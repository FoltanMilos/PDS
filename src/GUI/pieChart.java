/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;


/**
 *
 * @author folko
 */
public class pieChart implements ExampleChart<PieChart> {

    public pieChart() {
        ExampleChart<PieChart> exampleChart = new pieChart();
        PieChart chart = this.getChart();
        new SwingWrapper<PieChart>(chart).displayChart();
    }

 
  public PieChart getChart() {
 
    // Create Chart
    PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();
 
    // Customize Chart
    Color[] sliceColors = new Color[] { new Color(224, 68, 14), new Color(230, 105, 62), new Color(236, 143, 110), new Color(243, 180, 159), new Color(246, 199, 182) };
    chart.getStyler().setSeriesColors(sliceColors);
 
    // Series
    chart.addSeries("Gold", 24);
    chart.addSeries("Silver", 21);
    chart.addSeries("Platinum", 39);
    chart.addSeries("Copper", 17);
    chart.addSeries("Zinc", 40);
 
    return chart;
  }
}
