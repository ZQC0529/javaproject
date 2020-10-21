<%@ page contentType="text/html;charset=GBK" %>
<HTML> <BODY>
<%
   if(application.getAttribute("mywords").equals(null)){
	application.setAttribute("mywords","Start:");
	}	
	if(request.getParameter("mywords")!=null){
		String mywords = request.getParameter("mywords");
		mywords = (String)application.getAttribute("mywords") + "<br>" + mywords;
		application.setAttribute("mywords", mywords); 
		out.print((String)application.getAttribute("mywords"));
	}
%>
	<FORM ACTION="4-21.jsp" METHOD="get">
	<INPUT TYPE="TEXT" SIZE="30" NAME="mywords" VALUE="I LIKE CHAT">
	<INPUT TYPE="SUBMIT" name="submit" VALUE="Ìá½»">
	</FORM>
</BODY> </HTML>
