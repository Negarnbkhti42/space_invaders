package frame;

import input.KeyManager;
import input.MouseManager;
import state.GameState;
import state.MenuState;
import state.State;

public class Handler {
    private GamePanel game;

    public Handler(GamePanel game){
        this.game=game;
    }

    public GamePanel getGame() {
        return game;
    }


    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }

    public GameState getGameState(){
        return (GameState)game.getGameState();
    }

    public MenuState getMenuState(){
        return (MenuState)game.getMenuState();
    }
}
