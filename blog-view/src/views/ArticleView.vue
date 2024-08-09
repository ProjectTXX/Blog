<template>
  <div class="comment">
    <CommentSection/>
    <CommentPagination/>
  </div>
</template>

<script>
import CommentSection from '@/components/article/CommentSection.vue';
import CommentPagination from '@/components/article/CommentPagination.vue';

export default {
  components: {
    CommentSection,
    CommentPagination
  }
}
</script>