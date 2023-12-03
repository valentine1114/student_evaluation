<template>
  <div>
    <div class="button-container">
      <input
        type="file"
        @change="importFromExcel"
        ref="fileInput"
        style="display: none"
      />
      <el-button type="info" plain @click="triggerFileInput">导入</el-button>
      <el-button type="primary" plain @click="exportToExcel">导出</el-button>
      <el-button type="success" plain @click="summarizeScores"
        >汇总成绩</el-button
      >
    </div>
    <el-table
      ref="multipleTable"
      :data="pagedData"
      tooltip-effect="dark"
      style="width: 100%; margin-top: 20px"
      @selection-change="handleSelectionChange"
      :page-size="20"
    >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column
        prop="student.id"
        label="ID"
        min-width="40"
      ></el-table-column>
      <el-table-column
        prop="student.student_number"
        label="学号"
        min-width="80"
      ></el-table-column>
      <el-table-column
        prop="student.name"
        label="姓名"
        min-width="60"
      ></el-table-column>
      <el-table-column
        prop="gpaScore"
        label="学生成绩得分"
        min-width="110"
      ></el-table-column>
      <el-table-column
        prop="volunteerScore"
        label="志愿服务得分"
        min-width="80"
      ></el-table-column>
      <el-table-column
        prop="researchScore"
        label="科研情况得分"
        min-width="110"
      ></el-table-column>
      <el-table-column
        prop="leadershipScore"
        label="学生骨干得分"
        min-width="110"
      ></el-table-column>
      <el-table-column
        prop="socialPracticeScore"
        label="社会实践得分"
        min-width="110"
      ></el-table-column>
      <el-table-column
        prop="summaryScore"
        label="个人总结得分"
        min-width="80"
      ></el-table-column>
      <el-table-column
        prop="totalScore"
        label="总成绩"
        min-width="80"
      ></el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[20, 50, 100]"
      :page-size="20"
      layout="total, sizes, prev, pager, next, jumper"
      :total="data.length"
    >
    </el-pagination>
  </div>
</template>
  
  <script>
import * as XLSX from "xlsx";
import axios from "axios";

export default {
  data() {
    return {
      currentPage: 1,
      data: [],
      pagedData: [],
      multipleSelection: [],
    };
  },
  created() {
    this.fetchData();
  },
  watch: {
    currentPage(newVal) {
      this.setPagedData(newVal);
    },
  },
  methods: {
    triggerFileInput() {
      this.$refs.fileInput.click();
    },
    fetchData() {
      axios
        .get("http://127.0.0.1:8818/api/yearlyGpaSummaryScores")
        .then((response) => {
          this.data = response.data;
          this.setPagedData(this.currentPage);
        })
        .catch((error) => {
          console.error("Failed to fetch data:", error);
        });
    },
    importFromExcel(event) {
      const file = event.target.files[0];
      const fileReader = new FileReader();

      fileReader.onload = (e) => {
        const data = e.target.result;
        const workbook = XLSX.read(data, { type: "binary" });

        const firstSheetName = workbook.SheetNames[0];
        const worksheet = workbook.Sheets[firstSheetName];

        let jsonData = XLSX.utils.sheet_to_json(worksheet, { raw: false });

        // Add this mapping object
        const fieldMap = {
          id: "id",
          姓名: "name",
          学号: "student_number",
          姓名拼音: "name_pinyin",
          性别: "gender",
          身份证号: "id_number",
          籍贯: "nation",
          民族: "ethnicity",
          生日: "dob",
          政治面貌: "political_status",
          学苑: "school",
          学生类型: "student_type",
          专业: "major",
          角色: "role_id",
          院系: "schoolOptions",

          // Other fields you need to map...
        };

        // Map fields from Chinese to English
        jsonData = jsonData.map((row) => {
          const newRow = {};
          Object.keys(row).forEach((chineseField) => {
            const englishField = fieldMap[chineseField];
            newRow[englishField] = row[chineseField];
          });
          return newRow;
        });

        this.data = jsonData;
        this.setPagedData(this.currentPage);
        this.$refs.fileInput.value = null;

        // 根据表头选择不同的接口路径
        if (jsonData.some((row) => row.volunteerHours !== undefined)) {
          // 表头包含 volunteerHours，调用 '/api/upload/volunteer' 接口
          this.uploadDataToBackend("/api/upload/volunteer", jsonData);
        }
        if (jsonData.some((row) => row.grade !== undefined)) {
          // 表头包含 grade，调用 '/api/upload/gpa' 接口
          this.uploadDataToBackend("/api/upload/gpa", jsonData);
        }
        if (jsonData.some((row) => row.name !== undefined)) {
          if (this.validateData(jsonData)) {
            // 表头包含 name，调用 '/api/upload/info' 接口
            this.uploadDataToBackend("/api/upload/info", jsonData).then(() =>
              this.fetchData()
            );
          } else {
            this.$message({
              message: "数据格式错误，请检查后重新上传",
              type: "error",
            });
          }
          // // 表头包含 grade，调用 '/api/upload/info' 接口
          // this.uploadDataToBackend('/api/upload/info', this.data).then(() => this.fetchData());
        }
      };

      fileReader.readAsBinaryString(file);
    },

    validateData(data) {
      const errors = [];
      const politicalStatusOptions = [
        "共产党员（含预备党员）",
        "共青团员",
        "群众",
        "其他",
      ];
      const studentTypeOptions = [
        "二学位",
        "专业硕士",
        "工程博士",
        "工学博士",
        "工程管理硕士",
      ];
      const schoolOptions = [
        "求知一苑",
        "求知二苑",
        "求知三苑",
        "燕南一苑",
        "燕南二苑",
        "燕南三苑",
        "未名一苑",
        "未名二苑",
        "未名三苑",
        "英杰一苑",
        "英杰二苑",
        "英杰三苑",
        "博雅一苑",
        "博雅二苑",
        "博雅三苑",
        "博实苑",
      ];

      data.forEach((row) => {
        if (!row.name || row.name.length > 100) {
          errors.push(`名字无效: ${row.name}`);
        }
        if (row.student_number && row.student_number.length > 20) {
          errors.push(`学号无效: ${row.student_number}`);
        }
        if (row.name_pinyin && row.name_pinyin.length > 100) {
          errors.push(`拼音名无效: ${row.name_pinyin}`);
        }
        if (row.gender && row.gender.length != 1) {
          errors.push(`性别无效: ${row.gender}`);
        }
        if (row.id_number && row.id_number.length != 18) {
          errors.push(`身份证号无效: ${row.id_number}`);
        }
        if (row.nation && row.nation.length > 100) {
          errors.push(`国籍无效: ${row.nation}`);
        }
        if (row.ethnicity && row.ethnicity.length > 50) {
          errors.push(`民族无效: ${row.ethnicity}`);
        }
        if (!Date.parse(row.dob)) {
          errors.push(`生日无效: ${row.dob}`);
        }
        if (
          row.political_status &&
          !politicalStatusOptions.includes(row.political_status)
        ) {
          errors.push(`政治面貌无效: ${row.political_status}`);
        }
        if (
          row.student_type &&
          !studentTypeOptions.includes(row.student_type)
        ) {
          errors.push(`学生类型无效: ${row.student_type}`);
        }
        if (row.major && row.major.length > 100) {
          errors.push(`专业无效: ${row.major}`);
        }
        if (row.school && !schoolOptions.includes(row.school)) {
          errors.push(`学校无效: ${row.school}`);
        }
      });
      if (errors.length > 0) {
        alert(`数据验证失败:\n${errors.join("\n")}`);
        return false;
      }
      return true;
    },

    uploadDataToBackend(url, data) {
      // 调用后端接口并发送数据
      return axios
        .post(`http://127.0.0.1:8818${url}`, data)
        .then((response) => {
          // 数据成功上传到后端
          console.log("Data uploaded successfully:", response);
        })
        .catch((error) => {
          // 发生错误
          console.error("Failed to upload data:", error);
        });
    },

    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.currentPage = val;
    },
    setPagedData(page) {
      const pageSize = 20;
      const start = (page - 1) * pageSize;
      const end = Math.min(page * pageSize, this.data.length);
      this.pagedData = this.data.slice(start, end);
    },
    exportToExcel() {
      const selectedData = this.multipleSelection;
      if (selectedData.length === 0) {
        alert("请至少选择一行数据");
        return;
      }
      if (selectedData.some((row) => row.totalScore === undefined)) {
        // 如果有未汇总的数据，显示消息并返回
        this.$message({
          message: "请先汇总成绩",
          type: "warning",
        });
        return;
      }
      // Create a new array with the student properties flattened
      const flattenedData = selectedData.map((row) => ({
        ID: row.student.id,
        学号: row.student.student_number,
        姓名: row.student.name,
        学生成绩得: row.gpaScore,
        志愿服务得分: row.volunteerScore,
        科研情况得分: row.researchScore,
        学生骨干得分: row.leadershipScore,
        社会实践得分: row.socialPracticeScore,
        个人总结得分: row.summaryScore,
        总分: row.totalScore,
      }));
      const ws = XLSX.utils.json_to_sheet(flattenedData);
      // const ws = XLSX.utils.json_to_sheet(selectedData);
      const wb = XLSX.utils.book_new();
      XLSX.utils.book_append_sheet(wb, ws, "Sheet1");

      const wbout = XLSX.write(wb, { bookType: "xlsx", type: "array" });
      const blob = new Blob([wbout], { type: "application/octet-stream" });
      const url = window.URL.createObjectURL(blob);

      const a = document.createElement("a");
      a.href = url;
      a.download = "2023年学生综合测评成绩.xlsx";
      a.click();
      window.URL.revokeObjectURL(url);
    },
    // summarizeScores() {
    //   this.multipleSelection.forEach((item) => {
    //     // eslint-disable-next-line no-param-reassign
    //     item.totalScore = item.socialP
    //     ractice + item.research+item.volunteerHours+item.grade+item.yearlySummary;
    //   });
    // },
    summarizeScores() {
      this.multipleSelection.forEach((student) => {
        // Calculate the summary score for a student
        const totalScore =
          student.gpaScore * 0.4 +
          student.volunteerScore * 0.1 +
          student.researchScore * 0.2 +
          student.leadershipScore * 0.15 +
          student.socialPracticeScore * 0.15;
        // Add the totalScore to the student data
        // Round the totalScore to 2 decimal places
        const roundedTotalScore = totalScore.toFixed(2);
        // Add the roundedTotalScore to the student data
        this.$set(student, "totalScore", roundedTotalScore);
      });
    },
  },
};
</script>
  
  <!-- Add this style in your project to include Element UI styles -->
  <style>
.button-container {
  display: flex;
  justify-content: flex-end;
  margin-bottom: 10px;
}

.el-table {
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);
  border-radius: 4px;
  overflow: hidden;
}

.el-table th {
  background-color: #f5f7fa;
  color: #606266;
  font-weight: bold;
}

.el-table .cell {
  padding: 12px 0;
  text-align: center;
}

.el-table th > div {
  text-align: center;
}
</style>