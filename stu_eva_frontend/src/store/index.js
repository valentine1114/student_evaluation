import Vue from 'vue'
import Vuex from 'vuex'

// Vue.use(Vuex)

// export default new Vuex.Store({
//   state: {
//   },
//   getters: {
//   },
//   mutations: {
//   },
//   actions: {
//   },
//   modules: {
//   }
// })
import { getInfo } from "@/api/login";
import router from '@/router'
Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user: {},
  },
  mutations: {
    SET_USER(state, user) {
      Vue.set(state, 'user', user);
    },
    CLEAR_USER(state) {
      state.user = {};
    },
  },
  actions: {
    
    async getUser({ commit }) {
      commit('SET_USER', {});
      try {
        const response = await getInfo();
        commit('SET_USER', response.data);
        console.log(response.data);
      } catch (error) {
        // 在这里处理错误，例如设置一个错误消息或者重定向用户到登录页
        console.log(error);
        router.push('/login');
      }
    },
  },
  getters: {
    user: (state) => state.user,
    routes: (state) => (state.user && state.user.role ? state.user.role.routes : []),
  },
});
