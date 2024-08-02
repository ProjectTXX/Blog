const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: {
      '/api': {
        target:'http://7ad7a648.r19.cpolar.top',
        changeOrigin: true,
        pathRewrite: {
          '^/api': '/api'
        }
      }
    },//解决跨域问题
    port: 80,  //指定端口号
    //allowedHosts: 'all', 
    //disableHostCheck: true, //解决Invalid Host header
  }
})