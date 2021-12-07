package application;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import javafx.scene.Scene;

public class ShanghaiApplication extends Application {
    
    private static Map<String, Map<Integer, Integer>> values;

    public static void main(String[] args) {
        values = new HashMap();
        launch(ShanghaiApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        values = new HashMap();
        NumberAxis xAxis = new NumberAxis(2007, 2017, 10);
        NumberAxis yAxis = new NumberAxis();
        
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");
        
        LineChart<Integer, Integer> chart = new LineChart(xAxis, yAxis);
        chart.setTitle("University of Helsinki, Shanghai ranking");
        
        String[] raw = new String("2007 73\n" +
"2008 68\n" +
"2009 72\n" +
"2010 72\n" +
"2011 74\n" +
"2012 73\n" +
"2013 76\n" +
"2014 73\n" +
"2015 67\n" +
"2016 56\n" +
"2017 56").split("\n");
        
        List<String> strValues= new ArrayList<>(Arrays.asList(raw));
        Map<Integer, Integer> m = new HashMap();
       
        strValues.stream().map(string -> string.split(" "))
                .forEach(arr -> {
                    m.put(Integer.valueOf(arr[0]),Integer.valueOf(arr[1]));
                        });
        values.put("Rank", m);
        setValuesToLineChart(chart);
        
        Scene scene = new Scene(chart, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
    
    public void add(String seriesName, int year, int rank) {
        this.values.put(seriesName, new HashMap(year, rank));
    }
    
    public  void setValuesToLineChart(LineChart chart) {
        values.keySet().stream().forEach(party -> {
            
            XYChart.Series data = new XYChart.Series<>();
            data.setName(party);
            
            values.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });
            chart.getData().add(data);
        });
    }

}
