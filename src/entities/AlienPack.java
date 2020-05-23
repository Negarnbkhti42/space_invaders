package entities;

import frame.GamePanel;

import java.awt.*;
import java.util.LinkedList;

public class AlienPack {
    private LinkedList<Alien> pack=new LinkedList<>();
    private int timer;
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
    }

    public void tick(){
        if (++timer==15) {
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
