
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

    }
    
    public static int sum(int[] array, int fromWhere, int toWhere, int smallest, int largest) {
        int sum = 0;
        
        
        if(fromWhere < 0) {
            fromWhere = 0;
            smallest = 0;
        }
        
        if(toWhere > array.length) {
            toWhere = array.length;
            largest = array.length-1;
        }
        
        for(int i = fromWhere; i < toWhere; i++) {
            System.out.println(i);
            if(array[i] <= largest && array[i] >= smallest) {
                sum += array[i];
            }
        }
        
        return sum;
    }

}
