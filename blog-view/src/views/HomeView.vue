<template>
  <!-- 引用导航栏Navtab组件 -->
  <NavTab />
  
</template>
<script>
import NavTab from '@/components/NavTab.vue'


// @ is an alias to /src
//import HelloWorld from '@/components/HelloWorld.vue'
export default {
  name: 'HomeView',
  components: {
    NavTab
  }
}
</script>
<style scoped>
</style>