const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: {
      '/api1':{
      target: 'http://72eb6267.r21.cpolar.top',
      changeOrigin: true,   // 允许跨域
      ['/api1']:'',
      }
    },
    port: 80,  //指定端口号
    //disableHostCheck: false, //解决Invalid Host header
  }
})