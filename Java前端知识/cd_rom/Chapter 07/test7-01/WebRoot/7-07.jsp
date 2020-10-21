<%@page contentType="text/html;charset=gb2312"%>
<%@page import="java.sql.*"%>
<HTML><BODY>
<%
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
try{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
}
catch(ClassNotFoundException ce){
	out.println(ce.getMessage());
}
try{
	conn=DriverManager.getConnection("jdbc:odbc:grade");
	stmt=conn.createStatement(
		ResultSet.TYPE_SCROLL_INSENSITIVE,
		ResultSet.CONCUR_READ_ONLY);
	rs=stmt.executeQuery("SELECT * FROM grade");
	out.print("<TABLE BORDER='1'>");
    rs.absolute(3);
	out.print("<TR><TD>"+rs.getString("学号")+"</TD>");
	out.print("<TD>"+rs.getString("姓名")+"</TD>");
	out.print("<TD>"+rs.getString("语文")+"</TD>");
	out.print("<TD>"+rs.getString("数学")+"</TD>");
	out.print("<TD>"+rs.getString("英语")+"</TD></TR>");
	out.print("</TABLE>");
}
catch(SQLException e){
	System.out.println(e.getMessage());
}
finally{
	stmt.close();
	conn.close();
}
%>
