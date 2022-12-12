package tictactoe;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

interface OnWin {
    void onWin(String player);
}

public class TicTacToe extends GridPane {
    ArrayList<ArrayList<Button>> tiles = new ArrayList<>();
    String player = "O";
    int gridSize;
    OnWin onWin;

    public TicTacToe(int gridSize, int tileSize, OnWin onWin) {
        this.gridSize = gridSize;
        this.onWin = onWin;
        for (int x = 0; x < gridSize; x++) {
            ArrayList<Button> column = new ArrayList<>();
            for (int y = 0; y < gridSize; y++) {
                Button tile = new Button();
                tile.setMinHeight(tileSize);
                tile.setMinWidth(tileSize);
                tile.setOnAction((e) -> {
                    if (tile.getText().isEmpty()) {
                        tile.setText(player);
                        if (checkWin()) {
                            onWin.onWin(player);
                        }
                        player = player.equals("O") ? "X" : "O";
                    }
                });
                column.add(tile);
                this.add(tile, x, y);
            }
            tiles.add(column);
        }
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