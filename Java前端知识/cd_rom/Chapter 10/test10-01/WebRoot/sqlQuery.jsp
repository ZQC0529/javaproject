<%@ page contentType="text/html;charset=GBk" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<sql:setDataSource url="jdbc:odbc:grade" driver="sun.jdbc.odbc.JdbcOdbcDriver" user=" " password=" "  var="ds"/>
<!-- 执行一个数据库查询，结果保存在变量results -->
<sql:query sql="select * from grade" var="results"
    dataSource="${ds}"/>
<!-- 显示查询结果 -->
<html>
<head>
  <title>JSTL: SQL 查询</title>
</head>
<body>
<h4>JSTL: SQL 查询</h4>
<table border="1">
<tr><th>学号</th><th>姓名</th><th>语文</th><th>数学</th></tr>
<c:forEach var="row" items="${results.rows}">
    <tr><td><c:out value="${row.学号}"/></td>
        <td><c:out value="${row.姓名}"/></td>
        <td><c:out value="${row.语文}"/></td>
        <td><c:out value="${row.数学}"/></td>
    </tr>
</c:forEach>
</table>
</body>  </html>
