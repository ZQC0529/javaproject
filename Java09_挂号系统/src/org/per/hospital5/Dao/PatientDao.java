package org.per.hospital5.Dao;

import org.per.hospital5.model.PatientM;
import org.per.hospital5.util.SqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Version：1.0.0
 * Package:org.per.hospital5.Dao
 * Author:Riel
 */


public class PatientDao {
    int logSign;

    //查询函数
    public PatientM query(String pname){
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;   //这两个先置为空值
        PatientM patient = new PatientM();
        try {
//            StringBuffer text = new StringBuffer();
//            text.append("SELECT id,name,sex,age FROM patient WHERE id=");
//            text.append(did);
//            String sql=text.toString();
            String sql;
            sql = "SELECT id,name,sex,age FROM patient WHERE name=?";
            // 执行查询
            pstmt = conn.prepareStatement(sql);  //用这个连接来创建一个conn.prepareStatement对象。
            pstmt.setString(1,pname);
            //这个对象比statement的优点是：能够防止sql注入，能够先建立对象再传入sql参数
            ResultSet rs = pstmt.executeQuery();  //Query

            // 展开结果集数据库
            while (rs.next()) {

                // 通过字段检索
                int pid = rs.getInt("id");
                String name = rs.getString("name");
                int age=rs.getInt("age");
                String sex = rs. getString("sex");
                patient.setAge(age);
                patient.setName(name);
                patient.setId(pid);
                patient.setSex(sex);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException se2) {
            }// 什么都不做 。如果列名写错了也会编译，不过到这里就会结束，弹出错误提示
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            return patient;
        }
    }


    public PatientM queryById(int pid){
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;   //这两个先置为空值
        PatientM patient = new PatientM();
        try {
            String sql;
            sql = "SELECT id,name,sex,age FROM patient WHERE id=?";
            // 执行查询
            pstmt = conn.prepareStatement(sql);  //用这个连接来创建一个conn.prepareStatement对象。
            pstmt.setInt(1,pid);
            //这个对象比statement的优点是：能够防止sql注入，能够先建立对象再传入sql参数
            ResultSet rs = pstmt.executeQuery();  //Query

            // 展开结果集数据库
            while (rs.next()) {

                // 通过字段检索
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age=rs.getInt("age");
                String sex = rs. getString("sex");
                patient.setAge(age);
                patient.setName(name);
                patient.setId(pid);
                patient.setSex(sex);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException se2) {
            }// 什么都不做 。如果列名写错了也会编译，不过到这里就会结束，弹出错误提示
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            return patient;
        }
    }
    //删除函数
    public void delete(PatientM patient) {
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql;
            sql = "DELETE FROM patient WHERE id=?";
            // 执行删除
            int id = patient.getId();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException se2) {
            }// 什么都不做 。如果列名写错了也会编译，不过到这里就会结束，弹出错误提示
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    //更新函数
    public void update(PatientM patient) {
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql;
            sql = "UPDATE patient SET id=?, name=?,sex=?,age=?,password=?  WHERE id=?";
            // 执行更新
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, patient.getId());
            pstmt.setString(2, patient.getName());
            pstmt.setString(3, patient.getSex());
            pstmt.setInt(4, patient.getAge());
            pstmt.setString(5, patient.getPassword());
            pstmt.setInt(6, patient.getId());
            pstmt.executeUpdate();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException se2) {
            }// 什么都不做 。如果列名写错了也会编译，不过到这里就会结束，弹出错误提示
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


    //插入函数
    public void insert(PatientM patient) {
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql;
            sql = "INSERT INTO patient(id,name,age,sex,password)" + "VALUES(?,?,?,?,?)";
            // 执行插入
            pstmt = conn.prepareStatement(sql);
            //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
            // 这句话必须要放在pstmt.set前面，不然会抛出异常。要先创建再操作。
            pstmt.setInt(1, patient.getId());
            pstmt.setString(2, patient.getName());
            pstmt.setInt(3, patient.getAge());
            pstmt.setString(4, patient.getSex());
            pstmt.setString(5, patient.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException se2) {
            }// 什么都不做 。如果列名写错了也会编译，不过到这里就会结束，弹出错误提示
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

//
//    //
//    private static List<patientM> fillPatient(String sql) throws SQLException, ClassNotFoundException {
//        List<patientM> patients = new LinkedList();
//        Connection conn = SqlUtil.getConnection();
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        ResultSet rs = pstmt.executeQuery();
//        while (rs.next()) {
//            patientM patient = new patientM(rs.getInt("id"), rs.getString("name"),
//                    rs.getString("sex"),
//                    rs.getInt("age"), null);
//            if (sql.contains("password")) {
//                patient.setPassword(rs.getString("password"));
//            }
//            patients.add(patient);
//        }
//        SqlUtil.release(rs, pstmt, conn);
//        return patients;
//    }
//
////    /**
////     * 登陆
////     */
////    public responseM login(String code, String password) {
////        if(code == null || password == null || "".equals(code) || "".equals(password)) {
////            return Util.badArg();
////        }
////        StringBuffer sql = new StringBuffer();
////        sql.append("select id, code, name, password, remark, add_time, update_time from user");
////        sql.append(" where code = '").append(code).append("';");
////        try {
////            List<patientM> patients = fillPatient(sql.toString());
////            if(patients == null || patients.size() == 0) {
////                return Util.fail("学号不存在.");
////            }
////            if(!user.getPassword().equals(password)) {
////                return Util.fail("密码错误.");
////            }
////            return Util.ok();
////        } catch (Exception e) {
////            return RespUtil.fail(e.getClass());
////        }
////    }
//
//
//    public int login1(String name, String password) throws SQLException, ClassNotFoundException {
//        Connection conn = SqlUtil.getConnection();
//        StringBuffer sql = new StringBuffer();
//        sql.append("select  * from patient WHERE name=? AND password=? ;");
//        sql.append(" where name = '").append(name).append("';");
//        String real_sql = sql.toString();
//        List<patientM> patients = fillPatient(real_sql);
//        if (patients == null || patients.size() == 0) {
//            return 0;
//        }
//        patientM patient = patients.get(0);
//        if (patient.getPassword().equals(password)) {
//            return 1;
//        }
//
////        String key="";
////            PreparedStatement pstmt = conn.prepareStatement(real_sql);
////            ResultSet rs = pstmt.executeQuery();
////            key = rs.getString("password");
////        if(rs.getString("password").equals(password)){
////            return 1;
////        }
////        else return 0;
//        else return 0;
//
    //  }


    public int login2(String name, String password) throws SQLException{
        String sql = "select  * from patient WHERE name=? AND password=? ;";
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setString(2,password);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return 1;
        } else return 0;
    }
}
