
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here
        List<Integer> negative = new ArrayList<>();
        negative.add(-1);
        negative.add(4);
        negative.add(-10);
        negative.add(-987);
        negative.add(3);
        negative.add(10);
        List<Integer> positive = positive(negative);
        System.out.println(positive);   // works as a charm
    }
    
    public static List<Integer> positive(List<Integer> numbers) {
        List<Integer> list = numbers.stream()
                .filter(number -> number > 0)
                .collect(Collectors.toCollection(ArrayList::new)); // possible to use Collectors.toList() instead
        
        return list;
    }

}
