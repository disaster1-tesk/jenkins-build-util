// 动画
const siginBtn = document.getElementById('signin')
const sigupBtn = document.getElementById('signup')
const fistForm = document.getElementById('from1')
const secondForm =document.getElementById('from2')
const container = document.querySelector(".container")


siginBtn.addEventListener('click',(e)=>{
    container.classList.remove("right-panel-active")
})

sigupBtn.addEventListener('click',(e)=>{
    container.classList.add("right-panel-active")
})
fistForm.addEventListener("submit",(e)=>{
    return e.preventDefault()
})
secondForm.addEventListener('submit',(e)=>{
    return e.preventDefault()
})

// 表单验证
// 获取输入框
let un = document.getElementById('un')
let ue = document.getElementById('ue')
let upwd = document.getElementById('upwd')

let inun =document.getElementById('inun')
let inupwd = document.getElementById('inupwd')
// 获取提示文字
let userName = document.getElementById('userName')
let userEmail = document.getElementById('userEmail')
let userPassword =document.getElementById('userPassword')
let inUserName = document.getElementById('inUserName')
let inUserPwd  = document.getElementById('inUserPwd')

var formValiad = {
    // 用户名验证  不少于6个字符
    checkUserName:function(){
        var pattern = /^\w{6,}$/
        if(un.value.length == 0){
            userName.style.visibility = 'visible'
            userName.innerText = '用户名不能为空'
            userName.style.color = 'red'
            return false
        }
        if(!pattern.test(un.value)){
            userName.style.visibility = 'visible'
            userName.innerText = '用户名不合法'
            userName.style.color = 'red'
            return false
        }else{
            userName.style.visibility = 'visible'
            userName.innerText = '合法'
            userName.style.color = 'green'
            return true
        }
    },
    // 邮箱验证
    checkUserEmail:function(){
        var pattern = /^[0-9a-zA-Z]+([\.\-_]*[0-9a-zA-Z]+)*@([0-9a-zA-Z]+[\-_]*[0-9a-zA-Z]+\.)+[0-9a-zA-Z]{2,6}$/
        if(ue.value.length == 0){
            userEmail.style.visibility = 'visible'
            userEmail.innerText = '邮箱不能为空'
            userEmail.style.color = 'red'
            return false
        }
        if(!pattern.test(ue.value)){
            userEmail.style.visibility = 'visible'
            userEmail.innerText = '邮箱不合法'
            userEmail.style.color = 'red'
            return false
        }else{
            userEmail.style.visibility = 'visible'
            userEmail.innerText = '合法'
            userEmail.style.color = 'green'
            return true
        }
    },
    // 密码验证
    checkUserPassword:function(){
        var pattern = /^\w{6,18}$/
        if(upwd.value.length == 0){
            userPassword.style.visibility = 'visible'
            userPassword.innerText = '密码不能为空'
            userPassword.style.color = 'red'
            return false
        }
        if(!pattern.test(upwd.value)){
            userPassword.style.visibility = 'visible'
            userPassword.innerText = '密码不合法'
            userPassword.style.color = 'red'
            return false
        }else{
            userPassword.style.visibility = 'visible'
            userPassword.innerText = '合法'
            userPassword.style.color = 'green'
            return true
        }
    },
    // 登录框 邮箱验证
    checkInUserEmail:function(){
        var pattern = /^[0-9a-zA-Z]+([\.\-_]*[0-9a-zA-Z]+)*@([0-9a-zA-Z]+[\-_]*[0-9a-zA-Z]+\.)+[0-9a-zA-Z]{2,6}$/
        if(inun.value.length == 0){
            inUserName.style.visibility = 'visible'
            inUserName.innerText = '邮箱不能为空'
            inUserName.style.color = 'red'
            return false
        }
        if(!pattern.test(inun.value)){
            inUserName.style.visibility = 'visible'
            inUserName.innerText = '邮箱不合法'
            inUserName.style.color = 'red'
            return false
        }else{
            inUserName.style.visibility = 'visible'
            inUserName.innerText = '合法'
            inUserName.style.color = 'green'
            return true
        }
    },
    // 登录框 密码验证
    checkUserInPassword:function(){
        var pattern = /^\w{6,18}$/
        if(inupwd.value.length == 0){
            inUserPwd.style.visibility = 'visible'
            inUserPwd.innerText = '密码不能为空'
            inUserPwd.style.color = 'red'
            return false
        }
        if(!pattern.test(inupwd.value)){
            inUserPwd.style.visibility = 'visible'
            inUserPwd.innerText = '密码不合法'
            inUserPwd.style.color = 'red'
            return false
        }else{
            inUserPwd.style.visibility = 'visible'
            inUserPwd.innerText = '合法'
            inUserPwd.style.color = 'green'
            return true
        }
    }
}