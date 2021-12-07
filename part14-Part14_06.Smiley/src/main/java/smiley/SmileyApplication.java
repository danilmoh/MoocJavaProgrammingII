package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SmileyApplication extends Application {


    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane base = new BorderPane();
        Canvas canvas = new Canvas(400, 350);
        base.setCenter(canvas);
        
        GraphicsContext painter = canvas.getGraphicsContext2D();
        
        setBackground(canvas, painter);
        drawSmiley(painter);
        
        Scene scene = new Scene(base);
        stage.setScene(scene);
        stage.show();
    }
    
    private void setBackground(Canvas canvas, GraphicsContext painter) {
        painter.setFill(Color.WHITE);
        painter.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
    
    private void drawSmiley(GraphicsContext painter) {
        painter.setFill(Color.BLACK);
        drawEyes(painter);
        drawSmile(painter);
    }
    
    private void drawEyes(GraphicsContext painter) {
        painter.fillRect(100, 50, 50, 50);
        painter.fillRect(250, 50, 50, 50);
    }
    
    private void drawSmile(GraphicsContext painter) {
        painter.fillRect(50, 200, 50, 50);
        painter.fillRect(300, 200, 50, 50);
        
        painter.fillRect(100, 250, 50, 50);
        painter.fillRect(150, 250, 50, 50);
        painter.fillRect(200, 250, 50, 50);
        painter.fillRect(250, 250, 50, 50);
    }
}
