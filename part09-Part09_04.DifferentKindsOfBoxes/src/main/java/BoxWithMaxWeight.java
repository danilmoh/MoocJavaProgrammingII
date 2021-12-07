import java.util.ArrayList;

public class BoxWithMaxWeight extends Box{
    
    private int maxWeight;
    private    ArrayList<Item> items = new ArrayList<>();

    
    public BoxWithMaxWeight(int capacity) {
        this.maxWeight = capacity;
    }
    
    private int countWeight() {
        if(items.isEmpty()) {
            return 0;
        }

        int weightSum = 0;
        for(Item item : items) { 
            weightSum += item.getWeight();
        }

        return weightSum;
    }
    
    @Override
    public void add(Item item) {
        if((item.getWeight() == 0) || (countWeight() + 1 <= maxWeight)) {
            items.add(item);
        }
    }
    

    
    @Override
    public boolean isInBox(Item item) {
        return items.contains(item);
    }
    
}
