package state;

import frame.GamePanel;
import frame.Handler;
import gfx.Assets;
import gfx.ImageLoader;
import menus.LoginMenu;
import menus.MainMenu;
import menus.Menu;
import ui.ClickListener;
import ui.UIImageButton;
import ui.UIManager;
import ui.UIObject;

import java.awt.*;

public class MenuState extends State {

    private Menu currentMenu;

    public static Menu mainMenu,highScoreMenu;

    public MenuState(Handler handler) {
        super(handler);

        loadMenus();
        setCurrentMenu(mainMenu);
    }

    public void loadMenus(){
        mainMenu=new MainMenu(handler);
        highScoreMenu=new LoginMenu(handler);
    }

    @Override
    public void tick() {
        currentMenu.tick();
        //uiManager.tick();
    }

    @Override
    public void render(Graphics graphic) {
        currentMenu.render(graphic);
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
        handler.getMouseManager().setUiManager(currentMenu.getUiManager());
    }
}
