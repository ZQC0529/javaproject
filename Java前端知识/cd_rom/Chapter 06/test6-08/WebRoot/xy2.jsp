<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.io.PrintWriter" %>
<%@ page import="com.mydraw.*"%>

<%@ page import="org.jfree.data.xy.*"%>
<%@ page import="org.jfree.data.time.TimeSeriesCollection"%>
<%@ page import="org.jfree.data.time.TimeSeries"%>
<%@ page import="org.jfree.data.time.*"%>
<%
	TimeSeries timeseries = new TimeSeries("L&G European Index Trust",
	Month.class);
	timeseries.add(new Month(2, 2001), 181.8D);//这里用的是Month.class，同样还有Day.class Year.class 等等
	timeseries.add(new Month(3, 2001), 167.3D);
	timeseries.add(new Month(4, 2001), 153.8D);
	timeseries.add(new Month(5, 2001), 167.6D);
	timeseries.add(new Month(6, 2001), 158.8D);
	timeseries.add(new Month(7, 2001), 148.3D);
	timeseries.add(new Month(8, 2001), 153.9D);
	timeseries.add(new Month(9, 2001), 142.7D);
	timeseries.add(new Month(10, 2001), 123.2D);
	timeseries.add(new Month(11, 2001), 131.8D);
	timeseries.add(new Month(12, 2001), 139.6D);
	timeseries.add(new Month(1, 2002), 142.9D);
	timeseries.add(new Month(2, 2002), 138.7D);
	timeseries.add(new Month(3, 2002), 137.3D);
	timeseries.add(new Month(4, 2002), 143.9D);
	timeseries.add(new Month(5, 2002), 139.8D);
	timeseries.add(new Month(6, 2002), 137D);
	timeseries.add(new Month(7, 2002), 132.8D);

	TimeSeries timeseries1 = new TimeSeries("L&G UK Index Trust",
			Month.class);
	timeseries1.add(new Month(2, 2001), 129.6D);
	timeseries1.add(new Month(3, 2001), 123.2D);
	timeseries1.add(new Month(4, 2001), 117.2D);
	timeseries1.add(new Month(5, 2001), 124.1D);
	timeseries1.add(new Month(6, 2001), 122.6D);
	timeseries1.add(new Month(7, 2001), 119.2D);
	timeseries1.add(new Month(8, 2001), 116.5D);
	timeseries1.add(new Month(9, 2001), 112.7D);
	timeseries1.add(new Month(10, 2001), 101.5D);
	timeseries1.add(new Month(11, 2001), 106.1D);
	timeseries1.add(new Month(12, 2001), 110.3D);
	timeseries1.add(new Month(1, 2002), 111.7D);
	timeseries1.add(new Month(2, 2002), 111D);
	timeseries1.add(new Month(3, 2002), 109.6D);
	timeseries1.add(new Month(4, 2002), 113.2D);
	timeseries1.add(new Month(5, 2002), 111.6D);
	timeseries1.add(new Month(6, 2002), 108.8D);
	timeseries1.add(new Month(7, 2002), 101.6D);
	TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
	timeseriescollection.addSeries(timeseries);
	timeseriescollection.addSeries(timeseries1);
	timeseriescollection.setDomainIsPointsInTime(true); //domain轴上的刻度点代表的是时间点而不是时间段

	request.getSession().setAttribute("dataset", timeseriescollection);
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
