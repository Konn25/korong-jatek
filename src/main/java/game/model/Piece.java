package game.model;

import javafx.scene.shape.Circle;

/**
 * Piece properties
 */
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

    /**
     *  Set piece Y axis
     * @param y the piece y axis position
     */
    public void setY(double y){
        this.y=y;
    }

    /**
     * Set piece X
     * @param x he piece x axis position
     */
    public void setX(double x){
        this.x=x;
    }

    /**
     * Get piece X position
     * @return piece X position
     */
    public double getX(){
        return x;
    }

    /**
     * Get piece Y position
     * @return piece Y position
     */
    public double getY(){
        return y;
    }

    /**
     * Draw piece
     */
    public void draw(){
        c.setRadius(radius);
        c.setTranslateX(x);
        c.setTranslateY(y);

    }
}
