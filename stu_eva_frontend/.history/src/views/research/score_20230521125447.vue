<template>
  <el-card>
    <!-- 条件表格 -->
    <h2>学术研究</h2>
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
                v-model="scope.row.value"
                size="mini"
                @blur="saveEdit(scope.row)"
              ></el-input>
            </span>
            <span v-else>{{ scope.row.value }}</span>
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
      <div style="display: inline">
        <el-button type="success" @click="submitUpload">提交</el-button>
      </div>
    </el-footer>
  </el-card>
</template>
<script>
// import viewerApi from "viewerjs";
// import "viewerjs/dist/viewer.css"; // 引入Viewer.js的CSS文件
// import Vue from "vue";

export default {
  data() {
    return {
      dataList: [],

      textarea: "",
    };
  },
  computed: {},

  methods: {
    submitUpload() {
      this.$refs.upload.submit();
    },
  },
};
</script>
<style>
.el-footer {
  color: #333;
  line-height: 80px;
}
</style>