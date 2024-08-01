<template>
  <div class="container" :class="{ 'right-panel-active': isSignup }">
    <SigninForm />
    <SignupForm />
    <div class="container_overlay">
      <div class="overlay">
        <div class="overlay_panel overlay--left">
          <button class="btn" @click="togglePanel">已有账号，直接登录</button>
        </div>
        <div class="overlay_panel overlay--right">
          <button class="btn" @click="togglePanel">没有账号，点击注册</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import SigninForm from './components/SigninForm.vue';
import SignupForm from './components/SignupForm.vue';

export default {
  components: {
    SigninForm,
    SignupForm,
  },
  data() {
    return {
      isSignup: false
    };
  },
  methods: {
    togglePanel() {
      this.isSignup = !this.isSignup;
    }
  }
};
</script>
