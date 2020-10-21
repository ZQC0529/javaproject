package org.zuel.course.ch03;

import org.zuel.course.dao.BookmarkDao;
import org.zuel.course.model.Bookmark;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookmarkAdd extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String category = request.getParameter("category");
        // 判断书签信息是否全部填写
        String error = null;
        if (name == null || "".equals(name)
                || author == null || "".equals(author)
                || category == null || "".equals(category)) {
            error = "书签信息不完整。";
        }
        // 添加成功或失败跳转到不同页面
        if (error != null) {
            request.setAttribute("error", error);
            request.getRequestDispatcher("../03/addFail")
                    .forward(request, response);
        } else {
            Bookmark bookmark = new Bookmark(13, name.trim(),
                    author.trim(), category.trim());
            BookmarkDao.insert(bookmark);
            request.setAttribute("bookmark", bookmark);
            request.getRequestDispatcher("../03/addSuccess")
                    .forward(request, response);
        }
    }
}
