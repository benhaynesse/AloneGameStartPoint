package View;

import Entities.Player;
import Main.Game;

import java.awt.*;

/**
 * Created by Ben on 30/01/2017.
 */
public class Camera {

    public int x,y;

    private int GameWidth, GameHeight;
    private int offsetMinX, offsetMinY, offsetMaxX, offsetMaxY;


    public Camera(Player p, int GameWidth, int GameHeight, int mapWidth, int mapHeight){
        this.x = p.getX();
        this.y = p.getY();
        this.GameWidth = GameWidth;
        this.GameHeight = GameHeight;

        offsetMinX = 0;
        offsetMinY = 0;
        offsetMaxX = mapWidth - GameWidth;
        offsetMaxY = mapHeight - GameHeight;
        

    }
    public void update(Player p){

        this.x = p.getX() - GameWidth/2;
        this.y = p.getY() - GameHeight/2;

        if(x < offsetMinX) x = offsetMinX;
        else if(x > offsetMaxX) x = offsetMaxX;
        if(y < offsetMinY) y = offsetMinY;
        else if(y > offsetMaxY) y = offsetMaxY;
    }


    public Rectangle getBounds(){
        return new Rectangle(x,y,GameWidth, GameHeight);
    }

}
