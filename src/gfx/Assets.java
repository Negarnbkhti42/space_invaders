package gfx;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Assets {


    private static final int WIDTH = 130, HEIGHT = 130;
    public static BufferedImage spaceShip = ImageLoader.loadImage("/res/galaga-galaxian-golden-age.png");
    public static SpriteSheet alienSheet = new SpriteSheet(ImageLoader.loadImage("/res/space_invader_sprites2.png"));
    public static BufferedImage laser=ImageLoader.loadImage("/res/SpaceInvadersLaserDepiction.png");
    public static BufferedImage background;
    public static BufferedImage menuBackground;
    public static BufferedImage logo;
    public static BufferedImage greenAlien;
    public static BufferedImage[] startButton;
    public static BufferedImage[] highscoreButton;

    private static HashMap<String,BufferedImage[]> aliens=new HashMap<>();
    private static HashMap<String,BufferedImage> bullets=new HashMap<>();
    private static HashMap<String,BufferedImage> destroyed=new HashMap<>();

    public static Font defaultFont;

    public static void init() {
        loadAliens();
        loadMenu();
        //loadFont();
    }

    private static void loadAliens() {
        aliens.put("green",
                new BufferedImage[]{alienSheet.crop(0, 0, WIDTH, HEIGHT),
                        alienSheet.crop(WIDTH, 0, WIDTH, HEIGHT)});
        bullets.put("green",alienSheet.crop(WIDTH*3,0,WIDTH,HEIGHT));
        destroyed.put("green",alienSheet.crop(WIDTH*2,0,WIDTH,HEIGHT));

        aliens.put("yellow",new BufferedImage[]{alienSheet.crop(0, HEIGHT, WIDTH, HEIGHT),
                alienSheet.crop(WIDTH, HEIGHT, WIDTH, HEIGHT)});
        bullets.put("yellow",alienSheet.crop(WIDTH*3,HEIGHT,WIDTH,HEIGHT));
        destroyed.put("yellow",alienSheet.crop(WIDTH*2,HEIGHT,WIDTH,HEIGHT));


        aliens.put("purple",new BufferedImage[]{alienSheet.crop(0, HEIGHT * 2, WIDTH, HEIGHT),
                alienSheet.crop(WIDTH, HEIGHT * 2, WIDTH, HEIGHT)});
        bullets.put("purple",alienSheet.crop(WIDTH*3,HEIGHT*2,WIDTH,HEIGHT));
        destroyed.put("purple",alienSheet.crop(WIDTH*2,HEIGHT*2,WIDTH,HEIGHT));


        aliens.put("lightBlue",new BufferedImage[]{alienSheet.crop(0, HEIGHT * 3, WIDTH, HEIGHT),
                alienSheet.crop(WIDTH, HEIGHT * 3, WIDTH, HEIGHT)});
        bullets.put("lightBlue",alienSheet.crop(WIDTH*3,HEIGHT*3,WIDTH,HEIGHT));
        destroyed.put("lightBlue",alienSheet.crop(WIDTH*2,HEIGHT*3,WIDTH,HEIGHT));


        aliens.put("blue",new BufferedImage[]{alienSheet.crop(0, HEIGHT * 4, WIDTH, HEIGHT),
                alienSheet.crop(WIDTH, HEIGHT * 4, WIDTH, HEIGHT)});
        bullets.put("blue",alienSheet.crop(WIDTH*3,HEIGHT*4,WIDTH,HEIGHT));
        destroyed.put("blue",alienSheet.crop(WIDTH*2,HEIGHT*4,WIDTH,HEIGHT));


        aliens.put("red", new BufferedImage[]{alienSheet.crop(0, HEIGHT * 5, WIDTH, HEIGHT),
                alienSheet.crop(WIDTH, HEIGHT * 5, WIDTH, HEIGHT)});
        bullets.put("red",alienSheet.crop(WIDTH*3,HEIGHT*5,WIDTH,HEIGHT));
        destroyed.put("red",alienSheet.crop(WIDTH*2,HEIGHT*5,WIDTH,HEIGHT));



    }

    private static void loadMenu(){
        background=ImageLoader.loadImage("/res/Tileable_Background_Images.jpg");
        menuBackground=ImageLoader.loadImage("/menu_Background.png");
        logo=ImageLoader.loadImage("/space-invaders-logo.png");
        greenAlien=ImageLoader.loadImage("/res/green_alien.png");
        startButton=new BufferedImage[]{
                ImageLoader.loadImage("/res/start-game.png"),
                ImageLoader.loadImage("/res/start-game-hover.png")
        };
        highscoreButton=new BufferedImage[]{
                ImageLoader.loadImage("/highscores.png"),
                ImageLoader.loadImage("/highscores-hover.png")
        };
    }

    private static void loadFont(){
        try {
            defaultFont = Font.createFont(Font.TRUETYPE_FONT, new File("/res/ARCADECLASSIC.TTF")).deriveFont(Font.PLAIN,300);
        }catch (FontFormatException | IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static HashMap<String, BufferedImage[]> getAliensTexture() {
        return aliens;
    }

    public static HashMap<String, BufferedImage> getDestroyed() {
        return destroyed;
    }

    public static HashMap<String, BufferedImage> getBullets() {
        return bullets;
    }
}
