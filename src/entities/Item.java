package entities;

import java.awt.*;

public class Item extends Entity{

    public static final int DEFAULT_ITEM_WIDTH=50,
            DEFAULT_ITEM_HEIGHT=50;

    public Item(float xPosition, float yPosition,int width,int height) {
        super(xPosition, yPosition,width,height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
