package pl.edu.agh.pea.core;

import java.awt.Color;
import java.awt.BasicStroke;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class ChartDrawer extends ApplicationFrame {
	private static final long serialVersionUID = 1L;

	public ChartDrawer(String applicationTitle, String chartTitle, double[] ySet) {
		super(applicationTitle);
		JFreeChart xylineChart = ChartFactory.createXYLineChart(chartTitle, "Generation", "Best individual",
				createDataset(ySet), PlotOrientation.VERTICAL, false, true, false);

		ChartPanel chartPanel = new ChartPanel(xylineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		final XYPlot plot = xylineChart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(4.0f));
		plot.setRenderer(renderer);
		setContentPane(chartPanel);
	}

	private XYDataset createDataset(double[] ySet) {
		final XYSeries result = new XYSeries("Best Individual in Generation");
		int x = 1;
		for (double y : ySet) {
			result.add(x, y);
			x++;
		}

		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(result);
		return dataset;
	}

	public static void drawPlot(double[] ySet) {
		ChartDrawer chart = new ChartDrawer("PEA - Rastrigin's Function", "Best Individual in Generation", ySet);
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
	}
}