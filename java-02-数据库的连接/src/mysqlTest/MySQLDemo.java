package mysqlTest;

import java.sql.*;

public class MySQLDemo {

    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";// 这是个固定的驱动值，是用绝对路径来使用的，所以不用import com.mysql.*
    static final String DB_URL = "jdbc:mysql://localhost:3306/new sql";

    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";   这个是用绝对地址来使用Driver类
    //static final String DB_URL = "jdbc:mysql://localhost:3306/newsql";   //最后这个是数据库名，不是表名


    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;   //这两个先置为空值
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);// 最好通过这种形式来传值，不要直接写class.forName

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, namechar FROM stu_test";
            ResultSet rs = stmt.executeQuery(sql);
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("namechar");
                //String url = rs.getString("url");

                // 输出数据
                System.out.print("学号: " + id);
                System.out.print(", 名字: " + name);
                System.out.print("\n");
            }
            // 完成后关闭 一定要记得关闭，不占用系统资源
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做 。如果列名写错了也会编译，不过到这里就会结束，弹出错误提示
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");//遍历结束了。
    }

}