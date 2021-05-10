package game;

import game.model.*;
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

public class DrawBoard {

    @FXML
    Pane pane;

    @FXML
    Label moveText,endText;


    List<DataModel> dm;
    private Stage stage;
    private Scene scene;
    private Parent root;

    private final int  size=400;

    private final int squareSizeX = size/4;
    private final int squareSizeY = size/5;

    private Rectangle[][] grid;

    private final int [][] adat= new int [5][4];
    int lastX=0;
    int lastY=0;

    boolean whichPlayerMove = false;
    boolean gameEnd=false;

    private String winner2="";
    //public Jdbi scoreBoard;

    @FXML
    Label redNameLabel,blueNameLabel;

    @FXML
    Button endGame;

    public void setRedName(String redName) {
        redNameLabel.setText(redName);
    }

    public void setBlueName(String blueName){
        blueNameLabel.setText(blueName);
    }


    @FXML
    public void initialize(){
        endGame.setVisible(false);
        endText.setVisible(false);
        grid= new Rectangle[4][5];

        Draw.DrawTable(grid, size, squareSizeX, squareSizeY, pane);
        ArrayList<Piece> pieces = new ArrayList<Piece>();
        int plus=0;
        int counter =1;
        int plus2=0;

        for (int i = 0; i <8 ; i++) {
            Circle c=new Circle();
            Piece p;

            double radius = squareSizeX/4.0;

            if(counter<=4){
                if(counter%2==0){
                    c.setStroke(Color.BLACK);
                    c.setFill(Color.RED);
                }else{
                    c.setStroke(Color.BLACK);
                    c.setFill(Color.BLUE);
                }

                p= new Piece(50+plus,40,radius,c);
                pieces.add(p);


                c.setOnMousePressed(event -> pressed(p,adat,c,whichPlayerMove));
                c.setOnMouseDragged(event -> dragged(event,p,c,whichPlayerMove));
                c.setOnMouseReleased(event -> released(p,adat,c));

                System.out.println(pieces.get(i).getX()+"  "+ pieces.get(i).getY());

                pane.getChildren().add(c);
                p.draw();
                plus=plus+100;
            }else{

                if(counter%2==0){
                    c.setStroke(Color.BLACK);
                    c.setFill(Color.BLUE);
                }else{
                    c.setStroke(Color.BLACK);
                    c.setFill(Color.RED);
                }

                p= new Piece(50+plus2,40+320,radius,c);
                pieces.add(p);

                c.setOnMousePressed(event -> pressed(p,adat,c,whichPlayerMove));
                c.setOnMouseDragged(event -> dragged(event,p,c,whichPlayerMove));
                c.setOnMouseReleased(event -> released(p,adat,c));

                Logger.info(pieces.get(i).getX()+"  "+ pieces.get(i).getY());

                pane.getChildren().add(c);
                p.draw();
                plus2=plus2+100;
            }

            counter++;
        }

        MoveCheck.uploadList(adat);

    }

    public void checkValues(int [][] adat){
        int color=0; //1--kék, 2--piros
        int blueColor=1;
        int redColor=2;

        if(MoveCheck.checkData(adat,blueColor)==1){
            color=1;
        }else if(MoveCheck.checkData(adat,redColor)==2){
            color=2;
        }

        if(color==1){
            Logger.info("Játék vége Kék játékos győzött");
            winner2=blueNameLabel.getText();
            System.out.println(winner2);
            gameEnd=true;
            endGame.setVisible(true);
            endText.setVisible(true);
            endText.setText("Kék játékos nyert");
            pane.setVisible(false);
            moveText.setVisible(false);
        }
        else if(color == 2){
            Logger.info("Játék vége Piros játékos győzött");
            winner2=redNameLabel.getText();
            System.out.println(winner2);
            gameEnd=true;
            endGame.setVisible(true);
            endText.setVisible(true);
            endText.setText("Piros játékos nyert");
            pane.setVisible(false);
            moveText.setVisible(false);
        }
    }


    public void pressed(Piece p,int [][] adat, Circle c, boolean whichPlayerMove) {
        lastX=(int)p.getX() / squareSizeX;
        lastY=(int)p.getY() / squareSizeY;
        System.out.println(lastX+" "+lastY);

        if(c.getFill() == Color.RED && !whichPlayerMove) {
            MoveCheck.checkPossibleMove(lastX, lastY, adat, grid);
            Logger.info("A tábla jelenlegi állapota\n"+ adat[0][0]+" "+adat[0][1]+" "+adat[0][2]+" "+adat[0][3]+"\n"+adat[1][0]+" "+adat[1][1]+" "+adat[1][2]+" "+adat[1][3]+"\n"+
                    adat[2][0]+" "+adat[2][1]+" "+adat[2][2]+" "+adat[2][3]+"\n"+adat[3][0]+" "+adat[3][1]+" "+adat[3][2]+" "+adat[3][3]+"\n"+
                    adat[4][0]+" "+adat[4][1]+" "+adat[4][2]+" "+adat[4][3]);
        }else if(c.getFill() == Color.BLUE && whichPlayerMove){
            MoveCheck.checkPossibleMove(lastX, lastY, adat, grid);

            Logger.info("A tábla jelenlegi állapota\n"+ adat[0][0]+" "+adat[0][1]+" "+adat[0][2]+" "+adat[0][3]+"\n"+adat[1][0]+" "+adat[1][1]+" "+adat[1][2]+" "+adat[1][3]+"\n"+
                    adat[2][0]+" "+adat[2][1]+" "+adat[2][2]+" "+adat[2][3]+"\n"+adat[3][0]+" "+adat[3][1]+" "+adat[3][2]+" "+adat[3][3]+"\n"+
                    adat[4][0]+" "+adat[4][1]+" "+adat[4][2]+" "+adat[4][3]);
        }else{
            Logger.info("Nem jó játékos lép");
        }



        Logger.info("LAST: "+lastX+"  "+lastY);
    }

    public void dragged(MouseEvent event, Piece p, Circle c, boolean whichPlayerMove){

        if(c.getFill() == Color.RED && !whichPlayerMove){
            p.setX(p.getX()+event.getX());
            p.setY(p.getY()+event.getY());
            p.draw();
        }
        else if(c.getFill() == Color.BLUE && whichPlayerMove){
            p.setX(p.getX()+event.getX());
            p.setY(p.getY()+event.getY());
            p.draw();
        }else{
            Logger.info("Nem jó játékos lép");
        }



    }

    public void released( Piece p,int [][] adat,Circle c){
        int gridx =(int)p.getX() / squareSizeX;
        int gridy =(int)p.getY() / squareSizeY;

        int redNumber=2;
        int blueNumber=1;

        try{
            if(c.getFill()==Color.RED && !whichPlayerMove&& !gameEnd){

                whichPlayerMove=MoveCheck.movePiece(p,adat,gridx,gridy,squareSizeX,squareSizeY,lastX,lastY,redNumber,false);
                MoveCheck.movePiece(p,adat,gridx,gridy,squareSizeX,squareSizeY,lastX,lastY,redNumber,whichPlayerMove);
            }else if(c.getFill()==Color.BLUE && whichPlayerMove && !gameEnd){

                whichPlayerMove=MoveCheck.movePiece(p,adat,gridx,gridy,squareSizeX,squareSizeY,lastX,lastY,blueNumber,true);
                MoveCheck.movePiece(p,adat,gridx,gridy,squareSizeX,squareSizeY,lastX,lastY,blueNumber,whichPlayerMove);
            }else{
                p.setX((float)(squareSizeX/2 +squareSizeX*lastX));
                p.setY((float)(squareSizeY/2 +squareSizeY*lastY));
                p.draw();
                Logger.info("Vissza rakom mert nem jó a lépés");
            }

            if(!whichPlayerMove){
                moveText.setText("Piros játékos jön");
            }else{
                moveText.setText("Kék játékos jön");
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 5; j++) {
                    if(grid[i][j].getFill()==Color.GREEN){
                        grid[i][j].setFill(Color.WHITE);
                    }
                }

            }

        }catch(Exception e){
            Logger.warn("Hiba:"+e);
        }

        checkValues(adat);

    }

    public void playerWin(ActionEvent event) throws IOException {


        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/endgame.fxml"));
        root = loader2.load();
        EndGameControl end = loader2.getController();

        end.setWinner(winner2);
        end.getPlayer(redNameLabel.getText(),blueNameLabel.getText());

        try (Handle handle = Main.jd.open()){
            DataBase.uploadResultToDataBase(Main.jd,redNameLabel.getText(),blueNameLabel.getText(),winner2);
            dm = DataBase.getScoreBoard(handle);
        }
        end.setScoreBoard(dm);



        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Játék vége");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
