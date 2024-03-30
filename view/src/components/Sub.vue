<!--
*@Sub
*@author Jinli
*@date 2024/3/24 19:15
-->
<template>
  <div>
    <div>
      <el-row :gutter="20">
        <el-col :span="6">
          <div style="display: flex">
            <el-button style="margin-right: 15px">专业</el-button>
            <el-select v-model="value2" multiple placeholder="请选择">
              <el-option
                  v-for="item in options2"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </div>
        </el-col>
        <el-col :span="1">
          <el-button @click="load1(1)">查询</el-button>
        </el-col>
      </el-row>
    </div>

    <div>
      <el-row :gutter="20" style="padding: 8px">
        <el-col :span="6" v-for="school in schools" :key="school.id" style="padding: 10px">
          <el-card class="card-item" style="cursor: pointer; background-size: cover" :style="{ backgroundImage: 'url(' + school.pic + ')' }">
            <div slot="header">
              <span>{{ school.school }}</span>
            </div>
            <div>
              <p>城市: {{ school.city }}</p>
              <p>专业: {{ school.sub }}</p>
              <div slot="footer">
                <el-button @click="$router.push('Subinfo?id=' + school.id)" size="mini">查看详情</el-button>
              </div>
              <!-- 在这里添加更多数据 -->
            </div>
          </el-card>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "Sub",
  props: {},
  components: {},
  data() {
    return {
      pageNum: 1,
      pageSize: 100,
      sub:'',
      schools: [],
      total: 0,
      form: {
        title: '',
        description: '',
        content: '',
      },
      options2: [{
        value: '计算机科学与技术',
        label: '计算机科学与技术'
      }, {
        value: '软件工程',
        label: '软件工程'
      }, {
        value: '网络安全',
        label: '网络安全'
      }, {
        value: '电子信息',
        label: '电子信息'
      }, {
        value: '人工智能',
        label: '人工智能'
      }, {
        value: '大数据',
        label: '大数据'
      }],
      value2: [],
    }
  },
  created() {
    this.load1()
  },
  mounted: {},
  methods: {
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
  },
}
</script>

<style>

</style>
