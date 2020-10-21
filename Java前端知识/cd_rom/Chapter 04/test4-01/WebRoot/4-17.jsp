<%@page contentType="text/html;charset=GBK"%>
<%@page import="java.util.*"%>
<%
String current_param = "";
request.setCharacterEncoding("GBK");
Enumeration params = request.getParameterNames();
while(params.hasMoreElements()) {
	current_param = (String)params.nextElement();
	out.println("Name:   " + current_param + "<br>");
	out.println("Values: " + request.getParameter(current_param) + "<br>");
}
%>
