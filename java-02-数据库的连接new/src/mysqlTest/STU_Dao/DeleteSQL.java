package mysqlTest.STU_Dao;

import java.sql.*;
import java.util.*;

public class DeleteSQL {
    static final String USER = "root";
    static final String PASS = "123456";   //用户名和密码

    public void delete() {
        Connection conn = JDBCKit.getConnection();
        PreparedStatement pstmt = null;
        try {
            System.out.println("连接数据库...");
            String sql;
            sql = "DELETE FROM stu_test WHERE id=?";
            System.out.println("实例化PreparedStatement对象...");
            // 执行删除

            System.out.println("Which id you want to delete?  ID：   ");
            Scanner INT = new Scanner(System.in);
            int id = INT.nextInt();

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            INT.close();
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
        System.out.println("DELETE DONE!");
    }
}