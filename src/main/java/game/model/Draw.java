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

    /*public static void DrawCircle(int counter, int plus, int plus2, ArrayList<Piece> pieces, Pane pane, int [][] adat, int squareSizeX,int squareSizeY,int lastX,int lastY, Rectangle[][] grid,boolean whichPlayerMove,boolean gameEnd,String winner2,Label blueNameLabel,Label redNameLabel,Button endGame){
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


                c.setOnMousePressed(event -> pressed(p,adat,lastX,lastY,squareSizeX,squareSizeY,grid));
                c.setOnMouseDragged(event -> dragged(event,p));
                c.setOnMouseReleased(event -> released(p,adat,c,squareSizeX,squareSizeY,lastX,lastY,whichPlayerMove,gameEnd,grid,winner2,blueNameLabel,redNameLabel,endGame));

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


                 c.setOnMousePressed(event -> pressed(p,adat,lastX,lastY,squareSizeX,squareSizeY,grid));
                 c.setOnMouseDragged(event -> dragged(event,p));
                 c.setOnMouseReleased(event -> released(p,adat,c,squareSizeX,squareSizeY,lastX,lastY,whichPlayerMove,gameEnd,grid,winner2,blueNameLabel,redNameLabel,endGame));

                Logger.info(pieces.get(i).getX()+"  "+ pieces.get(i).getY());

                pane.getChildren().add(c);
                p.draw();
                plus2=plus2+100;
            }

            counter++;
        }
    }


    public static void pressed(Piece p, int[][] adat,int lastX, int lastY, int squareSizeX,int squareSizeY, Rectangle[][] grid) {
        lastX=(int)p.getX() / squareSizeX;
        lastY=(int)p.getY() / squareSizeY;
        System.out.println(lastX+" "+lastY);


        if(lastY==0){
            grid[lastX][lastY+1].setFill(Color.GREEN);
            if(lastX<3 && lastX!=0){
                if(adat[lastY][lastX-1]==0){
                    grid[lastX-1][lastY].setFill(Color.GREEN);
                }
                if(adat[lastY][lastX+1]==0){
                    grid[lastX+1][lastY].setFill(Color.GREEN);
                }
            }else if(lastX==0){
                if(adat[lastY][lastX+1]==0){
                    grid[lastX+1][lastY].setFill(Color.GREEN);
                }
            }
            if(lastX==3){
                if(adat[lastY][lastX-1]==0)
                    grid[lastX-1][lastY].setFill(Color.GREEN);
            }

        }
        else if(lastX==0){
            if (adat[lastY - 1][lastX] == 0) {
                grid[lastX][lastY - 1].setFill(Color.GREEN);
                if (adat[lastY][lastX + 1] == 0) {
                    grid[lastX + 1][lastY].setFill(Color.GREEN);
                }
            }
            if(lastY<3){
                if (adat[lastY+1][lastX] == 0) {
                    grid[lastX][lastY - 1].setFill(Color.GREEN);
                    if (adat[lastY][lastX + 1] == 0) {
                        grid[lastX + 1][lastY].setFill(Color.GREEN);
                    }
                }
            }
            if(lastY<4) {
                if (adat[lastY + 1][lastX] == 0) {
                    grid[lastX][lastY + 1].setFill(Color.GREEN);
                }
            }
        }
        else if(lastY==4){
            if (adat[lastY][lastX - 1] == 0 && adat[lastY - 1][lastX] == 0) {
                grid[lastX][lastY - 1].setFill(Color.GREEN);
                grid[lastX - 1][lastY].setFill(Color.GREEN);
                if (lastX < 3 && adat[lastY][lastX + 1] == 0) {
                    grid[lastX + 1][lastY].setFill(Color.GREEN);
                }
            }
            else if(adat[lastY - 1][lastX] == 0) {
                grid[lastX][lastY - 1].setFill(Color.GREEN);
            }
            if(adat[lastY][lastX-1] == 0){
                grid[lastX-1][lastY].setFill(Color.GREEN);
            }
        }
        else if(adat[lastY-1][lastX]==0 ){
            grid[lastX][lastY-1].setFill(Color.GREEN);
            if(adat[lastY][lastX-1]==0 ) {
                grid[lastX - 1][lastY].setFill(Color.GREEN);
            }
            if(lastY<4){
                if(adat[lastY+1][lastX]==0){
                    grid[lastX][lastY+1].setFill(Color.GREEN);
                }
            }
        }
        else if(adat[lastY-1][lastX]==0 ) {
            grid[lastX][lastY +1].setFill(Color.GREEN);
            if (adat[lastY][lastX - 1] == 0) {//Ezt még csekkolni kell hogy kell-e
                grid[lastX - 1][lastY].setFill(Color.GREEN);
            }
            if (lastY < 4) {
                if (adat[lastY + 1][lastX] == 0) {
                    grid[lastX][lastY + 1].setFill(Color.GREEN);
                }
            }
        }
        if(lastX<3 && lastX>0) {
            if (adat[lastY][lastX + 1] == 0) {
                grid[lastX + 1][lastY].setFill(Color.GREEN);
                if(lastY<3) {
                    if (adat[lastY + 1][lastX] == 0) {
                        grid[lastX][lastY + 1].setFill(Color.GREEN);
                    }
                    if(lastY>1) {
                        if (adat[lastY - 1][lastX] == 0) {
                            grid[lastX][lastY - 1].setFill(Color.GREEN);
                        }
                    }
                }
                if(adat[lastY][lastX-1] == 0){
                    grid[lastX-1][lastY].setFill(Color.GREEN);
                }
            }
        }
        if(lastX==3 && lastY<=3){
            if(adat[lastY+1][lastX] == 0){
                grid[lastX][lastY+1].setFill(Color.GREEN);
            }
            if(adat[lastY][lastX-1] == 0){
                grid[lastX-1][lastY].setFill(Color.GREEN);
            }
        }
        if(lastY<4){
            if(adat[lastY+1][lastX] == 0){
                grid[lastX][lastY+1].setFill(Color.GREEN);
            }
            if(lastX>0 && adat[lastY][lastX-1] == 0){
                grid[lastX-1][lastY].setFill(Color.GREEN);
            }
        }

        Logger.info("A tábla jelenlegi állapota\n"+ adat[0][0]+" "+adat[0][1]+" "+adat[0][2]+" "+adat[0][3]+"\n"+adat[1][0]+" "+adat[1][1]+" "+adat[1][2]+" "+adat[1][3]+"\n"+
                adat[2][0]+" "+adat[2][1]+" "+adat[2][2]+" "+adat[2][3]+"\n"+adat[3][0]+" "+adat[3][1]+" "+adat[3][2]+" "+adat[3][3]+"\n"+
                adat[4][0]+" "+adat[4][1]+" "+adat[4][2]+" "+adat[4][3]);


        Logger.info("LAST: "+lastX+"  "+lastY);
    }

    public static void dragged(MouseEvent event, Piece p){
        p.setX(p.getX()+event.getX());
        p.setY(p.getY()+event.getY());

        p.draw();
    }

    public static void released(Piece p, int[][] adat, Circle c, int squareSizeX,int squareSizeY, int lastX, int lastY, boolean whichPlayerMove, boolean gameEnd, Rectangle[][] grid,String winner2,Label blueNameLabel,Label redNameLabel,Button endGame){
        int gridx =(int)p.getX() / squareSizeX;
        int gridy =(int)p.getY() / squareSizeY;

        Color colorRed = Color.INDIANRED;
        Color colorBlue = Color.CADETBLUE;
        int redNumber=2;
        int blueNumber=1;

        try{
            if(c.getFill()==Color.RED && whichPlayerMove==false && gameEnd == false){

                whichPlayerMove=MoveCheck.movePiece(p,adat,gridx,gridy,squareSizeX,squareSizeY,lastX,lastY,grid,colorRed,redNumber,false);
                MoveCheck.movePiece(p,adat,gridx,gridy,squareSizeX,squareSizeY,lastX,lastY,grid,colorRed,redNumber,whichPlayerMove);
            }else if(c.getFill()==Color.BLUE && whichPlayerMove==true && gameEnd == false){

                whichPlayerMove=MoveCheck.movePiece(p,adat,gridx,gridy,squareSizeX,squareSizeY,lastX,lastY,grid,colorBlue,blueNumber,true);
                MoveCheck.movePiece(p,adat,gridx,gridy,squareSizeX,squareSizeY,lastX,lastY,grid,colorBlue,blueNumber,whichPlayerMove);
            }else{
                p.setX((float)(squareSizeX/2 +squareSizeX*lastX));
                p.setY((float)(squareSizeY/2 +squareSizeY*lastY));
                p.draw();
                Logger.info("Vissza rakom mert nem jó a lépés");
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

        checkValues(adat,winner2,blueNameLabel,redNameLabel,gameEnd,endGame);

    }

    public static void checkValues(int [][] adat, String winner2,Label blueNameLabel,Label redNameLabel,boolean gameEnd,Button endGame){
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
        }
        else if(color == 2){
            Logger.info("Játék vége Piros játékos győzött");
            winner2=redNameLabel.getText();
            System.out.println(winner2);
            gameEnd=true;
            endGame.setVisible(true);

        }
    }

}
*/
}