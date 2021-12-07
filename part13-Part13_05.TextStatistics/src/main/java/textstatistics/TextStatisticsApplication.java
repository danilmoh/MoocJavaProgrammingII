package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TextStatisticsApplication extends Application {


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane baseLayout = new BorderPane();
        HBox labels = new HBox();
        labels.setSpacing(10);
        
        TextArea text = new TextArea("Type something here");
        labels.getChildren().add(new Label("Letters: 0"));
        labels.getChildren().add(new Label("Words: 0"));
        labels.getChildren().add(new Label("The longest word is:"));
        
        baseLayout.setCenter(text);
        baseLayout.setBottom(labels);
        
        Scene scene = new Scene(baseLayout);
        
        stage.setWidth(500);
        stage.setHeight(200);
        stage.setScene(scene);
        stage.show();
    }

}
