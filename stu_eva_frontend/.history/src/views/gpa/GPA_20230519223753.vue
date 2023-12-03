<template>
  <div class="container">
    <h2>学生成绩确认</h2>
    <div class="gpa-container">
      <p>
        您当前的 GPA 为: <span class="gpa">{{ gpa }}</span>
      </p>
    </div>
    <div class="button-container">
      <el-button type="primary" @click="confirm">确认</el-button>
      <el-button type="warning" @click="openRecheckDialog">成绩复核</el-button>
    </div>

    <el-dialog
      title="提交证明文件"
      :visible.sync="recheckDialogVisible"
      width="50%"
      :before-close="handleClose"
    >
      <el-form label-position="top" label-width="120px">
        <el-form-item label="复核 GPA">
          <el-input
            v-model="recheckGpa"
            placeholder="请输入复核 GPA"
          ></el-input>
        </el-form-item>
      </el-form>

      <el-upload
        class="upload-demo"
        action="https://jsonplaceholder.typicode.com/posts/"
        :on-success="handleUploadSuccess"
        :on-error="handleUploadError"
      >
        <el-button slot="trigger" size="small" type="primary"
          >选取文件</el-button
        >
        <el-button size="small" type="success" @click="submitRecheck"
          >提交复核申请</el-button
        >
      </el-upload>
    </el-dialog>
  </div>
</template>

<script>
import { fetchStudentScores } from "@/services/studentScoreService";
import { getInfo } from "@/api/login";
export default {
  mounted() {
    getInfo().then((response) => {
      const id = response.data.studentNumber;

      console.log(response.data.studentNumber);
      console.log(id);
      fetchStudentScores(id).then((response) => {
        console.log(id);
        this.gpa = response.data.gpa;
        console.log(response.data.gpa);
      });
    });
  },
  data() {
    return {
      gpa: " ",
      recheckDialogVisible: false,
    };
  },
  methods: {
    confirm() {
      this.$message({
        message: "成绩已确认",
        type: "success",
      });
    },
    openRecheckDialog() {
      this.recheckDialogVisible = true;
    },
    handleClose(done) {
      done();
    },
    submitRecheck() {
      this.$message({
        message: "复核申请已提交",
        type: "success",
      });
      this.recheckDialogVisible = false;
    },
    handleUploadSuccess(response, file, fileList) {
      this.$message({
        message: "文件上传成功",
        type: "success",
      });
    },
    handleUploadError(err, file, fileList) {
      this.$message({
        message: "文件上传失败",
        type: "error",
      });
    },
  },
};
</script>

<style scoped>
.container {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);
  background-color: #fff;
  border-radius: 8px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
}

h2 {
  text-align: center;
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
}

.gpa-container {
  text-align: center;
  font-size: 18px;
  margin-bottom: 20px;
}

.gpa {
  font-size: 24px;
  font-weight: bold;
  color: #f56c6c;
}

.button-container {
  display: flex;
  justify-content: center;
  gap: 20px;
  margin-bottom: 20px;
}
</style>
