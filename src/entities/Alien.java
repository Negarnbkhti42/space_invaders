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
    private long timer,lastTime;


    public Alien(Handler handler,float xPosition, float yPosition, String color) {
        super(handler,xPosition, yPosition, Creature.getDefaultCreatureWidth(), Creature.DEFAULT_CREATURE_HEIGHT);
        this.color=color;
        movement=new Animation(250,Assets.getAliensTexture().get(color));
        this.speed=10;
        this.initialX=xPosition;
        boundary.x=5;
        boundary.y=10;
        boundary.width=(100*Creature.getDefaultCreatureWidth())/130;
        boundary.height=(70*Creature.getDefaultCreatureHeight())/130;
        lastTime=System.currentTimeMillis();
    }

    @Override
    public void tick() {
        timer+=System.currentTimeMillis()-lastTime;
        lastTime=System.currentTimeMillis();
        if (timer>=250) {
            timer = 0;
            movement.tick();
            move();
        }
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
