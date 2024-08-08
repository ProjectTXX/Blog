import axios from '@/plugins/axios'; 

export default function sendVercode(email) {
  return axios({
    url: '/api/v1/user/code',
    method: 'get',
    params: {
      email
    }
  
  })
}