<template>
  <div>
<!--    <div class="box"></div>-->
<!--    <lottie :options="defaultOptions" :height="400" :width="400" @animCreated="handleAnimation" />-->

    <div id="person" style="width: 45%; height: 400px"></div>
    </div>
</template>

<script>
import gsap from 'gsap';
import lottie from "vue-lottie";
import * as animationData from '../../assets/load.json';
import * as echarts from "echarts";

const option1 = {
  title: {
    text: '鲁迅的《少年闰土》对你的哪方面产生了重要影响',
    left: 'center'
  },
  tooltip: {
    trigger: 'item'
  },
  legend: {
    orient: 'vertical',
    left: 'left'
  },
  series: [
    {
      name: 'Access From',
      type: 'pie',
      radius: '50%',
      data: [
        { value: 31, name: '人文价值观念' },
        { value: 26, name: '文学创作水平' },
        { value: 43, name: '核心素养提升' },
      ],
      emphasis: {
        itemStyle: {
          shadowBlur: 10,
          shadowOffsetX: 0,
          shadowColor: 'rgba(0, 0, 0, 0.5)'
        }
      }
    }
  ]
};
export default {
  components:{
    lottie
  },
  name: 'personal',
  data() {
    return{
      defaultOptions: { animationData: animationData }
    }
  },
  mounted() {
    gsap.to(".box", {
      duration: 2,
      x: 200,
      rotation: 360,
    });
    let personDom = document.getElementById('person')
    let personChart = echarts.init(personDom)
    personChart.setOption(option1);
  },
  methods: {
    handleAnimation: function (anim) {
      this.anim = anim;
    },
  },
};
</script>

<style>
.box {
  width: 100px;
  height: 100px;
  background-color: blue;
}
</style>
