
public class Program {

    public static void main(String[] args) {
        // Test the MagicSquare class here
        
        MagicSquareFactory msFactory = new MagicSquareFactory();
        MagicSquare mSquare = msFactory.createMagicSquare(41);
        System.out.println("magic square is created!");

        System.out.println("all numbers:");
        System.out.println(mSquare.giveAllNumbers());
        System.out.println("Sums of rows:");
        System.out.println(mSquare.sumsOfRows());
        System.out.println("Sums of diagonals:");
        System.out.println(mSquare.sumsOfDiagonals());
        
    }
}
