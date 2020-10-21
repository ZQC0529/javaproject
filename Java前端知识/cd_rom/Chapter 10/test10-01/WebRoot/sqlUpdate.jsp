<%@ page contentType="text/html;charset=GBk" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>  <body>
<!-- 设置数据源 -->
<sql:setDataSource url="jdbc:odbc:grade" driver="sun.jdbc.odbc.JdbcOdbcDriver" user=" " password=" "  var="ds"/>
<h4>创建表myTable：CREATE TABLE</h4>
<sql:update dataSource="${ds}" var="newTable">
    CREATE TABLE mytable (nameid int primary key,name varchar(80),role varchar(80))
</sql:update>
<h4>向表myTable中插入记录：INSERT INTO</h4>
<sql:update dataSource="${ds}" var="updateCount">
    INSERT INTO mytable VALUES (1,'张三','管理员')
</sql:update>
<sql:update dataSource="${ds}" var="updateCount">
    INSERT INTO mytable VALUES (2,'李四','用户')
</sql:update>
<sql:update dataSource="${ds}" var="updateCount">
    INSERT INTO mytable VALUES (3,'周一','未验证')
</sql:update>
<h4>查询表的记录：SELECT</h4>
<sql:query dataSource="${ds}" var="deejays">
    SELECT * FROM mytable
</sql:query>
<table border="1">
  <%-- 获取查询结果的字段名作为HTML表头 --%>
  <c:forEach var="columnName" items="${deejays.columnNames}">
    <th><c:out value="${columnName}"/></th>
  </c:forEach>
  <%-- 显示每条记录 --%>
  <c:forEach var="row" items="${deejays.rowsByIndex}">
    <tr><c:forEach var="column" items="${row}">
        <td><c:out value="${column}"/></td>
      </c:forEach></tr>
  </c:forEach>
</table>
<h4>删除表myTable中nameid为2的记录：DELETE</h4>
<sql:update var="updateCount" dataSource="${ds}">
    DELETE FROM mytable WHERE nameid=2
</sql:update>
<h4>查询表的记录：SELECT</h4>
<sql:query var="deejays" dataSource="${ds}">
  SELECT * FROM mytable
</sql:query>
<%-- 显示查询结果的另外一种方法 --%>
<table border="1">
<c:forEach var="row" items="${deejays.rows}" varStatus="status">
    <%-- 获取查询结果的字段名作为HTML表头  --%>
    <c:choose>
      <c:when test="${status.count == 1}">
        <%-- 每条记录是一个关键字为列名的Map对象 --%>
        <tr>
        <c:forEach var="metaData" items="${row}">
          <th><c:out value="${metaData.key}"/></th>
        </c:forEach>
        </tr>
      </c:when>
    </c:choose>
    <tr>
    <%-- 显示每条记录 --%>
    <c:forEach var="column" items="${row}">
      <td><c:out value="${column.value}"/></td>
    </c:forEach>
  </tr>
</c:forEach>
</table>
<h4>删除表myTable：DROP</h4>
<sql:update var="newTable" dataSource="${ds}" >
  DROP TABLE mytable
</sql:update>
</body>   </html>
