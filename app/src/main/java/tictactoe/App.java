package tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public Scene scene() {
        return new Scene(new TicTacToe(5));
    }

    public void start(Stage stage) throws Exception {
        stage.setTitle("TicTacToe");
        stage.setScene(scene());
        stage.show();
    }

}
