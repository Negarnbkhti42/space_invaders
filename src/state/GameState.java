package state;

import com.sun.scenario.effect.PhongLighting;
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
    private boolean win=false;
    private Player player;
    private AlienPack pack;
    private long winTime;

    public GameState(Handler handler) {
        super(handler);
        this.player=new Player(handler,GamePanel.getPanelWidth()/2,
                GamePanel.getPanelHeight()-Creature.getDefaultCreatureHeight()-10);
        manager=new EntityManager(handler,player);
        pack=new AlienPack(handler);
       for (Alien alien:pack.getPack())
        manager.addEntity(alien);
    }

    @Override
    public void tick() {
        getInput();
        if (!paused)
        manager.tick();
        if (win){
            if (System.currentTimeMillis()-winTime>=4000)
                startNewLevel();
        }
    }

    @Override
    public void render(Graphics graphic) {
        graphic.drawImage(Assets.background,0,0,GamePanel.getPanelWidth(),GamePanel.getPanelHeight(),null);
        manager.render(graphic);
        graphic.setColor(Color.green);
        graphic.setFont(new Font("ARCADECLASSIC",Font.PLAIN,50));
        graphic.drawString(Integer.toString(player.getPoints()),0,40);
        if (win) {
            graphic.setFont(new Font("ARCADECLASSIC",Font.PLAIN,100));
            graphic.drawString("you win", 300, 400);
        }
    }

    public void stateWin(){
        win=true;
        paused=true;
        winTime=System.currentTimeMillis();
    }

    public void startNewLevel(){
        pack=new AlienPack(handler);
        for (Alien alien:pack.getPack())
            manager.addEntity(alien);
        player.setxPosition(GamePanel.getPanelWidth()/2);
        win=false;
        paused=false;
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

    public AlienPack getPack() {
        return pack;
    }

    public Player getPlayer() {
        return player;
    }
}
