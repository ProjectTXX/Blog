<template>
  <div class="home">
    <div class="header">
      <div class="logo">
          <h3>Our's Blog</h3>
      </div>
      <div class="nav">
        <ul>
          <li>
            <a href="#" target="_blank">
              <i class="iconfont icon-shouye"></i>
              首页
            </a>
          </li>
          <li>
            <a href="#" target="_blank">
              <i class="iconfont icon-fenlei"></i>
              分类
            </a>
          </li>
          <li>
            <a href="#" target="_blank">
              <i class="iconfont icon-guidang"></i>
              归档
            </a>
          </li>
          <li>
            <a href="#" target="_blank">
              <i class="iconfont icon-guanyuwomen"></i>
              关于我们</a
            >
          </li>
        </ul>
      </div>
      <div class="user">
        <button class="search">
          <i class="iconfont icon-sousuo"></i>
        </button>
        <button class="login" @click="login">
          <i class="iconfont icon-zhucedenglu" ></i>
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HomeView',
  data() {
    return {};
  },
  //点击按钮跳转到登录注册界面
  methods: {
    login() {
      this.$router.push('login');
    },
  },
};
</script>

<style scoped>
.header{
  display: flex;
  height:50px;
}
.home{
  height: 100vh;
  background-image: url(../assets/home.jpg);
  background-size: cover;
  background-repeat: no-repeat;
}
.logo{
  display: inline-block;
  cursor: pointer;
  margin-right: 25px;
  font-size: 18px;
  font-weight: bold;
}
h3{
  position: absolute;
  text-align: center;
  color: rgb(4, 15, 36); 
  /* -webkit-box-reflect: below 1px linear-gradient(transparent ,rgb(218, 218, 218)); */
  animation: san 10s linear infinite;
}
@keyframes san{
  0%,15%,50%,52%,70%,90%,99.1%{
      color: rgb(235, 192, 230);
      filter: blur(2px);
  }
  12%,15.1%,60%,70.1%,90.5%,100%{
      color: rgb(255, 255, 255);
      text-shadow: 0 0 5px rgba(22, 138, 216, 0.356),
      0 0 25px rgb(235, 118, 185),
      0 0 35px rgb(22, 138, 216),
      0 0 105px rgb(245, 127, 170),
      0 0 155px rgb(22, 138, 216);
      filter: blur(0px);
  }
}

.nav{
  display: flex;
  margin: 0 auto;
  align-items: center;
}
.nav li{
  padding: 10px;
  display: inline-block;
  cursor: pointer;
 
}

.nav a{
  color: rgb(255, 255, 255,0.8);
}

.icon-sousuo,
.icon-zhucedenglu{
  color: rgb(255, 255, 255,0.8);

  font-family:"iconfont" !important;
  font-size:25px;
  font-style:normal;
  -webkit-font-smoothing: antialiased;
  /* -webkit-text-stroke-width: 0.2px; */
  -moz-osx-font-smoothing: grayscale;
}

.user{
 padding: 5px 25px;
}
.search{
  margin-right: 12px;
}
@font-face {
  font-family: "iconfont";
  src: url('./iconfont/iconfont.woff2?t=1721552581805') format('woff2'),
       url('./iconfont/iconfont.woff?t=1721552581805') format('woff'),
       url('./iconfont/iconfont.ttf?t=1721552581805') format('truetype');
}


</style>
