package com.mydraw;

import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;

public class testdraw {
	private DefaultPieDataset getDataSet()
	{
		DefaultPieDataset dataset =  new DefaultPieDataset();
		dataset.setValue("商品一", 100);
		dataset.setValue("商品二", 200);
		dataset.setValue("商品三", 300);
		return dataset;
	}
	public JFreeChart getChat()
	{
		DefaultPieDataset data = this.getDataSet();
		JFreeChart chart = ChartFactory.createPieChart3D("商品", data, true, false, false);
		return chart;
	}
}
