const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  devServer: {
    port: 8188
  },
  devServer: {
    proxy: {
      '/api': {
        target: 'http://127.0.0.1:8818',
        ws: true,
        changeOrigin: true
      }
    }
  },
  transpileDependencies: true
})
