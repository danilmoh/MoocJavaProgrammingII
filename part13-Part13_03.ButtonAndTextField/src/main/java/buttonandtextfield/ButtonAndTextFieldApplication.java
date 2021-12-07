package buttonandtextfield;

import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ButtonAndTextFieldApplication extends Application{


    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FlowPane pane = new FlowPane(Orientation.VERTICAL);
        stage.setWidth(200);
        stage.setHeight(200);
        
        TextField textField = new TextField("input a text");
        Button button = new Button("click me");
        
        pane.getChildren().addAll(button, textField);
        
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

}
