<%@ page contentType="text/html;charset=GBk" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>   <body>
  	<c:import url="/forToken.jsp">
	   <c:param name="Id" value="123"/>
	   <c:param name="Type" value="String"/>
	</c:import>
     <c:url value="forToken.jsp" var="url">
	   <c:param name="Id" value="123"/>
	   <c:param name="Type" value="String"/>
	</c:url>
	<c:import url="${url}"/>
    <c:import url="forToken.jsp?Id=123&Type=String"/>
</body>  </html>
