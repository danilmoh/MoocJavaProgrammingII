
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        
        System.out.println("Input numbers, type \"end\" to stop.");
        while(true) {
            String raw = scanner.nextLine();
            
            if(raw.equals("end")) {
                break;
            }
            
            input.add(raw);
        }
        
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String check = scanner.nextLine();
        boolean positive = check.equals("p");
        double average;
        
        if(positive) {
            average = input.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(number -> number > 0)
                    .average()
                    .getAsDouble();
        } else {
            average = input.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(number -> number < 0)
                    .average()
                    .getAsDouble();
        }
        
        
        System.out.println("Average of the " + ((positive) ? "positive" : "negative") + " numbers: " + average);

    }
}
