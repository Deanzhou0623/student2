import axios from 'axios'
import qs from 'qs'
import { BASE_URL, USER_TOKEN_KEY } from '@/config/constants'
import { Message, MessageBox } from 'element-ui'
import { clearAll, getItem } from '@/storage'
import Nprogress from 'nprogress'


axios.defaults.baseURL = BASE_URL
axios.defaults.timeout = 1000 * 60 * 10 // 单位ms
axios.defaults.headers["Content-Type"] = "application/json"

/**
 * 给axiosInstance添加请求、响应拦截器
 */
function addInterceptors(axiosInstance){
  // 请求拦截器
  axiosInstance.interceptors.request.use(config => {
    Nprogress.start()
    // 获取token并且加入到请求头中
    let userToken = getItem(USER_TOKEN_KEY)
    // null时后端接收到的是"null"
    if (userToken) {
      config.headers['Authorization'] = userToken
    }
    return config;
  },error => {
    console.log("请求发送失败",error)
    MessageBox.alert("请求发送失败","错误提示");
  });
  // 响应拦截器
  axiosInstance.interceptors.response.use(resultWrapper => {
    Nprogress.done()
    let result = resultWrapper.data;
    if (result.success) {
      return result;
    } else {
      if (result.code && result.code === 30001) {
        // 跳转到登录页面
        clearAll()
        // 被路由的前置守卫拦截跳转到登录页
        window.location.reload()
      }else {
        // 对错误进行统一的提示
        MessageBox.alert(result.msg,"错误提示")
        return Promise.reject(result)
      }
    }
  },error => {
    Nprogress.done()
    console.log("服务器响应失败",error)
    // 对错误进行统一的提示
    Message.error("服务器响应失败")
    return Promise.reject("服务器响应失败")
  });
}

/**
 * 用来发送get请求的axios实例
 */
let getInstance = axios.create();
addInterceptors(getInstance);

/**
 * 用来发送post请求的axios实例,
 * Content-Type:application/x-www-form-urlencoded
 */
let formPostInstance = axios.create({
  method:"post",
  headers:{
    "Content-Type": "application/x-www-form-urlencoded"
  },
  // id=1&name=abc&age=34
  transformRequest: [function (data,headers) {
    // data:程序员自己传给axios的参数 ,如:
    // {
    //     "userName": "admin",
    //     "pwd": "333"
    // }
    console.log("data:",data)
    return qs.stringify(data)
  }]
});
addInterceptors(formPostInstance);


/**
 * 用来发送post请求的axios实例,
 * Content-Type:application/json
 */
let appJsonPostInstance = axios.create({
  method:"post"
});
addInterceptors(appJsonPostInstance);

/**
 * @param config
 *        {"url":'/abc',params:{id:1}} 或 {url:'/abc?id=1'}
 * @returns {AxiosPromise}
 */
export function doGet (config) {
  return getInstance(config);
}

/**
 * @param config
 *        {"url":'/abc',data:{id:1}}
 * @returns {AxiosPromise}
 */
export function formPost (config) {
  return formPostInstance(config);
}


/**
 * @param config
 *        {"url":'/abc',data:{id:1}}
 * @returns {AxiosPromise}
 */
export function appJsonPost (config) {
  return appJsonPostInstance(config);
}
