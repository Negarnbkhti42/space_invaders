package entities;

import gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Alien extends Creature {

    private BufferedImage texture;
    private String color;
    private float initialX;

    public Alien(float xPosition, float yPosition,String color) {
        super(xPosition, yPosition, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.color=color;
        this.texture=Assets.getAliensTexture().get(color);
        this.speed=10;
        this.initialX=xPosition;
    }

    @Override
    public void tick() {
       xPosition+=speed;
       if (Math.abs(xPosition-initialX)>=AlienPack.getAlienLimit()){
           yPosition+=15;
           speed*=-1;
       }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(texture, (int) xPosition, (int) yPosition, width, height, null);
    }
}
