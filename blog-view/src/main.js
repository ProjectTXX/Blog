import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

Vue.config.productionTip = false

//导入 element-ui
import elementUI from 'element-ui';

//导入 element-ui 的css样式
import 'element-ui/lib/theme-chalk/index.css';

//vue使用 element-ui
Vue.use(elementUI);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
