import axios from '@/plugins/axios'; 

export function register(RegisterForm) {
 // const { username, password, email, code } = RegisterForm;
  
  return axios({
    url: '/api/v1/user/register',
    method: 'post',
    data: {
      ...RegisterForm
    }
  });
}