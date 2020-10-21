<%--
  Created by IntelliJ IDEA.
  User: cc
  Date: 2020/1/3
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找病人</title>
</head>
<body>
<form style=" background-image: url(image/loginform_bg.png);background-repeat: no-repeat ; background-size: cover ;width: 30em;margin: auto;margin-top: 300px" action="./query" method="post">

    <FONT color="#9400d3" size="5px"><B>    请输入您要查找的病人的ID  :  </B></FONT> <input style="height: 30px;vertical-align:middle;marker-top: 130px" type="text" name="query-id"><br/>
    <input style="width: 120px;height: 50px;font-size: 25px;font-weight: bold;color: darkblue;position: center" type="submit" value="确认查找" >
</form>


</body>
</html>