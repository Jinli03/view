<template>
  <div style="margin-left: 10px">
    <el-row :gutter="20" style="display: flex">
      <el-col :span="12">
        <div style="display: flex; justify-content: center;">
          <div id="echart" style="width: 580px; height:580px; margin-right: auto; "></div>
        </div>
      </el-col>
      <el-col :span="12">
        <el-card>
          <el-collapse v-model="activeName" accordion>
            <el-collapse-item title="A区" name="1">
              <div>北京、天津、上海、江苏、浙江、福建、山东、河南、湖北、湖南、广东、河北、山西、辽宁、吉林、黑龙江、安徽、江西、重庆、四川、陕西21个省 (市)</div>
            </el-collapse-item>
            <el-collapse-item title="B区" name="2">
              <div>内蒙古、广西、海南、贵州、云南、西藏、甘肃、青海、宁夏、新疆10个省 (区)</div>
            </el-collapse-item>
          </el-collapse>
          <el-button @click="$router.push('Sear')" size="mini">查看详情</el-button>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import * as echarts from 'echarts';
const option1 = {
  title: {
    text: '学校概览',
    textStyle: {
      fontSize: 14,
      align: 'right'
    },
    subtextStyle: {
      align: 'right'
    },
    sublink: 'https://worldcoffeeresearch.org/work/sensory-lexicon/'
  },
  series: {
    type: 'sunburst',
    radius: [0, '110%'],
    data: [],
    sort: undefined,
    emphasis: {
      focus: 'ancestor'
    },
    levels: [
      {},
      {
        r0: '15%',
        r: '35%',
        itemStyle: {
          borderWidth: 2
        },
        label: {
          rotate: 'tangential'
        }
      },
      {
        r0: '35%',
        r: '70%',
        label: {
          align: 'right'
        }
      },
      {
        r0: '70%',
        r: '72%',
        label: {
          position: 'outside',
          padding: 3,
          silent: false
        },
        itemStyle: {
          borderWidth: 3
        }
      }
    ]
  }
}

export default {

  name: "Echarts",
  props: {},
  components: {},
  data() {
    return {
      chart: null,
      data1 : [
        {
          name: 'A区',
          itemStyle: {
            color: '#da1d23'
          },
          children: [
            {
              name: '北京',
              itemStyle: {
                color: '#dd4c51'
              },
              children: [
                {
                  name: '北京大学',
                  value: 1,
                  itemStyle: {
                    color: '#dd4c51'
                  }
                },
                {
                  name: '清华大学',
                  value: 1,
                  itemStyle: {
                    color: '#dd4c51'
                  }
                },
                {
                  name: '北京航天航空大学',
                  value: 1,
                  itemStyle: {
                    color: '#dd4c51'
                  }
                },
                {
                  name: '中国人民大学',
                  value: 1,
                  itemStyle: {
                    color: '#dd4c51'
                  }
                },

                {
                  name: '北京师范大学',
                  value: 1,
                  itemStyle: {
                    color: '#dd4c51'
                  }
                },

                {
                  name: '中国农业大学',
                  value: 1,
                  itemStyle: {
                    color: '#dd4c51'
                  }
                },

                {
                  name: '中央民族大学',
                  value: 1,
                  itemStyle: {
                    color: '#dd4c51'
                  }
                },
              ]
            },
            {
              name: '天津',
              itemStyle: {
                color: '#c944b3'
              },children: [
                {
                  name: '天津大学',
                  value: 1,
                  itemStyle: {
                    color: '#c944b3'
                  }
                },

                {
                  name: '南开大学',
                  value: 1,
                  itemStyle: {
                    color: '#c944b3'
                  }
                },
               ]
            },
            {
              name: '辽宁',
              itemStyle: {
                color: '#b744c9'
              },children: [
                {
                  name: '大连理工大学',
                  value: 1,
                  itemStyle: {
                    color: '#b744c9'
                  }
                },

                {
                  name: '东北大学',
                  value: 1,
                  itemStyle: {
                    color: '#b744c9'
                  }
                },
              ]
            },
            {
              name: '吉林',
              itemStyle: {
                color: '#8944c9'
              },children: [
                {
                  name: '吉林大学',
                  value: 1,
                  itemStyle: {
                    color: '#8944c9'
                  }
                }
              ]
            },
            {
              name: '黑龙江',
              itemStyle: {
                color: '#445ac9'
              },children: [
                {
                  name: '哈尔滨工业大学',
                  value: 1,
                  itemStyle: {
                    color: '#445ac9'
                  }
                }
              ]
            },
            {
              name: '上海',
              itemStyle: {
                color: '#4487c9'
              },children: [
                {
                  name: '上海交通大学',
                  value: 1,
                  itemStyle: {
                    color: '#4487c9'
                  }
                },

                {
                  name: '复旦大学',
                  value: 1,
                  itemStyle: {
                    color: '#4487c9'
                  }
                }, {
                  name: '同济大学',
                  value: 1,
                  itemStyle: {
                    color: '#4487c9'
                  }
                }, {
                  name: '华东师范大学',
                  value: 1,
                  itemStyle: {
                    color: '#4487c9'
                  }
                },
              ]
            },
            {
              name: '江苏',
              itemStyle: {
                color: '#44b5c9'
              },children: [
                {
                  name: '南京大学',
                  value: 1,
                  itemStyle: {
                    color: '#44b5c9'
                  }
                },
                {
                  name: '东南大学',
                  value: 1,
                  itemStyle: {
                    color: '#44b5c9'
                  }
                },
              ]
            },
            {
              name: '浙江',
              itemStyle: {
                color: '#44c9b5'
              },children: [
                {
                  name: '浙江大学',
                  value: 1,
                  itemStyle: {
                    color: '#44c9b5'
                  }
                }
              ]
            },
            {
              name: '安徽',
              itemStyle: {
                color: '#44c9b9'
              },children: [
                {
                  name: '中国科学技术大学',
                  value: 1,
                  itemStyle: {
                    color: '#44c9b9'
                  }
                }
              ]
            },
            {
              name: '福建',
              itemStyle: {
                color: '#44c98d'
              },children: [
                {
                  name: '厦门大学',
                  value: 1,
                  itemStyle: {
                    color: '#44c98d'
                  }
                }
              ]
            },
            {
              name: '江西',
              itemStyle: {
                color: '#44c97e'
              },children: [
                {
                  name: '南昌大学',
                  value: 1,
                  itemStyle: {
                    color: '#44c97e'
                  }
                }
              ]
            },
            {
              name: '山东',
              itemStyle: {
                color: '#44c946'
              },children: [
                {
                  name: '山东大学',
                  value: 1,
                  itemStyle: {
                    color: '#44c946'
                  }
                },    {
                  name: '中国海洋大学',
                  value: 1,
                  itemStyle: {
                    color: '#44c946'
                  }
                },
              ]
            },
            {
              name: '河南',
              itemStyle: {
                color: '#89c944'
              },children: [
                {
                  name: '郑州大学',
                  value: 1,
                  itemStyle: {
                    color: '#89c944'
                  }
                }
              ]
            },
            {
              name: '湖北',
              itemStyle: {
                color: '#b7c944'
              },children: [
                {
                  name: '华中科技大学',
                  value: 1,
                  itemStyle: {
                    color: '#b7c944'
                  }
                }, {
                  name: '武汉大学',
                  value: 1,
                  itemStyle: {
                    color: '#b7c944'
                  }
                },
              ]
            },
            {
              name: '湖南',
              itemStyle: {
                color: '#c9a344'
              },children: [
                {
                  name: '湖南大学',
                  value: 1,
                  itemStyle: {
                    color: '#c9a344'
                  }
                },
                {
                  name: '中南大学',
                  value: 1,
                  itemStyle: {
                    color: '#c9a344'
                  }
                },
                {
                  name: '国防科技大学',
                  value: 1,
                  itemStyle: {
                    color: '#c9a344'
                  }
                },
              ]
            },
            {
              name: '广东',
              itemStyle: {
                color: '#c99444'
              },children: [
                {
                  name: '中山大学',
                  value: 1,
                  itemStyle: {
                    color: '#c99444'
                  }
                },{
                  name: '华南理工大学',
                  value: 1,
                  itemStyle: {
                    color: '#c99444'
                  }
                },
              ]
            },
            {
              name: '重庆',
              itemStyle: {
                color: '#c97744'
              },children: [
                {
                  name: '重庆大学',
                  value: 1,
                  itemStyle: {
                    color: '#c97744'
                  }
                }
              ]
            },
            {
              name: '四川',
              itemStyle: {
                color: '#c94444'
              },children: [
                {
                  name: '四川大学',
                  value: 1,
                  itemStyle: {
                    color: '#c94444'
                  }
                },{
                  name: '电子科技大学',
                  value: 1,
                  itemStyle: {
                    color: '#c94444'
                  }
                },
              ]
            },
            {
              name: '陕西',
              itemStyle: {
                color: 'rgba(68,201,121,0.9)'
              },children: [
                {
                  name: '西安交通大学',
                  value: 1,
                  itemStyle: {
                    color: 'rgba(68,201,121,0.9)'
                  }
                }, {
                  name: '西北工业大学',
                  value: 1,
                  itemStyle: {
                    color: 'rgba(68,201,121,0.9)'
                  }
                },
              ]
            },
            {
              name: '河北',
              itemStyle: {
                color: 'rgba(76,127,221,0.91)'
              },
              children: [
                {
                  name: '河北工业大学',
                  value: 1,
                  itemStyle: {
                    color: 'rgba(76,127,221,0.91)'
                  }
                },


              ]
            },
            {
              name: '山西',
              itemStyle: {
                color: 'rgba(247,206,40,0.85)'
              },
              children: [
                {
                  name: '太原理工大学',
                  value: 1,
                  itemStyle: {
                    color: 'rgba(247,206,40,0.85)'
                  }
                },


              ]
            },
          ]
        },
        {
          name: 'B区',
          itemStyle: {
            color: '#0aa3b5'
          },
          children: [
            {
              name: '内蒙古',
              itemStyle: {
                color: 'rgba(157,183,171,0.96)'
              },
              children: [
                {
                  name: '内蒙古大学',
                  value: 1,
                  itemStyle: {
                    color: 'rgba(157,183,171,0.96)'
                  }
                },

              ]
            },
            {
              name: '新疆',
              itemStyle: {
                color: 'rgb(118,203,158)'
              },
              children: [
                {
                  name: '新疆大学',
                  value: 1,
                  itemStyle: {
                    color: 'rgb(118,203,158)'
                  }
                },
                {
                  name: '石河子大学',
                  value: 1,
                  itemStyle: {
                    color: 'rgb(118,203,158)'
                  }
                },
              ]
            },

            {
              name: '西藏',
              itemStyle: {
                color: 'rgb(173,183,157)'
              },
              children: [
                {
                  name: '西藏大学',
                  value: 1,
                  itemStyle: {
                    color: 'rgb(173,183,157)'
                  }
                },

              ]
            },

            {
              name: '广西',
              itemStyle: {
                color: 'rgba(157,168,183,0.98)'
              },
              children: [
                {
                  name: '广西大学',
                  value: 1,
                  itemStyle: {
                    color: 'rgba(157,168,183,0.98)'
                  }
                },

              ]
            },

            {
              name: '海南',
              itemStyle: {
                color: 'rgba(157,183,179,0.99)'
              },
              children: [
                {
                  name: '海南大学',
                  value: 1,
                  itemStyle: {
                    color: 'rgb(177,183,157)'
                  }
                },

              ]
            },

            {
              name: '青海',
              itemStyle: {
                color: 'rgb(183,171,157)'
              },
              children: [
                {
                  name: '青海大学',
                  value: 1,
                  itemStyle: {
                    color: 'rgb(167,157,183)'
                  }
                },

              ]
            },

            {
              name: '云南',
              itemStyle: {
                color: 'rgb(183,157,170)'
              },
              children: [
                {
                  name: '云南大学',
                  value: 1,
                  itemStyle: {
                    color: 'rgb(183,157,170)'
                  }
                },

              ]
            },

            {
              name: '贵州',
              itemStyle: {
                color: 'rgb(183,157,157)'
              },
              children: [
                {
                  name: '贵州大学',
                  value: 1,
                  itemStyle: {
                    color: 'rgb(183,157,157)'
                  }
                },

              ]
            },

            {
              name: '甘肃',
              itemStyle: {
                color: 'rgba(174,183,157,0.85)'
              },
              children: [
                {
                  name: '兰州大学',
                  value: 1,
                  itemStyle: {
                    color: 'rgba(157,157,183,0.85)'
                  }
                },

              ]
            },

            {
              name: '宁夏',
              itemStyle: {
                color: 'rgb(183,157,171)'
              },
              children: [
                {
                  name: '宁夏大学',
                  value: 1,
                  itemStyle: {
                    color: 'rgba(167,157,183,0.81)'
                  }
                },

              ]
            },
          ]
        }
      ]
    }
  },
  mounted() {
    let echartDom = document.getElementById('echart');
    let echartChart = echarts.getInstanceByDom(echartDom);
    if (echartChart) {
      // 如果存在图表实例，则销毁它
      echarts.dispose(echartDom);
    }

    echartChart = echarts.init(echartDom);
    let option1 = {
      title: {
        text: '学校概览',
        textStyle: {
          fontSize: 14,
          align: 'right'
        },
        subtextStyle: {
          align: 'right'
        },
        sublink: 'https://worldcoffeeresearch.org/work/sensory-lexicon/'
      },
      series: [
        {
          type: 'sunburst',
          radius: [0, '95%'],
          data: this.data1,
          sort: undefined,
          emphasis: {
            focus: 'ancestor'
          },
          levels: [
            // Your levels here
          ]
        }
      ]
    };
    echartChart.setOption(option1);
  },

  methods: {}
}
</script>

<style>

</style>
