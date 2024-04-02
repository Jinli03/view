<template>
  <div>
    <el-container class="background-image-container">
      <div style=" width: 95%; height: 95%">
        <el-row :gutter="50">
          <el-col :span="6" style="backdrop-filter: blur(20px); border-radius: 10px; padding: 10px">
            <div>
              <el-row style="display:flex; justify-content: center; width: 80%; margin-left: 20px; margin-top: 10px; border-radius: 20px">
                <img :src="user.title || 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png'" alt="" style=" width: 50px; height: 50px; border-radius: 50%; margin: 10px">
                <p style="color: #ffffff; margin-top: 15px">"静水流深<br>沧笙踏歌"</p>
              </el-row>
              <el-row>
                <el-card style="justify-content: center; width: 80%; margin-left: 20px; border-radius: 20px">
                  <div>
                    <el-statistic
                        group-separator=","
                        :value="value1"
                        :title="title1"
                    >
                      <template slot="prefix">
                        <i class="el-icon-user"></i>
                      </template>
                    </el-statistic>
                  </div>
                </el-card>
              </el-row>
              <el-row>
                <el-card style="justify-content: center; width: 80%; margin-left: 20px; margin-top: 10px; border-radius: 20px">
                  <div>
                    <el-statistic
                        group-separator=","
                        :value="value2"
                        :title="title2"
                    >
                      <template slot="prefix">
                        <i class="el-icon-house"></i>
                      </template>
                    </el-statistic>
                  </div>
                </el-card>
              </el-row>
              <el-row>
                <el-card style="justify-content: center; width: 80%; margin-left: 20px; margin-top: 10px; border-radius: 20px">
                  <div>
                    <el-statistic
                        group-separator=","
                        :value="value3"
                        :title="title3"
                    >
                      <template slot="prefix">
                        <i class="el-icon-search"></i>
                      </template>
                    </el-statistic>
                  </div>
                </el-card>
              </el-row>
              <el-row>
                <el-card style="justify-content: center; width: 80%; margin-left: 20px; margin-top: 10px; border-radius: 20px">
                  <div style="width: 100%; display: inline-block;">
                    <el-statistic
                        format="DD天"
                        :value="deadline"
                        time-indices
                        title="🚩距离考研还有："
                    >
                      <template slot="prefix">
                        <i class="el-icon-sunrise"></i>
                      </template>
                    </el-statistic>
                  </div>
                </el-card>
              </el-row>
              <el-row>
                <el-card style="justify-content: center; width: 80%; margin-left: 20px; margin-top: 10px; margin-bottom: 10px; border-radius: 20px">

                </el-card>
              </el-row>
            </div>
          </el-col>
          <el-col :span="12" style="backdrop-filter: blur(20px); border-radius: 10px; padding: 10px">
<!--              <div style="margin-left: 50px; margin-right: 50px">-->
<!--                <template>-->
<!--                  <el-carousel :interval="3000" type="card" height="140px">-->
<!--                    <el-carousel-item v-for="item in 6" :key="item">-->
<!--                    </el-carousel-item>-->
<!--                  </el-carousel>-->
<!--                </template>-->
<!--              </div>-->
              <div style="margin: 30px">
                <a-card title="留言" style="width: 100%; height: 380px; border-radius: 20px;">
                  <div>
                    <a-comment v-for="(comment, index) in item" :key="index">
                      <template #author>
                        <a>{{ comment.author }}</a>
                      </template>
                      <template #avatar>
                        <a-avatar src="https://th.bing.com/th/id/OIP.DClLHtxlG_GKXHei8YzPVAHaE6?w=234&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"  />
                      </template>
                      <template #content>
                        <p>{{ comment.comment }}</p>
                      </template>
                      <a-divider />
                    </a-comment>
                  </div>
                </a-card>
              </div>
          </el-col>

          <el-col :span="6" style="backdrop-filter: blur(20px); border-radius: 10px; padding: 10px">
            <div>
              <el-row style="margin-bottom: 10px">
                <template>
                  <a-card title="每日箴言" style="background-size: cover; border-radius: 20px" :style="{ backgroundImage: 'url(' + require('@/assets/card/blue.webp') + ')' }">
                    <p style="font-size: 14px; color: rgba(0, 0, 0, 0.85); margin-bottom: 16px; font-weight: 500">
                      你永远是最棒的
                    </p>
                  </a-card>
                </template>
              </el-row>
              <el-row style="margin-bottom: 10px">
                <template>
                  <div style="background-color: #ececec; padding: 20px; background-size: cover; border-radius: 20px" :style="{ backgroundImage: 'url(' + require('@/assets/card/rainbow.png') + ')' }">
                    <a-row>
                      <p>心愿单</p>
                    </a-row>
                    <a-row :gutter="16" >
                      <a-col :span="8">
                        <a-card title="心愿1" :bordered="false" style="background-size: cover; border-radius: 20px">
                          <p>card content</p>
                        </a-card>
                      </a-col>
                      <a-col :span="8">
                        <a-card title="心愿2" :bordered="false" style="background-size: cover; border-radius: 20px">
                          <p>card content</p>
                        </a-card>
                      </a-col>
                      <a-col :span="8">
                        <a-card title="心愿3" :bordered="false" style="background-size: cover; border-radius: 20px">
                          <p>card content</p>
                        </a-card>
                      </a-col>
                    </a-row>
                  </div>
                </template>
              </el-row>
              <el-row>
                <template>
                  <template>
                    <a-card title="单词" style="background-size: cover; border-radius: 20px" :style="{ backgroundImage: 'url(' + require('@/assets/card/deepblue.png') + ')' }">
                      <a-icon type="redo" @click="handleRandom" />
                      <p style="font-size: 14px; color: rgba(0, 0, 0, 0.85); margin-bottom: 16px; font-weight: 500">
                      {{ words.word }}  {{ words.chinese }}
                      </p>
                    </a-card>
                  </template>
                </template>
              </el-row>
            </div>
          </el-col>
        </el-row>

      </div>
    </el-container>
  </div>

</template>

<script>
export default {
  name: "Personal",
  data() {
    return {
      user: JSON.parse(localStorage.getItem('pilot') || '{}'),
      welcomeMessage: "欢迎来到考研分析局",
      displayedMessage: "",
      deadline: new Date("2024-12-25"),
      title1: "已注册用户",
      title2: "已上传专业数量",
      title3: "网页访问量",
      value1: 4154,
      value2: 1314,
      value3: 1314,
      item: [],
      words: []
    };
  },
  mounted() {
    this.displayWelcomeMessage();
    this.$request.get('/forum/select', {
    }).then(res => {
      if (res.data) {
        // 确保在访问其属性之前，res.data不为null
        this.item = res.data;
        console.log('Response data:', res.data);
      } else {
      }
    });
  },
  methods: {
    handleRandom() {
      this.$request.get('/words/select', {
      }).then(res => {
        if (res.data) {
          // 确保在访问其属性之前，res.data不为null
          this.words = res.data;
          console.log('words:', this.words);
        } else {
        }
      });
    },
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
  background-image: url('@/assets/background/person.png');
  background-size: cover; /* 将背景图片铺满整个容器 */
  background-position: center; /* 图片居中显示 */
  height: 84vh; /* 调整容器的高度，根据需要更改 */
  background-size: 100%; /* 缩小背景图片 */
  display: flex;
  justify-content: center;
  align-items: center;
  color: white; /* 文字颜色 */
}

.background-image-container > div {
  width: 100%; /* 宽度100% */
  height: 100%; /* 高度100% */
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
  right: 80px; /* 调整文本距离右侧的位置 */
}
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(6n) {
  background-image: url('@/assets/pic/thu.png');
  background-size: cover; /* 以填充整个元素为目标 */
  background-repeat: no-repeat; /* 不重复平铺背景图 */
  background-position: center; /* 图片居中显示 */
}

.el-carousel__item:nth-child(6n+1) {
  background-image: url('@/assets/pic/pku.png');
  background-size: cover; /* 以填充整个元素为目标 */
  background-repeat: no-repeat; /* 不重复平铺背景图 */
  background-position: center; /* 图片居中显示 */
}
.el-carousel__item:nth-child(6n+2) {
  background-image: url('@/assets/pic/sjtu.png');
  background-size: cover; /* 以填充整个元素为目标 */
  background-repeat: no-repeat; /* 不重复平铺背景图 */
  background-position: center; /* 图片居中显示 */
}
.el-carousel__item:nth-child(6n+3) {
  background-image: url('@/assets/pic/fdu.png');
  background-size: cover; /* 以填充整个元素为目标 */
  background-repeat: no-repeat; /* 不重复平铺背景图 */
  background-position: center; /* 图片居中显示 */
}
.el-carousel__item:nth-child(6n+4) {
  background-image: url('@/assets/pic/ustc.png');
  background-size: cover; /* 以填充整个元素为目标 */
  background-repeat: no-repeat; /* 不重复平铺背景图 */
  background-position: center; /* 图片居中显示 */
}
.el-carousel__item:nth-child(6n+5) {
  background-image: url('@/assets/pic/xdu.png');
  background-size: cover; /* 以填充整个元素为目标 */
  background-repeat: no-repeat; /* 不重复平铺背景图 */
  background-position: center; /* 图片居中显示 */
}
</style>
