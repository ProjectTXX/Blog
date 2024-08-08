import Vue from 'vue'
import Vuex from 'vuex'
import App from './App.vue'
import router from './router'
import store from './store'
//导入 element-ui及css样式
import elementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
//导入 axios
import axios from 'axios'

Vue.config.productionTip = false
//App.config.globalProperties.$http = axios;
//
Vue.use(Vuex);
//vue使用 element-ui
Vue.use(elementUI);
Vue.prototype.$axios = axios;

new Vue({
  router,
  store,
  axios,
  render: h => h(App)
}).$mount('#app')
