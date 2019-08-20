<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>演示获取域对象数据</title>
</head>
<body>
<%--el用来获取servlet域对象的数据，域对象有4个：
    1.pageContext，作用范围是最小的；
    2.request，一次请求内有效，常用于转发跳转传递数据；
    3.session，一次会话有效，可以用于保存用户登录状态信息
    4.servletContext：上下文域，范围最大，全局唯一。
    --%>
<% pageContext.setAttribute("name", 35);%>
<%--
没有pageContext，结果：request域
有pageContext，结果：35
根据键查找数据，依次从pageContext，request，session，application4个域中查找，找到为止
--%>
<h5>获取的name的值：${name}</h5>
<%--按照4个域范围，分别获取值：--%>
<h5>获取的name的值：${pageScope.name}</h5>
<h5>获取的name的值：${requestScope.name}</h5>
<h5>获取的name的值：${sessionScope.name.birthday}</h5>
<h5>获取的name的值：${applicationScope.name.name}</h5>


</body>
</html>
