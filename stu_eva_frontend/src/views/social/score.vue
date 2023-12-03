<template>
  <el-card>
    <h2>社会实践</h2>
  <el-table :data="dataList" style="width: 100%">
    <el-table-column prop="time" :formatter="row => formatDate(row.time)" label="开始时间"></el-table-column>
    <el-table-column prop="activityTheme" label="主题"></el-table-column>
    <el-table-column prop="organizer" label="主办方"></el-table-column>
    <el-table-column prop="position" label="职位"></el-table-column>
    <el-table-column prop="duration" label="持续时间"></el-table-column>
  </el-table>
    <h2>打分</h2>
    <el-input
      v-model="score"
      placeholder="请输入分数"
      maxlength="3"
      show-word-limit
    ></el-input>
    <div class="submit-button">
      <el-button type="primary" @click="submitScore(msg)">
        确认
      </el-button>
    </div>
  </el-card>
</template>

<script>
import { fetchStudentSocial, teacherGetStudentSocial } from "@/services/studentSocialService";
import { submitYearlySummaryScore } from "@/services/teacherYearlySummaryService";
import { submitSocialScore } from "@/services/teacherListSocialService";

export default {

  props: ["msg"],
  watch: {
    msg(newVal) {
      this.getDataFromMsg(newVal);
    },
  },
  data() {
    return {
      dataList: [],
      score: "",
      allDataList: [],
    };
  },
  methods: {
    // other methods...
    formatDate(timestamp) {
    let date = new Date(timestamp);
    return date.toLocaleDateString("zh-CN");
  },
    async getDataFromMsg(msg) {
      console.log(msg);
      this.dataList = this.allDataList.filter((item) => item.student.id === +msg);
      console.log(this.dataList);
    },
    async submitScore(msg) {
      //const summaryValue = this.$refs.summaryInput.internalValue;
      await submitSocialScore(this.score, msg);

      // 提交评分的逻辑
      console.log("提交评分:", this.score);
      console.log("成绩评分:", msg);
      // this.$router.go({ path: "/Scoring/socialPracticeList" });
    },
  },
  async created() {
    console.log("created");

    console.log(this.msg);
    this.allDataList = await teacherGetStudentSocial();
    console.log(this.allDataList);
    console.log(this.allDataList[0].student.id);

    this.getDataFromMsg(this.msg);
  },
};
</script>
<style>
.el-footer {
  color: #333;
  line-height: 80px;
}
</style>