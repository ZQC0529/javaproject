<%@ page contentType="text/html;charset=GBK" %>
<%
	String strBack = (String)application.getAttribute("greeting");
	out.print(strBack);
%>
