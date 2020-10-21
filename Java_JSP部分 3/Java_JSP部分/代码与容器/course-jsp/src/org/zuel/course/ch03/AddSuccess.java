package org.zuel.course.ch03;

import org.zuel.course.model.Bookmark;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddSuccess extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Bookmark bookmark = (Bookmark) request.getAttribute("bookmark");
        out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<html>");
        out.println("<head>");
        out.println("  <meta content=\"text/html; charset=UTF-8\" http-equiv=\"content-type\">");
        out.println("  <title>添加书签成功</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>添加书签成功</h1>");
        out.println("<ul>");
        out.println("  <li>名称：" + bookmark.getName() + "</li>");
        out.println("  <li>作者：" + bookmark.getAuthor() + "</li>");
        out.println("  <li>分类：" + bookmark.getCategory() + "</li>");
        out.println("</ul>");
        out.println("<a href=\"../03/list\">返回书签列表</a>");
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
