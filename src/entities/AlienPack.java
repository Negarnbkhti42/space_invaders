package entities;

import frame.GamePanel;
import frame.Handler;
import sun.util.resources.ga.LocaleNames_ga;

import javax.print.attribute.HashAttributeSet;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class AlienPack  {
    private ArrayList<Alien> pack=new ArrayList<>();
    private int speed=250;
    private long lastTime,timer=0;
    private static int alienLimit= (GamePanel.getPanelWidth()-(Creature.getDefaultCreatureWidth()*11))/2;
    private Handler handler;


    public AlienPack(Handler handler){
        this.handler=handler;
        for (int i=0;i<11;i++)
            pack.add(new Alien(handler,alienLimit+(i*Creature.getDefaultCreatureWidth()),50,"blue"));
        for (int i=0;i<11;i++)
            pack.add(new Alien(handler,alienLimit+(i*Creature.getDefaultCreatureWidth()),50+Creature.getDefaultCreatureHeight(),"purple"));
        for (int i=0;i<11;i++)
            pack.add(new Alien(handler,alienLimit+(i*Creature.getDefaultCreatureWidth()),50+Creature.getDefaultCreatureHeight()*2,"red"));
        for (int i=0;i<11;i++)
            pack.add(new Alien(handler,alienLimit+(i*Creature.getDefaultCreatureWidth()),50+Creature.getDefaultCreatureHeight()*3,"lightBlue"));
        for (int i=0;i<11;i++)
            pack.add(new Alien(handler,alienLimit+(i*Creature.getDefaultCreatureWidth()),50+Creature.getDefaultCreatureHeight()*4,"yellow"));
        for (int i=0;i<11;i++)
            pack.add(new Alien(handler,alienLimit+(i*Creature.getDefaultCreatureWidth()),50+Creature.getDefaultCreatureHeight()*5,"green"));
        lastTime=System.currentTimeMillis();
    }

    public void killAlien(Alien alien){
        alien.kill();
        handler.getGameState().getPlayer().increasePoints();
        pack.remove(alien);
        if (pack.isEmpty()){
            handler.getGameState().stateWin();
        }
    }


    public static int getAlienLimit() {
        return alienLimit;
    }

    public ArrayList<Alien> getPack() {
        return pack;
    }
}
