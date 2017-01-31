package Entities;

import Main.Game;
import Main.Handler;
import Utils.GameObjectList;

import java.awt.*;

/**
 * Created by Ben on 26/01/2017.
 */
public abstract class GameObject {

    protected Handler handler;
    protected Game game;
    protected int x,y,width,height;
    protected ObjectId id;

    public boolean visible = true;

    public GameObject(Handler handler, int x, int y, int width, int height, ObjectId id) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;
        this.game = handler.getGame();
    }

    public abstract void update(GameObjectList objects);
    public abstract void render();


    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ObjectId getId() {
        return id;
    }

}
