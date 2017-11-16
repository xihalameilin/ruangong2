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
        // ���ò��ֹ�����ΪFlowLayout
        b1 = new JButton("Press Me");
        // ��ť����ʾ�ַ�"Press Me"
        b2 = new JButton("Don't Press Me");
        f.add(b1);
        f.add(b2);
        f.pack();
        // �������У��������൱��setSize()�����ô��ھ���С��С���ո��ܹ�����סb1��b2������ť
        f.setVisible(true);
    }


}
