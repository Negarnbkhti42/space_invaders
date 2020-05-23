package entities;

import frame.GamePanel;
import frame.Handler;
import gfx.Assets;
import state.State;

import javax.print.attribute.HashAttributeSet;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Laser extends Item{


    public Laser(Handler handler,float xPosition, float yPosition) {
        super(handler,xPosition, yPosition, DEFAULT_ITEM_WIDTH, DEFAULT_ITEM_HEIGHT);
        this.speed=15.0f;
        this.texture=Assets.laser;
        this.xPosition= xPosition;
        this.yPosition=yPosition;
        boundary.x=53;
        boundary.y=4;
        boundary.width=23;
        boundary.height=117;
    }

    @Override
    public void tick() {
        yPosition-=speed;
    }

    @Override
    public void render(Graphics g){
        g.drawImage(texture,(int)xPosition,(int)yPosition,width,height,null);

    }


}
