package entities;

import java.awt.*;

public abstract class Item extends Entity {

    protected float speed;

    public static final int DEFAULT_ITEM_WIDTH = 35,
            DEFAULT_ITEM_HEIGHT = 35;

    public Item(float xPosition, float yPosition, int width, int height) {
        super(xPosition, yPosition, width, height);
    }


}
