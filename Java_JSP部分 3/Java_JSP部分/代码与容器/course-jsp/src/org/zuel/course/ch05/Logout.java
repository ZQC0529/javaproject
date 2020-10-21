package org.zuel.course.ch05;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Logout extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.getSession().invalidate();
        request.getSession().setAttribute("login", null);
        response.setContentType("text/html;charset=UTF-8");
        Integer count = (Integer) getServletContext().getAttribute("count");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Logout</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>第" + count + "次登录已注销。</h1>");
        out.println("<a href='../login05.html'>返回登录</a><br>");
        out.println("<a href='/'>返回导航页</a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        processRequest(request, response);
    }
}
