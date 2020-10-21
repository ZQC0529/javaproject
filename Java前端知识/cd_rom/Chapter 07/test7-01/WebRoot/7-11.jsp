<%@page contentType="text/html;charset=gb2312"%>
<%@page import="java.sql.*"%>
<%
Connection conn = null;
PreparedStatement pst = null;
try{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
}
catch(ClassNotFoundException ce){
	out.println(ce.getMessage());
}
try{
	conn = DriverManager.getConnection("jdbc:odbc:grade");
	pst = conn.prepareStatement("INSERT INTO grade(学号,姓名,数学) VALUES (?,?,?)");
	pst.setInt(1,1001);
	pst.setString(2,"王九");
	pst.setInt(3,88);	
	pst.executeUpdate();
}
catch(SQLException e){
	System.out.println(e.getMessage());
}
finally{
	pst.close();
	conn.close();
}
%>
