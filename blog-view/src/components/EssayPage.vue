<template>
  <div class="article-container">
    <div
      class="article-content"
      v-for="article in currentPageData"
      :key="article.id"
      :id="'article-' + (index + 1)"
    >
      <span class="article-label" @click="changePath(article.labelPath)">
        {{ article.label }}
      </span>
      <h2 class="article-title">
        {{ article.title }}
      </h2>
      <div v-html="article.content"></div>
      <div class="read-more-button" @click="goToArticleDetail(article.id)">
        点击全文阅读
      </div>
    </div>

    <nav class="pagination">
      <button @click="prevPage" v-show="currentPage > 1">上一页</button>
      <span
        v-for="page in totalPages"
        :key="page"
        :class="{ active: page === currentPage }"
        @click="setPage(page)"
        >{{ page }}</span
      >
      <button @click="nextPage" v-show="currentPage < totalPages">
        下一页
      </button>
    </nav>
  </div>
</template>

<script>
export default {
  data() {
    return {
      currentPage: 1,
      totalPages: 1,
      articles: [
        { id: 1, title: "文章1", content: "这是文章1的内容", label: "1" },
        { id: 2, title: "文章2", content: "这是文章2的内容" },
        { id: 3, title: "文章3", content: "这是文章3的内容" },
        { id: 4, title: "文章4", content: "这是文章4的内容" },
        { id: 5, title: "文章5", content: "这是文章5的内容" },
        { id: 6, title: "文章6", content: "这是文章6的内容" },
        { id: 7, title: "文章7", content: "这是文章7的内容" },
        { id: 8, title: "文章8", content: "这是文章8的内容" },
        { id: 9, title: "文章9", content: "这是文章9的内容" },
        { id: 10, title: "文章10", content: "这是文章10的内容" },
        { id: 11, title: "文章11", content: "这是文章11的内容" },
        { id: 12, title: "文章12", content: "这是文章12的内容" },

        // ...
      ],
    };
  },
  created() {
    this.totalPages = Math.ceil(this.articles.length / 5);
  },
  computed: {
    currentPageData() {
      const start = (this.currentPage - 1) * 5;
      const end = start + 5;
      return this.articles.slice(start, end);
    },
  },
  methods: {
    goToArticleDetail(articleId) {
      // 假设您的文章详情页面路由路径为 '/article-detail'，并且使用文章的 id 作为路由参数
      const path = `/article-detail/${articleId}`;
      this.$router.push({ path });
    },
    changePath(path) {
      this.$router.push({ path }); // 确保 this.$router 是可用的
    },
    nextPage() {
      if (this.currentPage < this.totalPages) {
        this.currentPage++;
        this.scrollToTop();
      }
    },
    prevPage() {
      if (this.currentPage > 1) {
        this.currentPage--;
        this.scrollToTop();
      }
    },
    setPage(page) {
      this.currentPage = page;
      this.scrollToTop();
    },
    scrollToTop() {
      this.$nextTick(() => {
        const firstArticle = document.querySelector(
          ".article-content:first-child .article-title"
        );
        if (firstArticle) {
          firstArticle.scrollIntoView();
          window.scrollBy(0, -150);
        }
      });
    },
  },
};
</script>

<style scoped>
.read-more-button {
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  display: inline-block; /* 内联块级元素，可以设置宽度和高度 */
  padding: 10px 30px; /* 内边距 */
  margin: 20px 0; /* 外边距，距离文章内容的距离 */
  background: linear-gradient(45deg, #9400d3, #4b0082); /* 紫色渐变背景 */
  color: white; /* 文字颜色 */
  border: none; /* 无边框 */
  border-radius: 30px; /* 圆角边框，胶囊形状 */
  cursor: pointer; /* 鼠标悬停时显示手形图标 */
  font-weight: bold; /* 字体加粗 */
  text-align: center; /* 文本居中 */
  text-decoration: none; /* 去除下划线 */
  transition: background 0.3s ease; /* 渐变效果的过渡动画 */
}

.read-more-button:hover {
  background: linear-gradient(135deg, #9400d3, #4b0082);
}
.article-container {
  display: flex;
  flex-direction: column; /* 设置为垂直排列 */
  align-items: center; /* 如果需要，水平居中对齐 */
}

.article-content {
  margin: 10px 0;
  height: 500px;
  border: 1px solid #ddd;
  padding: 15px;
  border-radius: 4px;
  background-color: #fff;
  box-sizing: border-box;
  width: 95%; /* 或者使用固定的宽度，如 width: 600px; */
  position: relative; /* 为标签的位置设置相对定位 */
}

.article-content h2 {
  margin-top: 0;
  color: #333; /* 标题颜色 */
}
.article-title {
  text-align: center; /* 标题居中 */
  font-size: 24px; /* 放大标题 */
  margin: 0 0 20px; /* 标题下边距 */
}

.article-label {
  position: absolute; /* 绝对定位 */
  top: 10px; /* 距离顶部10px */
  left: 10px; /* 距离左侧10px */
  cursor: pointer;
  padding: 5px 10px; /* 内边距 */
  background-color: #007bff; /* 背景颜色 */
  color: white; /* 字体颜色 */
  border-radius: 5px; /* 边框圆角 */
  font-size: 14px; /* 字体大小 */
  /* 添加更多样式，如文本对齐、字体粗细等 */
  text-align: center;
  font-weight: bold;
}
.article-label:hover {
  background-color: #0056b3;
}
.article-content:not(:last-child) {
  margin-bottom: 20px; /* 为除了最后一个文章盒子外的盒子添加底部边距 */
}

.pagination {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 20px;
}

.pagination button,
.pagination span {
  padding: 10px 15px;
  margin: 0 5px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #fff;
  cursor: pointer;
  transition: background-color 0.3s, color 0.3s; /* 平滑过渡效果 */
}

.pagination .active {
  background-color: #4caf50;
  color: white;
}

.pagination button:disabled {
  opacity: 0.5;
  cursor: not-allowed;
}
</style>