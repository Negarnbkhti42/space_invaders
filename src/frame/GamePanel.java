package frame;

import gfx.Assets;
import input.KeyManager;
import state.GameState;
import state.MenuState;
import state.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GamePanel implements Runnable {
    private static final String TITLE = "Space invaders";
    private static final int PANEL_WIDTH = 800, PANEL_HEIGHT = 600;
    private Display display;
    private Thread thread;
    private boolean running = false;

    private BufferStrategy Bstrategy;
    private Graphics graphics;

    private State gameState;
    private State menuState;

    private final KeyManager keyManager = new KeyManager();

    public static int getPanelWidth() {
        return PANEL_WIDTH;
    }

    public static int getPanelHeight() {
        return PANEL_HEIGHT;
    }

    private void init() {
        display = new Display(TITLE, PANEL_WIDTH, PANEL_HEIGHT);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        gameState = new GameState(this);
        menuState = new MenuState(this);
        State.setState(gameState);
    }

    private void tick() {
        keyManager.tick();
        if (State.getCurrentState() != null) {
            State.getCurrentState().tick();
        }
    }

    private void render() {
        Bstrategy = display.getCanvas().getBufferStrategy();
        if (Bstrategy == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = Bstrategy.getDrawGraphics();
        graphics.clearRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
        graphics.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
        graphics.setColor(Color.BLACK);
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
                render();
                delta--;
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
}
