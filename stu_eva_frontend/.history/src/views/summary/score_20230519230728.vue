<template>
  <el-card>
    <!-- <h2>个人学年总结</h2> -->
    <!-- <el-table :data="activities" border style="width: 100%">
  <el-table-column prop="time" label="时间" min-width="150">
    <template #default="{ row }">
      <el-date-picker
        v-model="row.time"
        type="date"
        placeholder="选择日期"
        v-bind:disabled="true"
      ></el-date-picker>
    </template>
  </el-table-column>
  <el-table-column prop="location" label="地点" min-width="150">
    <template #default="{ row }">
      <el-input
        v-model="row.location"
        placeholder="请输入地点"
        v-bind:readonly="true"
      ></el-input>
    </template>
  </el-table-column>
  <el-table-column prop="role" label="角色" min-width="100">
    <template #default="{ row }">
      <el-select
        v-model="row.role"
        placeholder="请选择角色"
        v-bind:disabled="true"
      >
        <el-option label="参与者" value="participant"></el-option>
        <el-option label="组织者" value="organizer"></el-option>
      </el-select>
    </template>
  </el-table-column>
  <el-table-column
    prop="activityName"
    label="活动名称"
    min-width="250"
  >
    <template #default="{ row }">
      <el-input
        v-model="row.activityName"
        placeholder="请输入活动名称"
        v-bind:readonly="true"
      ></el-input>
    </template>
  </el-table-column>
</el-table> -->

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

    <!-- <h2>学习态度</h2>
      <el-input
        type="textarea"
        :rows="2"
        :readonly="true"
        :value="studyAttitude"
      ></el-input>
  
      <h2>健康素质</h2>
      <el-input
        type="textarea"
        :rows="2"
        :readonly="true"
        :value="health"
      ></el-input> -->

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
    submitScore(data) {
      //const summaryValue = this.$refs.summaryInput.internalValue;
      submitYearlySummaryScore(this.score, data);

      // 提交评分的逻辑
      console.log("提交评分:", this.score);
      console.log("个人学年总结:", data);
      this.observer.$emit();
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
  