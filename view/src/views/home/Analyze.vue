<template>
  <div>
    <div>
      <div style="margin-bottom: 10px">
        <el-input style="width: 200px" placeholder="查询城市" v-model="city"></el-input>
        <el-button type="primary" @click="load(1)" style="margin-left: 10px">查询</el-button>
        <el-button type="warning" @click="reset">重置</el-button>
      </div>
      <el-card style="width: 100%">
        <div slot="header" class="clearfix">
          <span>数据</span>
        </div>
        <div>
          <el-table :data="tableData" stripe :header-cell-style="{backgroundColor: 'aliceblue', fontWeight: 'bold', color: '#666'}" @selection-change="handleSelectionChange">
            <el-table-column type="selection" align="center"></el-table-column>
            <el-table-column label="school" prop="school" align="center"></el-table-column>
            <el-table-column label="sub" prop="sub" align="center"></el-table-column>
            <el-table-column label="city" prop="city" align="center" show-overflow-tooltip></el-table-column>
            <el-table-column label="person23" prop="person23" align="center"></el-table-column>
            <el-table-column label="person22" prop="person22" align="center"></el-table-column>
            <el-table-column label="person21" prop="person21" align="center"></el-table-column>
          </el-table>
          <div style="margin: 10px 0">
            <el-pagination
                @current-change="handleCurrentChange"
                :current-page="pageNum"
                :page-sizes="[100, 200, 300, 400]"
                :page-size="pageSize"
                layout="total,prev, pager, next"
                :total="total">
            </el-pagination>
          </div>
        </div>
      </el-card>
    </div>
    <el-button @click="drawer = true" type="primary" style="margin-left: 16px;">
      点我打开
    </el-button>
    <div style="background-color: #409EFF">
      <el-drawer
          title="选择"
          :visible.sync="drawer"
          size="50%"
      >
        <el-button @click="schoolDrawer = true">学校</el-button>
        <el-button @click="areaDrawer = true">地区</el-button>
        <el-button @click="gradeDrawer = true">分数线</el-button>
        <div>
          <el-drawer
              title="选择学校"
              size="40%"
              :append-to-body="true"
              :before-close="handleClose"
              :visible.sync="schoolDrawer"
          >
            <el-button @click="schoolDrawer = false">返回</el-button>
            <p>_(:зゝ∠)_</p>
          </el-drawer>
        </div>
        <div>
          <el-drawer
              title="选择地区"
              size="40%"
              :append-to-body="true"
              :before-close="handleClose"
              :visible.sync="areaDrawer"
          >
            <el-button @click="areaDrawer = false">返回</el-button>
            <p>_(:зゝ∠)_</p>
            <el-button>华北</el-button>
            <el-button>华南</el-button>
            <el-button>华中</el-button>
            <el-button>华西</el-button>
            <el-button>华东</el-button>
          </el-drawer>
        </div>
        <div>
          <el-drawer
              title="选择分数线"
              size="40%"
              :append-to-body="true"
              :before-close="handleClose"
              :visible.sync="gradeDrawer"
          >
            <el-button @click="gradeDrawer = false">返回</el-button>
            <p>_(:зゝ∠)_</p>
            <el-card style="width: 95%;margin-left: 20px">
              <div class="block" style="width: 80%; margin-left: 20px">
                <el-slider
                    v-model="value"
                    range
                    show-stops
                    :min="250"
                    :max="500"
                    :marks="marks">
                </el-slider>
              </div>
            </el-card>
          </el-drawer>
        </div>
      </el-drawer>
    </div>


    <div>
      <el-row :gutter="20">
        <el-col :span="6">
          <div>
            <el-statistic
                group-separator=","
                :value="value2"
                :title="title"
            ></el-statistic>
          </div>
        </el-col>
        <el-col :span="6">
          <div>
            <el-statistic title="已统计院校">
              <template slot="formatter">
                15
              </template>
            </el-statistic>
          </div>
        </el-col>
        <el-col :span="6">
          <div>
            <el-statistic
                group-separator=","
                :precision="2"
                decimal-separator="."
                :value="value1"
                :title="title"
            >
              <template slot="prefix">
                <i class="el-icon-s-flag" style="color: red"></i>
              </template>
              <template slot="suffix">
                <i class="el-icon-s-flag" style="color: blue"></i>
              </template>
            </el-statistic>
          </div>
        </el-col>
        <el-col :span="6">
          <div>
            <el-statistic :value="like ? 521 : 520" title="Feedback">
              <template slot="suffix">
              <span @click="like = !like" class="like">
                <i
                    class="el-icon-star-on"
                    style="color:red"
                    v-show="!!like"
                ></i>
                <i class="el-icon-star-off" v-show="!like"></i>
              </span>
              </template>
            </el-statistic>
          </div>
        </el-col>
      </el-row>
    </div>

  </div>
</template>

<script>
import gsap from 'gsap';
import lottie from "vue-lottie";
import * as animationData from '../../assets/load.json';
export default {
  name: 'analyze',
  data() {
    return {
      drawer: false,
      schoolDrawer: false,
      areaDrawer: false,
      gradeDrawer: false,
      user: JSON.parse(localStorage.getItem('pilot') || '{}'),
      tableData: [],
      pageNum: 1,
      pageSize: 5,
      city: '',
      total: 0,
      formVisible: false,
      form: {
        title: '',
        description: '',
        content: '',
      },
      ids: [],
      content: '',
      rules: {
        school: [
          {required: true, message: '请输入学校', trigger: 'blur'}
        ],
        sub: [
          {required: true, message: '请选择学科', trigger: 'blur'}
        ]
      },
      value: [300, 350],
      marks: {
        250: '250',
        300: '300',
        350: '350',
        400: '400',
        450: '450',
        500: '500',
      },
      like: true,
      value1: 4154.564,
      value2: 1314,
      title: "已注册用户",
    }
  },
  mounted() {
    if (!this.user.id) {
      this.$router.push('/login')
    }
    this.load()
  },
  methods: {
    handleSelectionChange(rows) {
      this.ids = rows.map(v => v.id)
      console.log(rows)
    },
    reset() {
      this.city = ''
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
          city: this.city
        }
      }).then(res => {
        if (res.data) {
          // 确保在访问其属性之前，res.data不为null
          this.tableData = res.data.records || [];
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
    handleClose() {
      // 处理关闭抽屉的逻辑，例如将抽屉的 visible 设置为 false
      this.drawer = false;
      this.schoolDrawer = false;
      this.areaDrawer = false;
      this.gradeDrawer = false;
    }
  }
}
</script>

<style>
.like {
  cursor: pointer;
  font-size: 25px;
  display: inline-block;
}
</style>
