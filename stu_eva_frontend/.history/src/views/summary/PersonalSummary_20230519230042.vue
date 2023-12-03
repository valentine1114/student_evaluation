<template>
  <el-card>
    <h2>个人学年总结</h2>
    <!-- <el-table :data="activities" border style="width: 100%">
      <el-table-column
        prop="time"
        label="时间"
        min-width="150"
        :editable="true"
      >
        <template #default="{ row }">
          <el-date-picker
            v-model="row.time"
            type="date"
            placeholder="选择日期"
            :clearable="true"
          ></el-date-picker>
        </template>
      </el-table-column>
      <el-table-column
        prop="location"
        label="地点"
        min-width="150"
        :editable="true"
      >
        <template #default="{ row }">
          <el-input v-model="row.location" placeholder="请输入地点"></el-input>
        </template>
      </el-table-column>
      <el-table-column
        prop="role"
        label="角色"
        min-width="100"
        :editable="true"
      >
        <template #default="{ row }">
          <el-select v-model="row.role" placeholder="请选择角色">
            <el-option label="参与者" value="participant"></el-option>
            <el-option label="组织者" value="organizer"></el-option>
          </el-select>
        </template>
      </el-table-column>
      <el-table-column
        prop="activityName"
        label="活动名称"
        min-width="250"
        :editable="true"
      >
        <template #default="{ row }">
          <el-input
            v-model="row.activityName"
            placeholder="请输入活动名称"
          ></el-input>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin-top: 10px">
      <el-button @click="addRow" type="primary">添加行</el-button>
      <el-button @click="clearTable" type="danger">清空</el-button>
    </div> -->
    <!-- <h2>个人评价</h2> -->
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
        <!-- <el-form-item label="学习态度">
          <el-input
            type="textarea"
            :rows="4"
            maxlength="100"
            show-word-limit
            v-model="learningAttitude"
          ></el-input>
        </el-form-item>
        <el-form-item label="健康素质">
          <el-input
            type="textarea"
            :rows="4"
            maxlength="100"
            show-word-limit
            v-model="physicalHealth"
          ></el-input>
        </el-form-item> -->
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
      activities: [
        {
          time: "",
          location: "",
          role: "",
          activityName: "",
        },
      ],
      behaviorNorms: "",
      learningAttitude: "",
      physicalHealth: "",
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
    addRow() {
      this.activities.push({
        time: "",
        location: "",
        role: "",
        activityName: "",
      });
    },
    clearTable() {
      this.activities = [];
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
  