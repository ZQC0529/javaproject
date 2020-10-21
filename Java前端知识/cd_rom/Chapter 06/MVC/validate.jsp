<%!
   boolean isnotlogin = false;
%>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if(username==null || password==null) 
    {
      response.sendRedirect("error.jsp?errmsg=非法进入该页"); 
	return;
    } 
%>
    <jsp:useBean id="validatebean" scope="page" class="mypackage.validate">
      <jsp:setProperty  name="validatebean" property="username" param="username"/>
      <jsp:setProperty  name="validatebean" property="pwd" param="password" />
    </jsp:useBean>
<%
    isnotlogin = validatebean.uservalidate();
    if(!isnotlogin) 
    {
      response.sendRedirect("error.jsp?errmsg=用户名或者口令错误！");
	  return;
    }
    else 
    {
      session.setAttribute("username",username);
%>
      <jsp:forward page="forky" >
        <jsp:param name="username"  value="<%=username %>" />
      </jsp:forward>       
<%
    }
%>
