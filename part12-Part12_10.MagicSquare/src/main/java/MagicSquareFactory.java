
public class MagicSquareFactory {
    private MagicSquare square;

    public MagicSquare createMagicSquare(int size) {

        square = new MagicSquare(size);
        
        int col = square.getWidth() / 2;
        int row = 0;
        int i = 1;
        
        while(!square.isMagicSquare()) {
            square.placeValue(col, row, i);
            
            int prevRow = row;
            int prevCol = col;
            
            if(onRowEdge(row) && onColumnEdge(col)){
                //System.out.println("(1)");
                col = 0;
                row = square.getHeight()-1;
            } else if(onRowEdge(row)) {
                //System.out.println("(2)");

                col++;
                row = square.getHeight() -1;
                
            } else if(onColumnEdge(col)) {
                //System.out.println("(3)");

                col = 0;
                row--;
            } else {
                //System.out.println("(4)");

                col++;
                row--;
            }
            
            if(isFull(col, row)) {
                //System.out.println("(5)");

                row = prevRow;
                col = prevCol;
                
                row++;
            }
            
            i++;
            System.out.println(square);
        }
        return square;
    }
    
    private boolean onRowEdge(int row) {
        return row == 0;
    }
    
    private boolean onColumnEdge(int column) {
        return column == square.getWidth()-1;
    }
    
    private boolean isFull(int col, int row) {
        return square.readValue(col, row) != 0;
    }
}
