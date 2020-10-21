<%@ page language="java" errorPage="/4-03.jsp"
contentType="text/html;charset=GBK"%>
<% 
	int dividend = 0;
	int divisor = 0;
	int result = 0;
	try {
		result = dividend / divisor;
	}
	catch(ArithmeticException zz) {
		throw new ArithmeticException( "除数不能为零！" );
	}
%>   
