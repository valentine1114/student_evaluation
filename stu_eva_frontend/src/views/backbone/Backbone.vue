<template>
  <el-card>
    <div slot="header">
      <div style="display: inline">
        <el-button type="info" @click="resetDataList">清空</el-button>
        <el-button type="warning" @click="handleDataAdd">新增一行</el-button>
        <!-- <el-button type="primary" @click="handleDataSave"> 保存 </el-button> -->
        <el-button type="success" @click="handleUpload"> 提交 </el-button>
      </div>
    </div>

    <!--  条件表格 -->
    <div>
      <el-table :data="dataList" style="width: 100%" highlight-current-row>
        <el-table-column
          label="序号"
          min-width="10%"
          type="index"
        ></el-table-column>
        <el-table-column label="时间" min-width="20%">
          <template slot-scope="scope">
            <div class="block">
              <span class="demonstration"></span>
              <el-date-picker
                v-model="scope.row.startTime"
                type="date"
                placeholder="选择日期"
                pro
              >
              </el-date-picker>
            </div>
          </template>
        </el-table-column>
        <el-table-column label="部门" min-width="25%">
          <template slot-scope="scope">
            <el-input
              placeholder="请输入内容"
              v-model="scope.row.department"
            ></el-input>
          </template>
        </el-table-column>
        <el-table-column label="职位" min-width="25%">
          <template slot-scope="scope">
            <el-input
              placeholder="请输入内容"
              v-model="scope.row.position"
            ></el-input>
          </template>
        </el-table-column>

        <el-table-column label="操作" min-width="10%">
          <template slot-scope="scope">
            <el-button
              type="danger"
              @click="handleDataDelete(scope.$index, scope.row)"
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </div>
  </el-card>
</template>

<script>
import { studentSubmitStudentLeadership } from "@/services/studentLeadershipService";
import { getInfo } from "@/api/login";
export default {
  data() {
    return {

      //数据列表
      dataList: [
        { startTime: "", department: "", position: "", student: { id: "" } },
        // 这里添加了三个空对象，对应三行表格
      ],
      list: [],
    };
  },
  methods: {
    //清空条件列表
    resetDataList() {
      this.dataList = [
        {
          startTime: "",
          department: "",
          position: "",
          student: { id: "" },
        },
      ];
    },
    handleDataSave() {},
    //删除一行
    handleDataDelete(index, row) {
      this.dataList.splice(index, 1);
    },
    //插入一行
    handleDataAdd() {
      if (this.dataList == undefined) {
        this.dataList = [];
      }
      let obj = {};

      this.dataList.push(obj);
    },
    // handleDataSave() {
    //   this.handleUpload();
    // },
    async handleUpload() {
      // 提交处理逻辑
      await getInfo().then((response) => {
        console.log(response.data);
        // const id = response.data.id;
        // console.log(response.data.id);
        // console.log(id);
        console.log(this.dataList);
        const list = this.dataList.filter((item) => item.type !== "");
        console.log(list);
        studentSubmitStudentLeadership(list, response.data);
        this.resetDataList();
      });
    },
  },
};
</script>
<style scoped>
.submit-button {
  margin-top: 20px;
  text-align: center;
}
</style>
  