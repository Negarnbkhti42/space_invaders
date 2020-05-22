package state;

import gfx.Assets;

import java.awt.*;

public class GameState extends State {

    private int x=0;
    @Override
    public void tick() {
        if (x<1480-260){
            x+=20;
        }
    }

    @Override
    public void render(Graphics graphic) {
        graphic.fillRect(0,0,1480,1000);
        graphic.setColor(Color.black);
        graphic.drawImage(Assets.greenAlien, x, 0, null);
        graphic.drawImage(Assets.greenAlien_2, 130+x, 0, null);
        graphic.drawImage(Assets.greenBullet, x, 70, null);
        graphic.drawImage(Assets.spaceShip,(1480/2)-65,1000-130, null);
    }
}
