package org.per.hospital5.servlet;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.per.hospital5.Dao.PatientDao;
import org.per.hospital5.model.PatientM;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Version：1.0.0
 * Package:org.per.hospital5.servlet
 * Author:Riel
 */

public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取页面信息
        String name = request.getParameter("p_name");
        String id = request.getParameter("p_id");
        String age = request.getParameter("p_age");
        String sex = request.getParameter("p_sex");
        String password = request.getParameter("p_password");
        int sql_id = Integer.valueOf(id);
        int sql_age = Integer.valueOf(age);

        try {
            //建立model
            PatientDao pa = new PatientDao();
            PatientM patient = new PatientM(sql_id, name, sex, sql_age, password);//int id, String name, String sex, int age, String password
            pa.insert(patient);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}


