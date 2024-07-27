import axios from '@/plugins/axios'

export function login(loginForm) {
	return axios({
		url: 'user/login',
		method: 'POST',
		data: {
			...loginForm
		}
	})
}
