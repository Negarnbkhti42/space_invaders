import java.awt.*;

public class GamePanel implements Runnable {
    private Display display;

    private static final String TITLE = "Space invaders";
    private static final int WIDTH = 800, HEIGHT = 600;

    private Thread thread;

    public GamePanel(){
        display=new Display(TITLE,WIDTH,HEIGHT);
    }

    @Override
    public void run() {

    }

    public synchronized void start(){
        thread=new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        try {
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
