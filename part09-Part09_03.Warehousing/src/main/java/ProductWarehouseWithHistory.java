
public class ProductWarehouseWithHistory extends ProductWarehouse {
    
    private ChangeHistory history;
    
    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        this.history = new ChangeHistory();
        this.history.add(initialBalance);
    }
    
    public String history() {
        return history.toString();
    }
    
    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        history.add(super.getBalance());
    }
    
    @Override
    public double takeFromWarehouse(double amount) {
        double amountTaken = super.takeFromWarehouse(amount);
        history.add(super.getBalance());
        
        return amountTaken;
    }
    
    public void printAnalysis() {
        System.out.println("Product: " + super.getName() +
                "\nHistory: " + history.toString() +
                "\nLargest amount of product: " + history.maxValue() +
                "\nSmallest amount of product: " + history.minValue() +
                "\nAverage: " + history.average());
    }
}
