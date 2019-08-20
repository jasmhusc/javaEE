<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el的运算符</title>
</head>
<body>
<h2>算数运算符</h2>
<p>${5/2}</p> <%--2.5： 如果除不尽会保留16位小数，四舍五入--%>
<p>${1+2+3+f}</p> <%--6： 取不到或为null数据不参与运算--%>

<h2>三元运算符</h2>
<p>${3>6?"非常正确":"错误"}</p>
<%--与java一样--%>

<h2>判空表达式</h2>
<%--
格式:${empty 表达式}
作用:
    1.判断表达式是否null, null返回true, 否则返回false
    2.判断表达式是否为空字符串, 空字符串返回true, 否则返回false
    3.判断表达式是集合是否有元素, 集合对象不为空，但是里面没有元素返回true, 否则返回false
--%>
<p>${empty ""}</p> <%--true--%>
<p>${empty " "}</p> <%--false,含有空格不算空字符串--%>
<p>${empty null}</p> <%--true--%>
<% ArrayList list = new ArrayList();
    list.add("assf");
    request.setAttribute("list", list);%>
<p>${empty list}</p> <%--false--%>
</body>
</html>
