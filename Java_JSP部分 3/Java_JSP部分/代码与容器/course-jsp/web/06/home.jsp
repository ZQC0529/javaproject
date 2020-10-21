<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.zuel.course.ch06.model.User" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <jsp:useBean id="user" class="org.zuel.course.ch06.model.User" />
    <jsp:setProperty name="user" property="username" />
    <h3>
        ${requestScope.user.username}
        <%= ((User) request.getAttribute("user")).getUsername()%>
        ${sessionScope.login}
        <%= session.getAttribute("login")%>
    </h3>
    <h3>
        <jsp:getProperty name="user" property="username" />
        ${user["username"]}
        您好!
    </h3>
    <h3>欢迎使用书签管理系统.</h3>

    <a href="./list">查看书签列表</a>&nbsp;&nbsp;&nbsp;
    <a href="./add.html">添加书签</a>&nbsp;&nbsp;&nbsp;
    <a href="./logout">退出登录</a><br>
    <a href="/index.jsp">返回导航页</a>
</body>
</html>
