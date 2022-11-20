//这里导入Vue 尴尬的事情是，没有引用的引用语句是灰色的，所有没有出错哦
import Vue from 'vue';
//路由配置空间
import VueRouter from 'vue-router';

//告诉vue使用VueRouter
Vue.use(VueRouter);
//1。创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import register from "@/views/register";
import UpdatePassword from '@/views/update-password'
import center from '@/views/center'
import news from '@/views/modules/news/list'
import zhaopinxinxi from '@/views/modules/zhaopingxinxi/list'
import qiyexinxi from '@/views/modules/qiyexinxi/list'
import qiuzhizhexinxi from '@/views/modules/qiuzhizhexinxi/list'
import yonghu from '@/views/modules/yonghu/list'
import peizhiguanli from '@/views/modules/peizhiguanli/list'
import gangweifenlei from '@/views/modules/gangweifenlei/list'
import youqinglianjie from '@/views/modules/youqinglianjie/list'
import storeup from '@/views/modules/storeup/list'
import xuelixinxi from '@/views/modules/xuelixinxi/list'
import yingpinxinxi from '@/views/modules/yingpinxinxi/list'
import users from '@/views/modules/users/list'

//2.配置路由 注意：名字
const routes = [
    {
        path:'/index', name: 'index',component: Index,children:[{
            //这里不设置值，是把main作为默认页面
            path:'/',
            name: 'home',
            component: Home
        },{
           path: '/updatePassword',
           name: 'updatePassword',
           component: UpdatePassword
        },{
            path: '/center',
            name: 'center',
            component: center
        },{
            path: '/news',
            name: 'news',
            component: news
        },{
            path: '/zhaopinxinxi',
            name: 'zhaopinxinxi',
            component: zhaopinxinxi
        },{
            path: '/qiyexinxi',
            name: 'qiyexinxi',
            component: qiyexinxi
        },{
            path: '/qiuzhizhexinxi',
            name: 'qiuzhizhexinxi',
            component: qiuzhizhexinxi
        },{
            path: '/yonghu',
            name: 'yonghu',
            component: yonghu
        },{
            path: '/peizhiguanli',
            name: 'peizhiguanli',
            component: peizhiguanli
        },{
            path: '/gangweifenlei',
            name: 'gangweifenlei',
            component: gangweifenlei
        },{
            path: '/youqinglianjie',
            name: 'youqinglianjie',
            component: youqinglianjie
        },{
            path: '/storeup',
            name: 'storeup',
            component: storeup
        },{
            path: '/xuelixinxi',
            name: 'xuelixinxi',
            component: xuelixinxi
        },{
            path: '/yingpinxinxi',
            name: 'yingpinxinxi',
            component: yingpinxinxi
        },{
            path: '/users',
            name: 'users',
            component: users
        }]
    },//adminexam不用要
    {path: '/login', name: 'login', component: Login},
    {path: '/register',name: 'register',component: register},
    {path: '/',redirect:'/index/'}, /*默认跳转路由*/
    {path: '*',component: NotFound}

]

//3.实例化VueRouter 注意：名字
const router = new VueRouter({
    mode: 'hash', /*hash模式改为history*/
    routes//( 缩写)相当宇 routes:routes
})

export default router;