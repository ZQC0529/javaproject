package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestInfo extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RequestInfo() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		String s;
		//getMethod
		s="<br><b>request.getMethod():</b>"+ request.getMethod();
		out.print(s);
		//getRequestURI
		s="<br><b>request.getRequestURI():</b>"+ request.getRequestURI();
		out.print(s);
		//getProtocol
		s="<br><b>request.getProtocol():</b>"+ request.getProtocol();
		out.print(s);
		//getParameter
		s="<br><b>request.getParameter(\"a\"):</b>"+  request.getParameter("a");
		out.print(s);
		s="<br><b>request.getParameter(\"b\"):</b>"+ request.getParameter("b");
		out.print(s);
		//getQueryString
		s="<br><b>request.getQueryString():</b>"+ request.getQueryString();
		out.print(s);
		//getHeaders
		java.util.Enumeration e=request.getHeaderNames();
		while(e.hasMoreElements())
		{
			String headerName=(String)e.nextElement();
			String headerValue=request.getHeader(headerName);
			   out.print("<br><b>"+headerName+"</b>&nbsp;&nbsp;&nbsp;&nbsp;");
			out.print("------ " + headerValue);
		}	

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
