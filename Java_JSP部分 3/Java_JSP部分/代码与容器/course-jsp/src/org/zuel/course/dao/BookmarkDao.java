package org.zuel.course.dao;

import org.zuel.course.model.Bookmark;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BookmarkDao {

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://10.174.146.131:3306/example", "root", "Hh19950928");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 释放资源
     * @param pstmt
     * @param conn
     */
    public static void release(PreparedStatement pstmt, Connection conn) {
        release(null, pstmt, conn);
    }

    /**
     * 释放资源
     * @param rs
     * @param pstmt
     * @param conn
     */
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

    /**
     * insert操作
     * @param bookmark
     */
    public static void insert(Bookmark bookmark) {
        try {
            String sql = "insert into bookmark(id, name, author, category) values(?, ?, ?, ?);";
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bookmark.getId());
            pstmt.setString(2, bookmark.getName());
            pstmt.setString(3, bookmark.getAuthor());
            pstmt.setString(4, bookmark.getCategory());
            pstmt.executeUpdate();
            release(pstmt, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * delete操作
     * 仅示例删除所有记录
     */
    public static void detele() {
        try {
            String sql = "delete from bookmark;";
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            release(pstmt, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * update操作
     * 根据id更新其他字段，如果id为空，则更新全部记录
     * @param bookmark
     */
    public static void update(Bookmark bookmark) {
        try {
            // 参数为空，直接返回
            if(bookmark == null) {
                return;
            }
            StringBuffer sql = new StringBuffer();
            sql.append("update bookmark set name = ?, author = ?, category = ?");
            if(bookmark.getId() != null) {
                sql.append(" where id = '").append(bookmark.getId()).append("'");
            }
            sql.append(";");

            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, bookmark.getName());
            pstmt.setString(2, bookmark.getAuthor());
            pstmt.setString(3, bookmark.getCategory());
            pstmt.executeUpdate();
            release(pstmt, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * select操作
     * 仅示例查询所有记录
     * @return
     */
    public static List<Bookmark> select() {
        ResultSet rs = null;
        List<Bookmark> bookmarks = new LinkedList();
        String sql = "select * from bookmark;";
        fillBookmark(bookmarks, sql);
        return bookmarks;
    }

    /**
     * 根据name参数进行查询
     * @param name
     * @return
     */
    public static List<Bookmark> query(String name) {
        List<Bookmark> bookmarks = new LinkedList();
        StringBuffer sql = new StringBuffer();
        sql.append("select * from bookmark");
        if(name != null && !"".equals(name)) {
            sql.append(" where name like '%").append(name).append("%'");
        }
        sql.append(";");
        fillBookmark(bookmarks, sql.toString());
        return bookmarks;
    }

    /**
     * 将查询结果填充至列表
     * @param bookmarks
     * @param sql
     */
    private static void fillBookmark(List<Bookmark> bookmarks, String sql) {
        try {
        ResultSet rs = null;
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        while(rs.next()) {
            Bookmark bookmark = new Bookmark(rs.getInt("id"), rs.getString("name"),
                    rs.getString("author"), rs.getString("category"));
            bookmarks.add(bookmark);
        }
            release(rs, pstmt, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据id进行删除
     * @param id
     */
    public static void deleteById(Integer id) {
        try {
            String sql = "delete from bookmark where id ='" + id + "';";
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            release(pstmt, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            String sql = "delete from bookmark where id = 4;";
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            release(pstmt, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
