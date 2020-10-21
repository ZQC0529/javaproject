package mysqlTest.STU_Dao;

import java.sql.*;
import java.util.Scanner;

/**
 * Version：1.0.0
 * Package:mysqlTest.STU_Dao
 * Author:Riel
 */
public class StudentDao {
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

    public void query(){
//   这不能加static 关键字 ，不然query（）就不属于任何一个方法了
        Connection conn = JDBCKit.getConnection();  //调用JDBCKit中的方法来创建一个连接
        PreparedStatement pstmt = null;   //这两个先置为空值
        try {
            System.out.println("连接数据库...");
            String sql;
            sql = "SELECT id, namechar,add_time FROM stu_test";
            // 执行查询

            System.out.println(" 实例化PreparedStatement对象...");
            pstmt = conn.prepareStatement(sql);  //用这个连接来创建一个conn.prepareStatement对象。
            //这个对象比statement的优点是：能够防止sql注入，能够先建立对象再传入sql参数

            ResultSet rs = pstmt.executeQuery(sql);  //Query ,
            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int id = rs.getInt("id");
                String name = rs.getString("namechar");
                Timestamp time = rs.getTimestamp("add_time");


                // 输出数据
                System.out.print("学号: " + id);
                System.out.print(", 名字: " + name);
                System.out.println(time);
                System.out.print("\n");
            }
            // 完成后关闭 一定要记得关闭，不占用系统资源
//            rs.close();
//            pstmt.close();
//            conn.close();
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
        System.out.println("QUERY DONE!");//遍历结束了。
    }

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

