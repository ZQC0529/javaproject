<%@page contentType="text/html;charset=gb2312"%>
<%@page import="java.sql.*"%>
<%
Connection conn = null;
CallableStatement cs = null;
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
}
catch(ClassNotFoundException ce){
	out.println(ce.getMessage());
}
try{
	String url="jdbc:oracle:thin:@localhost:1521:oradb";	
	conn=DriverManager.getConnection(url,"scott","tiger");
	cs = conn.prepareCall("{call get_area_sub(?, ?, ?)}");
	cs.registerOutParameter(3, java.sql.Types.INTEGER);
	cs.setInt(1, 10);
	cs.setInt(2, 20);
	cs.execute();
	int iBack = cs.getInt(3);
	out.print(iBack);
}
catch(SQLException e){
	out.print(e.getMessage());
}
finally{
	cs.close();
	conn.close();
}
%>
