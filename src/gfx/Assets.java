package gfx;

import com.sun.org.apache.regexp.internal.RE;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {

    private static final int WIDTH=130,HEIGHT=130;
    public static BufferedImage greenAlien,purpleAlien,pinkAlien,blueAlien,redAlien,yellowAlien;
    public static BufferedImage greenAlien_2,purpleAlien_2,pinkAlien_2,blueAlien_2,redAlien_2,yellowAlien_2;
    public static BufferedImage gBullet,gDestroy;
    private static SpriteSheet aliens= new SpriteSheet(ImageLoader.loadImage("/res/space_invader_sprites2.png"));

    public static void init(){
        loadAliens();
    }

    private static void loadAliens(){
        greenAlien=aliens.crop(0,0,WIDTH,HEIGHT);
        greenAlien_2=aliens.crop(WIDTH,0,WIDTH,HEIGHT);
        gBullet=aliens.crop(WIDTH*3,0,WIDTH,HEIGHT);
        yellowAlien=aliens.crop(0,HEIGHT,WIDTH,HEIGHT);
        yellowAlien_2=aliens.crop(0,HEIGHT,WIDTH,HEIGHT);
        purpleAlien=aliens.crop(0,HEIGHT*2,WIDTH,HEIGHT);
        purpleAlien_2=aliens.crop(0,HEIGHT*2,WIDTH,HEIGHT);
        pinkAlien=aliens.crop(0,HEIGHT*3,WIDTH,HEIGHT);
        pinkAlien_2=aliens.crop(0,HEIGHT*3,WIDTH,HEIGHT);
        blueAlien=aliens.crop(0,HEIGHT*4,WIDTH,HEIGHT);
        blueAlien_2=aliens.crop(0,HEIGHT*4,WIDTH,HEIGHT);
        redAlien=aliens.crop(0,HEIGHT*5,WIDTH,HEIGHT);
        redAlien_2=aliens.crop(0,HEIGHT*5,WIDTH,HEIGHT);
    }
}
