package state;

import entities.Alien;
import entities.Player;
import frame.GamePanel;

import java.awt.*;

public class GameState extends State {

    private Player player;
    private Alien greenAlien;

    public GameState(GamePanel game){
        super(game);
        player=new Player(game,(GamePanel.getPanelWidth()/2)-65,870);
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
