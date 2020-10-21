package org.per.hospital5.util;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Version：1.0.0
 * Package:org.per.hospital5.util
 * Author:Riel
 */

/**
 * 工具类，用于获取Connection
 */
public class SqlUtil {
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



    /**
     * 释放资源
     */
    public static void release(PreparedStatement pstmt, Connection conn) {
        release(null, pstmt, conn);
    }
    public static void release(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        try {
            if(rs != null) {
                rs.close();
            }
            if(pstmt != null) {
                pstmt.close();
            }
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
