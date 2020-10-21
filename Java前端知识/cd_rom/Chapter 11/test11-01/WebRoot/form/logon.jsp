<%@ page language="java"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for LogonForm form</title>
	</head>
	<body>
		<html:form action="/logon">
			userid : <html:text property="userid"/><html:errors property="userid"/><br/>
			userpwd : <html:password property="userpwd"/><html:errors property="userpwd"/><br/>
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>

