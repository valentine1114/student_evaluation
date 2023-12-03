import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import axios from 'axios';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/icon/iconfont.css';
import { getAccessToken, isTokenExpired, refreshToken } from '@/utils/auth';
axios.defaults.baseURL = "http://localhost:8818"
/* 
全局配置axios——把 axios挂载到Vue.prototype 上：
优点：供每个.vue组件的实例直接使用
缺点：无法实现 API接口 的复用！！！
 */

Vue.prototype.$http = axios
// axios.defaults.withCredentials = true;
// Vue.prototype.$axios = axios;
Vue.config.productionTip = false

// axios.interceptors.request.use(async function (config) {
//   const token = getAccessToken();
//   if (token) {
//     if (isTokenExpired(token)) {
//       // Token已过期
//       // 在这里你可以引导用户重新登录，或者尝试自动刷新令牌
//       // 这取决于你的应用是否支持刷新令牌，以及你想要如何处理这种情况

//       router.push('/login');
//     } else {
//       // 如果Token未过期，将其添加到请求头部
//       config.headers.Authorization = 'Bearer ' + token;
//     }
//   }
//   return config;
// }, function (error) {
//   // 对请求错误做些什么
//   return Promise.reject(error);
// });
axios.interceptors.request.use(async function (config) {
  const token = getAccessToken();
  if (token) {
    if (isTokenExpired(token)) {
      try {
        const newToken = await refreshToken(); // 使用refreshToken方法请求新的令牌
        config.headers.Authorization = 'Bearer ' + newToken;
        updateAccessToken(newToken); // 更新localStorage中的令牌
      } catch (error) {
        // 处理刷新令牌失败的情况
        router.push('/login');
      }
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




