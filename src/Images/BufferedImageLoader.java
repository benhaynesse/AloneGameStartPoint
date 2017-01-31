package Images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ben on 30/01/2017.
 */
public class BufferedImageLoader {

    public static BufferedImage loadImage(String file){

        try {
            return ImageIO.read(new File("res/"+file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
