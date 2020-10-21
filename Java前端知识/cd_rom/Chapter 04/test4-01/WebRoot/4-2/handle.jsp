<%@ page contentType="text/html;charset=GBK" %>
<%
	request.setCharacterEncoding("GBK");
	String strUserName = request.getParameter("USERNAME");
	String strUserPWD = request.getParameter ("USERPWD");
	String strUserSex = request.getParameter ("SEX");
	String strUserBlood = request.getParameter ("BLOOD");
	String strUserChar = request.getParameter ("CHATACTER");
	String strUserMemo = request.getParameter ("MEMO");
	String strUserCity = request.getParameter ("CITY");
%>
用户名是：<%=strUserName%><br>
用户密码：<%=strUserPWD%><br>
你的性别：<%=strUserSex%><br>
你的血型：<%=strUserBlood%><br>
你的性格：<%=strUserChar%><br>
你的简介：<%=strUserMemo%><br>
所在城市：<%=strUserCity%><br>
