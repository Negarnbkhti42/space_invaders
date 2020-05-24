package entities;

import frame.GamePanel;
import frame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    protected float xPosition, yPosition;
    protected int width, height;
    protected BufferedImage texture;
    protected Rectangle boundary=new Rectangle();
    protected Handler handler;

    protected float xMove = 0, yMove = 0;

    public Entity(Handler handler,float xPosition, float yPosition, int width, int height) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.handler=handler;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public boolean checkCollision(float xOffset,float yOffset){
        for (Entity e:handler.getGameState().getEntityManager().getEntities()){
            if (e.equals(this))
                continue;
            if (e.getBounds(0,0).intersects(getBounds(xOffset,yOffset)))
                return true;
        }
        return false;
    }

    public Rectangle getBounds(float xOffset,float yOffset){
        return new Rectangle(((int)(xPosition+boundary.x+xOffset)),((int)(yPosition+boundary.y+yOffset)),boundary.width,boundary.height);
    }

    public float getxPosition() {
        return xPosition;
    }

    public void setxPosition(float xPosition) {
        this.xPosition = xPosition;
    }

    public float getyPosition() {
        return yPosition;
    }

    public void setyPosition(float yPosition) {
        this.yPosition = yPosition;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getxMove() {
        return xMove;
    }

    public float getyMove() {
        return yMove;
    }
}
