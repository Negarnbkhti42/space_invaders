package input;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean right,left,space;

    public KeyManager(){
        keys=new boolean[256];
    }

    public void tick(){
        right=keys[KeyEvent.VK_RIGHT];
        left=keys[KeyEvent.VK_LEFT];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
    }
}
