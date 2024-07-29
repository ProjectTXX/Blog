const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    port: 80,  //指定端口号
    https: false, //是否启用https
    disableHostCheck: true, //解决Invalid Host header
  }
})
