package frame;

public class Handler {
    private GamePanel game;

    public Handler(GamePanel game){
        this.game=game;
    }

    public GamePanel getGame() {
        return game;
    }

    public void setGamPanel(GamePanel gamePanel) {
        this.game = gamePanel;
    }
}
