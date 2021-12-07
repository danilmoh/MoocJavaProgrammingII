
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LiquidContainer first = new LiquidContainer();
        LiquidContainer second = new LiquidContainer();

        UserInterface ui = new UserInterface(scan, first, second);
        ui.start();
        
    }

}
