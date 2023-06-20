$("#login-btn").click((e) => {
            const userName = $("#username").val();
            const passWord = $("#password").val();
            if (!username || !password) {
                alert("请输入账号或密码")
            } else {
                // 调用登录接口
                $.get("http://localhost:8080/api/operation/platform/account/login", {
                    userName,
                    passWord
                }, function(data) {
                    // data接口返回的用户数据
                    console.log(data);
                    const {data:{token}} = data;
                    console.log(token);
                    if(token){
                        window.location.href = "main.html";
//                        console.log(token);
//                        sessionStorage.setItem('saToken', token);
                    }
                });
            }
        })