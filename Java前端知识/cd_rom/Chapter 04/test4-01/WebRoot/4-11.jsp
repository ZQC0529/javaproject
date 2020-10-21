<%@ page contentType="text/html;charset=GBK" %>
<HTML>
	<BODY>
	<P>response对象 <BR>setContentType方法
	<P>将当前页面保存为word文档吗
	<%
	response.setContentType("application/msword;charset=GB2312");
	%> 
	</BODY>
</HTML>