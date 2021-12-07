package application;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;
import java.util.Scanner;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;

public class PartiesApplication extends Application {

    Map<String, HashMap<Integer, Double>> values;
    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }
    
    @Override
    public void init() {
        this.values = new HashMap();
    }

    @Override
    public void start(Stage stage) throws Exception {
        init();
        
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis();
        
        LineChart<Integer, Double> lineChart = new LineChart(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");
        
        readFile("partiesdata.tsv");
        
        putValuesOnLineChart(lineChart);
        
        Scene scene = new Scene(lineChart);
        stage.setScene(scene);
        stage.setTitle(" ");
        stage.show();
    }
    
    public void readFile(String path) {
        try(Scanner scan = new Scanner(Paths.get(path))){ 
            int lineNumber = 0;
            int[] years = new int[0];
            
            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] rawData = line.split("\t");
                
                if(lineNumber == 0) {
                    years = new int[rawData.length-1];
                    for(int i = 1, j = 0; i < rawData.length; i++) {
                        years[j] = Integer.valueOf(rawData[i]);
                        j++;
                    }
                } else {
                    String partie = rawData[0];
                    HashMap<Integer, Double> pairs = new HashMap();

                    for(int i  = 1, j = 0; i < rawData.length; i++) {
                        if(rawData[i].equals("-")) {
                            j++;
                            continue;
                        }
                        
                        pairs.put(years[j], Double.valueOf(rawData[i]));
                        System.out.println(years.length);
                        
                        values.put(partie, pairs);
                        j++;
                    }
                }
                lineNumber++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void putValuesOnLineChart(LineChart lineChart) {
        values.keySet().stream().forEach(party -> {
            XYChart.Series data = new XYChart.Series<>();
            data.setName(party);
            
            values.get(party).entrySet().stream().forEach(pair ->{
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });
            lineChart.getData().add(data);
        });
    }

}
