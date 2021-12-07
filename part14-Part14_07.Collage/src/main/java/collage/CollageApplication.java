package collage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {

        // the example opens the image, creates a new image, and copies the opened image
        // into the new one, pixel by pixel
        Image sourceImage = new Image("file:monalisa.png");

        ImageView smallerImage = getSmallerImage(sourceImage);
        Pane pane = new Pane();
        pane.getChildren().add(smallerImage);
        stage.setScene(new Scene(pane));
        stage.show();
    }
    
    private ImageView getSmallerImage(Image sourceImage) {
        PixelReader imageReader = sourceImage.getPixelReader();
        
        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();
        
        System.out.println(width + ", " + height);
        
        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter imageWriter = targetImage.getPixelWriter();
        
        outer:
        for(int y = 0; y < height; y++) {
            if(y*2 >= height) {
                break;
            }
            inner:
            for(int x = 0; x < width; x++) {

                if(x*2 >= width) {
                    continue outer;
                }
                
                Color color = imageReader.getColor(x*2, y*2);
                double red = 1.0 - color.getRed();
                double green = 1.0 - color.getGreen();
                double blue = 1.0 - color.getBlue();
                double opacity = color.getOpacity();
                
                Color newColor = new Color(red, green, blue, opacity);
                
                imageWriter.setColor(x, y, newColor);
                imageWriter.setColor(x + width/2, y, newColor);
                imageWriter.setColor(x, y+height/2, newColor);
                imageWriter.setColor(x+width/2, y+height/2, newColor);
            }
        }
        ImageView resultImage = new ImageView(targetImage);
        return resultImage;
    }
    

    public static void main(String[] args) {
        launch(args);
    }

}
