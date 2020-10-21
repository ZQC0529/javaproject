<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="m" uri="http://org.zuel.edu.cn/mytag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tag Test</title>
</head>
<body>
    <c:if test="${param.a > param.b}">
        <h3>判断正确</h3>
    </c:if>
    <m:if test="${param.a > param.b}">
        <h3>判断正确</h3>
    </m:if>
</body>
</html>
