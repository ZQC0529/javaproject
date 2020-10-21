<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>500</title>
</head>
<body>
    <h3>当前操作出现错误，错误详情如下</h3>
    <div style="border:1px solid" >${requestScope.error}</div>
    <a href="./list">查看书签列表</a>&nbsp;&nbsp;&nbsp;
    <a href="./add.html">添加书签</a>&nbsp;&nbsp;&nbsp;
    <a href="./del.html">删除书签</a><br>
</body>
</html>
