import axios from "@/plugins/axios"

export function Add(CommentForm) {
  return axios({
    url: "api/v1/comment/add",
    method: "POST",
    data: {
      CommentForm
    }
  })
}
