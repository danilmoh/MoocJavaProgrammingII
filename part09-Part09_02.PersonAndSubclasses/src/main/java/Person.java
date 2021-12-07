
public class Person {
    private String name;
    private String address;
    
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    @Override
    public String toString() {
        return this.name + "\n  " + this.address;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getAddress() {
        return this.address;
    }
}
