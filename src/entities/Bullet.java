package entities;

import frame.Handler;
import gfx.Assets;

import javax.print.attribute.HashAttributeSet;
import java.awt.*;

public class Bullet extends Item {
    public Bullet(Handler handler,float xPosition, float yPosition,String color) {
        super(handler,xPosition, yPosition, Item.DEFAULT_ITEM_WIDTH, Item.DEFAULT_ITEM_HEIGHT);
        this.speed=10;
        this.health=1;
        this.texture= Assets.getBullets().get(color);
        this.xPosition= xPosition;
        this.yPosition=yPosition;
        boundary.x=46;
        boundary.y=32;
        boundary.width=(27*DEFAULT_ITEM_WIDTH)/130;
        boundary.height=(51*DEFAULT_ITEM_HEIGHT)/130;
    }

    @Override
    public void tick() {
        yPosition+=speed;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(texture,(int)xPosition,(int)yPosition,width,height,null);
    }
}
