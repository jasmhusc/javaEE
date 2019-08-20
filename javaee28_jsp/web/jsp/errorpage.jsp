<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<html>
<head>
    <title>错误信息页面</title>
</head>
<body>
<%--isErrorPage="true":含义是可以使用exception对象打印异常消息到控制台或日志文件，
                       目的是让开发人员发现错误，从而解决错误
                       没有该标签同样可以跳转，但不能使用exception对象来处理异常，打印信息。--%>
<%
    exception.printStackTrace();
%>
<h4>服务器繁忙，请稍后再试...</h4>
<a href="intro.jsp">点击回首页</a>
</body>
</html>
