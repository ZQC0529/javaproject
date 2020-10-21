<%@ page contentType="text/html;charset=gb2312"%>
<HTML>
	<jsp:useBean id="myBean1" scope="page" class="sample.j5_02"/>
	<BODY>
		<HR>
		调用jsp:setProperty之前的值：
		<jsp:getProperty name="myBean1" property="sample1"/>
		<p>
		<jsp:setProperty name="myBean1" property="sample1" value="hh"/>
		调用jsp:setProperty之后的值：
		<jsp:getProperty name="myBean1" property="sample1"/><BR>
		<HR>
		调用jsp:setProperty之前的值：
		<jsp:getProperty name="myBean1" property="sample2"/>
		<p>
		<jsp:setProperty name="myBean1" property="sample2" value="hh"/>
		调用jsp:setProperty之后的值：
		<jsp:getProperty name="myBean1" property="sample2"/>
	</BODY>
</HTML>
