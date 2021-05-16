package game.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.tinylog.Logger;


/**
 * Draw the board.
 */

public class Draw {

    /**
     * Draw the board.
     *
     * @param grid        store the grid position
     * @param size        board size
     * @param squareSizeX X axis square number
     * @param squareSizeY Y axis square number
     * @param pane        a pane where the board draw
     */

    public static Pane DrawBoard(Rectangle[][] grid, int size, int squareSizeX, int squareSizeY, Pane pane) {
        for (int i = 0; i < size; i += squareSizeX) {
            for (int j = 0; j < size; j += squareSizeY) {
                Rectangle r = new Rectangle(i, j, squareSizeX, squareSizeY);
                grid[i / squareSizeX][j / squareSizeY] = r;
                r.setFill(Color.WHITE);
                r.setStroke(Color.BLACK);
                pane.getChildren().add(r);
            }
        }
        Logger.info("The board has been drawn");
        return pane;
    }

}