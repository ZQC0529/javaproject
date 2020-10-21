<%--
  Created by IntelliJ IDEA.
  User: cc
  Date: 2020/10/15
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.sql.*" %>

<html>
  <head>
    <title>学生信息一览</title>
  </head>
  <body>
  <table>
    <tr>



  <%
  Class.forName("com.mysql.jdbc.Driver");
  String url = "jdbc:mysql://localhost:3306/hospital";
  Connection conn = DriverManager.getConnection(url,"root","123456");
  String sql = "SELECT * FROM doctor";
  Statement stmt = conn.createStatement(); //创建一个句柄，用于执行SQL语句。
  ResultSet rs = stmt.executeQuery(sql); //re是一个游标，指向返回的结果集中的顶部
  while(rs.next()){
    String d_psw = rs.getString("password");
    String d_name = rs.getString("name");
    String d_sex = rs.getString("sex");


%>
      <td><%=d_name%></td>
<%}
  rs.close();%>


    </tr>
  </table>


  </body>
</html>
