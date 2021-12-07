
import java.util.Objects;


public class Item {

    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Item(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
    
    @Override
    public boolean equals(Object compared) {
        if(compared == this) { 
            return true;
        }
        
        if((compared == null) || compared.getClass() != this.getClass()){
            return false;
        }
        
        Item comparedItem = (Item) compared;
        
        return this.name.equals(comparedItem.getName());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = hash * this.name.hashCode();
        return hash;
    }

    @Override 
    public String toString() {
        return this.name;
    }
    
    

}
