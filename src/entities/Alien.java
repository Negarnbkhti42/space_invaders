package entities;

import frame.Handler;
import gfx.Animation;
import gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Alien extends Creature {

    private Animation movement;
    private String color;
    private float initialX;
    private long timer,lastTime;
    private boolean killed=false;
    private long deathTime;
    private Random random=new Random();


    public Alien(Handler handler,float xPosition, float yPosition, String color) {
        super(handler,xPosition, yPosition, Creature.getDefaultCreatureWidth(), Creature.DEFAULT_CREATURE_HEIGHT);
        this.color=color;
        movement=new Animation(800,Assets.getAliensTexture().get(color));
        this.speed=15;
        this.initialX=xPosition;
        health=1;
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
        if (timer>=800) {
            timer = 0;
            movement.tick();
            move();
        }
    }

    @Override
    public void render(Graphics g) {
        if (killed) {
            g.drawImage(Assets.getDestroyed().get(color), (int) xPosition, (int) yPosition, width, height, null);
            if ((System.currentTimeMillis()-deathTime)>=200)
            health=0;
        } else
        g.drawImage(movement.getCurrentFrame(), (int) xPosition, (int) yPosition, width, height, null);
    }

    @Override
    public void move() {
        xPosition+=speed;
        if (((xPosition-initialX)>=AlienPack.getAlienLimit())||((initialX-xPosition)>=AlienPack.getAlienLimit())){
            yPosition+=35;
            speed*=-1;
            xPosition+=speed;
        }
    }


    public void kill(){
        killed=true;
        deathTime=System.currentTimeMillis();
    }

}
