package ticTacToe;

public enum Turn {
    X('X'), O('O');
    
    private final char value;
    
    private Turn(char value) {
        this.value = value;
    }
    
    public char getValue() {
        return this.value;
    }
}