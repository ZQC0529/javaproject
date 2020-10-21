<%@ page language="java" pageEncoding="GBK" %>
<%@ page import="java.awt.*" %>
<jsp:useBean id="wm" class="water.WaterMark"/>
<%
String filepath = application.getRealPath("img.jpg");
String words="这是添加的水印";
if(wm.createMark(filepath,words,Color.ORANGE,70f))
{
  out.print("添加水印成功！");
  out.print("<p><img src=img.jpg>");
}
else
{
  out.print("添加水印失败！");
}
%>
