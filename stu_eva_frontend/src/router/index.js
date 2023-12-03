import Vue from 'vue'
import VueRouter from 'vue-router'

import Layout from '@/layout'
import { getAccessToken, isTokenExpired, refreshToken, updateAccessToken, setAuthorizationHeader } from '@/utils/auth'
import { getInfo } from '@/api/login'
import store from '@/store';
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Layout,
    children: [
      {
        path: '',
        component: () => import('../views/HomeView.vue'),
        name: 'home'
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/login.vue')

  }
  ,
  {
    path: '/error',
    component: Layout,
    children: [{
      path: '501',
      component: () => import('../views/error501.vue')
    }]
  }
  ,
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/StudentEvaluation',
    component: Layout,
    children: [{
      path: 'personalSummary',
      component: () => import('../views/summary/PersonalSummary.vue')
    },
    {
      path: 'gpa',
      component: () => import('../views/gpa/GPA.vue')
    },
    {
      path: 'research',
      component: () => import('../views/research/Research.vue')
    },
    {
      path: 'backbone',
      component: () => import('../views/backbone/Backbone.vue')
    },
    {
      path: 'socialPractice',
      component: () => import('../views/social/SocialPractice.vue')
    },
    {
      path: 'volunteer',
      component: () => import('../views/volunteer/Volunteer.vue')
    },
    ]
  },
  {
    path: '/Scoring',
    component: Layout,
    children: [{
      path: 'personalSummary',
      component: () => import('../views/summary/score.vue')
    },
    {
      path: 'gpa',
      component: () => import('../views/gpa/score.vue')
    },
    {
      path: 'research',
      component: () => import('../views/research/score.vue')
    },
    {
      path: 'backbone',
      component: () => import('../views/backbone/score.vue')
    },
    {
      path: 'socialPractice',
      component: () => import('../views/social/score.vue')
    },
    {
      path: 'volunteer',
      component: () => import('../views/volunteer/score.vue')
    },
    {
      path: 'personalSummaryList',
      component: () => import('../views/summary/list.vue')
    },
    {
      path: 'gpaList',
      component: () => import('../views/gpa/list.vue')
    },
    {
      path: 'researchList',
      component: () => import('../views/research/list.vue')
    },
    {
      path: 'backboneList',
      component: () => import('../views/backbone/list.vue')
    },
    {
      path: 'socialPracticeList',
      component: () => import('../views/social/list.vue')
    },
    {
      path: 'volunteerList',
      component: () => import('../views/volunteer/list.vue')
    },
    ]
  },
  {
    path: '/sums',
    component: Layout,
    children: [{
      path: 'summary',
      component: () => import('../views/sums/sum.vue')
    },
    {
      path: 'lists',
      component: () => import('../views/sums/lists.vue')
    },
    ]
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

const publicPages = ['/login', '/home', '/about']; // 公共页面
const protectedPages = ['/StudentEvaluation', '/Scoring', '/sums']; // 需要授权的页面


let tokenRefreshed = false;

router.beforeEach(async (to, from, next) => {
  const hasToken = getAccessToken();
  const isExpired = isTokenExpired(getAccessToken());
  console.log(getAccessToken());
  console.log(isExpired);
  const isPublicPage = publicPages.includes(to.path);
  const topath = '/' + to.path.split('/')[1];
  const isProtectedPage = protectedPages.includes(topath);

  // if (hasToken && isExpired && !tokenRefreshed) {
  //   // 令牌存在、过期且未刷新
  //   try {
  //     const newToken = await refreshToken(); // 使用刷新令牌的 API 请求方法获取新的令牌
  //     updateAccessToken(newToken); // 更新存储的令牌
  //     setAuthorizationHeader(newToken); // 更新请求头中的令牌
  //     tokenRefreshed = true; // 将标记设置为已刷新
  //     next(); // 重新导航到当前路由
  //   } catch (error) {
  //     // 处理刷新令牌失败的情况
  //     console.error('Failed to refresh token:', error);
  //     next('/login'); // 跳转到登录页或执行其他适当的操作
  //   }
  // } else {
  //   next(); // 继续导航到下一个路由
  // }

  if (hasToken && !isExpired) {
    console.log(Object.keys(store.getters.user));
    if (Object.keys(store.getters.user).length === 0) {
      try {
        console.log('Before calling getUser');
        await store.dispatch('getUser');
        console.log('After calling getUser');
      } catch (error) {
        next('/login');
        return;
      }
    }

    if (isProtectedPage) {
      const routes = store.getters.routes;
      const targetRoute = to.path;
      console.log(routes);
      console.log(targetRoute);
      if (routes.some(route => route.node_path === targetRoute)) {
        next();
      } else {
        next('/error/501');
      }
    } else {
      next();
    }
  } else {
    if (isPublicPage) {
      next();
    } else {
      next('/login');
    }
  }
});

export default router
