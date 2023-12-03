<!-- <template>
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
          placeholder="请输入用户名"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-col :span="12">
          <el-form-item prop="captcha">
            <el-input
              type="test"
              v-model="loginForm.captcha"
              auto-complete="off"
              placeholder="验证码"
              style="width: 100%"
            >
            </el-input>
          </el-form-item>
        </el-col>
        <el-col class="line" :span="1"> </el-col>
        <el-col :span="10">
          <el-form-item>
            <img
              style="width: 100%"
              class="pointer"
              src="http://localhost:8818/captcha"
              alt="Captcha"
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
          <el-button type="primary" @click="do_goback" :loading="loading"
            >返回</el-button
          >
        </el-form-item>
      </div>
    </el-form>
  </div>
</template> -->
  

<template>
  <div class="login-form">
    <h3 class="form-title">用户登录</h3>
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
          placeholder="请输入用户名"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-row>
          <el-col :span="12">
            <el-form-item prop="captcha">
              <el-input
                type="test"
                v-model="loginForm.captcha"
                auto-complete="off"
                placeholder="验证码"
                style="width: 100%"
              ></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item>
              <img
                class="captcha-image pointer"
                src="http://localhost:8818/captcha"
                alt="Captcha"
                @click="refreshCaptcha"
              />
            </el-form-item>
          </el-col>
        </el-row>
      </el-form-item>

      <el-form-item class="button-container">
        <el-button type="primary" @click="do_login" :loading="loading"
          >登录</el-button
        >
        <el-button type="primary" @click="do_goback" :loading="loading"
          >返回</el-button
        >
      </el-form-item>
    </el-form>
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
        //src: http://localhost:8818/captcha
      },
      rules: {
        studentId: [{ required: true, message: "请输入学号", trigger: "blur" }],
        captcha: [{ required: true, message: "请输入验证码", trigger: "blur" }],
      },
      loading: false,
    };
  },
  //   mounted: {
  //      this.loginForm.src="http://localhost:8818/captcha",
  // },
  methods: {
    do_login() {
      this.$refs.form.validate((valid) => {
        if (valid) {
          this.loading = true;
          login(this.loginForm.studentId, this.loginForm.captcha)
            .then((res) => {
              console.log(res);
              setToken(res.data.accessToken, response.data.refreshToken);
              this.$router.push({ path: "/" });
            })
            .catch((error) => {
              // 登录失败，显示错误提示
              console.log(error);
              this.$message.error("账号或验证码错误");
              this.loading = false;
            });
        }
      });
    },
    refreshCaptcha: function () {
      this.loginForm.src =
        this.global.baseUrl + "/captcha.jpg?t=" + new Date().getTime();
    },
    do_goback() {
      this.$router.push({ path: "/" });
    },
  },
};
</script>
<style scoped>
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

  
