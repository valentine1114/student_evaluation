<template>
  <el-card>
    <div slot="header">
      <div style="display: inline">
        <el-button type="info" @click="resetDataList">清空</el-button>
        <el-button type="warning" @click="handleDataAdd">新增一行</el-button>
        <!-- <el-button type="primary" @click="handleDataSave"> 保存 </el-button> -->
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

        <el-table-column label="上传文件" min-width="20%">
          <template slot-scope="scope">
            <div>
              <form id="Form">
                <input
                  type="file"
                  :ref="'fileInput_' + scope.$index"
                  class="upload-input"
                  @change="handleFileChange(scope.$index, $event)"
                />
              </form>
              <button
                class="upload-button"
                @click="uploadFile(scope.$index, scope.row)"
              >
                上传
              </button>
            </div>
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
import { studentSubmitResearch } from "@/services/researchService";
import { getInfo } from "@/api/login";
import { upload } from "@/services/researchService";
export default {
  data() {
    return {
      queryFields: [
        { key: "论文" },
        {
          key: "比赛",
        },
        {
          key: "专利",
        },
        {
          key: "其他",
        },
      ],

      //数据列表
      dataList: [
        {
          time: "",
          type: "",
          content: "",
          student: { id: "" },
          uploadUrl: "",
        },
        {
          time: "",
          type: "",
          content: "",
          student: { id: "" },
          uploadUrl: "",
        },
        {
          time: "",
          type: "",
          content: "",
          student: { id: "" },
          uploadUrl: "",
        },
        // 这里添加了三个空对象，对应三行表格
      ],
      list: [],
      fileList: [],
      selectedFile: null,
      uploadUrl: "",
    };
  },
  methods: {
    handleFileChange(event) {
      this.selectedFile = event.target.files[0];
    },

    uploadFile(index, row) {
      if (!this.selectedFile) {
        alert("请选择要上传的文件");
        return;
      }

      const allowedTypes = ["image/jpeg", "image/png"];
      const maxSize = 2 * 1024 * 1024; // 2MB

      if (!allowedTypes.includes(this.selectedFile.type)) {
        alert("只能上传 JPG/PNG 格式的图片");
        return;
      }

      if (this.selectedFile.size > maxSize) {
        alert("上传图片大小不能超过 2MB");
        return;
      }

      const formData = new FormData();
      formData.append("file", this.selectedFile);
      const config = {
        headers: { "content-type": "multipart/form-data" },
      };
      // 发起上传请求
      // 使用你的上传接口的URL替换下面的/api/upload
      // 可以使用axios、fetch或Vue Resource等HTTP库发送请求
      // 示例使用axios发送请求的方式
      upload(formData, config)
        .then((response) => {
          alert("文件上传成功");
          console.log(response);
          const uploadUrl = response; // Assuming the response contains the upload URL
          console.log(uploadUrl);
          row.uploadUrl = uploadUrl;

          console.log(uploadUrl);
          // 处理上传成功的逻辑
        })
        .catch((error) => {
          alert("文件上传失败");
          // 处理上传失败的逻辑
        });
    },
    //清空条件列表
    resetDataList() {
      this.dataList = [
        {
          time: "",
          type: "",
          content: "",
          student: { id: "" },
          uploadUrl: "",
        },
      ];
      document.getElementById("Form") &&
        document.getElementById("Form").reset();
    },
    handleDataSave() {},
    //删除一行
    handleDataDelete(index, row) {
      console.log(this.dataList[index]);

      const fileInput = this.$refs["fileInput_" + index];
      if (fileInput) {
        fileInput.value = "";
      }
      console.log(this.$refs.fileInput);
      this.dataList.splice(index, 1);
    },
    //插入一行
    handleDataAdd() {
      if (this.dataList == undefined) {
        this.dataList = [];
      }
      let obj = {};

      this.dataList.push(obj);
    },
    // handleDataSave() {
    //   this.handleUpload();
    // },
    async handleUpload() {
      // 提交处理逻辑
      await getInfo().then((response) => {
        console.log(response.data);
        console.log(this.dataList);
        const list = this.dataList.filter((item) => item.type !== "");
        console.log(list);
        studentSubmitResearch(list, response.data);
        this.resetDataList();
      });
    },
  },
};
</script>

<style scoped>
.upload-input {
  /* 设置上传文件输入框的样式属性 */
  /* 例如： */
  overflow: hidden;
  /* 可根据需要添加其他样式属性，如宽度、高度、边框等 */
}
</style>
  