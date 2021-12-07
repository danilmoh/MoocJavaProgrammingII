import java.util.ArrayList;

public class Box implements Packable {
    
    private double capacity;
    private ArrayList<Packable> contents;
    
    public Box (double capacity) {
        this.capacity = capacity;
        contents = new ArrayList<>();
    }
    
    public void add(Packable packable) {
        if(packable == null) {
            return;
        }
        
        if((packable.weight() >= 0) && (packable.weight() + weight() < capacity) ) {
            this.contents.add(packable);
        }
    }
    
    @Override 
    public double weight() {
        if(contents.isEmpty()) {
            return 0.0;
        }
        
        double weightSum = 0.0;
        for(Packable thing : contents) {
            weightSum += thing.weight();
        }
        return weightSum;
    }
    
    @Override
    public String toString() {
        return "Box: " + contents.size() + " items, " +
                "total weight " + weight() + " kg";
    }
}
