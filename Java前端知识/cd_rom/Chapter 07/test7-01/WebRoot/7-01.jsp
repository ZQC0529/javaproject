<%@page contentType="text/html;charset=gb2312"%>
<%@page import="java.sql.*"%>
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
	stmt=conn.createStatement();
	rs=stmt.executeQuery("SELECT * FROM grade");
	while(rs.next()){
		out.print(rs.getString("学号"));
		out.print(rs.getString("姓名"));
		out.print(rs.getString("语文"));
		out.print(rs.getString("数学"));
		out.print(rs.getString("英语"));
		out.print("<BR>");
	}
}
catch(SQLException e){
	System.out.println(e.getMessage());
}
finally{
	stmt.close();
	conn.close();
}
%>
