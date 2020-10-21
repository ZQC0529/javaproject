<%@ page contentType="text/html;charset=GBk" import="java.util.Calendar" %>
<html>    <body>
    <font color="#000000"/>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <h4>依据条件执行不同的when本体</h4>
    <c:forEach var="index" begin="0" end="4">
      # ${index}: 
      <c:choose>
		<c:when test="${index == 1}">
	          符合第一个条件</br>
		</c:when>
		<c:when test="${index == 4}">
	          符合第二个条件</br>
		</c:when>
		<c:when test="${index == 3}">
	          符合第三个条件</br>
		</c:when>
		<c:otherwise>
	          没有符合任何条件</br>
		</c:otherwise>
      </c:choose>
    </c:forEach>
    <h4>依据当前时间来输出不同的问候语</h4>
	<%
	Calendar rightNow = Calendar.getInstance();
	Integer Hour=new Integer(rightNow.get(Calendar.HOUR_OF_DAY));
	request.setAttribute("hour", Hour);
	%>
	<c:choose>
		<c:when test="${hour >= 0 && hour <=11}">
		    <c:set var="sayHello" value="上午好！"/>
		</c:when>
		<c:when test="${hour >= 12 && hour <=17}">
		    <c:set var="sayHello" value="下午好！"/>
		</c:when>
		<c:otherwise>
		    <c:set var="sayHello" value="晚上好！"/>
		</c:otherwise>
	</c:choose>
    <c:out value="现在时间：${hour}时，"/>
    <c:out value="${sayHello}"/>    <p />
   </body>   </html>

