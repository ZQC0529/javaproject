<%@ page contentType="text/html;charset=GBK" %>
<HTML>
<BODY>
	<%
	String str = "╩╤с╜!";
	session.setAttribute("Greeting", str); 
	out.print(session.getAttribute("Greeting"));
	%>
	<br><a href="4-24.jsp">обр╩рЁ</a>
</BODY>
</HTML>
