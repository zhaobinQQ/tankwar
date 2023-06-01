import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//坦克大战的绘图区域
//为了监听 键盘事件,实现KeyListener
public class MyPanel extends JPanel implements KeyListener {
    //定义我的坦克
    Hero hero = null;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理wdsa 键按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){//按下W键
            //改变坦克的方向
            hero.setDirect(0);
            //修改坦克的坐标
            hero.moveUp();
        }else if (e.getKeyCode() == KeyEvent.VK_D){//D键
            hero.setDirect(1);
            hero.moveRight();
        }else if (e.getKeyCode() == KeyEvent.VK_S){//S键
            hero.setDirect(2);
            hero.moveDown();
        }else if (e.getKeyCode() == KeyEvent.VK_A){//A键
            hero.setDirect(3);
            hero.moveLeft();
        }
        //让画板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public MyPanel() {
        //初始化自己的坦克
        hero = new Hero(100, 100);
        hero.setSpeed(5);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //填充矩形,默认黑色
        g.fillRect(0, 0, 1000, 750);
        //画出坦克-封装方法
        drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),0);
    }

    //编写方法,画出坦克

    /**
     * @param x      坦克的左上角x坐标
     * @param y      坦克的左上角y坐标
     * @param g      画笔
     * @param direct 坦克方向(上下左右)
     * @param type   坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        //根据不同类型坦克,设置不同颜色
        switch (type) {
            case 0://我的的坦克
                g.setColor(Color.cyan);
                break;
            case 1://敌人的坦克
                g.setColor(Color.yellow);
                break;
        }
        //根据坦克方向,来绘制对应坦克
        //direct 表示方向(0:向上 1:向右 2:向下 3:向左)
        switch (direct) {
            case 0://表示向上
                g.fill3DRect(x,y,10,60,false);//画出坦克的左边轮子
                g.fill3DRect(x + 30,y ,10,60,false);//画出坦克的右边轮子
                g.fill3DRect(x + 10,y + 10,20,40,false);//花出坦克盖子
                g.fillOval(x+ 10,y+20,20,20);//画出圆形盖子
                g.drawLine(x+20,y+30,x+20,y);//画出炮筒
                break;
            case 1://表示向右
                g.fill3DRect(x,y,60,10,false);//画出坦克的左边轮子
                g.fill3DRect(x ,y + 30,60,10,false);//画出坦克的右边轮子
                g.fill3DRect(x + 10,y + 10,40,20,false);//花出坦克盖子
                g.fillOval(x + 20,y +10,20,20);//画出圆形盖子
                g.drawLine(x+30,y+20,x+60,y+20);//画出炮筒
                break;
            case 2://表示向下
                g.fill3DRect(x,y,10,60,false);//画出坦克的左边轮子
                g.fill3DRect(x + 30,y ,10,60,false);//画出坦克的右边轮子
                g.fill3DRect(x + 10,y + 10,20,40,false);//花出坦克盖子
                g.fillOval(x+ 10,y+20,20,20);//画出圆形盖子
                g.drawLine(x+20,y+30,x+20,y+60);//画出炮筒
                break;
            case 3://表示向左
                g.fill3DRect(x,y,60,10,false);//画出坦克的左边轮子
                g.fill3DRect(x ,y + 30,60,10,false);//画出坦克的右边轮子
                g.fill3DRect(x + 10,y + 10,40,20,false);//花出坦克盖子
                g.fillOval(x + 20,y +10,20,20);//画出圆形盖子
                g.drawLine(x+30,y+20,x,y+20);//画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }

    }

}
