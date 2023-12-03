<template>
  <div class="container">
    <!-- <h2>学生成绩确认</h2> -->

    <div class="gpa-container" :data="dataList">
      <!-- <div class="steps-container">
        <el-steps :space="200" :active="1" finish-status="success">
          <el-step title="学生确认成绩"></el-step>
          <el-step title="成绩复核"></el-step>
          <el-step title="确认成绩"></el-step>
        </el-steps>
      </div> -->
      <p prop="gpa">
        学生当前的 GPA 为: <span class="gpa">{{ dataList[0].gpa }}</span>
      </p>
    </div>
    <div>
      <h2>打分</h2>
      <el-input
        v-model="score"
        placeholder="请输入分数"
        maxlength="3"
        show-word-limit
      ></el-input>
    </div>

    <!-- <div v-if="recheckRequest" class="recheck-container">
      <h3>复核申请</h3>

      <el-form label-position="top" class="ttable" label-width="120px" border >
        <el-form-item label="复核GPA"> {{ recheckGpa }} </el-form-item>
        <el-form-item label="提交的文件">
          <a :href="submittedFileUrl" target="_blank">查看文件</a>
        </el-form-item>
        <el-form-item label="复核后的 GPA">
          <el-input
            v-model="reviewedGpa"
            placeholder="请输入复核后的 GPA"
          ></el-input>
        </el-form-item>
      </el-form>
    </div> -->

    <div class="button-container">
      <el-button type="primary" @click="submitScore(dataList[0])">
        确认
      </el-button>
    </div>
  </div>
</template>


<script>
import { fetchStudentScores } from "@/services/studentScoreService";
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
      reviewedGpa: "",
    };
  },
  methods: {
    confirm() {},
    async getDataList(msg) {
      console.log(msg);
      this.allDataList = await fetchStudentScores();
      console.log(this.allDataList);

      this.dataList = this.allDataList.filter((item) => item.id === +msg);

      console.log(this.dataList);
    },
  },
  async mounted() {
    console.log("mounted");

    console.log(this.msg);
    this.allDataList = await fetchStudentScores();
    console.log(this.allDataList);

    this.allDataList.forEach((item) => {
      console.log(item.id === +this.msg);
    });

    this.dataList = this.allDataList.filter((item) => item.id === +this.msg);

    console.log(this.dataList);
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
  margin-bottom: 20px;
  text-align: center;
}

.gpa {
  font-weight: bold;
  color: #0084ff;
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
  margin-bottom: 20px;
}
.steps-container {
  width: 100%;
}
</style>
