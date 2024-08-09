<template>
  <nav class="navbar">
    <div class="logo">Our's Blog</div>
    <ul class="nav-links">
      <li><a href="#">首页</a></li>
      <li><a href="#">分类</a></li>
      <li><a href="#">归档</a></li>
      <li><a href="#">成员</a></li>
    </ul>
    <div class="right-side">
      <button class="search-btn"><svg t="1722602137969" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1551" width="200" height="200"><path d="M942.427 857.574L775.792 690.939C823.699 625.691 852 545.152 852 458c0-217.6-176.4-394-394-394S64 240.4 64 458s176.4 394 394 394c87.152 0 167.691-28.301 232.939-76.208l166.635 166.635c23.432 23.431 61.422 23.431 84.853 0 23.431-23.432 23.431-61.422 0-84.853zM458 762c-167.895 0-304-136.105-304-304s136.105-304 304-304 304 136.105 304 304-136.105 304-304 304z" fill="#29ABE2" p-id="1552"></path></svg></button>
      <button class="login-btn"><svg t="1722602268194" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5456" width="200" height="200"><path d="M505.344 127.914667A181.248 181.248 0 0 0 322.944 307.626667a182.4 182.4 0 0 0 364.8 0 181.248 181.248 0 0 0-182.4-179.712m0-85.333334a266.709333 266.709333 0 0 1 267.733333 265.045334 267.733333 267.733333 0 0 1-535.466666 0A266.709333 266.709333 0 0 1 505.344 42.581333z" fill="#516280" p-id="5457"></path><path d="M579.754667 589.866667h-135.424a228.309333 228.309333 0 0 0-229.76 226.133333v13.525333c0 66.602667 101.418667 66.602667 229.76 66.602667h135.424c123.306667 0 229.76 0 229.76-66.602667v-13.354666a228.352 228.352 0 0 0-229.76-226.304m0-85.333334a313.728 313.728 0 0 1 315.093333 311.466667v13.525333c0 34.517333-13.44 117.418667-137.429333 141.952a976.768 976.768 0 0 1-177.664 9.984h-135.424a970.069333 970.069333 0 0 1-179.84-9.984c-122.069333-24.533333-135.253333-107.434667-135.253334-141.909333v-13.312a313.728 313.728 0 0 1 315.093334-311.466667z" fill="#516280" p-id="5458"></path><path d="M512.170667 429.568a112.597333 112.597333 0 0 1-91.264-48.256 41.984 41.984 0 0 1 5.845333-55.466667 33.834667 33.834667 0 0 1 50.432 6.4 41.856 41.856 0 0 0 62.336 7.978667 46.293333 46.293333 0 0 0 7.253333-7.978667 33.834667 33.834667 0 0 1 50.432-6.4 41.984 41.984 0 0 1 5.845334 55.466667 121.770667 121.770667 0 0 1-19.029334 20.864 109.098667 109.098667 0 0 1-71.850666 27.392z" fill="#007BFC" p-id="5459"></path></svg></button>
    </div>
  </nav>
</template>

<script>
export default {
  name: 'BlogNavbar',
};
</script>

<style scoped>
.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  color: white;
  padding: 0.5rem 1rem;
}
.logo {
  flex: 1;
  font-size: 1.5rem;
  font-weight: bold;
}
.nav-links {
  display: flex;
  justify-content: center;
  list-style: none;
  padding: 0;
  flex: 2;
}
.nav-links li {
  margin: 0 2rem;

}
.nav-links a {
  font-weight: bold;
  color: white;
  text-decoration: none;
}
.right-side {
  flex: 1;
  display: flex;
  justify-content: flex-end;
}
.right-side .search-btn,
.right-side .login-btn {
  background: none;
  border: none;
  color: white;
  font-size: 1.2rem;
  cursor: pointer;
  margin-left: 0.5rem;
}

</style>
