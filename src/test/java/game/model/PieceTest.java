package game.model;

import javafx.scene.shape.Circle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {


    @Test
    void getX() {
        Piece p = new Piece(50, 100, 30, new Circle());
        assertEquals(50, p.getX());
    }

    @Test
    void getY() {
        Piece p = new Piece(50, 100, 30, new Circle());
        assertEquals(100, p.getY());
    }

}