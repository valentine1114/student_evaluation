<template>
  <el-card>
    <div slot="header">
      <div style="display: inline">
        <el-button type="info" @click="resetDataList">清空</el-button>
        <el-button type="warning" @click="handleDataAdd">新增一行</el-button>
        <el-button type="success" @click="handleUpload"> 提交 </el-button>
      </div>
    </div>
    <div>
      <el-table :data="dataList" style="width: 100%" highlight-current-row>
        <el-table-column
          label="序号"
          min-width="10%"
          type="index"
        ></el-table-column>

        <el-table-column label="主题" min-width="15%">
          <template slot-scope="scope">
            <el-input
              placeholder="请输入主题"
              v-model="scope.row.ActivityTheme"
            ></el-input>
          </template>
        </el-table-column>

        <el-table-column label="主办方" min-width="15%">
          <template slot-scope="scope">
            <el-input
              placeholder="请输入主办方"
              v-model="scope.row.Organizer"
            ></el-input>
          </template>
        </el-table-column>

        <el-table-column label="职位" min-width="15%">
          <template slot-scope="scope">
            <el-input
              placeholder="请输入职位"
              v-model="scope.row.Position"
            ></el-input>
          </template>
        </el-table-column>

        <el-table-column label="起始时间" min-width="15%">
          <template slot-scope="scope">
            <el-date-picker
              v-model="scope.row.StartTime"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="选择起始时间"
            >
            </el-date-picker>
          </template>
        </el-table-column>

        <el-table-column label="结束时间" min-width="15%">
          <template slot-scope="scope">
            <el-date-picker
              v-model="scope.row.EndTime"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="选择结束时间"
            >
            </el-date-picker>
          </template>
        </el-table-column>

        <el-table-column label="操作" min-width="15%">
          <template slot-scope="scope">
            <el-button
              type="danger"
              @click="handleDataDelete(scope.$index, scope.row)"
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </div>
  </el-card>
</template>
  
  <script>
import axios from "axios";
import { getInfo } from "@/api/login";
// import moment from 'moment';
export default {
  data() {
    return {
      user: {
        studentNumber: "",
      },
      //数据列表
      dataList: [
        {},
        // 这里添加了三个空对象，对应三行表格
      ],
    };
  },
  mounted() {
    getInfo().then((response) => {
      this.user.studentID = response.data.id;
      console.log(response.data);
      console.log(this.user.studentID);
    });
  },

  methods: {
    handleUpload() {
      this.submitData();
    },
    async submitData() {
      try {
        for (let data of this.dataList) {
          let startTime = moment(data.StartTime, "YYYY-MM-DD HH:mm:ss");
          let endTime = moment(data.EndTime, "YYYY-MM-DD HH:mm:ss");
          await axios.post(
            "http://127.0.0.1:8818/api/socialPractice/saveData",
            {
              activityTheme: data.ActivityTheme,
              organizer: data.Organizer,
              position: data.Position,
              time: moment(data.StartTime, "YYYY-MM-DD HH:mm:ss").toISOString(),
              duration: Math.abs(endTime.diff(startTime, "months")),
              // You also need to include the student ID in the post request
              student: {
                id: this.user.studentID,
              },
            }
          );
        }
        this.$message.success("Data submitted successfully");
      } catch (error) {
        this.$message.error("Error submitting data");
        console.error(error);
      }
    },
    handleDateSelection(date) {
      this.value1 = date;
    },
    handleClick(tab, event) {
      console.log(tab, event);
    },

    //清空条件列表
    resetDataList() {
      this.dataList = [
        {
          活动名称: "",
          活动选项: "",
          值: "",
          isDict: false,
          isDate: false,
          conditionOptions: [],
          valueOptions: [],
        },
      ];
      this.sortName = "";
      this.sortValue = "";
    },
    handleDataSave() {},
    //删除一行
    handleDataDelete(index, row) {
      this.dataList.splice(index, 1);
    },
    //插入一行
    handleDataAdd() {
      this.dataList.push({
        ActivityTheme: "",
        Organizer: "",
        Position: "",
        StartTime: "",
        EndTime: "",
      });
    },
    submitUpload() {
      this.$refs.upload.submit();
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
  },
};
</script>