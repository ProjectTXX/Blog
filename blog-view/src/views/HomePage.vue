<template>
  <div class="home">
    <div class="img">
      <div
        ref="background"
        class="interactive-background"
        @mousemove="handleMouseMove"
        @mouseleave="resetImage"
      >
        <!-- 文字效果 -->
        <div class="animated-text">
          <span v-for="(char, index) in visibleChars" :key="index">{{
            char
          }}</span>
          <button ref="scrollButton" @click="scrollToPosition">点击</button>
        </div>
        <img
          class="background-image"
          src="../assets/1.gif"
          alt="High-tech background"
        />
      </div>
    </div>
    <div class="content">
      <div class="template-container">
        <div class="left-half scroll-animation">
          <h2>文章</h2>
          <p>内容</p>
        </div>
        <div class="right-half scroll-animation">
          <div class="section-a">
            <h3>博客介绍</h3>
            <p>内容</p>
          </div>
          <div class="section-b scroll-animation">
            <h3>公告</h3>
            <p>内容</p>
          </div>
          <div class="section-c scroll-animation">
            <h3>评论</h3>
            <p>内容</p>
          </div>
          <div class="section-d scroll-animation">
            <h3>网站咨询</h3>
            <p>内容</p>
          </div>
        </div>
      </div>
    </div>
    <!-- 出现效果 -->
    <div class="friend-link-box scroll-animation">
      <h2>友情链接</h2>
      <div class="friend-links">
        <a>Friend 1</a>
        <a>Friend 2</a>
        <a>Friend 3</a>
        <a>Friend 4</a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      text: "这是一段测试文字",
      currentIndex: 0,
      direction: "forward",
      intervalId: null,
    };
  },
  computed: {
    visibleChars() {
      let chars = [];
      if (this.direction === "forward") {
        chars = this.text.slice(0, this.currentIndex + 1);
      } else {
        chars = this.text.slice(0, this.text.length - this.currentIndex);
      }
      return chars;
    },
  },
  mounted() {
    this.startAnimation();
    window.addEventListener("scroll", this.handleScroll);
  },
  beforeDestroy() {
    clearInterval(this.intervalId);
    window.removeEventListener("scroll", this.handleScroll);
  },
  methods: {
    handleScroll() {
      const boxes = this.$el.querySelectorAll(".scroll-animation");
      const triggerOffset = window.innerHeight * 1;

      boxes.forEach((box) => {
        const boxTop = box.getBoundingClientRect().top;
        if (boxTop < triggerOffset) {
          box.classList.add("show");
        }
      });
    },
    scrollToPosition() {
      const contentTop = this.$refs.background.clientHeight - 30;
      window.scrollTo({
        top: contentTop,
        behavior: "smooth",
      });
    },
    stepAnimation() {
      if (
        this.direction === "forward" &&
        this.currentIndex < this.text.length - 1
      ) {
        this.currentIndex++;
      } else if (this.direction === "backward" && this.currentIndex > 0) {
        this.currentIndex--;
      } else {
        // 切换方向
        this.direction = this.direction === "forward" ? "backward" : "forward";
      }
    },
    startAnimation() {
      this.intervalId = setInterval(this.stepAnimation, 500); // 每500毫秒改变一次
    },
    handleMouseMove(event) {
      const background = this.$refs.background;
      const image = background.querySelector(".background-image");

      const boundingRect = background.getBoundingClientRect();
      const offsetX = event.clientX - boundingRect.left;
      const offsetY = event.clientY - boundingRect.top;

      const centerX = boundingRect.width / 2;
      const centerY = boundingRect.height / 2;

      const xAxis = (offsetX - centerX) / 20;
      const yAxis = (centerY - offsetY) / 20;

      image.style.transform = `scale(1.3) rotateY(${xAxis.toFixed(
        2
      )}deg) rotateX(${yAxis.toFixed(2)}deg)`;
    },
    resetImage() {
      const image = this.$refs.background.querySelector(".background-image");
      image.style.transform = "scale(1.3)";
    },
  },
};
</script>

<style scoped lang="less">
.home {
  height: 2000px;
  margin-top: -70px;
  .img {
    position: relative; /* 设置为相对定位，以便.overlay-text可以使用绝对定位 */
    z-index: 0;
  }
}
.interactive-background {
  position: relative;
  top: 0;
  left: 0;
  width: 100%;
  height: 100vh;
  overflow: hidden;
  perspective: 1000px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.background-image {
  width: auto;
  height: 100%;
  object-fit: cover;
  transition: transform 0.5s ease;
  transform-origin: center center;
  transform: scale(1.3);
}
.animated-text {
  position: absolute; /* 绝对定位使文本浮动在图片上方 */
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: white;
  font-size: 24px;
  z-index: 1;
  span {
    animation: changeColor 5s infinite;
    font-size: 50px;
  }
  button {
    width: 120px;
    height: 40px;
    position: absolute;
    top: calc(600% + 30px);
    left: 50%;
    transform: translateX(-50%);
    background-color: rgba(0, 0, 0, 0.5);
    color: white;
    padding: 10px 20px;
    border: none;
    cursor: pointer;
    z-index: 2;
  }
}
@keyframes changeColor {
  0% {
    color: rgb(255, 119, 0);
  }
  25% {
    color: rgb(241, 4, 166);
  }
  50% {
    color: rgb(5, 174, 252);
  }
  75% {
    color: rgb(123, 255, 0);
  }
  100% {
    color: rgb(132, 0, 255);
  }
}

.content {
  margin-top: 50px;
  padding-top: 10px;
  margin-bottom: 50px;
  .template-container {
    width: 70%;
    margin: auto;
    display: flex;
    justify-content: space-between;
  }

  .left-half {
    width: 70%;
    padding: 20px;
    background-color: #f0f0f0;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Initial box shadow */
    transition: box-shadow 0.3s ease;
    &:hover {
      box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); /* Box shadow on hover */
    }
  }

  .right-half {
    width: 30%; /* Adjust as needed */
    padding: 20px;
  }

  .section-a,
  .section-b,
  .section-c,
  .section-d {
    margin-bottom: 20px;
    padding: 10px;
    background-color: #f0f0f0;
    border: 1px solid #ccc;
  }

  .section-a h3,
  .section-b h3,
  .section-c h3,
  .section-d h3 {
    margin-top: 0;
  }

  .section-a p,
  .section-b p,
  .section-c p,
  .section-d p {
    margin-bottom: 0;
  }
  .friend-link-box {
    margin: auto;
    width: 60%;
    padding: 20px;
    background-color: #f0f0f0;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    transition: box-shadow 0.3s ease;

    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
  }

  .friend-link-box:hover {
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
  }

  .friend-links {
    margin-top: 20px;
  }

  .friend-links a {
    display: block;
    padding: 5px 10px;
    margin-bottom: 5px;
    color: #333;
    text-decoration: none;
    transition: background-color 0.3s ease, color 0.3s ease;
  }

  .friend-links a:hover {
    background-color: #007bff;
    color: white;
  }
  .scroll-animation {
    transform: scale(0);
    opacity: 0;
    transition: transform 2s;
  }

  .scroll-animation.show {
    transform: scale(1);
    opacity: 1;
  }
}
</style>
