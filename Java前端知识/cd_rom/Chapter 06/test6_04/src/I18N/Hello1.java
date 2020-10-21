package I18N;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Hello1 extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws IOException,ServletException
	{
		response.setContentType("text/html;charset=iso-8859-1");
		
		response.setHeader("Content-Language","es"); 
		
		PrintWriter out=response.getWriter();
		out.println("<html><head><title> En Espa&ntilde;ol</title></head>");
		out.println("<body>"); 
		out.println("<h3>En espa&ntilde;ol:</h3>"); 
		out.println("&iexcl;Hola Mundo!"); 
		out.println("</body></html>"); 
	}
}
