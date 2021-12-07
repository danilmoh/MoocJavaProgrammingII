
public class MainProgram {

    public static void main(String[] args) {
        Person person = new Person("Danil", Education.HS);
        
        Employees empl = new Employees();
        empl.add(person);
        empl.add(new Person("someone", Education.BA));
        empl.add(new Person("noname", Education.MA));
        
        empl.print(Education.BA);
    }
}
