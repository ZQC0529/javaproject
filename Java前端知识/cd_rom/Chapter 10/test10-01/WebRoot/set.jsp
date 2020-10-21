<%@ page contentType="text/html;charset=GBK" import="java.util.HashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<%
    HashMap person = new HashMap();
    person.put("address", new HashMap());
    //设置请求有效变量chen
    request.setAttribute("chen", person);
    ((HashMap) person.get("address")).put("street", "北京路22号");
%>
<b>街道</b>：<c:out value="${chen.address.street}"/><br />
<!--设置HashMap的属性值-->
<c:set target="${chen.address}" property="city" value="北京"/>
<b>城市</b>：<c:out value="${chen.address.city}"/>
<br/>
<!--使用本体设置变量cityName属性值，请求有效-->
<c:set var="cityName" scope="request">
  <c:out value="${chen.address.city}"/>
</c:set>
<b>变量cityName的值为</b>：<c:out value="${cityName}"/>
<br/>
<!--设置HashMap的属性值-->
<c:set target="${chen}" property="name" value="小王"/>
<c:set target="${chen}" property="book">
	JSTL入门与提高
</c:set>
<b>姓名</b>：<c:out value="${chen.name}"/>
<b>书名</b>：<c:out value="${chen.book}"/>
<p />
<!--使用本体设置会话有效的属性reqTable,其值为一个表格,会话有效-->
<c:set var="reqTable" scope="session">
<table border="1">
    <c:forEach var="req" items="${requestScope}">
    <tr>
	  <td>${req.key}</td>
	  <td><c:out value="${req.value}" default="no accept specified"/></td>
    </tr>
  </c:forEach>
</table>
</c:set>
<b>变量reqTable的值为</b>：<br />
<b>escapeXml="true"</b>:<br />
<c:out value="${reqTable}"/><br />
<b>escapeXml="false"</b>:<br />
<c:out value="${reqTable}" escapeXml="false" />
</body>  </html>
