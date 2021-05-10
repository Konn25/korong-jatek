package game.model;

import game.DrawBoard;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.tinylog.Logger;

import javafx.scene.input.MouseEvent;
import java.util.ArrayList;

public class Draw {

    /*
        *Draw the tabel
        * grind: store the table rows and colums
        * size: table size in px
        * squareSizeX: how many squres in the X axis
        * squarSizeY: how many squers  in the Y axis
        * pane: FXML Pane
     */

    public static void DrawTable(Rectangle[][] grid, int size, int squareSizeX, int squareSizeY, Pane pane) {
        for (int i = 0; i < size; i += squareSizeX) {
            for (int j = 0; j < size; j += squareSizeY) {
                Rectangle r = new Rectangle(i, j, squareSizeX, squareSizeY);
                grid[i / squareSizeX][j / squareSizeY] = r;
                r.setFill(Color.WHITE);
                r.setStroke(Color.BLACK);
                pane.getChildren().add(r);
            }
        }
        Logger.info("Tábla felrajzolása kész");
    }

}