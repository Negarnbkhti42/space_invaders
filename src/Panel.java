import gfx.Assets;
import state.GameState;
import state.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Panel implements Runnable {
    private Display display;

    private static final String TITLE = "Space invaders";
    private static final int PANEL_WIDTH = 1450, PANEL_HEIGHT = 1000;

    private Thread thread;
    private boolean running = false;

    private BufferStrategy Bstrategy;
    private Graphics graphics;

    private State gameState;


    private void init() {
        display = new Display(TITLE, PANEL_WIDTH, PANEL_HEIGHT);
        Assets.init();

        gameState= new GameState();
        State.setState(gameState);
    }

    private void tick() {
        if (State.getCurrentState()!=null){
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

        if (State.getCurrentState()!=null){
            State.getCurrentState().render(graphics);
        }
        Bstrategy.show();
        graphics.dispose();
    }

    @Override
    public void run() {
        init();

        int fps = 3;
        double timeForTick = 1000000000 / fps;
        long lastTime = System.nanoTime();
        long now;
        double delta=0;
        while (running) {
            now = System.nanoTime();
            delta += (now -lastTime) / timeForTick;
            lastTime=now;

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

    public static int getPanelWidth() {
        return PANEL_WIDTH;
    }

    public static int getPanelHeight() {
        return PANEL_HEIGHT;
    }
}
