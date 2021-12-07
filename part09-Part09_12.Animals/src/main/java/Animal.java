
public abstract class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name =  name;
    };
    
    public void eat() {
        System.out.println(name + " eats");
    };
    
    public void sleep() {
        System.out.println(name + " sleeps");
    };
    
    public String getName() {
        return name;
    };
    
    
}
