<%@ page contentType="text/html;charset=GBk" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>JSTL: Formatting/I18N</title>
</head>
<body>
<h3>JSTL: Formatting/I18N</h3>
<p>
<c:if test="${!empty param.locale}">
  <fmt:setLocale value="${param.locale}" scope="page"/>
</c:if>
<br>

<fmt:bundle basename="i18n.Resources">
<table cellpadding="5" border="1">
  <tr>
    <th align="left">键</th>
    <th align="left">值</th>
  </tr>
  <tr>
    <td>greetingMorning</td>
    <td><fmt:message key="greetingMorning"/></td>
  </tr>
  <tr>
    <td>greetingEvening</td>
    <td><fmt:message key="greetingEvening"/></td>
  </tr>
  <tr>
    <td>currentTime</td>
    <td>
      <fmt:message key="currentTime">
        <fmt:param value="${now}"/>
      </fmt:message>
    </td>
  </tr>
  <tr>
    <td>serverInfo</td>
    <td><fmt:message key="serverInfo"/></td>
  </tr>
  <tr>
    <td>undefinedKey</td>
    <td><fmt:message key="undefinedKey"/></td>
  </tr>
</table>
</fmt:bundle>

<p>
<h3>JSTL: Formatting/I18N</h3>
<table>
<tr>
  <td><b>设置本地属性（locale）</b></td>
  <td>
	<a href='?locale=zh'>中文</a> &#149;
	<a href='?locale=en'>英文</a> &#149;
	<a href='?locale=de'>德文(没有资源包)</a> 
  </td>
</tr>
</table>
<p>

请求参数locale: <c:out value="${param.locale}"/><br>

浏览器的locales: 
<% 
  Enumeration enum = request.getLocales();
  while (enum.hasMoreElements()) {
    Locale locale = (Locale)enum.nextElement();
    out.print(locale);
    out.print(" ");
  }
%>
<jsp:useBean id="now" class="java.util.Date" />
<h4>
<fmt:formatDate value="${now}" dateStyle="full"/> &#149;
<fmt:formatDate value="${now}" type="time"/>
</h4>
<p>

</body>
</html>
