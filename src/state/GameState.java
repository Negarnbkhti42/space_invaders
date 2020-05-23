package state;

import entities.*;
import frame.GamePanel;
import frame.Handler;
import gfx.Assets;

import java.awt.*;

public class GameState extends State {

    private final int x = 0;
    private EntityManager manager;

    public GameState(Handler handler) {
        super(handler);
        manager=new EntityManager(handler,new Player(handler,GamePanel.getPanelWidth()/2,
                GamePanel.getPanelHeight()-Creature.getDefaultCreatureHeight()));
    }

    @Override
    public void tick() {
        manager.tick();
    }

    @Override
    public void render(Graphics graphic) {
        graphic.drawImage(Assets.background,0,0,GamePanel.getPanelWidth(),GamePanel.getPanelHeight(),null);
        manager.render(graphic);
    }

}
