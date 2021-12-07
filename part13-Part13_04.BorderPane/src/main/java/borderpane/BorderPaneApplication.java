package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class BorderPaneApplication extends Application{


    public static void main(String[] args) {
        launch(BorderPaneApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();
        layout.setTop(new Label("NORTH"));
        layout.setBottom(new Label("SOUTH"));
        layout.setRight(new Label("EAST"));
        
        Scene view = new Scene(layout);
        
        stage.setScene(view);
        stage.show();
    }

}
