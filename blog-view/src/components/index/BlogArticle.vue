<template>
  <main class="content">
    <h2>文章</h2>
    <div class="article">
      <p>内容</p>
      <p>内容</p>
    </div>
  </main>
</template>

<script>
export default {
  name: 'BlogArticle',
};
</script>

<style scoped>
.content {
  height: 1000px;
  /* width: 1000px; */
  flex: 1;
  padding: 1rem;
  background-color: rgb(240, 240, 240);
}
.article p {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  padding: 1rem;
  background-color: beige;
}
</style>
