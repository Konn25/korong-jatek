package game.javafx.controller;

import game.javafx.Main;
import game.model.*;
import game.results.DataBase;
import game.results.DataModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.jdbi.v3.core.Handle;
import org.tinylog.Logger;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Draw the game board and control the game.fxml
 */
public class DrawBoardController {

    @FXML
    Pane pane;

    @FXML
    Label moveText, endText;


    List<DataModel> dm;

    private final int size = 400;

    private final int squareSizeX = size / 4;
    private final int squareSizeY = size / 5;

    private Rectangle[][] grid;

    private int[][] circlePos = new int[5][4];
    private int lastX = 0;
    private int lastY = 0;

    private boolean whichPlayerMove = false;
    private boolean gameEnd = false;

    private String winner2 = "";


    @FXML
    private Label redNameLabel, blueNameLabel;

    @FXML
    private Button endGame;


    public void setRedName(String redName) {
        redNameLabel.setText(redName);
    }

    public void setBlueName(String blueName) {
        blueNameLabel.setText(blueName);
    }

    @FXML
    public void initialize() {
        endGame.setVisible(false);
        endText.setVisible(false);
        grid = new Rectangle[4][5];

        pane = Draw.DrawBoard(grid, size, squareSizeX, squareSizeY, pane);
        ArrayList<Piece> pieces = new ArrayList<>();
        int plus = 0;
        int counter = 1;
        int plus2 = 0;

        for (int i = 0; i < 8; i++) {
            Circle c = new Circle();
            Piece p;

            double radius = squareSizeX / 4.0;

            c.setStroke(Color.BLACK);
            if (counter <= 4) {
                if (counter % 2 == 0) {
                    c.setFill(Color.RED);
                } else {
                    c.setFill(Color.BLUE);
                }

                p = new Piece(50 + plus, 40, radius, c);
                pieces.add(p);


                c.setOnMousePressed(event -> pressed(p, circlePos, c, whichPlayerMove));
                c.setOnMouseDragged(event -> dragged(event, p, c, whichPlayerMove));
                c.setOnMouseReleased(event -> released(p, circlePos, c));

                System.out.println(pieces.get(i).getX() + "  " + pieces.get(i).getY());

                pane.getChildren().add(c);
                p.draw();
                plus = plus + 100;
            } else {

                if (counter % 2 == 0) {
                    c.setFill(Color.BLUE);
                } else {
                    c.setFill(Color.RED);
                }

                p = new Piece(50 + plus2, 40 + 320, radius, c);
                pieces.add(p);

                c.setOnMousePressed(event -> pressed(p, circlePos, c, whichPlayerMove));
                c.setOnMouseDragged(event -> dragged(event, p, c, whichPlayerMove));
                c.setOnMouseReleased(event -> released(p, circlePos, c));

                Logger.info(pieces.get(i).getX() + "  " + pieces.get(i).getY());

                pane.getChildren().add(c);
                p.draw();
                plus2 = plus2 + 100;
            }

            counter++;
        }

        circlePos = MoveCheck.uploadList(circlePos);

    }

    public void checkValues(int[][] circlePos) {
        int color = 0;
        int blueColor = 1;
        int redColor = 2;

        if (MoveCheck.checkData(circlePos, blueColor) == 1) {
            color = 1;
        } else if (MoveCheck.checkData(circlePos, redColor) == 2) {
            color = 2;
        }

        if (color == 1) {
            Logger.info("Game Over Blue player won");
            winner2 = blueNameLabel.getText();
            System.out.println(winner2);
            gameEnd = true;
            endGame.setVisible(true);
            endText.setVisible(true);
            endText.setText("Blue player won");
            pane.setVisible(false);
            moveText.setVisible(false);
        } else if (color == 2) {
            Logger.info("Game Over Red player won");
            winner2 = redNameLabel.getText();
            System.out.println(winner2);
            gameEnd = true;
            endGame.setVisible(true);
            endText.setVisible(true);
            endText.setText("Red player won");
            pane.setVisible(false);
            moveText.setVisible(false);
        }
    }


    public void pressed(Piece p, int[][] circlePos, Circle c, boolean whichPlayerMove) {
        lastX = (int) p.getX() / squareSizeX;
        lastY = (int) p.getY() / squareSizeY;
        Logger.info(lastX + " " + lastY);

        if (c.getFill() == Color.RED && !whichPlayerMove) {
            CheckPossibleMoves(circlePos);
        } else if (c.getFill() == Color.BLUE && whichPlayerMove) {
            CheckPossibleMoves(circlePos);
        } else {
            Logger.info("Not the right player moves");
        }


        Logger.info("Last Position: " + lastX + "  " + lastY);
    }

    public void dragged(MouseEvent event, Piece p, Circle c, boolean whichPlayerMove) {

        if (c.getFill() == Color.RED && !whichPlayerMove) {
            p.setX(p.getX() + event.getX());
            p.setY(p.getY() + event.getY());
            p.draw();
        } else if (c.getFill() == Color.BLUE && whichPlayerMove) {
            p.setX(p.getX() + event.getX());
            p.setY(p.getY() + event.getY());
            p.draw();
        }
    }

    public void released(Piece p, int[][] circlePos, Circle c) {
        int gridX = (int) p.getX() / squareSizeX;
        int gridY = (int) p.getY() / squareSizeY;

        int redNumber = 2;
        int blueNumber = 1;

        try {
            if (c.getFill() == Color.RED && !whichPlayerMove && !gameEnd) {

                whichPlayerMove = movePiece(p, circlePos, gridX, gridY, redNumber, false);
                movePiece(p, circlePos, gridX, gridY, redNumber, whichPlayerMove);
            } else if (c.getFill() == Color.BLUE && whichPlayerMove && !gameEnd) {

                whichPlayerMove = movePiece(p, circlePos, gridX, gridY, blueNumber, true);
                movePiece(p, circlePos, gridX, gridY, blueNumber, whichPlayerMove);
            } else {
                p.setX((float) (squareSizeX / 2 + squareSizeX * lastX));
                p.setY((float) (squareSizeY / 2 + squareSizeY * lastY));
                p.draw();
                whichPlayerMove = whichPlayerMove;

                Logger.info("Not a correct move, circle back to the last position ");
            }

            if (!whichPlayerMove) {
                moveText.setText("Red player turn");
            } else {
                moveText.setText("Blue player turn");
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 5; j++) {
                    if (grid[i][j].getFill() == Color.GREEN) {
                        grid[i][j].setFill(Color.WHITE);
                    }
                }
            }
            checkValues(circlePos);

        } catch (Exception e) {
            Logger.error("Error:" + e);
            if (c.getFill() == Color.RED && !whichPlayerMove && !gameEnd) {
                whichPlayerMove = false;
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 5; j++) {
                    if (grid[i][j].getFill() == Color.GREEN) {
                        grid[i][j].setFill(Color.WHITE);
                    }
                }
            }


        }
        //checkValues(circlePos);
    }

    public void playerWin(ActionEvent event) throws IOException {


        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/endgame.fxml"));
        Parent root = loader2.load();
        EndGameController end = loader2.getController();

        end.setWinner(winner2);
        end.getPlayers(redNameLabel.getText(), blueNameLabel.getText());
        try (Handle handle = Main.jd.open()) {
            DataBase.uploadResultToDataBase(Main.jd, redNameLabel.getText(), blueNameLabel.getText(), winner2);
            dm = DataBase.getScoreBoard(handle);
        }
        end.setScoreBoard(dm);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Game Over");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void CheckPossibleMoves(int[][] circlePos) {
        MoveCheck.checkPossibleMove(lastX, lastY, circlePos, grid);
        Logger.info("The previous state of the table: \n%d %d %d %d\n%d %d %d %d\n%d %d %d %d\n%d %d %d %d\n%d %d %d %d".formatted(circlePos[0][0], circlePos[0][1], circlePos[0][2], circlePos[0][3],
                circlePos[1][0], circlePos[1][1], circlePos[1][2], circlePos[1][3],
                circlePos[2][0], circlePos[2][1], circlePos[2][2], circlePos[2][3],
                circlePos[3][0], circlePos[3][1], circlePos[3][2], circlePos[3][3],
                circlePos[4][0], circlePos[4][1], circlePos[4][2], circlePos[4][3]));
    }


    public boolean movePiece(Piece p, int[][] circlePos, int gridX, int gridY, int colorNumber, boolean movePlayer) {

        if ((p.getX() > 10 && p.getY() > 360) || (p.getX() > 400 && p.getY() > 20) || (circlePos[gridY][gridX] == 0 || circlePos[gridY][gridX] == 1 || circlePos[gridY][gridX] == 2) && (lastY - gridY > 1 || lastY - gridY < -1) || (lastX - gridX > 1 || lastX - gridX < -1) || (lastX - gridX > 0 && lastY - gridY > 0 || lastX - gridX < 0 && lastY - gridY > 0 || lastX - gridX < 0 && lastY - gridY < 0 || lastX - gridX > 0 && lastY - gridY < 0)) {
            p.setX((float) (squareSizeX / 2 + squareSizeX * lastX));
            p.setY((float) (squareSizeY / 2 + squareSizeY * lastY));
            p.draw();
            Logger.info("Not the right move");
        } else if (circlePos[gridY][gridX] == 2 || circlePos[gridY][gridX] == 1) {
            p.setX((float) (squareSizeX / 2 + squareSizeX * lastX));
            p.setY((float) (squareSizeY / 2 + squareSizeY * lastY));
            p.draw();
            Logger.info("There is a circle");
            whichPlayerMove = movePlayer;
        } else if (!movePlayer && colorNumber == 2) {
            p.setX((float) (squareSizeX / 2 + squareSizeX * lastX));
            p.setY((float) (squareSizeY / 2 + squareSizeY * lastY));
            p.draw();
            Logger.info("Blue player turn");
            whichPlayerMove = true;
        } else if (movePlayer && colorNumber == 1) {
            p.setX((float) (squareSizeX / 2 + squareSizeX * lastX));
            p.setY((float) (squareSizeY / 2 + squareSizeY * lastY));
            p.draw();
            Logger.info("Red player turn ");
            whichPlayerMove = false;
        } else {
            circlePos[gridY][gridX] = colorNumber;
            if (colorNumber == 1) {
                whichPlayerMove = false;
            }

            circlePos[lastY][lastX] = 0;
            p.setX((float) (squareSizeX / 2 + squareSizeX * gridX));
            p.setY((float) (squareSizeY / 2 + squareSizeY * gridY));
            p.draw();
            Logger.info("Good move");

        }
        return whichPlayerMove;
    }
}
