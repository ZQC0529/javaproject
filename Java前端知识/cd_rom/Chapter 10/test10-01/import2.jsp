<%@ page contentType="text/html;charset=GBk" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>&lt;c:import&gt;</title>
  </head>
  <body>
    <h3>&lt;c:import&gt;</h3>
    <c:import url="/WEB-INF/web.xml" var="url" />
    <pre><c:out value="${url}"/></pre>
   </body>
</html> 
