package application;

import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.List;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class JokeApplication extends Application{


    public static void main(String[] args) {
        launch(JokeApplication.class);
        
    }
    
    private static StackPane createView(String text) {

	StackPane layout = new StackPane();
	layout.setPrefSize(300, 180);
	layout.getChildren().add(new Label(text));
	layout.setAlignment(Pos.CENTER);

	return layout;
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        BorderPane base = new BorderPane();
        
        Button questionButton = new Button("Joke");     // shows a question that is related to a joke
        Button answerButton = new Button("Answer"); // shows the related answer
        Button explainButton = new Button("Explanation"); // shows explanation to the joke
        
        List<Joke> explanations = new ArrayList<>();
        Joke joke = new Joke();
        joke.setQuestion("What do you call a bear with no teeth?");
        joke.setAnswer("A gummy bear.");
        joke.setExplanation("It's a bear with the gummy teeth!");
        explanations.add(joke);
        
        HBox menu = new HBox();
        menu.getChildren().addAll(questionButton, answerButton, explainButton);
        
        menu.setSpacing(10);
        
        StackPane questionText = createView(explanations.get(0).getQuestion());
        StackPane answerText = createView(explanations.get(0).getAnswer());
        StackPane explanationText = createView(explanations.get(0).getExplanation());
        
        questionButton.setOnAction((event) -> base.setBottom(questionText));
        answerButton.setOnAction((event) -> base.setBottom(answerText));
        explainButton.setOnAction((event) -> base.setBottom(explanationText));
        
        base.setTop(menu);
        base.setBottom(questionText);
        stage.setScene(new Scene(base));
        stage.show();
    }
}
