<%@ page contentType="text/html;charset=GBK" %>
<HTML>
<BODY>
<%
	Cookie cookies[] = request.getCookies();
   for(int i=0; i<cookies.length; i++) {
       if(cookies[i].getName().equals("Name1"))
			out.print(cookies[i].getValue());
   }
%>
¶Á³öCookie<br><br>
