package I18N;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Hello2 extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws IOException,ServletException
	{
		response.setContentType("text/html;charset=UTF-16");
		response.setHeader("Content-Language","es"); 
		PrintWriter out=response.getWriter();
		out.println("<html><head><title> En Espa\u00f1ol</title></head>"); 
		out.println("<body>"); 
		out.println("<h3>En espa\u00f1ol:</h3>"); 
		out.println("\u00a1Hola Mundo!"); 
		out.println("</body></html>"); 	
	}
}
