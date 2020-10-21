<%@ page contentType="text/html;charset=GBk" import="java.util.Calendar" %>
<html>  <body>
    <font color="#000000"/>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <h4>将表达式结果赋值给变量</h4>
    <c:if test="${1==1}" var="theTruth" scope="session"/>
    表达式 (1==1) 的结果为: ${theTruth}
    <h4>依据条件执行本体内容</h4>
    <c:if test="${2>0}">
	    条件表达式的值为：2>0 = ${2>0}<p />
    </c:if>
    <h4>依据当前时间来输出不同的问候语</h4>
    <%
    Calendar rightNow = Calendar.getInstance();
    Integer Hour=new Integer(rightNow.get(Calendar.HOUR_OF_DAY));
    request.setAttribute("hour", Hour);
    %>
    <c:if test="${hour >= 0 && hour <=11}">
        <c:set var="sayHello" value="上午好！"/>
    </c:if>
    <c:if test="${hour >= 12 && hour <=17}">
        <c:set var="sayHello" value="下午好！"/>
    </c:if>
    <c:if test="${hour >= 18 && hour <=23}">
        <c:set var="sayHello" value="晚上好！"/>
    </c:if>
    <c:out value="现在时间：${hour}时，"/>
    <c:out value="${sayHello}"/>
  </body>   </html>
