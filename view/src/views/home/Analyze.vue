<!--
*@Personal
*@author Jinli
*@date 2024/3/5 20:13
-->
<template>
  <div>
    <div class="bob">
      <div class="center">
        <input type="checkbox" id="toggle" style="position: fixed; left: 0; top: 0; z-index: 11">
        <div class="main">
          <div class="layers">
            <div class="layer">
              <div class="text">School</div>
              <div class="container">
                <div class="can">
                  <img src="@/assets/01.png">
                </div>
                <div class="wrapper">
                  <img src="@/assets/02.png">
                </div>
              </div>
              <label for="toggle">Click To Slide</label>
              <label @click="showTable">查看学校</label>
            </div>
            <div class="layer">
              <div class="text">Subject</div>
              <div class="container">
                <div class="can">
                  <img src="@/assets/01.png">
                </div>
                <div class="wrapper">
                  <img src="@/assets/02.png">
                </div>
              </div>
              <label for="toggle">Click To Slide</label>
              <label @click="showTable">查看专业</label>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="additional-content">
      <!-- 这里添加你的额外内容 -->
      <p>这里是底部显示的内容</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "Analyze",
  props: {},
  components: {},
  data() {
    return {
      tableVisible: false
    }
  },
  created() {
  },
  mounted: {},
  methods: {
    showTable() {
      document.body.style.overflowY = 'auto'
    },
  },
}
</script>

<style>
body {
  overflow-y: hidden;
}

.bob {
  width: 100%;
  height: 100vh;
  overflow-y: hidden;
}

.center {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.main {
  width: 100%;
  height: 100%;
  position: relative;
}

.layers {
  width: 200%;
  height: 100%;
  display: flex;
  transition: cubic-bezier(0.71, 0, 0.36, 1) 0.8s;
}

.layer {
  width: 100vw;
  height: 100%;
  background-color: rgb(255,239,219);
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
  overflow: hidden;
  flex-direction: column;
}

.layer:nth-child(2) {
  background-color: rgb(229,254,193);
}

.layer .text {
  position: absolute;
  left: 50%;
  top: 45%;
  transform: translate(-50%, -50%);
  font-size: 175px;
  font-weight: 500;
  color: rgb(255,213,159);
  transition: cubic-bezier(0.71, 0, 0.36, 1) 1.2s;
}

.layer:nth-child(2) .text {
  color: rgb(181,235,115);
}

.container {
  position: relative;
  overflow: hidden;
  margin-top: 75px;
}

.can {
  width: 200px;
}

.can img {
  top: 50%;
  left: 50%;
  width: 200px;
}

.wrapper {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  height: 90%;
  mix-blend-mode: multiply;
  transition: cubic-bezier(0.71, 0, 0.36, 1) 1.2s;
}

.wrapper img {
  height: 100%;
  mix-blend-mode: multiply;
}

#toggle:checked ~ .main .layers {
  transform: translateX(-50%);
}

#toggle:checked ~ .main .layers .layer:nth-child(1) .text {
  left: 150%
}

#toggle:checked ~ .main .layers .layer:nth-child(1) .wrapper {
  left: -50%
}
#toggle:not(:checked) ~ .main .layers .layer:nth-child(2) .text {
  left: -50%
}

#toggle:not(:checked) ~ .main .layers .layer:nth-child(2) .wrapper {
  left: 150%
}

.layer label {
  display: block;
  padding: 10px 20px;
  font-size: 16px;
  border:2px solid black;
  border-radius: 25px;
  cursor: pointer;
  margin-top: 20px;
}

#toggle {
  display: none;
}

.additional-content {
  position: relative;
  z-index: 1;
  width: 100%;
  padding: 20px;
  box-sizing: border-box;
  text-align: center;
  background-color: #f0f0f0; /* 为底部内容添加背景色，可根据需要调整 */
}

</style>