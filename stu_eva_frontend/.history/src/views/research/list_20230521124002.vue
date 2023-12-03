<template>
  <el-card>
    <h2>待评测人员查询</h2>
    <!-- 条件表格 -->
    <div style="margin-bottom: 20px">
      <el-min>
        <el-table
          :data="
            dataList.slice(
              (pageInfo.currentPage - 1) * pageInfo.pageSize,
              pageInfo.currentPage * pageInfo.pageSize
            )
          "
          border
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
            prop="number"
            label="学号"
            min-width="15%"
          ></el-table-column>
          <el-table-column
            prop="name"
            label="姓名"
            min-width="15%"
          ></el-table-column>

          <el-table-column
            prop="status"
            label="评测状态"
            align="center"
            min-width="15%"
          >
            <el-button type="warning" @click="checkStatus"
              >未通过评测</el-button
            >
          </el-table-column>

          <el-table-column label="操作" min-width="20%" align="center">
            <el-button type="primary" @click="startReview">评测</el-button>
          </el-table-column>
        </el-table>
      </el-min>
    </div>

    <el-dialog title="评测" :visible.sync="dialogVisible">
      <score></score>
    </el-dialog>

    <el-pagination background layout="prev, pager, next" :total="1000">
    </el-pagination>
  </el-card>
</template>

<script>
import score from "./score.vue";

export default {
  components: {
    score, // 声明 score 组件
  },
  data() {
    return {
      dialogVisible: false,
      dataList: [
        {
          id: "1",
          number: "2200022701",
          name: "zhangsan",
        },
        {
          id: "2",
          number: "2200022702",
          name: "zhangsan",
        },
        {
          id: "3",
          number: "2200022703",
          name: "zhangsan",
        },
        {
          id: "4",
          number: "2200022704",
          name: "zhangsan",
        },
        {
          id: "5",
          number: "2200022705",
          name: "zhangsan",
        },
      ],
    };
  },

  methods: {
    checkStatus() {},
    startReview() {
      this.dialogVisible = true;
    },
  },
};
</script>
<style>
h2 {
  text-align: center;
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
}
.pagination {
  text-align: center;
}
</style>