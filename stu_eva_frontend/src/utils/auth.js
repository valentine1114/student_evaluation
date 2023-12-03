import axios from 'axios';
const AccessTokenKey = 'ACCESS_TOKEN'
const RefreshTokenKey = 'refreshToken'

const API_BASE_URL = 'http://127.0.0.1:8818';
// ========== Token 相关 ==========

export function getAccessToken() {
  return localStorage.getItem(AccessTokenKey)
}
export function getRefreshTokenKey() {
  return localStorage.getItem(RefreshTokenKey)
}

export function setToken(token, refreshToken) {
  localStorage.setItem(AccessTokenKey, token)
  localStorage.setItem(RefreshTokenKey, refreshToken)

}

function updateAccessToken(newToken) {
  localStorage.setItem(AccessTokenKey, newToken);
}


export function removeToken() {
  console.log('removeToken')
  localStorage.removeItem(AccessTokenKey)
}

import jwt_decode from 'jwt-decode';

export function isTokenExpired(token) {
  if (!token) {
    return true;
  }
  try {
    const decoded = jwt_decode(token);
    return decoded.exp < Date.now() / 1000;
  } catch (err) {
    return true;
  }
}
export function isRefreshTokenExpired(refreshToken) {
  if (!refreshToken) {
    return true;
  }
  try {
    const decoded = jwt_decode(refreshToken);
    return decoded.exp < Date.now() / 1000;
  } catch (err) {
    return true;
  }
}
// function refreshToken() {
//   axios.post('/refreshToken', {
//     refreshToken: localStorage.getItem('refreshToken')
//   }).then(response => {
//     localStorage.setItem('token', response.data.accessToken);
//     localStorage.setItem('refreshToken', response.data.refreshToken);
//   }).catch(error => {
//     // 处理刷新Token失败或者RefreshToken过期的情况
//   });
// }
async function refreshToken() {
  try {
    // const refreshToken = getRefreshTokenKey(); // 从localStorage中获取刷新令牌
    const response = await axios.post('/refreshToken', {
      refreshToken: localStorage.getItem('refreshToken')
    })
    const { accessToken } = response.data.accessToken; // 从响应中获取新的访问令牌
    return accessToken;
  } catch (error) {
    throw error; // 处理刷新令牌失败的情况
  }
}
function setAuthorizationHeader(token) {

  axios.defaults.headers.Authorization = 'Bearer ' + token;
}

// export function refreshToken(refreshTokenOld) {
//   console.log("aaaaa")
//   let data = new FormData();
//   data.append('refreshToken', refreshTokenOld)
//   const res = axios.defaults.baseURL.post(`/refreshToken`, data);
//   console.log(res.data);
  // return axios.post(`${API_BASE_URL}/refreshToken`, data)
  //   .then(response => {
  //     const response = axios.post(`${API_BASE_URL}/upload`, formData, config);
  //     console.log(response.data);
  //     console.log(response)
  //     setToken(response.data.accessToken, response.data.refreshToken);
  //     console.log('Token refreshed!!!!');
  //   })
  //   .catch(error => {
  //     console.log('Failed to refresh token:', error);
  //   });

// export const refreshToken = async () => {
//   const refreshTokenOld = localStorage.getItem(RefreshTokenKey);
//   console.log("refreshToken")
//   // 发起POST请求到后端的/refreshToken地址
//   let data = new FormData();
//   data.append('refreshToken', refreshTokenOld)
//   const response = await axios.post(`${API_BASE_URL}/refreshToken`, data);
//   setToken(response.data.accessToken, response.data.refreshToken);
//   console.log('Token refreshed!!!!');
  // await axios.post(`${API_BASE_URL}/refreshToken`, data)
  //   .then(response => {
  //     console.log(response)
  //     // 设置新的Token和RefreshToken
  //     setToken(response.data.accessToken, response.data.refreshToken);
  //     console.log('Token refreshed!!!!');

  //   })
  //   .catch(error => {
  //     // 处理刷新失败错误
  //     console.error('刷新Token失败', error);

  //   });
// }