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

        <el-table-column label="学术类别" min-width="25%">
          <template slot-scope="scope">
            <el-select
              v-model="scope.row.活动名称"
              placeholder="请选择"
              filterable
              clearable
              @change="nameChange(scope.row.活动名称, scope.$index)"
            >
              <el-option
                v-for="item in queryFields"
                :key="item.key"
                :label="item.key"
                :value="item.key"
              >
              </el-option>
            </el-select>
          </template>
        </el-table-column>

        <el-table-column label="具体分类" min-width="25%">
          <template slot-scope="scope">
            <el-select
              v-model="scope.row.活动选项"
              placeholder="请选择"
              clearable
              @change="activityOptionChange(scope.row.活动选项, scope.$index)"
            >
              <el-option
                v-for="item in scope.row.conditionOptions"
                :key="item"
                :label="item"
                :value="item"
              >
              </el-option>
            </el-select>
          </template>
        </el-table-column>

        <el-table-column label="详细内容" min-width="25%">
          <template slot-scope="scope">
            <el-input
              placeholder="请输入内容"
              v-model="scope.row.publishname"
            ></el-input>
          </template>
        </el-table-column>

        <!-- <el-table-column label="得分情况" min-width="10%">
          <template slot-scope="scope">
            <el-select v-model="scope.row.值" placeholder="0" clearable>
              <el-option
                v-for="item in scope.row.valueOptions"
                :key="item"
                :label="item"
                :value="item"
              >
              </el-option>
            </el-select>
          </template>
        </el-table-column> -->

        <el-table-column label="上传证明文件" min-width="15%">
          <el-upload
            class="upload-demo"
            ref="upload"
            action="https://jsonplaceholder.typicode.com/posts/"
            :on-preview="handlePreview"
            :on-remove="handleRemove"
            :file-list="fileList"
            :auto-upload="false"
          >
            <el-button slot="trigger" type="primary">选取文件</el-button>
          </el-upload>
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
      valueMap: {
        本专业领域核心期刊: "4",
        其他非核心正式出版刊物: "2",

        测评工作小组酌情加分: "酌情赋分",

        参与院级或各研究中心课题研究并有成果: "1.5",
        参与校级课题研究: "1",
        参与校级课题研究并有成果: "2",
        省级有成果: "3",
        国家级有成果: "5",
        其他重大科技成果与发明创造: "10",

        全国特等奖: "6",
        全国一等奖: "5.5",
        全国二等奖: "5",
        全国三等奖: "4.5",
        省级特等奖: "5",
        省级一等奖: "4.5",
        省级二等奖: "4",
        省级三等奖: "3.5",
        校级特等奖: "4",
        校级一等奖: "3.5",
        校级二等奖: "3",
        校级三等奖: "2.5",
        院级一等奖: "2.5",
        院级二等奖: "2",
        院级三等奖: "1.5",
        院级优秀奖: "1",

        积极参加各类活动: "1",
        // 添加更多活动选项与对应数据的映射
      },
      queryFields: [
        { key: "学术论文", conditionType: "condition1" },
        {
          key: "学术专著",
          conditionType: "condition2",
        },
        {
          key: "课题研究与科技发明",
          conditionType: "condition3",
        },
        {
          key: "学科竞赛",
          conditionType: "condition4",
        },
        {
          key: "积极参加各类活动",
          conditionType: "condition5",
        },
      ],

      //不同的活动类型的值
      conditions_options: {
        condition1: ["本专业领域核心期刊", "其他非核心正式出版刊物"],
        condition2: ["测评工作小组酌情加分"],
        condition3: [
          "参与院级或各研究中心课题研究并有成果",
          "参与校级课题研究",
          "参与校级课题研究并有成果",
          "省级有成果",
          "国家级有成果",
          "其他重大科技成果与发明创造",
        ],
        condition4: [
          "全国特等奖",
          "全国一等奖",
          "全国二等奖",
          "全国三等奖",
          "省级特等奖",
          "省级一等奖",
          "省级二等奖",
          "省级三等奖",
          "校级特等奖",
          "校级一等奖",
          "校级二等奖",
          "校级三等奖",
          "院级一等奖",
          "院级二等奖",
          "院级三等奖",
          "院级优秀奖",
        ],
        condition5: ["积极参加各类活动"],
      },

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
    handleClick(tab, event) {
      console.log(tab, event);
    },
    activityOptionChange(option, index) {
      // 查找活动选项对应的值
      const value = this.valueMap[option];

      // 更新值
      this.$set(this.dataList[index], "值", value);
    },

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