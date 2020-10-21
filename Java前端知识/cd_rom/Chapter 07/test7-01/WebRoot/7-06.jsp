<%@page contentType="text/html;charset=gb2312"%>
<%@page import="java.sql.*"%>
<HTML><BODY>
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
request.setCharacterEncoding("GBK");
String str = request.getParameter("keywords");
if( str == null)
	str = "";
try{
	conn=DriverManager.getConnection("jdbc:odbc:grade");
	stmt=conn.createStatement();
	rs=stmt.executeQuery("SELECT * FROM grade WHERE 姓名 LIKE '%" + str + "%'");
	out.print("<TABLE BORDER='1'>");

	while(rs.next()){
		out.print("<TR><TD>"+rs.getString("学号")+"</TD>");
		out.print("<TD>"+rs.getString("姓名")+"</TD>");
		out.print("<TD>"+rs.getString("语文")+"</TD>");
		out.print("<TD>"+rs.getString("数学")+"</TD>");
		out.print("<TD>"+rs.getString("英语")+"</TD></TR>");
	}
	out.print("</TABLE>");

}
catch(SQLException e){
	System.out.println(e.getMessage());
}
finally{
	stmt.close();
	conn.close();
}

%>
<FORM Action="7-06.jsp" Method=POST>
输入姓名关键字：
<INPUT Type="Text" Name="keywords" Value="<%=str%>"><P>
<INPUT Type=Submit Value=" 执行">
</FORM>
</BODY></HTML>
