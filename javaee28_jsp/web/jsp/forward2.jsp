<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取转发跳转携带过来的数据</title>
</head>
<body>
<%
    // 乱码问题？
    String name = request.getParameter("name");
    String job = request.getParameter("job");
    out.write(name + " " + job);
%>
</body>
</html>
