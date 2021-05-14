package game.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.tinylog.Logger;

/**
 * Check the player moves and which player win the game
 */

public class MoveCheck {

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
            colorName="Red";
        }
        else if(colorNumber == 1){
            colorName="Blue";
        }
        else{
            colorName="There is no such color";
        }

        if((circlePos[0][0]==colorNumber && circlePos[1][0]==colorNumber && circlePos[2][0]==colorNumber) || (circlePos[1][0]==colorNumber && circlePos[2][0]==colorNumber && circlePos[3][0]==colorNumber) || (circlePos[2][0]==colorNumber && circlePos[3][0]==colorNumber && circlePos[4][0]==colorNumber)){
            color=colorNumber;
            Logger.info( colorName +" wins");
        }
        else if((circlePos[0][1]==colorNumber && circlePos[1][1]==colorNumber && circlePos[2][1]==colorNumber) || (circlePos[1][1]==colorNumber && circlePos[2][1]==colorNumber && circlePos[3][1]==colorNumber) || (circlePos[2][1]==2 && circlePos[3][1]==colorNumber && circlePos[4][1]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" wins");
        }
        else if((circlePos[0][2]==colorNumber && circlePos[1][2]==colorNumber && circlePos[2][2]==colorNumber) || (circlePos[1][2]==colorNumber && circlePos[2][2]==colorNumber && circlePos[3][2]==colorNumber) || (circlePos[2][2]==colorNumber && circlePos[3][2]==colorNumber && circlePos[4][2]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" wins");
        }
        else if((circlePos[0][3]==colorNumber && circlePos[1][3]==colorNumber && circlePos[2][3]==colorNumber) || (circlePos[1][3]==colorNumber && circlePos[2][3]==colorNumber && circlePos[3][3]==colorNumber) || (circlePos[2][3]==colorNumber && circlePos[3][3]==colorNumber && circlePos[4][3]==colorNumber)){
            color=colorNumber;
            System.out.println(colorName +" wins");
        }
        else if((circlePos[0][0]==colorNumber && circlePos[0][1]==colorNumber && circlePos[0][2]==colorNumber) || (circlePos[0][1]==colorNumber && circlePos[0][2]==colorNumber && circlePos[0][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" wins");
        }
        else if((circlePos[1][0]==colorNumber && circlePos[1][1]==colorNumber && circlePos[1][2]==colorNumber) || (circlePos[1][1]==colorNumber && circlePos[1][2]==colorNumber && circlePos[1][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" wins");
        }
        else if((circlePos[2][0]==colorNumber && circlePos[2][1]==colorNumber && circlePos[2][2]==colorNumber) || (circlePos[2][1]==colorNumber && circlePos[2][2]==colorNumber && circlePos[2][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" wins");
        }
        else if((circlePos[3][0]==colorNumber && circlePos[3][1]==colorNumber && circlePos[3][2]==colorNumber) || (circlePos[3][1]==colorNumber && circlePos[3][2]==colorNumber && circlePos[3][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" wins");
        }
        else if((circlePos[4][0]==colorNumber && circlePos[4][1]==colorNumber && circlePos[4][2]==colorNumber) || (circlePos[4][1]==colorNumber && circlePos[4][2]==colorNumber && circlePos[4][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" wins");
        }
        else if((circlePos[0][0]==colorNumber && circlePos[1][1]==colorNumber && circlePos[2][2]==colorNumber) || (circlePos[1][1]==colorNumber && circlePos[2][2]==colorNumber && circlePos[3][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" wins");
        }
        else if((circlePos[0][1]==colorNumber && circlePos[1][2]==colorNumber && circlePos[2][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" wins");
        }
        else if((circlePos[0][2]==colorNumber && circlePos[1][1]==colorNumber && circlePos[2][0]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" wins");
        }
        else if((circlePos[0][3]==colorNumber && circlePos[1][2]==colorNumber && circlePos[2][1]==colorNumber) || (circlePos[1][2]==colorNumber && circlePos[2][1]==colorNumber && circlePos[3][0]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" wins");
        }
        else if((circlePos[1][0]==colorNumber && circlePos[2][1]==colorNumber && circlePos[3][2]==colorNumber) || (circlePos[2][1]==colorNumber && circlePos[3][2]==colorNumber && circlePos[4][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName+" wins");//Red
        }
        else if((circlePos[1][3]==colorNumber && circlePos[2][2]==colorNumber && circlePos[3][1]==colorNumber) || (circlePos[2][2]==colorNumber && circlePos[3][1]==colorNumber && circlePos[4][0]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" wins");
        }
        else if((circlePos[2][0]==colorNumber && circlePos[3][1]==colorNumber && circlePos[4][2]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" wins");
        }
        else if((circlePos[2][3]==colorNumber && circlePos[3][2]==colorNumber && circlePos[4][1]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" wins");
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

        Logger.info("The current state of the table: \n"+ circlePos[0][0]+" "+circlePos[0][1]+" "+circlePos[0][2]+" "+circlePos[0][3]+"\n"+circlePos[1][0]+" "+circlePos[1][1]+" "+circlePos[1][2]+" "+circlePos[1][3]+"\n"+
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
