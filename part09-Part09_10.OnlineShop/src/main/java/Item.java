
public class Item {
    
    private String name;
    private int quantity;
    private int unitPrice;
    
    public Item(String productName, int qty, int unitPrice) {
        this.name = productName;
        this.quantity = qty;
        this.unitPrice = unitPrice;
    }
    
    public int price() {
        return quantity * unitPrice;
    }
    
    public void increaseQuantity() {
        quantity++;
    }
    
    @Override
    public String toString() {
        return this.name + ": " + this.quantity;
    }
    
    @Override
    public boolean equals(Object compared) {
        if(this == compared) {
            return true;
        }
        
        if((compared == null) || compared.getClass() != getClass()) {
            return false;
        }
        
        Item comparedItem = (Item) compared;
        
        return this.name.equals(comparedItem.name) && this.unitPrice == comparedItem.unitPrice;
    }
}
