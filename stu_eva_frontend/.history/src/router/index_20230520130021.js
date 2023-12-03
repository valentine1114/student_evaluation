import Vue from 'vue'
import VueRouter from 'vue-router'

import Layout from '@/layout'

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

export default router
