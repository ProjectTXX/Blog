import axios from "@/plugins/axios"

export function login(loginForm) {
  return axios({
    url: "api/v1/user/login",
    method: "POST",
    data: {
      loginForm
    }
  })
}
