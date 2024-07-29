<template>
  <div class="container_form container--signin">
    <form @submit.prevent="handleSubmit" class="form">
      <h2 class="form_title">{{ forgotPassword ? '忘记密码' : '欢迎登录' }}</h2>
      <input v-model="username" type="text" :placeholder="forgotPassword ? '输入邮箱：' : '用户名：'" class="input" @input="validateEmail">
      <input v-model="password" type="password" :placeholder="forgotPassword ? '重设密码：' : '密码：'" class="input">
      <div v-if="forgotPassword" class="yzm">
        <input v-model="verificode" type="text" placeholder="请输入验证码" >
        <button type="button" :disabled="!isEmailValid" @click="sendVerificode" :class="{ enabled: isEmailValid }">{{ buttonText }}</button>
      </div>
      <a v-if="!forgotPassword" href="#" class="link" @click.prevent="toggleForgotPassword">忘记密码？</a>
      <button type="submit" class="btn">{{ forgotPassword ? '重置密码并登录' : '登录' }}</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      username: '',
      password: '',
      verificode: '',
      forgotPassword: false,
      isEmailValid: false,
      buttonText: '获取验证码',
      timer: null,
      countdown: 60
    };
  },
  methods: {
    validateEmail() {
      const re = /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
      this.isEmailValid = re.test(String(this.username).toLowerCase());
    },
    sendVerificode() {
      if (this.timer) return;

      axios.post('https://18a0afbd.r21.cpolar.top/api', { username: this.username })
        .then(response => {
          //处理成功的响应
          console.log(response.data);
        })
        .catch(error => {
          //处理失败的响应
          console.error('Error sending verificode:', error);
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
    toggleForgotPassword() {
      this.forgotPassword = !this.forgotPassword;
    },
    handleSubmit() {
      if (this.forgotPassword) {
        if (this.isEmailValid && this.password && this.verificode) {
          axios.post('/api/reset-password', {
            username: this.username,
            password: this.password,
            verificode: this.verificode
          })
          .then(response => {
            // 密码重置成功的响应
            alert('重设密码成功并登录！');
            console.log(response.data);
          })
          .catch(error => {
            // 密码重置失败的响应
            console.error('Error during password reset:', error);
          });
        } else {
          alert('请完整填写表单');
        }
      } else {
        if (this.username && this.password) {
          axios.post('https://18a0afbd.r21.cpolar.top/api/v1/user/login', {
            username: this.username,
            password: this.password
          })
          .then(response => {
            // 处理成功的响应
            alert('登录成功！');
            console.log(response.data);
          })
          .catch(error => {
            // 处理失败的响应
            console.error('Error during login:', error);
          });
        } else {
          alert('请完整填写表单');
        }
      }
    }
  }
};
</script>
