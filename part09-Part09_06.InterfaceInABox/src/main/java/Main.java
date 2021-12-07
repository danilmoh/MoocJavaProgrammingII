
public class Main {

    public static void main(String[] args) {
        Book book1 = new Book("Someone", "?", 6.9);
        System.out.println(book1);
        
        CD cd1 = new CD("Me", "My music", 2021);
        System.out.println(cd1);
        
        Box box1 = new Box(10);
        box1.add(book1);
        box1.add(cd1);
        
        Box box2 = new Box(3);
        Book book2 = new Book("Robert Martin", "Clear Code", 1);
        Book book3 = new Book("Craig Walls", "Spring in Action", 1.99999);
        box2.add(book2);
        box2.add(book3);
        
        System.out.println("Weight of box2 " + box2.weight());
        System.out.println("Weight of box1 " + box1.weight());
        box1.add(box2);
        System.out.println("Weight of both " + box1.weight());
    }

}
