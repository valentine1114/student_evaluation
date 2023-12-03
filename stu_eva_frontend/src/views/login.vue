<template>
  <div class="login-container">
    <div class="login-form">
      <h2>用户登录</h2>
      <el-form
        ref="form"
        :model="loginForm"
        :rules="rules"
        label-position="left"
        label-width="0"
      >
        <el-form-item prop="studentID">
          <el-input
            v-model="loginForm.studentId"
            placeholder="请输入学号或工号"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-col :span="12">
            <el-form-item prop="captcha">
              <el-input
                type="test"
                v-model="loginForm.captcha"
                auto-complete="off"
                placeholder="验证码, 单击图片刷新"
                style="width: 100%"
              >
              </el-input>
            </el-form-item>
          </el-col>
          <el-col class="line" :span="1">&nbsp;</el-col>
          <el-col :span="11">
            <el-form-item>
              <img
                style="width: 100%"
                class="pointer"
                :src="loginForm.src"
                @click="refreshCaptcha"
              />
            </el-form-item>
          </el-col>
        </el-form-item>
        <div class="button-container">
          <el-form-item>
            <el-button type="primary" @click="do_login" :loading="loading"
              >登录</el-button
            >
          </el-form-item>
        </div>
      </el-form>
    </div>
  </div>
</template>
  
  <script>
import axios from "axios";
import { login } from "@/api/login.js";
import { setToken } from "@/utils/auth";

export default {
  data() {
    return {
      loginForm: {
        studentId: "",
        captcha: "",
        src: "",
      },
      rules: {
        studentId: [
          { required: true, message: "请输入学号或工号", trigger: "blur" },
        ],
        captcha: [{ required: true, message: "请输入验证码", trigger: "blur" }],
      },
      loading: false,
    };
  },
  created() {
    this.loginForm.src = axios.defaults.baseURL + "/captcha"; // 假设响应中的data属性包含验证码图片的URL
  },
  methods: {
    do_login() {
      console.log(this.loginForm.captcha);
      this.$refs.form.validate((valid) => {
        if (valid) {
          this.loading = true;
          console.log(this.loginForm.studentId, this.loginForm.captcha);
          login(this.loginForm.studentId, this.loginForm.captcha).then(
            (res) => {
              console.log(res);
              if (res.code === 200) {
                console.log(res.data);
                setToken(res.data.accessToken, res.data.refreshToken);
                this.$router.push({ path: "/" });
              } else {
                this.loading = false;
                this.$message({
                  message: res.msg,
                  type: "error",
                });
              }
            }
          );
        }
      });
    },
    refreshCaptcha: function () {
      this.loginForm.src =
        axios.defaults.baseURL + "/captcha?t=" + new Date().getTime();
    },
  },
};
</script>
<style scoped>
.login-container {
  height: 100vh;
  /*弹性布局居中*/
  display: flex;
  justify-content: center;
  align-items: center;
  /*渐变背景*/
  background: linear-gradient(200deg, #a80303, #f8f8f8);
  /*溢出影藏*/
  overflow: hidden;
}
.login-form {
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
.button-container {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}
</style>

  