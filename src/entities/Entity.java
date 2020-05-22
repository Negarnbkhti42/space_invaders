package entities;

import java.awt.*;

public abstract class Entity {

    protected float xPosition,yPosition;
    protected int width,height;

    public Entity(float xPosition,float yPosition,int width,int height){
        this.xPosition=xPosition;
        this.yPosition=yPosition;
        this.width=width;
        this.height=height;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public float getxPosition() {
        return xPosition;
    }

    public float getyPosition() {
        return yPosition;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setxPosition(float xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(float yPosition) {
        this.yPosition = yPosition;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
