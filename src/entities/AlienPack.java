package entities;

import frame.GamePanel;
import frame.Handler;
import sun.util.resources.ga.LocaleNames_ga;

import javax.print.attribute.HashAttributeSet;
import java.awt.*;
import java.util.LinkedList;

public class AlienPack extends Entity {
    private LinkedList<Alien> pack=new LinkedList<>();
    private int speed=250;
    private long lastTime,timer=0;
    private static int alienLimit= (GamePanel.getPanelWidth()-(Creature.getDefaultCreatureWidth()*11))/2;


    public AlienPack(Handler handler){
        super(handler,alienLimit,0,11*Creature.DEFAULT_CREATURE_WIDTH,6*Creature.DEFAULT_CREATURE_HEIGHT);
        for (int i=0;i<11;i++)
            pack.add(new Alien(handler,alienLimit+(i*Creature.getDefaultCreatureWidth()),20,"blue"));
        for (int i=0;i<11;i++)
            pack.add(new Alien(handler,alienLimit+(i*Creature.getDefaultCreatureWidth()),Creature.getDefaultCreatureHeight()+20,"purple"));
        for (int i=0;i<11;i++)
            pack.add(new Alien(handler,alienLimit+(i*Creature.getDefaultCreatureWidth()),20+Creature.getDefaultCreatureHeight()*2,"red"));
        for (int i=0;i<11;i++)
            pack.add(new Alien(handler,alienLimit+(i*Creature.getDefaultCreatureWidth()),20+Creature.getDefaultCreatureHeight()*3,"lightBlue"));
        for (int i=0;i<11;i++)
            pack.add(new Alien(handler,alienLimit+(i*Creature.getDefaultCreatureWidth()),20+Creature.getDefaultCreatureHeight()*4,"yellow"));
        for (int i=0;i<11;i++)
            pack.add(new Alien(handler,alienLimit+(i*Creature.getDefaultCreatureWidth()),20+Creature.getDefaultCreatureHeight()*5,"green"));
        lastTime=System.currentTimeMillis();
    }

    @Override
    public void tick(){
        timer+=System.currentTimeMillis()-lastTime;
        lastTime=System.currentTimeMillis();
        if (timer>=speed) {
            timer=0;
            for (int i = 0; i < pack.size(); i++)
                pack.get(i).tick();
        }
    }

    @Override
    public void render(Graphics g){

            for (int i = 0; i < pack.size(); i++)
                pack.get(i).render(g);
    }

    public static int getAlienLimit() {
        return alienLimit;
    }

    public LinkedList<Alien> getPack() {
        return pack;
    }
}
