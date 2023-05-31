import javax.swing.*;
import java.awt.*;

//坦克大战的绘图区域
public class MyPanel extends JPanel {
    //定义我的坦克
    Hero hero = null;
    public MyPanel()
    {
        //初始化自己的坦克
        hero = new Hero(100,100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //填充矩形,默认黑色
        g.fillRect(0,0,1000,750);
        System.out.println("韩顺平");
    }
}
