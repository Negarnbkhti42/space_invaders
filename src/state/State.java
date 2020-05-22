package state;

import java.awt.*;

public abstract class State {

    private static State currentState=null;

    public static void setState(State state){
        currentState=state;
    }

    public static State getCurrentState() {
        return currentState;
    }

    public abstract void tick();
    public abstract void render(Graphics graphic);
}
