<%@page contentType="text/html;charset=gb2312"%>
<%@page import="java.sql.*"%>
<%
try{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
	Connection conn = DriverManager.getConnection("jdbc:odbc:person", "", ""); 
	Statement stmt  = conn.createStatement();
	ResultSet rs=stmt.executeQuery("select * from [Sheet1$]");
	while(rs.next()){
		out.print("  ±àºÅ£º" + rs.getString(1));
		out.print("  ÐÕÃû£º" + rs.getString(2));
		out.print("  ×ùÎ»£º" + rs.getString(3));
		out.print("<BR>");
	}
	rs.close();
	stmt.close();
	conn.close();
}catch(Exception e){
	e.printStackTrace();
}
%>