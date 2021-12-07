package ticTacToe;

public enum GameValue {
    X('X'),
    O('O'),
    BLANK(' ');
    
    public final Character value;
    
    private GameValue(char value) {
        this.value = value;
    }
    
    public char getValue() {
        return this.value;
    }
}