package entities;

import frame.GamePanel;
import gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Laser extends Item{

    private BufferedImage texture=Assets.laser;
    private final GamePanel game;
    private static Laser laser=null;
    private boolean shot=false;

    public Laser(GamePanel game,float xPosition, float yPosition) {
        super(xPosition, yPosition, DEFAULT_ITEM_WIDTH, DEFAULT_ITEM_HEIGHT);
        this.speed=5.0f;
        this.game=game;
    }

    @Override
    public void tick() {
        if (shot)
        yPosition-=speed;
        if (yPosition<=0)
           shot=false;
    }

    @Override
    public void render(Graphics g){
        if (shot)
        g.drawImage(texture,(int)xPosition,(int)yPosition,width,height,null);

    }

    public static Laser getLaser(GamePanel game) {
        if (laser==null)return laser=new Laser(game,0,0);
        return laser;
    }

    public void shoot(float x,float y){
        if (!shot) {
            shot = true;
            setxPosition(x);
            setyPosition(y);
        }
    }
}
