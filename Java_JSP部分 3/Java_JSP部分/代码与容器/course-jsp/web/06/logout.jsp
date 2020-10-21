<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退出登录</title>
</head>
<body>
    <h1>用户 ${requestScope.username} ${username} 已退出登录。</h1>
    <a href="./login.html">返回登录</a><br>
    <a href="/index.jsp">回到导航页</a>
</body>
</html>
