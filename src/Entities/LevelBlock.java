package Entities;

import Main.Handler;
import Utils.GameObjectList;

/**
 * Created by Ben on 26/01/2017.
 */
public class LevelBlock extends GameObject {

    public static int blockSize = 30;

    public LevelBlock(Handler handler, int x, int y, ObjectId id) {
        super(handler, x, y, blockSize, blockSize, id);
    }

    @Override
    public void update(GameObjectList objects) {

    }

    @Override
    public void render() {
        game.fill(255);
        game.rect(x,y,width,height);
    }
}
