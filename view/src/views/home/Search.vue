<template>
  <div>
    <el-container class="background-image-container">
      <div style="backdrop-filter: blur(8px); width: 95%; height: 95%; border-radius: 2%;">
        <el-tabs v-model="activeName" @tab-click="handleClick">
          <el-tab-pane label="院校库" name="first" @click="load(1)">
            <School/>
          </el-tab-pane>
          <el-tab-pane label="专业库" name="second" @click="load1(1)">
            <Sub/>
          </el-tab-pane>
          <el-tab-pane label="智能推荐" name="third">角色管理</el-tab-pane>
        </el-tabs>
      </div>
    </el-container>
  </div>
</template>

<script>
import gsap from 'gsap';
import lottie from "vue-lottie";
import * as animationData from '../../assets/load.json';
import Sub from "@/components/Sub.vue";
import School from "@/components/School.vue";
export default {
  components:{
    Sub,School
  },
  name: 'search',
  data() {
    return {
      user: JSON.parse(localStorage.getItem('pilot') || '{}'),
      ids: [],
      content: '',
      value: [300, 350],
      marks: {
        200: '200',
        300: '300',
        400: '400',
        350: {
          style: {
            color: '#1989FA'
          },
          label: this.$createElement('strong', '350')
        }
      },
      activeName: 'first',
    }
  },
  created() {
    if (!this.user.id) {
      this.$router.push('/login')
    }
    this.load()
  },
  mounted() {

  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
    handleSelectionChange(rows) {
      this.ids = rows.map(v => v.id)
      console.log(rows)
    },
    reset() {
      this.square = ''
      this.load()
    },
    load(pageNum) {
      if (pageNum) {
        this.pageNum = pageNum
      }
      const city = this.value1.join(',')
      this.$request.get('/tables/selectBySchool', {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          square: this.square,
          city: city
        }
      }).then(res => {
        if (res.data) {
          // 确保在访问其属性之前，res.data不为null
          this.schools = res.data.records;
          console.log('Response data:', res.data);
          this.total = res.data.total;
        } else {
          // 处理res.data为null的情况
          this.tableData = [];
          this.total = 0;
        }
      });
    },
    load1(pageNum) {
      if (pageNum) {
        this.pageNum = pageNum
      }
      const sub = this.value2.join(',')
      this.$request.get('/tables/selectBySub', {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          sub: sub
        }
      }).then(res => {
        if (res.data) {
          // 确保在访问其属性之前，res.data不为null
          this.schools = res.data.records;
          console.log('Response data:', res.data);
          this.total = res.data.total;
        } else {
          // 处理res.data为null的情况
          this.tableData = [];
          this.total = 0;
        }
      });
    },

    handleCurrentChange(pageNum) {
      this.pageNum = pageNum
      this.load()
    },

  }
}
</script>

<style>
.background-image-container {
  background-image: url('@/assets/pic/up.png');
  background-size: cover; /* 将背景图片铺满整个容器 */
  background-position: center; /* 图片居中显示 */
  height: 84vh; /* 调整容器的高度，根据需要更改 */
  background-size: 75%; /* 缩小背景图片 */
  display: flex;
  justify-content: center;
  align-items: center;
  color: white; /* 文字颜色 */
}

.like {
  cursor: pointer;
  font-size: 25px;
  display: inline-block;
}

.card-item {
  transition: transform 0.3s ease-in-out;
}

.card-item:hover {
  transform: scale(1.1);
}

</style>
