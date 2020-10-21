<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.io.PrintWriter" %>
<%@ page import="com.mydraw.*"%>
<%@ page import="org.jfree.data.category.DefaultCategoryDataset"%>
<%
DefaultCategoryDataset data = new DefaultCategoryDataset();
data.addValue(1, "访问量","2" );
data.addValue(2, "访问量","3" );
data.addValue(3, "访问量","4" );
data.addValue(4, "访问量","5" );
request.getSession().setAttribute("dataset", data);
DefaultCategoryDataset dataset = (DefaultCategoryDataset)session.getAttribute("dataset");
String fileName = ChartHandle.generateBarChart("统计信息", session, dataset, new PrintWriter(out));
String graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + fileName;
%>
<HTML>
<HEAD></HEAD>
<BODY>
<P ALIGN="CENTER">
<img src="<%=graphURL%>" width=500 height=300 border=0>
</P>
</BODY>
</HTML>