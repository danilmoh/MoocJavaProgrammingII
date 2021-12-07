package asteroids;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public abstract class Character {
    private Point2D movement;
    private Polygon character;
    
    private boolean alive = true;
    
    public Character(Polygon polygon, int x, int y) {
        this.character = polygon;
        
        this.character.setTranslateX(x);
        this.character.setTranslateY(y);
        
        this.movement = new Point2D(0, 0);
    }
    
    public Polygon getCharacter() {
        return this.character;
    }
    
    public Point2D getMovement() {
        return this.movement;
    }
    
    public void setMovement(Point2D newMovement) {
        this.movement = newMovement;
    }
    
    public boolean isAlive() {
        return this.alive;
    }
    
    public void setAlive(boolean newAlive) {
        this.alive = newAlive;
    }
    
    public void turnLeft() {
        this.character.setRotate(this.character.getRotate() -2.5);
    }
    
    public void turnRight() {
        this.character.setRotate(this.character.getRotate() +2.5);
    }
    
    public void move() {
        this.character.setTranslateX(this.character.getTranslateX() + this.movement.getX());
        this.character.setTranslateY(this.character.getTranslateY() + this.movement.getY());
        
        if(this.character.getTranslateX() < 0) {
            this.character.setTranslateX(this.character.getTranslateX() + AsteroidsApplication.WIDTH);
        }
        
        if(this.character.getTranslateX() > AsteroidsApplication.WIDTH) {
            this.character.setTranslateX(0);
        }
        
        if(this.character.getTranslateY() < 0) {
            this.character.setTranslateY(this.character.getTranslateY() + AsteroidsApplication.HEIGHT);
        }
        
        if(this.character.getTranslateY() > AsteroidsApplication.HEIGHT) {
            this.character.setTranslateY(0);
        }
    }
    
    public void accelerate() {
        // calculating the movement change
        double changeX = Math.cos(Math.toRadians(this.character.getRotate()));
        double changeY = Math.sin(Math.toRadians(this.character.getRotate()));
        
        changeX *= 0.005;
        changeY *= 0.005;
        
        this.movement = this.movement.add(changeX, changeY);
    }
    
    public boolean collide(Character other) {
        Shape collisionArea = Shape.intersect(this.character, other.getCharacter());
        return collisionArea.getBoundsInLocal().getWidth() != -1;
    }
}
