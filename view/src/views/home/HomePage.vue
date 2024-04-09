<template>
  <div >
    <div class="background-image-container" >
      <div>
        <div>
          <div>
            <img src="../../assets/222.png" alt="First Image" class="image1" style="width: 350px; height: 300px; position: absolute; top: 530px; left: 430px;" @click="$router.push('search')">
            <p style="position: absolute; top: 800px; left: 550px; font-size: 26px">分析局</p>
          </div>
          <div>
            <img src="@/assets/333.png" alt="Second Image" class="image2" style="width: 300px; height: 300px; position: absolute; bottom: 520px; right: 185px" @click="$router.push('personal')">
            <p style="position: absolute; bottom: 505px; right:400px; font-size: 26px">个人中心</p>
          </div>
          <div>
            <img src="@/assets/444.png" alt="Third Image" class="image3" style="width: 300px; height: 300px; position: absolute; bottom: 520px; left: 185px" >
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomePage",
  data() {
    return {};
  },
};
</script>

<style scoped>
.background-image-container {
  background-image: url('@/assets/background/homepage.png');
  background-size: cover; /* 使用 cover 让背景图片填满整个容器 */
  background-position: center; /* 图片居中显示 */
  height: 100vh; /* 使用视口高度作为容器高度 */
  width: 100vw; /* 使用视口宽度作为容器宽度 */
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

.image1 {
  position: absolute;
  top: 500px;
  left: 350px;
  transition: transform 0.3s ease-out;
}

.image2 {
  transition: transform 0.3s ease-out;
}

.image1:hover {
  transform: scale(1.1); /* 放大1.1倍 */
}

.image2:hover {
  transform: scale(1.1); /* 放大1.1倍 */
}
</style>
