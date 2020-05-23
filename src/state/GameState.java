package state;

import entities.*;
import frame.GamePanel;
import gfx.Assets;

import java.awt.*;

public class GameState extends State {

    private final Player player;
    private AlienPack alienPack;
    private final int x = 0;

    public GameState(GamePanel game) {
        super(game);
        player = new Player(game, (GamePanel.getPanelWidth() - Creature.getDefaultCreatureWidth()) / 2,
                GamePanel.getPanelHeight() - Creature.getDefaultCreatureHeight() - 30);
        alienPack=new AlienPack();
    }

    @Override
    public void tick() {
        player.tick();
        alienPack.tick();
    }

    @Override
    public void render(Graphics graphic) {
        graphic.drawImage(Assets.background,0,0,GamePanel.getPanelWidth(),GamePanel.getPanelHeight(),null);
        player.render(graphic);
        alienPack.render(graphic);
    }
}
