import Vue from 'vue'
import App from './App.vue'
import router from '@/router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import plugins from '@/plugins/plugins'
import store from '@/store'

Vue.config.productionTip = false

// 引入ElementUI
Vue.use(ElementUI,{size:'small'})
Vue.use(plugins)
new Vue({
  render: h => h(App),
  router,
  store
}).$mount('#app')
