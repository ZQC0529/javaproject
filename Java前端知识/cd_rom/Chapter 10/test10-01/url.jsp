<%@ page contentType="text/html;charset=GBk" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
  <head>
    <title>&lt;c:url&gt;</title>
  </head>
  <body>
    <h3>&lt;c:url&gt;</h3>
    <font size=-1>在将鼠标移到对应的超链接上，浏览器状态栏中可以看到结果。</font><p/>
    <b>c:url 嵌入html标记中：</b>
    <a href="<c:url value="/forToken.jsp" />">&lt;c:forToken&gt;的用法</a>
    <br/>结果：http://localhost:2008/helloBeijing/forToken.jsp<p/>
    <b>使用var属性保存URL：</b>
    <c:url var="url1" value="/forToken.jsp"/>
    <a href="${url1}">&lt;c:forToken&gt;的用法</a>
    <br/>结果：http://localhost:2008/helloBeijing/forToken.jsp<p/>
    <b>使用其他Web应用URL：</b>
    <c:url var="examples" value="/index.html" context="/jsp-examples"/>
    <a href="${examples}">Tomcat实例</a>
    <br/>结果：http://localhost:2008/jsp-examples/index.html<p/>
    <b>使用参数：</b>
    <c:url value="/forToken.jsp" var="url1">
	   <c:param name="Id" value="12345678"/>
	   <c:param name="Type" value="String"/>
	</c:url>
	<a href="${url1}">带参数的URL</a>
    <br/>结果：http://localhost:2008/helloBeijing/forToken.jsp?Id=12345678&Type=String<p/>
    <b>使用绝对URL：</b>
    <c:url var="ftp1" value="ftp://ftp.helloBeijing.org/form.xml"/>
    <a href="${ftp1}">绝对URL</a>
    <br/>结果：ftp://ftp.hellobeijing.org/form.xml
   </body>
</html> 
