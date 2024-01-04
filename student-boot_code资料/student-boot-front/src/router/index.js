// 配置路由
import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '@/views/Login'
import Main from '@/views/Main'
import Index from '@/views/index/Index'
import StudentHome from '@/views/student/StudentHome'
import StudentManage from '@/views/student/StudentManage'
import ScoreHome from '@/views/score/ScoreHome'
import ScoreManage from '@/views/score/ScoreManage'
import AddScore from '@/views/score/AddScore'
import UpdateScore from '@/views/score/UpdateScore'
import { getItem } from '@/storage'
import { USER_TOKEN_KEY } from '@/config/constants'
/**
 * 引入nprogress的js和css后
 * 开始和结束分别调用Nprogress.start()和Nprogress.done()即可
 */
import Nprogress from 'nprogress'
import 'nprogress/nprogress.css'

Vue.use(VueRouter)

// 定义路由规则
const routes = [
  {
    path: '/',
    redirect:'/login'
  },
  {
    path: '/login',
    name: 'Login',
    component: Login,
    meta: {
      title: '登录'
    }
  },
  {
    // /score/manage
    path: '/',
    name: 'Main',
    component: Main,
    children:[
      {
        path: 'index',
        name: 'Index',
        component: Index,
        meta: {
          title: '首页'
        }
      },
      {
        // /student/manage
        path: 'student',
        name: 'StudentHome',
        component: StudentHome,
        children:[
          {
            path: 'manage',
            name: 'StudentManage',
            component: StudentManage,
            meta: {
              title: '学生管理'
            }
          }
        ]
      },
      {
        // /score/manage(add/update....)
        path: 'score',
        name: 'ScoreHome',
        component: ScoreHome,
        children:[
          {
            path: 'manage',
            name: 'ScoreManage',
            component: ScoreManage,
            meta: {
              title: '成绩管理'
            }
          },
          {
            path: 'add',
            name: 'AddScore',
            component: AddScore,
            meta: {
              title: '添加成绩'
            }
          },
          {
            path: 'update',
            name: 'UpdateScore',
            component: UpdateScore,
            meta: {
              title: '修改成绩'
            }
          }
        ]
      }
    ]
  }
]
const router = new VueRouter({
  routes
})

const IGNORE_URLS = ['/','/login']
// 前置守卫进行权限的控制
router.beforeEach((toRoute,fromRoute,next) => {
  Nprogress.start()
  if (IGNORE_URLS.includes(toRoute.path)) {
    // 要访问的路径在要忽略的url中
    next()
  }else {
    let token = getItem(USER_TOKEN_KEY)
    if (token) {
      return next()
    }
    // 无权限跳转到登录页面
    return next({path:IGNORE_URLS[0]})
  }
})

// 后置守卫
router.afterEach((toRoute,fromRoute) => {
  Nprogress.done()
  document.title = toRoute.meta.title
})

export default router

