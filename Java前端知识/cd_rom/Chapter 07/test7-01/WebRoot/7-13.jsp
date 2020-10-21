<%@page contentType="text/html;charset=gb2312"%>
<%@page import="java.sql.*"%>
<jsp:useBean id="connDbBean" scope="page" class="db.dbConn"/>
<%
connDbBean.executeUpdate("INSERT INTO grade(Ñ§ºÅ) VALUES(4004)");
%>

