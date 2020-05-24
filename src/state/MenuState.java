package state;

import frame.GamePanel;
import frame.Handler;
import gfx.Assets;
import gfx.ImageLoader;

import java.awt.*;

public class MenuState extends State {

    public MenuState(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphic) {
        graphic.drawImage(Assets.background,0,0,GamePanel.getPanelWidth(),GamePanel.getPanelHeight(),null);
        graphic.drawImage(Assets.logo,80,50,(int)(Assets.logo.getWidth()/1.2),(int)(Assets.logo.getHeight()/1.2),null);
        graphic.drawImage(Assets.greenAlien,20,400,Assets.greenAlien.getWidth()/4,Assets.greenAlien.getHeight()/4,null);
        graphic.drawImage(Assets.startButton[0],300,400,null);
        graphic.drawImage(Assets.highscoreButton[0],290,500,null);
    }
}
