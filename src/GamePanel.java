import gfx.Assets;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GamePanel implements Runnable {
    private Display display;

    private static final String TITLE = "Space invaders";
    private static final int WIDTH = 800, HEIGHT = 600;

    private Thread thread;
    private boolean running = false;

    private BufferStrategy Bstrategy;
    private Graphics graphics;

    private int x = 0;


    private void init() {
        display = new Display(TITLE, WIDTH, HEIGHT);
        Assets.init();
    }

    private void tick() {
        if (x < 800 - 130) {
            x += 10;
        }
    }

    private void render() {
        Bstrategy = display.getCanvas().getBufferStrategy();
        if (Bstrategy == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = Bstrategy.getDrawGraphics();
        graphics.clearRect(0, 0, WIDTH, HEIGHT);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        graphics.setColor(Color.black);
        graphics.drawImage(Assets.greenAlien, x, 0, null);
        graphics.drawImage(Assets.greenAlien_2, x + 130, 0, null);
        graphics.drawImage(Assets.gBullet, x, 70, null);
        Bstrategy.show();
        graphics.dispose();
    }

    @Override
    public void run() {
        init();

        int fps = 2;
        long timeForTick = 1000000000 / 2;
        long lastTime = System.nanoTime();
        long now;
        long delta = 0;
        long tick=0,timer;
        while (running) {
            now = System.nanoTime();
            delta += (now -lastTime) / timeForTick;
            timer=now-lastTime;
            lastTime=now;

            if (delta >= 1) {
                tick();
                render();
                tick++;
                delta--;
            }
            if (timer>=1000000000){
                System.out.println(tick);
            }
        }
        stop();
    }

    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
