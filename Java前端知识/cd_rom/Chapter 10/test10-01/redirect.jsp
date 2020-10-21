<%@ page contentType="text/html;charset=GBk" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>&lt;c:redirect&gt;</title>
  </head>
  <body>
    <h3>&lt;c:redirect&gt;</h3>
	这里文字不会显示，因为下面语句会转向新的URL！
	<c:redirect url="/index.html" context="/jsp-examples" />
   </body>
</html> 
