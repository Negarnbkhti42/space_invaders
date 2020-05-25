package frame;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.GenericArrayType;

public class Display {

    private JFrame frame;
   // private Canvas canvas;
    private JPanel gamePanel;

    private final String title;
    private final int width;
    private final int height;


    public Display(String title, int width, int height) {
        this.title = title;
        this.height = height;
        this.width = width;

        this.createFrame();
    }

    private void createFrame() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //canvas = new Canvas();
        gamePanel=new GamePanel();
        gamePanel.setPreferredSize(new Dimension(width, height));
        gamePanel.setMaximumSize(new Dimension(width, height));
        gamePanel.setMinimumSize(new Dimension(width, height));
        gamePanel.setFocusable(false);

        this.getFrame().addKeyListener(((GamePanel)gamePanel).getKeyManager());
        this.getFrame().addMouseListener(((GamePanel)gamePanel).getMouseManager());
        this.getFrame().addMouseMotionListener(((GamePanel)gamePanel).getMouseManager());

        frame.add(gamePanel);
        frame.pack();
    }

    public void startPanel(){
        ((GamePanel)gamePanel).start();
    }

//    public Canvas getCanvas() {
//        return canvas;
//    }

    public JFrame getFrame() {
        return frame;
    }
}



