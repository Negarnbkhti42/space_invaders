import gfx.ImageLoader;
import gfx.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class GamePanel implements Runnable {
    private Display display;

    private static final String TITLE = "Space invaders";
    private static final int WIDTH = 800, HEIGHT = 600;

    private Thread thread;
    private boolean running=false;

    private BufferStrategy Bstrategy;
    private Graphics graphics;

    private BufferedImage bi;
    private SpriteSheet sheet;



    private void init(){
        display=new Display(TITLE,WIDTH,HEIGHT);

        bi= ImageLoader.loadImage("/res/space_invader_sprites1.png");
        sheet=new SpriteSheet(bi);
    }

    private void tick(){

    }

    private void render(){
        Bstrategy =display.getCanvas().getBufferStrategy();
        if (Bstrategy==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics=Bstrategy.getDrawGraphics();
        graphics.clearRect(0,0,WIDTH,HEIGHT);
        graphics.fillRect(0,0,WIDTH,HEIGHT);
        graphics.setColor(Color.black);
        graphics.drawImage(sheet.crop(0,0,145,110),0,0,null);
        Bstrategy.show();
        graphics.dispose();
    }

    @Override
    public void run() {
        init();
        while (running){
            tick();
            render();
        }
        stop();
    }

    public synchronized void start(){
        if (running)
            return;
        running=true;
        thread=new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if (!running)
            return;
        running=false;
        try {
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
