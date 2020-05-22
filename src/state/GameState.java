package state;

import entities.Alien;
import entities.Creature;
import entities.Player;
import frame.GamePanel;

import java.awt.*;

public class GameState extends State {

    private Player player;
    private Alien greenAlien;

    public GameState(GamePanel game){
        super(game);
        player=new Player(game,(GamePanel.getPanelWidth()- Creature.getDefaultCreatureWidth())/2,
                GamePanel.getPanelHeight()-Creature.getDefaultCreatureHeight()-30);
        greenAlien=new Alien(0,0);
    }

    private int x=0;
    @Override
    public void tick() {
        player.tick();
        greenAlien.tick();
    }

    @Override
    public void render(Graphics graphic) {
        player.render(graphic);
        greenAlien.render(graphic);
    }
}
