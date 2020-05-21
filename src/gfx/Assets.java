package gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int WIDTH=130,HEIGHT=130;
    public static BufferedImage greenAlien,purpleAlien,pinkAlien,blueAlien,redAlien,yellowAlien;
    public static BufferedImage gBullet,gDestroy;

    public static void init(){
        SpriteSheet sheet= new SpriteSheet(ImageLoader.loadImage("/res/space_invader_sprites2.png"));
        greenAlien=sheet.crop(0,0,WIDTH,HEIGHT);
        yellowAlien=sheet.crop(0,HEIGHT,WIDTH,HEIGHT);
        purpleAlien=sheet.crop(0,HEIGHT*2,WIDTH,HEIGHT);
        pinkAlien=sheet.crop(0,HEIGHT*3,WIDTH,HEIGHT);
    }
}
