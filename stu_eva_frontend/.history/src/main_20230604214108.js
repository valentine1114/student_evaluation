import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/icon/iconfont.css'
Vue.config.productionTip = false

Vue.use(ElementUI);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

//session 设置,放到路由上面
app.use(session({
  secret: 'secret', // 自定义加密方法，可以随便起
  resave: true,
  saveUninitialized: false, // 是否保存未初始化的会话
  maxAge: 1000 * 60 * 3, // 设置 session 的有效时间，单位毫秒
  rolling: true//登录时一直刷新有效时间
}))

