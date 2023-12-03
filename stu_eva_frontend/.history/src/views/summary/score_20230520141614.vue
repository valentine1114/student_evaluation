<template>
  <el-card>
    <h2>个人学年总结</h2>
    <div class="summary-container" :data="dataList">
      <el-input
        ref="summaryInput"
        v-model="dataList[0].summary"
        type="textarea"
        :rows="2"
        :readonly="true"
        value=""
      ></el-input>
    </div>

    <h2>打分</h2>
    <el-input
      v-model="score"
      placeholder="请输入分数"
      maxlength="3"
      show-word-limit
    ></el-input>

    <div class="submit-button">
      <el-button type="primary" @click="submitScore(dataList[0])"
        >提交</el-button
      >
    </div>
  </el-card>
</template>
  
  <script>
import { fetchYearlySummary } from "@/services/studentYearlySummaryService";
import { submitYearlySummaryScore } from "@/services/teacherYearlySummaryService";

export default {
  props: ["msg"],
  watch: {
    msg(newVal) {
      this.getDataList(newVal);
    },
  },
  data() {
    return {
      // activities: [
      //   // 从个人年度总结页面获取活动数据
      //   {
      //     time: new Date("2022-04-01"),
      //     location: "北京大学",
      //     role: "organizer",
      //     activityName: "纪念五四运动100周年大会",
      //   },
      // ],
      dataList: [],

      score: "",
    };
  },
  methods: {
    async submitScore(data) {
      //const summaryValue = this.$refs.summaryInput.internalValue;
      await submitYearlySummaryScore(this.score, data);

      // 提交评分的逻辑
      console.log("提交评分:", this.score);
      console.log("个人学年总结:", data);
      this.$router.go({ path: "/Scoring/personalSummaryList" });
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
    this.allDataList = await fetchYearlySummary();
    console.log(this.allDataList);

    this.dataList = this.allDataList.filter((item) => item.id === +this.msg);

    console.log(this.dataList);
    console.log(this.dataList[0].summary);
  },
};
</script>
  
  <style scoped>
.submit-button {
  margin-top: 20px;
  text-align: center;
}
</style>
  