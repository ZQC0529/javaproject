<%@page contentType="text/html;charset=gb2312"%>
<%@page import="java.sql.*"%>
<%
Connection conn = null;
Statement stmt = null;
boolean defaultCommit = false;
String strSQL1 = "INSERT INTO grade(学号) VALUES(9001)";
String strSQL2 = "UPDATE grade SET 姓名='张三' WHERE 学号=9001";
try{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
}
catch(ClassNotFoundException ce){
	out.println(ce.getMessage());
}
try {
	conn = DriverManager.getConnection("jdbc:odbc:grade");
	defaultCommit = conn.getAutoCommit();
	conn.setAutoCommit(false);
	stmt = conn.createStatement();
	stmt.executeUpdate(strSQL1);
	stmt.executeUpdate(strSQL2);
	conn.commit();

}
catch (Exception e) {
	conn.rollback();
	e.printStackTrace();
}
finally {
	conn.setAutoCommit(defaultCommit);
	if (stmt != null) {
		stmt.close();
	}
	if (conn != null) {
		conn.close();
	}
}
%>