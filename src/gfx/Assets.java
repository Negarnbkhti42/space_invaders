package gfx;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Assets {


    private static final int WIDTH = 130, HEIGHT = 130;
    public static BufferedImage greenAlien_2, purpleAlien_2, pinkAlien_2, blueAlien_2, redAlien_2, yellowAlien_2;
    public static BufferedImage greenBullet, yellowBullet, purpleBullet, pinkBullet, blueBullet, redBullet;
    public static BufferedImage spaceShip = ImageLoader.loadImage("/res/galaga-galaxian-golden-age.png");
    public static SpriteSheet alienSheet = new SpriteSheet(ImageLoader.loadImage("/res/space_invader_sprites2.png"));
    public static BufferedImage laser=ImageLoader.loadImage("/res/SpaceInvadersLaserDepiction.png");
    public static BufferedImage background=ImageLoader.loadImage("/res/Tileable_Background_Images.jpg");

    private static HashMap<String,BufferedImage> aliens=new HashMap<>();
    private static HashMap<String,BufferedImage> aliens_2=new HashMap<>();
    private static HashMap<String,BufferedImage> bullets=new HashMap<>();
    private static HashMap<String,BufferedImage> destroyed=new HashMap<>();

    public static void init() {
        loadAliens();
        loadBullets();
    }

    private static void loadAliens() {
        aliens.put("green", alienSheet.crop(0, 0, WIDTH, HEIGHT));
        greenAlien_2 = alienSheet.crop(WIDTH, 0, WIDTH, HEIGHT);
        aliens.put("yellow",alienSheet.crop(0, HEIGHT, WIDTH, HEIGHT));
        yellowAlien_2 = alienSheet.crop(0, HEIGHT, WIDTH, HEIGHT);
        aliens.put("purple",alienSheet.crop(0, HEIGHT * 2, WIDTH, HEIGHT));
        purpleAlien_2 = alienSheet.crop(0, HEIGHT * 2, WIDTH, HEIGHT);
        aliens.put("lightBlue",alienSheet.crop(0, HEIGHT * 3, WIDTH, HEIGHT));
        pinkAlien_2 = alienSheet.crop(0, HEIGHT * 3, WIDTH, HEIGHT);
        aliens.put("blue",alienSheet.crop(0, HEIGHT * 4, WIDTH, HEIGHT));
        blueAlien_2 = alienSheet.crop(0, HEIGHT * 4, WIDTH, HEIGHT);
        aliens.put("red", alienSheet.crop(0, HEIGHT * 5, WIDTH, HEIGHT));
        redAlien_2 = alienSheet.crop(0, HEIGHT * 5, WIDTH, HEIGHT);
    }

    private static void loadBullets() {
        greenBullet = alienSheet.crop(WIDTH * 3, 0, WIDTH, HEIGHT);
        yellowBullet = alienSheet.crop(WIDTH * 3, HEIGHT, WIDTH, HEIGHT);
        purpleBullet = alienSheet.crop(WIDTH * 3, HEIGHT * 2, WIDTH, HEIGHT);
        pinkBullet = alienSheet.crop(WIDTH * 3, HEIGHT * 3, WIDTH, HEIGHT);
        blueBullet = alienSheet.crop(WIDTH * 3, HEIGHT * 4, WIDTH, HEIGHT);
        redBullet = alienSheet.crop(WIDTH * 3, HEIGHT * 5, WIDTH, HEIGHT);
    }

    public static HashMap<String, BufferedImage> getAliensTexture() {
        return aliens;
    }
}
