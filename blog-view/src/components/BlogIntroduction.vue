<template>
  <div class="body">
    <div class="blog-intro-container">
      <div class="blog-header">
        <div class="header-image">
      </div>
        <div class="header-text">
          <h1>{{ blogName }}</h1>
          <div class="description-container">
            <p class="blog-description" v-html="typedDescription"></p>
            <span class="cursor" v-show="isTyping">|</span>
        </div>
        </div>
      </div>
      <div class="blog-body">
        <div class="contact-icons">
          <!-- rel="noopener noreferrer"：这个属性有助于提高安全性，防止钓鱼攻击，并确保不会泄露当前页面的地址。 -->
          <a href="https://github.com/ProjectTXX/Blog" target="_blank" rel="noopener noreferrer" class="contact-icon" title="GitHub" ><i class="fab fa-github"></i></a>
          <!-- 暂时以我的QQ邮箱为例 -->
          <a href="mailto:213947810@qq.com" class="contact-icon" title="Email"><i class="fas fa-envelope"></i></a>
        </div>
        <div class="stats">
          <div class="stat-item" v-for="stat in stats" :key="stat.label">
            <span class="stat-label">{{ stat.label }}</span>
            <span class="stat-number">{{ stat.count }}</span>
          </div>
        </div>
        <p class="intro-text">{{ introText }}</p>
      </div>
  </div>
  </div>
</template>

<script>
export default {
  name: 'BlogIntro',
  data() {
    return {
      blogName: '项目组博客',
      blogDescription: 'Our journey is the sea of stars.',
      headerImageUrl: '/images/background.jpg', // 替换为你的图片路径
      stats: [
        { count: 0,label: '文章' },
        { count: 0, label: '日常' },
        { count: 0, label: '标签' }
      ],
      introText: '这里是博客的简介内容。',
      typedDescription: '',
      isTyping: false,
      typeCount: 0, //用于跟踪打字进度
      typeSpeed: 150, // 调整打字速度
    };
  },
  computed: {
    descriptionLength() {
      return this.blogDescription.length;
    }
  },
  methods: {
    type() {
      if (this.typeCount < this.descriptionLength) {
        this.typeCount++;
        this.typedDescription = this.blogDescription.substring(0, this.typeCount);
        if (this.typeCount === this.descriptionLength) {
          this.isTyping = false;
        } else {
          this.isTyping = true;
        }
        this.timer = setTimeout(this.type, this.typeSpeed);
      } else {
        this.isTyping = false;
        clearTimeout(this.timer);
      }
    },
   
  },
  mounted() {
    this.typeCount = 0;
    this.isTyping = true;
    this.type();
  },
};
</script>

<style scoped>
.body {
  color: #959494;
}

.blog-intro-container {
  position: fixed;
  top: 40px;
  right: 20px;
  width: 280px;
  display: flex;
  flex-direction: column;
  /* 阴影效果 */
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.1);
  border-radius: 10px;
  overflow: hidden;
  z-index: 1001;
  transition: box-shadow 0.3s ease-in-out; /* 平滑的阴影变化 */
}

.blog-header {
  /* color: white; */
background-image: url(../assets/home.jpg);
background-size:cover;
background-position:center;
border-radius:10px 10px 0 0;
height: 200px; /* 根据需要调整高度 */
display: flex;
flex-direction: column;
justify-content: flex-end;
padding: 20px;
position: relative;
transition: transform 0.3s ease-in-out;
}

.header-image img {
  width: 100%;
  height: 150px; /* 根据需要调整高度 */
  object-fit: cover;
  border-radius:  0 10px 10px ;
  transition: transform 0.3s ease-in-out; /* 平滑的图片缩放 */
}

.header-text h1, .header-text p {
  position: relative;
  z-index: 10;
  color: #282727;
}

.blog-body {
  flex: 1;
  padding: 15px;
  background: linear-gradient(to bottom, #ffffff, #d7d4d4);
  color: rgb(0, 0, 0);
  border-radius: 0 0 10px 10px;
}

.stats {
  display: flex;
  justify-content: space-around;
  margin-bottom: 20px;
}

.stat-item {
  text-align: center;
}

.stat-number {
  font-size: 1.2em;
  margin-bottom: 0.2em;
}

.stat-label {
  font-size: 0.8em;
  text-transform: uppercase;
  color: rgba(0, 0, 0, 0.7);
  padding-right: 10px;
}

.intro-text {
  font-size: 0.9em;
  line-height: 1.6;
}

/* 悬停效果 */
.blog-intro-container:hover {
  box-shadow: 0 12px 24px rgba(0,0,0,0.3); /* 更深的阴影 */
}

.blog-intro-container:hover .blog-header {
  transform: scale(1.02); /* 轻微放大 */
}

.description-container {
  position: relative; /* 为光标定位 */
}

.blog-description {
  display: inline; /* 使文本行内显示 */
  white-space: nowrap; /* 防止文本换行 */
  overflow: hidden; /* 隐藏超出部分 */
  color: #282727; /* 文本颜色 */
}

.cursor {
  position: absolute;
  right: 10px; /* 光标与文本的间隔 */
  bottom: 0;
  display: inline-block;
  background-color: black; /* 光标颜色 */
  animation: blink 1s infinite; /* 光标闪烁动画 */
}

.contact-icons {
  display: flex;
  justify-content: center;
  margin-bottom: 10px;
}

.contact-icon {
  color: #282727;
  font-size: 1.5em;
  margin: 0 10px;
  transition: color 0.3s ease-in-out;
}

.contact-icon:hover {
  color: #4A90E2; /* 鼠标悬停时的颜色变化 */
}

@keyframes blink {
  50% { opacity: 0; }
}
@media (max-width: 768px) {
  .blog-intro-container {
    top: 10px;
    right: 10px;
    width: calc(100% - 20px);
    height: calc(100% - 20px);
    border-radius: 0;
  }

  .header-image img {
    height: 100px; /* 调整高度以适应更小的屏幕 */
  }

  .contact-icon {
    font-size: 1.2em;
    margin: 0 5px;
  }
}
</style>