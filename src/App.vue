<template>
  <div id="app">
    <div class="side">
     <a id="System"><router-link to="/">System</router-link></a>
      <a id="PageBook"><router-link to="/pagebook">PageBook</router-link></a>
    <a id="Quora"><router-link to="/quora">Quora</router-link></a>
      <a id="Quiz"><router-link to="/quiz">Quiz</router-link></a>
    </div>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
.side{
  position: fixed;
  top: 50%;
  transform: translateY(-50%);
}
.side a{
  font-size: 22px;
  display: block;
  width: 130px;
  height: 70px;
  text-decoration: none;
  margin: 20px 0px;
  color: white;
  border-radius: 6px;
  margin-left: -100px;
  text-align: center;
}
.side a:hover{
  margin-left: 0px
}
#System{
  background: black;
}
#PageBook{
 background: blue;
}
#Quora{
 background: red;
}
#Quiz{
 background: purple;
}
</style>
