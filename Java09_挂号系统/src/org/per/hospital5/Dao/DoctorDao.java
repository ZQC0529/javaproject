package org.per.hospital5.Dao;

import jdk.jfr.consumer.RecordedMethod;
import org.per.hospital5.model.*;
import org.per.hospital5.util.SqlUtil;

import java.math.BigDecimal;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Version：1.0.0
 * Package:org.per.hospital5.Dao
 * Author:Riel
 */


public class DoctorDao {

    //查询
    public DoctorM query(String dname){
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;   //这两个先置为空值
        DoctorM doctor = new DoctorM();
        try {
            String sql;
            sql = "SELECT id,dept_id,sex,name FROM doctor WHERE name=?";
            // 执行查询

            pstmt = conn.prepareStatement(sql);  //用这个连接来创建一个conn.prepareStatement对象。
            //这个对象比statement的优点是：能够防止sql注入，能够先建立对象再传入sql参数
            pstmt.setString(1,dname);
            ResultSet rs = pstmt.executeQuery(); //set以后这里就不用填sql这个参数了
            // 展开结果集数据库
            while (rs.next()) {

                // 通过字段检索
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int dept_id=rs.getInt("dept_id");
                String sex = rs. getString("sex");
                doctor.setDept_id(dept_id);
                doctor.setId(id);
                doctor.setName(name);
                doctor.setSex(sex);

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
            return doctor;
        }
    }

//按照部门id查询挂号记录
    public RecordM query2(int deptId){
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;   //这两个先置为空值
        RecordM record = new RecordM();
        try {
            StringBuilder content= new StringBuilder();
            content.append("SELECT id,patient_id,dept_id,reg_time,price FROM record  WHERE dept_id=").append(deptId);
            String sql;
            sql =content.toString();
            // 执行查询
            pstmt = conn.prepareStatement(sql);  //用这个连接来创建一个conn.prepareStatement对象。
            //这个对象比statement的优点是：能够防止sql注入，能够先建立对象再传入sql参数
            ResultSet rs = pstmt.executeQuery(sql);  //Query


            // 展开结果集数据库
            while (rs.next()) {

                // 通过字段检索
                int id = rs.getInt("id");
                int patient_id = rs.getInt("patient_id");
                int dept_id=rs.getInt("dept_id");
                Timestamp reg_time = rs.getTimestamp("reg_time");
                BigDecimal price = rs.getBigDecimal("price");
                record.setDept_id(dept_id);
                record.setId(id);
                record.setPatient_id(patient_id);
                record.setPrice(price);
                record.setReg_time(reg_time);
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
            return record;
        }
    }

//返回List的query2
public List<RecordM> query3(int deptId){
    Connection conn = SqlUtil.getConnection();
    PreparedStatement pstmt = null;   //这两个先置为空值
    List<RecordM> records = new LinkedList<RecordM>();
    try {
        StringBuilder content= new StringBuilder();
        content.append("SELECT record.id,patient_id,patient.name,dept_id,reg_time,price FROM record,patient WHERE record.patient_id = patient.id AND dept_id=").append(deptId);
        String sql;
        sql =content.toString();
        // 执行查询
        pstmt = conn.prepareStatement(sql);  //用这个连接来创建一个conn.prepareStatement对象。
        //这个对象比statement的优点是：能够防止sql注入，能够先建立对象再传入sql参数
        ResultSet rs = pstmt.executeQuery(sql);  //Query
        // 展开结果集数据库
        while (rs.next()) {
            RecordM record = new RecordM();
            // 通过字段检索
            int id = rs.getInt("id");
            int patient_id = rs.getInt("patient_id");
            int dept_id=rs.getInt("dept_id");
            Timestamp reg_time = rs.getTimestamp("reg_time");
            BigDecimal price = rs.getBigDecimal("price");
            String name = rs.getString("name");
            record.setDept_id(dept_id);
            record.setId(id);
            record.setPatient_id(patient_id);
            record.setPrice(price);
            record.setReg_time(reg_time);
            record.setPatient_name(name);
            records.add(record);
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
        return records;
    }
}




    //删除函数
    public void delete(DoctorM doctor) {
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql;
            sql = "DELETE FROM doctor WHERE id=?";
            // 执行删除

            int id = doctor.getId();

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
    public void update(DoctorM doctor) {
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql;
            sql = "UPDATE doctor SET id=?, name=?,sex=?,dept_id=?,password=?  WHERE id=?";//改挂的门诊
            // 执行更新
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, doctor.getId());
            pstmt.setString(2,doctor.getName());
            pstmt.setString(3,doctor.getSex());
            pstmt.setInt(4,doctor.getDept_id());
            pstmt.setString(5,doctor.getPassword());
            pstmt.setInt(6,doctor.getId());
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
    public void insert(DoctorM doctor) {
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql;
            sql = "INSERT INTO doctor(id,name,dept_id,sex,password)" + "VALUES(?,?,?,?,?)";
            // 执行插入
            pstmt = conn.prepareStatement(sql);
            //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
            // 这句话必须要放在pstmt.set前面，不然会抛出异常。要先创建再操作。
            pstmt.setInt(1, doctor.getId());
            pstmt.setString(2,doctor.getName());
            pstmt.setInt(3,doctor.getDept_id());
            pstmt.setString(4,doctor.getSex());
            pstmt.setString(5,doctor.getPassword());
            pstmt.setInt(6,doctor.getId());
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


    public int login3(String name, String password) throws SQLException{
        String sql = "select  * from doctor WHERE name=? AND password=? ;";
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
