import axios from '@/plugins/axios'

export function login(loginForm){
  const { username, password } = loginForm; // 解构赋值
    return axios({
        url: '/api/v1/user/login',
        method: 'post',
        data: {
            username,
            password, // 将解构赋值得到的值作为参数传递
        }
    })


}
