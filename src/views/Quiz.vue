<template>
  <div class="container">
      <div class="headerquiz">
      Quiz
    </div>
    <div class="row mt-5">
      <div class="col">
        <h2>Most answered questions by category</h2>
        <pie-chart :chartData="arrActiveCount" :options="chartOptions" label="Categories"></pie-chart>
        <div class="center">
        <button>10min</button>
        <button>20min</button>
        <button>30min</button>
        <button>1hour</button>
        <button>3hours</button>
        <button>5hours</button>
        <button>12hrs</button>
        <button>1 Day</button>
        <button>2 Days</button>
        <button>3Days</button>
        <button>7 Days</button>
        <button>15  Days</button>
        </div>
        <div>Number of quizes for cat1</div>
        <div>Number of quizes for cat2</div>
        <div>Number of quizes for cat3</div>
        <div>Number of quizes for cat4</div>
        <div>Number of quizes for cat5</div>
        <h2>Most Contests won</h2>
        <bar-graph :chartData="arrActiveCount" :options="chartOptions" label="BarActive"></bar-graph>
        <div class="center">
        <button>10min</button>
        <button>20min</button>
        <button>30min</button>
        <button>1hour</button>
        <button>3hours</button>
        <button>5hours</button>
        <button>12hrs</button>
        <button>1 Day</button>
        <button>2 Days</button>
        <button>3Days</button>
        <button>7 Days</button>
        <button>15  Days</button>
        </div>
        <div>Ultimate winner: {{arrActiveCount[1].total}}</div>
        <h2>Most answered question</h2>
        <bar-graph :chartData="arrActiveCount" :options="chartOptions" label="BarActive"></bar-graph>
        <div class="center">
        <button>10min</button>
        <button>20min</button>
        <button>30min</button>
        <button>1hour</button>
        <button>3hours</button>
        <button>5hours</button>
        <button>12hrs</button>
        <button>1 Day</button>
        <button>2 Days</button>
        <button>3Days</button>
        <button>7 Days</button>
        <button>15  Days</button>
        </div>
        <div>Most answered question: {{arrActiveCount[1].total}}</div>
        </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /sr
// import axios from 'axios';
import moment from 'moment'
import BarGraph from '../components/BarGraph.vue'
import PieChart from '../components/PieChart.vue'
export default {
  name: 'Quora',
  components: {
    PieChart,
    BarGraph
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
      ]
    }
  },

  // const { data } = await axios.get('url')
  // console.log(data)
  created () {
    console.log('inside generate')
    this.data.forEach(d => {
      const date = moment(d.date, 'YYYYMMDD').format('DD/MM')
      console.log(date)
      const {
        count
      } = d
      this.arrActiveCount.push({ date, total: count })
      // console.log(this.arrActiveCount)
    })
  }
}
</script>
<style scoped>
.container{
  margin-left: 70px;
}
.headerquiz{
  text-align: center;
  font-size: 50px;
  background:purple;
  color: white;
}
button{
  display: inline-block;
  margin-right: 10px;
  border-radius: 15px;
}
.center{
  text-align: center;
}
</style>
