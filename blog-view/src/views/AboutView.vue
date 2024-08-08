<template>
  <div class="about">
    <!-- <h1>This is an about page</h1> -->
    <ArticlePage/>
  </div>

</template>

<script>
import ArticlePage from '@/components/ArticlePage.vue';

export default {
  name: 'AboutView',
  components: {
    ArticlePage
  }
};
</script>