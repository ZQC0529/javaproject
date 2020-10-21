package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * 游戏面板
 * 里面要放：  背景图片，飞机的图片（英雄机和敌机等）等所有图片，所以要定义一个paint类。
 *
 * 添加背景图片的步骤：
 * 1. 在类中定义图片 并取名（即直接创建一个对象先，但不用new）
 * 2.在构造方法中，调用工具初始化图片
 * 2. 在画图方法paint中，画图。
 */

public class gamePanel extends JPanel{
    BufferedImage bg;    //定义背景图，并取名为bg
    heroPlane hero = new heroPlane();//创建英雄级对象
    //   enemyPlane ep = new enemyPlane();//创建敌机对象
    //不用创建敌机对象了，我们创建敌机的大本营，即敌机的集合。
    List<enemyPlane> eps= new ArrayList<enemyPlane>();//用泛型代表，这里只能放敌机，不能放英雄机，不能放子弹。
    //用集合不用数组的原因： 数组需要提前定义长度，而集合不用。

    //英雄机的弹药库
    List<Fire> fires = new ArrayList<Fire>();
    int score;
    boolean gameover ;//游戏开始时  为false，游戏结束时，为true；


    /**
     * 创建开始游戏的方法
     * 创建并开始一个线程，控制物体的活动
     * 固定格式：  new Thread(){      public void run() {···线程需要做的事情···}     }.start（）;
     */
    public void action() {
        new Thread() {
            public void run() {
                while(true) {
                    if(!gameover){
                        epEnter();
                        epMove();
                        shoot();
                        fireMove();
                        shootEp();
                        hit();
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    repaint();
                }
            }
        }.start();
    }

    protected void hit() {
        //遍历敌机
        for(int i=0;i<eps.size();i++){
            enemyPlane enemyPlane= eps.get(i);
            if(enemyPlane.hitBy(hero)){
                //1.删除敌机
                eps.remove(enemyPlane);
                //2.英雄级血量减少
                hero.hp--;
                //当英雄机的血量减少到0时，游戏结束
                if(hero.hp==0){
                    gameover=true;
                }
            }
        }
    }

    protected void fireMove() {
        //遍历所有子弹
        for(int i=0;i<fires.size();i++){
            //获取每一颗子弹
            Fire fire= fires.get(i);
            //让子弹移动
            fire.move();
        }
    }
    int fireIndex=0;

    protected void shoot() {
        fireIndex++;
        if(fireIndex>10) {
            Fire fire1 = new Fire(hero.x+15, hero.y);
            fires.add(fire1);
            Fire fire2 = new Fire(hero.x+45, hero.y-20);
            fires.add(fire2);
            Fire fire3 = new Fire(hero.x+75, hero.y);
            fires.add(fire3);
            fireIndex=0;
        }
    }

    protected void  shootEp(){
        for(int i=0;i<fires.size();i++){
            Fire fire = fires.get(i);
            bang(fire);
        }
    }

    protected void bang(Fire fire) {
        for(int i=0;i<eps.size();i++){
            enemyPlane enemyPlane= eps.get(i);
            if(enemyPlane.shootBy(fire)){
                enemyPlane.hp=enemyPlane.hp-1;
                if(enemyPlane.hp==0){
                eps.remove(enemyPlane);
                    score=score+1;
                }
                fires.remove(fire);

            }
        }
    }

    protected void epMove() {
        //遍历所有敌机
        for(int i=0;i<eps.size();i++)
        {
            enemyPlane e = eps.get(i);
            e.move();
            //用线程休眠，来实现执行一次就休息一会
        }
    }

    /**
     * 敌机入场的方法
     * 目前的问题：  敌机出现的频率太快
     * 解决方法：执行二十次才创建一个敌机
     */
    int ep_index = 0; // 记录这个epEnter运行的次数。
    protected void epEnter() {
        ep_index ++;
        if (ep_index>=5){
            enemyPlane ep = new enemyPlane();
            eps.add(ep);
            ep_index=0; //再次置为0开始计数。  实现每20次执行一次
        }
    }


    // 构造函数
    public gamePanel(gameFrame frame){
        setBackground(Color.black);
        bg= App.getImg("/image/rick.jpg");

        //在构造函数里创建鼠标监听器（固定格式）；
        /**
         * 1.创建鼠标适配器，即new一个对象
         * 2.确定鼠标需要监听的事件
         *           mouseMoved（） 监听鼠标移动
         *           mouseClicked（）监听鼠标单击
         *           mousePressed（） 监听鼠标按下去
         *           mouseEntered（） 监听鼠标移入界面
         *           mouseExited（） 监听鼠标移出
         *
         * 3.将适配器加入监听器中（固定格式）
         * 4.让英雄机移动到鼠标上（在英雄机中定义它出现在鼠标的x和y上）
         */
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(gameover){
                    hero= new heroPlane();
                    gameover=false;//重置游戏开关
                    score=0;//分数清零
                    eps.clear();
                    fires.clear();

                    repaint();//刷新界面
                }
            }

            public void mouseMoved(MouseEvent e) {
                // MouseEvent 是鼠标的事件，用来记录鼠标做的事情，相当于一个本子。  有getX 和getY 方法返回鼠标的横纵坐标。

                /**当鼠标在游戏界面中移动时会触发的方法。
                 *让英雄机随着鼠标一起移动就是让英雄机的横纵坐标始终等于鼠标的横纵坐标
                 * 所以现在问题就转化为了：获取鼠标的横纵坐标
                 *///System.out.println("鼠标正在移动"); 可以加一行测试代码看鼠标监听器能不能工作
                int mx = e.getX();
                int my = e.getY();
                if(!gameover) {
                    hero.moveToMouse(mx, my);// 到这步，英雄机还是不会随着鼠标移动。但是其实已经实现了，只是没有刷新页面而已，所以要用一个函数来刷新页面
                }
                //重新调用paint方法即可（repaint）
                repaint();//刷新页面

            }
    };
        /**
         * 下面是将适配器加入监听器中（固定模式）
         */
        addMouseListener(adapter);
        addMouseMotionListener(adapter);

        /**
         * 创建键盘监听器：
         * 步骤和创建鼠标监听器相同
         * 1.创建键盘适配器
         * 2.确定需要监听的事件
         * 3.将适配器加入到窗体的键盘监听器中（注意：是窗体的，不能直接在面板这里加）
         */
        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
             //   System.out.println("1111");    测试键盘监听器是否可以工作
                int keycode = e.getKeyCode();

                if(keycode == KeyEvent.VK_UP){
                    //我们敲了“↑”键 ，需要让英雄机向上移动。
                    hero.moveUp();
                    repaint();
                }
                else if (keycode == KeyEvent.VK_DOWN){
                    //我们敲了“↓”键，需要让英雄机向下移动。
                    hero.moveDown();
                    repaint();
                }
                else if (keycode == KeyEvent.VK_LEFT){
                    //我们敲了“←”键，需要让英雄机向下移动。
                    hero.moveLeft();
                    repaint();
                }
                else if (keycode == KeyEvent.VK_RIGHT){
                    //我们敲了“→”键，需要让英雄机向下移动。
                    hero.moveRight();
                    repaint();//repaint()可以不用写这么多，在所有if完了以后写一个repaint就OK了。
                }
            }
        };
        frame.addKeyListener(keyAdapter);//这个键盘监听器方法是在awt包下面的，我们在这里导入了awt，又把frame传入了gamePanel
    }




    @Override
    public void paint(Graphics g) {
        super.paint(g);
        /**
         * 专用的画图方法
         * @param g=画笔
         * 画英雄机等图片（即在游戏面板上显示出来）都要用这个方法，在方法里面执行。
         */
        //参数：   图片名字，x坐标，y坐标，null (适用于背景图大小和面板大小一样的情况下)
        //如果想改变（或控制）图片大小：（用于生成英雄机等）
        // 参数变为：   图片名字，x坐标，y坐标，想要更改为的宽度，想要更改为的高度，null
        //注意：java中x-y坐标系是倒的，即越往屏幕下面y越大。越往屏幕右边x越大。
        //画图只需要执行 g. drawImage(),然后按照参数的格式往里面填充即可。
        //↓  在方法里面执行

        //画图是有顺序的，先画的图片会被后画的覆盖掉。
        g.drawImage(bg,0,0,640,640,null);
        g.drawImage(hero.img,hero.x,hero.y,hero.w,hero.h,null);
        for(int i=0;i<eps.size();i++)
        {
           enemyPlane ep= eps.get(i);
            g.drawImage(ep.img,ep.x,ep.y,ep.w,ep.h,null);
        }
        //画子弹的方法和画敌机的一样
        for(int i=0;i<fires.size();i++)
        {
            Fire fire = fires.get(i);
            g.drawImage(fire.img,fire.x,fire.y,fire.w,fire.h,null);
        }
        //画英雄机的血量
        for(int i=0;i<hero.hp;i++) {
            g.drawImage(hero.img, 450 + i * 35, 5, 30, 30, null);
        }
        g.setColor(Color.white);
        g.setFont(new Font("楷体",Font.BOLD,20));
        g.drawString("消灭的敌机："+score,10,30);
        if(gameover) {
            g.setColor(Color.red);
            g.setFont(new Font("楷体", Font.BOLD, 60));
            g.drawString("GAME OVER!", 160, 200);
            g.setColor(Color.blue);
            g.setFont(new Font("楷体", Font.BOLD, 30));
            g.drawString("Click T0 restart ", 200, 320);
        }


    }
}