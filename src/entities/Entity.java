package entities;

import java.awt.*;

public abstract class Entity {

    protected float xPosition,yPosition;

    public Entity(float xPosition,float yPosition){
        this.xPosition=xPosition;
        this.yPosition=yPosition;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}
