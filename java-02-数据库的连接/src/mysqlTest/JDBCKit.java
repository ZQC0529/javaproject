//package mysqlTest;
//
//import com.mysql.jdbc.log.NullLogger;
//
//import java.sql.*;
//
//public class JDBCKit {
//    private static final String driverName="com.mysql.jdbc.Driver";
//    private static final String url="jdbc:mysql:localhost:3306/new sql";
//    private static final String user="root";
//    private static final String password="123456";
//
//    public static Connection getConnection()
//    {
//        Connection conn= null; //初始先置为空值
//        try{
//            Class.forName(driverName);
//            conn= DriverManager.getConnection(url,user,password);
//            return coon;
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
//}
