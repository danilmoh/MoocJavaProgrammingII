
public class Organism implements Movable {
    
    private int[] position;
    
    public Organism(int x, int y) {
        this.position = new int[2];
        
        this.position[0] = x;
        this.position[1] = y;
    }
    
    @Override
    public void move(int dx, int dy) {
        position[0] += dx;
        position[1] += dy;
    }
    
    @Override
    public String toString() {
        return "x: " + this.position[0] + "; y: " + this.position[1];
    }
}
