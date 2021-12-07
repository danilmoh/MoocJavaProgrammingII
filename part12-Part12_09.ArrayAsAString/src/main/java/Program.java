public class Program {

    public static void main(String[] args) {
        int rows = 2;
int columns = 3;
int[][] matrix = new int[rows][columns];
matrix[0][1] = 5;
matrix[1][0] = 3;
matrix[1][2] = 7;
System.out.print(arrayAsString(matrix));
        
    }
    
    public static String arrayAsString(int[][] array) {
        StringBuilder builder = new StringBuilder();
        builder = new StringBuilder();
        
        for (int row = 0; row < array.length; row++) {
            
            for(int column = 0; column < array[row].length; column++) {
                builder.append(array[row][column]);
            }
            
            builder.append("\n");
        }
        
        return builder.toString();
    }

}
