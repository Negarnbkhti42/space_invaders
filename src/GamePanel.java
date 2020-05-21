import java.awt.*;
import java.awt.image.BufferStrategy;

public class GamePanel implements Runnable {
    private Display display;

    private static final String TITLE = "Space invaders";
    private static final int WIDTH = 800, HEIGHT = 600;

    private Thread thread;
    private boolean running=false;

    private BufferStrategy Bstrategy;
    private Graphics graphics;



    private void init(){
        display=new Display(TITLE,WIDTH,HEIGHT);
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
        graphics.setColor(Color.red);
        graphics.drawRect(-10,70,70,90);
        graphics.setColor(Color.green);
        graphics.fillRect(80,90,50,70);
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
