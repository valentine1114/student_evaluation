<template>
  <div class="container">
    <h2>学生志愿时长确认</h2>
    <div class="gpa-container">
      <p>
        您当前的志愿时长为: <span class="volunteer">{{ volunteer }}</span>
      </p>
    </div>
    <el-alert
      title="志愿时长如有问题，请发送邮件至xuegong@pku.edu.cn"
      type="warning"
      effect="dark"
      class="notice"
    >
    </el-alert>
  </div>
</template>

<script>
import { fetchStudentVolunteer } from "@/services/studentVolunteerService";
import { getInfo } from "@/api/login";
export default {
  data() {
    return {
      volunteer: "",
      recheckDialogVisible: false,
    };
  },
  created() {
    getInfo().then((response) => {
      console.log(response);
      const id = response.data.id;

      console.log(response.data.id);
      console.log(id);
      fetchStudentVolunteer(id).then((response) => {
        console.log(id);
        console.log(response);
        this.volunteer = response[0].hours;
        console.log(response[0].hours);
      });
    });
  },

  methods: {},
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

.volunteer {
  font-size: 24px;
  font-weight: bold;
  color: #f56c6c;
}

.notice {
  display: flex;
  justify-content: center;
}
</style>
