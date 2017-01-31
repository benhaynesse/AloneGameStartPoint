package Levels;

import Entities.*;
import Images.BufferedImageLoader;
import Main.Handler;
import Utils.GameObjectList;

import java.awt.image.BufferedImage;

import static Entities.ObjectId.TREE;

/**
 * Created by Ben on 30/01/2017.
 */
public class LevelLoader {

    private GameObjectList objects;
    private Handler handler;

    public LevelLoader(Handler handler){
        this.handler = handler;
        objects = new GameObjectList();
    }

    public void generateLevel(String filename, int blockSize){

        BufferedImage levelImage = BufferedImageLoader.loadImage(filename);
        objects.setWidth(levelImage.getWidth()*blockSize);
        objects.setHeight(levelImage.getHeight()*blockSize);

        for(int yy = 0; yy < levelImage.getHeight(); yy++){
            for(int xx = 0; xx < levelImage.getWidth(); xx++){

                int pixel = levelImage.getRGB(xx,yy);
                int x = xx * blockSize;
                int y = yy * blockSize;

                GameObject obj = new LevelBlock(handler, 0, 0, ObjectId.BLOCK);

                if(pixel == ObjectId.BLOCK.getCol()){
                    obj = new LevelBlock(handler,x,y, ObjectId.BLOCK);
                }

                if(pixel == ObjectId.PLAYER.getCol()){
                    obj = new Player(handler, x,y, ObjectId.PLAYER);
                }

                if(pixel == ObjectId.STONE.getCol()){
                    obj = new Stone(handler,x,y, ObjectId.STONE);
                }

                if(pixel == TREE.getCol()){
                    obj = new Tree(handler, x,y, TREE);
                }

                objects.addObject(obj);

            }
        }


    }

    public GameObjectList getLevel(){
        return objects;
    }

}
