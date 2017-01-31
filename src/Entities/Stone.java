package Entities;

import Main.Handler;
import Utils.GameObjectList;

/**
 * Created by Ben on 27/01/2017.
 */
public class Stone extends GameObject {

    private int velY = 0;
    private int gravity = 2;
    boolean falling = false;

    public Stone(Handler handler, int x, int y, ObjectId id) {
        super(handler, x, y, 20, 10, id);
    }

    @Override
    public void update(GameObjectList objects) {
        for(GameObject obj : objects){

            if(obj.getId() == ObjectId.BLOCK){
                if(!obj.getBounds().intersects(getBounds())){
                    falling = true;
                }else{
                    falling = false;
                    velY = 0;
                    y = obj.getY() - height;
                }
            }

        }

        if(falling){
            velY+=gravity;
        }

        y += velY;
    }

    @Override
    public void render() {

        if(visible) {
            handler.getGame().fill(122, 240);
            handler.getGame().ellipse(x, y, width, height);
        }
    }
}
