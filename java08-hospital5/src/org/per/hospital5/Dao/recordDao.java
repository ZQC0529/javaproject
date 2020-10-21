package org.per.hospital5.Dao;

import org.per.hospital5.model.patientM;
import org.per.hospital5.model.recordM;
import org.per.hospital5.util.SqlUtil;

import java.math.BigDecimal;
import java.sql.*;

/**
 * Version：1.0.0
 * Package:org.per.hospital5.Dao
 * Author:Riel
 */

/**
 *     int id; //流水号（自动递增）
 *     int patient_id;
 *     int dept_id;
 *     Timestamp reg_time;
 *     BigDecimal price;
 */

public class recordDao {


    //查询函数
    //j
    public void query(Integer pid,Integer did){
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;   //这两个先置为空值
        try {
            StringBuilder content= new StringBuilder();
            content.append("SELECT id,patient_id,dept_id,reg_time,price FROM record WHERE 1=1");
            if(pid!=null)
            {
                content.append(" and patient_id = '" ).append(pid).append("'");//append=在尾部加上
            }
            if(did!=null)
            {
                content.append(" and dept_id='").append(did).append("'");
            }
            String sql=content.toString();
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int patient_id = rs.getInt("patient_id");
                int dept_id=rs.getInt("dept_id");
                Timestamp reg_time = rs.getTimestamp("reg_time");
                BigDecimal price = rs.getBigDecimal("price");
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
    public void delete(recordM record) {
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql;
            sql = "DELETE FROM record WHERE id=?";
            // 执行删除
            int id = record.getId();
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
    public void update(recordM record) {
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql;
            sql = "UPDATE record SET id=?, patient_id=?,dept_id=?,reg_time=?,price=?  WHERE id=?";
            // 执行更新
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, record.getId());
            pstmt.setInt(2,record.getPatient_id());
            pstmt.setInt(3,record.getDept_id());
            pstmt.setTimestamp(4,record.getReg_time());
            pstmt.setBigDecimal(5,record.getPrice());
            pstmt.setInt(6,record.getId());
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
        System.out.println("UPDATE DONE!");
    }

    //插入函数
    public void insert(recordM record) {
        Connection conn = SqlUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql;
            sql = "INSERT INTO record(id,patient_id,dept_id,reg_time,price)" + "VALUES(?,?,?,?,?)";
            // 执行插入
            pstmt = conn.prepareStatement(sql);
            //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
            // 这句话必须要放在pstmt.set前面，不然会抛出异常。要先创建再操作。
            pstmt.setInt(1, record.getId());
            pstmt.setInt(2,record.getPatient_id());
            pstmt.setInt(3,record.getDept_id());
            pstmt.setTimestamp(4,record.getReg_time());
            pstmt.setBigDecimal(5,record.getPrice());
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
