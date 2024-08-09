import Vue from 'vue';
import VueRouter from 'vue-router';
import LoginView from '@/views/LoginView.vue';
import HomeView from '@/views/HomeView.vue';
import ArticleView from '@/views/ArticleView.vue';

Vue.use(VueRouter);

const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      component: LoginView
    },
    {
      path: '/home',
      component: HomeView,
    },
    {
      path: '/article',
      component: ArticleView
    }
  ]
});

export default router