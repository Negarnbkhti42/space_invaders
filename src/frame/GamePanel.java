package frame;

import gfx.Assets;
import input.KeyManager;
import input.MouseManager;
import state.GameState;
import state.MenuState;
import state.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;

public class GamePanel extends JPanel implements Runnable{
    private static final String TITLE = "Space invaders";
    private static final int PANEL_WIDTH = 1000, PANEL_HEIGHT = 750;
    //private Display display;
    private Thread thread;
    private boolean running = false;

    private BufferStrategy Bstrategy;
    private Graphics graphics;

    private State gameState;
    private State menuState;

    private final KeyManager keyManager = new KeyManager();
    private final MouseManager mouseManager=new MouseManager();
    private Handler handler;

    public static int getPanelWidth() {
        return PANEL_WIDTH;
    }

    public static int getPanelHeight() {
        return PANEL_HEIGHT;
    }

    private void init() {
//        display = new Display(TITLE, PANEL_WIDTH, PANEL_HEIGHT);
//        display.getFrame().addKeyListener(keyManager);
//        display.getFrame().addMouseListener(mouseManager);
//        display.getFrame().addMouseMotionListener(mouseManager);
        this.addMouseListener(mouseManager);
        this.addMouseMotionListener(mouseManager);
        //display.getCanvas().addMouseListener(mouseManager);
       // display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();

        handler=new Handler(this);


        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        State.setState(menuState);


    }

    private void tick() {
        keyManager.tick();
        if (State.getCurrentState() != null) {
            State.getCurrentState().tick();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        g.clearRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
        if (State.getCurrentState() != null) {
            State.getCurrentState().render(g);
        }
    }

    private void render() {
//        Bstrategy = display.getCanvas().getBufferStrategy();
//        if (Bstrategy == null) {
//            display.getCanvas().createBufferStrategy(3);
//            return;
//        }
//        graphics = Bstrategy.getDrawGraphics();
        graphics.clearRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
        if (State.getCurrentState() != null) {
            State.getCurrentState().render(graphics);
        }
        Bstrategy.show();
        graphics.dispose();
    }

    @Override
    public void run() {
        init();

        int fps = 60;
        double timeForTick = 1000000000 / fps;
        long lastTime = System.nanoTime();
        long now;
        double delta = 0;
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timeForTick;
            lastTime = now;

            if (delta >= 1) {
                tick();
                repaint();
                delta--;
            }
            try {
                Thread.sleep(Math.max(0,System.currentTimeMillis()));
            } catch (InterruptedException e) {
                e.printStackTrace();
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

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public State getGameState() {
        return gameState;
    }

    public State getMenuState() {
        return menuState;
    }

//    public Display getDisplay() {
//        return display;
//    }
}
