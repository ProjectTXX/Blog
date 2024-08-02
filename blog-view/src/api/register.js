import request from '@/plugins/axios'; 

export function register(RegisterForm) {
  const { username, password, email, code } = RegisterForm;
  
  return request({
    url: '/api/v1/user/register',
    method: 'post',
    data: {
      username,
      password,
      email,
      code
    }
  });
}