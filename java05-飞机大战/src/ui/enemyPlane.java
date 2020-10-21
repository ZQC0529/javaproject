package ui;

import java.util.Random;

public class enemyPlane extends flightOBJ {
     int hp;
    int sp;

    public enemyPlane(){
        Random random = new Random();        //↓： 定义随机敌机生成到随机位置  用到random类。
        int index = random.nextInt(15)+1;
        String path = "/image/ep"+(index<10?"0":"")+index+".png";
       // System.out.println(path);
        img = App.getImg(path);
        if(index<8){
            hp=1;
        }
        else if(index<11){
            hp=2;
        }
        else {
            hp=3;
        }

        y=-h;
        w=50;
        h=50;
        //w=img.getWidth();
        //h=img.getHeight();
        x= random.nextInt(640-w);//最右边的坐标应该是512-w   nextInt（num）表示选取【0，num）的整数。
        sp=17-index;
    }

    public void move() {
        // 敌机移动的方法   向下移动
        y=y+sp;
    }

    public boolean shootBy(Fire fire) {
        boolean hit = x<=fire.x+fire.w &&
                x>=fire.x-w &&
                y<=fire.y+fire.h&&
                y>=fire.y-h;
        return hit;
    }

    public boolean hitBy(heroPlane hero) {
        boolean hitHero = x<=hero.x+hero.w &&
                x>=hero.x-w &&
                y<=hero.y+hero.h&&
                y>=hero.y-h;
        return hitHero;
    }
}
