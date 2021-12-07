package validating;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        if(name == null || name.isEmpty() || name.length() > 40 || !isBetweenOrEquals(age, new NumberSection(0, 120)))  {
            throw new IllegalArgumentException("hello world");
        }
        
        this.name = name;
        this.age = age;
    }
    
    public static boolean isBetweenOrEquals(int arg, NumberSection section) {
        
        if(arg < section.getStartNumber() || arg > section.getEndNumber()) {
            return false;
        } else {
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
