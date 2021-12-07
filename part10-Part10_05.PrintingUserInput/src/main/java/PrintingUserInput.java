
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        
        while(true) {
            String input = scanner.nextLine();
            if(input.isEmpty() ) {
                break;
            }
            strings.add(input);
        }
        
        strings.stream().forEach(string -> System.out.println(string));
    }
}
