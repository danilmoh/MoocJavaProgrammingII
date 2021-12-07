import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Warehouse {

    private Map<String, Integer> products;
    private Map<String, Integer> productStocks;
    
    public Warehouse() {
        this.products = new HashMap<>();
        this.productStocks = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        if(products.containsKey(product)) {
            Integer productStock = productStocks.get(product);
            productStock++;
            productStocks.put(product, productStock);
        } else {
            products.put(product, price);
            productStocks.put(product, stock);
        }

    }
    
    public int price(String product) {
        return products.getOrDefault(product, -99);
    }
    
    public int stock(String product) {
        return productStocks.getOrDefault(product, 0);
    }
   
    public boolean take(String product) {
       if(productStocks.containsKey(product)) {
           Integer stock = productStocks.get(product);
           if(stock > 0) {
               stock--;
               productStocks.put(product, stock);
           } else {
               return false;
           }
           return true;
       } else {
           return false;
       }
   }
    
    public Set<String> products() {
        return products.keySet();
    }
    
    
}
