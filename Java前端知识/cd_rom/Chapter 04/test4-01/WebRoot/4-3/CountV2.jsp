<%@ page contentType="text/html;charset=GB2312" %>
<HTML> <BODY>
<%!
	String G(Integer counter)
	{
	   String S, myimage;
                    myimage = "";
	   S = counter.toString() ;

	   for(int i = 0; i<S.length(); i++)
	   {
                         myimage = myimage + "<IMG SRC=" + S.charAt(i) + ".GIF>";
	   }
	   return myimage;
	}
%>
<%
	Integer number=(Integer)application.getAttribute("Count");
	if(number==null)	{ 
		number=new Integer(1);
		application.setAttribute("Count",number); 
	}
	else   { 
		number=new Integer(number.intValue() + 1);
		application.setAttribute("Count",number); 
	}
	%>
您是第<%=G((Integer)application.getAttribute("Count"))%>
个访问本站的客户。
</BODY>
</HTML>