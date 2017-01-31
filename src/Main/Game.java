package Main;

import Entities.GameObject;
import Entities.ObjectId;
import Utils.GameObjectList;
import View.Camera;
import processing.core.PApplet;

import java.awt.*;

/**
 * Created by Ben on 19/01/2017.
 */
public class Game extends PApplet{

    public static final int WIDTH = 900;
    public static final int HEIGHT = 600;


    private Handler handler;
    private Camera camera;
    private GameObjectList objects;



    public void settings(){
        size(WIDTH,HEIGHT);
    }

    public void setup(){

        init();


    }

    private void init(){
        handler = new Handler(this);
        objects = handler.createLevel("level.png",30);
        camera = new Camera(handler.getPlayer(), WIDTH, HEIGHT, objects.getWidth(), objects.getHeight());
    }

    private void update(){




        for(GameObject obj : objects){
            if(obj.getId() == ObjectId.PLAYER) {
                obj.update(objects);
            }
            if(obj.getId() == ObjectId.TREE || obj.getId() == ObjectId.STONE){
                if(obj.getBounds().intersects(camera.getBounds())){
                    obj.update(objects);
                }
            }

        }

        camera.update(handler.getPlayer());




    }


    public void draw(){
        background(0);

        update();
        println(frameRate);

        //Set Camera position
        translate(-camera.x, -camera.y);
        for(GameObject obj : objects){
            //Used to only render things in camera view
            if(obj.getBounds().intersects(camera.getBounds())) {
                obj.render();
            }
        }
        //Resets translation everything after things will be draw normal location
        translate(camera.x, camera.y);
    }

    public void keyPressed(){
        if(key == 'd'){
            handler.getPlayer().move(1);
        }

        if(key == 'a'){
            handler.getPlayer().move(-1);
        }
    }

    public void keyReleased(){

        if(key == 'd'){
            handler.getPlayer().move(0);
        }

        if(key == 'a'){
            handler.getPlayer().move(0);
        }
    }



    public static void main(String[] args) {
        PApplet.main("Main.Game");
    }
}
