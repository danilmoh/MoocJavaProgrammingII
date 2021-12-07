import java.util.List;
import java.util.ArrayList;

public class Herd implements Movable {
    private List<Movable> units;
    
    public Herd() {
        this.units = new ArrayList<>();
    }
    
    public void addToHerd(Movable movable) {
        if(movable != null) {
            this.units.add(movable);

        }
    }
    
    @Override
    public void move(int dx, int dy) {
        for(Movable unit : units) {
            unit.move(dx, dy);
        }
    }
    
    @Override
    public String toString() {
        String result = "";
        for(Movable unit : units) {
            result += unit.toString() + "\n";
        }
        
        return result;
    }
}
