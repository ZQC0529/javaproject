
package water;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import com.sun.image.codec.jpeg.*;

public class WaterMark 
{
  /**
  *这个程序用来给图片添加水印
  *createMark中的参数说明：
  *
  *filePath 需要添加水印的图片的路径
  *markContent 水印的文字
  *markContentColor 水印文字的颜色
  *qualNum 图片质量
  */
  public boolean createMark(
String filePath,String markContent,Color markContentColor,float qualNum) 
  { 
    ImageIcon imgIcon=new ImageIcon(filePath); 
    Image theImg =imgIcon.getImage(); 
    int width=theImg.getWidth(null); 
    int height= theImg.getHeight(null); 
    BufferedImage bimage = 
new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB); 
    Graphics2D g=bimage.createGraphics();
    g.setColor(markContentColor); 
    g.setBackground(Color.white); 
    g.drawImage(theImg, 0, 0, null ); 

//添加水印的文字和设置水印文字出现的内容 
    g.drawString(markContent,width/5,height/5); 
    g.dispose(); 
    
    try
    { 
	    FileOutputStream out=new FileOutputStream(filePath); 
	    JPEGImageEncoder encoder =JPEGCodec.createJPEGEncoder(out); 
	    JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bimage); 
	    param.setQuality(qualNum, true); 
	    encoder.encode(bimage, param); 
	    out.close(); 
    }
    catch(Exception e)
    { 
	    return false; 
    } 
    return true; 
  } 
}
