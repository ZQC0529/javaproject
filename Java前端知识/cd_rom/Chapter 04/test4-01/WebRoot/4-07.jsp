<%@ page contentType="text/html;charset=GBK" %>
<%! int number=0;     
   synchronized void countPeople() { 
	   number++;
     }
%>
<%
countPeople();  
%>
您是第<%out.print(number);%>个访问本站的客户。
