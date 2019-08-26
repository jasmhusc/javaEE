<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>管理员登录</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">管理员登录</h3>
    <form action="login" method="post">
        <div class="form-group">
            <label for="user">用户名：</label>
            <input type="text" name="user" class="form-control" id="user" placeholder="请输入用户名"/>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
        </div>

        <div class="form-inline">
            <label for="vcode">验证码：</label>
            <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码"
                   style="width: 120px;"/>
            <a href="javascript:void(0);"><img onclick="changeCheckCode(this)" src="checkCode" title="看不清点击刷新"
                                               id="vcode"/></a>
            <script type="text/javascript">
                //图片点击事件
                function changeCheckCode(img) {
                    img.src = "checkCode?" + new Date().getTime();
                }
            </script>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="登录">
        </div>
    </form>

    <!-- 出错显示的信息框 -->
    <c:if test="${not empty errorMsg}">
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" onclick="hide()">
                <span>&times;</span></button>
            <strong>${errorMsg}</strong>
        </div>
    </c:if>
</div>
<script>
    function hide() {
        <%
            request.setAttribute("errorMsg",null);
        %>
    }
</script>
</body>
</html>