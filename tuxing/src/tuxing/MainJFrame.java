package tuxing;
import javax.swing.ImageIcon;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JPanel;  
public class MainJFrame extends JFrame {  
  
    public MainJFrame() {  
      /* //���ñ���  
        super("JFram���ñ���ͼƬ(Cannel_2020)");  
        //���ô�С  
        setSize(500, 400);  
        //����λ��  
        setLocation(200, 50);  
        //����ͼƬ��·���������·�����߾���·��������ͼƬ����"java��Ŀ��"���ļ��£�  
        String path = "huoying.jpg";  
        // ����ͼƬ  
        ImageIcon background = new ImageIcon(path);  
        // �ѱ���ͼƬ��ʾ��һ����ǩ����  
        JLabel label = new JLabel(background);  
        // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������  
        label.setBounds(0, 0, this.getWidth(), this.getHeight());  
        // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��  
        JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);  
        // �ѱ���ͼƬ���ӵ��ֲ㴰�����ײ���Ϊ����  
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
        //���ÿɼ�  
        setVisible(true);  
        //��رհ�ťʱ�˳�  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); */ 
    	String path="huoying.jpg";
    	ImageIcon background =new ImageIcon(path);
    	JFrame frame=new JFrame();
    	JLabel label=new JLabel(background);
    	frame.setBounds(700,500,500,400);
    	label.setBounds(0, 0, frame.getWidth(), frame.getHeight());
    	frame.add(label);
    	frame.setVisible(true);
    	
    }  
  
    public static void main(String[] args) {  
        new MainJFrame();  
    }  
}  