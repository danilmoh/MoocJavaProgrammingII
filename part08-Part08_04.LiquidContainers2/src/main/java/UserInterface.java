import java.util.Scanner;

public class UserInterface {
    private Container firstContainer;    
    private Container secondContainer;
    private Scanner scanner;

    public UserInterface(Scanner scanner, Container first, Container second){
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
                    firstContainer.add(amount);
                    break;
                case "move":
                    firstContainer.move(secondContainer, amount);
                    break;
                case "remove":
                    secondContainer.remove(amount);
                    break;
                case "quit":
                    
                    break outer;
                
            }
        }
    }
}
