import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // type                 reference
        Person student = new Student("Danil", "SomeCity");
        // person type can not have a reference of the student so it just cuts off it's differenct subclass parts (methods, fields)
        
        System.out.println(student);
        
        // same thing but with an object type
        Object teacher = new Teacher("Maria", "Russia", 150);
//      doesnt work    System.out.println(teacher.getSalary());
        System.out.println(teacher);
    }
    
    public static void printPersons(ArrayList<Person> persons) {
        for(Person p : persons){
            System.out.println(p);
        }
    }

}
