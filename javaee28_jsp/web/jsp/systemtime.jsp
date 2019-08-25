<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--jsp的page元素：指定页面内容的类型，编码，页面使用的编程语言是java--%>
<html>
<head>
    <title>时间</title>
</head>
<body>
<h1 style="color: red">服务器现在的时间：</h1>
<%
    String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    /**
     * 1.输出，out内置对象，可以直接使用，jsp有9个内置对象:
     *  request、response、session、application、out、
     *  pagecontext、config、page、exception
     * 2.out对象的类型是JspWriter。JspWriter继承了java.io.Writer类。
     *  重载的print方法可将各种类型的数据转换成字符串的形式输出，
     *  而重载的write方法只能输出字符、字符数组和字符串等与字符相关的数据。
     */
    out.print(time);
%>
</body>
</html>
