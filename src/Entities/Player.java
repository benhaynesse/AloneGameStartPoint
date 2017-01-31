package Entities;

import Main.Handler;
import Utils.GameObjectList;

import java.awt.*;


/**
 * Created by Ben on 26/01/2017.
 */
public class Player extends GameObject {

    private final int MAX_SPEED = 12;
    private int velX, velY;
    private int gravity = 2;
    private boolean falling = true, jumping = false;
    private int speed = 5;

    public boolean interact = false;



    public Player(Handler handler, int x, int y, ObjectId id) {
        super(handler, x, y, 30, 75, id);
    }

    @Override
    public void update(GameObjectList objects) {
        x+=velX;
        y+=velY;

        if(falling || jumping){
            velY += gravity;
            if(velY > MAX_SPEED){
                velY = MAX_SPEED;
            }

        }

        Collision(objects);

    }

    public void move(int dir){
        velX = dir * speed;
    }

    public void jump(){
        if(!jumping && falling) {
            jumping = true;
            velY = -30;
        }
    }

    private void Collision(GameObjectList objs){



        for(GameObject obj : objs) {
            switch(obj.getId()){

                //If its a tile
                case BLOCK:
                    blockCollision(obj);
                    break;





            }
        }




    }



    @Override
    public void render() {
        game.fill(255,0,0);
        game.rect(x,y,width,height);
    }

    private boolean canInteract(GameObject obj){
        return getBounds().intersects(obj.getBounds());
    }


    private void blockCollision(GameObject obj){
        if(getTopBounds().intersects(obj.getBounds())){
            y = obj.getY() + obj.height+2;
            velY = 0;
        }
        if(getBottomBounds().intersects(obj.getBounds())){
            y = obj.getY() - this.height;
            velY =  0;
            falling = false;
            jumping = false;

        }else{
            falling = true;
        }
        if(getLeftBounds().intersects(obj.getBounds())){
            x = obj.getX()+obj.width;
        }
        if(getRightBounds().intersects(obj.getBounds())){
            x = obj.getX() - width;
        }

    }



    private Rectangle getLeftBounds(){
        return new Rectangle(x,y+5,5,height-10);
    }

    private Rectangle getRightBounds(){
        return new Rectangle(x+width-5,y+5,5,height - 10);
    }

    private Rectangle getBottomBounds(){
        return new Rectangle(x+(width/2)-(width/2)/2, y+(height/2),width/2, height/2);
    }

    private Rectangle getTopBounds(){
        return new Rectangle(x+(width/2)-(width/2)/2, y, width/2, height/2);
    }





}
