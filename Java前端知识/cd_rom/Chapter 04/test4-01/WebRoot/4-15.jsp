<%@ page contentType="text/html;charset=GBK" %>
<%
request.setCharacterEncoding("GBK");
String strUserName = "";
String strUserPWD = "";
strUserName = request.getParameter("UserID");
strUserPWD = request.getParameter("UserPWD");
%>
аеУћЃК<%=strUserName%><br>
УмТыЃК<%=strUserPWD%>
