<template>
  <div class="home">
    <h1>{{user.name}}，欢迎来到学生综测系统</h1>
    <!-- <p>欢迎来到首页</p>   -->
  </div>
</template>

<script>
import { getInfo } from "@/api/login";

export default {
  name: "HomeView",
  data() {
    return {
      user: {
        name: "",
      },
    };
  },
  mounted() {
    getInfo().then((response) => {
      this.user.studentNumber = response.data.student_number;
      this.user.name = response.data.name;
      console.log(response.data.student_number);
      console.log(this.user.studentNumber);
      console.log(response.data);
    });
  },

};

</script>
