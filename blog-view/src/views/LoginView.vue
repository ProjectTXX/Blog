<template>
  <body>
     <!--登录和注册表单的主要区域 -->
     <main :class="{'sign-up-mode':isSignup}">
      <!-- 包含登录和注册表单的容器 -->
      <div class="box">
        <!-- 包含登录和注册表单的内部容器 -->
        <div class="inner-box">
          <!-- 包含登录和注册表单的表单容器 -->
          <div class="forms-wrap">
            <!-- 登录表单 -->
            <form action="index.html" autocomplete="off" class="sign-in-form">
              <!-- 包含网站logo的容器 -->
              <div class="logo">
                <h4>登录</h4>
              </div>
              <!-- 包含标题和切换注册表单的链接的容器 -->
              <div class="heading">
                <h2>欢迎回来</h2>
                <h6>Not registered yet?</h6>
                <a href="#" class="toggle" @click="toggle">Sign up</a>
              </div>
              <!-- 包含输入字段和提交按钮的容器 -->
              <div class="actual-form">
                <!-- 包含邮箱输入字段的容器 -->
                <div class="input-wrap">
                  <input
                    id="name"
                    type="text"
                    minlength="4"
                    autocomplete="off"
                    required
                    class="input-field"
                    placeholder="Name"

                  />       
                </div>
                <!-- 包含密码输入字段的容器 -->
                <div class="input-wrap">
                  <input
                    id="password"
                    type="password"
                    autocomplete="off"
                    required
                    class="input-field"
                    placeholder="Password"

                  /> 
                </div>
                <!-- 包含人机验证码输入字段容器 -->
                <div class="input-wrap">
                  <input 
                    id="sign-code" 
                    type="text" 
                    class="input-field"
                    placeholder="Code" 

                    />
                </div>
                <!-- 登录表单的提交按钮 -->
                <input type="submit" value="SIGN IN" class="sign-btn" />
                <!-- 忘记密码的链接 -->
                <p class="text">
                  忘记密码?
                  <a href="#">获取帮助</a>
                </p>
              </div>
            </form>
            <!-- 注册表单 -->
            <form action="index.html" autocomplete="off" class="sign-up-form">
              <!-- 包含网站logo的容器 -->
              <div class="logo">
                <!-- <img src="" alt=""> -->
              </div>
              <!-- 包含标题和切换登录表单的链接的容器 -->
              <div class="heading">
                <h2>注册</h2>
                <h6>Already have an account?</h6>
                <a href="#" class="toggle" @click="toggle">Sign In</a>
              </div>
              <div class="actual-form">
                <!-- 包含用户名输入字段的容器 -->
                <div class="input-wrap">
                  <input
                    id="sign-name"
                    type="text"
                    minlength="4"
                    autocomplete="off"
                    required
                    class="input-field"
                    placeholder="Name"

                  />
                </div>
                <!-- 包含电子邮件输入字段的容器 -->
                <div class="input-wrap">
                  <input
                    id="sign-email"
                    type="email"
                    autocomplete="off"
                    required
                    class="input-field"
                    placeholder="Email"

                  />
                </div>
                <!-- 包含密码输入字段的容器 -->
                <div class="input-wrap">
                  <input
                    id="sign-password"
                    type="password"
                    autocomplete="off"
                    required
                    class="input-field"
                    placeholder="Password"

                  />
                </div>
                <!-- 包含邮箱验证码输入字段容器 -->
                <div class="input-wrap">
                  <input 
                    id="sign-code" 
                    type="text" 
                    class="input-field"
                    placeholder="Code"

                    />
                </div>
                <!-- 注册表单的提交按钮 -->
                <input type="submit" value="SIGN IN" class="sign-btn" />
                <!-- 同意服务条款和隐私协议的复选框 -->
                <p class="text">
                  <input type="checkbox" name="" id="" />注册前我已阅读并同意
                  <a href="#">服务条款</a>和<a href="#">隐私协议</a>
                </p>
              </div>
            </form>
          </div>
          <!-- 包含轮播图的容器 -->
          <div class="carousel">
            <!-- 包含轮播图图片的容器 -->
            <div class="images-wrapper">
              <img
                src="https://img-baofun.zhhainiao.com/pcwallpaper_ugc/live/68ff62863bb9fd90d6fd874802e08568.mp4.jpg"
                class="image img-1 show"
                alt=""
              />
              <img
                src="https://wallpaper-static.cheetahfun.com/wallpaper/sites/scifi/pic5.jpg"
                alt=""
                class="image img-2"
              />
              <img
                src="https://img-baofun.zhhainiao.com/pcwallpaper_ugc/live/8bc682fba0a8747155409b3bbc2676ac.mp4.jpg"
                alt=""
                class="image img-3"
              />
            </div>
            <!-- 包含轮播图文本和轮播图指示器的容器 -->
            <div class="text-slider">
              <!-- 包含轮播图文本的容器 -->
              <div class="text-wrap">
                <div class="text-group">
                  <h2>开始你的学习旅程</h2>
                  <h2>准备创造奇迹吧</h2>
                  <h2>学习是一切创建力的开始</h2>
                </div>
              </div>
              <!-- 包含轮播图指示器的容器 -->
              <div class="bullets">
                <span class="active" data-value="1"></span>
                <span data-value="2"></span>
                <span data-value="3"></span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
  </body>
</template>
<script>
//导入axios
import axios from 'axios';
export default {
  name: "LoginView",
  data:function (){
    return{
      name:'',
      pwd:'',
      codeImg:null,
      code:'',
      user_list:[
      { 
        id:'1',
        username:'admin',
        password:'123'
      },
      ],
      //页面:
      isWrap: false,
      isSignup: false,
      // axios
      username: "",
      password: "",
    }
  },
 
  methods:{
    toggle() {
      this.isSignup = !this.isSignup;
    },
    // 登录表单提交事件处理函数
    login() {
      // 获取用户名和密码
      const username = this.username;
      const password = this.password;
      // 发送登录请求
      axios.post("http://18a0afbd.r21.cpolar.top/api/v1/user/login", {
        username,
        password,
      })
      .then((response) => {
        // 处理登录成功
        console.log(response.data);
      })
      .catch((error) => {
        // 处理登录失败
        console.error(error);
      });
    },
  },
}

</script>

<style scoped>

/* 重置所有元素的内边距、外边距和盒模型为border-box */
*, *::after, *::before {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}


body {
  color: #fff; 
  background-image: url(../assets/login.jpg);
  background-repeat: no-repeat;
  background-size: cover;
  font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif; 
}


main {
  width: 100%; 
  overflow: hidden;
  min-height: 100vh; 
  padding: 2rem; 
  display: flex; 
  align-items: center; 
  justify-content: center; 
}




.box {
  width: 100%; 
  max-width: 800px; 
  height: 500px; 
  background-image: url(../assets/login.jpg); 
  background-repeat: no-repeat; 
  background-size: cover; 
  position: relative; 
  border-radius: 3.0rem; 
  box-shadow: 0 0 20px #b7b2a9; 
}


.inner-box {
  position: absolute; 
  width: calc(100% - 4.1rem); 
  height: calc(100% - 4.1rem); 
  top: 50%; 
  left: 50%;
  transform: translate(-50%, -50%); 
}



.forms-wrap {
  position: absolute; 
  height: 100%;
  width: 45%; 
  left: 0; 
  top: 0; 
  display: grid; 
  grid-template-columns: 1fr;
  grid-template-rows: 1fr;
  transition: 0.8s ease-in-out; 
}


form {
  max-width: 260px; 
  width: 100%; 
  margin: 0 auto; 
  height: 100%; 
  display: flex; 
  flex-direction: column; /* 设置form的子元素在垂直方向上排列 */
  justify-content: space-evenly; /* 在form的子元素之间均匀分布空间 */
  grid-column: 1/2; /* 设置form的列为1到2 */
  grid-row: 1/2; /* 设置form的行为1到2 */
  transition: opacity 0.02s 0.4s; 
}

form.sign-up-form {
  opacity: 0; 
  pointer-events: none; /* 禁用.sign-up-form的鼠标事件 */
}




.logo {
  display: flex; 
  align-items: center; 

}
.logo img {
  height: 27px;
  margin-right: .3rem;
}


.logo h4 {
  font-size: 2rem;
  letter-spacing: 0.5px; 
  color: #9cf1eb; 
}



.heading h2 {
  font-size: 1.1rem;
  font-weight: 600;
  color: #9cf1eb;
}


.heading h6 {
  font-size: 0.75rem;
  font-weight: 400;
  display: inline;
  color: #bababa;
}

.toggle {
  color: #bbb;
  text-shadow:0 0 20px #bababa;
  text-decoration: none;
  font-size: 0.75rem;
  font-weight: 500;
  transition: .3s;
}

.toggle:hover {
  color: #8371f6;
}

.input-wrap {
  position: relative;
  height: 37px;
  margin-bottom: 2rem;
}

.input-field {
  position: absolute;
  width: 100%;
  height: 100%;
  background: none;
  border: none;
  outline: none;
  border-bottom: 1px solid #bbb;
  padding: 0;
  font-size: 0.95rem;
  color: #151111;
  transition: 0.4s;
}


/* 当输入框获得焦点时 */
.input-field:focus {
  border-bottom-color: #151111;
}



.sign-btn {
  display: inline-block;
  width: 100%;
  height: 43px;
  background: #151111;
  color: #fff;
  border: none;
  cursor: pointer;
  border-radius: 0.8rem;
  margin-bottom: 2rem;
  transition: 0.3s;
}

.sign-btn:hover {
  background-color: #8371f6;
}

.text {
  display: flex;
  color: white;
  text-shadow: 0 0 20px #b7b2a9;
  font-size: 0.7rem;
}

.text a {
  color: #bbb; 
  transition: 0.3s;
}


.text a:hover {
  color: #8371f6;
}


/* 当处于注册模式下的登录表单 */
main.sign-up-mode form.sign-in-form {
  opacity: 0;
  /* 禁用指针事件 */
  pointer-events: none
}

/* 当处于注册模式下的注册表单 */
main.sign-up-mode form.sign-up-form {
  /* 设置透明度为1 */
  opacity: 1;
  /* 启用指针事件 */
  pointer-events: all
}

/* 当处于注册模式下的表单容器 */
main.sign-up-mode .forms-wrap {
  left: 55%;
}

/* 当处于注册模式下的轮播容器 */
main.sign-up-mode .carousel {
  left: 0%;
}

.carousel {
  border-radius: 2rem;
  padding: 2rem;
  position: absolute;
  overflow: hidden;
  height: 100%;
  width: 55%;
  left: 45%;
  top: 0;
  box-shadow: 0 0 5px #b7b2a9;
  background-color: transparent;
  display: grid;  /*网格布局*/
  transition: 0.8s ease-in-out;
  position: relative;
  /* 设置网格行模板 */
  grid-template-rows: auto 1fr;
}


.images-wrapper {
  /* 设置为网格布局 */
  display: grid;
  /* 设置网格列模板 */
  grid-template-columns: 2fr;
  /* 设置网格行模板 */
  grid-template-rows: 1fr;
}

.image {
  width: 100%;
  /* 设置网格列为1到2 */
  grid-column: 1/2;
  /* 设置网格行为1到2 */
  grid-row: 1/2;
  opacity: 0;
  transition: opacity 0.3s, transform 0.5s;
}

.img-1 {
  transform: translate(0, -50px);
}

.img-2 {
  /* 设置水平和垂直缩放 */
  transform: scale(0.4, 0.5);
}

.img-3 {
  /* 设置缩放和旋转 */
  transform: scale(0.3), rotate((-20deg));
}

.image.show {
  /* 设置透明度为1 */
  opacity: 1;
  /* 取消所有变换效果 */
  transform: none;
}



.text-slider {
  display: flex;
  align-items: center;
  justify-content: center;
  /* 设置主轴方向为垂直 */
  flex-direction: column;
}


.text-wrap {
  max-height: 2.2rem;
  overflow: hidden;
  margin-bottom: 2.5rem;
}


.text-group {
  display: flex;
  flex-direction: column;
  text-align: center;
  /* 初始位置为不偏移 */
  transform: translateY(0);
  /* 过渡效果为0.5秒 */
  transition: 0.5s;
}

.text-group h2 {
  line-height: 2.2rem;
  font-weight: 600;
  font-size: 1.6rem;
}


.bullets {
  margin-top: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.bullets span {
  display: block;
  width: 0.5rem;
  height: 0.5rem;
  border-radius: 0.2rem;
  background-color: white;
  box-shadow: 20px #b7b2a9;
  margin: 0 0.25rem;
  cursor: pointer;
  transition: .3s;
}

.bullets span.active {
  width: 1.1rem;
  background-color:aqua;
  border-radius: 1rem;
}


/* 当屏幕宽度小于等于850px时生效 */
@media (max-width:850px) {
  .box {
      height: auto;
      max-width: 550px;
      overflow: hidden;
  }

  .inner-box {
      /* 位置为默认值 */
      position: static;
      transform: none;
      /* 宽搞为默认值 */
      width: revert;
      height: revert;
      padding: 2rem;
  }

  .forms-wrap {
      /* 位置为默认值 */
      position: revert;
      width: 100%;
      height: 100%;
  }

  .form {
      /* 最大宽度为默认值 */
      max-width: revert;
      padding: 1.5rem 2.5rem 2rem;
      transition: transform 0.8s ease-in-out, opacity 0.4s linear;
  }


  .heading {
      margin: 2rem 0;
  }

  form.sign-up-form {
      transform: translateX(100%);
  }

  main.sign-up-mode form.sign-in-form {
      transform: translateX(-100%);
  }
  main.sign-up-mode form.sign-up-form {
      transform: translateX(0%);
  }

  .carousel {
      position: revert;
      height: auto;
      width: 100%;
      padding: 3rem 2rem;
      display: flex;
  }

  .images-wrapper {
      /* 隐藏 */
      display: none;
  }

  .text-slider {
      width: 100%;
  }
}


/* 当屏幕宽度小于等于530px时生效 */
@media (max-width:530px) {
  main {
      padding: 1rem;
  }

  .box {
      border-radius: 2rem;
  }

  .inner-box {
      padding: 1rem;
  }

  .carousel {
      padding: 1.5rem 1rem;
      border-radius: 1.6rem;
  }

  .text-wrap {
      margin-bottom: 1rem;
  }

  .text-group h2 {
      font-size: 1.2rem;
  }

  form {
      padding: 1rem 2rem 1.5rem;
  }
}


</style>