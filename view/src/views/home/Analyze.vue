<template>
  <div class="background-image-container">
    <div>
      <div>
        <div>
          <img src="../../assets/icon/school.png" alt="First Image" class="image1" style="width: 100px; height: 100px; position: absolute; top: 125px; left: 550px;" @click="$router.push('school')">
          <p style="position: absolute; top: 190px; left: 580px; font-size: 20px">学校</p>
        </div>
        <div>
          <img src="@/assets/icon/major.png" alt="Second Image" class="image2" style="width: 100px; height: 100px; position: absolute; top: 125px; left: 650px" @click="$router.push('personal')">
          <p style="position: absolute; top: 190px; left: 680px; font-size: 20px">专业</p>
        </div>
      </div>
      <div class="vertical-text">
        <p ref="welcomeText" style="font-size: 50px; color: #8c939d">{{ displayedMessage }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomePage",
  data() {
    return {
      welcomeMessage: "欢迎来到考研分析局",
      displayedMessage: ""
    };
  },
  mounted() {
    this.displayWelcomeMessage();
  },
  methods: {
    displayWelcomeMessage() {
      let index = 0;
      const intervalId = setInterval(() => {
        this.displayedMessage += this.welcomeMessage[index];
        index++;
        if (index === this.welcomeMessage.length) {
          clearInterval(intervalId);
        }
      }, 100); // 逐字显示的时间间隔，单位为毫秒
    }
  }
};
</script>

<style scoped>
.background-image-container {
  background-image: url('@/assets/background/desktop.png');
  background-size: cover; /* 将背景图片铺满整个容器 */
  background-position: center; /* 图片居中显示 */
  height: 84vh; /* 调整容器的高度，根据需要更改 */
  background-size: 75%; /* 缩小背景图片 */
  display: flex;
  justify-content: center;
  align-items: center;
  color: white; /* 文字颜色 */
}

/* 针对内容的额外样式 */
.background-image-container > div {
  text-align: center;
}

.background-image-container h1 {
  font-size: 2em;
  margin-bottom: 10px;
}

.background-image-container p {
  font-size: 1.2em;
}

.image1:hover {
  transform: scale(1.1); /* 放大1.1倍 */
}

.image2:hover {
  transform: scale(1.1); /* 放大1.1倍 */
}

.vertical-text {
  writing-mode: vertical-rl; /* 竖直显示文本，从右到左 */
  position: absolute;
  top: 20%;
  left: 80px; /* 调整文本距离右侧的位置 */

}
</style>
