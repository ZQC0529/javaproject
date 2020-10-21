package mypackage;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class forky extends HttpServlet{
	protected void doPost(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException   {
	HttpSession session = request.getSession(false);
      if(session==null){
		response.sendRedirect("error.jsp?errmsg=会话已经过期了！"); 
		return;
      }
      String username1 = (String)session.getAttribute("username");
      String username2 = request.getParameter("username");
      //如果session没有过期，username1的值和username2的值应该是相等的。      
      if(!username1.equals(username2)) {
		  response.sendRedirect("error.jsp?errmsg=会话已经过期！"); 
		  return;
      }      
      response.setContentType("text/html; charset=GBK");      
      PrintWriter out = response.getWriter();      
      request.setAttribute("username",username2);
      if(username2.equals("teacher")) { 
		 getServletConfig().getServletContext().getRequestDispatcher("/teacher.jsp").forward(request,response);
      }
      else {
		getServletConfig().getServletContext().getRequestDispatcher("/student.jsp").forward(request,response);
      }
   }
}
