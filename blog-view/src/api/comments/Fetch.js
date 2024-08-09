import axios from "@/plugins/axios"

export function Fetch(CommentForm) {
  return axios({
    url: "api/v1/comment/fetch",
    method: "GET",
    data: {
      CommentForm
    }
  })
}
