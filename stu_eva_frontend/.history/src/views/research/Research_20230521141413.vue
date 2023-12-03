<template>
  <el-card>
    <div slot="header">
      <div style="display: inline">
        <el-button type="info" @click="resetDataList">清空</el-button>
        <el-button type="warning" @click="handleDataAdd">新增一行</el-button>
        <el-button type="primary" @click="handleDataSave"> 保存 </el-button>
        <el-button type="success" @click="handleUpload"> 提交 </el-button>
      </div>
    </div>

    <!--  条件表格 -->
    <div>
      <el-table :data="dataList" style="width: 100%" highlight-current-row>
        <el-table-column
          label="序号"
          min-width="10%"
          type="index"
        ></el-table-column>
        <el-table-column label="时间" min-width="20%">
          <template slot-scope="scope">
            <div class="block">
              <span class="demonstration"></span>
              <el-date-picker
                v-model="scope.row.time"
                type="date"
                placeholder="选择日期"
                pro
              >
              </el-date-picker>
            </div>
          </template>
        </el-table-column>
        <el-table-column label="科研类别" min-width="25%">
          <template slot-scope="scope">
            <div class="block">
              <el-select
                v-model="scope.row.type"
                placeholder="请选择"
                filterable
                clearable
              >
                <el-option
                  v-for="item in queryFields"
                  :key="item.key"
                  :label="item.key"
                  :value="item.key"
                >
                </el-option>
              </el-select>
            </div>
          </template>
        </el-table-column>

        <el-table-column label="详细内容" min-width="25%">
          <template slot-scope="scope">
            <el-input
              placeholder="请输入内容"
              v-model="scope.row.content"
            ></el-input>
          </template>
        </el-table-column>

        <el-table-column label="操作" min-width="10%">
          <template slot-scope="scope">
            <el-button
              type="danger"
              @click="handleDataDelete(scope.$index, scope.row)"
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </div>
  </el-card>
</template>

<script>
export default {
  data() {
    return {
      queryFields: [
        { key: "学术论文" },
        {
          key: "学术专著",
        },
        {
          key: "课题研究与科技发明",
        },
        {
          key: "学科竞赛",
        },
        {
          key: "积极参加各类活动",
        },
      ],

      fileList: [],

      //数据列表
      dataList: [
        {
          活动名称: "",
          活动选项: "",
          值: "",
          fileList: [],
          conditionOptions: [],
          valueOptions: [],
        },
        {
          活动名称: "",
          活动选项: "",
          值: "",
          fileList: [],
          conditionOptions: [],
          valueOptions: [],
        },
        {
          活动名称: "",
          活动选项: "",
          值: "",
          fileList: [],
          conditionOptions: [],
          valueOptions: [],
        },
        // 这里添加了三个空对象，对应三行表格
      ],
    };
  },
  methods: {
    //清空条件列表
    resetDataList() {
      this.dataList = [
        {
          活动名称: "",
          活动选项: "",
          值: "",
          isDict: false,
          isDate: false,
          conditionOptions: [],
          valueOptions: [],
        },
      ];
      this.sortName = "";
      this.sortValue = "";
    },
    handleDataSave() {},
    //删除一行
    handleDataDelete(index, row) {
      this.dataList.splice(index, 1);
    },
    //插入一行
    handleDataAdd() {
      if (this.dataList == undefined) {
        this.dataList = [];
      }
      let obj = {};

      obj.活动名称 = "";
      obj.活动选项 = "";
      obj.值 = "";
      obj.isDict = false;
      obj.isDate = false;
      obj.conditionOptions = [];
      obj.valueOptions = [];
      this.dataList.push(obj);
    },
    submitUpload() {
      this.$refs.upload.submit();
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    //活动名称选择变化，相应的活动选项、值跟着发生变化
    nameChange(fieldName, index) {
      this.dataList[index].conditionOptions = [];
      this.dataList[index].valueOptions = [];

      this.getConditionAndValue(fieldName, index);
      this.dataList[index].活动选项 = "";

      this.dataList[index].值 = "";
    },
    getConditionAndValue(fieldName, index) {
      for (var i = 0; i < this.queryFields.length; i++) {
        if (this.queryFields[i].key === fieldName) {
          const conditionType = this.queryFields[i].conditionType;

          // 赋值活动选项
          this.dataList[index].conditionOptions =
            this.conditions_options[conditionType];

          // 赋值值选项
          this.dataList[index].valueOptions =
            this.values_options[conditionType];

          break;
        }
      }
    },
  },
};
</script>