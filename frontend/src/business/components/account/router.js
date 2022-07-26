/* eslint-disable */
export default {
  name: "Account",
  path: "/account",
  redirect: "/account/cloudaccount",
  components: {
    content: () => import(/* webpackChunkName: "setting" */ '@/business/components/account/base')
  },
  children: [
    {
      path: "clouddashboard",
      name: "cloudDashboard",
      component: () => import(/* webpackChunkName: "api" */ "@/business/components/account/home/Dashboard"),
    },
    {
      path: "cloudaccount",
      name: "cloudAccount",
      component: () => import(/* webpackChunkName: "api" */ '@/business/components/account/home/CloudAccount'),
    },
    {
      path: "accountscan/:id",
      name: "accountScan",
      component: () => import(/* webpackChunkName: "api" */ '@/business/components/account/home/AccountScan'),
    },
    {
      path: 'quartztask',
      name: 'cloudQuartzTask',
      component: () => import(/* webpackChunkName: "api" */ '@/business/components/account/home/QuartzTask'),
    },
    {
      path: "rule",
      name: "cloudRule",
      component: () => import(/* webpackChunkName: "api" */ "@/business/components/rule/home/Rule"),
    },
    {
      path: "result",
      name: "cloudResult",
      component: () => import(/* webpackChunkName: "api" */ '@/business/components/account/home/Result'),
    },
    {
      path: "resultdetails/:id",
      name: "resultDetails",
      component: () => import(/* webpackChunkName: "api" */ "@/business/components/account/home/ResultDetails"),
    },
    {
      path: "history",
      name: "cloudHistory",
      component: () => import(/* webpackChunkName: "api" */ "@/business/components/account/home/History"),
    },
    {
      path: 'accountoverview',
      name: 'cloudOverview',
      component: () => import(/* webpackChunkName: "api" */ '@/business/components/account/home/AccountOverview'),
    },
  ]
}
