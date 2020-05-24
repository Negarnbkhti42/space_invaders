package entities;

import frame.Handler;

import java.awt.*;

public abstract class Item extends Entity {

    protected float speed;

    public static final int DEFAULT_ITEM_WIDTH = 25,
            DEFAULT_ITEM_HEIGHT = 25;

    public Item(Handler handler,float xPosition, float yPosition, int width, int height) {
        super(handler,xPosition, yPosition, width, height);
    }


}
