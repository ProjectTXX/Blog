<template>
  <div class="container_form container--signup">
    <form @submit.prevent="handleSignup" class="form">
      <h2 class="form_title">注册账号</h2>
      <input v-model="username" type="text" placeholder="输入用户名：" class="input" >
      <input v-model="password" type="password" placeholder="设置密码：" class="input">
      <input v-model="email" type="email" placeholder="输入邮箱：" class="input" @input="validateEmail">
      <div class="yzm">
        <input v-model="verificode" type="text" placeholder="请输入验证码">
        <button type="button" :disabled="!isEmailValid" @click="sendVerificode" :class="{ enabled: isEmailValid }">{{ buttonText }}</button>
      </div>
      <button type="submit" class="btn">注册</button>
    </form>
  </div>
</template>

<script>
import { register } from '@/api/register';
import { vercode } from '@/api/vercode';

export default {
  data() {
    return {
      username: '',
      email: '',
      password: '',
      verificode: '',
      isEmailValid: false,
      buttonText: '获取验证码',
      timer: null,
      countdown: 60
    };
  },
  methods: {
    validateEmail() {
      const re = /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
      this.isEmailValid = re.test(String(this.email).toLowerCase());
    },
    sendVerificode() {
      if (this.timer) return;

      vercode({
        params: {
          email:this.email
        }
      })
      .then(response => {
        // 处理成功的响应
        console.log(response.data);
      })
      .catch(error => {
        // 处理失败的响应
        console.error('发送验证码时出错：', error);
      });

      this.isEmailValid = false;
      this.buttonText = `${this.countdown}s后可再次发送`;
      this.timer = setInterval(() => {
        this.countdown--;
        this.buttonText = `${this.countdown}s后可再次发送`;

        if (this.countdown < 0) {
          clearInterval(this.timer);
          this.timer = null;
          this.countdown = 60;
          this.buttonText = '获取验证码';
          this.validateEmail(); 
        }
      }, 1000);
    },
    handleSignup() {
      if (this.username && this.isEmailValid && this.password && this.verificode) {

        register({
          username: this.username,
          email: this.email,
          password: this.password,
          verificode: this.verificode
        })
        .then(response => {
          alert('注册成功！');
          console.log(response.data);
        })
        .catch(error => {
          console.error('注册时错误：', error);
        });
      } else {
        alert('请完整填写表单');
      }
    }
  }
};
</script>

<style scoped>
@import '../assets/styles.css';
</style>