package Main;

import processing.core.PApplet;

/**
 * Created by Ben on 19/01/2017.
 */
public class Game extends PApplet{

    public static final int WIDTH = 900;
    public static final int HEIGHT = 600;



    public void settings(){
        size(WIDTH,HEIGHT);
    }

    public void setup(){

    }

    private void update(){

    }


    public void draw(){
        background(0);

        update();

    }



    public static void main(String[] args) {
        PApplet.main("Main.Game");
    }
}
