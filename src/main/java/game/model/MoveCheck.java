package game.model;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.tinylog.Logger;


public class MoveCheck {

    public static boolean movePiece(Piece p, int [][] adat, int gridx, int gridy, int squareSizeX, int squareSizeY, int lastX, int lastY, Rectangle[][] grid, Color color, int colorNumber, boolean movePlayer){
        boolean whichPlayerMove=false;

        if((p.getX()>40 && p.getY()>360)||(p.getX()>400 && p.getY()>20)||(adat[gridy][gridx]==0 || adat[gridy][gridx]==1 || adat[gridy][gridx]==2)&&( lastY-gridy>1 || lastY-gridy<-1) || ( lastX-gridx>1 || lastX-gridx<-1) ||(lastX-gridx>0 && lastY-gridy>0 || lastX-gridx<0 && lastY-gridy>0 || lastX-gridx<0 && lastY-gridy<0 || lastX-gridx>0 && lastY-gridy<0)){
            p.setX((float)(squareSizeX/2 +squareSizeX*lastX));
            p.setY((float)(squareSizeY/2 +squareSizeY*lastY));
            p.draw();
            Logger.info("Nem megfelelő a lépés");
            whichPlayerMove=movePlayer;

        }else if(adat[gridy][gridx]==2 || adat[gridy][gridx]==1){
            p.setX((float)(squareSizeX/2 +squareSizeX*lastX));
            p.setY((float)(squareSizeY/2 +squareSizeY*lastY));
            p.draw();
            Logger.info("Nem jó van ott egy korong");
            whichPlayerMove=movePlayer;
        }
        else if(!movePlayer && colorNumber==2){//false
            p.setX((float)(squareSizeX/2 +squareSizeX*lastX));
            p.setY((float)(squareSizeY/2 +squareSizeY*lastY));
            p.draw();
            Logger.info("Kék játékos jön ");
            whichPlayerMove=true;
        }
        else if(movePlayer && colorNumber==1){//true
            p.setX((float)(squareSizeX/2 +squareSizeX*lastX));
            p.setY((float)(squareSizeY/2 +squareSizeY*lastY));
            p.draw();
            Logger.info("Piros játékos jön ");
            whichPlayerMove=false;
        }
        else{

            adat[gridy][gridx]=colorNumber;
            if(colorNumber==1){
                whichPlayerMove=true;
            }

            adat[lastY][lastX]=0;
            grid[gridx][gridy].setFill(color);
            p.setX((float)(squareSizeX/2 +squareSizeX*gridx));
            p.setY((float)(squareSizeY/2 +squareSizeY*gridy));
            p.draw();
            Logger.info("Megfelelő lépés");

        }
        return whichPlayerMove;
    }

    public static int checkData(int [][] adat,int colorNumber){

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

        if((adat[0][0]==colorNumber && adat[1][0]==colorNumber && adat[2][0]==colorNumber) || (adat[1][0]==colorNumber && adat[2][0]==colorNumber && adat[3][0]==colorNumber) || (adat[2][0]==colorNumber && adat[3][0]==colorNumber && adat[4][0]==colorNumber)){
            color=colorNumber;
            Logger.info( colorName +" győz");
        }
        else if((adat[0][1]==colorNumber && adat[1][1]==colorNumber && adat[2][1]==colorNumber) || (adat[1][1]==colorNumber && adat[2][1]==colorNumber && adat[3][1]==colorNumber) || (adat[2][1]==2 && adat[3][1]==colorNumber && adat[4][1]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((adat[0][2]==colorNumber && adat[1][2]==colorNumber && adat[2][2]==colorNumber) || (adat[1][2]==colorNumber && adat[2][2]==colorNumber && adat[3][2]==colorNumber) || (adat[2][2]==colorNumber && adat[3][2]==colorNumber && adat[4][2]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((adat[0][3]==colorNumber && adat[1][3]==colorNumber && adat[2][3]==colorNumber) || (adat[1][3]==colorNumber && adat[2][3]==colorNumber && adat[3][3]==colorNumber) || (adat[2][3]==colorNumber && adat[3][3]==colorNumber && adat[4][3]==colorNumber)){
            color=colorNumber;
            System.out.println(colorName +" győz");
        }
        else if((adat[0][0]==colorNumber && adat[0][1]==colorNumber && adat[0][2]==colorNumber) || (adat[0][1]==colorNumber && adat[0][2]==colorNumber && adat[0][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((adat[1][0]==colorNumber && adat[1][1]==colorNumber && adat[1][2]==colorNumber) || (adat[1][1]==colorNumber && adat[1][2]==colorNumber && adat[1][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((adat[2][0]==colorNumber && adat[2][1]==colorNumber && adat[2][2]==colorNumber) || (adat[2][1]==colorNumber && adat[2][2]==colorNumber && adat[2][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((adat[3][0]==colorNumber && adat[3][1]==colorNumber && adat[3][2]==colorNumber) || (adat[3][1]==colorNumber && adat[3][2]==colorNumber && adat[3][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((adat[4][0]==colorNumber && adat[4][1]==colorNumber && adat[4][2]==colorNumber) || (adat[4][1]==colorNumber && adat[4][2]==colorNumber && adat[4][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((adat[0][0]==colorNumber && adat[1][1]==colorNumber && adat[2][2]==colorNumber) || (adat[1][1]==colorNumber && adat[2][2]==colorNumber && adat[3][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((adat[0][1]==colorNumber && adat[1][2]==colorNumber && adat[2][3]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((adat[0][2]==colorNumber && adat[1][1]==colorNumber && adat[2][0]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((adat[0][3]==colorNumber && adat[1][2]==colorNumber && adat[2][1]==colorNumber) || (adat[1][2]==colorNumber && adat[2][1]==colorNumber && adat[3][0]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((adat[1][0]==colorNumber && adat[2][1]==colorNumber && adat[3][2]==colorNumber) || (adat[2][1]==colorNumber && adat[3][2]==colorNumber && adat[4][3]==colorNumber)){
            color=colorNumber;
            Logger.info("Piros győz");
        }
        else if((adat[1][3]==colorNumber && adat[2][2]==colorNumber && adat[3][1]==colorNumber) || (adat[2][2]==colorNumber && adat[3][1]==colorNumber && adat[4][0]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((adat[2][0]==colorNumber && adat[3][1]==colorNumber && adat[4][2]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }
        else if((adat[2][3]==colorNumber && adat[3][2]==colorNumber && adat[4][1]==colorNumber)){
            color=colorNumber;
            Logger.info(colorName +" győz");
        }

        return color;
    }

    public static void uploadList(int[][] adat){
       //Mátix feltöltése a megfelelő adatokkal

        adat[0][0]=1;
        adat[0][1]=2;
        adat[0][2]=1;
        adat[0][3]=2;

        adat[1][0]=0;
        adat[1][1]=0;
        adat[1][2]=0;
        adat[1][3]=0;

        adat[2][0]=0;
        adat[2][1]=0;
        adat[2][2]=0;
        adat[2][3]=0;

        adat[3][0]=0;
        adat[3][1]=0;
        adat[3][2]=0;
        adat[3][3]=0;

        adat[4][0]=2;
        adat[4][1]=1;
        adat[4][2]=2;
        adat[4][3]=1;

        Logger.info("A tábla jelenlegi állapota\n"+ adat[0][0]+" "+adat[0][1]+" "+adat[0][2]+" "+adat[0][3]+"\n"+adat[1][0]+" "+adat[1][1]+" "+adat[1][2]+" "+adat[1][3]+"\n"+
        adat[2][0]+" "+adat[2][1]+" "+adat[2][2]+" "+adat[2][3]+"\n"+adat[3][0]+" "+adat[3][1]+" "+adat[3][2]+" "+adat[3][3]+"\n"+
        adat[4][0]+" "+adat[4][1]+" "+adat[4][2]+" "+adat[4][3]);
    }


   public static void checkPossibleMove(int lastX,int lastY,int [][] adat, Rectangle[][] grid){
       if(lastY==0){
           if(adat[lastY+1][lastX]==0) {
               grid[lastX][lastY + 1].setFill(Color.GREEN);
           }
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
                   grid[lastX][lastY +1].setFill(Color.GREEN);
                   if (adat[lastY][lastX + 1] == 0) {
                       grid[lastX + 1][lastY].setFill(Color.GREEN);
                   }
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

   }

}
