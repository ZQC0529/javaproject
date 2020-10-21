package ui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

/**
 * 将多次使用的方法定义为工具类，用static定义方法
 * static特点:公用的，所有对象都可以共用这一份
 * static不依赖对象，可以直接通过类名调用。  即不需要先创建一个对象，再用对象调用。
 * 直接通过类命调用即可。
 */
public class App {
    public static BufferedImage getImg(String path){
        //BufferedImage 用来表示图片的类，读取指定位置上的图片
        //把它封装成一个方法，方便以后调用图片只用喊这个名字就OK了
        try {
            BufferedImage img = ImageIO.read(App.class.getResource(path));
            return img ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**把某张图片变成流，然后通过  ImageIO这个管道 被read读取
         * App.class 会找到App类的路径，根剧这个路径去找图片
         * getResource（）获取图片资源。
         */
        return null;
    }
}
