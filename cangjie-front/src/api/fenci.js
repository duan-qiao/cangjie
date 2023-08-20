import axios from 'axios'

export async function getTokenization(params) {
  const res = await axios.get('/tokenizer/page', { params })
  if(res?.status === 200 && res?.data?.success === true) {
    return res?.data?.data
  }else {
    return Promise.reject('请求失败~')
  }
}

export async function saveTokenizer(list) {
  return axios.post('/tokenizer/save', list)
}

// export async function getTokenization(params) {

//   const res = await Promise.resolve({
//     "list": [{
//         "sentence": "万博科技园",
//         "tokens": [{
//             "word": "万博",
//             "category": null
//           },
//           {
//             "word": "科技园",
//             "category": null
//           }
//         ]
//       },
//       {
//         "sentence": "南京市雨花台区凤信路与花神大道交叉路口往东北约180米",
//         "tokens": [{
//             "word": "南京市",
//             "category": null
//           },
//           {
//             "word": "雨花台区",
//             "category": null
//           },
//           {
//             "word": "凤信路",
//             "category": null
//           },
//           {
//             "word": "与",
//             "category": null
//           },
//           {
//             "word": "花神",
//             "category": null
//           },
//           {
//             "word": "大道",
//             "category": null
//           },
//           {
//             "word": "交叉路口",
//             "category": null
//           },
//           {
//             "word": "往",
//             "category": null
//           },
//           {
//             "word": "东北",
//             "category": null
//           },
//           {
//             "word": "约",
//             "category": null
//           },
//           {
//             "word": "180",
//             "category": null
//           },
//           {
//             "word": "米",
//             "category": null
//           }
//         ]
//       },
//       {
//         "sentence": "雨花客厅",
//         "tokens": [{
//             "word": "雨花",
//             "category": null
//           },
//           {
//             "word": "客厅",
//             "category": null
//           }
//         ]
//       },
//       {
//         "sentence": "江苏省南京市雨花台区安德门大街47号（天隆寺地铁站1号口步行260米）",
//         "tokens": [{
//             "word": "江苏省",
//             "category": null
//           },
//           {
//             "word": "南京市",
//             "category": null
//           },
//           {
//             "word": "雨花台区",
//             "category": null
//           },
//           {
//             "word": "安德门",
//             "category": null
//           },
//           {
//             "word": "大街",
//             "category": null
//           },
//           {
//             "word": "47",
//             "category": null
//           },
//           {
//             "word": "号",
//             "category": null
//           },
//           {
//             "word": "（",
//             "category": null
//           },
//           {
//             "word": "天隆寺",
//             "category": null
//           },
//           {
//             "word": "地铁站",
//             "category": null
//           },
//           {
//             "word": "1",
//             "category": null
//           },
//           {
//             "word": "号口",
//             "category": null
//           },
//           {
//             "word": "步行",
//             "category": null
//           },
//           {
//             "word": "260",
//             "category": null
//           },
//           {
//             "word": "米",
//             "category": null
//           },
//           {
//             "word": "）",
//             "category": null
//           }
//         ]
//       },
//       {
//         "sentence": "肯德基（丰盛餐厅）",
//         "tokens": [{
//             "word": "肯德基",
//             "category": null
//           },
//           {
//             "word": "（",
//             "category": null
//           },
//           {
//             "word": "丰盛",
//             "category": null
//           },
//           {
//             "word": "餐厅",
//             "category": null
//           },
//           {
//             "word": "）",
//             "category": null
//           }
//         ]
//       },
//       {
//         "sentence": "江苏省南京市雨花台区软件大道119号丰盛商汇1层",
//         "tokens": [{
//             "word": "江苏省",
//             "category": null
//           },
//           {
//             "word": "南京市",
//             "category": null
//           },
//           {
//             "word": "雨花台区",
//             "category": null
//           },
//           {
//             "word": "软件",
//             "category": null
//           },
//           {
//             "word": "大道",
//             "category": null
//           },
//           {
//             "word": "119",
//             "category": null
//           },
//           {
//             "word": "号",
//             "category": null
//           },
//           {
//             "word": "丰盛",
//             "category": null
//           },
//           {
//             "word": "商汇",
//             "category": null
//           },
//           {
//             "word": "1",
//             "category": null
//           },
//           {
//             "word": "层",
//             "category": null
//           }
//         ]
//       },
//       {
//         "sentence": "东软软件园",
//         "tokens": [{
//             "word": "东软",
//             "category": null
//           },
//           {
//             "word": "软件园",
//             "category": null
//           }
//         ]
//       },
//       {
//         "sentence": "江苏省南京市雨花台区软件大道与铁心工业园路交叉口东南150米",
//         "tokens": [{
//             "word": "江苏省",
//             "category": null
//           },
//           {
//             "word": "南京市",
//             "category": null
//           },
//           {
//             "word": "雨花台区",
//             "category": null
//           },
//           {
//             "word": "软件",
//             "category": null
//           },
//           {
//             "word": "大道",
//             "category": null
//           },
//           {
//             "word": "与",
//             "category": null
//           },
//           {
//             "word": "铁心",
//             "category": null
//           },
//           {
//             "word": "工业园",
//             "category": null
//           },
//           {
//             "word": "路",
//             "category": null
//           },
//           {
//             "word": "交叉口",
//             "category": null
//           },
//           {
//             "word": "东南",
//             "category": null
//           },
//           {
//             "word": "150",
//             "category": null
//           },
//           {
//             "word": "米",
//             "category": null
//           }
//         ]
//       },
//       {
//         "sentence": "王小连油条店",
//         "tokens": [{
//             "word": "王小连",
//             "category": null
//           },
//           {
//             "word": "油条",
//             "category": null
//           },
//           {
//             "word": "店",
//             "category": null
//           }
//         ]
//       },
//       {
//         "sentence": "江苏省无锡市梁溪区贡湖大道芦庄五区",
//         "tokens": [{
//             "word": "江苏省",
//             "category": null
//           },
//           {
//             "word": "无锡市",
//             "category": null
//           },
//           {
//             "word": "梁溪区",
//             "category": null
//           },
//           {
//             "word": "贡湖",
//             "category": null
//           },
//           {
//             "word": "大道",
//             "category": null
//           },
//           {
//             "word": "芦庄",
//             "category": null
//           },
//           {
//             "word": "五区",
//             "category": null
//           }
//         ]
//       },
//       {
//         "sentence": "沙野轻食",
//         "tokens": [{
//           "word": "沙野轻食",
//           "category": null
//         }]
//       },
//       {
//         "sentence": "安徽省合肥市庐阳区长江中路16号三牌楼安徽省委大院",
//         "tokens": [{
//             "word": "安徽省",
//             "category": null
//           },
//           {
//             "word": "合肥市",
//             "category": null
//           },
//           {
//             "word": "庐阳区",
//             "category": null
//           },
//           {
//             "word": "长江中路",
//             "category": null
//           },
//           {
//             "word": "16",
//             "category": null
//           },
//           {
//             "word": "号",
//             "category": null
//           },
//           {
//             "word": "三",
//             "category": null
//           },
//           {
//             "word": "牌楼",
//             "category": null
//           },
//           {
//             "word": "安徽省委",
//             "category": null
//           },
//           {
//             "word": "大院",
//             "category": null
//           }
//         ]
//       }
//     ],
//     "pageNum": 1,
//     "pageSize": 10,
//     "pages": 2,
//     "total": 12,
//     "hasPreviousPage": false,
//     "hasNextPage": true
//   })
//   return res
// }