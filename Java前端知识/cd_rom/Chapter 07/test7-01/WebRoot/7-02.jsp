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
	int iBack =stmt.executeUpdate("UPDATE grade SET 数学=数学+10");
	out.print("有" + iBack + "条记录被修改！");
}
catch(SQLException e){
	System.out.println(e.getMessage());
}
finally{
	stmt.close();
	conn.close();
}
%>
