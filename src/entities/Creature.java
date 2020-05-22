package entities;

public abstract class Creature extends Entity{

    protected int health;

    public Creature(float xPosition, float yPosition) {
        super(xPosition, yPosition);
        health=1;
    }
}
