import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {
    
    private List<Item> items;
    
    public ShoppingCart() {
        this.items = new ArrayList();
    }
    
    public void add(String product, int price) {
        Item nonexistentItem = new Item(product, 1, price);
        if(items.contains(nonexistentItem)) {
            int itemIndex = items.indexOf(nonexistentItem);
            items.get(itemIndex).increaseQuantity();
        } else {
            items.add(new Item(product, 1, price));
            
        }
        
    }
    
    public int price() {
        int priceSum = 0;
        for(Item item : items) {
            priceSum += item.price();
        }
        
        return priceSum;
    }
    
    public void print() {
        for(Item item : items) {
            System.out.println(item);
        }
    }
}
