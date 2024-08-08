import axios from "axios";

export function getViews(params) {
  return axios({
    url: '/api/v1/comment/fetch',
    method: 'get',
    params:params
  });

  
}