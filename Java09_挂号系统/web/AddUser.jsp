

<%--
  Created by IntelliJ IDEA.
  User: cc
  Date: 2019/12/21
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册</title>
</head>
<body background="image/loginarea_bg.png" style="background-repeat: no-repeat;background-size: cover">

<div class="ui-menu-item-wrapper">
<CENTER>
<form action="${pageContext.request.contextPath }/add" method="post" style="background-image: url(image/loginform_bg.png);background-repeat: no-repeat;background-size: cover">

    <FONT color="#9400d3" size="5px"><B>    请输入您的ID: </B></FONT><input style="height: 30px;vertical-align:middle;marker-top: 130px" type="text" name="p_id"><br/>
        <FONT color="#9400d3" size="5px"><B>   请输入您的姓名</B></FONT><input style="height: 30px;vertical-align:middle;marker-top: 130px" type="text" name="p_name"><br/>
            <FONT color="#9400d3" size="5px"><B>   请输入您的年龄:</B></FONT> <input style="height: 30px;vertical-align:middle;marker-top: 130px" type="text" name="p_age" ><br/>
                <FONT color="#9400d3" size="5px"><B>    请输入您的性别: </B></FONT><input style="height: 30px;vertical-align:middle;marker-top: 130px" type="text" name="p_sex" ><br/>
                    <FONT color="#9400d3" size="5px"><B>   请输入您的密码: </B></FONT><input style="height: 30px;vertical-align:middle;marker-top: 130px" type="password" name="p_password" ><br/>
                        <FONT color="#9400d3" size="5px"><B>   请确认您的密码：</B></FONT><input style="height: 30px;vertical-align:middle;marker-top: 130px" type="password" name="passwordConfirm"  onkeyup="test()"><br/>
    <input type="submit" value="提交" >
</form>
</CENTER>
</div>
</body>

<script>
    function test(){
        var password = document.getElementById("p_password");
        var passwordConfirm = document.getElementById("p_passwordConfirm");
        if(password.value != passwordConfirm.value)
            alert("对不起，您2次输入的密码不一致");
        else
            document.forms[0].submit();
    }
</script>
</html>