package ticTacToe;

import java.util.List;
import java.util.ArrayList;

public class Logic {
    private GameValue[][] values;
    private Turn winner;
    private int scale = 3;
    
    public Logic() {
        this.values = new GameValue[scale][scale];
        this.winner = null;
        initializeValues();
    }
    
    public Logic(int scale) {
        this.scale = scale;
        this.values = new GameValue[scale][scale];
        this.winner = null;
        initializeValues();
    }
    
    public void setValue(GameValue value, int x, int y) {
        this.values[x][y] = value;;
    }
    
    public boolean gameEnded(Turn player, int x, int y) {
        
        int col = 0, row = 0, diag = 0, rdiag = 0;
        int scale = this.scale-1;
        boolean gameEnded = false;
        
        for(int i = 0; i <= scale; i++) {
            if(this.values[x][i].getValue() == player.getValue()) col++;
            if(this.values[i][y].getValue()==player.getValue()) row++;
            if(this.values[i][i].getValue()==player.getValue()) diag++;
           
            if(this.values[i][scale-i].getValue()==player.getValue()) rdiag++;
                
        }
        if (col == this.scale || row == this.scale || diag == this.scale || rdiag == this.scale) {
            gameEnded = true;
            this.winner = player;
        }
        return gameEnded;
    }
    
    public char winner() {
        return this.winner.getValue();
    }
    
    private void initializeValues() {
        for(int i = 0 ; i < this.values.length; i++) {
            for(int j = 0; j < this.values[i].length; j++) {
                values[i][j] = GameValue.BLANK;
            }
        }
    }
}
