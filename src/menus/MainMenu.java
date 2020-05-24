package menus;

import frame.Handler;
import gfx.Assets;
import state.MenuState;
import state.State;
import ui.ClickListener;
import ui.UIImageButton;
import ui.UIManager;

import java.awt.*;

public class MainMenu extends Menu{


    public MainMenu(Handler handler) {
        super(handler);
        this.init();
    }


        @Override
        public void init() {
            background= Assets.menuBackground;
            uiManager.addObject(new UIImageButton(300, 400, Assets.startButton[0].getWidth(),
                    Assets.startButton[0].getHeight(), Assets.startButton, new ClickListener() {
                @Override
                public void onClick() {
                    handler.getMouseManager().setUiManager(null);
                    State.setState(handler.getGame().getGameState());

                }
            }));
            uiManager.addObject(new UIImageButton(290, 500, Assets.highscoreButton[0].getWidth(),
                    Assets.highscoreButton[0].getHeight(), Assets.highscoreButton, new ClickListener() {
                @Override
                public void onClick() {
                    handler.getMenuState().setCurrentMenu(MenuState.highScoreMenu);
                }
            }));
        }

}
