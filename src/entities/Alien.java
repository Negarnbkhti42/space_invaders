package entities;

import frame.Handler;
import gfx.Animation;
import gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Alien extends Creature {

    private Animation movement;
    private String color;
    private float initialX;


    public Alien(Handler handler,float xPosition, float yPosition, String color) {
        super(handler,xPosition, yPosition, Creature.getDefaultCreatureWidth(), Creature.DEFAULT_CREATURE_HEIGHT);
        this.color=color;
        movement=new Animation(250,Assets.getAliensTexture().get(color));
        this.speed=10;
        this.initialX=xPosition;
        boundary.x=18;
        boundary.y=26;
        boundary.width=94;
        boundary.height=68;
    }

    @Override
    public void tick() {
        movement.tick();
       move();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(movement.getCurrentFrame(), (int) xPosition, (int) yPosition, width, height, null);
    }

    @Override
    public void move() {
        xPosition+=speed;
        if (((xPosition-initialX)>=AlienPack.getAlienLimit())||((initialX-xPosition)>=AlienPack.getAlienLimit())){
            yPosition+=15;
            speed*=-1;
        }
    }

}
