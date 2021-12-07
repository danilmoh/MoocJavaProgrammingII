package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        Label label1 = new Label("First view!");
        Button button1 = new Button("To the second view!");

        BorderPane firstLayout = new BorderPane();
        firstLayout.setTop(label1);
        firstLayout.setCenter(button1);
        
        Button button2 = new Button("To the third view!");
        Label label2 = new Label("Second view!");
        
        VBox secondLayout = new VBox(button2, label2);
        
        Label label3 = new Label("Third view!");
        Button button3 = new Button("To the first view!");
        
        GridPane thirdLayout = new GridPane();
        
        for(int x = 0; x <= 1; x++) {
            for(int y = 0 ; y <= 1; y++) {
                if(x == 0 && y==0) {
                    thirdLayout.add(label3, x, y);
                } else
                if(x==1 && y==1) {
                    thirdLayout.add(button3, x, y);
                }
            }
        }
        
        Scene firstView = new Scene(firstLayout);
        Scene secondView = new Scene(secondLayout);
        Scene thirdView = new Scene(thirdLayout);

        button1.setOnAction((event) -> {
            stage.setScene(secondView);
        });
        
        button2.setOnAction((event) -> {
            stage.setScene(thirdView);
        });
        
        button3.setOnAction((event) -> {
            stage.setScene(firstView);
        });
        
        stage.setScene(firstView);
        stage.show();
    }

}
