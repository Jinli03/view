<template>
  <div>
    <el-container class="background-image-container">
      <div style=" width: 95%; height: 95%">
        <el-row :gutter="50">

          <el-col :span="6" style="height: 750px; border-radius: 10px; padding: 1px; ">
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
                  <template>
                    <a-popover title="Todo-List">
                      <template slot="content">
                        <p><a-checkbox @change="onChange">高数第一讲</a-checkbox></p>
                        <p><a-checkbox @change="onChange">英语单词</a-checkbox></p>
                        <p><a-checkbox @change="onChange">跑步</a-checkbox></p>
                        <p><a-checkbox @change="onChange">专业课习题</a-checkbox></p>
                      </template>
                      <a-button  style="width: 235px; background-color: white; color: black;border-color: white;display: inline-block">

                        <p><i class="el-icon-edit-outline"></i>    备忘录</p>
                      </a-button>
                    </a-popover>
                  </template>
                </el-card>
                <lottie :options="defaultOptions" :height="170" :width="300" @animCreated="handleAnimation"/>


              </el-row>
            </div>
          </el-col>



          <el-col :span="11" style="backdrop-filter: blur(10px);margin-right: 40px;">
<!--              <div style="margin-left: 50px; margin-right: 50px">-->
<!--                <template>-->
<!--                  <el-carousel :interval="3000" type="card" height="140px">-->
<!--                    <el-carousel-item v-for="item in 6" :key="item">-->
<!--                    </el-carousel-item>-->
<!--                  </el-carousel>-->
<!--                </template>-->
<!--              </div>-->
            <template>
              <a-comment>
                <template slot="actions">
      <span key="comment-basic-like">
        <a-tooltip title="Like">
          <a-icon type="like" :theme="action === 'liked' ? 'filled' : 'outlined'" @click="like" />
        </a-tooltip>
        <span style="padding-left: 8px;cursor: auto">
          {{ likes }}
        </span>
      </span>
                  <span key="comment-basic-dislike">
        <a-tooltip title="Dislike">
          <a-icon
              type="dislike"
              :theme="action === 'disliked' ? 'filled' : 'outlined'"
              @click="dislike"
          />
        </a-tooltip>
        <span style="padding-left: 8px;cursor: auto">
          {{ dislikes }}
        </span>
      </span>
                  <span key="comment-basic-reply-to">Reply to</span>
                </template>
                <a slot="author">Han Solo</a>
                <a-avatar
                    slot="avatar"
                    src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
                    alt="Han Solo"
                />
                <p slot="content" style="color: #000c17">
                  We supply a series of design principles, practical patterns and high quality design resources
                  (Sketch and Axure), to help people create their product prototypes beautifully and
                  efficiently.
                </p>
                <a-tooltip slot="datetime" :title="moment().format('YYYY-MM-DD HH:mm:ss')">
                  <span>{{ moment().fromNow() }}</span>
                </a-tooltip>
              </a-comment>
            </template>

            <template>
              <a-list
                  class="comment-list"
                  :header="`${data.length} replies`"
                  item-layout="horizontal"
                  :data-source="data"
              >
                <span key="comment-basic-like">
        <a-tooltip title="Like">
          <a-icon type="like" :theme="action === 'liked' ? 'filled' : 'outlined'" @click="like" />
        </a-tooltip>
        <span style="padding-left: 8px;cursor: auto">
          {{ likes }}
        </span>
      </span>
                <span key="comment-basic-dislike">
        <a-tooltip title="Dislike">
          <a-icon
              type="dislike"
              :theme="action === 'disliked' ? 'filled' : 'outlined'"
              @click="dislike"
          />
        </a-tooltip>
        <span style="padding-left: 8px;cursor: auto">
          {{ dislikes }}
        </span>
      </span>
                <a-list-item slot="renderItem" slot-scope="item, index">
                  <a-comment :author="item.author" :avatar="item.avatar">
                    <template slot="actions">
                      <span v-for="action in item.actions">{{ action }}</span>
                    </template>
                    <p slot="content">
                      {{ item.content }}
                    </p>
                    <a-tooltip slot="datetime" :title="item.datetime.format('YYYY-MM-DD HH:mm:ss')">
                      <span>{{ item.datetime.fromNow() }}</span>
                    </a-tooltip>
                  </a-comment>
                </a-list-item>
              </a-list>
            </template>

            <el-steps :space="300" :active="1" finish-status="success" style="margin-top: 60px;width: 900px">
              <el-step title="决心" style="color: #000c17" ></el-step>
              <el-step title="努力" ></el-step>
              <el-step title="上岸" ></el-step>
            </el-steps>

          </el-col>



          <div>
            <template>
              <div  style="display: flex; justify-content: space-between; margin-bottom: 2px;margin-top: 1px;">
                <a-progress type="circle" :percent="75" :format="percent => ` 数学`" />
                <a-progress type="circle" :percent="100" :format="() => '英语'" />
                <a-progress type="circle" :percent="25" status="exception" :format="() => '专业课'">
                  <template #format="percent">
                    <span style="color: red">{{ percent }}</span>
                  </template>
                </a-progress>
              </div>
            </template>
          </div>


          <el-col :span="6" style=" border-radius: 10px; padding: 10px">
            <div>
              <el-row style="margin-bottom: 10px">
                <template>
                  <a-card  style="background-size: cover; border-radius: 20px;background-color: rgba(255,255,255,0.71)" >
                    <p style="text-align: center;margin-bottom: -15px;margin-top: -10px">每日箴言</p>
                    <el-divider class="centered-divider" style="margin-top: -5px; background-color: rgba(255,255,255,0.11)"></el-divider>
                    <p style="font-size: 14px; color: rgba(0, 0, 0, 0.85); margin-bottom: 16px; font-weight: 500;font-family: 楷体">
                      "最可怕的敌人，就是没有坚强的信念。"</p>

                    <p style=" font-family: 楷体; text-indent: 14em;font-size: 14px; color: rgba(0, 0, 0, 0.85); margin-bottom: 16px; font-weight: 500">           ——罗曼·罗兰</p>

                  </a-card>
                  <template>
                    <div>
                      <el-button icon="el-icon-star-off" circle @click="show2 = !show2" style="background-color: rgba(255,255,255,0);margin-top: 10px;border-color: #ffffff">心愿单</el-button>
                      <transition>
                        <div v-show="show2" style="margin-left:240px;margin-top:-25px;margin-bottom: -15px" >
                          <p style="font-size: 15px">
                            <a-button style="border-color: rgba(255,255,255,0)" ghost @click="$router.push('PersonWishes?name=' + user.name)">查看全部<a-icon  style="margin-left: 1px" type="double-right" /></a-button>
                          </p>
                        </div>
                      </transition>

                      <transition><div v-show="show2" style="padding-top: -30px;"> <el-divider content-position="right" style="background-color: rgba(255,255,255,0);"></el-divider></div></transition>

                      <div v-show="show2" style="display: flex; margin-top: 20px; height: 100px;">
                        <transition name="el-zoom-in-center" >
                          <div style="background-color: rgba(255,255,255,0.67); border-radius: 50%;" v-show="show2" class="transition-box">
                            <p style="color: #000c17; font-size: 12px; ">上海理工大学</p>
                          </div>

                        </transition>

                        <transition name="el-zoom-in-top">
                          <div style="background-color: rgba(255,255,255,0.67); border-radius: 50%;" v-show="show2" class="transition-box">
                            <p style="color: #000c17; font-size: 12px; ">华东理工大学</p>
                          </div>
                        </transition>

                        <transition name="el-zoom-in-bottom">
                          <div style="background-color: rgba(255,255,255,0.67); border-radius: 60%;" v-show="show2" class="transition-box">
                            <p style="color: #000c17; font-size: 12px; ">上海交通大学</p>
                          </div>
                        </transition>
                      </div>

                      <transition><div v-show="show2"> <el-divider></el-divider></div></transition>
                    </div>
                  </template>



                  <el-carousel :interval="4000" type="card" height="150px":width="300">
                    <el-carousel-item v-for="item in 6" :key="item">
                      <h3 class="medium">{{ item }}</h3>
                      <p class="english-word">{{ words[item-1].word }}       {{ words[item-1].chinese }}    </p>

                    </el-carousel-item>
                  </el-carousel>
                  <el-col :span="6">
                    <a-button ghost @click="handleRandom">
                      <a-icon type="redo" />
                    </a-button>
                  </el-col>
                </template>
              </el-row>
            </div>
            <div>
              <i class="el-icon-top" style="font-size: 80px;"></i>
              <i class="el-icon-top" style="font-size: 80px;"></i>
              <i class="el-icon-top" style="font-size: 80px;"></i>
              <i class="el-icon-top" style="font-size: 80px;"></i>
              <p style="font-size:28px;color: #ffffff">Attention!Focus on youself</p>

            </div>
          </el-col>
        </el-row>

      </div>
    </el-container>
  </div>

</template>



  <div>
    <p>每天都要记得来打卡哦！！！</p>
  </div>




<script>
export default {
  data: () => ({
    show2: true
  })
}
</script>

<script>
import lottie from "vue-lottie";
import * as animationData from '../../assets/one.json'
import moment from 'moment';
export default {

  components:{
    lottie
  },
  name: "Personal",
  data() {

    return {
      show2:true,
      defaultOptions:{
        animationData:animationData
      },
      data: [
        {
          actions: ['Reply to'],
          author: 'Han Solo',
          avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
          content:
              'We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently.',
          datetime: moment().subtract(1, 'days'),
        },
        {
          actions: ['Reply to'],
          author: 'Han Solo',
          avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
          content:
              'We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently.',
          datetime: moment().subtract(2, 'days'),
        },
      ],
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
      words: [],
      infs: [],
      likes: 0,
      dislikes: 0,
      action: null,

      moment,
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
    this.handleRandom()
    this.select()
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

    handleAnimation:function (anim){
      this.anim=anim;
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
    },
    select() {
      this.$request.get('/wishes/selectThree', {
        params: {
          name: this.user.name
        }
      }).then(res => {
        if (res.data) {
          // 确保在访问其属性之前，res.data不为null
          this.infs = res.data;
          console.log('Response data:', res.data);
        } else {
        }
      });
    },

    like() {
      this.likes = 1;
      this.dislikes = 0;
      this.action = 'liked';
    },
    dislike() {
      this.likes = 0;
      this.dislikes = 1;
      this.action = 'disliked';
    },
  }



};
</script>

<style scoped>

.heart {
  width: 100px; /* 调整心形的大小 */
  height: 100px; /* 调整心形的大小 */
  background-color: red; /* 心形的颜色 */
  position: relative;
  transform: rotate(-45deg);
  margin: 50px;
}

.heart::before,
.heart::after {
  content: '';
  width: 100px; /* 调整心形的大小 */
  height: 100px; /* 调整心形的大小 */
  background-color: red; /* 心形的颜色 */
  border-radius: 50%;
  position: absolute;
  top: 0;
}

.heart::before {
  left: -50px;
}

.heart::after {
  left: 50px;
}




.english-word {
  color: #333; /* 设置颜色 */
  font-size: 25px; /* 设置字体大小 */
  text-align: center; /* 设置文本居中 */
  margin-top: 10px; /* 设置上边距 */
}


.transition-box {
  margin-bottom: 10px;
  width: 200px;
  height: 100px;
  border-radius: 4px;
  background-color: #409EFF;
  text-align: center;
  color: #fff;
  padding: 40px 20px;
  box-sizing: border-box;
  margin-right: 20px;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

.background-image-container {
  background-image: url('@/assets/background/person1.jpg');
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

.english-word{
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: white;
  font-size: 14px;
  font-weight: bold;
  text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.5); /* 添加文字阴影效果以提高可读性 */
}



 div.ant-progress-circle,
 div.ant-progress-line {
   margin-right: 8px;
   margin-bottom: 8px;
 }

</style>








