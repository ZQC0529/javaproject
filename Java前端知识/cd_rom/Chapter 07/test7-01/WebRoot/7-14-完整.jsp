<%@page contentType="text/html;charset=gb2312"%>
<%@page import="java.sql.*"%>
<%
String serverName = "localhost";
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@"+serverName+":1521:oradb";	
	Connection conn=DriverManager.getConnection(url,"scott","tiger");
	Statement stmt=conn.createStatement();			
	ResultSet rs=stmt.executeQuery("select * from dept");
	while(rs.next()){
		out.print("  "+rs.getInt(1));
		out.print("  "+rs.getString(2));
		out.println("  "+rs.getString(3)+"<br>");
	}
	rs.close();
	stmt.close();
	conn.close();
}catch(Exception e){
	out.print(e);
}
%>
