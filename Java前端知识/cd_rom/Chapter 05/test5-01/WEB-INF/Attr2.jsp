<%@ page contentType="text/html;charset=gb2312"%>
<HTML>	<BODY>
	<FORM action="" Method="post" >
	<P>输入1:
	<Input type=text name="sample1">
	<P>输入2：
	<Input type=text name="sample2">
	<Input type=submit value="提交">
	</FORM>
	<jsp:useBean id="myBean1" scope="page" class="sample.j5_02"/>
		<HR>
		<jsp:setProperty name="myBean1" property="*"/>
		<jsp:getProperty name="myBean1" property="sample1"/><BR>
		<jsp:getProperty name="myBean1" property="sample2"/>
		<p>
	</BODY></HTML>
