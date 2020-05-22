package entities;

import frame.GamePanel;
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
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(texture,(int)xPosition,(int) yPosition,null);
    }
}
