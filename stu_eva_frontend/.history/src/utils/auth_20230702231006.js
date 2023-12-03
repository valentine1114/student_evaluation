
const AccessTokenKey = 'ACCESS_TOKEN'

// ========== Token 相关 ==========

export function getAccessToken() {
  return localStorage.getItem(AccessTokenKey)
}


export function setToken(token) {
  localStorage.setItem(AccessTokenKey, token)
  localStorage.setItem('refreshToken', response.data.refreshToken);
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