package entities;

import frame.Handler;

import javax.print.attribute.HashAttributeSet;
import java.awt.*;

public class Bullet extends Item {
    public Bullet(Handler handler,float xPosition, float yPosition) {
        super(handler,xPosition, yPosition, Item.DEFAULT_ITEM_WIDTH, Item.DEFAULT_ITEM_HEIGHT);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
