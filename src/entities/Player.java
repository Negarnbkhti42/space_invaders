package entities;

import frame.GamePanel;
import frame.Handler;
import gfx.Assets;

import java.awt.*;

public class Player extends Creature {


    public Player(Handler handler, float xPosition, float yPosition) {
        super(handler, xPosition, yPosition, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.handler = handler;
        boundary.x = 17;
        boundary.y = 13;
        boundary.width = 94;
        boundary.height = 116;
    }

    @Override
    public void tick() {
        getInput();
        move();
    }

    public void getInput() {
        xMove = yMove = 0;
        if (handler.getGame().getKeyManager().right) {
            xMove = speed;
        }
        if (handler.getGame().getKeyManager().left) {
            xMove = -speed;
        }
        if (handler.getGame().getKeyManager().space) {
            //todo: shoot lasers
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

}
