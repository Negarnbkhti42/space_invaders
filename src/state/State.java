package state;

import frame.GamePanel;
import frame.Handler;

import java.awt.*;

public abstract class State {

    private static State currentState = null;
    protected Handler handler;

    public State(Handler handler) {
        this.handler = handler;
    }

    public static void setState(State state) {
        currentState = state;
    }

    public static State getCurrentState() {
        return currentState;
    }

    public abstract void tick();

    public abstract void render(Graphics graphic);
}
