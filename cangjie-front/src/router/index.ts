import { createRouter, createWebHistory } from 'vue-router'
import Fenci from '../views/FenciView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'fenci',
      component: Fenci
    }
  ]
})

export default router
