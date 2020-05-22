package state;

import entities.Alien;
import entities.Creature;
import entities.Laser;
import entities.Player;
import frame.GamePanel;

import java.awt.*;

public class GameState extends State {

    private final Player player;
    private Alien greenAlien;
    private Laser laser;
    private final int x = 0;

    public GameState(GamePanel game) {
        super(game);
        player = new Player(game, (GamePanel.getPanelWidth() - Creature.getDefaultCreatureWidth()) / 2,
                GamePanel.getPanelHeight() - Creature.getDefaultCreatureHeight() - 30);
        greenAlien = new Alien(0, 0);
        laser=Laser.getLaser(game);
    }

    @Override
    public void tick() {
        player.tick();
        greenAlien.tick();
        laser.tick();
    }

    @Override
    public void render(Graphics graphic) {
        player.render(graphic);
        greenAlien.render(graphic);
        laser.render(graphic);
    }
}
