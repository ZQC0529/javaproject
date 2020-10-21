<%@ page contentType="text/html;charset=GBk" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>&lt;c:import&gt;</title>
  </head>
  <body>
    <h3>&lt;c:import&gt;</h3>
  	<c:import url="/forToken.jsp">
	   <c:param name="Id" value="12345678"/>
	   <c:param name="Type" value="String"/>
	</c:import>
	<!-- 下面的语句有同样的效果 -->
   <c:url value="forToken.jsp" var="url">
	   <c:param name="Id" value="12345678"/>
	   <c:param name="Type" value="String"/>
	</c:url>
	<c:import url="${url}"/>
	<!-- 下面的语句有同样的效果 -->
    <c:import url="forToken.jsp?Id=12345678&Type=String "/>
   </body>
</html> 
