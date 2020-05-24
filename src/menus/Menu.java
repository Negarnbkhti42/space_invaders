package menus;

import frame.GamePanel;
import frame.Handler;
import ui.UIManager;
import ui.UIObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Menu {
    protected UIManager uiManager;
    protected Handler handler;
    protected BufferedImage background;

    public Menu(Handler handler){
        this.handler=handler;
        this.uiManager=new UIManager(handler);
    }

    public abstract void init();

    public void tick(){
       // uiManager.tick();
    }

    public void render(Graphics g){
        g.drawImage(background,0,0, GamePanel.getPanelWidth(),GamePanel.getPanelHeight(),null);
        uiManager.render(g);
    }

    public UIManager getUiManager() {
        return uiManager;
    }
}
