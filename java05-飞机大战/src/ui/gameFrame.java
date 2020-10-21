package ui;

import javax.swing.*;

/**
 * 游戏框架
 */
public class gameFrame extends JFrame {
    public gameFrame() {
        setTitle("不写完不睡觉");//设置标题
        setSize(640, 640);
        /**
         * java中，只有宽和高的概念，横向宽，纵向高，前面宽后面高。
         */
        setLocationRelativeTo(null);
        setResizable(false);//关闭窗体时自动退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗体的时候退出程序

    }


    public static void main(String[] args) {
        gameFrame frame = new gameFrame();
        gamePanel panel = new gamePanel(frame); // 添加这个参数的目的：方便在面板中添加键盘监听器。而监听器又只能在窗体中添加。
        //开始游戏
        panel.action();
        frame.add(panel);

        //将窗体和面板结合起来，如果没有这句下面显示窗体还是不会显现出面板上的东西。
        frame.setVisible(true);
        //true:显示   false：隐藏
    }
}