package org.per.hospital5.Dao;

import org.per.hospital5.model.DepartmentM;
import org.per.hospital5.util.*;

import java.sql.*;

/**
 * Version：1.0.0
 * Package:org.per.hospital5.Dao
 * Author:Riel
 */

public class DepartmentDao {

    //查询函数
    public void query(){
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql;
            sql = "SELECT id,name,type,remark FROM department";
            // 执行查询

            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery(sql);  //Query
            // 展开结果集数据库
            while (rs.next()) {

                // 通过字段检索
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int type=rs.getInt("type"); //0-门诊  1-住院
                String remark = rs.getString("remark");
                System.out.print("部门id: " + id+'\n');
                System.out.print("部门名: " + name+'\n');
                System.out.println("门诊类型:" + type+'\n');
                System.out.println("部门信息:"+ remark + '\n');
                System.out.print("\n");
            }
             //完成后关闭 一定要记得关闭，不占用系统资源
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
    public void delete(DepartmentM department) {
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql;
            sql = "DELETE FROM department WHERE id=?";
            // 执行删除
            int id = department.getId();

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
    public void update(DepartmentM department) {
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql;
            sql = "UPDATE department SET id=?, name=? ,type=?,remark=? WHERE id=?";
            int id = department.getId();
            String name = department.getName();
            int type = department.getType();
            String remark = department.getRemark();

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2,name);
            pstmt.setInt(3,type);
            pstmt.setString(4,remark);

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
    public void insert(DepartmentM department) {
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql;
            sql = "INSERT INTO department(id,name,type,remark)" + "VALUES(?,?,?,?)";
            // 执行插入
            pstmt = conn.prepareStatement(sql);
            int id = department.getId();
            String name = department.getName();
            int type = department.getType();
            String remark = department.getRemark();

            pstmt.setInt(1, id);
            pstmt.setString(2,name);
            pstmt.setInt(3,type);
            pstmt.setString(4,remark);
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
