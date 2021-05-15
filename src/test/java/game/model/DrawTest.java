package game.model;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawTest {

    @Test
    void drawBoard() {
        Pane pane = new Pane();
        Rectangle[][] grid = new Rectangle[4][5];
        int size = 500;
        int squareSizeX = size / 4;
        int squareSizeY = size / 5;
        assertEquals(pane, Draw.DrawBoard(grid, size, squareSizeX, squareSizeY, pane));
    }
}