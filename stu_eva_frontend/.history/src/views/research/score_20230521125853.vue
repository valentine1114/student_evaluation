<template>
  <el-card>
    <!-- 条件表格 -->
    <h2>科研情况</h2>
    <div class="summary-container" :data="dataList">
      <div>
        <el-table
          :data="dataList"
          border
          show-summary
          style="width: 100%"
          highlight-current-row
        >
          <el-table-column
            prop="id"
            label="序号"
            min-width="10%"
            type="index"
          ></el-table-column>

          <el-table-column
            prop="activity"
            label="学术类别"
            min-width="10%"
          ></el-table-column>
          <el-table-column
            prop="rating"
            label="具体分类"
            min-width="20%"
          ></el-table-column>
          <el-table-column
            prop="explanation"
            label="详细内容"
            min-width="20%"
          ></el-table-column>

          <el-table-column
            prop="value"
            sortable
            label="分值"
            align="center"
            min-width="10%"
          >
            <template slot-scope="scope">
              <span v-if="scope.row.editable">
                <el-input
                  v-model="scope.row.score"
                  size="mini"
                  @blur="saveEdit(scope.row)"
                ></el-input>
              </span>
              <span v-else>{{ scope.row.score }}</span>
            </template>
          </el-table-column>

          <el-table-column label="修改意见" min-width="20%">
            <template slot-scope="scope">
              <el-input
                placeholder="请输入内容"
                v-model="scope.row.opinion"
              ></el-input>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <el-footer>
        <div class="submit-button">
          <el-button type="primary" @click="submitScore(dataList[0])"
            >提交</el-button
          >
        </div>
      </el-footer>
    </div>
  </el-card>
</template>
<script>
// import viewerApi from "viewerjs";
// import "viewerjs/dist/viewer.css"; // 引入Viewer.js的CSS文件
// import Vue from "vue";

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

      textarea: "",

      score: "",
    };
  },
  computed: {},

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
<style>
.el-footer {
  color: #333;
  line-height: 80px;
}
</style>