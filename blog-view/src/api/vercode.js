import axios from "@/plugins/axios"

export function vercode(vercodeForm) {
  return axios({
    url: "api/v1/user/code",
    method: "GET",
    data: {
      vercodeForm
    }
  })
}
