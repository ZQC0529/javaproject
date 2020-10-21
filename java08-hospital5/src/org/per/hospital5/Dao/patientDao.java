package org.per.hospital5.Dao;

import org.per.hospital5.model.doctorM;
import org.per.hospital5.model.patientM;
import org.per.hospital5.util.SqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Version：1.0.0
 * Package:org.per.hospital5.Dao
 * Author:Riel
 */


public class patientDao {

    //查询函数
    public void query(){
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;   //这两个先置为空值
        try {
            String sql;
            sql = "SELECT id,name,sex,age FROM patient";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age=rs.getInt("age");
                String sex = rs. getString("sex");

                System.out.println("病人编号：" +id );
                System.out.print("病人名字: " + name+"\n");
                System.out.println("病人性别：" + sex );
                System.out.println("病人年龄："+ age +"\n");
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
        }
    }

    //删除函数
    public void delete(patientM patient) {
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
    public void update(patientM patient) {
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql;
            sql = "UPDATE patient SET id=?, name=?,sex=?,age=?,password=?  WHERE id=?";
            // 执行更新
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, patient.getId());
            pstmt.setString(2,patient.getName());
            pstmt.setString(3,patient.getSex());
            pstmt.setInt(4,patient.getAge());
            pstmt.setString(5,patient.getPassword());
            pstmt.setInt(6,patient.getId());
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
    public void insert(patientM patient) {
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
            pstmt.setString(2,patient.getName());
            pstmt.setInt(3,patient.getAge());
            pstmt.setString(4,patient.getSex());
            pstmt.setString(5,patient.getPassword());
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
}
