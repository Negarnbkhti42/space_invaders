package entities;

import frame.GamePanel;
import sun.util.resources.ga.LocaleNames_ga;

import java.awt.*;
import java.util.LinkedList;

public class AlienPack {
    private LinkedList<Alien> pack=new LinkedList<>();
    private int speed=250;
    private long lastTime,timer=0;
    private static int alienLimit= (GamePanel.getPanelWidth()-(Creature.getDefaultCreatureWidth()*11))/2;


    public AlienPack(){
        for (int i=0;i<11;i++)
            pack.add(new Alien(alienLimit+(i*Creature.getDefaultCreatureWidth()),0,"blue"));
        for (int i=0;i<11;i++)
            pack.add(new Alien(alienLimit+(i*Creature.getDefaultCreatureWidth()),Creature.getDefaultCreatureHeight(),"purple"));
        for (int i=0;i<11;i++)
            pack.add(new Alien(alienLimit+(i*Creature.getDefaultCreatureWidth()),Creature.getDefaultCreatureHeight()*2,"red"));
        for (int i=0;i<11;i++)
            pack.add(new Alien(alienLimit+(i*Creature.getDefaultCreatureWidth()),Creature.getDefaultCreatureHeight()*3,"lightBlue"));
        for (int i=0;i<11;i++)
            pack.add(new Alien(alienLimit+(i*Creature.getDefaultCreatureWidth()),Creature.getDefaultCreatureHeight()*4,"yellow"));
        for (int i=0;i<11;i++)
            pack.add(new Alien(alienLimit+(i*Creature.getDefaultCreatureWidth()),Creature.getDefaultCreatureHeight()*5,"green"));
        lastTime=System.currentTimeMillis();
    }

    public void tick(){
        timer+=System.currentTimeMillis()-lastTime;
        lastTime=System.currentTimeMillis();
        if (timer>=speed) {
            timer=0;
            for (int i = 0; i < pack.size(); i++)
                pack.get(i).tick();
        }
    }

    public void render(Graphics g){

            for (int i = 0; i < pack.size(); i++)
                pack.get(i).render(g);
    }

    public static int getAlienLimit() {
        return alienLimit;
    }
}
