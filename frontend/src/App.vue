<template>
  <div class="container">
    <input type="text" v-model="today" name="today" placeholder="날짜">
    <input type="text" v-model="todo" name="todo" placeholder="할일">
    <button @click="saveData">저장</button>
  </div>
</template>

<script>
import axios from 'axios'
// 비동기 통신 라이브러리, ajax를 사용하기 위해서는 axios가 주로 쓰임

export default {
  data () {
    return {
      today: ' ',
      todo: ' '
    }
  },
  methods: {
    saveData () {
      // axios의 단축키인 aliases 사용됨
      axios
        .put('/api/', {
          today: this.today,
          todo: this.todo
        })
        .then(response => {
          console.log('Data saved successfully')
          this.fetchData()
        })
        .catch(error => {
          console.error('Error saving data', error)
        })
    },
    fetchData () {
      axios
        .get('/api/data')
        .then(response => {
          this.data = response.data
        })
        .catch(error => {
          console.error('Error fetching data:', error)
        })
    }
  },
  mounted () {
    // Fetch data on component mount
    this.fetchData()
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
