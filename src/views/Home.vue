<template>
  <div class="container">
    <div class="headersys">
      SYSTEM
    </div>
    <div class="row mt-5">
      <div class="col">
        <h2>Users Active</h2>
        <line-chart :chartData="arrActiveCount" :options="chartOptions" label="GetDissapointed"></line-chart>
        <div class="center">
        <button>10 min</button>
        <button>30 min</button>
        <button>1 hour</button>
        <button>5 hours</button>
        <button>12 hours</button>
        <button>1 Day</button>
        <button>3 Days</button>
        <button>7 Days</button>
        <button>15  Days</button>
        </div>
        <div>Total number of Users online:{{arrActiveCount[1].total}}</div>
        <h2>Most liked Categories</h2>
        <pie-chart :chartData="arrActiveCount" :options="chartOptions" label="BarActive"></pie-chart>
        <div class="center">
        <button>10 min</button>
        <button>30 min</button>
        <button>1 hour</button>
        <button>5 hours</button>
        <button>12 hours</button>
        <button>1 Day</button>
        <button>3 Days</button>
        <button>7 Days</button>
        <button>15 Days</button>
        </div>
        <div>Number of likes for cat1</div>
        <div>Number of likes for cat2</div>
        <div>Number of likes for cat3</div>
        <div>Number of likes for cat4</div>
        <div>Number of likes for cat5</div>
        </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /sr
import LineChart from '../components/LineChart.vue'
import PieChart from '../components/PieChart.vue'
import axios from 'axios'
// import moment from 'moment'
import Vue from 'vue'
import VueAxios from 'vue-axios'
Vue.use(VueAxios, axios)
export default {
  name: 'Home',
  components: {
    LineChart,
    PieChart
  },
  data () {
    return {
      chartOptions: {
        responsive: true,
        maintainAspectRatio: false,
        borderwidth: 2
      },
      arrActiveCount: [],
      data: [
        {
          date: '20210101',
          count: 10
        },
        {
          date: '20210102',
          count: 20
        },
        {
          date: '20210103',
          count: 30
        },
        {
          date: '20210104',
          count: 40
        },
        {
          date: '20210105',
          count: 35
        },
        {
          date: '20210106',
          count: 37
        },
        {
          date: '20210107',
          count: 33
        },
        {
          date: '20210108',
          count: 39
        },
        {
          date: '20210109',
          count: 50
        }
      ],
      data1: [],
      datetime: {
        dateStartDTO: '2017-01-13T17:09:42.411Z',
        dateEndDTO: new Date().toISOString()
      },
      header: {
        Authorization: this.$store.state.token
      }
    }
  },
  methods: {
    getActiveUsers () {
      this.axios.post('http://10.177.2.29:8760/analytics/get/' + 6, this.datetime, { headers: this.header }).then((resp) => {
        console.log(resp.data)
      })
    }
  },
  created () {
    console.log('inside generate')
    console.log(this.header)
    // this.data1 = axios.post('http://10.177.2.29:8760/analytics/get/' + 6, this.datetime)
    this.axios.post('http://10.177.2.29:8760/analytics/get/' + 6, this.datetime, { headers: this.header }).then((resp) => {
      console.log(resp.data)
      this.data1 = resp.data
      this.data1.forEach(d => {
      // const date = moment(d.date, 'YYYYMMDD').format('DD/MM')
        const id = d.id
        // console.log(date)
        const {
          count
        } = d
        this.arrActiveCount.push({ id, total: count })
      // console.log(this.arrActiveCount)
      })
    })
    console.log(this.date1)
  }
}
</script>
<style>
.container{
  margin-left: 70px;
}
button{
  display: inline-block;
  margin-right: 10px;
  border-radius: 15px;
}
.center{
  text-align: center;
}
.headersys{
  text-align: center;
  font-size: 50px;
  background: black;
  color: white;
}
</style>
