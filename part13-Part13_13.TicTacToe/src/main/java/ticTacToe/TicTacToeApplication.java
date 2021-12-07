package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class TicTacToeApplication extends Application {
    
    private TurnCounter turn;
    private Label turnText;

    public static void main(String[] args) {
        
        launch(TicTacToeApplication.class);
    }
    
    @Override
    public void init() {
        this.turn = new TurnCounter();
        this.turnText = new Label("Turn: " + turn.getTurn());
    }

    @Override
    public void start(Stage stage) throws Exception {
        init();
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        
        GridPane board = new GridPane();
        board.setAlignment(Pos.CENTER);
        board.setPadding(new Insets(10, 10, 10, 10));   // margins around the whole grid
        board.setHgap(10);
        board.setVgap(10);
        
        Logic logic = new Logic();
        
        Button[][] cells = new Button[3][3];
        
        initializeButtons(cells, logic, board);
        
        pane.setTop(turnText);
        pane.setCenter(board);
        
        BorderPane.setAlignment(turnText, Pos.CENTER);
        BorderPane.setAlignment(board, Pos.CENTER);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Tic tac toe");
        stage.show();
    }
    
    private void initializeButtons(Button[][] cells, Logic logic, GridPane board) {
        for(int x = 0; x < cells.length; x++) {
            for(int y = 0; y < cells[x].length; y++) {
            cells[x][y] = new Button(" ");
            cells[x][y].setFont(new Font("Liberation Mono", 40));
                board.add(cells[x][y], x, y);
                setButtonOnAction(cells, logic, x, y);
            }
        }
    }
    
    private void setButtonOnAction(Button[][] arr, Logic logic, int x, int y) {
        arr[x][y].setOnAction((event) -> {
            if(arr[x][y].getText().equals(" ")) {
                setButtonValue(arr, logic, x, y);
            }
        });
    }
    
    private void setButtonValue(Button[][]arr, Logic logic, int x, int y) {
        if(this.turn.getTurn().equals(Turn.X)) {
                logic.setValue(GameValue.X, x, y);
                arr[x][y].setText(((Character)GameValue.X.getValue()).toString());
            }
            else if (this.turn.getTurn().equals(Turn.O)) {
                logic.setValue(GameValue.O, x, y);
                arr[x][y].setText(((Character)GameValue.O.getValue()).toString());
            }
            
            if(!logic.gameEnded(this.turn.getTurn(), x, y)) {
                changeTurn();
                this.turnText.setText("Turn: " + this.turn.getTurn());
            } else {
                this.turnText.setText("The end!");
                disableButtons(arr);
            }
            
    }
    
    private void disableButtons(Button[][] arr) {
        for(int x = 0; x < arr.length; x++) {
            for(int y = 0; y < arr[x].length; y++ ) {
                arr[x][y].setDisable(true);
            }
        }
    }
    
    private void changeTurn() {
        this.turn.nextTurn();
    }
}
