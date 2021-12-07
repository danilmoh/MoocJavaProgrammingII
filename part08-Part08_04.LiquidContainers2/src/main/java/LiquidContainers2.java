
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container first = new Container();
        Container second = new Container();

        UserInterface ui = new UserInterface(scan, first, second);
        ui.start();
        
    }

}
