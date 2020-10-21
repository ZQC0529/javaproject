package org.zuel.course.ch03;

import org.zuel.course.dao.BookmarkDao;
import org.zuel.course.model.Bookmark;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BookmarkList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta content=\"text/html; UTF-8\" http-equiv=\"content-type\">");
        out.println("<title>书签列表</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table style=\"text-align: left; width: 100%;\" border=\"0\" >");
        out.println("  <tbody>");
        out.println("    <tr>");
        out.println("      <td style=\"background-color: rgb(51, 255, 255);\">名称</td>");
        out.println("      <td style=\"background-color: rgb(51, 255, 255);\">作者</td>");
        out.println("      <td style=\"background-color: rgb(51, 255, 255);\">分类</td>");
        out.println("    </tr>");
        String name = request.getParameter("name");   // 获取url参数
        List<Bookmark> bookmarkList = BookmarkDao.query(name);
        for(Bookmark bookmark : bookmarkList) {
            out.println("    <tr>");
            out.println("      <td>" +
                    bookmark.getName() + "</td>");
            out.println("      <td>" +
                    bookmark.getAuthor() + "</td>");
            out.println("      <td>" +
                    bookmark.getCategory() + "</td>");
            out.println("    </tr>");
        }
        out.println("  </tbody>");
        out.println("</table><br>");
        out.println("<a href='/'>返回导航页</a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

}
