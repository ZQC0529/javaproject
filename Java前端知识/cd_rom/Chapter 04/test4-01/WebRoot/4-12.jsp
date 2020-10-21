<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="java.util.*" %>
<P>现在的时间是：<BR>
<% out.println(""+new Date());
   response.setHeader("Refresh","5");
 %>
