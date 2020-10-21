package org.per.hospital5.Dao;

import org.per.hospital5.model.*;
import org.per.hospital5.util.SqlUtil;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

import org.per.hospital5.util.*;
/**
 * Version：1.0.0
 * Package:org.per.hospital5.Dao
 * Author:Riel
 */


public class doctorDao {

    //查询
    public void query(){
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;   //这两个先置为空值
        try {
            String sql;
            sql = "SELECT id,dept_id,sex,name FROM doctor";
            // 执行查询

            pstmt = conn.prepareStatement(sql);  //用这个连接来创建一个conn.prepareStatement对象。
            //这个对象比statement的优点是：能够防止sql注入，能够先建立对象再传入sql参数

            ResultSet rs = pstmt.executeQuery(sql);  //Query
            // 展开结果集数据库
            while (rs.next()) {

                // 通过字段检索
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int dept_id=rs.getInt("dept_id");
                String sex = rs. getString("sex");

                System.out.println("医生编号：" +id );
                System.out.print("医生名字: " + name+"\n");
                System.out.println("性别：" + sex );
                System.out.println("所属部门id："+ dept_id +"\n");
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

//按照部门id查询挂号记录
    public void query2(int deptId){
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;   //这两个先置为空值
        try {
            StringBuilder content= new StringBuilder();
            content.append("SELECT id,patient_id,dept_id,reg_time,price FROM record WHERE dept_id=").append(deptId);
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
                System.out.println(deptId+"号部门的挂号记录如下：\n");
                System.out.println("流水号： " + id );
                System.out.println("病人编号：" +patient_id );
                System.out.print("部门编号: " + dept_id+"\n");
                System.out.println("挂号时间：" + reg_time );
                System.out.println("总花费："+ price +"\n");
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
    public void delete(doctorM doctor) {
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
    public void update(doctorM doctor) {
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
    public void insert(doctorM doctor) {
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


}
