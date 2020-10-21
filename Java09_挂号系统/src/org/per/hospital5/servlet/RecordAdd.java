package org.per.hospital5.servlet;

import org.per.hospital5.Dao.PatientDao;
import org.per.hospital5.Dao.RecordDao;
import org.per.hospital5.model.PatientM;
import org.per.hospital5.model.RecordM;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Version：1.0.0
 * Package:org.per.hospital5.servlet
 * Author:Riel
 */
public class RecordAdd extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  pid=request.getParameter("p_id");
        int patient_id = Integer.valueOf(pid);
        String pname=request.getParameter("p_name");
        String dept_id=request.getParameter("p_did");
        int did = Integer.valueOf(dept_id);
        String pkey = request.getParameter("passwordConfirm");
        PatientDao pa = new PatientDao();
        HttpSession session = request.getSession();
        try {
            if(pa.login2(pname,pkey)==1) {
                PatientM patient= pa.query(pname);
                session.setAttribute("userName", patient.getName());
                session.setAttribute("patient",patient);
                ////////////////////////////////////////插入///////////////////////////////////
                RecordM record = new RecordM();
                record.setDept_id(did);
                record.setId(patient_id);//??自动填充
                record.setPatient_id(patient_id);
                Date javaDate = new Date();
                Timestamp timestamp = new Timestamp(javaDate.getTime());
                record.setReg_time(timestamp);
                //取出小时
                SimpleDateFormat sdf = new SimpleDateFormat("HH");
                String curHour = sdf.format(javaDate);

                if (curHour.compareTo("18")<0){
                    //前面比后面小会输出-1
                    BigDecimal price = new BigDecimal("50.05");
                    record.setPrice(price);
                    RecordDao re = new RecordDao();
                    re.insert(record);
                }
                else {
                    BigDecimal price = new BigDecimal("100.05");
                    record.setPrice(price);
                    RecordDao re = new RecordDao();
                    re.insert(record);
                }


                ////////////////////////////////////////插入///////////////////////////////////
//                request.getRequestDispatcher("/successful.jsp").forward(request, response);
                response.sendRedirect(request.getContextPath()+"/successful.jsp");
//                request.getRequestDispatcher("/successful.jsp").forward(request, response);
            }
            else{
                request.setAttribute("message", "账号密码输入错误");
                request.getRequestDispatcher("/successful.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
