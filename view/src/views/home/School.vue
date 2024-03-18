<template>
  <div>

    <div>
      <el-button @click="show2 = !show2" >地区</el-button>
      <div style="display: flex; flex-wrap: wrap; margin-top: 20px; height: auto;">
        <transition name="el-zoom-in-center">
          <div v-if="show2" style="margin-right: 10px; margin-bottom: 10px;" @click="square='A'; load(1)">
            <el-button type="primary">A</el-button>
          </div>
        </transition>

        <transition name="el-zoom-in-top">
          <div v-if="show2" style="margin-right: 10px; margin-bottom: 10px;" @click="square='B'; load(1)">
            <el-button type="primary">B</el-button>
          </div>
        </transition>

        <transition name="el-zoom-in-bottom">
          <div v-if="show2" style="margin-right: 10px; margin-bottom: 10px;" @click="square='C'; load(1)">
            <el-button type="primary">C</el-button>
          </div>
        </transition>
      </div>

    </div>

    <div>
      <el-row :gutter="20" style="padding: 8px">
        <el-col :span="6" v-for="school in schools" :key="school.id" style="padding: 10px">
          <el-card class="card-item" style="cursor: pointer">
            <div slot="header">
              <span>{{ school.school }}</span>
            </div>
            <div>
              <p>城市: {{ school.city }}</p>
              <p>地区: {{ school.square }}</p>
              <div slot="footer">
                <el-button @click="$router.push('One?school=' + school.school)" size="mini">查看详情</el-button>
              </div>
              <!-- 在这里添加更多数据 -->
            </div>

          </el-card>
        </el-col>
      </el-row>
    </div>

    <div style="margin-top: 20px">
      <transition name="fade">
        <el-row :gutter="20">
          <el-col :span="6">
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
          </el-col>
          <el-col :span="6">
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
          </el-col>
          <el-col :span="6">
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
          </el-col>
          <el-col :span="6">
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
          </el-col>
        </el-row>
      </transition>
    </div>

  </div>
</template>

<script>
import gsap from 'gsap';
import lottie from "vue-lottie";
import * as animationData from '../../assets/load.json';
export default {
  name: 'school',
  data() {
    return {
      drawer: false,
      schoolDrawer: false,
      areaDrawer: false,
      gradeDrawer: false,
      user: JSON.parse(localStorage.getItem('pilot') || '{}'),
      pageNum: 1,
      pageSize: 7,
      school: '',
      square: '',
      schools: [],
      total: 0,
      form: {
        title: '',
        description: '',
        content: '',
      },
      ids: [],
      content: '',
      deadline: new Date("2024-12-25"),
      title1: "已注册用户",
      title2: "已上传院校数量",
      title3: "网页访问量",
      value1: 4154.564,
      value2: 1314,
      value3: 1314,
      show2: false
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
      this.$request.get('/tables/selectByPage', {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          square: this.square
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

.fade-enter-active, .fade-leave-active {
  transition: opacity 0.5s;
}
.fade-enter, .fade-leave-to {
  opacity: 0;
}
.data-container {

}
</style>
