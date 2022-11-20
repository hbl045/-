import Vue from 'vue'
import App from './App.vue'

//  element ui 完全引入
import ElementUI from 'element-ui'
import '@/assets/css/element-variables.scss'
import '@/assets/css/style.scss'

//  引入自定义主题
import '@/assets/css/theme.scss'

//加载路由  前端第二步 页面路由跳转
import router from '@/router/router-static.js';

//面包屑导航，注册为全局组件
import BreadCrumbs from '@/components/common/BreadCrumbs'

// 引入echart
import echarts from 'echarts'
// 引入echart主题
// import  '@/assets/js/echarts-theme-macarons.js'
import 'echarts/theme/macarons.js'

//ajax
import http from '@/utils/http.js'

// 基础配置 登陆路径 项目名称
import base from '@/utils/base'

//工具类 权限验证
import { isAuth } from '@/utils/utils'

//storage 封装
import storage from "@/utils/storage";

//上传组件
import FileUpload from "@/components/common/FileUpload";

//富文本编辑组件
import Editor from "@/components/common/Editor";

//  api 接口 （路由）
import api from '@/utils/api'

// 数据检验工具类 （正则表达式）
import * as validate from '@/utils/validate'


//定义全局变量 Vue.prototype.xxx 全局属性 可以使用this方法
Vue.prototype.$validate = validate
Vue.prototype.$http = http //ajax请求方法
Vue.prototype.$echarts = echarts
Vue.prototype.$base = base.get()
Vue.prototype.$project = base.getProjectName()
Vue.prototype.$storage = storage
Vue.prototype.$api = api

//判断权限方法
Vue.prototype.isAuth = isAuth

//Vue.use 全局方法
Vue.use(ElementUI,{size:'medium',zIndex: 3000 });
Vue.config.productionTip = false
//组件全局组件
Vue.component('bread-crumbs',BreadCrumbs)
Vue.component('file-upload',FileUpload)
Vue.component('editor',Editor)
new Vue({
  render: h => h(App),
  router
}).$mount('#app')
