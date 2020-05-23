package entities;

import frame.GamePanel;
import gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Laser extends Item{

    private final GamePanel game;
    private static Laser laser=null;
    private boolean shot=false;
    private Player spaceship;

    public Laser(GamePanel game,float xPosition, float yPosition,Player spaceship) {
        super(xPosition, yPosition, DEFAULT_ITEM_WIDTH, DEFAULT_ITEM_HEIGHT);
        this.speed=15.0f;
        this.game=game;
        this.texture=Assets.laser;
        this.spaceship=spaceship;
    }

    @Override
    public void tick() {
        if (shot) {
            yPosition -= speed;
            if (yPosition <= 0)
                shot = false;
        }else {
          xPosition=  spaceship.getxPosition();
          yPosition=spaceship.getyPosition();
        }
    }

    @Override
    public void render(Graphics g){
        if (shot)
        g.drawImage(texture,(int)xPosition,(int)yPosition,width,height,null);

    }

    public void shoot(float x,float y){
        if (!shot) {
            shot = true;
        }
    }
}
