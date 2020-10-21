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
	pst = conn.prepareStatement("INSERT INTO grade(Ñ§ºÅ) VALUES (?)");
	for (int i = 101; i < 111; i++) {
		pst.setInt(1, i);
		pst.addBatch();
}
pst.executeBatch();
}
catch(SQLException e){
	System.out.println(e.getMessage());
}
finally{
	pst.close();
	conn.close();
}
%>
