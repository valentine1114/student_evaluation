<template>
  <el-card>
    <div class="gpa-container" :data="dataList">
      <p prop="gpa">
        学生当前的 GPA 为: <span class="gpa">{{ dataList[0].gpa }}</span>
      </p>
    </div>
    <h2>打分</h2>

    <el-input
      v-model="score"
      placeholder="请输入分数"
      maxlength="3"
      show-word-limit
    ></el-input>

    <div class="button-container">
      <el-button type="primary" @click="submitScore(dataList[0])">
        确认
      </el-button>
    </div>
  </el-card>
</template>


<script>
import { teacherGetStudentScores } from "@/services/studentScoreService";
import { submitGpaSummaryScore } from "@/services/teacherGpaSummaryService";
import router from "@/router";
export default {
  props: ["msg"],
  watch: {
    msg(newVal) {
      this.getDataList(newVal);
    },
  },
  data() {
    return {
      dataList: [],
      isConfirmed: true,
      recheckRequest: true,
      recheckGpa: 3.9,
      submittedFileUrl: "https://example.com/file.pdf",
      reviewedGpa: "",
      score: "",
    };
  },
  methods: {
    async getDataList(msg) {
      console.log(msg);
      this.allDataList = await fetchStudentScores();
      console.log(this.allDataList);

      this.dataList = this.allDataList.filter((item) => item.id === +msg);

      console.log(this.dataList);
    },
    async submitScore(data) {
      //const summaryValue = this.$refs.summaryInput.internalValue;
      await submitGpaSummaryScore(this.score, data);

      // 提交评分的逻辑
      console.log("提交评分:", this.score);
      console.log("成绩评分:", data);
      this.$router.go({ path: "/Scoring/gpaList" });
    },
    async getDataList(msg) {
      console.log(msg);
      this.allDataList = await fetchYearlySummary();
      console.log(this.allDataList);

      this.dataList = this.allDataList.filter((item) => item.id === +msg);

      console.log(this.dataList);
    },
  },
  async mounted() {
    console.log("mounted");

    console.log(this.msg);
    this.allDataList = await teacherGetStudentScores();
    console.log(this.allDataList);

    this.allDataList.forEach((item) => {
      console.log(item.id === +this.msg);
    });

    this.dataList = this.allDataList.filter((item) => item.id === +this.msg);

    console.log(this.dataList);
  },
};
</script>

<style scoped>
.container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  background-color: #f7f7f7;
  border-radius: 6px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

h2 {
  text-align: center;
  margin-bottom: 30px;
  font-weight: bold;
}

.gpa-container {
  text-align: center;
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
}

.gpa {
  font-size: 24px;
  font-weight: bold;
  color: #f56c6c;
}

.recheck-container {
  background-color: #ffffff;
  padding: 20px;
  border-radius: 6px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  margin-bottom: 30px;
}

.button-container {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}
.steps-container {
  width: 100%;
}
</style>
