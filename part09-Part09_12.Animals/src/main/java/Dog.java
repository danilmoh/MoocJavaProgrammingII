
public class Dog extends Animal implements NoiseCapable{
    
    
    public Dog(String name) {
        super(name);
    }
    
    public Dog() {
        super("Dog");
    }
    
    public void bark() {
        System.out.println(name + " barks");
    }
    
    public void makeNoise() {
        bark();
    }
}
