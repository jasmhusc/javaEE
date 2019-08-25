<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>九九乘法表</title>
    <style>
        table {
            margin: auto;
            border-collapse: collapse;
        }

        tr {
            height: 30px;
        }

        td {
            padding: 5px 5px;
            font-family: Monaco;
            color: blue;
        }
    </style>
</head>
<body>
<form action="99multiply.jsp">
    <input type="text" name="num"><br/>
    <input type="submit" value="提交">
</form>
<table border="1px">
    <caption><h3>九九乘法表</h3></caption>
    <%--    <% int num = Integer.parseInt(request.getParameter("num"));%>--%>
    <%--    <c:forEach begin="1" end="<%=num %>" step="1" varStatus="row">--%>
    <c:forEach begin="1" end="${param.num}" step="1" varStatus="row">
        <tr>
            <c:forEach begin="1" end="${row.count}" step="1" varStatus="col">
                <td>${col.count}&times;${row.count}=${row.count*col.count}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>
