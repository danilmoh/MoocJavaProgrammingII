import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Employees {
    
    private List<Person> employees;
    
    public Employees() {
        this.employees = new ArrayList<>();
    }
    
    public void add(Person personToAdd) {
        if(personToAdd != null) {
            employees.add(personToAdd);
        }
    }
    
    public void add(List<Person> peopleToAdd) {
        if(peopleToAdd != null) {
            employees.addAll(peopleToAdd);
        }
    }
    
    public void print() {
        Iterator<Person> iterator = employees.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
    public void print(Education education) {
        Iterator<Person> iterator = employees.iterator();
        while(iterator.hasNext()) {
            Person person = iterator.next();
            if(person.getEducation() == education) {
                System.out.println(person);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> iterator = employees.iterator();
        while(iterator.hasNext()) {
            if( iterator.next().getEducation() == education ) {
                iterator.remove();
            }
        }
    }
}
