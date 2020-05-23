package entities;

import frame.Handler;
import org.omg.IOP.ENCODING_CDR_ENCAPS;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
    private Handler handler;
    private Player player;
    private AlienPack alienPack;
    private ArrayList<Entity> entities;

    public EntityManager(Handler handler,Player player){
        this.handler=handler;
        this.player=player;
        this.alienPack=new AlienPack(handler);
        entities=new ArrayList<Entity>();
        entities.add(player);
        entities.add(alienPack);
    }

    public void tick(){
        for (int i=0;i<entities.size();i++)
            entities.get(i).tick();
    }

    public void render(Graphics g){
        for (int i=0;i<entities.size();i++)
            entities.get(i).render(g);
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    public void removeEntity(Entity e){
        entities.remove(e);
    }

    public AlienPack getAlienPack() {
        return alienPack;
    }

    public Handler getHandler() {
        return handler;
    }

    public Player getPlayer() {
        return player;
    }
}
