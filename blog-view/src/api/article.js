import axios from "axios";

export function getArticles(params) {
  return axios({
    url: '/api/v1/articles',
    method: 'get',
    params:params
  });

  
}