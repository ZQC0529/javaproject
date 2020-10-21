<%@ page contentType="text/html;charset=gb2312" %>
<%  
    String str=request.getParameter("errmsg");
    String errmsg=new String(str.getBytes("ISO-8859-1"),"GBK");
%>
对不起，您的操作有误。请参考下列提示: <p>
;<b><%=errmsg %></b>
