import axios from 'axios'
import router from '@/router/router-static'
import storage from "@/utils/storage";


 //这里创建的另外的配置路由 反向代理
const http = axios.create({
    timeout: 1000 * 86400 ,//设置的超时时间
    withCredentials:true,//前端设置这个开启跨域，后端用shiro
    baseURL: '/paulitem',
    headers:{
        //根据请求头 GET POST PUT DELETE  设置请求头json格式 字符类型为utf-8
        'Content-Type': 'application/json; charset=utf-8'
    }
})

// //请求拦截
http.interceptors.request.use(config =>{
    config.headers['Token'] = storage.get('Token')  //  请求头带上token
    console.log("2、请求拦截，头文件，返回config")
    return config
}, error => {
    console.log("请求拦截，error")
    return Promise.reject(error)
})
// //响应拦截
http.interceptors.response.use(response => {
    if(response.data && response.data.code === 401){
        console.log("响应拦截响应，401，返回login")
        router.push({name: 'login'})
    }
    return response
}, error => {
    console.log("3、失败响应拦截错误返回")
    return Promise.reject(error)
})
export default  http