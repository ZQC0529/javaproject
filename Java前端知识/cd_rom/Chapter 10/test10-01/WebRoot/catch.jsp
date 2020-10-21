<%@ page contentType="text/html;charset=GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>   <body>
    <c:catch var="exception">
        <fmt:parseDate var="d1" value="${param.date1}"
                      pattern="yyyy-MM-dd" />
        <c:out value="${param.date1}"/>:<c:out value="${d1}"/>
        <fmt:parseDate var="d2" value="${param.date2}"
                      pattern="yyyy-MM-dd" />
        <c:out value="${param.date2}"/>:<c:out value="${d2}"/>
    </c:catch>
    <c:if test="${exception != null}">
        <h4>∑¢…˙“Ï≥££∫</h4>
        <c:out value="${exception}" escapeXml="false" />
    </c:if>
</body>    </html>
