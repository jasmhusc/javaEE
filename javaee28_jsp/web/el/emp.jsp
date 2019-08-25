<%@ page import="com.hsc.entity.Emp" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: HuscLove
  Date: 2019/8/21
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>emp测试el表达式</title>
</head>
<body>
<% // 将员工放在页面域
    Emp emp = new Emp("貂蝉", 10000);
    pageContext.setAttribute("emp", emp);
%>
<h2>得到javabean的属性值</h2>
姓名：${emp.name} 工资：${emp.salary}

<% // 创建list集合，存放在域中
    List<String> names = Arrays.asList("孙悟空", "猪八戒", "唐僧");
    // 放在请求域中
    request.setAttribute("names", names);
%>
<h2>取出list集合中的元素</h2>
${names[0]} &nbsp; ${names[1]}

<h2>el算数运算符</h2>
${5-3} &nbsp; ${5 div 2} &nbsp; ${5 mod 3}

</body>
</html>
