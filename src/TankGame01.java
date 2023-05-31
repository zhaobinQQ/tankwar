import javax.swing.*;

public class TankGame01 extends JFrame {
    //定义Mypanel
    MyPanel mp = null;
    public static void main(String[] args) {
        TankGame01 tankGame01 = new TankGame01();
    }
    public TankGame01(){
        mp = new MyPanel();
        //把面板(就是游戏绘图区域)
        this.add(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
