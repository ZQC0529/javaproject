<%@ page contentType="text/html;charset=GBk" %>
<html>
  <head>
    <title>&lt;c:import&gt;</title>
  </head>
  <body>
    <h3>&lt;c:import&gt;</h3>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <c:import url="/forToken.jsp"/>
    <h3>&lt;c:import&gt;</h3>
    <c:import url="/WEB-INF/web.xml" var="url" />
    <pre><c:out value="${url}"/></pre>
	
	<c:url value="forToken.jsp" var="url">
	   <c:param name="Id" value="12345678"/>
	   <c:param name="Type" value="String"/>
	</c:url>
	<c:import url="${url}"/>


   </body>
</html> 
