<template>
  <div class="article-container">
    <!-- 文章内容 -->
    <div
      class="article-content"
      v-for="(article, index) in currentPageData"
      :key="article.articleId"
      :id="'article-' + (index + 1)"
    >
      <!-- 标签 -->
      <div class="article-labels">
        <span
          class="article-label"
          v-for="label in formattedTagArrays[index]"
          :key="label"
          @click="changePath(label)"
        >
          {{ label.trim() }}
        </span>
      </div>

      <!-- 标题 -->
      <h2 class="article-title">
        {{ article.articleTitle }}
      </h2>
      <!-- 时间 -->
      <div class="article-time">
        {{ article.articleCreatTime }}
      </div>

      <!-- 图片 -->
      <div v-if="article.images">
        <img :src="article.images" alt="Article Image" class="article-image" />
      </div>
      <!-- 文章内容 -->
      <div v-else>
        <div class="Content">{{ article.articleContent }}</div>
      </div>
      <!-- 点击按钮 -->
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
import { mapState } from "vuex";
export default {
  data() {
    return {
      currentPage: 1,
      totalPages: 1,
      index: 0,
      formattedTagArrays: [],
    };
  },
  created() {
    this.articles.forEach((article, index) => {
      // 检查 article.tag 是否存在，并且是字符串类型
      if (article && article.tag && typeof article.tag === "string") {
        this.formattedTagArrays[index] = article.tag.split(",");
      } else this.formattedTagArrays[index] = [];
    });
    this.totalPages = Math.ceil(this.articles.length / 5);
    this.$store.dispatch("fetchArticles"); //在这里获取文章
  },
  computed: {
    ...mapState({
      articles: (state) => state.articles,
    }),
    currentPageData() {
      const start = (this.currentPage - 1) * 5;
      const end = start + 5;
      return this.articles.slice(start, end);
    },
    articles() {
      return this.$store.state.articles;
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
.article-image {
  width: 90%;
  height: 312px;
  /* overflow: hidden; */
  object-fit: cover;
  margin-bottom: 10px;
  border-radius: 4px;
}

.article-time {
  font-size: 12px;
  color: #666;
  margin-top: -15px;
  margin-bottom: 15px;
}

.read-more-button {
  position: absolute;
  left: 50%;
  bottom: 5px;
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
  text-align: center;
  margin: 10px 0;
  height: 500px;
  border: 1px solid #ddd;
  padding-top: 50px;
  border-radius: 4px;
  background-color: #fff;
  box-sizing: border-box;
  width: 95%; /* 或者使用固定的宽度，如 width: 600px; */
  position: relative; /* 为标签的位置设置相对定位 */
}
.Content {
  height: 312px;
  overflow: hidden;
}

.article-content h2 {
  margin-top: 0;
  color: #333; /* 标题颜色 */
}
.article-title {
  text-align: center;
  font-size: 24px;
}

.article-labels {
  position: absolute;
  top: 10px;
  left: 10px;
  display: flex;
  margin-bottom: 10px;
  display: block;
}
.article-label {
  cursor: pointer;
  padding: 5px 10px;
  margin: 5px;
  background-color: #007bff;
  color: white;
  border-radius: 5px;
  font-size: 14px;
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