<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.io.PrintWriter" %>
<%@ page import="com.mydraw.*"%>

<%@ page import="org.jfree.data.xy.*"%>
<%@ page import="org.jfree.data.time.TimeSeriesCollection"%>
<%@ page import="org.jfree.data.time.TimeSeries"%>
<%@ page import="org.jfree.data.time.Day"%>
<%
	XYSeries xyseries = new XYSeries("First"); //先产生XYSeries 对象
	xyseries.add(1.0D, 1.0D);
	xyseries.add(2D, 4D);
	xyseries.add(3D, 3D);
	xyseries.add(4D, 5D);
	xyseries.add(5D, 5D);
	xyseries.add(6D, 7D);
	xyseries.add(7D, 7D);
	xyseries.add(8D, 8D);
	
	XYSeries xyseries1 = new XYSeries("Second");
	xyseries1.add(1.0D, 5D);
	xyseries1.add(2D, 7D);
	xyseries1.add(3D, 6D);
	xyseries1.add(4D, 8D);
	xyseries1.add(5D, 4D);
	xyseries1.add(6D, 4D);
	xyseries1.add(7D, 2D);
	xyseries1.add(8D, 1.0D);
	
	XYSeries xyseries2 = new XYSeries("Third");
	xyseries2.add(3D, 4D);
	xyseries2.add(4D, 3D);
	xyseries2.add(5D, 2D);
	xyseries2.add(6D, 3D);
	xyseries2.add(7D, 6D);
	xyseries2.add(8D, 3D);
	xyseries2.add(9D, 4D);
	xyseries2.add(10D, 3D);
	
	XYSeriesCollection xyseriescollection = new XYSeriesCollection(); //再用XYSeriesCollection添加入XYSeries 对象
	xyseriescollection.addSeries(xyseries);
	xyseriescollection.addSeries(xyseries1);
	xyseriescollection.addSeries(xyseries2);

	request.getSession().setAttribute("dataset", xyseriescollection);

	XYDataset dataset = (XYDataset) session.getAttribute("dataset");
	//从session中取出数据集
	String fileName = ChartHandle.generateZigzagChart("统计信息", session,
			dataset, new PrintWriter(out));
	//利用数据集生成图形文件，并返回文件名
	String graphURL = request.getContextPath()
			+ "/servlet/DisplayChart?filename=" + fileName;
%>
<HTML>
<HEAD></HEAD>
<BODY>
<P ALIGN="CENTER">
<img src="<%=graphURL%>" width=500 height=300 border=0">
</P>
</BODY>
</HTML>
