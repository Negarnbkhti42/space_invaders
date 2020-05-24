package entities;

import frame.Handler;
import org.omg.IOP.ENCODING_CDR_ENCAPS;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;

    public EntityManager(Handler handler,Player player){
        this.handler=handler;
        this.player=player;
        entities=new ArrayList<Entity>();
        entities.add(player);
    }

    public void tick(){
        for (int i=0;i<entities.size();i++) {
            Entity e=entities.get(i);
            e.tick();
            if (e.getHealth()==0)
                entities.remove(e);
        }
    }

    public void render(Graphics g){
        for (int i=0;i<entities.size();i++) {
            Entity e=entities.get(i);
            e.render(g);
        }
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    public void removeEntity(Entity e){
        entities.remove(e);
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public Handler getHandler() {
        return handler;
    }

    public Player getPlayer() {
        return player;
    }
}
