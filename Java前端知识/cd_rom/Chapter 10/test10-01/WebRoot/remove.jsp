<%@ page contentType="text/html;charset=GBK" import="java.util.HashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>   <body>
<c:set var="browser" value="${header['User-Agent']}" scope="session" />
<b> browser 的值</b> : <c:out value="${browser}"/><br />
<c:remove var="browser" scope="session" />
<b>c:remove执行后，browser 的值</b> : <c:out value="${browser}"/>
</body>   </html>
