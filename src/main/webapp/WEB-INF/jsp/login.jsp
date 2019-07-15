<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/28
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/Css/style.css">
</head>
<body>
<form action="/login" method="post">
    <div class="login">
        <div class="login-screen">
            <div class="app-title">
                <h1>学生请假系统</h1>
            </div>

            <div class="login-form">
                <div class="control-group">

                    <input type="text" class="login-field" value="" placeholder="用户名" id="login-name" name="username">
                    <label class="login-field-icon fui-user" for="login-name"></label>
                </div>

                <div class="control-group">
                    <input type="password" class="login-field" value="" placeholder="密码" id="login-pass"name="password">
                    <label class="login-field-icon fui-lock" for="login-pass"></label>
                </div>

                <input  type ="submit"  value ="登录"class="btn btn-primary btn-large btn-block" >
                <a class="login-link" href="">注册</a>

            </div>
        </div>
    </div>
</form>
</body>
</html>
