package mysqlTest.STU_Dao;

import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import java.sql.*;
import java.util.*;


public class InsertSQL {
    static final String USER = "root";
    static final String PASS = "123456";   //用户名和密码

    public void insert() {
        Connection conn = JDBCKit.getConnection();
        PreparedStatement pstmt = null;
        try {
            System.out.println("连接数据库...");
            String sql;
            sql = "INSERT INTO stu_test(id,namechar)" + "VALUES(?,?)";
            // 执行插入
            System.out.println(" 实例化PreparedStatement对象...");

            //定义输入---------------------------------------------------------
            Scanner INT = new Scanner(System.in);
            System.out.println("Would you like to input new id?  ID:  ");
            int valueInt = INT.nextInt();

            Scanner STRING = new Scanner(System.in);
            System.out.println("would you like to input new name? NAME:  ");
            String valueString = STRING.nextLine();
            //-----------------------------------------------------------------

            pstmt = conn.prepareStatement(sql);
            //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
            // 这句话必须要放在pstmt.set前面，不然会抛出异常。要先创建再操作。
            pstmt.setInt(1,valueInt);
            pstmt.setString(2, valueString);
            INT.close();
            STRING.close();
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
        System.out.println("INSERT DONE!");
    }
}

