<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<style type="text/css">
    a {
        color: orangered;
        text-decoration: none;
    }

    #name {
        color: deepskyblue;
        font-size: large;
    }

    #rank {
        color: crimson;
        font-family: Monaco;
        font-size: large;
    }
</style>
<body>
<c:if test="${not empty user}">
    <h4>亲爱的
        <span id="name">${user.username}</span>&nbsp;
        <span id="rank">${user.rank.rankName}</span>&nbsp;
        欢迎来到德莱联盟！
    </h4>
    <h4><a href="list">联系人列表</a></h4>
</c:if>
<c:if test="${empty user}">
    <h4>欢迎光临，<a href="login.jsp">请登录</a></h4>
</c:if>
</body>
</html>
