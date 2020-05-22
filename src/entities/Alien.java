package entities;

import frame.Panel;
import gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Alien extends Creature {

    private BufferedImage texture= Assets.greenAlien;

    public Alien(float xPosition, float yPosition) {
        super(xPosition, yPosition);
    }

    @Override
    public void tick() {
        if (xPosition< Panel.getPanelWidth()-130){
            xPosition+=20;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(texture,(int)xPosition,(int) yPosition,null);
    }
}
