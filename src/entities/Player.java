package entities;

import frame.GamePanel;
import frame.Handler;
import gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    private int points=0;


    public Player(Handler handler, float xPosition, float yPosition) {
        super(handler, xPosition, yPosition, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.handler = handler;
        boundary.x = 8;
        boundary.y = 10;
        boundary.width = (95 * DEFAULT_CREATURE_WIDTH) / 130;
        boundary.height = (116 * DEFAULT_CREATURE_HEIGHT) / 130;
    }

    @Override
    public void tick() {
        getInput();
        move();
    }

    public void getInput() {
        xMove = yMove = 0;
        if (handler.getKeyManager().right) {
            xMove = speed;
        }
        if (handler.getKeyManager().left) {
            xMove = -speed;
        }
        if (handler.getKeyManager().space) {
            if (!Laser.isShot())
                handler.getGameState().getEntityManager().addEntity(new Laser(handler, xPosition + 15, yPosition));
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.spaceShip, (int) xPosition, (int) yPosition, width, height, null);

    }


    @Override
    public void move() {
        xPosition += xMove;
        if (xPosition >= GamePanel.getPanelWidth() - 55)
            xPosition = GamePanel.getPanelWidth() - 55;
        if (xPosition <= 5) {
            xPosition = 5;
        }
    }

    public int getPoints() {
        return points;
    }

    public void increasePoints(){
        points+=1;
    }
}
