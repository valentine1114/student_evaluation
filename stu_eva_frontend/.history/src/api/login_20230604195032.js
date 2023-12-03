import request from '@/utils/request'

// 用户登录
export function login(number, capt) {
  console.log(number)
  const data = {
    number
  }
  console.log(data)
  return request({
    url: '/auth/login',
    method: 'post',
    data: data
  })
}


// 获取用户信息
export function getInfo() {
  return request({
    url: '/user/profile/get',
    method: 'get'
  })
}