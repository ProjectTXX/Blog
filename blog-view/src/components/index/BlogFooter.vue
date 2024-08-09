<template>
  <footer class="footer">
    <h3>友情链接</h3>
    <ul>
      <li><a href="#">Friend 1</a></li>
      <li><a href="#">Friend 2</a></li>
      <li><a href="#">Friend 3</a></li>
      <li><a href="#">Friend 4</a></li>
    </ul>
  </footer>
</template>

<script>
export default {
  name: 'BlogFooter',
};
</script>

<style scoped>
.footer {
  background-color: #9ab3b9;
  color: white;
  padding: 1rem;
  text-align: center;
}
.footer ul {
  list-style: none;
  padding: 0;
}
.footer li {
  margin: 0.5rem 0;
}
.footer a {
  color: white;
  text-decoration: none;
}
</style>
