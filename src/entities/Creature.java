package entities;

import frame.GamePanel;

public abstract class Creature extends Entity {

    protected static final int DEFAULT_HEALTH = 1;
    protected static final float DEFAULT_CREATURE_SPEED = 2.0f;
    protected static final int DEFAULT_CREATURE_WIDTH = 50,
            DEFAULT_CREATURE_HEIGHT = 50;

    protected int health;
    protected float speed;

    protected float xMove = 0, yMove = 0;

    public Creature(float xPosition, float yPosition, int width, int height) {
        super(xPosition, yPosition, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_CREATURE_SPEED;
    }

    public static int getDefaultCreatureHeight() {
        return DEFAULT_CREATURE_HEIGHT;
    }

    public static int getDefaultCreatureWidth() {
        return DEFAULT_CREATURE_WIDTH;
    }

    public void move() {
        xPosition += xMove;
        if (xPosition >= GamePanel.getPanelWidth() - 55)
            xPosition = GamePanel.getPanelWidth() - 55;
        if (xPosition <= 5) {
            xPosition = 5;
        }
    }

    public int getHealth() {
        return health;
    }

    public float getSpeed() {
        return speed;
    }
}
