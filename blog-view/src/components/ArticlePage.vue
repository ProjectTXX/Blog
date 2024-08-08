<template>
  <div class="page">
    <div class="blog-article"> 
      <div class="sidebar">
        <!-- 文章目录tab -->
        <ul class="toc">
            <p>本文目录</p>
          <!-- 目录项，点击时滚动到对应的文章部分 -->
          <li v-for="(section, index) in tocSections" :key="index"
              :class="{ active: activeSection === section.id }"
              @click="scrollToSection(section.id)">
            {{ section.title }}
          </li>
        </ul>
      </div>
      <div class="content">
        <!-- 文章内容 -->
        <!-- 使用v-html来渲染HTML内容，注意在实际应用中需要对内容进行安全处理以避免XSS攻击 -->
        <h1 class="article-title">{{ articleTitle }}</h1>
        <div class="iconfont-content">
          <div>
             <i class="fa fa-clock">&nbsp; 2024-8-6 14:30</i> 
            <i class="devide">|</i>
             <i class="fa fa-eye">&nbsp;0</i>  
            <i class="devide">|</i>
             <i class="fa fa-comments">&nbsp;0</i>  
            <i class="devide">|</i>
             <i class="fa fa-tag">&nbsp;文章标签 </i> 
          <br>
             <i class="fa fa-pencil-alt">&nbsp;约xxx字</i> 
            <i class="devide">|</i>
             <i class="fa fa-hourglass-end">&nbsp;x分钟</i> 
          </div>
        </div>
        <div :id="section.id" class="article-section"  v-for="section in tocSections" :key="section.id">    
          <h2 >{{ section.title }}</h2>
          <hr>
          <div v-html="section.content"></div>
        </div>
        <div class="page-tag">
            <i class="fa fa-tag"></i>
            <a href="#" target="_blank">标签1</a>
            <a href="#" target="_blank">标签2</a>
            <a href="#" target="_blank">标签3</a>
        </div>
      </div>
    </div>
    <!-- 评论区 -->
    <div class="userViews">
      <i class="fa fa-comments">&nbsp;评论</i>
    </div>
  </div>
</template>

<script>
import { getArticles } from '@/api/article';
import { getViews } from '@/api/views';

export default {
  name: 'BlogArticle',
  data() {
    return {
      articles:[],//存储获取的文章数据
      commentsCount: 0, // 初始化评论数
      articleTitle: '文章标题',
      activeSection: 'article-title', // 默认激活的section
      tocSections: [
        { id: 'body-section-1', title: '正文一', content: '<div>这里是正文一的内容<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></div>' },
        { id: 'body-section-2', title: '正文二', content: '<div>这里是正文二的内容<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></div>' },
        { id: 'body-section-3', title: '正文三', content: '<div>这里是正文三的内容<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>啦啦啦啦</div>' }

        // 更多章节...
      ]
    };
  },
  created(){
    this.fetchArticles()
    this.fetchViews()
  },
  mounted() {
    // 页面加载时，滚动到顶部
    window.addEventListener('scroll',this.handleScroll)
  },
  beforeDestroy() {
    // 页面卸载时，移除滚动事件监听
    window.removeEventListener('scroll',this.handleScroll)
  },
  methods: {
    scrollToSection(sectionId) {
      this.activeSection = sectionId; // 更新当前激活的section
      
      //滚动到对应section
      const element = document.getElementById(sectionId);     
      if (element) {
        element.scrollIntoView({ behavior: 'smooth', block: 'start' });
      }
    },
    handleScroll() {
      const sections = document.querySelectorAll('.article-section')
      const currentSection = Array.from(sections).find(section =>{
        const sectionTop = section.offsetTop
        const sectionHeight = section.clientHeight
        const scrollTop = window.pageYOffset || document.documentElement.scrollTop
        const scrollBottom = scrollTop + window.innerHeight
        return scrollBottom > sectionTop && scrollTop < (sectionTop + sectionHeight)
      })
      if(currentSection) {
        this.activeSection = currentSection.id
      }
    },
    fetchArticles() {
      // 假设想获取所有文章，您可以传递特定的查询参数
      getArticles({}).then(response => {
          // 假设后端返回的数据格式如下：
          // {
          //   articleTitle: '文章标题',
          //   tocSections: [
          //     { id: '...', title: '...', content: '...' },
          //     ...
          //   ],
          //   // 其他数据...
          // }
          this.articleTitle = response.data.articleTitle;
          this.tocSections = response.data.tocSections;
          // 其他数据赋值...
        })
        .catch(error => {
          console.error('There was an error fetching the data:', error);
          // 根据需要进行错误处理，例如显示错误消息
        });
    },
    fetchViews() {
      // 您可以传递需要的参数给 getViews 函数
      getViews({}).then(response => {
        // 处理返回的视图数据
        // 例如，更新文章的阅读量或评论数
        this.commentsCount = response.data.commentsCount;
      }).catch(error => {
        console.error('Error fetching views:', error);
      });
    },
  }
};
</script>

<style scoped>
.page::before {
  content: "";
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: #D3D3D3; /* 背景颜色 */
  z-index: -1; /* 确保伪元素在页面内容下方 */
}

.blog-article {
  padding-top: 150px;
  margin: 0 auto;
  display: flex;
  max-width: 1200px;
  align-items: flex-start;
}


.sidebar {
  width: 148px;
  height: auto;
  position: sticky;
  top: 0px;
  background-color: #ffffff7c;
  margin-right: 40px;
  padding: 5px;
  border-radius: 8px;
  box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
}



.toc {
  list-style: none;
  padding: 0;
}
.toc p {
  margin-left: 4px;
  font-size: 16px;
  font-weight: bold;
  margin-bottom: 10px;
}

.toc li {
  cursor: pointer;
  padding: 5px;
  border-bottom: 1px solid #ccc;
  transition: background-color 0.3s;
}

.toc li.active {
  color: blue;
  font-weight: bold;
}

.toc li:hover {
  background-color:skyblue;
}

.toc li.active {
  color: blue;
  font-weight: bold;
}

.content {
  width: calc(100% - 188px);
  padding-bottom: 60px;
  padding-left: 40px;
  position: relative;
  background-color: #ffffff7c;
  border-radius: 8px;
  box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
}

.article-section {
  margin-bottom: 15px;
}

.article-section h2 {
  margin-top: 20px;
  margin-bottom: 0px;
}

.article-section hr {
  border: none;
  height: 1px;
  background-color: #ccc;
  margin-top: 0;
  margin-bottom: 5px;
}

.article-title {
  margin-bottom: 10px;
  text-align: center;
}

.iconfont-content {
  text-align: center;
  margin-bottom: 5px;
}

.iconfont-content i {
  font-size: 14px;
  color: #999;
}

.devide {
  display: inline-block;
  font-size: 14.5px;
  line-height: 24px;
  margin: 0 8px;
  opacity: .5;
  user-select: none;
}

.page-tag {
  margin-top: 100px;
}
.page-tag i {
  margin-right: 10px;
  font-size: 14px;
}

.page-tag a {
  display: inline-block;
  border: skyblue solid 1px;
  border-radius: 3px;
  padding: 2px 5px;
  margin-right: 5px;
  font-size: 14px;
  cursor: pointer;
  color: #999;
}

.userViews{
  position: absolute;
  margin-top: 30px;
  right: 155px;
  width: calc(100% - 505px);
  height: 300px;
  background-color: #ffffff7c;
  border-radius: 8px;
  box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
}
.userViews i{
  margin: 10px;
}

@media (max-width: 768px) {
  .sidebar {
    display: none;
  }

  .content {
    padding-left: 0;
    width: 100%;
    left: 0;
  }
}

</style>