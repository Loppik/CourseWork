import Vue from 'vue'
import Search from '../../../../vue/frontend/src/Search.vue'
import Menu from '../../../../vue/frontend/src/Menu.vue'
import MenuLog from '../../../../vue/frontend/src/MenuLog.vue'
import Footer from '../../../../vue/frontend/src/Footer.vue'
import Info from '../../../../vue/frontend/src/Info.vue'
import FormReg from '../../../../vue/frontend/src/FormReg.vue'
import FormLogin from '../../../../vue/frontend/src/FormLogin.vue'
import QuestionNonAuth from '../../../../vue/frontend/src/QuestionNonAuth.vue'
import QuestionAuth from '../../../../vue/frontend/src/QuestionAuth.vue'
import Cp from '../../../../vue/frontend/src/Cp.vue'

new Vue({
  el: '#cp',
  render: h => h(Cp)
})

new Vue({
  el: '#search',
  render: h => h(Search)
})

new Vue({
  el: '#menu',
  render: h => h(Menu)
})

new Vue({
  el: '#menu-log',
  render: h => h(MenuLog)
})

new Vue({
  el: '#formreg',
  render: h => h(FormReg)
})

new Vue({
  el: '#formlogin',
  render: h => h(FormLogin)
})

new Vue({
  el: '#footer',
  render: h => h(Footer)
})

new Vue({
  el: '#info',
  render: h => h(Info)
})

new Vue({
  el: '#question-non',
  render: h => h(QuestionNonAuth)
})

new Vue({
  el: '#question-auth',
  render: h => h(QuestionAuth)
})