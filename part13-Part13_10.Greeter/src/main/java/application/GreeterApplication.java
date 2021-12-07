package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    private String name = new String();
    
    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        Label startMessage = new Label("Enter your name and start");
        Label errorMessage = new Label("");
        TextField nameField=  new TextField();
        Button sceneSwitchButton = new Button("Start");

        GridPane layout1 = new GridPane();
        layout1.add(startMessage, 0, 0);
        layout1.add(nameField, 0, 1);
        layout1.add(sceneSwitchButton, 0, 2);
        layout1.add(errorMessage, 0, 3);
        layout1.setPrefSize(300, 150);
        layout1.setAlignment(Pos.CENTER);
        layout1.setVgap(10);
        layout1.setHgap(10);
        
        Label welcome = new Label();
        
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(welcome);
        layout2.setPrefSize(300, 150);
        layout2.setAlignment(Pos.CENTER);
        
        Scene nameEnterView = new Scene(layout1);
        nameEnterView.setOnKeyPressed((event) -> {
            KeyCode ev = event.getCode();
            if(ev.equals(KeyCode.ENTER)) {
                sceneSwitchButton.fire();
            }
        });
        Scene nameShowView = new Scene(layout2);
        
        sceneSwitchButton.setOnAction(event -> {
            name = nameField.getText();
            if(name.isEmpty()) {
                errorMessage.setText("Please enter your name");
                return;
            }
            
            welcome.setText("Welcome " + name + "!");
            stage.setScene(nameShowView);
            
        });
        
        stage.setScene(nameEnterView);
        stage.show();
    }
    
    
}
