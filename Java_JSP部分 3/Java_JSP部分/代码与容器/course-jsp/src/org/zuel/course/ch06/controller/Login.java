package org.zuel.course.ch06.controller;

import org.zuel.course.ch06.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException, ServletException {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (("admin".equals(username) && "admin".equals(password))
                    || ("guest".equals(username) && "guest".equals(password))) {
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                request.getSession().setAttribute("login", username);
                request.setAttribute("user", user);
                request.setAttribute("username", username);
                request.getRequestDispatcher("./home.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "用户名或密码错误，请重新填写");
                request.getRequestDispatcher("./login.jsp").forward(request, response);
            }
    }
}
