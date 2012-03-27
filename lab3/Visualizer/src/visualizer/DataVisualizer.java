/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package visualizer;

import java.awt.Dimension;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author piotrkowalski
 */
public class DataVisualizer {

    public DataVisualizer() {
    }
    
    public void showDemoData() {
            showChart(createDataSeries());
    }

    public XYSeries createDataSeries() {
        // Seria danych
        XYSeries series = new XYSeries("Average Size");
        series.add(1, 1);
        series.add(2, 2);
        series.add(3, 4);
        series.add(4, 5);
        series.add(5, -3);
        series.add(6, -2);
        return series;
    }
    
    public void showChart(XYSeries series) {
        // Zbior danych
        XYDataset xyDataset = new XYSeriesCollection(series);

        // Wykres
        JFreeChart chart = ChartFactory.createXYLineChart("XY Chart",
                "Sample [none]",
                "Value [none]",
                xyDataset,
                PlotOrientation.VERTICAL,
                false,
                false,
                false);

        // Swing - GUI
        JFrame frame = new JFrame("JFreeChart chart!");
        ChartPanel chartPanel = new ChartPanel(chart);
        frame.getContentPane().add(chartPanel);
        frame.setSize(new Dimension(600, 400));
        frame.setLocation(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
