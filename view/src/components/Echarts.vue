<template>
  <div style="margin-left: 10px">
    <el-row :gutter="20" style="display: flex">
      <el-col :span="12">
        <el-card style="width: 95%; height: 95%">
          <div style="display: flex; justify-content: center;">
            <div id="echart" style="width: 580px; height:580px; margin-right: auto; "></div>
          </div>
        </el-card>
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
    subtext: 'Source: https://worldcoffeeresearch.org/work/sensory-lexicon/',
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
    radius: [0, '95%'],
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
                  name: 'Blackberry',
                  value: 1,
                  itemStyle: {
                    color: '#3e0317'
                  }
                },
                {
                  name: 'Raspberry',
                  value: 1,
                  itemStyle: {
                    color: '#e62969'
                  }
                },
                {
                  name: 'Blueberry',
                  value: 1,
                  itemStyle: {
                    color: '#6569b0'
                  }
                },
                {
                  name: 'Strawberry',
                  value: 1,
                  itemStyle: {
                    color: '#ef2d36'
                  }
                }
              ]
            },
            {
              name: '天津',
              itemStyle: {
                color: '#c94a44'
              },children: [
                {
                  name: 'Coconut',
                  value: 1,
                  itemStyle: {
                    color: '#f2684b'
                  }
                }
               ]
            },
            {
              name: '辽宁',
              itemStyle: {
                color: '#c94a44'
              },children: [
                {
                  name: 'Coconut',
                  value: 1,
                  itemStyle: {
                    color: '#f2684b'
                  }
                }
              ]
            },
            {
              name: '吉林',
              itemStyle: {
                color: '#c94a44'
              },children: [
                {
                  name: 'Coconut',
                  value: 1,
                  itemStyle: {
                    color: '#f2684b'
                  }
                }
              ]
            },
            {
              name: '黑龙江',
              itemStyle: {
                color: '#c94a44'
              },children: [
                {
                  name: 'Coconut',
                  value: 1,
                  itemStyle: {
                    color: '#f2684b'
                  }
                }
              ]
            },
            {
              name: '上海',
              itemStyle: {
                color: '#c94a44'
              },children: [
                {
                  name: 'Coconut',
                  value: 1,
                  itemStyle: {
                    color: '#f2684b'
                  }
                }
              ]
            },
            {
              name: '江苏',
              itemStyle: {
                color: '#c94a44'
              },children: [
                {
                  name: 'Coconut',
                  value: 1,
                  itemStyle: {
                    color: '#f2684b'
                  }
                }
              ]
            },
            {
              name: '浙江',
              itemStyle: {
                color: '#c94a44'
              },children: [
                {
                  name: 'Coconut',
                  value: 1,
                  itemStyle: {
                    color: '#f2684b'
                  }
                }
              ]
            },
            {
              name: '安徽',
              itemStyle: {
                color: '#c94a44'
              },children: [
                {
                  name: 'Coconut',
                  value: 1,
                  itemStyle: {
                    color: '#f2684b'
                  }
                }
              ]
            },
            {
              name: '福建',
              itemStyle: {
                color: '#c94a44'
              },children: [
                {
                  name: 'Coconut',
                  value: 1,
                  itemStyle: {
                    color: '#f2684b'
                  }
                }
              ]
            },
            {
              name: '江西',
              itemStyle: {
                color: '#c94a44'
              },children: [
                {
                  name: 'Coconut',
                  value: 1,
                  itemStyle: {
                    color: '#f2684b'
                  }
                }
              ]
            },
            {
              name: '山东',
              itemStyle: {
                color: '#c94a44'
              },children: [
                {
                  name: 'Coconut',
                  value: 1,
                  itemStyle: {
                    color: '#f2684b'
                  }
                }
              ]
            },
            {
              name: '河南',
              itemStyle: {
                color: '#c94a44'
              },children: [
                {
                  name: 'Coconut',
                  value: 1,
                  itemStyle: {
                    color: '#f2684b'
                  }
                }
              ]
            },
            {
              name: '湖北',
              itemStyle: {
                color: '#c94a44'
              },children: [
                {
                  name: 'Coconut',
                  value: 1,
                  itemStyle: {
                    color: '#f2684b'
                  }
                }
              ]
            },
            {
              name: '湖南',
              itemStyle: {
                color: '#c94a44'
              },children: [
                {
                  name: 'Coconut',
                  value: 1,
                  itemStyle: {
                    color: '#f2684b'
                  }
                }
              ]
            },
            {
              name: '广东',
              itemStyle: {
                color: '#c94a44'
              },children: [
                {
                  name: 'Coconut',
                  value: 1,
                  itemStyle: {
                    color: '#f2684b'
                  }
                }
              ]
            },
            {
              name: '重庆',
              itemStyle: {
                color: '#c94a44'
              },children: [
                {
                  name: 'Coconut',
                  value: 1,
                  itemStyle: {
                    color: '#f2684b'
                  }
                }
              ]
            },
            {
              name: '四川',
              itemStyle: {
                color: '#c94a44'
              },children: [
                {
                  name: 'Coconut',
                  value: 1,
                  itemStyle: {
                    color: '#f2684b'
                  }
                }
              ]
            },
            {
              name: '陕西',
              itemStyle: {
                color: '#c94a44'
              },children: [
                {
                  name: 'Coconut',
                  value: 1,
                  itemStyle: {
                    color: '#f2684b'
                  }
                }
              ]
            },
            {
              name: '河北',
              itemStyle: {
                color: '#dd4c51'
              },
              children: [
                {
                  name: 'Coconut',
                  value: 1,
                  itemStyle: {
                    color: '#f2684b'
                  }
                },
                {
                  name: 'Cherry',
                  value: 1,
                  itemStyle: {
                    color: '#e73451'
                  }
                },
                {
                  name: 'Pomegranate',
                  value: 1,
                  itemStyle: {
                    color: '#e65656'
                  }
                },
                {
                  name: 'Pineapple',
                  value: 1,
                  itemStyle: {
                    color: '#f89a1c'
                  }
                },
                {
                  name: 'Grape',
                  value: 1,
                  itemStyle: {
                    color: '#aeb92c'
                  }
                },
                {
                  name: 'Apple',
                  value: 1,
                  itemStyle: {
                    color: '#4eb849'
                  }
                },
                {
                  name: 'Peach',
                  value: 1,
                  itemStyle: {
                    color: '#f68a5c'
                  }
                },
                {
                  name: 'Pear',
                  value: 1,
                  itemStyle: {
                    color: '#baa635'
                  }
                }
              ]
            },
            {
              name: '山西',
              itemStyle: {
                color: '#f7a128'
              },
              children: [
                {
                  name: 'Grapefruit',
                  value: 1,
                  itemStyle: {
                    color: '#f26355'
                  }
                },
                {
                  name: 'Orange',
                  value: 1,
                  itemStyle: {
                    color: '#e2631e'
                  }
                },
                {
                  name: 'Lemon',
                  value: 1,
                  itemStyle: {
                    color: '#fde404'
                  }
                },
                {
                  name: 'Lime',
                  value: 1,
                  itemStyle: {
                    color: '#7eb138'
                  }
                }
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
              name: 'Papery/Musty',
              itemStyle: {
                color: '#9db2b7'
              },
              children: [
                {
                  name: 'Stale',
                  value: 1,
                  itemStyle: {
                    color: '#8b8c90'
                  }
                },
                {
                  name: 'Cardboard',
                  value: 1,
                  itemStyle: {
                    color: '#beb276'
                  }
                },
                {
                  name: 'Papery',
                  value: 1,
                  itemStyle: {
                    color: '#fefef4'
                  }
                },
                {
                  name: 'Woody',
                  value: 1,
                  itemStyle: {
                    color: '#744e03'
                  }
                },
                {
                  name: 'Moldy/Damp',
                  value: 1,
                  itemStyle: {
                    color: '#a3a36f'
                  }
                },
                {
                  name: 'Musty/Dusty',
                  value: 1,
                  itemStyle: {
                    color: '#c9b583'
                  }
                },
                {
                  name: 'Musty/Earthy',
                  value: 1,
                  itemStyle: {
                    color: '#978847'
                  }
                },
                {
                  name: 'Animalic',
                  value: 1,
                  itemStyle: {
                    color: '#9d977f'
                  }
                },
                {
                  name: 'Meaty Brothy',
                  value: 1,
                  itemStyle: {
                    color: '#cc7b6a'
                  }
                },
                {
                  name: 'Phenolic',
                  value: 1,
                  itemStyle: {
                    color: '#db646a'
                  }
                }
              ]
            },
            {
              name: 'Chemical',
              itemStyle: {
                color: '#76c0cb'
              },
              children: [
                {
                  name: 'Bitter',
                  value: 1,
                  itemStyle: {
                    color: '#80a89d'
                  }
                },
                {
                  name: 'Salty',
                  value: 1,
                  itemStyle: {
                    color: '#def2fd'
                  }
                },
                {
                  name: 'Medicinal',
                  value: 1,
                  itemStyle: {
                    color: '#7a9bae'
                  }
                },
                {
                  name: 'Petroleum',
                  value: 1,
                  itemStyle: {
                    color: '#039fb8'
                  }
                },
                {
                  name: 'Skunky',
                  value: 1,
                  itemStyle: {
                    color: '#5e777b'
                  }
                },
                {
                  name: 'Rubber',
                  value: 1,
                  itemStyle: {
                    color: '#120c0c'
                  }
                }
              ]
            }
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
        subtext: 'Source: https://worldcoffeeresearch.org/work/sensory-lexicon/',
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
