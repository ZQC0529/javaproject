package com.mydraw;

import java.awt.Insets;
import java.awt.Font;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.urls.*;
import org.jfree.chart.servlet.*;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.title.TextTitle;
import org.jfree.ui.RectangleInsets;
import org.jfree.data.general.Dataset;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.xy.XYDataset;
import java.awt.Color;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.axis.DateAxis;
import java.text.SimpleDateFormat;

public class ChartHandle {
    /**
     * 根据传入的参数，生成饼图，并保存到文件中，返回文件名
     * @param title String 图形标题
     * @param session HttpSession
     * @param data CategoryDataset 数据集
     * @param pw PrintWriter 输出流
     * @return String 返回图形的文件名
     */
    public static String generatePieChart(String title, HttpSession session,
                                          DefaultPieDataset data,
                                          PrintWriter pw) {
        String filename = null;
        try {
            PiePlot plot = new PiePlot(data);
            //创建Plot图表区域对象,这里是饼图
            JFreeChart chart = new JFreeChart(title, //图形标题
                                              JFreeChart.DEFAULT_TITLE_FONT, //标题字体
                                              plot, //图标标题对象
                                              true //是否显示图例
                                              );
            //使用plot对象创建JFreeChart
            chart.setBackgroundPaint(java.awt.Color.white);
            //设置图形的背景色
            ChartRenderingInfo info = new ChartRenderingInfo(new
                StandardEntityCollection());
            filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info,
                session);
            //把生成的图片放到临时目录
            //500是图片长度，300是图片高度
            pw.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return filename;
    }

    /**
     * 根据传入的参数，生成柱状图，并保存到文件中，返回文件名
     * @param title String 图形标题
     * @param session HttpSession
     * @param data CategoryDataset 数据集
     * @param pw PrintWriter 输出流
     * @return String 返回图形的文件名
     */
    public static String generateBarChart(String title, HttpSession session,
                                          CategoryDataset data,
                                          PrintWriter pw) {
        String filename = null;
        try {
            JFreeChart chart = ChartFactory.createBarChart3D(
                title, //  图表标题
                "时间", //  目录轴的显示标签
                "访问量", //  数值轴的显示标签
                data, //  数据集
                PlotOrientation.VERTICAL, //  图表方向：水平、垂直
                true, //  是否显示图例(对于简单的柱状图必须是false)
                false, //  是否生成工具
                false //  是否生成URL链接
                );
            //使用ChartFactory创建柱状JFreeChart
            ChartRenderingInfo info = new ChartRenderingInfo(new
                StandardEntityCollection());
            filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info,
                session);
            //把生成的图片放到临时目录
            //500是图片长度，300是图片高度
            pw.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return filename;
    }

    /**
     * 根据传入的参数，生成折线图，并保存到文件中，返回文件名
     * @param title String 图形标题
     * @param session HttpSession
     * @param data XYDataset 数据集
     * @param pw PrintWriter 输出流
     * @return String 返回图形的文件名
     */
    public static String generateZigzagChart(
        String title,
        HttpSession session,
        XYDataset data,
        PrintWriter pw) {
        String filename = null;
        //保存图形的文件名
        try {
            JFreeChart chart = ChartFactory.createTimeSeriesChart(
                title, //图形的标题
                "日期", //X轴说明
                "访问量", //Y轴说明
                data, //数据
                true, //是否创建图例
                true, //是否生成tooltips
                false //是否生成URL链接
                );
            //使用ChartFactory来创建时间序列的图表对象
            chart.setBackgroundPaint(Color.white);
            //设置图表的背景色
            XYPlot xyplot = (XYPlot) chart.getPlot();
            //获得图表区域对象
            xyplot.setBackgroundPaint(Color.white);
            //设置背景色
            xyplot.setDomainGridlinePaint(Color.lightGray);
            //设置横坐标网格线的颜色
            xyplot.setRangeGridlinePaint(Color.lightGray);
            //设置纵坐标网格线的颜色
            xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
            //设置文字与坐标轴之间的偏移量
            xyplot.setDomainCrosshairVisible(true);
            //设置横坐标交叉线是否显示
            xyplot.setRangeCrosshairVisible(true);
            //设置纵坐标交叉线是否显示
            org.jfree.chart.renderer.xy.XYItemRenderer xyitemrenderer = xyplot.
                getRenderer();
            //获得数据点（X，Y）的render，负责描绘数据点
            if (xyitemrenderer instanceof XYLineAndShapeRenderer) {
                XYLineAndShapeRenderer xylineandshaperenderer = (
                    XYLineAndShapeRenderer) xyitemrenderer;
                xylineandshaperenderer.setShapesVisible(true);
                //数据点可见
                xylineandshaperenderer.setShapesFilled(true);
                //数据点是实心点
                xylineandshaperenderer.setSeriesFillPaint(0, Color.red);
                //数据点填充为红色
                xylineandshaperenderer.setUseFillPaint(true);
                //将设置好的属性应用到render上
            }
            DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
            //对domain 轴上日期显示格式定义
            dateaxis.setDateFormatOverride(new SimpleDateFormat("yy-MM-dd"));
            //设置日期格式
            ChartRenderingInfo info = new ChartRenderingInfo(new
                StandardEntityCollection());
            filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info,
                session);
            //把生成的图片放到临时目录, 500是图片长度，300是图片高度，并返回临时文件名
            pw.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return filename;
    }

    private static JFreeChart createChart(XYDataset xydataset) {
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "日流量统计",
            "日期",
            "访问量",
            xydataset,
            true,
            true,
            false);
        chart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot) chart.getPlot(); //获得 plot : XYPlot!!
        xyplot.setBackgroundPaint(Color.white);
        xyplot.setDomainGridlinePaint(Color.lightGray);
        xyplot.setRangeGridlinePaint(Color.lightGray);
        xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        xyplot.setDomainCrosshairVisible(true);
        xyplot.setRangeCrosshairVisible(true);
        org.jfree.chart.renderer.xy.XYItemRenderer xyitemrenderer = xyplot.
            getRenderer();
        if (xyitemrenderer instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer xylineandshaperenderer = (
                XYLineAndShapeRenderer) xyitemrenderer;
            xylineandshaperenderer.setShapesVisible(true); //数据点可见
            xylineandshaperenderer.setShapesFilled(true); //数据点是实心点
            xylineandshaperenderer.setSeriesFillPaint(0, Color.red); //数据点填充为红色
            xylineandshaperenderer.setUseFillPaint(true); //应用
        }
        DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis(); //对domain 轴上日期显示格式定义
        dateaxis.setDateFormatOverride(new SimpleDateFormat("yy-MM-dd"));
        return chart;
    }

}
