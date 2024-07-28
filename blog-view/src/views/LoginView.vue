<template>
  <div :xl="6" :lg="7"  class="container">
    <div class="main">
        <!-- 整个注册盒子 -->
      <div class="loginbox">
          <!-- 左侧的注册盒子 -->
          <div class="loginbox-in">
            <div class="userbox"> 
            <span class="iconfont">&#xe623;</span> 
            <input  class="user" id="user"   v-model="name" placeholder="用户名">
            </div>
          <br>
            <div class="pwdbox">
              <span class="iconfont">&#xee16;</span>
            <input  class="pwd" id ="password" type="password"  v-model="pwd" placeholder="密码">
            </div> 
          <br>            
            <!-- 验证码盒子 -->
            <div class="codebox">
              <el-image :src="codeImg" class="codeImg"></el-image>
              <input  class="code" id="code" placeholder="验证码">
            </div>
            <button type="primary"  class="register_btn" @click="register">若无账号点此注册</button>

            <br>
            <button type="primary"  class="login_btn" @click="login">Login</button>
  
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
      name:'',
      pwd:'',
      codeImg:null,
      code:'',
      user_list:[
      { 
        id:'1',
        username:'admin',
        password:'123'
      },
      ]
     
    }
  },
    
  methods:{
   
    register(){  this.$router.push("Register")},

    login(){
        let flag=0;
        //如果是有参数传递
        if(!this.$route.query.list){
        this.user_list.forEach((item) => {
         if(item.username==this.name){
           if(item.password==this.pwd){
            flag=1;//用户存在，并且密码正确
          }
         }
        }
      )
      if(flag==1){
        //可以跳转到主页
        this.$router.push("home");
      }
      else{
        alert("用户名或密码错误，请重新输入");
      }
      }
      else{
        // 取到路由带过来的参数
        let routerParams = this.$route.query.list;
        this.user_list = routerParams;
        this.user_list.forEach((item) => {
         if(item.username==this.name){
           if(item.password==this.pwd){
            flag=1;//用户存在，并且密码正确
           }
         }
        }
      )
      if(flag==1){
        //可以跳转到主页
        // this.$router.push("Homepage");
        this.$router.push({
            path: 'home',
          }
        )
      }
      else{
        alert("用户名或密码错误，请重新输入");}
      }
    },

  },
   
   
}
</script>

<style scoped>

.container{
  height: 100vh;
  background-image: url(../assets/login.jpg);
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
.userbox{
    margin-top:90px ;
    height:30px;
    width:230px;
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
  /* 修改默认背景框的颜色 */
 box-shadow: 0 0 0px 1000px #98caf16c inset !important;
 /* 修改默认字体的颜色 */
 -webkit-text-fill-color:#49a5cf;
} 

input:-webkit-autofill::first-line {
  /* 修改默认字体的大小 */
 font-size: 15px;
 /* 修改默认字体的样式 */
 font-weight:bold;
 }

.login_btn{
 
    background-color: #49a5cf; 
    border: none;
    color: #FAFAFA;
    padding: 5px 22px;
    text-align: center;
    text-decoration: none;
    font-size: 13px;
    border-radius: 20px;
    margin-top: 80px;
    margin-left: 140px;
    outline:none;
}
.login_btn:hover{
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
    cursor: pointer;
    background-color: #1955d7;
    transition: all 0.2s ease-in;
}


.register_btn{
    background-color: transparent;
    border: none;
    text-decoration: none;
    font-size: 12px;
    color: #49a5cf87;
    font-size:12px;
    margin-top: 5px;
    text-decoration:underline;
    outline:none;
    
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