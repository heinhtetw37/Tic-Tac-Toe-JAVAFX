package javaFXtictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToeTester extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        javaFXtictactoe.TicTacToe ttt = new javaFXtictactoe.TicTacToe();
        GridPane board = ttt.createGame();

        stage.setScene(new Scene(board, 250, 250));
        stage.setTitle("Tic-Tac-Toe");
        stage.show();
    }
}