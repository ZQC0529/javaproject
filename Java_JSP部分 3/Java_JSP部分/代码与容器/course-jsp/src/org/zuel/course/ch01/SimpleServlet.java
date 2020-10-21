package org.zuel.course.ch01;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class SimpleServlet extends HttpServlet {

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
        out.println("<title>Simple Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + new Date() + "</h1><br>");
        out.println("<a href='/'>返回导航页</a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
