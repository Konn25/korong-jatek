package game.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveCheckTest {

    private int[][] circlePos = new int[5][4];
    private int colorNumber = 2;

    @Test
    void checkData() {

        circlePos[0][0] = colorNumber;
        circlePos[0][1] = colorNumber;
        circlePos[0][2] = colorNumber;

        assertEquals(2, MoveCheck.checkData(circlePos, colorNumber));

        circlePos[0][0] = 0;
        circlePos[0][1] = 0;
        circlePos[0][2] = 0;

        circlePos[2][2] = colorNumber;
        circlePos[3][2] = colorNumber;
        circlePos[4][2] = colorNumber;

        assertEquals(2, MoveCheck.checkData(circlePos, colorNumber));

        circlePos[2][0] = 0;
        circlePos[2][1] = 0;
        circlePos[2][2] = 0;

        circlePos[1][1] = colorNumber;
        circlePos[2][2] = colorNumber;
        circlePos[3][3] = colorNumber;

        assertEquals(2, MoveCheck.checkData(circlePos, colorNumber));

        circlePos[2][3] = 0;
        circlePos[3][2] = 0;
        circlePos[4][1] = 0;

        circlePos[2][0] = colorNumber;
        circlePos[1][1] = colorNumber;
        circlePos[0][2] = colorNumber;

        assertEquals(2, MoveCheck.checkData(circlePos, colorNumber));

        circlePos[2][0] = 0;
        circlePos[3][1] = 0;
        circlePos[4][2] = 0;

        colorNumber = 1;

        circlePos[2][0] = colorNumber;
        circlePos[1][1] = colorNumber;
        circlePos[0][2] = colorNumber;

        assertEquals(1, MoveCheck.checkData(circlePos, colorNumber));


    }

    @Test
    void uploadList() {
        assertEquals(circlePos, MoveCheck.uploadList(circlePos));
    }

}