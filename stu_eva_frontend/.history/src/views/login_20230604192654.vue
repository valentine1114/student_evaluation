<template>
  <div class="login-form">
    <h3>用户登录</h3>
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
        <el-button type="primary" @click="do_login" :loading="loading"
          >登录</el-button
        >
        <el-button type="primary" @click="do_goback" :loading="loading"
          >返回</el-button
        >
      </el-form-item>
    </el-form>
    <img src="/captcha" alt="Captcha" />
    <input type="text" name="captchaText" placeholder="Enter captcha" />
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
      },
      rules: {
        studentId: [{ required: true, message: "请输入学号", trigger: "blur" }],
      },
      loading: false,
    };
  },
  methods: {
    do_login() {
      console.log();
      this.$refs.form.validate((valid) => {
        if (valid) {
          this.loading = true;
          console.log(this.loginForm.studentId);
          login(this.loginForm.studentId)
            .then((res) => {
              setToken(res.data.accessToken);
              this.$router.push({ path: "/" });
            })
            .catch(() => {
              // 登录失败，显示错误提示
              console.log();
              this.$message.error("学号错误");
              this.loading = false;
            });
        }
      });
    },
    do_goback() {
      this.$router.push({ path: "/" });
    },
  },
};
</script>
  