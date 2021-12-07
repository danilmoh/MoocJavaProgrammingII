package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application{

    private XYChart.Series yearlyInterest;
    private XYChart.Series saving;
    
    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }
    
    @Override
    public void init() {
        this.yearlyInterest = new XYChart.Series();
        this.yearlyInterest.setName("Yearly interest");
        this.saving = new XYChart.Series();
        this.saving.setName("Savings");
    }

    @Override
    public void start(Stage stage) throws Exception {
        int defaultMonthlySavings = 25;
        int defaultYearlyRate = 0;
        
        init();
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10,10,10,10));
        
        Slider monthlySavings = new Slider(25,250, defaultMonthlySavings);
        Slider yearlyInterest = new Slider(0,10, defaultYearlyRate);
        
        monthlySavings.setShowTickLabels(true);
        monthlySavings.setShowTickMarks(true);
        monthlySavings.setMajorTickUnit(25);
        monthlySavings.setBlockIncrement(25);
        yearlyInterest.setShowTickMarks(true);
        yearlyInterest.setShowTickLabels(true);
        yearlyInterest.setMajorTickUnit(10);
        yearlyInterest.setBlockIncrement(1);
        
        Label monthlySavingsName = new Label("Monthly savings");
        Label yearlyInterestName = new Label("Yearly interest rate");
        Label monthlySavingValue = new Label();
        Label yearlyInterestValue = new Label();
        
        NumberAxis xAxis = new NumberAxis(0,30, 1);
        NumberAxis yAxis = new NumberAxis(0,125000, 25000);
        LineChart<Integer, Integer> lineChart = new LineChart(xAxis,yAxis);
        lineChart.getData().add(this.saving);
        lineChart.getData().add(this.yearlyInterest);
        
        monthlySavings.valueProperty().addListener(
                
            new ChangeListener<Number>() {
                
                @Override
                public void changed(ObservableValue <? extends Number >
                        observable, Number oldValue, Number newValue) {
                    double monthlySaving = Double.valueOf(newValue.toString());

                    monthlySavingValue.setText(Math.round(monthlySaving) + "");
                    
                    setSavings(lineChart, monthlySaving);
                    setInterestRate(lineChart, monthlySaving, yearlyInterest.getValue());
                }
            });
        
        yearlyInterest.valueProperty().addListener(
                
            new ChangeListener<Number>() {
                
                @Override
                public void changed(ObservableValue <? extends Number >
                        observable, Number oldValue, Number newValue) {
                    
                    double interestRate = Double.valueOf(newValue.toString());

                    yearlyInterestValue.setText(Math.round(interestRate) + "");
                    
                    setInterestRate(lineChart, monthlySavings.getValue(), interestRate);
                }
            });
        
        monthlySavings.setPrefWidth(450);
        yearlyInterest.setPrefWidth(460);

        
        BorderPane firstLine = new BorderPane();
        BorderPane secondLine = new BorderPane();
        VBox bothLines = new VBox(10);
        
        firstLine.setLeft(monthlySavingsName);
        firstLine.setCenter(monthlySavings);
        firstLine.setRight(monthlySavingValue);
        secondLine.setLeft(yearlyInterestName); 
        secondLine.setCenter(yearlyInterest);
        secondLine.setRight(yearlyInterestValue);
        bothLines.getChildren().addAll(firstLine, secondLine);
        
        pane.setTop(bothLines);
        pane.setCenter(lineChart);
        
        Scene scene = new Scene(pane, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        setSavings(lineChart, defaultMonthlySavings);
        setInterestRate(lineChart, defaultMonthlySavings, defaultYearlyRate);
        
    }
    
    public void setSavings(LineChart chart, double monthlySavings) {
        saving.getData().clear();

        int yearlyValue = 0;
        double addValue = monthlySavings*12;

        for(int i = 0 ; i <= 30 ; i++) {
            saving.getData().add(new XYChart.Data(i, yearlyValue));
            yearlyValue+=addValue;
        }
        
    }
    
    public void setInterestRate(LineChart chart, double monthlySaving, double rate) {
        yearlyInterest.getData().clear();
        
        double numberOfYears = ((NumberAxis)chart.getXAxis()).getUpperBound();
        double yearlySaving = monthlySaving*12;
        double principal = 0;
        
        yearlyInterest.getData().add(new XYChart.Data(0, 0));   // setting zero year to be 0
        
        for(int i = 1; i <= numberOfYears; i++) {
            principal += yearlySaving;
            double interest = (principal * rate)/100.0;
            principal += interest;
            yearlyInterest.getData().add(new XYChart.Data(i, principal));
        }
    }

}
