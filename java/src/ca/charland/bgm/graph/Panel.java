package ca.charland.bgm.graph;

import java.awt.Color;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;

/**
 * The Panel
 * 
 * @author mcharland
 */
public class Panel extends ApplicationFrame {

	/**
     * Used to uniquely identify the class.
     */
    private static final long serialVersionUID = 2490289293680096781L;

    /**
     * The title. 
     */
    private static final String TITLE = "Testability Chart";

    /**
     * The data set.
     */
	private XYZDataset _dataSet;
    
	/**
	 * Instantiates a new bubble chart demo1.
	 */
	public Panel() {
		super(TITLE);
	}

	/**
	 * Creates the j panel.
	 */
	void createJPanel() {
	    JPanel jpanel = createDemoPanel();
		jpanel.setPreferredSize(new Dimension(500, 270));
		setContentPane(jpanel);
    }
	
	public void setDataSet(XYZDataset dataSet) {
		_dataSet = dataSet;
	}
	
	/**
	 * Creates the demo panel.
	 * 
	 * @return the j panel
	 */
	public JPanel createDemoPanel() {		
		JFreeChart jfreechart = createChart(_dataSet);
		ChartPanel chartpanel = new ChartPanel(jfreechart);
		chartpanel.setMouseWheelEnabled(true);
		chartpanel.setDomainZoomable(true);
		chartpanel.setRangeZoomable(true);
		return chartpanel;
	}

	/**
	 * Creates the chart.
	 * 
	 * @param xyzdataset
	 *            the xyzdataset
	 * @return the j free chart
	 */
	private static JFreeChart createChart(XYZDataset xyzdataset) {
		final String x = "date";
		final String y = "test / (test + source)";
		JFreeChart jfreechart = ChartFactory.createBubbleChart("", x, y, xyzdataset,
		        PlotOrientation.VERTICAL, true, true, false);
		XYPlot xyplot = (XYPlot) jfreechart.getPlot();
		xyplot.setForegroundAlpha(0.65F);
		xyplot.setDomainPannable(true);
		xyplot.setRangePannable(true);
		XYItemRenderer xyitemrenderer = xyplot.getRenderer();
		xyitemrenderer.setSeriesPaint(0, Color.blue);
		
		NumberAxis xAxis = (NumberAxis) xyplot.getDomainAxis();
		xAxis.setLowerMargin(0.14999999999999999D);
		xAxis.setUpperMargin(0.14999999999999999D);
		xAxis.setTickUnit(new NumberTickUnit(500000000, new DecimalFormat("##%")));
		
		// Switch the domain set to the date axis.
		xyplot.setDomainAxis(new DateAxis());
		
		NumberAxis yAxis = (NumberAxis) xyplot.getRangeAxis();
		yAxis.setLowerMargin(0.14999999999999999D);
		yAxis.setUpperMargin(0.14999999999999999D);
		yAxis.setTickUnit(new NumberTickUnit(.25, NumberFormat.getPercentInstance()));
		
		return jfreechart;
	}	
}
