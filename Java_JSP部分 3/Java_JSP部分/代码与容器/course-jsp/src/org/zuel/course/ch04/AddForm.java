package org.zuel.course.ch04;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddForm extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("    <head>");
        out.println("        <title>添加书签</title>");
        out.println("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        out.println("    </head>");
        out.println("    <body>");
        out.println("<form method=\"post\" action=\"../04/add\">");
        out.println("名称：<input name=\"name\"><br>");
        out.println("名称：<input name=\"author\"><br>");
        out.println("分类：");
        out.println("<select name=\"category\">");
        String category = getInitParameter("category");
        String[] categories = category.split(",");
        for(String token : categories) {
            out.println("<option value=\"" + token + "\">" + token + "</option>");
        }
        out.println("            </select><br>");
        out.println("            <input value=\"提交\" type=\"submit\"><br>");
        out.println("        </form>");
        out.println("    </body>");
        out.println("</html>");
        out.close();
    }
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
