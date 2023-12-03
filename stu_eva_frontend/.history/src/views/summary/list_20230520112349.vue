<template>
  <el-card>
    <el-header>待评测人员查询</el-header>
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
            :index="indexMethod"
          ></el-table-column>

          <el-table-column
            prop="studentNumber"
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
            <el-button type="warning" @click="checkStatus">未评测</el-button>
          </el-table-column>

          <el-table-column label="操作" min-width="20%" align="center">
            <template slot-scope="{ $index }">
              <el-button type="primary" @click="startReview($index)">{{
                getStatusText($index)
              }}</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-min>
    </div>

    <el-dialog title="评测" :visible.sync="dialogVisible">
      <score :msg="massage"></score>
    </el-dialog>

    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pageInfo.currentPage"
      :page-sizes="[2, 5, 10, 20]"
      :page-size="pageInfo.pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pageInfo.pageTotal"
    ></el-pagination>
  </el-card>
</template>

<script>
import score from "./score.vue";
import { fetchStudentList } from "@/services/studentListService";
import { teacherGetStudentScores } from "@/services/studentScoreService";
import { fetchStudentScoresList } from "@/services/teacherListScoreService";

export default {
  components: {
    score, // 声明 score 组件
  },
  data() {
    return {
      pageInfo: {
        currentPage: 1,
        pageSize: 5,
        pageTotal: 20,
      },
      dialogVisible: false,
      dataList: [],
      massage: null,
      checkStatus: "未评测",
    };
  },

  methods: {
    checkStatus() {},
    startReview(index) {
      this.dialogVisible = true;
      console.log(this.index);
      this.massage = this.indexMethod(index);
      console.log(this.massage);
      // this.massage = this.dataList[index].id;
      console.log(this.dataList[index]);
      console.log(this.msg);
      console.log(this.massage);
    },
    handleSizeChange(val) {
      this.pageInfo.pageSize = val;
    },
    handleCurrentChange(val) {
      this.pageInfo.currentPage = val;
    },
    // 配置显示序号
    indexMethod(index) {
      return (
        (this.pageInfo.currentPage - 1) * this.pageInfo.pageSize + index + 1
      );
    },
  },
  created() {
    console.log("created");
    fetchStudentScoresList().then((response) => {
      console.log(response);
    });
  },
  computed: {
    getStatusText() {
      return function (index) {
        const list = fetchStudentScoresList();

        console.log(this.response);
        const item_id = this.indexMethod(index);
        const item = list.filter((item) => item.id === +item_id);
        console.log(item_id);
        console.log(item);
        console.log(item[0].summaryScore);
        console.log(item[0].summaryScore != null);
        if (item[0].summaryScore != null) {
          console.log(item[0].summaryScore);
          return "已评测";
        }
        return "未评测";
      };
    },
  },
  async mounted() {
    console.log("mounted");
    this.dataList = await fetchStudentList();
    this.pageInfo.pageTotal = this.dataList.length;

    console.log(data);
  },
};
</script>