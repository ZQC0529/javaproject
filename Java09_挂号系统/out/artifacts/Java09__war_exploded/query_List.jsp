<%--
  Created by IntelliJ IDEA.
  User: cc
  Date: 2020/1/3
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询结果</title>
</head>
<body>

<FONT COLOR="#00008b" size="25px"> <B>您的查询结果如下:</B></FONT><br/>
<table border="1" width="700" height="10" align="center"><tr>
    <td><center><B>记录编号</B></center></td>
    <td><center><B>病人id</B></center></td>
    <td><center><B>科室id</B></center></td>
    <td><center><B> 挂号费 </B></center></td>
    <td><center><B>挂号时间</B></center></td>
</tr>

    <td><center><B>${sessionScope.record.id}</B></center></td>
    <td><center><B>${sessionScope.record.patient_id}</B></center></td>
    <td><center><B>${sessionScope.record.dept_id}</B></center></td>
    <td><center><B>${sessionScope.record.price}</B></center></td>
    <td><center><B>${sessionScope.record.reg_time}</B></center></td>
</table>
</body>
</html>
