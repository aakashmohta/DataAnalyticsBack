<template>
  <div class="login">
    <LoginContent msg="Login"/>
  </div>
</template>

<script>
// @ is an alias to /src
import LoginContent from '@/components/LoginContent.vue'

export default {
  name: 'Login',
  components: {
    LoginContent
  }
}
</script>
