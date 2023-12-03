<template>
  <div class="container">
    <h2>个人学年总结</h2>

    <div>
      <el-form>
        <el-form-item>
          <el-input
            ref="behaviorNorms"
            type="textarea"
            :rows="4"
            maxlength="400"
            show-word-limit
            v-model="behaviorNorms"
          ></el-input>
        </el-form-item>
      </el-form>
    </div>

    <div class="submit-btn">
      <el-button type="primary" @click="submit(behaviorNorms)">提交</el-button>
    </div>
  </div>
</template>
  
  <script>
import { submitYearlySummary } from "@/services/studentYearlySummaryService";
import { getInfo } from "@/api/login";
export default {
  data() {
    return {
      behaviorNorms: "",
    };
  },
  methods: {
    async submit(behaviorNorms) {
      // 提交处理逻辑
      await getInfo().then((response) => {
        console.log(response);
        const id = response.data.id;
        console.log(response.data.id);
        console.log(id);
        submitYearlySummary(behaviorNorms, id);
      });
      this.$refs.behaviorNorms.clear();
    },
  },
};
</script>
  
  <style>
.submit-btn {
  text-align: center;
  margin-top: 20px;
}
h2 {
  text-align: center;
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
}
.container {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);
  background-color: #fff;
  border-radius: 8px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
}
</style>
  