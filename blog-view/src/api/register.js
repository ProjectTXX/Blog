import axios from "@/plugins/axios"

export function register(registerForm) {
  return axios({
    url: "api/v1/user/register",
    method: "POST",
    data: {
      registerForm
    }
  })
}