package state;

import frame.GamePanel;
import frame.Handler;
import gfx.Assets;
import gfx.ImageLoader;
import ui.ClickListener;
import ui.UIImageButton;
import ui.UIManager;

import java.awt.*;

public class MenuState extends State {

    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        this.uiManager=new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UIImageButton(300, 400, Assets.startButton[0].getWidth(),
                Assets.startButton[0].getHeight(), Assets.startButton, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                handler.setState(handler.getGame().gameState);

            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics graphic) {
        uiManager.render(graphic);
//        graphic.drawImage(Assets.background,0,0,GamePanel.getPanelWidth(),GamePanel.getPanelHeight(),null);
//        graphic.drawImage(Assets.logo,80,50,(int)(Assets.logo.getWidth()/1.2),(int)(Assets.logo.getHeight()/1.2),null);
//        graphic.drawImage(Assets.greenAlien,20,400,Assets.greenAlien.getWidth()/4,Assets.greenAlien.getHeight()/4,null);
//        graphic.drawImage(Assets.startButton[0],300,400,null);
//        graphic.drawImage(Assets.highscoreButton[0],290,500,null);
    }
}
