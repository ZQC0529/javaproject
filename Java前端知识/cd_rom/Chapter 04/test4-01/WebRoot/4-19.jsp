<%@ page contentType="text/html;charset=GBK" %>
<%
	String str = "ÄãºÃ";
	application.setAttribute("greeting",str); 
%>
<%
	String strBack = (String)application.getAttribute("greeting");
	out.print(strBack);
%>
