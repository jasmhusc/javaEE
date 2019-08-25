<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>taglib导入jstl核心标准库</title>
</head>
<body>
<%--使用taglib指令导入jstl核心标准标签库
    uri="http://java.sun.com/jsp/jstl/core"  标签库的地址,所有的标签都在这个地址里面
    prefix="c"  使用jstl核心标签库标签的前缀
--%>

<%--test 后面使用 EL 表达式，判断是否为真--%>
<c:if test="${3>5}">
    我是女生！
</c:if>
<c:if test="${5-2 == 3}">
    我是男生！
</c:if>

<%--param.age 是 EL 中内置对象，相当于 request.getParameter("age")
    数据在地址栏带入--%>
<c:if test="${param.age >= 18}">
    你已成年，请进入！
</c:if>
<c:if test="${param.age < 18}">
    未成年，请绕行！
</c:if>

</body>
</html>
