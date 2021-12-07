package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TextStatisticsApplication extends Application{


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane basePane = new BorderPane();
        HBox parametersPane = new HBox();
        parametersPane.setSpacing(15);
        
        TextArea field = new TextArea();
        
        Label letterNumber = new Label("Letters: " + 0);
        Label wordsNumber = new Label("Words: " + 0);
        Label longestWord = new Label("The longest word is: " + 0);
        
        
        parametersPane.getChildren().addAll(letterNumber, wordsNumber, longestWord);
        basePane.setCenter(field);
        basePane.setBottom(parametersPane);
        
        field.textProperty().addListener((changeListener, oldValue, newValue) ->{
            int charCount = newValue.length();
            int wordCount = 0;
            String[] parts = newValue.split(" ");
            wordCount = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            
            letterNumber.setText("Letters: " + charCount);
            wordsNumber.setText("Words: " + wordCount);
            longestWord.setText("The longest word is: " + longest);
        }
        );
        
        Scene scene = new Scene(basePane);
        stage.setScene(scene);
        stage.setWidth(500);
        stage.setHeight(300);
        stage.show();
    }

}
