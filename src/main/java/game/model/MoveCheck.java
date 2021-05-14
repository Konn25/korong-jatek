package game.model;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.tinylog.Logger;

/**
 * Check the player moves and which player win the game
 */

public class MoveCheck {


    /**
     *  Check circle where can put
     * @param p a Piece type
     * @param circlePos store the circles position
     * @param gridx the grid X axis position
     * @param gridy the grid Y axis position
     * @param squareSizeX X axis square number
     * @param squareSizeY Y axis square number
     * @param lastX the circle last X position
     * @param lastY the circle last Y position
     * @param colorNumber the color number 1 is blue, number 2 is red
     * @param movePlayer if it is false red player can move else the blue player can move
     * @return a boolean, which player can move next
     */
    public static boolean movePiece(Piece p, int [][] circlePos, int gridx, int gridy, int squareSizeX, int squareSizeY, int lastX, int lastY,  int colorNumber, boolean movePlayer){
        boolean whichPlayerMove=false;

        if((p.getX()>40 && p.getY()>360)||(p.getX()>400 && p.getY()>20)||(circlePos[gridy][gridx]==0 || circlePos[gridy][gridx]==1 || circlePos[gridy][gridx]==2)&&( lastY-gridy>1 || lastY-gridy<-1) || ( lastX-gridx>1 || lastX-gridx<-1) ||(lastX-gridx>0 && lastY-gridy>0 || lastX-gridx<0 && lastY-gridy>0 || lastX-gridx<0 && lastY-gridy<0 || lastX-gridx>0 && lastY-gridy<0)){
            p.setX((float)(squareSizeX/2 +squareSizeX*lastX));
            p.setY((float)(squareSizeY/2 +squareSizeY*lastY));
            p.draw();
            Logger.info("Nem megfelelő a lépés");
            whichPlayerMove=movePlayer;

        }else if(circlePos[gridy][gridx]==2 || circlePos[gridy][gridx]==1){
            p.setX((float)(squareSizeX/2 +squareSizeX*lastX));
            p.setY((float)(squareSizeY/2 +squareSizeY*lastY));
            p.draw();
            Logger.info("Nem jó van ott egy korong");
            whichPlayerMove=movePlayer;
        }
        else if(!movePlayer && colorNumber==2){
            p.setX((float)(squareSizeX/2 +squareSizeX*lastX));
            p.setY((float)(squareSizeY/2 +squareSizeY*lastY));
            p.draw();
            Logger.info("Kék játékos jön ");
            whichPlayerMove=true;
        }
        else if(movePlayer && colorNumber==1){
            p.setX((float)(squareSizeX/2 +squareSizeX*lastX));
            p.setY((float)(squareSizeY/2 +squareSizeY*lastY));
            p.draw();
            Logger.info("Piros játékos jön ");
            whichPlayerMove=false;
        }
        else{

            circlePos[gridy][gridx]=colorNumber;
            if(colorNumber==1){
                whichPlayerMove=true;
            }

            circlePos[lastY][lastX]=0;
            p.setX((float)(squareSizeX/2 +squareSizeX*gridx));
            p.setY((float)(squareSizeY/2 +squareSizeY*gridy));
            p.draw();
            Logger.info("Megfelelő lépés");

        }
        return whichPlayerMove;
    }

    /**
     * Check which player win
     * @param circlePos store the circles position
     * @param colorNumber the color number 1 is blue, number 2 is red
     * @return a color number which can be number 1  and 2, number 1 is blue, number 2 is red
     */
    public static int checkData(int [][] circlePos,int colorNumber){

        int color =0;
        String colorName;

        if(colorNumber == 2){
            colorName="Piros";
        }
        else if(colorNumber == 1){
            colorName="Kék";
        }
        else{
            colorName="Nincs ilyen szín";
        }

        if((circlePos[0][0]==colorNumber && circlePos[1][0]==colorNumber && circlePos[2][0]==colorNumber) || (circlePos[1][0]==colorNumber && circlePos[2][0]==colorNumber && circlePos[3][0]==colorNumber) || (circlePos[2][0]==colorNumber && circlePos[3][0]==colorNumber && circlePos[4][0]==colorNumber)){
            color=colorNumber;
            Logger.info( colorName +" győz");
        }
        else if((circlePos[0][1]==colorNumber && circlePos[1][1]==colorNumber && circlePos[2][1]==colorNumber) || (circlePos[1][1]==colorNumber && circlePos[2][1]==colorNumber && circlePos[3][1]==colorNumber) || (circlePos[2][1]==2 && circlePos[3][1]==colorNumber && circlePos[4][1]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((circlePos[0][2]==colorNumber && circlePos[1][2]==colorNumber && circlePos[2][2]==colorNumber) || (circlePos[1][2]==colorNumber && circlePos[2][2]==colorNumber && circlePos[3][2]==colorNumber) || (circlePos[2][2]==colorNumber && circlePos[3][2]==colorNumber && circlePos[4][2]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((circlePos[0][3]==colorNumber && circlePos[1][3]==colorNumber && circlePos[2][3]==colorNumber) || (circlePos[1][3]==colorNumber && circlePos[2][3]==colorNumber && circlePos[3][3]==colorNumber) || (circlePos[2][3]==colorNumber && circlePos[3][3]==colorNumber && circlePos[4][3]==colorNumber)){
            color=colorNumber;
            System.out.println(colorName +" győz");
        }
        else if((circlePos[0][0]==colorNumber && circlePos[0][1]==colorNumber && circlePos[0][2]==colorNumber) || (circlePos[0][1]==colorNumber && circlePos[0][2]==colorNumber && circlePos[0][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((circlePos[1][0]==colorNumber && circlePos[1][1]==colorNumber && circlePos[1][2]==colorNumber) || (circlePos[1][1]==colorNumber && circlePos[1][2]==colorNumber && circlePos[1][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((circlePos[2][0]==colorNumber && circlePos[2][1]==colorNumber && circlePos[2][2]==colorNumber) || (circlePos[2][1]==colorNumber && circlePos[2][2]==colorNumber && circlePos[2][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((circlePos[3][0]==colorNumber && circlePos[3][1]==colorNumber && circlePos[3][2]==colorNumber) || (circlePos[3][1]==colorNumber && circlePos[3][2]==colorNumber && circlePos[3][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((circlePos[4][0]==colorNumber && circlePos[4][1]==colorNumber && circlePos[4][2]==colorNumber) || (circlePos[4][1]==colorNumber && circlePos[4][2]==colorNumber && circlePos[4][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((circlePos[0][0]==colorNumber && circlePos[1][1]==colorNumber && circlePos[2][2]==colorNumber) || (circlePos[1][1]==colorNumber && circlePos[2][2]==colorNumber && circlePos[3][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((circlePos[0][1]==colorNumber && circlePos[1][2]==colorNumber && circlePos[2][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((circlePos[0][2]==colorNumber && circlePos[1][1]==colorNumber && circlePos[2][0]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((circlePos[0][3]==colorNumber && circlePos[1][2]==colorNumber && circlePos[2][1]==colorNumber) || (circlePos[1][2]==colorNumber && circlePos[2][1]==colorNumber && circlePos[3][0]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((circlePos[1][0]==colorNumber && circlePos[2][1]==colorNumber && circlePos[3][2]==colorNumber) || (circlePos[2][1]==colorNumber && circlePos[3][2]==colorNumber && circlePos[4][3]==colorNumber)){
            color=colorNumber;
            Logger.info("Piros győz");
        }
        else if((circlePos[1][3]==colorNumber && circlePos[2][2]==colorNumber && circlePos[3][1]==colorNumber) || (circlePos[2][2]==colorNumber && circlePos[3][1]==colorNumber && circlePos[4][0]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((circlePos[2][0]==colorNumber && circlePos[3][1]==colorNumber && circlePos[4][2]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((circlePos[2][3]==colorNumber && circlePos[3][2]==colorNumber && circlePos[4][1]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }

        return color;
    }


    /**
     * * Upload the matrix with starting position
     * @param circlePos store the circles position
     */
    public static void uploadList(int[][] circlePos){

        circlePos[0][0]=1;
        circlePos[0][1]=2;
        circlePos[0][2]=1;
        circlePos[0][3]=2;

        circlePos[1][0]=0;
        circlePos[1][1]=0;
        circlePos[1][2]=0;
        circlePos[1][3]=0;

        circlePos[2][0]=0;
        circlePos[2][1]=0;
        circlePos[2][2]=0;
        circlePos[2][3]=0;

        circlePos[3][0]=0;
        circlePos[3][1]=0;
        circlePos[3][2]=0;
        circlePos[3][3]=0;

        circlePos[4][0]=2;
        circlePos[4][1]=1;
        circlePos[4][2]=2;
        circlePos[4][3]=1;

        Logger.info("A tábla jelenlegi állapota\n"+ circlePos[0][0]+" "+circlePos[0][1]+" "+circlePos[0][2]+" "+circlePos[0][3]+"\n"+circlePos[1][0]+" "+circlePos[1][1]+" "+circlePos[1][2]+" "+circlePos[1][3]+"\n"+
        circlePos[2][0]+" "+circlePos[2][1]+" "+circlePos[2][2]+" "+circlePos[2][3]+"\n"+circlePos[3][0]+" "+circlePos[3][1]+" "+circlePos[3][2]+" "+circlePos[3][3]+"\n"+
        circlePos[4][0]+" "+circlePos[4][1]+" "+circlePos[4][2]+" "+circlePos[4][3]);
    }

    /**
     * Check possible moves and fill it with green color
     * @param lastX the circle last X position
     * @param lastY the circle last Y position
     * @param circlePos store the circles position
     * @param grid store the board's grid number
     */
   public static void checkPossibleMove(int lastX,int lastY,int [][] circlePos, Rectangle[][] grid){
       if(lastY==0){
           if(circlePos[lastY+1][lastX]==0) {
               grid[lastX][lastY + 1].setFill(Color.GREEN);
           }
           if(lastX<3 && lastX!=0){
               if(circlePos[lastY][lastX-1]==0){
                   grid[lastX-1][lastY].setFill(Color.GREEN);
               }
               if(circlePos[lastY][lastX+1]==0){
                   grid[lastX+1][lastY].setFill(Color.GREEN);
               }
           }else if(lastX==0){
               if(circlePos[lastY][lastX+1]==0){
                   grid[lastX+1][lastY].setFill(Color.GREEN);
               }
           }
           if(lastX==3){
               if(circlePos[lastY][lastX-1]==0)
                   grid[lastX-1][lastY].setFill(Color.GREEN);
           }

       }
       else if(lastX==0){
           if (circlePos[lastY - 1][lastX] == 0) {
               grid[lastX][lastY - 1].setFill(Color.GREEN);
               if (circlePos[lastY][lastX + 1] == 0) {
                   grid[lastX + 1][lastY].setFill(Color.GREEN);
               }
           }
           if (circlePos[lastY][lastX + 1] == 0) {
               grid[lastX + 1][lastY].setFill(Color.GREEN);
           }
           if(lastY<3){
               if (circlePos[lastY+1][lastX] == 0) {
                   grid[lastX][lastY +1].setFill(Color.GREEN);
                   if (circlePos[lastY][lastX + 1] == 0) {
                       grid[lastX + 1][lastY].setFill(Color.GREEN);
                   }
               }
           }
       }
       else if(lastY==4){
           if (circlePos[lastY][lastX - 1] == 0 && circlePos[lastY - 1][lastX] == 0) {
               grid[lastX][lastY - 1].setFill(Color.GREEN);
               grid[lastX - 1][lastY].setFill(Color.GREEN);
               if (lastX < 3 && circlePos[lastY][lastX + 1] == 0) {
                   grid[lastX + 1][lastY].setFill(Color.GREEN);
               }
           }
           else if(circlePos[lastY - 1][lastX] == 0) {
               grid[lastX][lastY - 1].setFill(Color.GREEN);
           }
           if(circlePos[lastY][lastX-1] == 0){
               grid[lastX-1][lastY].setFill(Color.GREEN);
           }
       }
       else if(circlePos[lastY-1][lastX]==0 ){
           grid[lastX][lastY-1].setFill(Color.GREEN);
           if(circlePos[lastY][lastX-1]==0 ) {
               grid[lastX - 1][lastY].setFill(Color.GREEN);
           }
           if(lastY<4){
               if(circlePos[lastY+1][lastX]==0){
                   grid[lastX][lastY+1].setFill(Color.GREEN);
               }
           }
       }
       if(lastX<3 && lastX>0) {
           if (circlePos[lastY][lastX + 1] == 0) {
               grid[lastX + 1][lastY].setFill(Color.GREEN);
               if(lastY<3) {
                   if (circlePos[lastY + 1][lastX] == 0) {
                       grid[lastX][lastY + 1].setFill(Color.GREEN);
                   }
                   if(lastY>1) {
                       if (circlePos[lastY - 1][lastX] == 0) {
                           grid[lastX][lastY - 1].setFill(Color.GREEN);
                       }
                   }
               }
               if(circlePos[lastY][lastX-1] == 0){
                   grid[lastX-1][lastY].setFill(Color.GREEN);
               }
           }
       }
       if(lastX == 3 && lastY<=3){
           if(circlePos[lastY+1][lastX] == 0){
               grid[lastX][lastY+1].setFill(Color.GREEN);
           }
           if(circlePos[lastY][lastX-1] == 0){
               grid[lastX-1][lastY].setFill(Color.GREEN);
           }
       }
       if(lastY<4){
           if(circlePos[lastY+1][lastX] == 0){
               grid[lastX][lastY+1].setFill(Color.GREEN);
           }
           if(lastX>0 && circlePos[lastY][lastX-1] == 0){
               grid[lastX-1][lastY].setFill(Color.GREEN);
           }
       }

   }

}
