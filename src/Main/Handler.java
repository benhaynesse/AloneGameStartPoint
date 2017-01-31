package Main;

import Entities.GameObject;
import Entities.ObjectId;
import Entities.Player;
import Levels.LevelLoader;
import Utils.GameObjectList;

/**
 * Created by Ben on 31/01/2017.
 */
public class Handler {

    private Game game;
    private GameObjectList objects;



    public Handler(Game game){
        this.game = game;
    }

    public GameObjectList createLevel(String filename, int blockSize){
        LevelLoader l = new LevelLoader(this);
        l.generateLevel(filename,blockSize);
        objects = l.getLevel();
        return objects;
    }

    public GameObjectList getObjects() {
        return objects;
    }

    public Player getPlayer(){
        for(GameObject obj : objects){
            if(obj.getId() == ObjectId.PLAYER){
                return (Player) obj;
            }
        }

        return null;
    }

    public void addObject(GameObject object){
        objects.addObject(object);
    }

    public void removeObject(GameObject object){
        objects.removeObject(object);
    }

    public Game getGame(){return game;}

}
