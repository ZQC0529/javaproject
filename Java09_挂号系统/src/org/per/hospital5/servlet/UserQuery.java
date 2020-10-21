package org.per.hospital5.servlet;
import org.per.hospital5.Dao.RecordDao;
import org.per.hospital5.model.RecordM;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Version：1.0.0
 * Package:org.per.hospital5.servlet
 * Author:Riel
 */
public class UserQuery extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  id = request.getParameter("query-id");
        int query_id = Integer.valueOf(id);
        try {
            RecordDao re = new RecordDao();
            RecordM record = re.query(query_id,null);
            HttpSession session = request.getSession();
            session.setAttribute("record",record);
            response.sendRedirect(request.getContextPath()+"/query_List.jsp");
        //    response.sendRedirect(request.getContextPath()+"/main.jsp?userName="+userName);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}