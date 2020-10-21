package org.zuel.course.ch06.controller;
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String name = request.getParameter("query_name");   // 获取url参数
        List<Bookmark> bookmarkList = BookmarkDao.query(name);
        request.setAttribute("bookmarks", bookmarkList);
        request.getRequestDispatcher("./list.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }
}
