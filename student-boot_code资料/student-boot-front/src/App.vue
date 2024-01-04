<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { saveItem } from '@/storage'
import { USER_INFO_KEY } from '@/config/constants'

export default {
  name: 'App',
  computed:{
    // 可以简化为mapXxx
    // userInfo(){
    //   return this.$store.getters.userInfo
    // }
    ...mapGetters(["userInfo"])
  },
  methods:{
    saveUserInfo(){
      saveItem(USER_INFO_KEY,this.userInfo)
    }
  },
  mounted () {
    // 页面销毁(比如刷新)之前会调用指定的回调,
    window.addEventListener("unload",this.saveUserInfo)
  }
}
</script>

<style>
  html,body,#app {
    height: 100%;
    margin: 0;
    padding: 0;
  }
</style>
