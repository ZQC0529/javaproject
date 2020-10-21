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
String str = request.getParameter("id");
if (str == null) str = "1";
try{
	conn=DriverManager.getConnection("jdbc:odbc:grade");
	stmt=conn.createStatement();
	rs=stmt.executeQuery("SELECT * FROM grade WHERE 学号="+str);
	if(rs.next()){
		out.print(rs.getString("姓名")+"的成绩为");
		out.print("<BR>语文成绩:"+rs.getString("语文"));
		out.print("<BR>数学成绩:"+rs.getString("数学"));
		out.print("<BR>英语成绩:"+rs.getString("英语"));
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
