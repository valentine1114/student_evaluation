<template>
  <el-menu class="el-menu-demo" mode="horizontal" background-color="#334157" text-color="#fff" active-text-color="#fff">
    <el-button class="buttonimg">
      <img class="showimg" :src="collapsed ? imgsq : imgshow" @click="toggle(collapsed)">
    </el-button>
    <!-- <div class="submenu" v-if="user.name" @click="goToLogin">{{ user.name }}</div>
    <div class="submenu" v-else @click="goToLogin">请登录</div> -->
    <el-button v-if="user.name" class="submenu" @click="logout">{{ user.name }}</el-button>
    <el-button v-else class="submenu" @click="goToLogin">请登录</el-button>

  </el-menu>
</template>
<script>
  import axios from 'axios';
import { removeToken } from "@/utils/auth";
  import { getInfo } from "@/api/login";
  import store from '@/store';
export default {
  name: 'navcon',
  data() {
    return {
      user:{
        name:'',
        studentNumber: '',
      },
      collapsed: true,
      imgshow: require('../assets/img/show.png'),
      imgsq: require('../assets/img/sq.png')
    }
  },
  mounted(){
    getInfo().then((response) => {
      this.user.studentNumber = response.data.student_number;
      this.user.name = response.data.name;
      console.log(response.data.student_number);
      console.log(this.user.studentNumber);
      console.log(response.data);
    });
  },
  methods: {
    // 切换显示
    toggle(showtype) {
      this.collapsed = !showtype
    },
    goToLogin() {
      this.$router.push('/login');
    },
    logout() {
      this.$confirm("确定注销并退出系统吗？", "提示")
        .then(() => {
          store.commit('CLEAR_USER');
          removeToken();
          this.$router.push({ path: "/login" });
        })
        .catch(() => {});
    },
  }
}
</script>
<style scoped>
.el-menu-demo:not(.el-menu--collapse) {
  border: none;
  width: 100%;
}
.el-menu-demo .submenu {
  float: right;
}
.el-menu-demo .buttonimg {
  height: 60px;
  background-color: transparent;
  border: none;
}
.el-menu-demo .showimg {
  width: 26px;
  height: 26px;
  position: absolute;
  top: 17px;
  left: 17px;
}
.el-menu-demo .showimg:active {
  border: none;
}
</style>

