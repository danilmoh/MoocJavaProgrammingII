import java.util.Scanner;

public class UserInterface {
    private LiquidContainer firstContainer;    
    private LiquidContainer secondContainer;
    private Scanner scanner;

    public UserInterface(Scanner scanner, LiquidContainer first, LiquidContainer second){
        this.scanner = scanner;
        this.firstContainer = first;        
        this.secondContainer = second;
    }
    
    public void start(){
        String input[];
        String command;
        int amount = 0;
        
        outer:
        while(true){
            System.out.println("First: " + firstContainer);
            System.out.println("Second: " + secondContainer);
            
            input = scanner.nextLine().split(" ");
            command = input[0];
            if(input.length > 1)
                amount = Integer.valueOf(input[1]);
            
            switch(command){
                case "add":
                    firstContainer.addAmount(amount);
                    break;
                case "move":
                    firstContainer.moveAmount(secondContainer, amount);
                    break;
                case "remove":
                    secondContainer.removeAmount(amount);
                    break;
                case "quit":
                    break outer;
                
            }
        }
    }
}
