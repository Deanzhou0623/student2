// File | Settings | Languages & Frameworks | JavaScript | Webpack 配置
// 让webstorm支持别名解析
// 类似vs中的jsconfig.json,作用都仅仅是为了能让ide自动跳转
const path = require('path')

module.exports = {
  context: path.resolve(__dirname, './'),
  resolve: {
    extensions: ['.js', '.vue', '.json'],
    alias: {
      '@': path.resolve('src'),
    }
  }
}
