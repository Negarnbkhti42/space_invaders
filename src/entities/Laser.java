package entities;

import frame.GamePanel;
import frame.Handler;
import gfx.Assets;
import state.State;

import javax.print.attribute.HashAttributeSet;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Laser extends Item{

    private static boolean shot;

    public Laser(Handler handler,float xPosition, float yPosition) {
        super(handler,xPosition, yPosition, DEFAULT_ITEM_WIDTH, DEFAULT_ITEM_HEIGHT);
        this.speed=20.0f;
        this.texture=Assets.laser;
        this.xPosition= xPosition;
        this.yPosition=yPosition;
        boundary.x=14;
        boundary.y=-4;
        boundary.width=(27*DEFAULT_ITEM_WIDTH)/130;
        boundary.height=(117*DEFAULT_ITEM_HEIGHT)/130;
        shot=true;
    }



    @Override
    public void tick() {
        yPosition-=speed;
        if (checkCollision(0, yMove)||(yPosition)<=0) {
            shot=false;
            handler.getGameState().getEntityManager().removeEntity(this);
        }
    }

    @Override
    public void render(Graphics g){
        g.drawImage(texture,(int)xPosition,(int)yPosition,width,height,null);

    }

    @Override
    public boolean checkCollision(float xOffset, float yOffset) {
        for (Entity e:handler.getGameState().getEntityManager().getEntities()){
            if (e instanceof Alien){
                if (e.getBounds(0,0).intersects(getBounds(xOffset,yOffset))){
                    ((Alien) e).kill();
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isShot(){
        return shot;
    }
}
