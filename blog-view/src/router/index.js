import Vue from 'vue'
import VueRouter from 'vue-router'
import Vuex from 'vuex'

import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import AboutView from '../views/AboutView.vue'

Vue.use(VueRouter)
Vue.use(Vuex)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/home',
    name: 'home',
    component: HomeView
  },
  //配置登录页面的路由
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  //配置about页面的路由
  {
    path: '/about',
    name: 'about',
    component: AboutView
  },
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})


export default router
