window.onload=function(){

    var fornt = document.getElementById("front");
    var single = document.getElementById("single");
    var multi = document.getElementById("multi");

    var centerfront = document.getElementById("centerfront");
    var centersingle = document.getElementById("centersingle");
    var centerbatch = document.getElementById("centerbatch");


    fornt.onclick=function(){
        // fornt.style.backgroundColor = "#1125dd"
        centerfront.style.display = "block"
        centersingle.style.display = "none"
        centerbatch.style.display = "none"
        // alert('这就是点击事件~');
    }
    single.onclick=function(){
        // single.style.backgroundColor = "#1125dd"
        centerfront.style.display = "none"
        centersingle.style.display = "block"
        centerbatch.style.display = "none"
        // alert('这就是点击事件~');
    }
    multi.onclick=function(){
        // multi.style.backgroundColor = "#1125dd"
        centerfront.style.display = "none"
        centersingle.style.display = "none"
        centerbatch.style.display = "block"
        // alert('这就是点击事件~');
    }

    //----
    var isCheckAllt = false;
    var testbtn = document.getElementById("testselectall");
    var rebtn = document.getElementById("releaseselectall");
    testbtn.onclick=function(){
        $("input[class='testcheck']").each(function() {
            this.checked = !isCheckAllt;
        });
        isCheckAllt = !isCheckAllt;
        // alert('这就是点击事件~');
    }
    var isCheckAll = false;
    rebtn.onclick=function(){
        $("input[class='recheck']").each(function() {
            this.checked = !isCheckAll;
        });
        isCheckAll = !isCheckAll;
        // alert('这就是点击事件~');
    }

}

//批量构建
$(document).ready(function(){
    $("#batchstructure").click(function(){   //批量构建
        var batchhttpname = $("#batchhttpname").val();  //服务名称
        var branchname = $("#branchname").val();  //分支名称
        obj = document.getElementsByClassName("testcheck");
        robj = document.getElementsByClassName("recheck");
        batckadress = [];  //环境地址
        for (kk in obj) {
            if (obj[kk].checked)
                batckadress.push(obj[kk].value);
        }
        for (zz in robj) {
            if (robj[zz].checked)
                batckadress.push(robj[zz].value);
        }
        var token = $("[name = 'csrfmiddlewaretoken']").val()
        $.post("/batchbuild/",
            {   'batchhttpname':batchhttpname,
                'branchname':branchname,
                'batckadress':batckadress,
                'csrfmiddlewaretoken':token
            }, function(data){
        // $('#result').html(data)
                alert(data)
    })
});
    $("#selectbuild").click(function(){   //front查看分支构建情况
        var httpname = $("#httpname").val();  //服务名称
        if (httpname === ""){
            alert("请输入要查看的服务名称！")
            return false
        }
        var token = $("[name = 'csrfmiddlewaretoken']").val()
        $.post("/findfrontbuild/",
            {   'httpname':httpname,
                'csrfmiddlewaretoken':token
            }, function(data){
        // $('#result').html(data)
                alert(data[0])
                console(data[0])
                alert(data)
    })
});
});