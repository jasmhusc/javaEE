<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>choose标签实现分数分级</title>
</head>
<body>
<%--创建表单，测评输入的成绩。--%>
<form action="choose.jsp">
    <input type="text" name="score">
    <input type="submit" value="测评">
</form>
<%--检测表单提交的数据，根据数据评级。--%>
<%--先判断表单提交的分数是否为空--%>
<c:if test="${not empty param.score}">
    <%--不为空则可以进行分级--%>
    <c:choose>
        <c:when test="${param.score >= 90 && param.score <= 100}">
            <span style="color: red;font-size: large">优秀</span>
        </c:when>
        <c:when test="${param.score >= 80 && param.score < 90}">
            <span style="color: crimson;font-size: larger">优良</span>
        </c:when>
        <c:when test="${param.score >= 60 && param.score < 80}">
            <span style="color: blue;font-size: medium">加油</span>
        </c:when>
        <c:when test="${param.score < 60}">
            <span style="color: deepskyblue;font-size: small">你能做的岂止如此！</span>
        </c:when>
        <c:otherwise>
            <span style="color: aqua;">你输入的信息有误！</span>
        </c:otherwise>
    </c:choose>
</c:if>
</body>
</html>
