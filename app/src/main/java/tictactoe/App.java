package tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public Scene scene() {
        // TicTacToe extends GridPane, so it can be stored as a GridPane
        GridPane root = new TicTacToe(3, 32, (player) -> {
            System.out.format("%s won", player);
        });
        return new Scene(root);
    }

    public void start(Stage stage) throws Exception {
        stage.setTitle("TicTacToe");
        stage.setScene(scene());
        stage.show();
    }

}
