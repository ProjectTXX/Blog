import axios from "axios";

const request = axios.create({
  baseURL: "http://7ad7a648.r19.cpolar.top",
  timeout: 10000
})


export default request