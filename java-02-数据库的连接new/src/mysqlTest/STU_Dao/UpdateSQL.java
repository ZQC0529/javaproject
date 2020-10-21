package mysqlTest.STU_Dao;

import java.sql.*;
import java.util.*;

public class UpdateSQL {
    static final String USER = "root";
    static final String PASS = "123456";   //用户名和密码

    public void update() {
        Connection conn = JDBCKit.getConnection();
        PreparedStatement pstmt = null;
        try {
            System.out.println("连接数据库...");
            String sql;
            sql = "UPDATE stu_test SET id=?,namechar=? WHERE id=?";
            // 执行更新
            System.out.println("实例化PreparedStatement对象...");

            //输入-----------------------------------------------------------
            System.out.println("Would you like to input new ID?  ID:   ");
            Scanner INT1 = new Scanner(System.in);
            int valueInt1 = INT1.nextInt();

            System.out.println("Would you like to input new NAME?   NAME:   ");
            Scanner STRING = new Scanner(System.in);
            String valueString = STRING.nextLine();

            System.out.println("Which ID you want to update?   ID:    ");
            Scanner INT2 = new Scanner(System.in);
            int valueInt2 = INT2.nextInt();
            //输入-----------------------------------------------------------

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, valueInt1);
            pstmt.setInt(3,valueInt2);
            pstmt.setString(2,valueString);
            INT1.close();
            INT2.close();
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
        System.out.println("UPDATE DONE!");
    }
}
