<%@page contentType="text/html;charset=gb2312"%>
<%@page import="java.sql.*"%>
<%
Connection conn = null;
PreparedStatement pst = null;
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
}
catch(ClassNotFoundException ce){
	out.println(ce.getMessage());
}
try{
	String url="jdbc:oracle:thin:@localhost:1521:oradb";	
	conn=DriverManager.getConnection(url,"scott","tiger");
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
