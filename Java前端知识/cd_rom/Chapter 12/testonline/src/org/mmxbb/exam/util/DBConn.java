package org.mmxbb.exam.util;



import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConn {
  DataSource ds = null;
  Connection conn = null;

  public DBConn() {
  }

  /**
   * <li>get the connection from lookup DataSource
   * @return Connection
   */
  public Connection getConnection() {
    try {
    	Context initCtx = new InitialContext();
    	 Context envCtx = (Context)initCtx.lookup("java:comp/env");
         ds = (DataSource)envCtx.lookup("jdbc/exam");
         conn=ds.getConnection();
      	
    
    } catch (Exception e) {
      System.err.println("getConnection error: " + e);
      return null;
    }
    return conn;
  }

    
  /**
   * return connection to pool
   */
  public void close() {
    try {
      conn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
