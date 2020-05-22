package entities;

import gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{

    private BufferedImage texture;

    public Player(float xPosition, float yPosition) {
        super(xPosition, yPosition);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.spaceShip,(int)xPosition,(int)yPosition,null);
    }
}
