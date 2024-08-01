<template>
  <div class="slider-box">
    <div class="outer" ref="outer">
    <div class="masklayer" ref="maskLayer"></div>
    <div class="textC" ref="textC">请将滑块滑动至最右侧</div>
    <div class="slider-btn" ref="btn">&gt;&gt;</div>
  </div>
  </div>
</template>

<script>
export default {
  name: 'SliderVerification',
  mounted() {
    this.$nextTick(() => {
      this.btnSlide();
    });
  },
  methods: {
    btnSlide() {
      let bx = 0;
      const outer = this.$refs.outer;
      const outerOffsetW = outer.offsetWidth;
      const btn = this.$refs.btn;
      const bOffsetW = btn.offsetWidth;
      const maskLayer = this.$refs.maskLayer;
      let initialMouseX;

      btn.onmousedown = (e) => {
        initialMouseX = e.clientX;

        document.onmousemove = (e) => {
          if (!outer.classList.contains('success')) {
            const moveX = e.clientX - initialMouseX;
            bx += moveX;
            bx = Math.max(0, Math.min(bx, outerOffsetW - bOffsetW));
            maskLayer.style.width = bx + 'px';
            btn.style.left = bx + 'px';
            initialMouseX = e.clientX;
          }
        };

        document.onmouseup = () => {
          if (bx >= outerOffsetW - bOffsetW) {
            const textC = this.$refs.textC;
            textC.innerText = '验证通过';
            btn.innerText = '';
            outer.classList.add('success');
            this.$emit('verification-success');
          } else {
            bx = 0;
            maskLayer.style.width = bx + 'px';
            btn.style.left = bx + 'px';
          }
          document.onmousemove = null;
          document.onmouseup = null;
        };
      };
    }
  }
};
</script>

<style scoped>
.outer {
  position: relative;
  width: 310px;
  height: 40px;
  border: 1px solid #ccc;
  margin: 15px 0;
  overflow: hidden;
  border-radius: 3px;
}

.masklayer,
.textC,
.slider-btn {
  position: absolute;
}

.masklayer {
  width: 0;
  height: 100%;
  background-color: #e8e8e8;
  transition: width 0.3s;
}

.textC {
  width: 100%;
  height: 100%;
  text-align: center;
  line-height: 40px;
  color: #666;
  background-color: #f7f7f7;
}

.slider-btn {
  width: 40px;
  height: 100%;
  line-height: 40px;
  text-align: center;
  user-select: none;
  cursor: pointer;
  background-color: #fff;
  border: 1px solid #ccc;
  box-shadow: 0 0 3px rgba(0, 0, 0, 0.2);
}

.slider-btn:active {
  background-color: #e9e9e9;
}

.outer.success .masklayer {
  background-color: #7cb305;
}

.outer.success .textC {
  background-color: #fff;
  color: #7cb305;
}

.outer.success .slider-btn {
  border-color: #7cb305;
  background-repeat: no-repeat;
  background-position: center;
  background-color: #28a745;
  cursor: default;
}

.outer.success .slider-btn:after {
  content: '✔';
  color: white;
  position: absolute;
  right: 10px;
  top: 50%;
  transform: translateY(-50%);
  font-size: 1.2em;
}
</style>
