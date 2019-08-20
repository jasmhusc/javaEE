<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ include file="intro.jsp"%>--%>
<jsp:include page="intro.jsp"/>
<html>
<head>
    <title>include包含其他页面</title>
</head>
<body>
<%--include包含：
    1.静态包含页面：<%@include file="B.jsp"%>，属于内容包含，不能使用被包含页面已经使用的变量；
    2.动态包含页面：<jsp:include page="B.jsp"></jsp:include>，动态包含页面，属于结果包含，
    可以使用同名的变量。
    3.效果相同，动态包含更推荐使用。
    --%>
<%
    // intro中已经定义了变量：int a = 0;
    // int a = 8; 静态包含此处再定义a就会报错
    int a = 0;// 动态包含不会报错
    out.write(a);
%>

</body>
</html>
