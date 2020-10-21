<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="Bean.j5_01"%> 
<HTML><BODY>
<%
	j5_01 girl = new j5_01();
%>
   <% 
      girl.setRadius(100);
   %>
<P>圆的半径是：
   <%=girl.getRadius()%>
<P>圆的周长是：
   <%=girl.circlLength()%>
<P>圆的面积是：
   <%=girl.circleArea()%>
</BODY></HTML>
