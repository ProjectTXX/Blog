<template>
  <div>
    <!-- 引用导航栏Navtab组件 -->
  <NavTab />
  <!-- 引用博客介绍组件 -->
  <BlogIntro />
  <!-- 引用文章组件 -->
  </div>
</template>
<script>
import NavTab from '@/components/NavTab.vue'
import BlogIntro from '@/components/BlogIntroduction.vue'

// @ is an alias to /src
//import HelloWorld from '@/components/HelloWorld.vue'
export default {
  name: 'HomeView',
  components: {
    NavTab,
    BlogIntro,
  }
}
</script>
<style scoped>
</style>