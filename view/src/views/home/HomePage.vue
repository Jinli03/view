<template>
  <div>
    <div class="background-image-container">
      <div>
        <div>
          <div>
            <img src="../../assets/analyze.png" alt="First Image" class="image1" style="width: 200px; height: 200px; position: absolute; top: 500px; left: 350px;" @click="$router.push('search')">
            <p style="position: absolute; top: 650px; left: 400px; font-size: 26px">分析局</p>
          </div>
          <div>
            <img src="@/assets/personal.png" alt="Second Image" class="image2" style="width: 200px; height: 200px; position: absolute; bottom: 200px; right: 240px" @click="$router.push('personal')">
            <p style="position: absolute; bottom: 140px; right: 280px; font-size: 26px">个人中心</p>
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
  background-image: url('@/assets/homepage.png');
  background-size: cover; /* 将背景图片铺满整个容器 */
  background-position: center; /* 图片居中显示 */
  height: 84vh; /* 调整容器的高度，根据需要更改 */
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
