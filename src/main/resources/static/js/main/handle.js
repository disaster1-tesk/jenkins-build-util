// 给tab添加点击事件切换tab，切换数据
$(".nav-link").click((e) => {
  $(".active").removeClass("active");
  e.target.className = "nav-link active";
  $("#list-group").hide();
  $("#loading-icon").show();
  getTabData(e.target.attributes.url.value);
});

// 判断上一次提交是否结束
let accSubmit = 0;

// 提交
$("#submit-btn").click((e) => {
  // 如果上一次提交还未结束则不能再提交
  if (accSubmit) {
    alert("请耐心等待上一次提交结束");
    return;
  }
  // 勾选的数据
  const checkedData = [];
  $(".checkbox-btn").each(function (index) {
    this.checked && checkedData.push(listData[index]);
  });
  if (checkedData.length === 0) {
    alert("请勾选对应的数据");
  } else {
    $("#submit-btn-text").text("加载中");
    $("#submit-btn-icon").show();
    // 发送提交接口，checkedData发送给后台

//     伪代码：
        const sendSecondNetword = (url) => {
            axios.get(url).then( (res) => {
                console.log(res.data.code,"res");
                // success
                switch (res.data.code) {
                    case 200:
                    {
                        // // 改对应数据的图标
                        checkedData.forEach(item => {
                            // $('#'+item.key).toggleClass();
                            document.getElementById(item.key).className = "iconfont icon-zhengque";
                        })
                        alert("构建成功");
                        accSubmit--;
                    }
                    break;
                    case 202:
                    {
                        sendSecondNetword(url);
                    }
                    break;
                    case 500:
                    {

                        // // 改对应数据的图标
                        checkedData.forEach(item => {
                            // $('#'+item.key).toggleClass("iconfont icon-guanbi1");
                            document.getElementById(item.key).className = "iconfont icon-guanbi1";
                        })
                        alert('构建失败');
                        accSubmit--;
                    }
                    break;
                }
            });
        }


    checkedData.forEach(item => {
        accSubmit++;
    //        调第一个接口
           axios.get(`http://localhost:8080/api/operation/platform/job/build/getJobLastBuild?address=${item.value}`).then(res =>{

                   sendSecondNetword(`http://localhost:8080/api/operation/platform/job/build/createJob?address=${item.value}`);//diergejiekodizhi

           });
    })
    const inter = setInterval(() => {
        if (accSubmit === 0) {
            clearInterval(inter);
            $("#submit-btn-text").text("提交");
            $("#submit-btn-icon").hide();
        }
    },10)
  }
});

// link
console.log(1);
console.log($(".list-group-item-span"));
$(".list-group-item-span").click(e => {
    console.log(e.target.attributes.url.value);
    window.location.href = e.target.attributes.url.value;
});