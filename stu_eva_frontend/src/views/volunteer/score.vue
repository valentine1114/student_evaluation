<template>
  <el-card>
    <div class="gpa-container" :data="dataList">
      <p prop="hours">
        学生当前的志愿时长为: <span class="gpa">{{ dataList[0].hours }}</span>
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
import { fetchStudentVolunteer, teacherGetStudentVolunteer } from "@/services/studentVolunteerService";
import { submitVolunteerSummaryScore } from "@/services/teacherVolunteerSummaryService";
import { fetchVolunteerScoresList } from "@/services/teacherListScoreService";
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
      reviewedVolunteer: "",
      score: "",
    };
  },
  methods: {
    async getDataList(msg) {
      console.log(msg);
      // this.allDataList = await fetchStudentVolunteer();
      // const fetchedData = await fetchStudentVolunteer();

      // console.log(this.allDataList);

      // this.dataList = this.allDataList.filter((item) => item.id === +msg);
      // this.dataList = fetchedData.filter((item) => item.id === +msg);
      this.dataList = await fetchStudentVolunteer(msg);
      console.log(this.dataList);
    },
    async submitScore(data) {
      //const summaryValue = this.$refs.summaryInput.internalValue;
      await submitVolunteerSummaryScore(this.score, data);

      // 提交评分的逻辑
      console.log("提交评分:", this.score);
      console.log("成绩评分:", data);
      this.$router.go({ path: "/Scoring/volunteerList" });
    },
    async getDataList(msg) {
      console.log(msg);
      this.dataList = await fetchStudentVolunteer(msg);
      // console.log(this.allDataList);

      // this.dataList = this.allDataList.filter((item) => item.student.id === +msg);

      console.log(this.dataList);
      console.log(this.dataList[0].hours);
    },
  },
  async mounted() {
    console.log("mounted");

    console.log(this.msg);
    this.allDataList = await teacherGetStudentVolunteer();
    console.log(this.allDataList);
    // console.log(this.allDataList[0].hours);
    // this.allDataList.forEach((item) => {
    //   console.log(item.id === +this.msg);
    //   if(item.id === +this.msg){
    //     this.dataList=item;
    //   }
    // });

    // // this.dataList = this.allDataList.filter((item) => item.student.id === +this.msg);

    // console.log(this.dataList);
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
