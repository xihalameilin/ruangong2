package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import rmi.RemoteHelper;
import utility.ResultMessage;
import vo.PersonAccountVO;



public class MainFrame {
	
	private JFrame frame;
	private JButton close;//�رհ�ť
	private JButton min;
	private JButton signin;
	private JButton login;
	private JButton ic;//��˾��鰴ť
	private JButton is;//ϵͳ��鰴ť
	private JTextField idField;
	private JPasswordField passwordField;
	private JPanel imagePanel;
	private JLabel help;
	private JPanel is_panel;
	private JPanel ic_panel;
	private JPanel login_panel;//��¼����
	private JPanel panel;
	/*
	public static void main(String[] args){
		MainFrame frame  = new MainFrame();
	}*/
	
	public MainFrame(){
		//����frame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocation(600, 230);
		//��������
	    Font font0 = new Font("Default",Font.BOLD,30);
		//ȥ�������
		frame.setUndecorated(true);
		//�������
		JLabel title = new JLabel("�ƾ߽�����ϵͳ(PSIS)");
		title.setFont(font0);
		title.setSize(400,40);
		title.setLocation(250,30);
		title.setForeground(Color.pink);
		frame.getContentPane().add(title);
		//������С�����ر�
		close = new JButton("X");
		close.setForeground(Color.white);
		close.addActionListener(new ButtonActionListener());
		close.setSize(80,50);
		close.setLocation(720,0);
		close.setContentAreaFilled(false);
		close.setFocusPainted(false);
		//close.setBorderPainted(false);
		frame.getContentPane().add(close);
		min = new JButton("��");
		min.addActionListener(new ButtonActionListener());
		min.setForeground(Color.white);
		min.setSize(80,50);
		min.setLocation(640,0);
		min.setContentAreaFilled(false);
		min.setFocusPainted(false);
		frame.getContentPane().add(min);
		//��������
	    Font font = new Font("Default",Font.PLAIN,20);
	    
		//�û���¼
		login = new JButton("<html>�û���¼<br>Regist</html>");
		login.addActionListener(new ButtonActionListener());
		login.setForeground(Color.white);
		login.setSize(250,150);
		login.setLocation(0,100);
		//����͸����ť
		login.setContentAreaFilled(false);
		login.setFont(font);
		//ȥ������߿�
		login.setFocusPainted(false);
		frame.getContentPane().add(login);
		//ͼ��
		ImageIcon img_login = new ImageIcon("1.png");
		JLabel label_login = new JLabel(img_login);
		label_login.setSize(img_login.getIconWidth(),img_login.getIconHeight());
		label_login.setLocation(180,150);
		frame.getContentPane().add(label_login);
		
		//��˾���
		ic = new JButton("<html>��˾���<br>Introduction of company</html>");
		ic.addActionListener(new ButtonActionListener());
		ic.setForeground(Color.white);
		ic.setSize(250,150);
		ic.setLocation(0,250);
		ic.setContentAreaFilled(false);
		ic.setFont(font);
		ic.setFocusPainted(false);
		frame.getContentPane().add(ic);
		//ͼ��
		ImageIcon img_ic = new ImageIcon("3.png");
		JLabel label_ic = new JLabel(img_ic);
		label_ic.setSize(img_ic.getIconWidth(),img_ic.getIconHeight());
		label_ic.setLocation(180,290);
		frame.getContentPane().add(label_ic);
		
		//ϵͳ���
		is = new JButton("<html>ϵͳ���<br>Introduction of system</html>");
		is.addActionListener(new ButtonActionListener());
		is.setForeground(Color.white);
		is.setSize(250,150);
		is.setLocation(0,400);
		is.setContentAreaFilled(false);
		is.setFont(font);
		is.setFocusPainted(false);
		frame.getContentPane().add(is);
		//ͼ��
		ImageIcon img_is = new ImageIcon("4.png");
		JLabel label_is = new JLabel(img_is);
		label_is.setSize(img_ic.getIconWidth(),img_ic.getIconHeight());
		label_is.setLocation(180,435);
		frame.getContentPane().add(label_is);
		
		/*
		 * ��ʼpanel
		 */
		panel = new JPanel();
		panel.setLayout(null);
		panel.setLocation(300,100);
		panel.setSize(400,400);
		panel.setVisible(true);
		panel.setOpaque(false);
		JLabel label = new JLabel("��ӭ����");
		label.setLocation(50,130);
		label.setSize(150,40);
		label.setForeground(Color.pink);
		label.setFont(font0);
		ImageIcon imgicon = new ImageIcon("����.gif");
		JLabel imgLabel = new JLabel(imgicon);
		imgLabel.setLocation(200,100);
		imgLabel.setSize(imgicon.getIconWidth(),imgicon.getIconHeight());
		panel.add(imgLabel);
		panel.add(label);
		frame.add(panel);
		
		/*
		 * is_panel��ʼ��
		 */
		is_panel = new JPanel();
		is_panel.setLayout(null);
    	is_panel.setLocation(300,100);
    	is_panel.setSize(400,400);
    	is_panel.setVisible(false);
    	is_panel.setOpaque(false);
    	String intro1="<html>�ƾ߽�����ϵͳ���<br>ϵͳּ�������߹���Ч�ʺ��û������<br>ϵͳ���·��������û���ϵͳ���÷ֲ㿪��<br>�����ݿ�Ϊ֧�ţ��ṩ��Ҫ����ɾ�Ĳ����<br>ϵͳĿ��Ϊ:<br>ϵͳ�������������º󣬼��ټ�ѹ��棬��<br>�����۶��߲�����Ա����Ч�ʣ�Ϊ����<br>�ľ�����֧��</html>";
    	JLabel is_label = new JLabel(intro1);
    	is_label.setLayout(null);
    	is_label.setLocation(0,0);
    	is_label.setSize(1500,300);
    	is_label.setForeground(Color.pink);
    	Font fonttt = new Font("Default",Font.BOLD,20);
    	is_label.setFont(fonttt);
    	is_panel.add(is_label);
    	frame.add(is_panel);
    	
    	/*
    	 * login_panel��ʼ��
    	 */
    	login_panel = new JPanel();
    	login_panel.setLayout(null);
		login_panel.setLocation(300,100);
		login_panel.setSize(400,400);
		login_panel.setVisible(false);
		login_panel.setOpaque(false);
		
		idField = new JTextField("");
		idField.setSize(220, 50);
	    idField.setLocation(100,50);
		idField.setFont(font);
		login_panel.add(idField);
		JLabel idLabel = new JLabel("�û���");
		idLabel.setLayout(null);
		idLabel.setForeground(Color.white);
		idLabel.setSize(100, 150);
		idLabel.setLocation(20,0);
		idLabel.setFont(font);
		login_panel.add(idLabel);
		
		passwordField = new JPasswordField("");
		passwordField.setSize(220, 50);
		passwordField.setLocation(100,150);
		passwordField.setFont(font);
		login_panel.add(passwordField);
		JLabel pwLabel = new JLabel("����");
		pwLabel.setLayout(null);
		pwLabel.setForeground(Color.white);
		pwLabel.setSize(220,50);
		pwLabel.setLocation(30,150);
		pwLabel.setFont(font);
		login_panel.add(pwLabel);
		
		//�����¼button
		signin = new JButton("��¼");
		signin.addActionListener(new ButtonActionListener());
		signin.setLayout(null);
		signin.setSize(80,50);
		signin.setLocation(170,270);
		signin.setFont(font);
		signin.setBackground(Color.pink);
		signin.setFocusPainted(false);
		login_panel.add(signin);
		frame.add(login_panel);
		
		/*
		 * ic_panel��ʼ��
		 */
		ic_panel = new JPanel();
		ic_panel.setLayout(null);
		ic_panel.setLocation(300,100);
		ic_panel.setSize(400,400);
		ic_panel.setVisible(false);
		ic_panel.setOpaque(false);
		String intro="<html>�Ͼ�SE�ƾ߹�˾<br>���Ͼ�����Ʒ�Ƶ��ƹ㼰��Ŀ��<br>������ۡ������������ȹ���<br>������������Ŀҵ����ʩ����λ��<br>�����̡����Ժ���ն��û���</html>";
		JLabel ic_label = new JLabel(intro);
    	ic_label.setLayout(null);
    	ic_label.setLocation(0,0);
    	ic_label.setSize(1500,300);
    	ic_label.setForeground(Color.pink);
    	Font fontt = new Font("Default",Font.BOLD,25);
    	ic_label.setFont(fontt);
    	ic_panel.add(ic_label);
    	frame.add(ic_panel);
		
		//���� Help
		ImageIcon img_help = new ImageIcon("2.png");
		JLabel help_label = new JLabel(img_help);
		help_label.addMouseListener(new LabelActionListener());
		help_label.setSize(img_help.getIconWidth(),img_help.getIconHeight());
		help_label.setLocation(550,500);
		frame.getContentPane().add(help_label);
		help = new JLabel("HELP");
		help.setLocation(420,510);
		help.setSize(100,30);
		help.setFont(font0);
		help.setForeground(Color.black);
		frame.getContentPane().add(help);
		//���뱳��ͼƬ
		imagePanel = new ImageJPanel(new ImageIcon("������.jpg").getImage());
		frame.getContentPane().add(imagePanel);
		frame.setVisible(true);
	}

   class ButtonActionListener implements ActionListener{
	  // private Font font;
	    @Override
	    public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		    if(e.getSource() == close){
		    	frame.dispose();
		    }
		    else if(e.getSource() == min){
		    	frame.setExtendedState(JFrame.ICONIFIED);
		    }
		    else if(e.getSource() == login){
				login_panel.setVisible(true);
				panel.setVisible(false);
				is_panel.setVisible(false);
		    	ic_panel.setVisible(false);
		    	frame.repaint();
		    }
		    else if(e.getSource() == is){
		    	is_panel.setVisible(true);
		    	panel.setVisible(false);
		    	ic_panel.setVisible(false);
		    	login_panel.setVisible(false);
		    	frame.repaint();
		    }
		    else if(e.getSource() == ic){
		    	ic_panel.setVisible(true);
		    	panel.setVisible(false);
		    	is_panel.setVisible(false);
		    	login_panel.setVisible(false);
		    	frame.repaint();
		    }
		    if(e.getSource() == signin){
		    	String id = idField.getText();
		    	PersonAccountVO p =new PersonAccountVO();
		    	String pw = new String(passwordField.getPassword());
		    	p.setNumber(id);
		    	p.setPassword(pw);
		    	ResultMessage res=null;
		    	try {
					res=RemoteHelper.getInstance().getLoginblservice().login(p);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	if(res.isIssuccess()==true){
		    		if(res.getMessage().substring(0,1).equals("��")){
		    			new Adminui(res.getMessage());
		    			frame.dispose();
		    		}
		    		else if(res.getMessage().substring(0,1).equals("��")){
		    			new Stockmanui(res.getMessage());
		    			frame.dispose();
		    		}
		    		else if(res.getMessage().substring(0,1).equals("��")){
		    			new Finacialmanui(res.getMessage());
		    			frame.dispose();
		    		}
		    		else if(res.getMessage().substring(0,1).equals("��")){
		    		    new Salesmanui(res.getMessage());
		    		    frame.dispose();
		    		}
		    		else if(res.getMessage().substring(0,1).equals("��")){
		    			new Managerui(res.getMessage());
		    			frame.dispose();
		    		}
		    	}else{
		    	    JOptionPane.showMessageDialog(frame.getContentPane(), res.getMessage());
		    	}
		    }
	    }
    }
    
   class LabelActionListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println("help");
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			help.setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			help.setForeground(Color.black);
		}

   }
   class ImageJPanel extends JPanel{ 
    /**
	 * 
	 */
	  private static final long serialVersionUID = 1L;
	  private Image image; 
      public ImageJPanel(Image image){  
          this.image=image; 
          Dimension size = new Dimension(image.getWidth(null),image.getHeight(null)); 
          setSize(size); 
      } 
      @Override 
      protected void paintComponent(Graphics g) {
    	  super.paintComponent(g); 
    	  Dimension size=this.getParent().getSize(); 
    	  g.drawImage(image,0,0,size.width,size.height,null); 
      } 
    } 
   
}
   