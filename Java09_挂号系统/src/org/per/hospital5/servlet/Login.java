package org.per.hospital5.servlet;

import org.per.hospital5.Dao.*;
import org.per.hospital5.model.DoctorM;
import org.per.hospital5.model.PatientM;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Version：1.0.0
 * Package:org.per.hospital5.servlet
 * Author:Riel
 */


public class Login extends HttpServlet {


    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  userName = request.getParameter("userName");
        String password = request.getParameter("password");
    if("1".equals(request.getParameter("role"))){
        HttpSession session = request.getSession();
        PatientDao pa = new PatientDao();
        try {
            if(pa.login2(userName,password)==1) {
                PatientM patient= pa.query(userName);
                session.setAttribute("userName", patient.getName());
                session.setAttribute("patient",patient);
                response.sendRedirect(request.getContextPath()+"/main.jsp?userName="+userName);
            }
            else{
                request.setAttribute("message", "账号密码输入错误");
                request.getRequestDispatcher("/test.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("result",pa.query(userName));
        session.setAttribute("patient_session", pa.query(userName));
    }


    //医生
        if("2".equals(request.getParameter("role"))){
            HttpSession session = request.getSession();
            DoctorDao doc = new DoctorDao();
            try {
                if(doc.login3(userName,password)==1) {
                    DoctorM doctor = new DoctorM();
                    session.setAttribute("userName", doctor.getName());
                    session.setAttribute("doctor",doctor);
                    response.sendRedirect(request.getContextPath()+"/mainDoc.jsp?userName="+userName);
                }
                else{
                    request.setAttribute("message", "账号密码输入错误");
                    request.getRequestDispatcher("/test.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            PatientDao padao= new PatientDao();
            session.setAttribute("pat_session",padao.queryById(doc.query2(doc.query(userName).getDept_id()).getPatient_id()));
            session.setAttribute("doc_session", doc.query3(doc.query(userName).getDept_id()));
        }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }


}