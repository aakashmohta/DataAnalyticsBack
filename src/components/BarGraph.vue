<script>
import { Bar } from 'vue-chartjs'
export default {
  extends: Bar,
  props: {
    label: {
      type: String
    },
    chartData: {
      type: Array
    },
    options: {
      type: Object
    }
  },
  mounted () {
    const dates = this.chartData.map(d => d.date)
    const totals = this.chartData.map(d => d.total)

    this.renderChart({
      labels: dates,
      datasets: [{
        label: this.label,
        data: totals
      }]
    }, this.options)
  }
}
</script>>
