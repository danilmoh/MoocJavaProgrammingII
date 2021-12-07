package ticTacToe;

public class TurnCounter {
    
    private Turn turn;
    
    public TurnCounter() {
        this.turn = Turn.X;
    }
    
    public TurnCounter(Turn startTurn) {
        this.turn = startTurn;
    }
    
    public void nextTurn() {
        if(this.turn == Turn.X) {
            this.turn = Turn.O;
        } else if(this.turn == Turn.O) {
            this.turn = Turn.X;
        }
    }
    
    public Turn getTurn() {
        return this.turn;
    }
}
