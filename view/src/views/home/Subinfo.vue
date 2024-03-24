<!--
*@oneSchool
*@author Jinli
*@date 2024/3/19 0:00
-->
<template>
  <div>
    <h1>
      hello, {{ tables.school }}  {{ tables.sub }}
    </h1>
    <div>
      <el-row :gutter="20" style="padding: 8px">
        <el-col :span="6">
          <el-card style="height: 40%">
            <div id="person" style="width: 100%; height: 400px"></div>
          </el-card>
        </el-col>
        <el-col :span="6">
          <el-card>
            <div id="reperson" style="width: 100%; height: 400px"></div>
          </el-card>
        </el-col>
        <el-col :span="6">
          <el-card>
            <div id="rescore" style="width: 100%; height: 400px"></div>
          </el-card>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>

import * as echarts from "echarts";

const option1 = {
  title: {
    text: '历年录取人数',
    subtext: '仅供参考',
    left: 'center'
  },
  xAxis: {
    type: 'category',
    data: ['2021', '2022', '2023']
  },
  tooltip: {
    trigger: 'axis'
  },
  legend: {
    orient: 'horizontal', // 设置为水平方向
    bottom: 0 // 底部距离为0，您可以根据需要调整
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      name: '',
      data: [],
    },
  ]
};
const option2 = {
  title: {
    text: '历年复试人数',
    subtext: '仅供参考',
    left: 'center'
  },
  xAxis: {
    type: 'category',
    data: ['2021', '2022', '2023']
  },
  tooltip: {
    trigger: 'axis'
  },

  legend: {
    orient: 'horizontal', // 设置为水平方向
    bottom: 0 // 底部距离为0，您可以根据需要调整
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      name: '',
      data: [],
    },
  ]
};
const option3 = {
  title: {
    text: '历年复试分数',
    subtext: '仅供参考',
    left: 'center'
  },
  xAxis: {
    type: 'category',
    data: ['2021', '2022', '2023']
  },
  tooltip: {
    trigger: 'axis'
  },
  legend: {
    orient: 'horizontal', // 设置为水平方向
    bottom: 0 // 底部距离为0，您可以根据需要调整
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      name: '',
      data: [],
    },
  ]
};
export default {
  name: "oneSchool",
  props: {},
  components: {},
  data() {
    return {
      id: '',
      tables: []
    }
  },
  created() {
  },
  mounted() {
    let id = this.$route.query.id
    this.id = id
    if (!id) {
      return
    }
    this.load()
  },
  methods: {
    load() {
      if (this.pageNum) { // 使用 this.pageNum 而不是 pageNum
        this.pageNum = this.pageNum;
      }

      let id = this.id;

      this.$request.get('/tables/distinctSub/' + id ).then(res => {
        let tables = res.data;
        console.log(tables)
        console.log(tables.personGroups)
        // 更新招收人数图表
        this.updateChart('person', tables.personGroups, option1);
        console.log(tables.personGroups)
        // 更新复试人数图表
        this.updateChart('reperson', tables.repersonGroups, option2);
        // 更新复试分数图表
        this.updateChart('rescore', tables.rescoreGroups, option3);
      }).catch(error => {
        console.error('Error fetching data:', error);
      });
    },

    updateChart(elementId, dataGroups, option) {
      let elementDom = document.getElementById(elementId);
      let elementChart = echarts.init(elementDom);

      const series = [];

      option.series = [
        {
          data: dataGroups,
          type: 'line',
          smooth: true
        },
      ];
      // 更新图表
      elementChart.setOption(option);
    }


  },
}
</script>

<style>

</style>
