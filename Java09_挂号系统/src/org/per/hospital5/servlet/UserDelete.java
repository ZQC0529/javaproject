package org.per.hospital5.servlet;

import org.per.hospital5.Dao.RecordDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Version：1.0.0
 * Package:org.per.hospital5.servlet
 * Author:Riel
 */
public class UserDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  id = request.getParameter("delete-id");
        int delete_id = Integer.valueOf(id);
        try {
            RecordDao re = new RecordDao();
            re.deleteById(delete_id);
            request.getRequestDispatcher("/successful.jsp").forward(request, response);
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
