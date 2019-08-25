<%@ page import="java.util.Map" %>
<%@ page import="com.hsc.entity.Student" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息表</title>
    <style type="text/css">
        table {
            border-collapse: collapse;
            width: 500px;
            margin: auto;
        }

        tr {
            height: 35px;
        }

        td {
            text-align: center;
        }
    </style>
</head>
<body>
<table border="1px">
    <caption>学生信息表</caption>
    <tr>
        <th>序号</th>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>成绩</th>
    </tr>
    <tr>
        <td>1</td>
        <td>1000</td>
        <td>猪八戒</td>
        <td>男</td>
        <td>65.0</td>
    </tr>
    <tr>
        <td>2</td>
        <td>2000</td>
        <td>白骨精</td>
        <td>女</td>
        <td>85.0</td>
    </tr>
    <tr>
        <td>3</td>
        <td>3000</td>
        <td>嫦娥</td>
        <td>女</td>
        <td>90.0</td>
    </tr>
    <tr>
        <td>4</td>
        <td>4000</td>
        <td>唐僧</td>
        <td>男</td>
        <td>87.0</td>
    </tr>
    <tr>
        <td>5</td>
        <td>5000</td>
        <td>蜘蛛精</td>
        <td>女</td>
        <td>85.0</td>
    </tr>
</table>
<h2>jstl的循环填写表格内容</h2>
<%
    List<Student> students = new ArrayList<>();
    students.add(new Student("1000", "猪八戒", "男", 65.0));
    students.add(new Student("2000", "白骨精", "女", 85.0));
    students.add(new Student("3000", "嫦娥", "女", 90.0));
    students.add(new Student("4000", "唐僧", "男", 87.0));
    students.add(new Student("5000", "蜘蛛精", "女", 85.0));
    // 存进域中
    request.setAttribute("students", students);
%>
<table border="1px">
    <caption>学生信息表</caption>
    <tr>
        <th>序号</th>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>成绩</th>
    </tr>
    <c:forEach items="${students}" var="stu" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${stu.id}</td>
            <td>${stu.name}</td>
            <td>${stu.gender}</td>
            <td>${stu.score}</td>
        </tr>
    </c:forEach>
</Table>
</body>
</html>
