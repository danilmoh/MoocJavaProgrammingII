import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private TodoList list;
    
    public UserInterface(TodoList list, Scanner scanner){
        this.list = list;
        this.scanner = scanner;
    }
    
    public void start(){
        
        loop:
        while(true){
            System.out.print("Command: ");
            String command = scanner.nextLine();
            
            
            switch(command){
                case "add":
                    System.out.print("Task: ");
                    String task = scanner.nextLine();
                    list.add(task);
                    break;
                case "list":
                    list.print();
                    break;
                case "remove":
                    System.out.print("Which one is removed? ");
                    int taskNumber = Integer.parseInt(scanner.nextLine());
                    list.remove(taskNumber);
                    break;
                case "stop":
                    break loop;
                        
            }
        }
    }
}
