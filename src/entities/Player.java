package entities;

import frame.GamePanel;
import gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{

    private BufferedImage texture;

    private GamePanel game;

    public Player(GamePanel game,float xPosition, float yPosition) {
        super(xPosition, yPosition);
        this.game=game;
    }

    @Override
    public void tick() {
        if (game.getKeyManager().right)
            xPosition+=3;
        if (game.getKeyManager().left)
            xPosition-=3;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.spaceShip,(int)xPosition,(int)yPosition,null);
    }
}
