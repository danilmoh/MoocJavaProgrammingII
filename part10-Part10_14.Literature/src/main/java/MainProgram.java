
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList();
        
        while(true) {
            System.out.println("Input the name of the book, empty stops: ");
            
            String bookName = scanner.nextLine();
            
            if(bookName.isEmpty()) {
                break;
            }
            
            System.out.println("Input the age recommendation: ");
            int ageRecommend = Integer.valueOf(scanner.nextLine());
            
            books.add(new Book(bookName, ageRecommend));
        }
        
        System.out.println(books.size() + " books in total.");
        
        Comparator<Book> bookComparator = Comparator
            .comparing(Book::getAgeRecommendation)
            .thenComparing(Book::getTitle);
        
        
        Collections.sort(books, bookComparator);
        books.stream().forEach(book -> System.out.println(book));
    }

}
