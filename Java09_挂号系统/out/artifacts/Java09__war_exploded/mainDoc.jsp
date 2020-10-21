<%--
  Created by IntelliJ IDEA.
  User: cc
  Date: 2019/12/21
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.*"%>

<%@ page import="org.per.hospital5.model.*"%>
<!DOCTYPE >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录成功</title>
</head>
<body>
<FONT COLOR="#00008b" size="25px"> <B>${sessionScope.userName}  医生欢迎你。</B></FONT><br/>
    <FONT COLOR="#00008b" size="25px"><B> 您的部门当前的病人有：</B></FONT><br/>
<table border="1" width="700" height="10" align="center">
    <tr>
        <td><center><B>记录编号</B></center></td>
        <td><center><B>病人id</B></center></td>
        <td><center><B>病人姓名</B></center></td>
        <td><center><B>科室id</B></center></td>
        <td><center><B> 挂号费 </B></center></td>
        <td><center><B>挂号时间</B></center></td>
    </tr>

<%--    <td><center><B>${sessionScope.doc_session.id}</B></center></td>--%>
<%--    <td><center><B>${sessionScope.doc_session.patient_id}</B></center></td>--%>
<%--    <td><center><B>${sessionScope.pat_session.name}</B></center></td>--%>
<%--    <td><center><B>${sessionScope.doc_session.dept_id}</B></center></td>--%>
<%--    <td><center><B>${sessionScope.doc_session.price}</B></center></td>--%>
<%--    <td><center><B>${sessionScope.doc_session.reg_time}</B></center></td>--%>
        <c:forEach items="${sessionScope.doc_session}" var="record">
            <tr>
                <td>${record.id}</td>
                <td>${record.patient_id}</td>
                <td>${record.patient_name}</td>
                <td>${record.dept_id}</td>
                <td>${record.price}</td>
                <td>${record.reg_time}</td>
            </tr>
        </c:forEach>

</table>
<center>
    <TR>
        <TD height=29 align=middle ><INPUT style="width: 150px;height: 50px;font-size: 25px;font-weight: bold;color: darkblue" class=Btn onclick="window.self.location='./delete.jsp'" value="👆删除病人"  type=button name=Submit >
        <TD height=29 align=middle ><INPUT style="width: 150px;height: 50px;font-size: 25px;font-weight: bold;color: darkblue" class=Btn onclick="window.self.location='./query_Patient.jsp'" value="👆查找病人"  type=button name=Submit >
        </TD>
    </TR>
</center>


</body>
</html>