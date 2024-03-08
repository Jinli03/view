<template>
  <div>
    <div class="box"></div>
    <lottie :options="defaultOptions" :height="400" :width="400" @animCreated="handleAnimation" />
    </div>
</template>

<script>
import gsap from 'gsap';
import lottie from "vue-lottie";
import * as animationData from '../../assets/load.json';
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
