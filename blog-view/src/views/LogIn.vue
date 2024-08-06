<template>
  <!-- 整体布局 -->
  <div class="login">
    <div class="box">
      <!-- 注册框 -->
      <div class="signup l">
        <form @submit.prevent="handleRegister">
          <h2>注册账号</h2>
          <input type="text" v-model="username" placeholder="Username" />
          <input type="password" v-model="password" placeholder="Password" />
          <input type="email" v-model="email" placeholder="QQ Mailbox" />
          <!-- 验证码 -->
          <div class="verification">
            <div class="test">
              <label>验证码:</label>
              <button
                type="button"
                :disabled="disableBtn"
                @click="sendCode"
                :class="{ disabled: disableBtn }"
              >
                {{ btnText }}
              </button>
            </div>
            <input type="text" placeholder="请输入验证码" v-model="vercode" />
          </div>
          <button>点击注册</button>
        </form>
      </div>
      <!-- 登录框 -->
      <div class="signup r">
        <form @submit.prevent="handleLogin">
          <h2>欢迎登录</h2>
          <input type="text" v-model="username" placeholder="Username" />
          <input type="password" v-model="password" placeholder="Password" />
          <!-- 图片验证码 -->
          <div class="imgcode">
            <canvas
              @click="refresh()"
              ref="captchaCanvas"
              :width="width"
              :height="height"
            ></canvas>
            <input type="text" v-model="userInput" placeholder="请输入验证码" />
          </div>
          <button>登录</button>
        </form>
      </div>
    </div>
    <div class="cover" :class="{ rmove: isremove, lmove: !isremove }">
      <div class="case left" :style="{ opacity: risopacity }">
        <button @click="move('left')">已有账号，直接登录</button>
      </div>
      <div class="case right" :style="{ opacity: lisopacity }">
        <button @click="move('right')">没有账号，点击注册</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      // 图片验证码
      userInput: "",
      captcha: "",
      width: 200,
      height: 60,
      chars: "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789",
      size: 4,
      fonts: ["sans-serif", "serif", "monospace"],
      colors: [
        "black",
        "gray",
        "navy",
        "maroon",
        "darkgreen",
        "olive",
        "purple",
        "teal",
      ],
      lineCount: 5,
      noiseLevel: 0.1,

      // axios
      username: "",
      password: "",
      email: "",
      vercode: "",

      // 页面渲染
      isremove: false,
      risopacity: 0,
      lisopacity: 1,
      disableBtn: false, // 按钮是否禁用
      count: 60, // 倒计时秒数
      btnText: "发送验证码",
    };
  },
  mounted() {
    this.generateCaptcha();
  },
  methods: {
    generateCaptcha() {
      const ctx = this.$refs.captchaCanvas.getContext("2d");
      ctx.clearRect(0, 0, this.width, this.height);

      let captcha = "";
      for (let i = 0; i < this.size; i++) {
        captcha += this.chars.charAt(
          Math.floor(Math.random() * this.chars.length)
        );
      }
      const fontSize = 20; // 设置字体大小
      const xOffset = this.width / (this.size + 1); // 计算每个字符的水平偏移量
      const yOffset = this.height / 2 + fontSize / 2; // 垂直居中对齐

      for (let i = 0; i < captcha.length; i++) {
        ctx.save();
        ctx.font = `${fontSize}px ${
          this.fonts[Math.floor(Math.random() * this.fonts.length)]
        }`;
        ctx.fillStyle =
          this.colors[Math.floor(Math.random() * this.colors.length)];
        ctx.textBaseline = "middle";
        ctx.textAlign = "center";
        const x = xOffset * (i + 1); // 增加水平偏移量
        const y = yOffset;
        ctx.fillText(captcha[i], x, y);
        ctx.restore();
      }
      // 添加干扰线和噪点
      for (let i = 0; i < this.lineCount; i++) {
        ctx.beginPath(); // 开始新的路径
        ctx.moveTo(Math.random() * this.width, Math.random() * this.height);
        ctx.lineTo(Math.random() * this.width, Math.random() * this.height);
        ctx.stroke();
        ctx.closePath(); // 关闭路径
      }
      for (let i = 0; i < this.width * this.height * this.noiseLevel; i++) {
        ctx.fillStyle = "#eee";
        ctx.fillRect(
          Math.random() * this.width,
          Math.random() * this.height,
          1,
          1
        );
      }

      this.captcha = captcha;
    },
    validateCaptcha() {
      return this.userInput.toLowerCase() === this.captcha.toLowerCase();
    },
    refresh() {
      this.generateCaptcha();
    },
    move(e) {
      if (e === "right") {
        this.isremove = true;
        this.risopacity = 1;
        this.lisopacity = 0;
      } else {
        this.isremove = false;
        this.risopacity = 0;
        this.lisopacity = 1;
      }
    },
    handleRegister(event) {
      event.preventDefault();
      if (
        this.username === "" ||
        this.password === "" ||
        this.email === "" ||
        this.vercode === ""
      ) {
        alert("请填空");
        return;
      }
      axios
        .post(" http://2f1dd179.r19.cpolar.top/api/v1/user/register", {
          username: this.username,
          password: this.password,
          email: this.email,
          vercode: this.vercode,
        })
        .then((response) => {
          console.log(response.data);
          if (response.data.code === 200) {
            this.$router.push("/home");
          } else if (response.data.code === 500) {
            alert("账号已存在");
          } else {
            alert("验证码错误");
            this.vercode = "";
          }
        })
        .catch((error) => {
          console.error(error);
        });

      axios
        .post(" http://2f1dd179.r19.cpolar.top/api/v1/user/login", {
          username: this.username,
          password: this.password,
        })
        .then((response) => {
          console.log(response.data);
          if (response.data.code === 200) {
            this.$router.push("/home");
          } else {
            alert("密码或用户名错误");
            this.username = "";
            this.password = "";
          }
        })
        .catch((error) => {
          alert("error");
          console.error(error);
        });
    },
    handleLogin(event) {
      event.preventDefault();
      if (!this.validateCaptcha()) {
        alert("验证码错误，请重新输入");
        this.refresh();
        this.userInput = "";
        return;
      }
      axios
        .post(" http://2f1dd179.r19.cpolar.top/api/v1/user/login", {
          username: this.username,
          password: this.password,
        })
        .then((response) => {
          console.log(response.data);
          if (response.data.code === 200) {
            this.$router.push("/home");
          } else {
            alert("密码或用户名错误");
            this.username = "";
            this.password = "";
          }
        })
        .catch((error) => {
          alert("error");
          console.error(error);
        });
    },
    sendCode() {
      if (this.disableBtn) return;
      if (this.email === "") {
        alert("验证码不能为空");
        return;
      }
      alert("已发送验证码");
      this.disableBtn = true;
      const timer = setInterval(() => {
        this.count--;
        this.btnText = `${this.count}秒后重试`;
        if (this.count === 0) {
          clearInterval(timer);
          this.disableBtn = false;
          this.btnText = "发送验证码";
          this.count = 60;
        }
      }, 1000);
      axios
        .get("http://7ad7a648.r19.cpolar.top/api/v1/user/code", {
          params: {
            email: this.email,
          },
        })
        .then((response) => {
          console.log(response.data);
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
};
</script>

<style lang="less"  scoped>
.disabled {
  background-color: #ccc !important;
  cursor: not-allowed;
}
.rmove {
  transform: translateX(50%);
}
.lmove {
  transform: translateX(-50%);
}
.login {
  height: 100vh;
  display: flex;
  background: url("../assets/2.jpg") no-repeat center center fixed;
  background-size: cover;
  background-attachment: fixed;
  position: relative;
  .box {
    flex-grow: 1;
    transition: all 0.5s ease-in-out;
    border-radius: 8px;
    background-color: #fff;
    width: 741px;
    height: 480px;
    display: flex;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    box-shadow: 0 10px 15px rgba(0, 0, 0, 12.1);
    .l {
      position: absolute;
      z-index: 10;
    }
    .signup {
      position: relative;
      z-index: 10;
      padding: 20px;
      width: 50%;
      .test {
        display: flex;
        label {
          padding: 8px;
        }
        button {
          width: 150px !important;
        }
      }
      input {
        margin: 10px;
      }
      h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
      }
      input,
      button {
        width: 100%;
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
      }
      button {
        background-color: #007bff;
        color: #fff;
        cursor: pointer;
        transition: background-color 0.3s;
        &:hover {
          background-color: #0056b3;
        }
      }
    }
  }
  .cover {
    position: absolute;
    width: 741px;
    height: 480px;
    display: flex;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    margin: auto;
    overflow: hidden;
    // transition: transform 0.5s ease-in-out;

    .case {
      width: 50%;
      height: 100%;
      display: flex;
      background: url(../assets/3.jpg);
      background-size: cover;
      background-repeat: no-repeat;
      justify-content: center;
      align-items: center;
      // transition: opacity 0.3s ease-in-out;
      button {
        width: 80%;
        padding: 12px;
        font-size: 18px;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        transition: background-color 0.3s, color 0.3s;
        background-color: #007bff;
        color: #ffffff;
        &:hover {
          background-color: #0056b3;
        }
      }
    }
    .left {
      background-position: right center;
    }

    .right {
      background-position: left center;
    }
  }
}
</style>