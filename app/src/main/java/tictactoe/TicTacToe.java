package tictactoe;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class TicTacToe extends StackPane {
    ArrayList<ArrayList<Button>> tiles = new ArrayList<>();
    String player = "O";
    int gridSize;

    public TicTacToe(int gridSize) {
        this.gridSize = gridSize;
        GridPane game = new GridPane();
        for (int x = 0; x < gridSize; x++) {
            ArrayList<Button> column = new ArrayList<>();
            for (int y = 0; y < gridSize; y++) {
                Button tile = new Button();
                tile.setMinHeight(480 / gridSize);
                tile.setMinWidth(480 / gridSize);
                tile.setOnAction((e) -> {
                    if (tile.getText().isEmpty()) {
                        tile.setText(player);
                        if (checkWin()) {
                            Rectangle blur = new Rectangle(480, 480, Color.WHITESMOKE);
                            blur.setOpacity(0.5);
                            Label text = new Label(player + " wins!");
                            text.setFont(new Font(64));
                            this.getChildren().add(blur);
                            this.getChildren().add(text);
                        }
                        player = player.equals("O") ? "X" : "O";
                    }
                });
                column.add(tile);
                game.add(tile, x, y);
            }
            tiles.add(column);
        }
        this.getChildren().add(game);
    }

    private boolean checkWin() {
        int matchD1 = 0;
        int matchD2 = 0;
        for (int a = 0; a < gridSize; a++) {
            int matchA1 = 0;
            int matchA2 = 0;
            for (int b = 0; b < gridSize; b++) {
                if (tiles.get(a).get(b).getText().equals(player)) {
                    if (++matchA1 == gridSize) {
                        return true;
                    }
                } else {
                    matchA1 = 0;
                }
                if (tiles.get(b).get(a).getText().equals(player)) {
                    if (++matchA2 == gridSize) {
                        return true;
                    }
                } else {
                    matchA2 = 0;
                }
            }
            int c = gridSize - a - 1;
            if (tiles.get(a).get(a).getText().equals(player)) {
                if (++matchD1 == gridSize) {
                    return true;
                }
            } else {
                matchD1 = 0;
            }
            if (tiles.get(a).get(c).getText().equals(player)) {
                if (++matchD2 == gridSize) {
                    return true;
                }
            } else {
                matchD2 = 0;
            }
        }
        return false;
    }
}