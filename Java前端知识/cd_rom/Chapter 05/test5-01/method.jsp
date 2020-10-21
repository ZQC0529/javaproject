<%@ page contentType="text/html;charset=GB2312" %>
<HTML><BODY>
   <jsp:useBean id="girl" class="Bean.j5_01" scope="page" >
   </jsp:useBean>
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
