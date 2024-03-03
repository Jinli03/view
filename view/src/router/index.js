import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/Manager.vue'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Manager',
    component: () => import('../views/Manager.vue'),
    redirect: 'home',//重定向
    children: [
      { path: 'home', name: 'Home', meta: { name: '系统首页'}, component: () => import('../views/manager/Home.vue')},
      { path: 'user', name: 'User', meta: { name: '用户信息'}, component: () => import('../views/manager/User.vue')},
      { path: '403', name: 'Auth', meta: { name: '不知道'}, component: () => import('../views/manager/Auth.vue')},
      { path: 'person', name: 'Person', meta: { name: '个人信息'}, component: () => import('../views/manager/Person.vue')},
      { path: 'password', name: 'Password', meta: { name: '修改密码'}, component: () => import('../views/manager/Password.vue')},
      { path: 'news', name: 'News', meta: { name: '新闻信息'}, component: () => import('../views/manager/News.vue')},
      { path: 'newsdet', name: 'NewsDet', meta: { name: '新闻详情'}, component: () => import('../views/manager/NewsDet.vue')},
      { path: 'echarts', name: 'Echarts', meta: { name: '图表信息'}, component: () => import('../views/manager/Echarts.vue')},
      { path: 'notice', name: 'Notice', meta: { name: '系统公告'}, component: () => import('../views/manager/Notice.vue')},
      { path: 'tables', name: 'Tables', meta: { name: '查询名称'}, component: () => import('../views/manager/Tables.vue')},
    ]
  },
  { path: '/element', name: 'Element', meta: { name: 'element'}, component: () => import('../views/Element.vue')},
  { path: '/login', name: 'Login', meta: { name: '登录'}, component: () => import('../views/Login.vue')},
  { path: '/register', name: 'Register', meta: { name: '注册'}, component: () => import('../views/Register.vue')},
  { path: '/about', name: 'about', meta: { name: 'about'}, component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')},
  { path: '/*', name: '404', meta: { name: '无法访问'}, component: () => import('../views/404.vue')},

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) =>{
  let adminPath = ['/user']
  let users = JSON.parse(localStorage.getItem('pilot') || '{}')
  if ( users.role !== '管理员' && adminPath.includes(to.path)) {
    next('/403')
  } else{
    next()
  }
})

export default router
