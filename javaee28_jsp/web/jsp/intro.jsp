<%@ page import="com.hsc.entity.User" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>介绍jsp相关语法</title>
    <style>
        table {
            text-align: center;
            border: 2px solid blue;
            width: 500px;
        }
    </style>
</head>
<body>
<h3>jsp注释</h3>
<!--1.普通html注释，浏览器可以通过查看源代码查看，不能用来注释java代码：
    <% int a = 0;
        // 2.java注释，与java中一样，生成的servlet中会存在。
    %>,无法注释-->
<%--3.jsp的注释，html和java的servlet中都不会存在，可以注释java代码。--%>

<h3>jsp的基本使用，定义函数并使用。</h3>
<%--声明一个全局的求和方法，并使用。--%>
<%! private int sum(int... arr) {
    int sum = 0;
    for (int i : arr) {
        sum += i;
    }
    return sum;
}
%>
<p>1,3,5,7的求和结果为：<%= sum(1, 3, 5, 7)%>
</p>

<h3>jsp输出当前时间在页面</h3>
<span style="font-family: Monaco">
        当前时间：<%= new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date())%>
    </span>

<h3>jsp打印表格，表格数据来自定义的集合</h3>
<%--定义一个集合，包含3个User--%>
<%
    ArrayList<User> users = new ArrayList<>();
    User mayun = new User("马云", 45, java.sql.Date.valueOf("1979-09-23"));
    User maht = new User("马化腾", 38, java.sql.Date.valueOf("1989-05-27"));
    users.add(mayun);
    users.add(maht);
%>
<%--写一个列表，遍历集合，显示数据--%>

<table style="border-collapse: collapse">
    <tr>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>
    <%
        for (User user : users) {
    %>
    <tr>
        <td><%= user.getName()%>
        </td>
        <td><%= user.getAge()%>
        </td>
        <td><%= user.getBirthday()%>
        </td>
    </tr>
    <%
        }
    %>
</table>

<%--使用默认的out.print输出数据--%>
<hr/>
<table>
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>生日</td>
    </tr>
    <% for (User user : users) { %>
    <tr>
        <td><% out.print(user.getName());%></td>
        <td><% out.print(user.getAge());%></td>
        <td><% out.print(user.getBirthday());%></td>
    </tr>
    <% } %>
</table>
</body>
</html>
