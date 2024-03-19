<!--
*@oneSchool
*@author Jinli
*@date 2024/3/19 0:00
-->
<template>
  <div>
    <h1>
      hello, {{ school }}
    </h1>
  </div>
</template>

<script>
export default {
  name: "oneSchool",
  props: {},
  components: {},
  data() {
    return {
      school: '',
      pageNum: 1,
      pageSize: 10, // 设置默认值，根据需要调整
    }
  },
  created() {
  },
  mounted() {
    let school = this.$route.query.school
    this.school = school
    if (!school) {
      return
    }
    this.load()
  },
  methods: {
    load() {
      if (this.pageNum) { // 使用 this.pageNum 而不是 pageNum
        this.pageNum = this.pageNum;
      }
      this.$request.get('/tables/selectBySchool', {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          school: this.school
        }
      }).then(res => {
        if (res.data) {
          // 确保在访问其属性之前，res.data不为null
          this.schools = res.data.records;
          console.log('Response data:', res.data);
          this.total = res.data.total;
        } else {
          // 处理res.data为null的情况
          this.schools = [];
          this.total = 0;
        }
      }).catch(error => {
        console.error('Error fetching data:', error);
      });
    }

  },
}
</script>

<style>

</style>
