import java.util.Map;
import java.util.HashMap;

public class MainProgram {

    public static void main(String[] args) {
        HashMap<Integer, String> names = new HashMap<>();
        names.put(1, "First");
        names.put(2, "Second");
        
        System.out.println(returnSize(names));
        
    }

    // Implement here a method returnSize, which takes a Map-object as a parameter 
    // and returns the size of the map object
    
    public static int returnSize(Map map) {
        return map.size();
    }
    
}
