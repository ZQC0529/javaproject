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
    <title>挂号</title>
</head>
<body background="image/gb.jpeg.jpg" style="background-repeat: no-repeat;background-size: cover">

<div style="width: 253px; height: 28px; height :30px; line-height:30px; margin-left: 500px">

<form style=" background-image: url(image/loginform_bg.png);background-repeat: no-repeat ; background-size: cover ;width: 30em;margin: auto;margin-top: 300px" action="${pageContext.request.contextPath }/addr" method="post">


<%--    ${pageContext.request.contextPath }/main--%>
<FONT color="#9400d3" size="5px"><B>    请输入您的ID  :  </B></FONT> <input style="height: 30px;vertical-align:middle;marker-top: 130px" type="text" name="p_id"><br/>
<FONT color="#9400d3" size="5px"><B>    请输入您的姓名:</B></FONT><input style="height: 30px;vertical-align:middle;marker-top: 130px" type="text" name="p_name"><br/>
<%--<FONT color="#9400d3" size="5px"><B>    请输入科室编号: </B></FONT>--%>
<%--    <input style="height: 30px;marker-top: 130px" type="text" name="p_did" ><br/>--%>
<FONT color="#9400d3" size="5px"><B>请输入科室编号:</B></FONT>
        <td width="10%" class="tableleft">
            <select style="height: 35px;width :150px;marker-top: 130px" name="p_did" >
        <option value="1">1-眼科</option>
        <option value="2">2-精神科</option>
        <option value="3">3-脑科</option>
        <option value="4">4-儿科</option>
        <option value="5">5-妇产科</option>
        <option value="6">6-耳科</option>
        <option value="7">7-鼻科</option>
        <option value="8">8-牙科</option>

            </select>
    </td>
<br/>
<FONT color="#9400d3" size="5px"><B>    请输入您的密码: </B></FONT><input style="height: 30px;marker-top: 130px" type="password" name="p_password" ><br/>
<FONT color="#9400d3" size="5px"><B>    请确认您的密码：</B></FONT><input style="height: 30px;marker-top: 130px" type="password" name="passwordConfirm"  onkeyup="test()"><br/>
    <input style="width: 120px;height: 50px;font-size: 25px;font-weight: bold;color: darkblue" type="submit" value="提交" >
</form>
</div>
<div>
<FONT SIZE="5" color="#teal">
   <FONT color="teal"><B>科室列表</B></FONT><br/>
1-眼科<br/>
    2-精神科<br/>
    3-脑科<br/>
4-儿科<br/>
5-妇产科<br/>
6-耳科<br/>
7-鼻科<br/>
8-牙科<br/>


</FONT>

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