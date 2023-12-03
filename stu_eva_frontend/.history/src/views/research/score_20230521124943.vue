<template>
  <el-card>
    <!-- 条件表格 -->
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

        <el-table-column
          prop="material"
          label="预览材料"
          align="center"
          class-name="small-padding fixed-width"
          min-width="15%"
        >
          <el-button type="primary" @click="showImgViewer">预览材料</el-button>
          <el-image-viewer
            v-if="imgViewerVisible"
            :on-close="closeImgViewer"
            :url-list="getMaterialUrls"
          />
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
      imgViewerVisible: false,
      textarea: "",
    };
  },
  computed: {
    getMaterialUrls() {
      return this.dataList.map((item) => item.material);
    },
  },
  components: {
    "el-image-viewer": () =>
      import("element-ui/packages/image/src/image-viewer"),
  },
  methods: {
    handleDataSave() {},
    handleDataReject() {},

    submitUpload() {
      this.$refs.upload.submit();
    },
    showImgViewer() {
      this.imgViewerVisible = true;
      const m = (e) => {
        e.preventDefault();
      };
      document.body.style.overflow = "hidden";
      document.addEventListener("touchmove", m, false); // 禁止页面滑动
    },

    closeImgViewer() {
      this.imgViewerVisible = false;
      const m = (e) => {
        e.preventDefault();
      };
      document.body.style.overflow = "auto";
      document.removeEventListener("touchmove", m, true);
    },
    saveEdit(row) {
      // 在这里处理编辑保存的逻辑
      console.log("保存编辑结果:", row);
      // row.editable = false; // 将编辑状态设置为不可编辑
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