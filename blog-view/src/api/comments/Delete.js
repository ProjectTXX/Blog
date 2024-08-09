import axios from "@/plugins/axios"

export function Delete(CommentForm) {
  return axios({
    url: "api/v1/comment/delete",
    method: "POST",
    data: {
      CommentForm
    }
  })
}
