package FlightControl.domain;

public class Airplane {
    
    private String ID;
    private int capacity;
    
    public Airplane(String ID, int capacity) {
        this.ID = ID;
        this.capacity = capacity;
    }
    
    public String getID() {
        return this.ID;
    }
    
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public String toString() {
        return ID + " (" +capacity + " capacity)";
    }
}
