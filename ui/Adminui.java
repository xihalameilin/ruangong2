package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import rmi.RemoteHelper;
import ui.Stockmanui.ButtonActionListener;
import utility.DatetoString;
import utility.ResultMessage;
import vo.LogVO;
import vo.PersonAccountVO;

public class Adminui {
	
	private String operator;//����Ա
	private JFrame frame;
	private JPanel aa_panel;//�����˻�����
	private JPanel ua_panel;//�޸��˻�Ȩ�޽���
	private JButton aa;//�����˻���ť
	private JButton ua;//�޸��˻�Ȩ�ް�ť
	private JButton logout;//ע����ť
	private JButton close;
	private JButton min;
	private JPasswordField aa_password;//����
	private JTextField aa_id;//�û���
	private JButton aa_confirm;
	private JButton aa_cancel;
	private JTextField ua_id;
	private JPasswordField aa_password1;
	private JButton ua_confirm;
	private JButton ua_cancel;
	private JComboBox<String> aa_box;//
	private JComboBox<String> ua_box;
	
	public static void main(String[] args){
	    new Adminui("ϵͳ����Ա");
	}
	public Adminui(String operator){
		//����Ա
		this.operator = operator;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 700);
		frame.setLocation(570, 200);
		//ȥ��������
		frame.setUndecorated(true);
		JLabel title = new JLabel("<html>�ƾ߽�����ϵͳ<br>(PSIS)</html>");
		title.setLocation(30,0);
		title.setSize(300,150);
		title.setForeground(Color.pink);
		//��������
		Font font0 = new Font("Default",Font.BOLD,35);
		title.setFont(font0);
		frame.getContentPane().add(title);
		
		/*
		 * �����˻���ť
		 */
		Font font = new Font("Default",Font.BOLD,30);
		aa = new JButton("    �����˻�");
		aa.addActionListener(new ButtonActionListener());
		aa.setLocation(0,200);
		aa.setSize(250,150);
		aa.setFont(font);
		aa.setForeground(Color.white);
		aa.setContentAreaFilled(false);
		aa.setFocusPainted(false);
		ImageIcon aa_icon = new ImageIcon("����.png");
		JLabel aa_iconlabel = new JLabel(aa_icon);
		aa_iconlabel.setLocation(20,250);
		aa_iconlabel.setSize(aa_icon.getIconWidth(),aa_icon.getIconHeight());
		frame.getContentPane().add(aa_iconlabel);
		frame.getContentPane().add(aa);
		
		/*
		 * �޸��˻���ť
		 */
		ua = new JButton("    �޸��˻�");
		ua.addActionListener(new ButtonActionListener());
		ua.setLocation(0,350);
		ua.setSize(250,150);
		ua.setFont(font);
		ua.setForeground(Color.white);
		ua.setContentAreaFilled(false);
		ua.setFocusPainted(false);
		ImageIcon ua_icon = new ImageIcon("5.png");
		JLabel ua_iconlabel = new JLabel(ua_icon);
		ua_iconlabel.setLocation(20,405);
		ua_iconlabel.setSize(ua_icon.getIconWidth(),ua_icon.getIconHeight());
		frame.getContentPane().add(ua_iconlabel);
		frame.getContentPane().add(ua);
		
		/*
		 * ע��
		 */
		logout = new JButton("ע��       ");
		logout.addActionListener(new ButtonActionListener());
		logout.setLocation(0,620);
		logout.setSize(150,80);
		logout.setFont(font);
		logout.setForeground(Color.red);
		logout.setContentAreaFilled(false);
		logout.setFocusPainted(false);
		ImageIcon logout_icon = new ImageIcon("��Դ.png");
		JLabel logout_label = new JLabel(logout_icon);
		logout_label.setLocation(88,635);
		logout_label.setSize(logout_icon.getIconWidth(),logout_icon.getIconHeight());
		frame.getContentPane().add(logout_label);
		frame.getContentPane().add(logout);
		
		/*
		 * �رհ�ť
		 */
		close = new JButton("X");
		close.addActionListener(new ButtonActionListener());
		close.setLocation(820,0);
		close.setSize(80,50);
		close.setFont(font);
		close.setForeground(Color.white);
		close.setContentAreaFilled(false);
		close.setFocusPainted(false);
		frame.getContentPane().add(close);
		
		/*
		 * ��С����ť
		 */
		min = new JButton("��");
		min.addActionListener(new ButtonActionListener());
		min.setForeground(Color.white);
		min.setSize(80,50);
		min.setLocation(740,0);
		min.setFont(font);
		min.setContentAreaFilled(false);
		min.setFocusPainted(false);
		frame.getContentPane().add(min);
		
		/*
		 * �����˻�����
		 */
		aa_panel = new JPanel();
		aa_panel.setLayout(null);
		aa_panel.setLocation(300,100);
		aa_panel.setSize(540,530);
		aa_panel.setOpaque(true);
		aa_panel.setBackground(Color.cyan);
		/*
		 * �����û���������
		 */
		Font font1 = new Font("Default",Font.BOLD,25);
		JLabel aa_id_label = new JLabel("�û���");
		aa_id_label.setLocation(60,50);
		aa_id_label.setSize(100,50);
		aa_id_label.setFont(font1);
		aa_id_label.setForeground(Color.black);
		aa_panel.add(aa_id_label);
		aa_id = new JTextField();
		aa_id.setLocation(190,50);
		aa_id.setSize(250,50);
		aa_id.setFont(font1);
		aa_panel.add(aa_id);
		JLabel aa_level_label = new JLabel("Ȩ��");
		aa_level_label.setLocation(60,130);
		aa_level_label.setSize(100,50);
		aa_level_label.setFont(font1);
		aa_level_label.setBackground(Color.black);
		aa_panel.add(aa_level_label);
		//������
		aa_box = new JComboBox<String>();
		aa_box.setMaximumRowCount(4);
		aa_box.addItem("��������Ա");
		aa_box.addItem("����������Ա");
		aa_box.addItem("������Ա");
		aa_box.addItem("�ܾ���");
		aa_box.setFont(font1);
		aa_box.setLocation(190,130);
		aa_box.setSize(250,50);
		aa_box.setEditable(false);
		aa_box.setBackground(Color.white);
		aa_panel.add(aa_box);
		JLabel aa_pw1_label = new JLabel("����");
		aa_pw1_label.setLocation(60,210);
		aa_pw1_label.setSize(100,50);
		aa_pw1_label.setFont(font1);
		aa_pw1_label.setForeground(Color.black);
		aa_panel.add(aa_pw1_label);
		aa_password = new JPasswordField();
		aa_password.setLocation(190,210);
		aa_password.setSize(250,50);
		aa_password.setFont(font1);
		aa_panel.add(aa_password);
		JLabel aa_pw2_label = new JLabel("�ٴ�����");
		aa_pw2_label.setLocation(60,290);
		aa_pw2_label.setSize(150,50);
		aa_pw2_label.setFont(font1);
		aa_pw2_label.setForeground(Color.black);
		aa_panel.add(aa_pw2_label);
		aa_password1 = new JPasswordField();
		aa_password1.setLocation(190,290);
		aa_password1.setSize(250,50);
		aa_password1.setFont(font1);
		aa_panel.add(aa_password1);
		/*
		 * ȡ����ȷ��
		 */
		aa_confirm = new JButton("ȷ��");
		aa_confirm.addActionListener(new ButtonActionListener());
		aa_confirm.setLocation(350,400);
		aa_confirm.setSize(120,60);
		aa_confirm.setFocusPainted(false);
		aa_confirm.setFont(font1);
		aa_confirm.setForeground(Color.red);
		aa_panel.add(aa_confirm);
		aa_cancel = new JButton("ȡ��");
		aa_cancel.setLocation(70,400);
		aa_cancel.setSize(120,60);
		aa_cancel.setFocusPainted(false);
		aa_cancel.setFont(font1);
		aa_cancel.setForeground(Color.red);
		aa_cancel.addActionListener(new ButtonActionListener());
		aa_panel.add(aa_cancel);
		aa_panel.setVisible(false);
		frame.getContentPane().add(aa_panel);
		
		/*
		 * �޸��˻�����
		 */
		ua_panel = new JPanel();
		ua_panel.setLayout(null);
		ua_panel.setLocation(300,100);
		ua_panel.setSize(540,530);
		ua_panel.setOpaque(true);
		ua_panel.setBackground(Color.cyan);
		/*
		 * ��¼
		 */
		JLabel ua_id_label = new JLabel("�û���");
		ua_id_label.setLocation(60,50);
		ua_id_label.setSize(100,50);
		ua_id_label.setFont(font1);
		ua_id_label.setForeground(Color.black);
		ua_panel.add(ua_id_label);
		ua_id = new JTextField();
		ua_id.setLocation(190,50);
		ua_id.setSize(250,50);
		ua_id.setFont(font1);
		ua_panel.add(ua_id);
		
		JLabel ua_level_label = new JLabel("Ȩ��");
		ua_level_label.setLocation(60,170);
		ua_level_label.setSize(100,50);
		ua_level_label.setFont(font1);
		ua_level_label.setForeground(Color.black);
		ua_panel.add(ua_level_label);
		
		ua_box = new JComboBox<String>();
		ua_box.setMaximumRowCount(5);
		ua_box.addItem("");
		ua_box.addItem("��������Ա");
		ua_box.addItem("����������Ա");
		ua_box.addItem("������Ա");
		ua_box.addItem("�ܾ���");
		ua_box.setFont(font1);
		ua_box.setLocation(190,170);
		ua_box.setSize(250,50);
		ua_box.setEditable(false);
		ua_box.setBackground(Color.white);
		ua_panel.add(ua_box);
		/*
		 * ȡ����ȷ��
		 */
		ua_confirm = new JButton("ȷ��");
		ua_confirm.setLocation(350,390);
		ua_confirm.setSize(120,60);
		ua_confirm.setFocusPainted(false);
		ua_confirm.setFont(font1);
		ua_confirm.setForeground(Color.red);
		ua_confirm.addActionListener(new ButtonActionListener());
		ua_panel.add(ua_confirm);
		ua_cancel = new JButton("ȡ��");
		ua_cancel.setLocation(70,390);
		ua_cancel.setSize(120,60);
		ua_cancel.setFocusPainted(false);
		ua_cancel.setFont(font1);
		ua_cancel.setForeground(Color.red);
		ua_cancel.addActionListener(new ButtonActionListener());
		ua_panel.add(ua_cancel);
		
		ua_panel.setVisible(false);
		frame.getContentPane().add(ua_panel);
		//���뱳��ͼƬ
		JPanel imagePanel = new ImageJPanel(new ImageIcon("������.jpg").getImage());
		frame.getContentPane().add(imagePanel);
		frame.setVisible(true);
	}
	
	class ButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == close){
				frame.dispose();
			}
			else if(e.getSource() == min){
				frame.setExtendedState(JFrame.ICONIFIED);
			}
			else if(e.getSource() == logout){
				frame.dispose();
			    new MainFrame();
			}
			else if(e.getSource() == aa){
				aa_panel.setVisible(true);
				ua_panel.setVisible(false);
			}
			else if(e.getSource() == ua){
				aa_panel.setVisible(false);
				ua_panel.setVisible(true);
			}
			//������Ӧ
			else if(e.getSource() == aa_confirm){
				PersonAccountVO p=new PersonAccountVO();
				p.setNumber(aa_id.getText());
				String pw = new String(aa_password.getPassword());
				p.setPassword(pw);
				p.setIdentity(aa_box.getSelectedItem().toString());
				String pw_confirm=new String(aa_password1.getPassword());
				//��Ϣ��ȫ����
				if(aa_id.getText()==null||pw==null||pw_confirm==null){
					JOptionPane.showMessageDialog(frame.getContentPane(),"������������Ϣ");
				} 
				else{
				  //��������һ��
				  if(pw.equals(pw_confirm)){
				     ResultMessage res=null;
				     try {
					      res=RemoteHelper.getInstance().getAdminblservice().addPersonAccount(p);
				     } catch (RemoteException e1) {
				   	     // TODO Auto-generated catch block
					     e1.printStackTrace();
				     }
				     JOptionPane.showMessageDialog(null,res.getMessage());
				  }
			      //�����������벻һ�µ���
				  else{
					  JOptionPane.showMessageDialog(frame.getContentPane(),"���벻һ��");
				  }
				}
			}
			else if(e.getSource() == ua_confirm){
				String name=ua_id.getText();
				String identity=ua_box.getSelectedItem().toString();
				ResultMessage res=null;
				try {
					res=RemoteHelper.getInstance().getAdminblservice().updatePersonAccount(name, identity);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				//���³ɹ�����
				if(res.isIssuccess()==true){
					LogVO l=new LogVO();
					l.setName(operator);
					l.setDate(DatetoString.datetostr(new Date()));
					l.setOperation("�����˻�Ȩ��");
					try {
						RemoteHelper.getInstance().getLogblservice().addlog(l);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(frame.getContentPane(),"�޸ĳɹ�");
			}
			//�����˻�ȡ����Ӧ
			else if(e.getSource()==aa_cancel){
				aa_panel.setVisible(false);
			}
			
			else if(e.getSource()==ua_cancel){
				ua_panel.setVisible(false);
			}

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