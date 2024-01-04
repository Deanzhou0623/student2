<template>
  <div class="main">
    <el-container class="outer-container">
      <el-header><header-com/></el-header>
      <el-container>
        <el-aside :width="asideWidth">
          <side-bar @update:asideWidth="updateAsideWidth"></side-bar>
        </el-aside>
        <el-main>
          <Tabs :opened-tabs="openedTabs"></Tabs>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
  import HeaderCom from '@/components/HeaderCom'
  import SideBar from '@/components/SideBar'
  import Tabs from '@/components/Tabs'
  export default {
    name: 'Main',
    data(){
      return {
        asideWidth: '200px'
      }
    },
    computed:{
      openedTabs(){
        return this.$store.getters.openedTabs
      }
    },
    methods:{
      // 接受子组件传来的值并更新asideWidth
      updateAsideWidth(val){
        this.asideWidth = val
      }
    },
    components:{
      HeaderCom,
      SideBar,
      Tabs
    }
  }
</script>

<style scoped>
  .el-header {
    background-color: #0a366b;
    color: #fff;
    padding-left: 0;
  }

  /*让aside高度充满屏幕+app.vue的高度也要设置成100%*/
  .main,.outer-container {
    height: 100%;
  }
  .el-aside{
    background-color: #003c7f;
  }

  .el-main {
    padding: 10px;
  }
</style>
