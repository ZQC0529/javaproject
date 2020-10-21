<%@ page contentType="text/html;charset=GBk" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>   <body>
    <c:set var="resultSet" value="使用set标记进行赋值" scope="request" />
    <table border="1">
      <tr>
        <th>姓名</th><th>性别</th><th>数学</th><th>外语</th><th>英语</th>  </tr>
      <tr>
      <c:forTokens items="${resultSet}" delims="," var="item">
        <td><c:out value="${item}"/></td>
      </c:forTokens>
      </tr>
    </table>
    <c:set var="strs" value="红,橙,黄|绿,蓝|青,紫" scope="request" />
	<h4><c:out value="${strs}"/></h4>
	<c:out value="使用 '|' 作为分隔字符:"/><br/>
	<c:forTokens var="str" items="${strs}"  delims="|" varStatus="status">
  		<c:out value="${str}"/> &#149; &#149; 
  		<c:if test="${status.last}">
	    	<br/>总共输出<c:out value="${status.count}"/> 个元素。
	    </c:if>   
	</c:forTokens>
	<p />
	<c:out value="同时使用 '|' 和 ',' 作为分隔字符:"/><br/>
	<c:forTokens var="str" items="${strs}"  delims="|," varStatus="status">
  		<c:out value="${str}"/> &#149; &#149; 
  		<c:if test="${status.last}">
	    	<br/>总共输出<c:out value="${status.count}"/> 个元素。
	    </c:if>   
	</c:forTokens>
   </body></html>
