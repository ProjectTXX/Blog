<template>
  <div class="container">
    <div class="main">
        <!-- 整个注册盒子 -->
      <div class="loginbox">
          <!-- 左侧的注册盒子 -->
          <div class="loginbox-in">
            <div class="idbox"> 
            <span class="iconfont">&#xe623;</span> 
            <input  class="id" id="id"  v-model="id" placeholder="昵称">
            </div>
            <br>
            <div class="userbox">
            <span class="iconfont">&#xe623;</span> 
            <input  class="user" id="user"  v-model="name" placeholder="用户名">
            </div>
          <br>
            <div class="pwdbox">
              <span class="iconfont">&#xee16;</span>
            <input  class="pwd"  id="password" v-model="pwd" type="password"  placeholder="密码">
            </div>
          <br>
            <div class="pwdbox">
              <span class="iconfont">&#xee16;</span>
            <input  class="pwd"  id="re_password"  v-model="repwd" type="password"  placeholder="确认密码">
            </div>
           <br>
            <!-- 验证码盒子 -->
            <div class="codebox">
              <el-image :src="codeImg" class="codeImg"></el-image>
              <input  class="code" id="code" placeholder="验证码">
            </div>
           <br>
           <button type="primary"  class="login_btn" @click="login">已有账号点此登录</button>
           <br>
           <button type="primary"  class="register_btn" @click="register">Register</button>
     </div>
 
        <!-- 右侧的盒子 -->
         <div class="background">
            <div class="title">Welcome to Our Blog of Daily Study!</div>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "LoginView",
  data:function (){
    return{
      id:'',
      name:'',
      pwd:'',
      repwd:'',
      codeImg:null,
      code:'',
      user_list:[
      { 
        username:'admin',
        password:'123'
      },

      ]
    }
  },
  methods:{
    login(){
      this.$router.push('login')
    },
    register(){  
      let flag=1;
      //如果用户名已存在，则需要换一个用户名
      this.user_list.forEach((item) => {
         if(item.username==this.name){
           alert('用户已存在,请换一个用户名');
           flag=0;
         }
        }
      )
      //如果用户名不存在，则继续判断
      if(flag){
        //判断两次输入的密码是否一致，如果密码不一致，则需要重新输入
        if(this.pwd!=this.repwd){
        alert('两次输入的密码不一致,请重新输入');
        }
        //如果密码也一直，则存到用户列表里面
        else {
          var item ={};
          //获取到用户名
          item.username=this.name;
          //获取到密码
          item.password=this.pwd;
          //存储到用户列表
          this.user_list.push(item);
          alert('注册成功');
        //    this.user_list.forEach((item) => {
        //       console.log( item.username);
        // })
        
          this.$router.push({
            path: '/',
            query: {
              list: this.user_list,}
          })
        }
      }
      
    }
  }
}
</script>

<style scoped>


.container{
  height: 100vh;
  background-image: url(../assets/register.jpg);
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
}

.loginbox{
    display:flex;
    position:absolute;
    width:800px;
    height:400px;
    top:40%;
    left:50%;
    transform:translate(-50%,-50%);
    box-shadow: 0 12px 16px 0  rgba(0,0,0,0.24), 0 17px 50px 0 #4E655D;
}
.loginbox-in{
     background-color:#98caf16c;
     width:240px;
}
.idbox{
    margin-top: 50px;
    height:30px;
    width:225px;
    display: flex;
    margin-left:18px;
}
.userbox{
    height:30px;
    width:225px;
    display: flex;
    margin-left:18px;
}
.pwdbox{ 
    height:30px;
    width:225px;
    display: flex;
    margin-left:18px;
}
.codebox{
    height:30px;
    width:225px;
    display: flex;
    margin-left:18px;
}
.codeImg {
  border-radius: 3px;
  width: 40%;
}
.background{
    width:570px;
    background-color: #ffffff00;
    background-size:cover;
    font-family:sans-serif;
}
.title{
    margin-left: 15px;
    margin-top:320px;
    font-weight:bold;
    font-size:20px;
    color:#49a5cf;   
}
.title:hover{
     font-size:30px;
     transition: all 0.4s ease-in-out;
     cursor: pointer;
}
.uesr-text{
     position:left;
}
input{
    outline-style: none ;
    border: 0;
    border-bottom:1px solid #E9E9E9;
    background-color:transparent;
    height:20px;
     font-family:sans-serif;
    font-size:15px;
    color:#49a5cf;
    font-weight:bold;
}
 /* input::-webkit-input-placeholder{
    color:#E9E9E9;
 } */
input:focus{
    border-bottom:2px solid #4b7bbf;
    background-color:transparent;
     transition: all 0.2s ease-in;
     font-family:sans-serif;
    font-size:15px;
    color:#49a5cf;
     font-weight:bold;
     
}
input:hover{
    border-bottom:2px solid #4b7bbf;
    background-color:transparent;
     transition: all 0.2s ease-in;
     font-family:sans-serif;
    font-size:15px;
    color:#49a5cf;
     font-weight:bold;
     
}
 
input:-webkit-autofill {
 box-shadow: 0 0 0px 1000px #98caf16c inset !important;
 -webkit-text-fill-color: #4b7bbf;

} 

input:-webkit-autofill::first-line {
 font-size: 15px;
 font-weight:bold;
 }
.log-box{
    font-size:12px;
    display: flex;
    justify-content: space-between ;
    width:174px;
    margin-left:30px;
    color:#4E655D;
    margin-top:-5px;
    align-items: center;
   
}

.login_btn{
    background-color: transparent; 
    border: none;
    text-decoration: none;
    font-size: 12px;
    color: #2aa6e0af;
    font-size:12px;
    margin-top: 5px;
    text-decoration:underline;
    outline:none;
}
.login_btn:hover{
    font-weight:bold;
    cursor: pointer;
}

.register_btn{
    background-color: #49a5cf;
    border: none;
    color: #FAFAFA;
    padding: 7px 30px;
    text-align: center;
    text-decoration: none;
    font-size: 13px;
    border-radius: 20px;
    margin-top: 20px;
    margin-left: 110px;
    outline:none;
}
.register_btn:hover{
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
    cursor: pointer;
     background-color: #1955d7;
    transition: all 0.2s ease-in;
}

.warn{
    margin-top:60px;
    margin-right:110px;
    margin-bottom: 5px;
    font-weight:bold;
    font-size:17px;
}


.register_btn:hover{
    font-weight:bold;
    cursor: pointer;
}
@font-face {
  font-family: "iconfont"; /* Project id 4612607 */
  src: url('./iconfont/iconfont.woff2?t=1721552581805') format('woff2'),
       url('./iconfont/iconfont.woff?t=1721552581805') format('woff'),
       url('./iconfont/iconfont.ttf?t=1721552581805') format('truetype');
}
.iconfont {
    font-family: "iconfont" !important;
    font-size: 20px;
    font-style: normal;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    height:22px;
    color:#4E655D;
    margin-right:10px;
    margin-top:3px;
}

.icon-key:before {
    content: "\e775";
}

.icon-account:before {
    content: "\e817";
}

</style>