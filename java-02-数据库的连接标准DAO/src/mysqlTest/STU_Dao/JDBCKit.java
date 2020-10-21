package mysqlTest.STU_Dao;

import com.mysql.jdbc.log.NullLogger;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCKit {

//    private static final String driverName="com.mysql.jdbc.Driver";
//    private static final String url="jdbc:mysql://localhost:3306/new sql";
//    private static final String user="root";
//    private static final String password="123456";
    private static  String driverName;
    private static  String url;
    private static  String user;
    private static  String password;

    /**
     * 注意：配置文件中不需要添加双引号，因为本身它就是一个字符串，如果添加引号会把引号包含在字符串里面
     */
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        driverName=bundle.getString("driverName");
        url=bundle.getString("url");
        user=bundle.getString("user");
        password=bundle.getString("password");
    }

    public static Connection getConnection()
    {
        Connection conn= null; //初始先置为空值
        try{
            Class.forName(driverName);    //最好通过这种形式来传值
            conn = DriverManager.getConnection(url,user,password); //连接到数据库
        }
        catch (Exception e) {
            e.printStackTrace();
        }
      return conn;
    }
}