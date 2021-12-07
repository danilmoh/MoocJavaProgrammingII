
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        
        while(true) {
            String input = scanner.nextLine();
            
            if(Integer.valueOf(input) < 0) {
                break;
            }
            
            strings.add(input);
        }
        
        strings.stream()
                .mapToInt(value -> Integer.valueOf(value))
                .filter(number -> number <= 5 && number >= 1)
                .forEach(number -> System.out.println(number));
        
    }
}
