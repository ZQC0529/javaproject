package org.zuel.course.ch06.controller;

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
                          HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String author = request.getParameter("author");
            String category = request.getParameter("category");
            Bookmark bookmark = new Bookmark(Integer.valueOf(id), name.trim(),
                    author.trim(), category.trim());
            BookmarkDao.insert(bookmark);
            request.getRequestDispatcher("./list").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("./500.jsp").forward(request, response);
        }
    }
}
