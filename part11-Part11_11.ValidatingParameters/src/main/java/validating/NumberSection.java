package validating;

public class NumberSection {
    private int startNumber;
    private int endNumber;
    
    public NumberSection(int startNumber, int endNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public int getEndNumber() {
        return endNumber;
    }
}
