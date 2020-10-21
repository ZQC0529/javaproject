<jsp:useBean id="md5" class="md5.keyBean"/>
<%
	String s = "How are you!";
	out.print("Before md5:" + s + "<br>");
	s = md5.getkeyBeanofStr(s);
	out.print("After md5:" + s);
%>
