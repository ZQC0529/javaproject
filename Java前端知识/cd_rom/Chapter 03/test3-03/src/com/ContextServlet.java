package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ContextServlet() {
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

		request.setCharacterEncoding("GB2312");
		response.setContentType("text/html; charset=gb2312");
		PrintWriter out=response.getWriter();
		ServletContext context=getServletConfig().getServletContext();
		//获得工程相关信息
		out.println("获得了工程的相对路径："+context.getRealPath("/") + "<br>");
		out.println("获取了Tomcat的信息："+context.getServerInfo()+"<br>");
		out.println("获取了JNDI："+context.getResource("/")+"<br>");
		out.println("获取了源程序的相对路径：" + context.getResourcePaths("/") + "<br>");
		//getInitParameter方法
		String date = context.getInitParameter("date");
		String myclass = context.getInitParameter("class");
		out.print("date is -- " + date +"<br>");
		out.print("age is -- " + myclass +"<br>");
		//集合方法
		java.util.Enumeration e=context.getInitParameterNames();
		while(e.hasMoreElements())
		{
			String pName=(String)e.nextElement();
			String pValue=context.getInitParameter(pName);
			out.print("<br><b>"+pName+"</b>&nbsp;");
			out.print("------ " + pValue);
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
