

public class Main {

    public static void main(String[] args) {
        Warehouse house = new Warehouse();
        house.addProduct("coffee", 5, 7);
        house.take("coffee");
        System.out.println(house.stock("coffee"));
                
        
    }
}
