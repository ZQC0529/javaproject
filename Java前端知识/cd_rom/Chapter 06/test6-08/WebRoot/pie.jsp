<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.io.PrintWriter" %>
<%@ page import="com.mydraw.*"%>
<%@ page import="org.jfree.data.category.*"%>
<%@ page import="org.jfree.data.general.DefaultPieDataset"%>
<%
	DefaultPieDataset defaultpiedataset = new DefaultPieDataset(); //注意是DefaultPieDataset！！
	defaultpiedataset.setValue("One", new Double(43.200000000000003D));
	defaultpiedataset.setValue("Two", new Double(10D));
	defaultpiedataset.setValue("Three", new Double(27.5D));
	defaultpiedataset.setValue("Four", new Double(17.5D));

	request.getSession().setAttribute("dataset", defaultpiedataset);
	DefaultPieDataset dataset = (DefaultPieDataset)session.getAttribute("dataset");
	String fileName = ChartHandle.generatePieChart("统计信息", session, dataset, new PrintWriter(out));
	String graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + fileName;
%>
<HTML>
<HEAD> </HEAD>
<BODY>
<P ALIGN="CENTER">
<img src="<%=graphURL%>" width=500 height=300 border=0">
</P>
</BODY>
</HTML>
