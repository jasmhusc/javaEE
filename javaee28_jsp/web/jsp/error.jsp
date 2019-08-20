<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="intro.jsp" %>
<%--<%@ page errorPage="errorpage.jsp" %>--%>
<html>
<head>
    <title>jsp中的错误页面</title>
</head>
<body>
<%--当一个页面发生错误时，可以指定其跳转到另一个页面，以给用户更加友好的提示
这些错误如500，可以在需要的页面单独指定：errorPage，也可以在web.xml中统一配置，
统一配置的好处是可以根据错误类型，如404,500，或者Exception的类型指定某一个页面，
否则所有页面都要单独指定。--%>
<%
    int c = 1 / 0;
    // 演示发生异常的错误时，跳转错误页面，404不是错误。
    //throw new NullPointerException("空指针异常啦！请尽快处理哦！");
%>
</body>
</html>
