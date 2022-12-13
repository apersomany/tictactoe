package tictactoe;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Azarya Silaen
 */
public class Controller {
    public TextField rowTextField;
    public TextField ColumnTextField;
    public Text WarningTextField;
    static int row;
    static int column;

    // starting the game
    public void onClickStart(ActionEvent actionEvent) throws IOException {
        // getting the row and column from the text field
        row = Integer.parseInt(rowTextField.getText());
        column = Integer.parseInt(ColumnTextField.getText());
        // minimum of 3x3
        if (row < 3 || column < 3) {
            WarningTextField.setText("the maximum is 3x3");
            WarningTextField.setOpacity(0.3);
        }
        // maximum of 15/15
        else if (row > 15 || column > 15) {
            WarningTextField.setText("the maximum is 15x15");
            WarningTextField.setOpacity(0.3);
        }
        // open new game window
        else {
            Stage stage = new Stage();
            stage.setScene(new Scene(new TicTacToe(row), 480, 480));
            stage.setTitle("Tic Tac Toe");
            stage.setResizable(false);
            stage.show();
        }

    }

    // making sure row and column will always be the same
    public void onSetGridRow(KeyEvent actionEvent) {
        // changing column textfield to be the same as row
        ColumnTextField.setText(rowTextField.getText());
    }

    public void onSetGridColumn(KeyEvent actionEvent) {
        // changing the row textfield to be the same as column
        rowTextField.setText(ColumnTextField.getText());
    }

}
