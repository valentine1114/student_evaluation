<!-- <template>
  <el-menu default-active="2" :collapse="collapsed" collapse-transition router :default-active="$route.path" unique-opened class="el-menu-vertical-demo" background-color="#334157" text-color="#fff" active-text-color="#ffd04b">
    <div class="logobox">
      <img class="logoimg" src="../assets/img/logo.png" alt="">
    </div>
    <el-submenu v-for="menu in allmenu" :key="menu.menuid" :index="menu.menuname">
      <template slot="title">
        <i class="iconfont" :class="menu.icon"></i>&nbsp;
        <span>{{menu.menuname}}</span>
      </template>
      <el-menu-item-group>
        <el-menu-item v-for="chmenu in menu.menus" :index="'/'+chmenu.url" :key="chmenu.menuid">
          <i class="iconfont" :class="chmenu.icon"></i>&nbsp;&nbsp;
          <span>{{chmenu.menuname}}</span>
        </el-menu-item>
      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</template>
<script>
export default {
  name: 'leftnav',
  data() {
    return {
      collapsed: false,
      allmenu: [
        // 省略了部分静态菜单数据，您可以在这里粘贴完整的静态数据
        {
          menuid: 1,
          icon: 'icon-xuesheng',
          menuname: '学生填报',
          hasThird: null,
          url: null,
          menus: [
            {
              menuid: 2,
              icon: 'icon-zongjie',
              menuname: '个⼈学年总结',
              hasThird: 'N',
              url: 'StudentEvaluation/personalSummary',
              menus: null
            },
            {
              menuid: 21,
              icon: 'icon-weibiaoti--',
              menuname: '志愿服务',
              hasThird: 'N',
              url: 'StudentEvaluation/volunteer',
              menus: null
            },
            {
              menuid: 22,
              icon: 'icon-chengji',
              menuname: '学生成绩',
              hasThird: 'N',
              url: 'StudentEvaluation/gpa',
              menus: null
            },
            {
              menuid: 23,
              icon: 'icon-keyanxitong',
              menuname: '科研情况',
              hasThird: 'N',
              url: 'StudentEvaluation/research',
              menus: null
            },
            {
              menuid: 24,
              icon: 'icon-w_zhiyuan',
              menuname: '学生骨干服务',
              hasThird: 'N',
              url: 'StudentEvaluation/backbone',
              menus: null
            },
            {
              menuid: 25,
              icon: 'icon-shehuishijian',
              menuname: '社会实践',
              hasThird: 'N',
              url: 'StudentEvaluation/socialPractice',
              menus: null
            },
          ]
        },
        {
          menuid: 2,
          icon: 'icon-pingweiguanli',
          menuname: '教师评分',
          hasThird: null,
          url: null,
          menus: [
          {
              menuid: 12,
              icon: 'icon-zongjie',
              menuname: '个⼈学年总结',
              hasThird: 'N',
              url: 'Scoring/personalSummaryList',
              menus: null
            },
            {
              menuid: 121,
              icon: 'icon-weibiaoti--',
              menuname: '志愿服务',
              hasThird: 'N',
              url: 'Scoring/volunteerList',
              menus: null
            },
            {
              menuid: 122,
              icon: 'icon-chengji',
              menuname: '学生成绩',
              hasThird: 'N',
              url: 'Scoring/gpaList',
              menus: null
            },
            {
              menuid: 123,
              icon: 'icon-keyanxitong',
              menuname: '科研情况',
              hasThird: 'N',
              url: 'Scoring/researchList',
              menus: null
            },
            {
              menuid: 124,
              icon: 'icon-w_zhiyuan',
              menuname: '学生骨干服务',
              hasThird: 'N',
              url: 'Scoring/backboneList',
              menus: null
            },
            {
              menuid: 125,
              icon: 'icon-shehuishijian',
              menuname: '社会实践',
              hasThird: 'N',
              url: 'Scoring/socialPracticeList',
              menus: null
            },
            
          ]
        },
        {
          menuid: 3,
          icon: 'icon-pingweiguanli',
          menuname: '学工管理',
          hasThird: null,
          url: null,
          menus: [
          {
              menuid: 126,
              icon: 'icon-shehuishijian',
              menuname: '导入导出名单',
              hasThird: 'N',
              url: 'sums/summary',
              menus: null
            },
          ]
        },
      ]
    }
  }
}
</script> -->
<template>
  <el-menu
    default-active="2"
    :collapse="collapsed"
    collapse-transition
    router
    unique-opened
    class="el-menu-vertical-demo"
    background-color="#334157"
    text-color="#fff"
    active-text-color="#ffd04b"
  >
    <div class="logobox">
      <img class="logoimg" src="../assets/img/logo.png" alt="" />
    </div>
    <el-submenu
      v-for="menu in filteredMenu"
      :key="menu.menuid"
      :index="menu.menuname"
    >
      <template slot="title">
        <i class="iconfont" :class="menu.icon"></i>&nbsp;
        <span>{{ menu.menuname }}</span>
      </template>
      <el-menu-item-group>
        <el-menu-item
          v-for="chmenu in menu.menus"
          :index="'/' + chmenu.url"
          :key="chmenu.menuid"
        >
          <i class="iconfont" :class="chmenu.icon"></i>&nbsp;&nbsp;
          <span>{{ chmenu.menuname }}</span>
        </el-menu-item>
      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</template>

<script>
import { getInfo } from "@/api/login"; // 你需要根据你的项目结构调整这个路径

export default {
  name: "leftnav",
  data() {
    return {
      collapsed: false,
      allmenu: [
        // 省略了部分静态菜单数据，您可以在这里粘贴完整的静态数据
        {
          menuid: 1,
          icon: "icon-xuesheng",
          menuname: "学生填报",
          hasThird: null,
          url: null,
          menus: [
            {
              menuid: 2,
              icon: "icon-zongjie",
              menuname: "个⼈学年总结",
              hasThird: "N",
              url: "StudentEvaluation/personalSummary",
              menus: null,
            },
            {
              menuid: 21,
              icon: "icon-weibiaoti--",
              menuname: "志愿服务",
              hasThird: "N",
              url: "StudentEvaluation/volunteer",
              menus: null,
            },
            {
              menuid: 22,
              icon: "icon-chengji",
              menuname: "学生成绩",
              hasThird: "N",
              url: "StudentEvaluation/gpa",
              menus: null,
            },
            {
              menuid: 23,
              icon: "icon-keyanxitong",
              menuname: "科研情况",
              hasThird: "N",
              url: "StudentEvaluation/research",
              menus: null,
            },
            {
              menuid: 24,
              icon: "icon-w_zhiyuan",
              menuname: "学生骨干服务",
              hasThird: "N",
              url: "StudentEvaluation/backbone",
              menus: null,
            },
            {
              menuid: 25,
              icon: "icon-shehuishijian",
              menuname: "社会实践",
              hasThird: "N",
              url: "StudentEvaluation/socialPractice",
              menus: null,
            },
          ],
        },
        {
          menuid: 2,
          icon: "icon-pingweiguanli",
          menuname: "教师评分",
          hasThird: null,
          url: null,
          menus: [
            {
              menuid: 12,
              icon: "icon-zongjie",
              menuname: "个⼈学年总结",
              hasThird: "N",
              url: "Scoring/personalSummaryList",
              menus: null,
            },
            {
              menuid: 121,
              icon: "icon-weibiaoti--",
              menuname: "志愿服务",
              hasThird: "N",
              url: "Scoring/volunteerList",
              menus: null,
            },
            {
              menuid: 122,
              icon: "icon-chengji",
              menuname: "学生成绩",
              hasThird: "N",
              url: "Scoring/gpaList",
              menus: null,
            },
            {
              menuid: 123,
              icon: "icon-keyanxitong",
              menuname: "科研情况",
              hasThird: "N",
              url: "Scoring/researchList",
              menus: null,
            },
            {
              menuid: 124,
              icon: "icon-w_zhiyuan",
              menuname: "学生骨干服务",
              hasThird: "N",
              url: "Scoring/backboneList",
              menus: null,
            },
            {
              menuid: 125,
              icon: "icon-shehuishijian",
              menuname: "社会实践",
              hasThird: "N",
              url: "Scoring/socialPracticeList",
              menus: null,
            },
          ],
        },
        {
          menuid: 3,
          icon: "icon-pingweiguanli",
          menuname: "学工管理",
          hasThird: null,
          url: null,
          menus: [
            {
              menuid: 126,
              icon: "icon-shehuishijian",
              menuname: "导入导出名单",
              hasThird: "N",
              url: "sums/summary",
              menus: null,
            },
          ],
        },
      ],
      userRoutes: [],
    };
  },
  computed: {
    filteredMenu() {
      return this.allmenu
        .map((menu) => ({
          ...menu,
          menus: menu.menus.filter((chmenu) =>
            this.userRoutes.includes(`/${chmenu.url}`)
          ),
        }))
        .filter((menu) => menu.menus.length > 0); // 过滤掉没有子菜单的菜单
    },
  },
  created() {
    getInfo().then((response) => {
      console.log(response);
      this.userRoutes = response.data.role.routes.map(
        (route) => route.node_path
      );
    });
  },
};
</script>
<style scoped>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 240px;
  min-height: 400px;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  border: none;
  text-align: left;
}
.el-menu-vertical-demo .el-menu-item-group__title {
  padding: 0px;
}
.el-menu-vertical-demo.el-menu-bg {
  background-color: #1f2d3d !important;
}
.el-menu-vertical-demo.el-menu {
  border: none;
}
.logobox {
  height: 100px;
  line-height: 40px;
  color: #9d9d9d;
  font-size: 20px;
  text-align: center;
  padding: 20px 0px;
}
.logoimg {
  height: 60px;
}
</style>


