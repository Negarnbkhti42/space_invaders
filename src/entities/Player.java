package entities;

import com.sun.org.apache.bcel.internal.generic.LADD;
import frame.GamePanel;
import gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    private BufferedImage texture;

    private final GamePanel game;
    private Laser laser;

    public Player(GamePanel game, float xPosition, float yPosition) {
        super(xPosition, yPosition, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.game = game;
        this.laser=Laser.getLaser(game);
    }

    @Override
    public void tick() {
        getInput();
        move();
    }

    public void getInput() {
        xMove = yMove = 0;
        if (game.getKeyManager().right) {
            xMove = speed;
        }
        if (game.getKeyManager().left) {
            xMove = -speed;
        }
        if (game.getKeyManager().space){
            laser.shoot(xPosition,yPosition);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.spaceShip, (int) xPosition, (int) yPosition, width, height, null);
    }



}
