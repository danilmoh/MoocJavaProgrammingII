
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        List<Integer> list = new List<>();
        for(int i = 0; i < 11; i++) {
            list.add(i);
        }
        
        list.remove(5);
        
    }

}
