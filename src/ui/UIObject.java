package ui;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class UIObject {

    protected float x,y;
    protected int width,height;
    protected Rectangle bound;
    protected boolean hovering=false;

    public UIObject(float x,float y,int width, int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;

        bound=new Rectangle((int)x,(int)y,width,height);
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract void onClick();

    public void onMouseMove(MouseEvent e){
        if (bound.contains(e.getX(),e.getY())){
            hovering=true;
        }else {
            hovering=false;
        }
    }

    public void onMouseRelease(MouseEvent e){
        if (hovering)
            onClick();
    }
}
