package mysqlTest.STU_Dao;

import javax.xml.crypto.Data;
import java.sql.*;
public class QuerySQL {

    static final String USER = "root";
    static final String PASS = "123456";   //用户名和密码

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
}
