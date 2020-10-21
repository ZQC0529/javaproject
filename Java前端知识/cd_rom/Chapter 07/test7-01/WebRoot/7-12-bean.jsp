<%@page contentType="text/html;charset=gb2312"%>
<%@page import="java.sql.*"%>
<jsp:useBean id="connDbBean" scope="page" class="db.dbConn"/>
<%
ResultSet rs = connDbBean.executeQuery("SELECT * FROM grade");
while(rs.next()){
	out.print(rs.getString("学号"));
	out.print(rs.getString("姓名"));
	out.print(rs.getString("语文"));
	out.print(rs.getString("数学"));
	out.print(rs.getString("英语"));
	out.print("<BR>");
}
%>

