package org.zuel.course.ch02;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {
        // 设置内容类型
        response.setContentType("text/html;charset=UTF-8");
        // 获取响应输出
        PrintWriter out = response.getWriter();
        // 输出内容
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello Zuel!</h1><br>");
        out.println("<a href='/'>返回导航页</a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
