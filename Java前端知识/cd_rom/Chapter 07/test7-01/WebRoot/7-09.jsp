<%@page contentType="text/html;charset=gb2312"%>
<%@page import="java.sql.*"%>
<HTML><BODY>
<%
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
String strSQL = "";
int PageSize = 5;
int Page = 1;
int totalPage = 1;
int totalrecord = 0;
try{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
}
catch(ClassNotFoundException ce){
	out.println(ce.getMessage());
}
try{
	conn=DriverManager.getConnection("jdbc:odbc:grade");
	stmt=conn.createStatement(
		ResultSet.TYPE_SCROLL_INSENSITIVE,
		ResultSet.CONCUR_READ_ONLY);
	//输出记录
	strSQL = "SELECT * FROM grade";
    rs = stmt.executeQuery(strSQL);
    //算出总行数
     if (rs.next()){   
    rs.last();   
    totalrecord   =   rs.getRow();//得到记录集的总记录数（总行数）；   
    rs.first();   
    }      
	if(totalrecord % PageSize ==0)// 如果是当前页码的整数倍
		totalPage = totalrecord / PageSize; 
	else  // 如果最后还空余一页
		totalPage = (int) Math.floor( totalrecord / PageSize ) + 1; 
	if(totalPage == 0) totalPage = 1;
	if(request.getParameter("Page")==null || request.getParameter("Page").equals(""))
		Page = 1;
	else
	try {
		Page = Integer.parseInt(request.getParameter("Page"));
	}
    catch(java.lang.NumberFormatException e){
		// 捕获用户从浏览器地址拦直接输入Page=sdfsdfsdf所造成的异常
		Page = 1;
	}
	if(Page < 1)  Page = 1;
	if(Page > totalPage) Page = totalPage;
	rs.absolute((Page-1) * PageSize + 1);
	out.print("<TABLE BORDER='1'>");
	for(int iPage=1; iPage<=PageSize; iPage++)
	{
		out.print("<TR><TD>"+rs.getString("学号")+"</TD>");
		out.print("<TD>"+rs.getString("姓名")+"</TD>");
		out.print("<TD>"+rs.getString("语文")+"</TD>");
		out.print("<TD>"+rs.getString("数学")+"</TD>");
		out.print("<TD>"+rs.getString("英语")+"</TD></TR>");
		if(!rs.next()) break;
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
<FORM Action="7-09.jsp" Method="GET">
<% 
   if(Page != 1) {
      out.print("   <A HREF=7-09.jsp?Page=1>第一页</A>");
      out.print("   <A HREF=7-09.jsp?Page=" + (Page-1) + ">上一页</A>");
   }
   if(Page != totalPage) {
      out.print("   <A HREF=7-09.jsp?Page=" + (Page+1) + ">下一页</A>");
      out.print("   <A HREF=7-09.jsp?Page=" + totalPage + ">最后一页</A>");
   }
%>
<BR>输入页数：<input TYPE="TEXT" Name="Page" SIZE="3"> 
页数:<font COLOR="Red"><%=Page%>/<%=totalPage%></font> 
</FORM>

