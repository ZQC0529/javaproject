package org.zuel.course.ch03;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddFail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<html>");
        out.println("<head>");
        out.println("  <meta content=\"text/html; charset=UTF-8\" http-equiv=\"content-type\">");
        out.println("  <title>添加书签失败</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>添加书签失败: </h1>");
        out.println("<ul style=\"color: rgb(255, 0, 0);\">");
        String error = (String) request.getAttribute("error");
        out.println("  <li>" + error + "</li>");
        out.println("</ul>");
        out.println("<a href=\"../add03.html\">返回添加书签</a>");
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
