import Vue from 'vue'
import VueRouter from 'vue-router'
import LogIn from '../views/LogIn.vue'
import HeaderPage from '../views/HeaderPage.vue';
import TechPage from '../views/TechPage.vue';
import RecordPage from '../views/RecordPage.vue';
import FilePage from '../views/FilePage.vue';
import MemberPage from '../views/MemberPage.vue';
import HomePage from '../views/HomePage.vue'

Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  routes: [
    { path: '/', component: LogIn },
    {
      path: '/home',
      component: HeaderPage,
      redirect: '/home',
      children: [
        {
          path: '/home',
          component: HomePage,
        },
        {
          path: '/tec',
          component: TechPage,
        },
        {
          path: '/record',
          component: RecordPage,
        },
        {
          path: '/file',
          component: FilePage,
        },
        {
          path: '/member',
          component: MemberPage,
        },
      ]
    }
  ]
})
export default router
