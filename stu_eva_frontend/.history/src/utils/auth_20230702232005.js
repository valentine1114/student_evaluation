import axios from 'axios';
const AccessTokenKey = 'ACCESS_TOKEN'

// ========== Token 相关 ==========

export function getAccessToken() {
  return localStorage.getItem(AccessTokenKey)
}


export function setToken(token, refreshToken) {
  localStorage.setItem(AccessTokenKey, token)
  localStorage.setItem(RefreshTokenKey, refreshToken);

}

function refreshToken() {
  axios.post('/refreshToken', {
    refreshToken: localStorage.getItem('RefreshTokenKey')
  }).then(response => {
    setToken(response.data.accessToken, response.data.refreshToken);
    // localStorage.setItem('token', response.data.token);
    // localStorage.setItem('refreshToken', response.data.refreshToken);
  }).catch(error => {
    // 处理刷新Token失败或者RefreshToken过期的情况
  });
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