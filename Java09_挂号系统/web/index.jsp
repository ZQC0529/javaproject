<%--
  Created by IntelliJ IDEA.
  User: cc
  Date: 2019/12/21
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>金手指医院</title>
</head>
<body background="image/gb.jpeg.jpg" style="background-repeat: no-repeat;background-size: cover" >
<table style="text-align: left; width: 100%;" border="0">
  <TR><P><B><CENTER><FONT size="9" color="#ffd700">欢迎来到金手指医院☝</FONT></CENTER></B></P></TR>
  <TR>
    <TD class=style2 height=239>
      <P>1.👉使用网上预约挂号功能必须是<B>我院的诊疗卡用户</B>。</P>
      <P>2.👉如果您的诊疗卡没有开通网上服务功能，请携带诊疗卡及身份有效证件到医院门诊四楼门诊办公室开通网上服务功能。</P>
      <P>3.👉诊疗卡办理和开通网上预约时间为每天上午8：00-12：00，下午14：30-17：00（周末和节假日除外）。</P>
      <P>5.👉<B><FONT color=red>网上预约不收取任何手续费用</FONT></B>，请到医院门诊挂号处确认并就诊。</P>
      <P>6.👉请您根据病情进行预约，建议普通常见疾病预约专科号，疑难疾病预约专家号。</P>
      <P>7.👉预约成功后，<B><FONT
              color=#ff0000>请务必记住网上预约成功后的预约流水号或把它打印出来，以便就诊时核对。</FONT></B></P>
      <P>8.👉请在预约就诊当天凭诊疗卡和预约流水号到医院门诊大厅1号预约挂号窗口挂号，然后到专家门诊处就诊。请您务必至少<B><FONT
              color=#ff0000>提前30分钟挂号，逾期作废</FONT></B>。</P>
      <P>9.👉由于门诊诊疗时间的不确定性，您的就诊次序可能会延迟或提前，护士将根据具体情况合理安排您就诊。</P>
      <P>10.👉若医生因特殊原因临时停诊,挂号台工作人员将给您安排其他医生就诊,不便之处,敬请原谅!</P>
      <P>                                 </P>
      <P><B><CENTER><FONT size="5" color="#483d8b">请您点击登陆按钮进行登陆</FONT></CENTER></B></P></TD></TR>
  <TR>
    <TD height=29 align=middle ><INPUT style="width: 120px;height: 50px;font-size: 25px;font-weight: bold;color: darkblue" class=Btn onclick="window.self.location='./test.jsp'" value="💉登录"  type=button name=Submit >
    </TD></TR>
  <TR>
    <TD > <P><B><CENTER><FONT size="5" color="blue">新用户请注册</FONT></CENTER></B></P></TD></TR>
  </TD>
  <TD height=29 align=middle ><INPUT style="width: 120px;height: 50px;font-size: 25px;font-weight: bold;color: darkblue" class=Btn onclick="window.self.location='./AddUser.jsp'" value="💉注册"  type=button name=Submit >
  </TR>
</TABLE>



<%--<div>--%>
<%--  <form method="get" action="./test.jsp">--%>
<%--    <input type="submit" value="登陆">--%>
<%--  </form>--%>
<%--</div>--%>


<%--<tbody>--%>
<%--  <tr>--%>
<%--    <td style="background-color: rgb(51, 255, 255);">编号</td>--%>
<%--    <td style="background-color: rgb(51, 255, 255);">信息</td>--%>
<%--    <td style="background-color: rgb(51, 255, 255);">数据</td>--%>
<%--  </tr>--%>
<%--  <tr>--%>
<%--    <td>${requestScope.result.code}</td>--%>
<%--    <td>${requestScope.result.data}</td>--%>
<%--    <td>${requestScope.result.msg}</td>--%>
<%--  </tr>--%>
<%--  </tbody>--%>
<%--</table>--%>
<%--<%=request.getRealPath("/")%>--%>
</body>
</html>
