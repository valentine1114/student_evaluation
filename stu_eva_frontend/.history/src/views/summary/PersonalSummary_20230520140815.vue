<template>
  <el-card>
    <h2>个人学年总结</h2>

    <div>
      <el-form>
        <el-form-item>
          <el-input
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
  </el-card>
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
    submit(behaviorNorms) {
      // 提交处理逻辑
      getInfo().then((response) => {
        const id = response.data.studentNumber;
        console.log(response.data.studentNumber);
        console.log(id);
        submitYearlySummary(behaviorNorms, id);
      });
    },
  },
};
</script>
  
  <style>
.submit-btn {
  text-align: center;
  margin-top: 20px;
}
</style>
  