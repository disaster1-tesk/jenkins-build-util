// 列表数据

let listData=[];

axios.default.withCredentials = true;

// 获取用户登录之后的信息
//const token = sessionStorage.getItem("token");
//console.log(token);
//if (!token) {
//  alert("请登录后使用");
//  window.location.href = "login.html";
//}else {
//    document.cookie = "token="+token;
//    $.cookie('cookie', token);
//}

// 默认将按钮的loading效果关闭
$("#submit-btn-icon").hide();
// 请求列表数据
const getTabData = (url) => {
// 为给定 ID 的 user 创建请求
axios.get(url)
  .then(function (response) {
    console.log(response);
    const axiosData = response.data.data;
    //    listData = [];
      listData.length = 0;
                            for (const key in axiosData) {
                                if (Object.hasOwnProperty.call(axiosData, key)) {
                                    const value = axiosData[key];
                                    listData.push({key,value})
                                }
                              }

                            $("#list-group").show();
                            console.log(listData);
                            const listHtml = listData.map((v) => {
                              return `<li class="list-group-item" >
                                        <input type="checkbox" class="checkbox-btn">
                                        <i class="iconfont icon-tixing" id="${v.key}"></i>
                                        <span class="list-group-item-span" url="${v.value}">${v.key}</span>
                                    </li>`;
                            });
                            $(".list-group").html(listHtml);
                            $("#loading-icon").hide();

      // link
      console.log(1);
      console.log($(".list-group-item-span"));
      $(".list-group-item-span").click(e => {
          console.log(e.target.attributes.url.value);
          window.location.href = e.target.attributes.url.value;
      });

  })
};

// 默认请求第一个tab的数据
getTabData("http://localhost:8080/api/operation/platform/job/view/findTest?jobName=weaver-customer-service");
