<!--
*@PersonWishes
*@author Jinli
*@date 2024/4/6 1:23
-->
<template>
  <div>
    <el-card>
      <el-table
          :data="tables"
          style="width: 100%"
          height="250">
        <el-table-column
            fixed
            prop="school"
            label="学校"
            width="150"
            align="center">
        </el-table-column>
        <el-table-column
            prop="sub"
            label="专业"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="subcode"
            label="专业代码"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="city"
            label="城市"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="square"
            label="地区"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="person21"
            label="21年招收人数"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="person22"
            label="22年招收人数"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="person23"
            label="23年招收人数"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="rescore21"
            label="21年复试分数"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="rescore22"
            label="22年复试分数"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="rescore23"
            label="23年复试分数"
            width="120"
            align="center">
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "PersonWishes",
  props: {},
  components: {},
  data() {
    return {
      name: '',
      tables: []
    }
  },
  created() {
  },
  mounted() {
    let name = this.$route.query.name
    this.name = name
    this.load()
  },
  methods: {
    load() {
      let name = this.name
      this.$request.get('/wishes/selectAll/' + name).then(res => {
        this.tables = res.data
        console.log(tables)
      }).catch(error => {
        console.error('Error fetching data:', error);
      });
    }
  }
}
</script>

<style>

</style>
