import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import axios from 'axios';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/icon/iconfont.css';
import { getAccessToken, isTokenExpired } from '@/utils/auth';
// import axios from 'axios';
// axios.defaults.withCredentials = true;
// Vue.prototype.$axios = axios;
Vue.config.productionTip = false

axios.interceptors.request.use(async function (config) {
  const token = getAccessToken();
  if (token) {
    if (isTokenExpired(token)) {
      // Token已过期
      // 在这里你可以引导用户重新登录，或者尝试自动刷新令牌
      // 这取决于你的应用是否支持刷新令牌，以及你想要如何处理这种情况

      router.push('/login');
    } else {
      // 如果Token未过期，将其添加到请求头部
      config.headers.Authorization = 'Bearer ' + token;
    }
  }
  return config;
}, function (error) {
  // 对请求错误做些什么
  return Promise.reject(error);
});

Vue.use(ElementUI);


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')




