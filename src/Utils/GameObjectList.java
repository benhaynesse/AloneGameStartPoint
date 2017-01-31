package Utils;

import DEBUG.Debug;
import Entities.GameObject;
import Entities.ObjectId;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Ben on 30/01/2017.
 */
public class GameObjectList implements Iterable<GameObject> {

    ArrayList<GameObject> objects;
    private int width, height;

    public GameObjectList(){
        objects = new ArrayList<>();
    }

    public GameObjectList(ArrayList<GameObject> objects){
        this.objects = objects;
    }

    public int size(){
        return objects.size();
    }

    public GameObject getObjectByIndex(int index){
        return objects.get(index);
    }

    public void addObject(GameObject obj){
        objects.add(obj);
    }

    public void removeObject(GameObject obj){
        objects.remove(obj);
    }


    public GameObject getObjectById(ObjectId id){
        for(GameObject obj : objects){
            if(obj.getId() == id){
                return obj;
            }
        }
        Debug.printErr("NO OBJECTS OF THAT TYPE FOUND");
        return null;
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

    public Iterator<GameObject> iterator() {
        return objects.iterator();
    }
}
