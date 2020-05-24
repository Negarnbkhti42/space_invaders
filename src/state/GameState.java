package state;

import com.sun.scenario.effect.impl.prism.ps.PPSRenderer;
import entities.*;
import frame.GamePanel;
import frame.Handler;
import gfx.Assets;
import sun.dc.pr.PRError;

import java.awt.*;

public class GameState extends State {
    private EntityManager manager;

    private final int x = 0;
    private boolean paused=false;

    public GameState(Handler handler) {
        super(handler);
        manager=new EntityManager(handler,new Player(handler,GamePanel.getPanelWidth()/2,
                GamePanel.getPanelHeight()-Creature.getDefaultCreatureHeight()-10));
       for (Alien alien:(new AlienPack(handler)).getPack())
        manager.addEntity(alien);
    }

    @Override
    public void tick() {
        getInput();
        if (!paused)
        manager.tick();
    }

    @Override
    public void render(Graphics graphic) {
        graphic.drawImage(Assets.background,0,0,GamePanel.getPanelWidth(),GamePanel.getPanelHeight(),null);
        manager.render(graphic);
    }

    public void getInput(){
        if (handler.getKeyManager().esc){
            setPaused(!paused);
        }
    }


    public EntityManager getEntityManager() {
        return manager;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public boolean isPaused() {
        return paused;
    }
}
