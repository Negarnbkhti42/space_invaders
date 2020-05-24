package entities;

import frame.GamePanel;
import frame.Handler;

public abstract class Creature extends Entity {

    protected static final int DEFAULT_HEALTH = 1;
    protected static final float DEFAULT_CREATURE_SPEED = 2.5f;
    protected static final int DEFAULT_CREATURE_WIDTH = 55,
            DEFAULT_CREATURE_HEIGHT = 55;





    public Creature(Handler handler,float xPosition, float yPosition, int width, int height) {
        super(handler,xPosition, yPosition, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_CREATURE_SPEED;
    }

    public static int getDefaultCreatureHeight() {
        return DEFAULT_CREATURE_HEIGHT;
    }

    public static int getDefaultCreatureWidth() {
        return DEFAULT_CREATURE_WIDTH;
    }

    public abstract void move();

    public int getHealth() {
        return health;
    }

    public float getSpeed() {
        return speed;
    }

}
