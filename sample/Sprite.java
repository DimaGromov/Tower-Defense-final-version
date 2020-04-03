package sample;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

public class Sprite {

    private Image image;
    private double positionX;
    private double positionY;
    private int velocityX;
    private double width;
    private double height;

    public Sprite(){
        positionX = 0;
        positionY = 100;
        velocityX = 1;
    }

    public Sprite(double x, double y){
        positionX = x;
        positionY = y;
        velocityX = 1;
    }

    public void setImage(String filename) {
        image = new Image(filename);
        width = image.getWidth();
        height = image.getHeight();
    }

    public void setWidth(double height, double width){
        this.height = height;
        this.width = width;
    }

    public void setPositionX(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void setVelocityX(Speed speed) {
        this.velocityX = speed.getSpeed();
    }

    public double getPositionX() {
        return positionX;
    }

    public void update(double time) {
        positionX += velocityX * time;
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D((positionX-(width/2)),(positionY-(height/2)),width,height);
    }

    public boolean intersects(Sprite s) {
        return s.getBoundary().intersects( this.getBoundary() );
    }

    public void render(GraphicsContext gc)
    {
        gc.drawImage( image, (positionX - width/2), (positionY - height/2));
    }

}
