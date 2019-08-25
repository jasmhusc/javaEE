<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hsc.entity.User" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>foreach循环</title>
</head>
<body>
<%--
    作用：用于循环
    1.次数循环格式：
        <c:forEach begin="开始数字"  end="结束数字" var="循环变量名称，相当于i" step="步长默认为1，循环变量递增值，类似i++">
              循环体代码
        </c:forEach>
    2.List集合、数组循环格式【以后使用最多】：
        <c:forEach items="使用el获取遍历的集合" var="集合的每个元素" varStatus="循环过程信息">
               循环体代码
        </c:forEach>
        varStatus,循环过程信息,在线循环过程中foreach标签将一些数据放入到这个属性中，循环过程信息如下：
            index,循环的索引，从0开始
            count，循环的次数，从1开始
    3.Map循环格式：
        <c:forEach items="使用el获取遍历的Map集合" var="集合的每个元素类似每个entry" varStatus="循环过程信息">
                获取每个元素的key=${entry.key}  获取每个元素的value=${entry.value}
        </c:forEach>
        java代码分析：
                Set<Entry<String,Object>> set= Map.entrySet();
                一个Entry包含着一个键值对
--%>
<h4>次数循环格式</h4>
<c:forEach begin="1" end="5" step="1">
    <p>hello world</p>
</c:forEach>

<%--
    items： 表示要遍历的集合，要使用 EL
    var: 变量名，表示集合中的每个元素对象
    varStatus: 表示一个对象名字，当前的行对象。
    有四个属性：
        first: 第 1 个元素返回 true
        last: 最后 1 个元素返回 true
        count: 遍历到当前元素时，一共遍历了几个元素
        index: 当前元素的索引号，从 0 开始
--%>
<h4>List集合、数组循环格式</h4>
<%
    // 用集合演示，也可以用数组。
    ArrayList<User> users = new ArrayList<>();
    User mayun = new User("马云", 45, java.sql.Date.valueOf("1979-09-23"));
    User maht = new User("马化腾", 38, java.sql.Date.valueOf("1989-05-27"));
    users.add(mayun);
    users.add(maht);
    // 添加到域
    request.setAttribute("users", users);
%>
<c:forEach items="${users}" var="user" varStatus="status">
    <p>
        序号：${status.count} 姓名：${user.name} 生日：${user.birthday}
    </p>
</c:forEach>

<h4>Map循环格式</h4>
<%
    HashMap<String, User> map = new HashMap<>();
    map.put("my", mayun);
    map.put("mht", maht);
    // 添加到请求域
    request.setAttribute("map", map);
%>
<c:forEach items="${map}" var="entry" varStatus="status">
    <p>
        索引：${status.index} 姓名：${entry.value.name} 年龄：${entry.value.age}
    </p>
</c:forEach>
</body>
</html>
