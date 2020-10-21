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
<FONT COLOR="#00008b" size="25px"> <B>${sessionScope.userName}  </B>欢迎你!</FONT><br/>
<FONT COLOR="#00008b" size="25px"> <B>您的基本信息如下:</B></FONT><br/>
<table border="1" width="700" height="10" align="center">
    <tr>
        <td><center><FONT color="#8b008b" size="5px"><B>病人ID</B></FONT></center></td>
        <td><center><FONT color="#8b008b" size="5px"><B>病人姓名</B></FONT></center></td>
        <td><center><FONT color="#8b008b" size="5px"><B>病人性别</B></FONT></center></td>
        <td><center><FONT color="#8b008b" size="5px"><B>病人年龄</B></FONT></center></td>
    </tr>

    <td><center><FONT size="5px">${sessionScope.patient_session.id}</FONT></center></td>
    <td><center><FONT size="5px">${sessionScope.patient_session.name}</FONT></center></td>
    <td><center><FONT size="5px">${sessionScope.patient_session.sex}</FONT></center></td>
    <td><center><FONT size="5px">${sessionScope.patient_session.age}</FONT></center></td>
<%--    <c:forEach items="${sessionScope.patient_session}" var="patient" >--%>
<%--        <tr>--%>
<%--            <td>${patient.id}</td>--%>
<%--            <td>${patient.name}</td>--%>
<%--            <td>${patient.sex}</td>--%>
<%--            <td>${patient.age}</td>--%>
<%--            <td>${"明天早起"}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>

</table>
<center>
    <TR>
    <TD height=29 align=middle ><INPUT style="width: 120px;height: 50px;font-size: 25px;font-weight: bold;color: darkblue" class=Btn onclick="window.self.location='./add.jsp'" value="👆挂号"  type=button name=Submit >
    </TD>
    </TR>
</center>
</body>
</html>