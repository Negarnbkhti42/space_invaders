import frame.Display;
import frame.GamePanel;

public class Main {


    public static void main(String[] args) {
        Display display=new Display("space invaders",GamePanel.getPanelWidth(),GamePanel.getPanelHeight());
        display.startPanel();
    }


}
