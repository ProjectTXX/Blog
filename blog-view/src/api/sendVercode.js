import request from '@/plugins/axios'; 

export default function sendVercode(email) {
  return request({
    url: '/api/v1/user/code',
    method: 'get',
    data: {
      email
    }
  
  })
}