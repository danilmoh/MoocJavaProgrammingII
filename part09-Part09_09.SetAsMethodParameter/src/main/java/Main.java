import java.util.Set;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        // You can test your method here
        
        HashSet<String> set = new HashSet<>();
        set.add("hello world");
        set.add("something");
        set.add("goodbye world");
        System.out.println(returnSize(set));

    }

    // implement the method returnSize here, which returns
    // the number of elements in the set that it receives as a parameter.

    public static int returnSize(Set set) {
        return set.size();
    }
    
}
