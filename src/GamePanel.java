import java.awt.*;

public class GamePanel implements Runnable {
    private Display display;

    private static final String TITLE = "Space invaders";
    private static final int WIDTH = 800, HEIGHT = 600;

    private Thread thread;
    private boolean running=false;

    public GamePanel(){
        display=new Display(TITLE,WIDTH,HEIGHT);
    }

    private void init(){

    }

    private void tick(){

    }

    private void render(){

    }

    @Override
    public void run() {
        while (running){
            tick();
            render();
        }
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
