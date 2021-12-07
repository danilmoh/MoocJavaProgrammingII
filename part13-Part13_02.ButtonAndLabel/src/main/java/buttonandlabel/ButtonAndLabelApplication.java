package buttonandlabel;

import java.beans.EventHandler;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {


    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FlowPane pane = new FlowPane(Orientation.HORIZONTAL);    // groups out children in a flow that wraps at it's boundary
        // the group smallest size is the size of all it's children, the group is not
        // resizable by it's child components whereas
        // while the pane smallest size is the size of it's parent, so pane is resiable
        Group group = new Group() ;
        
        VBox.setVgrow(pane, Priority.NEVER);
        VBox.setVgrow(group, Priority.NEVER);
        
        Label label1 = new Label("Hello world button");
        Button button = new Button("Hello world!!!!1");
        
        pane.getChildren().add(label1);
        pane.getChildren().add(button);
        
        VBox vbox = new VBox(pane, group);
        Scene scene = new Scene(vbox, 150, 50); // special general container component without layout
       
        stage.setScene(scene);
        stage.setTitle("title");
        stage.show();
    }
}
