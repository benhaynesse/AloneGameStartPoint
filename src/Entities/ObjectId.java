package Entities;

import java.awt.*;

/**
 * Created by Ben on 26/01/2017.
 */
public enum ObjectId {
    BLOCK(Color.BLACK),STONE(Color.GRAY),PLAYER(Color.RED),TREE(Color.GREEN);

    private Color col;
    ObjectId(Color col){
        this.col = col;
    }

    public int getCol(){
        return col.getRGB();
    }

}
