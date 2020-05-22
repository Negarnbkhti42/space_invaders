package entities;

import frame.GamePanel;
import gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.time.Year;

public class Player extends Creature{

    private BufferedImage texture;

    private GamePanel game;

    public Player(GamePanel game,float xPosition,float yPosition) {
        super(xPosition, yPosition,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
        this.game=game;
    }

    @Override
    public void tick() {
        getInput();
        move();
    }

    public void getInput(){
        xMove=yMove=0;
        if (game.getKeyManager().right){
            xMove=speed;
        }
        if (game.getKeyManager().left){
            xMove=-speed;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.spaceShip,(int)xPosition,(int)yPosition,width,height,null);
    }
}
