import java.awt.*;

public class GamePanel {
    private Display display;

    private static final String TITLE = "Space invaders";
    private static final int WIDTH = 800, HEIGHT = 600;

    public GamePanel(){
        display=new Display(TITLE,WIDTH,HEIGHT);
    }
}
