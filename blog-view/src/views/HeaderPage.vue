<template>
  <div class="app">
    <header
      :style="{
        backgroundColor: `rgba(40, 40, 40, ${currentBackgroundOpacity})`,
      }"
      class="fixed-header"
    >
      <nav class="nav-flex">
        <router-link to="/home" class="nav-item">首页</router-link>
        <router-link to="/tec" class="nav-item">技术</router-link>
        <router-link to="/record" class="nav-item">会议记录</router-link>
        <router-link to="/file" class="nav-item">归档</router-link>
        <router-link to="/member" class="nav-item">成员</router-link>
      </nav>
    </header>
    <div class="content">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      scrollThreshold: 100,
      homeBackgroundOpacity: 0.2,
      nonHomeBackgroundOpacity: 1,
      currentBackgroundOpacity: 1,
    };
  },
  watch: {
    "$route.path"(newPath) {
      // 监听路由变化，更新背景透明度
      this.updateBackgroundOpacity(newPath);
    },
  },
  methods: {
    updateBackgroundOpacity(path) {
      this.currentBackgroundOpacity =
        path === "/home"
          ? this.homeBackgroundOpacity
          : this.nonHomeBackgroundOpacity;
    },
    handleScroll() {
      // 只在 /home 路由下处理滚动事件
      if (this.$route.path === "/home") {
        const scrollTop =
          window.pageYOffset ||
          document.documentElement.scrollTop ||
          document.body.scrollTop ||
          0;
        this.currentBackgroundOpacity =
          scrollTop > this.scrollThreshold ? 1 : this.homeBackgroundOpacity;
      }
    },
  },
  mounted() {
    // 绑定滚动事件监听器
    window.addEventListener("scroll", this.handleScroll);
    // 初始时根据路由设置背景透明度
    this.updateBackgroundOpacity(this.$route.path);
  },
  beforeDestroy() {
    // 移除滚动事件监听器
    window.removeEventListener("scroll", this.handleScroll);
  },
};
</script>

<style scoped lang="less">
.router-link-active {
  background-color: #666;
}
.app {
  width: 100%;
  top: 0;
  left: 0;
  z-index: 1000;
}

.fixed-header {
  height: 50px;
  width: 100%;
  position: fixed;
  top: 0;
  left: 0;
  background-color: #333;
  padding: 10px;
  color: white;
  z-index: 1000; /* Ensure it's above other content */
  transition: background-color 0.5s ease;
}

.content {
  margin-top: 50px; /* Adjust to match header height */
  padding-top: 20px; /* Add padding to separate content from header */
}

.nav-flex {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 20px;
  list-style-type: none;
  margin: 0;
  padding: 0;
  color: white;
}

.nav-item {
  color: white;
  text-decoration: none;
  padding: 10px;
  border-radius: 5px;
}

.nav-item:hover {
  background-color: #555;
}
</style>
