package tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(TicTacToe.class.getResource("app.fxml"))));
        stage.setTitle("Tic Tac Toe");
        stage.setResizable(false);
        stage.show();
    }

}
