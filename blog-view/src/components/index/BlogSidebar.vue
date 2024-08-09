<template>
  <aside class="sidebar">
    <div class="sidebar-item1">博客简介</div>
    <div class="sidebar-item2">
      <h3>📜公告栏</h3>
      <AnnouncementBoard />
    </div>
    <div class="sidebar-item3">标签</div>
    <!-- <div class="sidebar-item">网站资讯</div> -->
  </aside>
</template>

<script>
import AnnouncementBoard from './AnnouncementBoard.vue';

export default {
  name: 'BlogSidebar',
  components: {
    AnnouncementBoard,
  },
};
</script>

<style scoped>
.sidebar {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  /* background-color: #f5f5f5; */
  padding: 1rem;
  width: 250px;
  border: solid 1px;
}

.sidebar h3 {
  padding: 0 1rem;
}

.sidebar-item2 {
  background-color: #f5f5f5;
  margin-bottom: 1rem;
  border: solid 1px;
  border-radius: 10px;
}

</style>
