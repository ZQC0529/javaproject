package ui;

public class Fire extends flightOBJ {
    int direction;// 定义方向   0：左上角，1：中间，2：右上角
    /**
     * @param hx= 英雄机的x坐标
     * @param hy= 英雄级的y坐标
     */
    public Fire(int hx, int hy){
        //加子弹的话就多加一个 int direction
        img= App.getImg("/image/fire.png");
        w=img.getWidth()/4;
        h=img.getHeight()/4;
        // 确定子弹的位置（初始位置在英雄机上）
        x=hx;
        y=hy;
    }

    public void move() {
//        if(direction==0);y-=10;x-=5;
//        if(direction==1);y-=10;
//        if(direction==2);x+=5;y-=10;
        y=y-10;
    }
}
