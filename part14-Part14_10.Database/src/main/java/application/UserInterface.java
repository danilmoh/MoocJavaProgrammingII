package application;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if(command.equals("1")) {
                list();
            }
            if(command.equals("2")) {
                System.out.println("Enter name");
                String name = scanner.nextLine();
                
                System.out.println("Enter description");
                String description = scanner.nextLine();
                
                add(name, description);
            }
            if(command.equals("3")) {
                System.out.println("Which todo should be marked as done (give the id)?");
                int id = Integer.valueOf(scanner.nextLine());
                
                markAsDone(id);
            }
            if(command.equals("4")) {
                System.out.println("Which todo should be removed (give the id)?");
                int id = Integer.valueOf(scanner.nextLine());
                
                remove(id);
            }
            if (command.equals("x")) {
                break;
            }

        }

        System.out.println("Thank you!");
    }
    
    private void list() {
        try {
            System.out.println("Listing the database contents");
            this.database.list().forEach(item -> System.out.println(item) );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void add(String name, String description) {
        System.out.println("Adding the new todo");
        try {
            this.database.add(new Todo(name, description, false));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void markAsDone(int id) {
        try {
            this.database.markAsDone(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void remove(int id) {
        try {
            this.database.remove(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
