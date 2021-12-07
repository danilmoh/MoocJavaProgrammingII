package notifier;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class NotifierApplication extends Application{

    
    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        root.setSpacing(0);
        
        TextField field = new TextField();
        Button button = new Button("Update");
        Label updatedField = new Label();
        
        root.getChildren().addAll(field, button, updatedField);
        
        button.setOnAction((ActionEvent event) -> {
            String currentText = field.getText();
        updatedField.setText(currentText);
         });
        
        Scene scene = new Scene(root, 300, 50);
        stage.setWidth(500);
        stage.setHeight(200);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

}
