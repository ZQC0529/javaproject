<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.io.PrintWriter" %>
<%@ page import="com.mydraw.*"%>
<%@ page import="org.jfree.data.category.DefaultCategoryDataset"%>
<%
	String series1 = "First";
    String series2 = "Second";
    String series3 = "Third";
    String type1 = "Type 1";
    String type2 = "Type 2";
    String type3 = "Type 3";
    String type4 = "Type 4";
    String type5 = "Type 5";
    String type6 = "Type 6";
    String type7 = "Type 7";
    String type8 = "Type 8";
    DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
    defaultcategorydataset.addValue(1.0D, series1, type1);
    defaultcategorydataset.addValue(4D, series1, type2);
    defaultcategorydataset.addValue(3D, series1, type3);
    defaultcategorydataset.addValue(5D, series1, type4);
    defaultcategorydataset.addValue(5D, series1, type5);
    defaultcategorydataset.addValue(7D, series1, type6);
    defaultcategorydataset.addValue(7D, series1, type7);
    defaultcategorydataset.addValue(8D, series1, type8);
   
    defaultcategorydataset.addValue(5D, series2, type1);
    defaultcategorydataset.addValue(7D, series2, type2);
    defaultcategorydataset.addValue(6D, series2, type3);
    defaultcategorydataset.addValue(8D, series2, type4);
    defaultcategorydataset.addValue(4D, series2, type5);
    defaultcategorydataset.addValue(4D, series2, type6);
    defaultcategorydataset.addValue(2D, series2, type7);
    defaultcategorydataset.addValue(1.0D, series2, type8);
   
    defaultcategorydataset.addValue(4D, series3, type1);
    defaultcategorydataset.addValue(3D, series3, type2);
    defaultcategorydataset.addValue(2D, series3, type3);
    defaultcategorydataset.addValue(3D, series3, type4);
    defaultcategorydataset.addValue(6D, series3, type5);
    defaultcategorydataset.addValue(3D, series3, type6);
    defaultcategorydataset.addValue(4D, series3, type7);
    defaultcategorydataset.addValue(3D, series3, type8);

	request.getSession().setAttribute("dataset", defaultcategorydataset);
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