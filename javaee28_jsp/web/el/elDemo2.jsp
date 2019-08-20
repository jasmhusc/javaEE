<%@ page import="com.hsc.entity.User" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: HuscLove
  Date: 2019/8/20
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>集合数组复杂数据获取</title>
</head>
<body>
<%--创建对象集合的复杂数据类型。并获取输出。--%>
<%
    // 创建集合
    ArrayList<User> users = new ArrayList<>();
    User mayun = new User("马云", 45, Date.valueOf("1979-09-23"));
    User maht = new User("马化腾", 38, Date.valueOf("1989-05-27"));
    users.add(mayun);
    users.add(maht);
    // 将集合添加到request域
    request.setAttribute("users", users);

    // 遍历集合，数组也是根据索引遍历，不能使用for循环
%>
<span>姓名：${users[0].name} 年龄：${users[0].age} 生日：${users[0].birthday}</span> <br/>
<span>姓名：${users[1].name} 年龄：${users[1].age} 生日：${users[1].birthday}</span> <br/>

</body>
</html>
