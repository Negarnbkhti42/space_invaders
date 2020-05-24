package frame;

import state.State;

public class Handler {
    private GamePanel game;
    private State state;

    public Handler(GamePanel game){
        this.game=game;
    }

    public GamePanel getGame() {
        return game;
    }

    public void setGamPanel(GamePanel gamePanel) {
        this.game = gamePanel;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}