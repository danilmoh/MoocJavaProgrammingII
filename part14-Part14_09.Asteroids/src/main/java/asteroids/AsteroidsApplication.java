package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidsApplication  extends Application {
    
    public static int WIDTH = 600;
    public static int HEIGHT = 400;
    
    public static AtomicInteger points;

    public static void main(String[] args) {

        launch(AsteroidsApplication.class);
    }

    public static int partsCompleted() {
        return 4;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT); 
        
        Text pointsText = new Text(10, 20, "Points: 0");
        this.points = new AtomicInteger();
        pane.getChildren().add(pointsText);
        
       Ship ship = new Ship(WIDTH/2, HEIGHT/2);
        
        List<Projectile> projectiles = new ArrayList<>();
        List<Asteroid> asteroids = new ArrayList<>();
        
        Random rnd = new Random();
        
        pane.getChildren().add(ship.getCharacter()); 
       pane.getChildren().addAll(asteroids.stream().map(asteroid -> asteroid.getCharacter()).collect(Collectors.toList()));
        
        Scene scene = new Scene(pane);
        
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
        
        scene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });
        
        scene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });
        
        new AnimationTimer() {
            Point2D movement = new Point2D(1, 0);
            @Override
            public void handle(long l) {
                if(pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }
                
                if(pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }
                
                if(pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }
                
                if(pressedKeys.getOrDefault(KeyCode.CONTROL, false)
                        && pressedKeys.getOrDefault(KeyCode.Q, false)) {
                    stage.close();
                }
                
                if(Math.random() < 0.005) {
                    Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                    if(!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        pane.getChildren().add(asteroid.getCharacter());
                    }
                }
                
                projectiles.forEach(projectile -> {
                    asteroids.forEach(asteroid -> {
                        if(projectile.collide(asteroid)) {
                            projectile.setAlive(false);
                            asteroid.setAlive(false);
                        }
                    });
                    
                    if(!projectile.isAlive()) {
                        pointsText.setText("Points: " + points.addAndGet(1000));
                    }
                });
                
                // shooting
                if(pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3) {
                    shoot(pane, ship, projectiles);
                }
                
                projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .forEach(projectile -> pane.getChildren().remove(projectile.getCharacter()));
                
                projectiles.removeAll(projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .collect(Collectors.toList()));
                
                asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .forEach(asteroid -> pane.getChildren().remove(asteroid.getCharacter()));
                
                asteroids.removeAll(asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .collect(Collectors.toList()));
                
                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                projectiles.forEach(projectile -> projectile.move());
                
                asteroids.stream()
                        .forEach(asteroid -> {
                            if(ship.collide(asteroid)) {
                                stop();
                            }
                        });
            }
            
        }.start();
        
        stage.setTitle("Asteroids");
        stage.setScene(scene);
        stage.show();
    }
    
    private void shoot(Pane pane, Ship ship, List<Projectile> projectiles) {
        int shipPositionX = (int) ship.getCharacter().getTranslateX();
        int shipPositionY = (int) ship.getCharacter().getTranslateY();
        double shipRotate = ship.getCharacter().getRotate();

        Projectile projectile = new Projectile(shipPositionX, shipPositionY);
        projectile.getCharacter().setRotate(shipRotate);
        projectiles.add(projectile);

        projectile.accelerate();
        projectile.setMovement(projectile.getMovement().normalize().multiply(3));

        pane.getChildren().add(projectile.getCharacter());
    }
}
