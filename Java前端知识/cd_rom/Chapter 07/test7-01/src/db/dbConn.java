package db;
import java.sql.*;
public class dbConn {
	String sDBDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
	String sConnStr = "jdbc:odbc:grade";
	Connection conn = null;
	ResultSet rs = null;
	public dbConn() {
		try {
			Class.forName(sDBDriver); 
		}
		catch(java.lang.ClassNotFoundException e) {
			System.err.println( e.getMessage());
		}
	}
	public ResultSet executeQuery(String sql) {
		try {
			conn = DriverManager.getConnection(sConnStr); 
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} 
		catch(SQLException ex) { 
			System.err.println(ex.getMessage());
		}
		return rs;
	}
	public int executeUpdate(String sql) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(sConnStr); 
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} 
		catch(SQLException ex) { 
			System.err.println(ex.getMessage());
		}
		return result;
	}
}
