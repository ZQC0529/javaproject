package ui;

import java.awt.image.BufferedImage;

public class heroPlane extends flightOBJ{
    public int hp;

    public heroPlane(){
        img= App.getImg("/image/hero.png");
        x=250;
        y=500;
        //定义横纵坐标，定义英雄机开始时出现的位置。
        w=img.getWidth();
        h=img.getHeight();
        //用图片的方法来获取宽度和高度。
        hp=3;
    }

    /**
     * 定义英雄机移动到鼠标的位置上去
     * @param mx=鼠标的横坐标
     * @param my=鼠标的纵坐标
     */


    public void moveToMouse(int mx, int my){
        x= mx;
        y= my;
    }

    public void moveUp(){
        y=y-10;
    }
    public void moveDown(){
        y=y+10;
    }
    public void moveLeft(){
        x=x-10;
    }
    public void moveRight(){
        x=x+10;
    }
}
