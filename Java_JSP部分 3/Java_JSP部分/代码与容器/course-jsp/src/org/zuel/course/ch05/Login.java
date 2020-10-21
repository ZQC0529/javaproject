package org.zuel.course.ch05;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {
        String user = request.getParameter("user");
        String passwd = request.getParameter("passwd");
        if("123456".equals(user) && "123456".equals(passwd)) {
            request.getSession().setAttribute("login", user);
            response.sendRedirect("../home05.jsp");
            Integer count = (Integer) getServletContext().getAttribute("count");
            getServletContext().setAttribute("count", ++count);
        }
        else {
            response.sendRedirect("../login05.html");
        }
    }
}
