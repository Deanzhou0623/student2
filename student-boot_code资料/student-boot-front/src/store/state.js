import { getItem } from '@/storage'
import { USER_INFO_KEY } from '@/config/constants'

const state = {
  userInfo: getItem(USER_INFO_KEY) ? JSON.parse(getItem(USER_INFO_KEY)) : {
    id: -1,
    userName: ''
  },
  // 打开的tabs数组
  openedTabs: [
    {
      // 当前tab对应的route路径
      path:'/index',
      // tab的名字
      text:"首页",
      // 当前tab对应的route全路径
      fullPath:"/index"
    }
  ]
}

export default state
