<template>
  <div class="home">
    <BlogNavbar />
    <div class="box"></div>
    <div class="main-layout">
      <BlogArticle />
      <BlogSidebar />
    </div>
    <BlogFooter />
  </div>
</template>

<script>
import BlogNavbar from '@/components/index/BlogNavbar.vue'
import BlogArticle from '@/components/index/BlogArticle.vue'
import BlogSidebar from '@/components/index/BlogSidebar.vue'
import BlogFooter from '@/components/index/BlogFooter.vue'

export default {
  components: {
    BlogNavbar,
    BlogArticle,
    BlogSidebar,
    BlogFooter
  }
}
</script>

<style>
.home {
  background-image: url("../assets/background.png");
  background-size: 100%;
  background-attachment: fixed;
}

.main-layout {
  display: flex;
  flex: 1;
}

.box {
  height: 800px;
}

.icon {
  width: 1.2em; height: 1.2em;
  vertical-align: -0.15em;
  fill: currentColor;
  overflow: hidden;
}
</style>
