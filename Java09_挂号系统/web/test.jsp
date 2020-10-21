<%--
  Created by IntelliJ IDEA.
  User: cc
  Date: 2019/12/21
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户登录</title>
    <style type="text/css">
        *{margin: 0;padding: 0;}
        form{margin: 0 auto;padding:15px; width: 300px;height:300px;text-align: center;}
        #submit{padding: 10px}
        #submit input{width: 50px;height: 24px;}
    </style>
</head>
<body background="image/login_bg.jpeg" style="background-repeat: no-repeat;background-size: cover">

<div class="wrapper">
    <form   style=" background-image: url(image/loginform_bg.png) ;width: 30em;margin: auto;margin-top: 300px" action="<%=request.getContextPath()%>/login" method="post">
        <img style="width: 220px ; height: 52px" src ="image/login_title.png" /><br/></label>

        <label><FONT color="#9400d3" size="5px"><B>用户名:</B></FONT></label>
        <input  type="text" name="userName" style="height: 30px;marker-top: 130px" value="${param.userName}"/><br><br>
        <label><FONT color="#9400d3" size="5px"><B>密码 ：</B></FONT></label>
        <input type="password"  style="height: 30px;marker-top: 130px" name="password"/><br>
        <font color="red">
            <%
                if(request.getAttribute("message")!= null){

                    out.print(request.getAttribute("message"));
                }
            %>
        </font>


            <tr>
                <td width="10%" class="tableleft"><center><FONT color="#9400d3"><B>请选择您的身份：<select name="role" >
                    <option value="1">病人</option>
                    <option value="2">医生</option>
                </select></B></FONT></center>

                </td>
                <td>
                    <div id="submit">
                        <input type="submit" style="width: 120px;height: 50px;font-size: 25px;font-weight: bold;color: darkblue" value="登录"/>
                    </div>
                </td>
            </tr>


    </form>
</div>
</body>
</html>