package tuxing;

import java.awt.FlowLayout;

import javax.swing.*;


public class Gui {
	private JFrame f;
    private JButton b1;
    private JButton b2;
 
    public static void main(String args[]) {
        Gui that = new Gui();
        that.go();
    }
 
    public void go() {
        f = new JFrame("GUI example");
        f.setLocation(700, 500);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        f.setLayout(new BoxLayout(b1,10));
        // 设置布局管理器为FlowLayout
        b1 = new JButton("Press Me");
        // 按钮上显示字符"Press Me"
        b2 = new JButton("Don't Press Me");
        f.add(b1);
        f.add(b2);
        f.pack();
        // 紧凑排列，其作用相当于setSize()，即让窗口尽量小，小到刚刚能够包容住b1、b2两个按钮
        f.setVisible(true);
    }


}
