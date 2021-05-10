package game.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Piece {

    private double x;
    private double y;
    private double radius;
    private Circle c;



    public Piece(double x, double y, double radius, Circle c){
        this.x=x;
        this.y=y;
        this.radius=radius;
        this.c=c;
    }

    /*
        * Set piece Y
     */

    public void setY(double y){
        this.y=y;
    }

    /*
     * Set piece X
     */
    public void setX(double x){
        this.x=x;
    }

    /*
     * Get piece X
     */
    public double getX(){
        return x;
    }

    /*
     * Get piece Y
     */

    public double getY(){
        return y;
    }

    /*
     * Draw piece
     */

    public void draw(){
        c.setRadius(radius);
        c.setTranslateX(x);
        c.setTranslateY(y);

    }
}
