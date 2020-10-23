<%--
  Created by IntelliJ IDEA.
  User: David
  Date: 2020-10-16
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<div id="msg"></div>

<form action="" method="post">
    用户名<input type="text" name="uname" id="uname"/><br>
    密码<input type="password" name="upwd" id="upwd"><br>
    <input type="button" value="提交" id="submit" onclick="login()"/>
</form>
</body>
<script>
    var xhr;
    function login() {
        xhr=new XMLHttpRequest();
        var uname=document.getElementById("uname").value;
        var upwd=document.getElementById("upwd").value;
        xhr.open("get","/user?action=ajaxlogin&uname="+uname+"&upwd="+upwd);
        xhr.onreadystatechange=function(){
            if(xhr.readyState==4&& xhr.status==200){
                document.getElementById("msg").innerHTML=xhr.responseText;
            }
        };
        xhr.send(null);
    }
</script>
</html>
