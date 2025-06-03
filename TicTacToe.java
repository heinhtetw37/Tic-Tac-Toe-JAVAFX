package javaFXtictactoe;

import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

public class TicTacToe {
    private boolean xTurn = true;
    private Button[][] buttons = new Button[3][3];

    private boolean checkLine(Button b1, Button b2, Button b3){
        return !b1.getText().isEmpty() && //Changed from isEmpty() to isBlank()
                b1.getText().equals(b2.getText())&&
                b2.getText().equals(b3.getText());
    }

    private boolean checkWin() {
        //checking rows and columns
        for (int i = 0; i < 3; i++){
            if (checkLine(buttons[i][0], buttons [i][1], buttons [i][2]) ||
                    checkLine(buttons[0][i], buttons[1][i], buttons[2][i])){
                return true;
            }
        }
        //check diagonals
        return checkLine(buttons[0][0], buttons[1][1], buttons[2][2]) ||
                checkLine(buttons[0][2], buttons[1][1], buttons[2][0]);
    }
    private boolean isDraw(){
        for (Button[] row : buttons ){
            for(Button bn : row){
                if(bn.getText().isEmpty())
                    return false; //Changed from isEmpty()
            }
        }
        return true;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); //changes the heading tictactoe game to game over when X or Y win.
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void resetBoard(){
        for (Button[] row : buttons){
            for (Button bn : row){
                bn.setText("");
            }
        }
        xTurn = true;
    }

    public GridPane createGame() {
        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(5);
        //Format for the Tic Tac Toe pattern

        for (int row= 0; row < 3; row++){
            for (int column = 0; column < 3; column++ ){
                Button bn = new Button();
                bn.setMinSize(80,80);
                bn.setStyle("-fx-font-size: 24px;");
                bn.setOnAction(e-> {
                    if(bn.getText().isEmpty()){
                        bn.setText(xTurn? "X" : "O");
                        if (checkWin()) {
                            showAlert((xTurn ? "X" : "O") + " wins!");
                            resetBoard();
                        } else if (isDraw()) {
                            showAlert("It's a draw!");
                            resetBoard();
                        }
                        xTurn = !xTurn;
                    }
                });
                buttons[row][column] = bn;
                grid.add(bn, column, row);
            }
        }
        return grid;
    }

}
