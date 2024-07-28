<template>
  <div id="app">
    <!-- 路由界面 -->
    <router-view/>
  </div>
</template>

<style>

/* 重置body属性 */
body{
  margin: 0;
  padding: 0;
  /* height: 100%; */
  /* font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif; */
}

/* 全局字体 */
*{
  font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
}
/* 全局链接去下划线 */
a{
  text-decoration: none;
}
button{
  /* 清除默认边框 */
  border: 0;
  outline: none;
  /*清除默认背景 */
  background-color: transparent;
}
</style>
