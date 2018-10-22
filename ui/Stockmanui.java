package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import controller.GoodsClassificationController;
import controller.GoodsController;
import controller.OrderController;
import controller.StockController;
import rmi.RemoteHelper;
import ui.MainFrame.ButtonActionListener;
import ui.MainFrame.ImageJPanel;
import utility.DatetoString;
import vo.GoodsListVO;
import vo.GoodsVO;
import vo.NoticeVO;
import vo.StockAlarmOrderVO;
import vo.StockChangeVO;
import vo.StockGrantOrderVO;
import vo.StockLossOrderVO;
import vo.StockOverflowOrderVO;

public class Stockmanui {
	
	private String operator;//����Ա
	private JPanel panel;
	private JFrame frame;
	private JButton close;
	private JButton min;
	private JButton gcm;//��Ʒ�������
	private JButton gm;//��Ʒ����
	private JButton sc;//���鿴
	private JButton sl;//����̵�
	private JButton so;//��浥������
	private JButton logout;//ע��
	private JPanel gcm_panel;//��Ʒ����������
	private JPanel gm_panel;//��Ʒ�������
	private JPanel sc_panel;//���鿴����
	private JPanel sl_panel;//����̵����
	private JPanel so_panel;//��浥�����ɽ���
	private JTable goods_table;
	private JTable sc_table;
	private JTable sl_table;
	private JTextField search_goods;
	private JTextField start_time;
	private JTextField end_time;
	private JComboBox start_year;
	private JComboBox start_month;
	private JComboBox start_day;
	private JComboBox end_year;
	private JComboBox end_month;
	private JComboBox end_day;
	private JButton search;
	private JButton gcm_add;//����
	private JButton gcm_remove;//ɾ��
	private JButton gcm_update;//�޸�
	private String oldName;
	private JButton gm_add;
	//������Ʒ����ؼ�
	private JFrame gm_add_frame;
	private JTextField gm_add_number;//������Ʒ���
	private JTextField gm_add_name;//������Ʒ����
	private JTextField gm_add_type;//������Ʒ�ͺ�
	private JComboBox gm_add_classification;//������Ʒ����
	private JTextField gm_add_batchLot;//������Ʒ����
	private JTextField gm_add_batchNumber;//������Ʒ����
	private JTextField gm_add_time;//������Ʒ��������
	private JTextField gm_add_stockNumber;//������Ʒ�������
	private JTextField gm_add_pricein;//������Ʒ����
	private JTextField gm_add_price;//������Ʒ���ۼ�
	private JTextField gm_add_latestPrice;//������Ʒ������ۼ�
	private JTextField gm_add_latestPricein;//������Ʒ�������
	private JTextField gm_add_dangerNumber;//������Ʒ�ľ�������
	private JButton gm_add_cancel;
	private JButton gm_add_confirm;
	//ɾ����Ʒ
	private JButton gm_remove;
	private int removeFlag=-1;
	//����Jtree
	private int flag = 0;
	//������Ʒ����ؼ�
	private int updateFlag=-1;
	private JButton gm_update;
	private JButton sc_confirm;//ȷ������
	private JButton sc_cancel;//ȡ��
	private JButton sl_cancel;
	private JButton sl_export;//����EXCEL
	private JComboBox search_box;
	private JComboBox so_classification;//��浥������
	private JPanel so_grant;//������͵������ɽ���
	private JPanel so_alarm;//��汨���������ɽ���
	private JPanel so_of;//��汨�絥�����ɽ���
	private JPanel so_loss;//��汨�𵥾����ɽ���
	private JTextField so_grant_number;//������
	private JTextField so_grant_operator;//����Ա
	private JTextField so_grant_comment;//��ע
	private JTable grant_table;//��Ʒѡ���
	private Mytable grant_mytable;
	private JButton grant_saveDraft;//����ݸ�
	private JButton grant_submit;//�ύ
	private JTextField so_loss_number;//������
	private JTextField so_loss_operator;//����Ա
	private JTextField so_loss_comment;//��ע
	private JTable loss_table;//��汨���
	private Mytable1 loss_mytable;
	private JButton loss_saveDraft;//����ݸ�
	private JButton loss_submit;//�ύ
	private JTextField so_of_number;//������
	private JTextField so_of_operator;//����Ա
	private JTextField so_of_comment;//��ע
	private JTable of_table;//��汨���
	private Mytable1 of_mytable;
	
	private JButton of_saveDraft;//����ݸ�
	private JButton of_submit;//�ύ
	private JTextField so_alarm_number;//������
	private JTextField so_alarm_operator;//����Ա
	private JTextField so_alarm_comment;//��ע
	private JTable alarm_table;//��汨����
	private JButton alarm_saveDraft;//����ݸ�
	private JButton alarm_submit;//�ύ
	private JTree gc_tree;
	private int twinkledFlag = 0;
	private JLabel message1_label;
	private JLabel message_label;
	private ImageIcon message1;
	private ImageIcon message;
	private int noticeFlag = 0;
	private int alarmFlag = 0;

	
	public static void main(String[] args){
		Stockmanui stockmanui = new Stockmanui("��������Ա");
	}
	public Stockmanui(String operator){
		
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
		title.setSize(250,150);
		title.setForeground(Color.pink);
		//��������
		Font font0 = new Font("Default",Font.BOLD,25);
		title.setFont(font0);
		frame.getContentPane().add(title);
		
		//��Ϣ��ʾ
		message1 = new ImageIcon("��Ϣ��ʾ.gif");
		message = new ImageIcon("��Ϣ��ʾ.png");
		message_label = new JLabel();
		List<NoticeVO> notice_list = new ArrayList<NoticeVO>();
		try {
			notice_list = RemoteHelper.getInstance().getNoticeblservice().queryAll("��������Ա");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(notice_list == null){
			message_label.setIcon(message);
		}else{
			message_label.setIcon(message1);
			noticeFlag = 1;
		}
		List<GoodsVO> goods_list = new ArrayList<GoodsVO>();
		try {
			goods_list = RemoteHelper.getInstance().getStockblservice().queryDangerGoods();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(goods_list != null){
			message_label.setIcon(message1);
			alarmFlag = 1;
		}
		message_label.addMouseListener(new MouseActionListener());
		message_label.setLocation(180,635);
		message_label.setSize(message.getIconWidth(),message.getIconHeight());
		message_label.setVisible(true);
		frame.getContentPane().add(message_label);

		
		/*
		 * ��Ʒ�������ť
		 */
		Font font = new Font("Default",Font.BOLD,20);
		gcm = new JButton("��Ʒ�������");
		gcm.addActionListener(new ButtonActionListener());
		gcm.setLocation(0,150);
		gcm.setSize(250,80);
		gcm.setFont(font);
		gcm.setForeground(Color.white);
		gcm.setContentAreaFilled(false);
		gcm.setFocusPainted(false);
		frame.getContentPane().add(gcm);
		ImageIcon img_gcm = new ImageIcon("4.png");
		JLabel label_gcm = new JLabel(img_gcm);
		label_gcm.setLocation(20,185);
		label_gcm.setSize(img_gcm.getIconWidth(),img_gcm.getIconHeight());
		frame.getContentPane().add(label_gcm);
		
		/*
		 * ��Ʒ����ť
		 */
		gm = new JButton("��Ʒ����");
		gm.addActionListener(new ButtonActionListener());
		gm.setLocation(0,230);
		gm.setSize(250,80);
		gm.setFont(font);
		gm.setForeground(Color.white);
		gm.setContentAreaFilled(false);
		gm.setFocusPainted(false);
		frame.getContentPane().add(gm);
		ImageIcon img_gm = new ImageIcon("4.png");
		JLabel label_gm = new JLabel(img_gm);
		label_gm.setLocation(20,255);
		label_gm.setSize(img_gm.getIconWidth(),img_gm.getIconHeight());
		frame.getContentPane().add(label_gm);
		
		/*
		 * ���鿴��ť
		 */
		sc = new JButton("���鿴");
		sc.addActionListener(new ButtonActionListener());
		sc.setLocation(0,310);
		sc.setSize(250,80);
		sc.setFont(font);
		sc.setForeground(Color.white);
		sc.setContentAreaFilled(false);
		sc.setFocusPainted(false);
		ImageIcon sc_icon = new ImageIcon("5.png");
		JLabel sc_label = new JLabel(sc_icon);
		sc_label.setLocation(20,335);
		sc_label.setSize(sc_icon.getIconWidth(),sc_icon.getIconHeight());
		frame.getContentPane().add(sc_label);
		frame.getContentPane().add(sc);
		
		/*
		 * ����̵㰴ť
		 */
		sl = new JButton("����̵�");
		sl.addActionListener(new ButtonActionListener());
		sl.setLocation(0,390);
		sl.setSize(250,80);
		sl.setFont(font);
		sl.setForeground(Color.white);
		sl.setContentAreaFilled(false);
		sl.setFocusPainted(false);
		ImageIcon sl_icon = new ImageIcon("5.png");
		JLabel sl_label = new JLabel(sl_icon);
		sl_label.setLocation(20,415);
		sl_label.setSize(sl_icon.getIconWidth(),sl_icon.getIconHeight());
		frame.getContentPane().add(sl_label);
		frame.getContentPane().add(sl);
		
		/*
		 * ��浥�����ɰ�ť
		 */
		so = new JButton("��浥������");
		so.addActionListener(new ButtonActionListener());
		so.setLocation(0,470);
		so.setSize(250,80);
		so.setFont(font);
		so.setForeground(Color.white);
		so.setContentAreaFilled(false);
		so.setFocusPainted(false);
		ImageIcon so_icon = new ImageIcon("5.png");
		JLabel so_label = new JLabel(so_icon);
		so_label.setLocation(20,495);
		so_label.setSize(so_icon.getIconWidth(),so_icon.getIconHeight());
		frame.getContentPane().add(so_label);
		frame.getContentPane().add(so);
		
		/*
		 * ע����ť
		 */
		logout = new JButton("ע��        ");
		logout.addActionListener(new ButtonActionListener());
		logout.setLocation(0,620);
		logout.setSize(150,80);
		logout.setFont(font);
		logout.setForeground(Color.red);
		logout.setContentAreaFilled(false);
		logout.setFocusPainted(false);
		ImageIcon logout_icon = new ImageIcon("��Դ.png");
		JLabel logout_label = new JLabel(logout_icon);
		logout_label.setLocation(85,635);
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
		 * ��Ʒ����������
		 */
		gcm_panel = new JPanel();
		gcm_panel.setLayout(null);
		gcm_panel.setLocation(350,100);
		gcm_panel.setSize(400,500);
		gcm_panel.setOpaque(true);
		gcm_panel.setBackground(Color.white);
		/*
		 * ������Ʒ������ʾ
		 */
		/*
		 * button�ؼ�
		 */
		//add
		gcm_add = new JButton("����");
		gcm_add.addActionListener(new ButtonActionListener());
		gcm_add.setLocation(25,425);
		gcm_add.setSize(100,50);
		gcm_add.setFocusPainted(false);
		gcm_add.setFont(font);
		gcm_add.setForeground(Color.MAGENTA);
		gcm_panel.add(gcm_add);
		//remove
		gcm_remove = new JButton("ɾ��");
		gcm_remove.addActionListener(new ButtonActionListener());
		gcm_remove.setLocation(150,425);
		gcm_remove.setSize(100,50);
		gcm_remove.setFocusPainted(false);
		gcm_remove.setFont(font);
		gcm_remove.setForeground(Color.MAGENTA);
		gcm_panel.add(gcm_remove);
		//update
		gcm_update = new JButton("�޸�");
		gcm_update.addActionListener(new ButtonActionListener());
		gcm_update.setLocation(275,425);
		gcm_update.setSize(100,50);
		gcm_update.setFocusPainted(false);
		gcm_update.setFont(font);
		gcm_update.setForeground(Color.MAGENTA);
		gcm_panel.add(gcm_update);
		gcm_panel.setVisible(false);
		frame.getContentPane().add(gcm_panel);
		
		/*
		 * ��Ʒ�������
		 */
		gm_panel = new JPanel();
		gm_panel.setLayout(null);
		gm_panel.setLocation(280,50);
		gm_panel.setSize(540,600);
		gm_panel.setOpaque(true);
		gm_panel.setBackground(Color.cyan);
		/*
		 * ��Ʒ��
		 */
		Object[][] cellData = {{"","","","","","","","","",""}};
		String[] columnNames = {"���", "����","�ͺ�","��������","����","����","��������","�������","�������","������ۼ�"};
		DefaultTableModel model = new DefaultTableModel(cellData,columnNames);
		//���ñ�񲻿ɱ༭
		goods_table = new JTable(model){
			public boolean isCellEditable(int row, int column) {
				 if(column == 8 || column == 9){
					 return true;
				 }else{
					 return false;
				 }
			}
		};
		goods_table.addMouseListener(new MouseActionListener());
		goods_table.setBackground(Color.cyan);
		goods_table.setSelectionBackground(Color.pink);
		goods_table.getTableHeader().setFont(font);
		goods_table.getTableHeader().setForeground(Color.red);
		goods_table.setRowHeight(33);
		goods_table.setFont(font);
		//����
		DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		goods_table.setDefaultRenderer(Object.class, renderer); 
		
        goods_table.getColumnModel().getColumn(0).setPreferredWidth(60);
        goods_table.getColumnModel().getColumn(1).setPreferredWidth(150);
        goods_table.getColumnModel().getColumn(2).setPreferredWidth(80);
        goods_table.getColumnModel().getColumn(3).setPreferredWidth(100);
        goods_table.getColumnModel().getColumn(4).setPreferredWidth(60);
        goods_table.getColumnModel().getColumn(5).setPreferredWidth(60);
        goods_table.getColumnModel().getColumn(6).setPreferredWidth(100);
        goods_table.getColumnModel().getColumn(7).setPreferredWidth(100);
        goods_table.getColumnModel().getColumn(8).setPreferredWidth(100);
        goods_table.getColumnModel().getColumn(9).setPreferredWidth(130);
		JScrollPane gm_scrollPane = new JScrollPane(goods_table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		gm_scrollPane.setSize(540,430);
		gm_scrollPane.setLocation(0,100);
		//���ñ���ɫ
		gm_scrollPane.getViewport().setBackground(Color.cyan);
		goods_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		gm_panel.add(gm_scrollPane);
		/*
		 * ��ѯ��
		 */
		search_box = new JComboBox();
		search_box.setLocation(55,25);
		search_box.setSize(90,50);
		search_box.setFont(font);
		search_box.setBackground(Color.white);
		search_box.setMaximumRowCount(3);
		search_box.addItem("�ؼ���");
		search_box.addItem("���");
		search_box.addItem("����");
		gm_panel.add(search_box);
		search_goods = new JTextField();
		search_goods.setLocation(145,25);
		search_goods.setSize(280,50);
		search_goods.setFont(font);
		gm_panel.add(search_goods);
		search = new JButton();
		search.setLocation(425,25);
		search.setSize(50,50);
		search.setFont(font);
		search.setContentAreaFilled(false);
		search.addActionListener(new ButtonActionListener());
		gm_panel.add(search);
		ImageIcon search_icon = new ImageIcon("search.png");
		JLabel search_label = new JLabel(search_icon);
		search_label.setLocation(425,25);
		search_label.setSize(search_icon.getIconWidth(),search_icon.getIconHeight());
		gm_panel.add(search_label);
		/*
		 * button�ؼ�
		 */
		//add
		gm_add = new JButton("����");
		gm_add.addActionListener(new ButtonActionListener());
		gm_add.setLocation(70,540);
		gm_add.setSize(100,50);
		gm_add.setFont(font);
		gm_add.setFocusPainted(false);
		gm_add.setForeground(Color.magenta);
		gm_panel.add(gm_add);
		//remove
		gm_remove = new JButton("ɾ��");
		gm_remove.addActionListener(new ButtonActionListener());
		gm_remove.setLocation(220,540);
		gm_remove.setSize(100,50);
		gm_remove.setFont(font);
		gm_remove.setFocusPainted(false);
		gm_remove.setForeground(Color.magenta);
		gm_panel.add(gm_remove);
		//update
		gm_update = new JButton("�޸�");
		gm_update.addActionListener(new ButtonActionListener());
		gm_update.setLocation(370,540);
		gm_update.setSize(100,50);
		gm_update.setFont(font);
		gm_update.setFocusPainted(false);
		gm_update.setForeground(Color.magenta);
		gm_panel.add(gm_update);
		gm_panel.setVisible(false);
		frame.getContentPane().add(gm_panel);
		
		/*
		 * ���鿴����
		 */
		sc_panel = new JPanel();
		sc_panel.setLayout(null);
		sc_panel.setLocation(280,50);
		sc_panel.setSize(540,600);
		sc_panel.setOpaque(true);
		sc_panel.setBackground(Color.cyan);
		/*
		 * ������ֹʱ��
		 */
		JLabel start = new JLabel("��ʼ����");
		start.setLocation(20,20);
		start.setSize(100,50);
		start.setFont(font);
		start.setForeground(Color.magenta);
		sc_panel.add(start);
		JLabel end = new JLabel("��������");
		end.setLocation(20,80);
		end.setSize(100,50);
		end.setFont(font);
		end.setForeground(Color.magenta);
		sc_panel.add(end);
		//��ʼ���
		start_year = new JComboBox();
		start_year.setMaximumRowCount(10);
		start_year.addItem("2017");
		start_year.addItem("2018");
		start_year.setFont(font);
		start_year.setLocation(120,20);
		start_year.setSize(80,50);
		start_year.setEditable(false);
		start_year.setBackground(Color.white);
		sc_panel.add(start_year);
		JLabel label_year = new JLabel("��");
		label_year.setLocation(210,20);
		label_year.setSize(50,50);
		label_year.setFont(font);
		label_year.setForeground(Color.black);
		sc_panel.add(label_year);
		//�������
		end_year = new JComboBox();
		end_year.setMaximumRowCount(10);
		end_year.addItem("2017");
		end_year.addItem("2018");
		end_year.setFont(font);
		end_year.setLocation(120,80);
		end_year.setSize(80,50);
		end_year.setEditable(false);
		end_year.setBackground(Color.white);
		sc_panel.add(end_year);
		JLabel label_year1 = new JLabel("��");
		label_year1.setLocation(210,80);
		label_year1.setSize(50,50);
		label_year1.setFont(font);
		label_year1.setForeground(Color.black);
		sc_panel.add(label_year1);
		Object[] day = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17"
				,"18","19","20","21","22","23","24","25","26","27","28"};
		//��ʼ�·�
		start_month = new JComboBox();
		start_day = new JComboBox(day);
		start_month.addItemListener(new boxItemListener());//��Ӽ����¼�
		start_month.setMaximumRowCount(10);
		start_month.addItem("01");
		start_month.addItem("02");
		start_month.addItem("03");
		start_month.addItem("04");
		start_month.addItem("05");
		start_month.addItem("06");
		start_month.addItem("07");
		start_month.addItem("08");
		start_month.addItem("09");
		start_month.addItem("10");
		start_month.addItem("11");
		start_month.addItem("12");
		start_month.setFont(font);
		start_month.setLocation(250,20);
		start_month.setSize(80,50);
		start_month.setEditable(false);
		start_month.setBackground(Color.white);
		sc_panel.add(start_month);
		JLabel label_month = new JLabel("��");
		label_month.setLocation(340,20);
		label_month.setSize(50,50);
		label_month.setForeground(Color.black);
		label_month.setFont(font);
		sc_panel.add(label_month);
		//�����·�
		end_month = new JComboBox();
		end_day = new JComboBox(day);
		end_month.addItemListener(new boxItemListener());//��Ӽ����¼�
		end_month.setMaximumRowCount(10);
		end_month.addItem("01");
		end_month.addItem("02");
		end_month.addItem("03");
		end_month.addItem("04");
		end_month.addItem("05");
		end_month.addItem("06");
		end_month.addItem("07");
		end_month.addItem("08");
		end_month.addItem("09");
		end_month.addItem("10");
		end_month.addItem("11");
		end_month.addItem("12");
		end_month.setFont(font);
		end_month.setLocation(250,80);
		end_month.setSize(80,50);
		end_month.setEditable(false);
		end_month.setBackground(Color.white);
		sc_panel.add(end_month);
		JLabel label_month1 = new JLabel("��");
		label_month1.setLocation(340,80);
		label_month1.setSize(50,50);
		label_month1.setForeground(Color.black);
		label_month1.setFont(font);
		sc_panel.add(label_month1);
		//��ʼ����
		start_day.setMaximumRowCount(10);
		start_day.setLocation(400,20);
		start_day.setSize(80,50);
		start_day.setFont(font);
		start_day.setEditable(false);
		start_day.setBackground(Color.white);
		sc_panel.add(start_day);
		JLabel label_day = new JLabel("��");
		label_day.setLocation(490,20);
		label_day.setSize(50,50);
		label_day.setForeground(Color.black);
		label_day.setFont(font);
		sc_panel.add(label_day);
		//��������
		end_day.setMaximumRowCount(10);
		end_day.setLocation(400,80);
		end_day.setSize(80,50);
		end_day.setFont(font);
		end_day.setEditable(false);
		end_day.setBackground(Color.white);
		sc_panel.add(end_day);
		JLabel label_day1 = new JLabel("��");
		label_day1.setLocation(490,80);
		label_day1.setSize(50,50);
		label_day1.setForeground(Color.black);
		label_day1.setFont(font);
		sc_panel.add(label_day1);
		
		/*
		 * ȷ�ϡ�ȡ��
		 */
		sc_confirm = new JButton("ȷ��");
		sc_confirm.addActionListener(new ButtonActionListener());
		sc_confirm.setLocation(370,540);
		sc_confirm.setSize(100,50);
		sc_confirm.setFont(font);
		sc_confirm.setFocusPainted(false);
		sc_confirm.setForeground(Color.magenta);
		sc_panel.add(sc_confirm);
		sc_cancel = new JButton("ȡ��");
		sc_cancel.addActionListener(new ButtonActionListener());
		sc_cancel.setLocation(70,540);
		sc_cancel.setSize(100,50);
		sc_cancel.setFont(font);
		sc_cancel.setFocusPainted(false);
		sc_cancel.setForeground(Color.magenta);
		sc_panel.add(sc_cancel);
		/*
		 * �����Ϣ��ʾ
		 */
		Object[][] cellData1 = {{"","","","","","","","","",""}};
		String[] columnNames1 = {"���","����","��������","�������","������","�����","��������","���۽��","��������","�������"};
		DefaultTableModel sc_model = new DefaultTableModel(cellData1,columnNames1);
		//���ñ�񲻿ɱ༭
		sc_table = new JTable(sc_model){
			public boolean isCellEditable(int row, int column) { return false; }
			};
		sc_table.setBackground(Color.cyan);
		sc_table.setSelectionBackground(Color.pink);
		//�����п�
		sc_table.getColumnModel().getColumn(0).setPreferredWidth(80);
		sc_table.getColumnModel().getColumn(1).setPreferredWidth(180);
		sc_table.getColumnModel().getColumn(2).setPreferredWidth(120);
		sc_table.getColumnModel().getColumn(3).setPreferredWidth(120);
		sc_table.getColumnModel().getColumn(4).setPreferredWidth(120);
		sc_table.getColumnModel().getColumn(5).setPreferredWidth(120);
		sc_table.getColumnModel().getColumn(6).setPreferredWidth(120);
		sc_table.getColumnModel().getColumn(7).setPreferredWidth(120);
		sc_table.getColumnModel().getColumn(8).setPreferredWidth(120);
		sc_table.getColumnModel().getColumn(9).setPreferredWidth(120);
		Font font1 = new Font("Default",Font.BOLD,18);
		sc_table.getTableHeader().setFont(font1);
		sc_table.getTableHeader().setForeground(Color.red);
		sc_table.setRowHeight(33);
		sc_table.setFont(font);
		JScrollPane sc_scrollPane = new JScrollPane(sc_table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_scrollPane.getViewport().setBackground(Color.cyan);
		sc_scrollPane.setSize(540,380);
		sc_scrollPane.setLocation(0,150);
		sc_panel.add(sc_scrollPane);
		sc_panel.setVisible(false);
		sc_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		frame.getContentPane().add(sc_panel);

		
		/*
		 * ����̵����
		 */
		sl_panel = new JPanel();
		sl_panel.setLayout(null);
		sl_panel.setLocation(280,100);
		sl_panel.setSize(540,530);
		sl_panel.setOpaque(true);
		sl_panel.setBackground(Color.cyan);
		//����̵�
		JLabel sl_label1 = new JLabel("����̵�");
		sl_label1.setLocation(200,20);
		sl_label1.setSize(150,30);
		sl_label1.setFont(font0);
		sl_label1.setForeground(Color.magenta);
		sl_panel.add(sl_label1);
		Object[][] cellData2 = {{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""}
		,{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""}};
		String[] columnNames2 = {"�к�","����", "�ͺ�","�������","������","����","����","��������"};
		DefaultTableModel sl_model = new DefaultTableModel(cellData2,columnNames2);
		//���ñ�񲻿ɱ༭
		sl_table = new JTable(sl_model){
			public boolean isCellEditable(int row, int column) { return false; }
		};
		//sl_table.setPreferredSize(new Dimension(900,380));
		//�����п�
		sl_table.getColumnModel().getColumn(0).setPreferredWidth(70);
		sl_table.getColumnModel().getColumn(1).setPreferredWidth(150);
		sl_table.getColumnModel().getColumn(2).setPreferredWidth(80);
		sl_table.getColumnModel().getColumn(3).setPreferredWidth(120);
		sl_table.getColumnModel().getColumn(4).setPreferredWidth(120);
		sl_table.getColumnModel().getColumn(5).setPreferredWidth(80);
		sl_table.getColumnModel().getColumn(6).setPreferredWidth(80);
		sl_table.getColumnModel().getColumn(7).setPreferredWidth(120);
		sl_table.setBackground(Color.cyan);
		sl_table.setSelectionBackground(Color.pink);
		sl_table.getTableHeader().setReorderingAllowed(false);
		sl_table.getTableHeader().setFont(font1);
		sl_table.getTableHeader().setForeground(Color.red);
		sl_table.setRowHeight(33);
		sl_table.setFont(font);
		JScrollPane sl_scrollPane = new JScrollPane(sl_table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sl_scrollPane.getViewport().setBackground(Color.cyan);
		sl_scrollPane.setSize(540,380);
		sl_scrollPane.setLocation(0,70);
		sl_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		sl_panel.add(sl_scrollPane);
		//ȡ��
		sl_cancel = new JButton("ȡ��");
		sl_cancel.addActionListener(new ButtonActionListener());
		sl_cancel.setLocation(70,465);
		sl_cancel.setSize(100,50);
		sl_cancel.setFont(font);
		sl_cancel.setFocusPainted(false);
		sl_cancel.setForeground(Color.magenta);
		sl_panel.add(sl_cancel);
		//����EXCEL
		sl_export = new JButton("����EXCEL");
		sl_export.addActionListener(new ButtonActionListener());
		sl_export.setLocation(320,465);
		sl_export.setSize(150,50);
		sl_export.setFont(font);
		sl_export.setFocusPainted(false);
		sl_export.setForeground(Color.magenta);
		sl_panel.add(sl_export);
		sl_panel.setVisible(false);
		frame.getContentPane().add(sl_panel);

		
		/*
		 * ��浥�����ɽ���
		 */
		so_panel = new JPanel();
		so_panel.setLayout(null);
		so_panel.setLocation(300,50);
		so_panel.setSize(520,600);
		so_panel.setOpaque(true);
		so_panel.setBackground(Color.cyan);
		//��浥������ѡ��
		JLabel class_label = new JLabel("��������");
		class_label.setLocation(70,30);
		class_label.setSize(150,30);
		class_label.setFont(font0);
		class_label.setForeground(Color.red);
		so_panel.add(class_label);
		//��ֹ��ָ���
		so_grant = new JPanel();
		so_of = new JPanel();
		so_loss = new JPanel();
		so_alarm = new JPanel();
		grant_mytable = new Mytable();
	    grant_table = new JTable(grant_mytable);
	    //����
		so_classification = new JComboBox();
		so_classification.setMaximumRowCount(4);
		so_classification.setLocation(200,20);
		so_classification.setSize(200,50);
		so_classification.setFont(font);
		so_classification.setBackground(Color.white);
		so_classification.addItem("������͵�");
		so_classification.addItem("��汨�絥");
		so_classification.addItem("��汨��");
		so_classification.addItem("��汨����");
		so_panel.add(so_classification);
		/*
		 * ���͵����ɽ���
		 */
		so_grant.setLayout(null);
		so_grant.setLocation(0,80);
		so_grant.setSize(540,520);
		so_grant.setBackground(Color.cyan);
		/*
		 * ����
		 */
		JLabel grant_input = new JLabel("���͵�����");
		grant_input.setLocation(180,0);
		grant_input.setSize(150,30);
		grant_input.setFont(font);
		grant_input.setForeground(Color.red);
		so_grant.add(grant_input);
		//������
		JLabel so_grant_number_label = new JLabel("������");
		so_grant_number_label.setLocation(40,40);
		so_grant_number_label.setSize(100,30);
		so_grant_number_label.setFont(font);
		so_grant_number_label.setBackground(Color.black);
	    so_grant.add(so_grant_number_label);
	    so_grant_number = new JTextField();
	    so_grant_number.setLocation(130,40);
	    so_grant_number.setSize(280,30);
	    so_grant_number.setBackground(Color.white);
	    so_grant_number.setFont(font);
	    so_grant.add(so_grant_number);
	    //����Ա
	    JLabel so_grant_operator_label = new JLabel("����Ա");
	    so_grant_operator_label.setLocation(40,80);
	    so_grant_operator_label.setSize(100,30);
	    so_grant_operator_label.setFont(font);
	    so_grant_operator_label.setBackground(Color.black);
	    so_grant.add(so_grant_operator_label);
	    so_grant_operator = new JTextField();
	    so_grant_operator.setLocation(130,80);
	    so_grant_operator.setSize(280,30);
	    so_grant_operator.setBackground(Color.white);
	    so_grant_operator.setFont(font);
	    so_grant.add(so_grant_operator);
	    //��ע
	    JLabel so_grant_comment_label = new JLabel("��ע");
	    so_grant_comment_label.setLocation(40,120);
	    so_grant_comment_label.setSize(100,30);
	    so_grant_comment_label.setFont(font);
	    so_grant_comment_label.setBackground(Color.black);
	    so_grant.add(so_grant_comment_label);
	    so_grant_comment = new JTextField();
	    so_grant_comment.setLocation(130,120);
	    so_grant_comment.setSize(280,30);
	    so_grant_comment.setFont(font);
	    so_grant.add(so_grant_comment);
	    /*
	     * ��Ʒѡ���
	     */
	    frame.setLocationRelativeTo(null);
	    JLabel grant_table_label = new JLabel("��Ʒѡ��");
	    grant_table_label.setLocation(210,160);
	    grant_table_label.setSize(150,30);
	    grant_table_label.setFont(font);
	    grant_table_label.setForeground(Color.black);
		so_grant.add(grant_table_label);
		frame.setLocationRelativeTo(null);
		grant_table.getTableHeader().setReorderingAllowed(false);
		grant_table.setBackground(Color.cyan);
		grant_table.setSelectionBackground(Color.pink);
		grant_table.getTableHeader().setPreferredSize(new Dimension(1, 50));
		grant_table.getTableHeader().setFont(font);
		grant_table.getTableHeader().setForeground(Color.red);
		grant_table.setRowHeight(33);
		grant_table.setFont(font);
		grant_table.getColumnModel().getColumn(5).setPreferredWidth(100);
		grant_table.getColumnModel().getColumn(4).setPreferredWidth(100);
		JScrollPane sg_scrollPane = new JScrollPane(grant_table);
		sg_scrollPane.getViewport().setBackground(Color.cyan);
		sg_scrollPane.setLocation(0,190);
		sg_scrollPane.setSize(520,270);
		frame.setLocationRelativeTo(null);
		so_grant.add(sg_scrollPane);
		/*
		 * button�ؼ�
		 */
		//����ݸ�
		grant_saveDraft = new JButton("����ݸ�");
		grant_saveDraft.addActionListener(new ButtonActionListener());
		grant_saveDraft.setLocation(50,465);
		grant_saveDraft.setSize(150,50);
		grant_saveDraft.setFont(font1);
		grant_saveDraft.setForeground(Color.magenta);
		grant_saveDraft.setFocusPainted(false);
		so_grant.add(grant_saveDraft);
		grant_saveDraft.setVisible(false);
		//�ύ
		grant_submit = new JButton("�ύ");
		grant_submit.addActionListener(new ButtonActionListener());
		grant_submit.setLocation(320,465);
		grant_submit.setSize(150,50);
		grant_submit.setFont(font1);
		grant_submit.setForeground(Color.magenta);
		grant_submit.setFocusPainted(false);
		so_grant.add(grant_submit);
	    so_grant.setVisible(true);
	    so_panel.add(so_grant);
	    /*
	     * ��汨�絥���ɽ���
	     */
	    so_of.setLayout(null);
	    so_of.setLocation(0,80);
	    so_of.setSize(540,520);
	    so_of.setBackground(Color.cyan);
	    /*
		 * ����
		 */
		JLabel of_input = new JLabel("���絥����");
		of_input.setLocation(180,0);
		of_input.setSize(150,30);
		of_input.setFont(font);
		of_input.setForeground(Color.red);
		so_of.add(of_input);
		//������
		JLabel so_of_number_label = new JLabel("������");
		so_of_number_label.setLocation(40,40);
		so_of_number_label.setSize(100,30);
		so_of_number_label.setFont(font);
		so_of_number_label.setBackground(Color.black);
	    so_of.add(so_of_number_label);
	    so_of_number = new JTextField();
	    so_of_number.setLocation(130,40);
	    so_of_number.setSize(280,30);
	    so_of_number.setBackground(Color.white);
	    so_of_number.setFont(font);
	    so_of.add(so_of_number);
	    //����Ա
	    JLabel so_of_operator_label = new JLabel("����Ա");
	    so_of_operator_label.setLocation(40,80);
	    so_of_operator_label.setSize(100,30);
	    so_of_operator_label.setFont(font);
	    so_of_operator_label.setBackground(Color.black);
	    so_of.add(so_of_operator_label);
	    so_of_operator = new JTextField();
	    so_of_operator.setLocation(130,80);
	    so_of_operator.setSize(280,30);
	    so_of_operator.setBackground(Color.white);
	    so_of_operator.setFont(font);
	    so_of.add(so_of_operator);
	    //��ע
	    JLabel so_of_comment_label = new JLabel("��ע");
	    so_of_comment_label.setLocation(40,120);
	    so_of_comment_label.setSize(100,30);
	    so_of_comment_label.setFont(font);
	    so_of_comment_label.setBackground(Color.black);
	    so_of.add(so_of_comment_label);
	    so_of_comment = new JTextField();
	    so_of_comment.setLocation(130,120);
	    so_of_comment.setSize(280,30);
	    so_of_comment.setFont(font);
	    so_of.add(so_of_comment);
	    /*
	     * ��汨���
	     */
	    JLabel of_table_label = new JLabel("��汨���");
	    of_table_label.setLocation(210,160);
	    of_table_label.setSize(150,30);
	    of_table_label.setFont(font);
	    of_table_label.setForeground(Color.black);
		so_of.add(of_table_label);
		frame.setLocationRelativeTo(null);
		of_mytable = new Mytable1();
		of_table = new JTable(of_mytable);
		of_table.getTableHeader().setReorderingAllowed(false);
		of_table.setBackground(Color.cyan);
		of_table.setSelectionBackground(Color.pink);
		of_table.getTableHeader().setPreferredSize(new Dimension(1, 50));
		of_table.getTableHeader().setFont(font);
		of_table.getTableHeader().setForeground(Color.red);
		of_table.setRowHeight(33);
		of_table.setFont(font);
		of_table.getColumnModel().getColumn(4).setPreferredWidth(100);
		of_table.getColumnModel().getColumn(3).setPreferredWidth(100);
		JScrollPane of_scrollPane = new JScrollPane(of_table);
		of_scrollPane.getViewport().setBackground(Color.cyan);
		of_scrollPane.setLocation(0,190);
		of_scrollPane.setSize(520,270);
		frame.setLocationRelativeTo(null);
		so_of.add(of_scrollPane);
		/*
		 * button�ؼ�
		 */
		//����ݸ�
		of_saveDraft = new JButton("����ݸ�");
		of_saveDraft.setLocation(50,465);
		of_saveDraft.setSize(150,50);
		of_saveDraft.setFont(font1);
		of_saveDraft.setForeground(Color.magenta);
		of_saveDraft.setFocusPainted(false);
		so_of.add(of_saveDraft);
		of_saveDraft.setVisible(false);
		//�ύ
		of_submit = new JButton("�ύ");
		of_submit.addActionListener(new ButtonActionListener());
		of_submit.setLocation(320,465);
		of_submit.setSize(150,50);
		of_submit.setFont(font1);
		of_submit.setForeground(Color.magenta);
		of_submit.setFocusPainted(false);
		so_of.add(of_submit);
		so_of.setVisible(false);
	    so_panel.add(so_of);
	    /*
	     * ��汨�����ɽ���
	     */
	    so_loss.setLayout(null);
	    so_loss.setLocation(0,80);
	    so_loss.setSize(540,520);
	    so_loss.setBackground(Color.cyan);
	    /*
		 * ����
		 */
		JLabel loss_input = new JLabel("��������");
		loss_input.setLocation(180,0);
		loss_input.setSize(150,30);
		loss_input.setFont(font);
		loss_input.setForeground(Color.red);
		so_loss.add(loss_input);
		//������
		JLabel so_loss_number_label = new JLabel("������");
		so_loss_number_label.setLocation(40,40);
		so_loss_number_label.setSize(100,30);
		so_loss_number_label.setFont(font);
		so_loss_number_label.setBackground(Color.black);
	    so_loss.add(so_loss_number_label);
	    so_loss_number = new JTextField();
	    so_loss_number.setLocation(130,40);
	    so_loss_number.setSize(280,30);
	    so_loss_number.setBackground(Color.white);
	    so_loss_number.setFont(font);
	    so_loss.add(so_loss_number);
	    //����Ա
	    JLabel so_loss_operator_label = new JLabel("����Ա");
	    so_loss_operator_label.setLocation(40,80);
	    so_loss_operator_label.setSize(100,30);
	    so_loss_operator_label.setFont(font);
	    so_loss_operator_label.setBackground(Color.black);
	    so_loss.add(so_loss_operator_label);
	    so_loss_operator = new JTextField();
	    so_loss_operator.setLocation(130,80);
	    so_loss_operator.setSize(280,30);
	    so_loss_operator.setBackground(Color.white);
	    so_loss_operator.setFont(font);
	    so_loss.add(so_loss_operator);
	    //��ע
	    JLabel so_loss_comment_label = new JLabel("��ע");
	    so_loss_comment_label.setLocation(40,120);
	    so_loss_comment_label.setSize(100,30);
	    so_loss_comment_label.setFont(font);
	    so_loss_comment_label.setBackground(Color.black);
	    so_loss.add(so_loss_comment_label);
	    so_loss_comment = new JTextField();
	    so_loss_comment.setLocation(130,120);
	    so_loss_comment.setSize(280,30);
	    so_loss_comment.setFont(font);
	    so_loss.add(so_loss_comment);
	    /*
	     * ��汨���
	     */
	    JLabel loss_table_label = new JLabel("��汨���");
	    loss_table_label.setLocation(210,160);
	    loss_table_label.setSize(150,30);
	    loss_table_label.setFont(font);
	    loss_table_label.setForeground(Color.black);
		so_loss.add(loss_table_label);
		frame.setLocationRelativeTo(null);
		loss_mytable = new Mytable1();
		loss_table = new JTable(loss_mytable);
		loss_table.getTableHeader().setReorderingAllowed(false);
		loss_table.setBackground(Color.cyan);
		loss_table.setSelectionBackground(Color.pink);
		loss_table.getTableHeader().setPreferredSize(new Dimension(1, 50));
		loss_table.getTableHeader().setFont(font);
		loss_table.getTableHeader().setForeground(Color.red);
		loss_table.setRowHeight(33);
		loss_table.setFont(font);
		loss_table.getColumnModel().getColumn(4).setPreferredWidth(100);
		loss_table.getColumnModel().getColumn(3).setPreferredWidth(100);
		JScrollPane loss_scrollPane = new JScrollPane(loss_table);
		loss_scrollPane.getViewport().setBackground(Color.cyan);
		loss_scrollPane.setLocation(0,190);
		loss_scrollPane.setSize(520,270);
		frame.setLocationRelativeTo(null);
		so_loss.add(loss_scrollPane);
		/*
		 * button�ؼ�
		 */
		//����ݸ�
		loss_saveDraft = new JButton("����ݸ�");
		loss_saveDraft.setLocation(50,465);
		loss_saveDraft.setSize(150,50);
		loss_saveDraft.setFont(font1);
		loss_saveDraft.setForeground(Color.magenta);
		loss_saveDraft.setFocusPainted(false);
		so_loss.add(loss_saveDraft);
		loss_saveDraft.setVisible(false);
		//�ύ
		loss_submit = new JButton("�ύ");
		loss_submit.addActionListener(new ButtonActionListener());
		loss_submit.setLocation(320,465);
		loss_submit.setSize(150,50);
		loss_submit.setFont(font1);
		loss_submit.setForeground(Color.magenta);
		loss_submit.setFocusPainted(false);
		so_loss.add(loss_submit);
		so_loss.setVisible(false);
	    so_panel.add(so_loss);
	    /*
	     * ���������ɽ���
	     */
	    so_alarm.setLayout(null);
	    so_alarm.setLocation(0,80);
	    so_alarm.setSize(540,520);
	    so_alarm.setBackground(Color.cyan);
	    /*
		 * ����
		 */
		JLabel alarm_input = new JLabel("����������");
		alarm_input.setLocation(180,0);
		alarm_input.setSize(150,30);
		alarm_input.setFont(font);
		alarm_input.setForeground(Color.red);
		so_alarm.add(alarm_input);
		//������
		JLabel so_alarm_number_label = new JLabel("������");
		so_alarm_number_label.setLocation(40,40);
		so_alarm_number_label.setSize(100,30);
		so_alarm_number_label.setFont(font);
		so_alarm_number_label.setBackground(Color.black);
	    so_alarm.add(so_alarm_number_label);
	    so_alarm_number = new JTextField();
	    so_alarm_number.setLocation(130,40);
	    so_alarm_number.setSize(280,30);
	    so_alarm_number.setBackground(Color.white);
	    so_alarm_number.setFont(font);
	    so_alarm.add(so_alarm_number);
	    //����Ա
	    JLabel so_alarm_operator_label = new JLabel("����Ա");
	    so_alarm_operator_label.setLocation(40,80);
	    so_alarm_operator_label.setSize(100,30);
	    so_alarm_operator_label.setFont(font);
	    so_alarm_operator_label.setBackground(Color.black);
	    so_alarm.add(so_alarm_operator_label);
	    so_alarm_operator = new JTextField();
	    so_alarm_operator.setLocation(130,80);
	    so_alarm_operator.setSize(280,30);
	    so_alarm_operator.setBackground(Color.white);
	    so_alarm_operator.setFont(font);
	    so_alarm.add(so_alarm_operator);
	    //��ע
	    JLabel so_alarm_comment_label = new JLabel("��ע");
	    so_alarm_comment_label.setLocation(40,120);
	    so_alarm_comment_label.setSize(100,30);
	    so_alarm_comment_label.setFont(font);
	    so_alarm_comment_label.setBackground(Color.black);
	    so_alarm.add(so_alarm_comment_label);
	    so_alarm_comment = new JTextField();
	    so_alarm_comment.setLocation(130,120);
	    so_alarm_comment.setSize(280,30);
	    so_alarm_comment.setFont(font);
	    so_alarm.add(so_alarm_comment);
	    /*
	     * ��汨����
	     */
	    JLabel alarm_table_label = new JLabel("��汨����");
	    alarm_table_label.setLocation(210,160);
	    alarm_table_label.setSize(150,30);
	    alarm_table_label.setFont(font);
	    alarm_table_label.setForeground(Color.black);
		so_alarm.add(alarm_table_label);
		Object[][] alarm_data = {{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}};
		String[] alarm_columnName = {"���","����","�ͺ�","��������","ʵ������"}; 
		DefaultTableModel model1=new DefaultTableModel(alarm_data,alarm_columnName);
		alarm_table = new JTable(model1){
			public boolean isCellEditable(int row, int column) { return false; }
		};
		alarm_table.getTableHeader().setReorderingAllowed(false);
		alarm_table.setBackground(Color.cyan);
		alarm_table.setSelectionBackground(Color.pink);
		alarm_table.getTableHeader().setPreferredSize(new Dimension(1, 50));
		alarm_table.getTableHeader().setFont(font);
		alarm_table.getTableHeader().setForeground(Color.red);
		alarm_table.setRowHeight(33);
		alarm_table.setFont(font);
		alarm_table.getColumnModel().getColumn(2).setPreferredWidth(100);
		alarm_table.getColumnModel().getColumn(3).setPreferredWidth(100);
		JScrollPane alarm_scrollPane = new JScrollPane(alarm_table);
		alarm_scrollPane.getViewport().setBackground(Color.cyan);
		alarm_scrollPane.setLocation(0,190);
		alarm_scrollPane.setSize(520,270);
		so_alarm.add(alarm_scrollPane);
		/*
		 * button�ؼ�
		 */
		//����ݸ�
		alarm_saveDraft = new JButton("����ݸ�");
		alarm_saveDraft.setLocation(50,465);
		alarm_saveDraft.setSize(150,50);
		alarm_saveDraft.setFont(font1);
		alarm_saveDraft.setForeground(Color.magenta);
		alarm_saveDraft.setFocusPainted(false);
		so_alarm.add(alarm_saveDraft);
		alarm_saveDraft.setVisible(false);
		//�ύ
		alarm_submit = new JButton("�ύ");
		alarm_submit.addActionListener(new ButtonActionListener());
		alarm_submit.setLocation(320,465);
		alarm_submit.setSize(150,50);
		alarm_submit.setFont(font1);
		alarm_submit.setForeground(Color.magenta);
		alarm_submit.setFocusPainted(false);
		so_alarm.add(alarm_submit);
		so_alarm.setVisible(false);
	    so_panel.add(so_alarm);
		so_panel.setVisible(false);
		frame.getContentPane().add(so_panel);
		
		so_classification.addItemListener(new boxItemListener());
		//���뱳��ͼƬ
		JPanel imagePanel = new ImageJPanel(new ImageIcon("������.jpg").getImage());
		frame.getContentPane().add(imagePanel);
		frame.setVisible(true);
	}
	
	//�Զ���table
	class Mytable extends AbstractTableModel{
		/*
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String[] columnNames = {"���","����","�ͺ�","����","�������","��������","ѡ��"};
		Object[][] celldata = {{"","","","","","",new Boolean(false)},{"","","","","","",new Boolean(false)},{"","","","","","",new Boolean(false)}
		,{"","","","","","",new Boolean(false)},{"","","","","","",new Boolean(false)},{"","","","","","",new Boolean(false)},
		{"","","","","","",new Boolean(false)},{"","","","","","",new Boolean(false)}};
		
		public void setData(Object[][] data){
			celldata = data;
			fireTableDataChanged();
		}
		
		//����ÿһ�е�����
		@Override
		public Class getColumnClass(int columnIndex) {
			if(columnIndex == 6){
				   return Boolean.class;// ����ÿһ�е���������
			}else{
				return Object.class;
			}
		}
			
		@Override
		public String getColumnName(int column) {
			return columnNames[column];
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return celldata.length;
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columnNames.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return celldata[rowIndex][columnIndex];
		}
			
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			celldata[rowIndex][columnIndex] = aValue;
			fireTableCellUpdated(rowIndex, columnIndex);
		}
		//���ÿ��Ա༭
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			if(columnIndex==6 || columnIndex == 5){
				   return true;
			}else{
				return false;
			}
		}
		
		public void setRowValues(Object[][] data){
			this.celldata = data;
			 fireTableDataChanged();
		}
		
	}
	
	class Mytable1 extends AbstractTableModel{
		String[] columnNames = {"���","����","�ͺ�","�������","ʵ������","ѡ��"};
		Object[][] celldata = {{"1","","","","",new Boolean(false)},{"","","","","",new Boolean(false)},{"","","","","",new Boolean(false)}
		,{"","","","","",new Boolean(false)},{"","","","","",new Boolean(false)},{"","","","","",new Boolean(false)},
		{"","","","","",new Boolean(false)},{"","","","","",new Boolean(false)}};
		
		public void setData(Object[][] data){
			celldata = data;
			fireTableDataChanged();
		}
		
		//����ÿһ�е�����
		@Override
		public Class getColumnClass(int columnIndex) {
			if(columnIndex == 5){
				   return Boolean.class;// ����ÿһ�е���������
			}else{
				return Object.class;
			}
		}
			
		@Override
		public String getColumnName(int column) {
			return columnNames[column];
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return celldata.length;
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columnNames.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return celldata[rowIndex][columnIndex];
		}
			
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			celldata[rowIndex][columnIndex] = aValue;
			fireTableCellUpdated(rowIndex, columnIndex);
		}
		//���ÿ��Ա༭
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			if(columnIndex==4 || columnIndex == 5){
				   return true;
			}else{
				return false;
			}
		}
	}
	
	class ButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == close){
				frame.dispose();
			}
			else if(e.getSource() == min){
		    	frame.setExtendedState(JFrame.ICONIFIED);
		    }
			else if(e.getSource() == logout){
				frame.dispose();
				MainFrame mainFrame = new MainFrame();
			}
			else if(e.getSource() == gm){
				gm_panel.setVisible(true);
				gcm_panel.setVisible(false);
				sc_panel.setVisible(false);
				sl_panel.setVisible(false);
				so_panel.setVisible(false);
				//��ʾ��Ʒ��Ϣ
				DefaultTableModel model = (DefaultTableModel)goods_table.getModel();
				int n = model.getRowCount() - 1;
				while(n >= 0){
					model.removeRow(n);
					n--;
				}
				GoodsController gc = new GoodsController(operator);
				Object[][] data = new Object[gc.query().size()][10];
				for(int i=0;i<gc.query().size();i++){
					data[i][0] = gc.query().get(i).getNumber();
					data[i][1] = gc.query().get(i).getName();
					data[i][2] = gc.query().get(i).getType();
					data[i][3] = gc.query().get(i).getClassification();
					data[i][4] = gc.query().get(i).getPici();
					data[i][5] = gc.query().get(i).getPihao();
					data[i][6] = gc.query().get(i).getChuchangriqi();
					data[i][7] = gc.query().get(i).getStocknumber();
					data[i][8] = gc.query().get(i).getLatestpricein();
					data[i][9] = gc.query().get(i).getLatestpeice();
				}
				for(int i=0;i<gc.query().size();i++){
					model.addRow(data[i]);
				}
				goods_table.setModel(model);
			}
			else if(e.getSource()==search){
				String s=search_box.getSelectedItem().toString();
				String keyword=search_goods.getText();
				GoodsController gc=new GoodsController(operator);
				if(s.equals("���")){
					GoodsVO g = gc.queryGoodsByNumebr(Integer.valueOf(keyword));
					DefaultTableModel model = (DefaultTableModel)goods_table.getModel();
					int n = model.getRowCount() - 1;
					while(n >= 0){
						model.removeRow(n);
						n--;
					}
					Object[][] data = new Object[1][10];
					data[0][0] = g.getNumber();
					data[0][1] = g.getName();
					data[0][2] = g.getType();
					data[0][3] = g.getClassification();
					data[0][4] = g.getPici();
					data[0][5] = g.getPihao();
					data[0][6] = g.getChuchangriqi();
					data[0][7] = g.getStocknumber();
					data[0][8] = g.getLatestpricein();
					data[0][9] = g.getLatestpeice();
					model.addRow(data[0]);
					goods_table.setModel(model);
				}
				
				else if(s.equals("����"))
				{
					List<GoodsVO> list= gc.queryGoodsByName(keyword);
					DefaultTableModel model = (DefaultTableModel)goods_table.getModel();
					int n = model.getRowCount() - 1;
					while(n >= 0){
						model.removeRow(n);
						n--;
					}
					
					Object[][] data = new Object[list.size()][10];
					for(int i=0;i<list.size();i++){
						data[i][0] = list.get(i).getNumber();
						data[i][1] = list.get(i).getName();
						data[i][2] = list.get(i).getType();
						data[i][3] = list.get(i).getClassification();
						data[i][4] = list.get(i).getPici();
						data[i][5] = list.get(i).getPihao();
						data[i][6] = list.get(i).getChuchangriqi();
						data[i][7] = list.get(i).getStocknumber();
						data[i][8] = list.get(i).getLatestpricein();
						data[i][9] = list.get(i).getLatestpeice();
					}
					for(int i=0;i<list.size();i++){
						model.addRow(data[i]);
					}
					goods_table.setModel(model);
					
				}
				else{
					List<GoodsVO> list= gc.queryGoodsByKeyword(keyword);
					DefaultTableModel model = (DefaultTableModel)goods_table.getModel();
					int n = model.getRowCount() - 1;
					while(n >= 0){
						model.removeRow(n);
						n--;
					}
					
					Object[][] data = new Object[list.size()][10];
					for(int i=0;i<list.size();i++){
						data[i][0] = list.get(i).getNumber();
						data[i][1] = list.get(i).getName();
						data[i][2] = list.get(i).getType();
						data[i][3] = list.get(i).getClassification();
						data[i][4] = list.get(i).getPici();
						data[i][5] = list.get(i).getPihao();
						data[i][6] = list.get(i).getChuchangriqi();
						data[i][7] = list.get(i).getStocknumber();
						data[i][8] = list.get(i).getLatestpricein();
						data[i][9] = list.get(i).getLatestpeice();
					}
					for(int i=0;i<list.size();i++){
						model.addRow(data[i]);
					}
					goods_table.setModel(model);
				}
				
			}
			else if(e.getSource() == gcm){
				gm_panel.setVisible(false);
				gcm_panel.setVisible(true);
				sc_panel.setVisible(false);
				sl_panel.setVisible(false);
				so_panel.setVisible(false);
				DefaultMutableTreeNode top = new DefaultMutableTreeNode("�ƾ�");
				DefaultMutableTreeNode d=createtree("�ƾ�",top);
				DefaultTreeModel model = new DefaultTreeModel(d);
				if(flag == 1){
					gcm_panel.removeAll();
					/*
					 * button�ؼ�
					 */
					//add
					Font font = new Font("Default",Font.BOLD,20);
					gcm_add = new JButton("����");
					gcm_add.addActionListener(new ButtonActionListener());
					gcm_add.setLocation(25,425);
					gcm_add.setSize(100,50);
					gcm_add.setFocusPainted(false);
					gcm_add.setFont(font);
					gcm_add.setForeground(Color.MAGENTA);
					gcm_panel.add(gcm_add);
					//remove
					gcm_remove = new JButton("ɾ��");
					gcm_remove.addActionListener(new ButtonActionListener());
					gcm_remove.setLocation(150,425);
					gcm_remove.setSize(100,50);
					gcm_remove.setFocusPainted(false);
					gcm_remove.setFont(font);
					gcm_remove.setForeground(Color.MAGENTA);
					gcm_panel.add(gcm_remove);
					//update
					gcm_update = new JButton("�޸�");
					gcm_update.addActionListener(new ButtonActionListener());
					gcm_update.setLocation(275,425);
					gcm_update.setSize(100,50);
					gcm_update.setFocusPainted(false);
					gcm_update.setFont(font);
					gcm_update.setForeground(Color.MAGENTA);
					gcm_panel.add(gcm_update);
					gcm_panel.setVisible(true);
					
					flag = 0;
				}
				
				gc_tree = new JTree(model);
				gc_tree.addMouseListener(new MouseActionListener());
				gc_tree.setEditable(true);
				Font font0 = new Font("Default",Font.BOLD,25);
				gc_tree.setFont(font0);
				//�������ڵ㱳��ɫ
				DefaultTreeCellRenderer cellRenderer = (DefaultTreeCellRenderer)gc_tree.getCellRenderer();
				cellRenderer.setBackgroundNonSelectionColor(Color.white);
				cellRenderer.setBackgroundSelectionColor(Color.white);
				cellRenderer.setTextNonSelectionColor(Color.black);
				cellRenderer.setTextSelectionColor(Color.red);
				gc_tree.setRowHeight(40);
				JScrollPane gc_scrollpane = new JScrollPane(gc_tree);
				gc_scrollpane.getViewport().setBackground(Color.cyan);
				gc_scrollpane.setLocation(0,0);
				gc_scrollpane.setSize(400,400);
				gc_scrollpane.setBackground(Color.red);
				gcm_panel.add(gc_scrollpane);
				flag = 1;
			}else if(e.getSource() == sc){
				gm_panel.setVisible(false);
				gcm_panel.setVisible(false);
				sc_panel.setVisible(true);
				sl_panel.setVisible(false);
				so_panel.setVisible(false);
			}else if(e.getSource() == sl){
				gm_panel.setVisible(false);
				gcm_panel.setVisible(false);
				sc_panel.setVisible(false);
				sl_panel.setVisible(true);
				so_panel.setVisible(false);
				GoodsController gc = new GoodsController(operator);
				List<GoodsVO> list = gc.query();
				//����̵���Ϣ��ʾ
				DefaultTableModel model = (DefaultTableModel)sl_table.getModel();
				int n = model.getRowCount() - 1;
				while(n >= 0){
					model.removeRow(n);
					n--;
				}
				Object[][] data = new Object[list.size()][8];
				for(int i=0;i<list.size();i++){
					data[i][0] = i+1;
					data[i][1] = list.get(i).getName();
					data[i][2] = list.get(i).getType();
					data[i][3] = list.get(i).getStocknumber();
					data[i][4] = list.get(i).getLatestpeice();
					data[i][5] = list.get(i).getPici();
					data[i][6] = list.get(i).getPihao();
					data[i][7] = list.get(i).getChuchangriqi();
				}
				for(int i=0;i<list.size();i++){
					model.addRow(data[i]);
				}
				gc.insertLog("����̵�");
			}else if(e.getSource() == sl_export){
				String path="";    
			    JFileChooser chooser = new JFileChooser();  			    
			    int abc =chooser.showSaveDialog(null);  
			    if(abc == JFileChooser.APPROVE_OPTION){  
			    	if(chooser.getSelectedFile().getAbsolutePath() != null){
			            path = chooser.getSelectedFile().getAbsolutePath()+".xls";
			    	}
			    	else{
			    		path = "D:\\����̵�.xls";
			    	}
			    }
			    StockController sc=new StockController(operator);
			    List<GoodsVO> list=new ArrayList<GoodsVO>();
			    DefaultTableModel model=(DefaultTableModel)sl_table.getModel();
			    for(int i=0;i<model.getRowCount();i++){
			    	GoodsVO good=new GoodsVO();
			    	good.setNumber(Integer.valueOf(model.getValueAt(i, 0).toString()));
			    	good.setName(model.getValueAt(i, 1).toString());
			    	good.setType(model.getValueAt(i, 2).toString());
			    	good.setStocknumber(Integer.valueOf(model.getValueAt(i, 3).toString()));
			    	good.setPrice(Double.valueOf(model.getValueAt(i, 4).toString()));
			    	good.setPici(model.getValueAt(i, 5).toString());
			    	good.setPihao(model.getValueAt(i, 6).toString());
			    	good.setChuchangriqi(model.getValueAt(i, 7).toString());
			    	list.add(good);
			    }
			    sc.excelstock(list,path);
			 sc.insertLog("����̵㲢��������");
			}else if(e.getSource() == sl_cancel){
				sl_panel.setVisible(false);
			}else if(e.getSource() == so){
				gm_panel.setVisible(false);
				gcm_panel.setVisible(false);
				sc_panel.setVisible(false);
				sl_panel.setVisible(false);
				so_panel.setVisible(true);
				//��ʾ��Ʒ�б�
				StockController sc=new StockController(operator);
				so_grant_number.setEditable(false);
				so_grant_number.setText(sc.getStockGrantOrderNumber());
				so_grant_operator.setText(operator);
				
				so_grant_operator.setEditable(false);
				GoodsController gc = new GoodsController(operator);
				Object[][] data = new Object[gc.query().size()][7];
				for(int i=0;i<gc.query().size();i++){
					data[i][0] = gc.query().get(i).getNumber();
					data[i][1] = gc.query().get(i).getName();
					data[i][2] = gc.query().get(i).getType();
					data[i][3] = gc.query().get(i).getLatestpeice();
					data[i][4] = gc.query().get(i).getStocknumber();
					data[i][5] = "0";
					data[i][6] = new Boolean(false);
				}
				grant_mytable.setData(data);
				grant_table.setModel(grant_mytable);
			}
			
			else if(e.getSource() == gm_add){
				Font font = new Font("Default",Font.BOLD,20);
				gm_add_frame = new JFrame("������Ʒ");
				gm_add_frame.setLayout(null);
				gm_add_frame.setLocation(800,170);
				gm_add_frame.setSize(350,780);
				gm_add_frame.getContentPane().setBackground(Color.cyan);
				//���
				JLabel gm_add_number_label = new JLabel("���");
				gm_add_number_label.setLocation(30,15);
				gm_add_number_label.setSize(80,30);
				gm_add_number_label.setFont(font);
				gm_add_frame.getContentPane().add(gm_add_number_label);
				gm_add_number = new JTextField();
				gm_add_number.setText(String.valueOf(new GoodsController(operator).getgoodsnumber()));
				gm_add_number.setLocation(100,10);
				gm_add_number.setSize(180,40);
				gm_add_number.setEditable(false);
				gm_add_number.setBackground(Color.white);
				gm_add_number.setFont(font);
				gm_add_frame.add(gm_add_number);
				//����
				JLabel gm_add_name_label = new JLabel("����");
				gm_add_name_label.setLocation(30,65);
				gm_add_name_label.setSize(80,30);
				gm_add_name_label.setFont(font);
				gm_add_frame.getContentPane().add(gm_add_name_label);
				gm_add_name = new JTextField();
				gm_add_name.setLocation(100,60);
				gm_add_name.setSize(180,40);
				gm_add_name.setEditable(true);
				gm_add_name.setBackground(Color.white);
				gm_add_name.setFont(font);
				gm_add_frame.add(gm_add_name);
				//�ͺ�
				JLabel gm_add_type_label = new JLabel("�ͺ�");
				gm_add_type_label.setLocation(30,115);
				gm_add_type_label.setSize(80,30);
				gm_add_type_label.setFont(font);
				gm_add_frame.getContentPane().add(gm_add_type_label);
				gm_add_type = new JTextField();
				gm_add_type.setLocation(100,110);
				gm_add_type.setSize(180,40);
				gm_add_type.setEditable(true);
				gm_add_type.setBackground(Color.white);
				gm_add_type.setFont(font);
				gm_add_frame.add(gm_add_type);
				//��������
				JLabel gm_add_classification_label = new JLabel("��������");
				gm_add_classification_label.setLocation(10,165);
				gm_add_classification_label.setSize(120,30);
				gm_add_classification_label.setFont(font);
				gm_add_frame.getContentPane().add(gm_add_classification_label);
				gm_add_classification = new JComboBox();
				gm_add_classification.setLocation(100,160);
				gm_add_classification.setSize(180,40);
				gm_add_classification.setFont(font);
				gm_add_classification.setBackground(Color.white);
				gm_add_frame.add(gm_add_classification);
				//��ʾ������Ϣ
				GoodsClassificationController gcc = new GoodsClassificationController(operator);
				List<String> list = gcc.getAllSonClassifiaction();
				for(int i=0;i<list.size();i++){
					gm_add_classification.addItem(list.get(i));
				}
				//����
				JLabel gm_add_batchLot_label = new JLabel("����");
				gm_add_batchLot_label.setLocation(20,215);
				gm_add_batchLot_label.setSize(80,30);
				gm_add_batchLot_label.setFont(font);
				gm_add_frame.getContentPane().add(gm_add_batchLot_label);
				gm_add_batchLot = new JTextField();
				gm_add_batchLot.setLocation(100,210);
				gm_add_batchLot.setSize(180,40);
				gm_add_batchLot.setEditable(true);
				gm_add_batchLot.setBackground(Color.white);
				gm_add_batchLot.setFont(font);
				gm_add_frame.add(gm_add_batchLot);
				//����
				JLabel gm_add_batchNumber_label = new JLabel("����");
				gm_add_batchNumber_label.setLocation(20,265);
				gm_add_batchNumber_label.setSize(80,30);
				gm_add_batchNumber_label.setFont(font);
				gm_add_frame.getContentPane().add(gm_add_batchNumber_label);
				gm_add_batchNumber = new JTextField();
				gm_add_batchNumber.setLocation(100,260);
				gm_add_batchNumber.setSize(180,40);
				gm_add_batchNumber.setEditable(true);
				gm_add_batchNumber.setBackground(Color.white);
				gm_add_batchNumber.setFont(font);
				gm_add_frame.add(gm_add_batchNumber);
				//��������
				JLabel gm_add_time_label = new JLabel("��������");
				gm_add_time_label.setLocation(10,315);
				gm_add_time_label.setSize(120,30);
				gm_add_time_label.setFont(font);
				gm_add_frame.getContentPane().add(gm_add_time_label);
				gm_add_time = new JTextField();
				gm_add_time.setLocation(100,310);
				gm_add_time.setSize(180,40);
				gm_add_time.setEditable(true);
				gm_add_time.setBackground(Color.white);
				gm_add_time.setFont(font);
				gm_add_frame.add(gm_add_time);
				//�������
				JLabel gm_add_stockNumber_label = new JLabel("�������");
				gm_add_stockNumber_label.setLocation(10,365);
				gm_add_stockNumber_label.setSize(120,30);
				gm_add_stockNumber_label.setFont(font);
				gm_add_frame.getContentPane().add(gm_add_stockNumber_label);
				gm_add_stockNumber = new JTextField();
				gm_add_stockNumber.setLocation(100,360);
				gm_add_stockNumber.setSize(180,40);
				gm_add_stockNumber.setEditable(true);
				gm_add_stockNumber.setBackground(Color.white);
				gm_add_stockNumber.setFont(font);
				gm_add_frame.add(gm_add_stockNumber);
				//����
				JLabel gm_add_pricein_label = new JLabel("����");
				gm_add_pricein_label.setLocation(30,415);
				gm_add_pricein_label.setSize(120,30);
				gm_add_pricein_label.setFont(font);
				gm_add_frame.getContentPane().add(gm_add_pricein_label);
				gm_add_pricein = new JTextField();
				gm_add_pricein.setLocation(100,410);
				gm_add_pricein.setSize(180,40);
				gm_add_pricein.setEditable(true);
				gm_add_pricein.setBackground(Color.white);
				gm_add_pricein.setFont(font);
				gm_add_frame.add(gm_add_pricein);
				//���ۼ�
				JLabel gm_add_price_label = new JLabel("���ۼ�");
				gm_add_price_label.setLocation(20,465);
				gm_add_price_label.setSize(120,30);
				gm_add_price_label.setFont(font);
				gm_add_frame.getContentPane().add(gm_add_price_label);
				gm_add_price = new JTextField();
				gm_add_price.setLocation(100,460);
				gm_add_price.setSize(180,40);
				gm_add_price.setEditable(true);
				gm_add_price.setBackground(Color.white);
				gm_add_price.setFont(font);
				gm_add_frame.add(gm_add_price);
				//�������
				JLabel gm_add_latestPricein_label = new JLabel("�������");
				gm_add_latestPricein_label.setLocation(10,515);
				gm_add_latestPricein_label.setSize(120,30);
				gm_add_latestPricein_label.setFont(font);
				gm_add_frame.getContentPane().add(gm_add_latestPricein_label);
				gm_add_latestPricein = new JTextField();
				gm_add_latestPricein.setLocation(100,510);
				gm_add_latestPricein.setSize(180,40);
				gm_add_latestPricein.setEditable(true);
				gm_add_latestPricein.setBackground(Color.white);
				gm_add_latestPricein.setFont(font);
				gm_add_frame.add(gm_add_latestPricein);
				//������ۼ�
				JLabel gm_add_latestPrice_label = new JLabel("������ۼ�");
				gm_add_latestPrice_label.setLocation(0,565);
				gm_add_latestPrice_label.setSize(120,30);
				gm_add_latestPrice_label.setFont(font);
				gm_add_frame.getContentPane().add(gm_add_latestPrice_label);
				gm_add_latestPrice = new JTextField();
				gm_add_latestPrice.setLocation(100,560);
				gm_add_latestPrice.setSize(180,40);
				gm_add_latestPrice.setEditable(true);
				gm_add_latestPrice.setBackground(Color.white);
				gm_add_latestPrice.setFont(font);
				gm_add_frame.add(gm_add_latestPrice);
				
				JLabel gm_add_danger_label = new JLabel("��������");
				gm_add_danger_label.setLocation(10,615);
				gm_add_danger_label.setSize(120,30);
				gm_add_danger_label.setFont(font);
				gm_add_frame.getContentPane().add(gm_add_danger_label);
				gm_add_dangerNumber = new JTextField();
				gm_add_dangerNumber.setLocation(100,610);
				gm_add_dangerNumber.setSize(180,40);
				gm_add_dangerNumber.setEditable(true);
				gm_add_dangerNumber.setBackground(Color.white);
				gm_add_dangerNumber.setFont(font);
				gm_add_frame.add(gm_add_dangerNumber);
				//ȷ��
				gm_add_confirm = new JButton("ȷ��");
				gm_add_confirm.addActionListener(new ButtonActionListener());
				gm_add_confirm.setLocation(220,660);
				gm_add_confirm.setSize(80,50);
				gm_add_confirm.setFont(font);
				gm_add_confirm.setForeground(Color.red);
				gm_add_confirm.setFocusPainted(false);
				gm_add_frame.add(gm_add_confirm);
				//ȡ��
				gm_add_cancel = new JButton("ȡ��");
				gm_add_cancel.addActionListener(new ButtonActionListener());
				gm_add_cancel.setLocation(30,660);
				gm_add_cancel.setSize(80,50);
				gm_add_cancel.setFont(font);
				gm_add_cancel.setForeground(Color.red);
				gm_add_cancel.setFocusPainted(false);
				gm_add_frame.add(gm_add_cancel);
				
				gm_add_frame.setVisible(true);
			}
			else if(e.getSource() == gm_add_cancel){
				gm_add_frame.dispose();
			}
			else if(e.getSource() == gm_add_confirm){
				GoodsController gc = new GoodsController(operator);
				GoodsVO vo = new GoodsVO();
				vo.setNumber(Integer.valueOf(gm_add_number.getText()));
				vo.setName(gm_add_name.getText());
				vo.setType(gm_add_type.getText());
				vo.setClassification(gm_add_classification.getSelectedItem().toString());
				vo.setPici(gm_add_batchLot.getText());
				vo.setPihao(gm_add_batchNumber.getText());
				vo.setChuchangriqi(gm_add_time.getText());
				vo.setStocknumber(Integer.valueOf(gm_add_stockNumber.getText()));
				vo.setPricein(Double.valueOf(gm_add_pricein.getText()));
				vo.setPrice(Double.valueOf(gm_add_price.getText()));
				vo.setLatestpricein(Double.valueOf(gm_add_latestPricein.getText()));
				vo.setLatestpeice(Double.valueOf(gm_add_latestPrice.getText()));
				vo.setDangernumber(Integer.valueOf(gm_add_dangerNumber.getText()));
				gc.insertGoods(vo);
				DefaultTableModel model = (DefaultTableModel)goods_table.getModel();
				String [] data = new String[13];
				data[0] = gm_add_number.getText();
				data[1] = gm_add_name.getText();
				data[2] = gm_add_type.getText();
				data[3] = gm_add_classification.getSelectedItem().toString();
				data[4] = gm_add_batchLot.getText();
				data[5] = gm_add_batchNumber.getText();
				data[6] = gm_add_time.getText();
				data[7] = gm_add_stockNumber.getText();
				data[8] = gm_add_pricein.getText();
				data[9] = gm_add_price.getText();
				data[10] = gm_add_latestPricein.getText();
				data[11] = gm_add_latestPrice.getText();
				data[12] = gm_add_dangerNumber.getText();
				model.addRow(data);
				goods_table.setModel(model);
				gm_add_frame.dispose();
				gc.insertLog("������Ʒ");
			}
			else if(e.getSource()==gm_remove){
				
				if(removeFlag != -1){
					DefaultTableModel model = (DefaultTableModel)goods_table.getModel();
					model.removeRow(removeFlag);
					goods_table.setModel(model);
					removeFlag = -1;
					updateFlag = -1;
				}
				GoodsController gc=new GoodsController(operator);
				gc.insertLog("ɾ����Ʒ");
			}
			else if(e.getSource() == gm_update){
				if(updateFlag != -1){
					GoodsVO vo = new GoodsVO();
					vo.setNumber((int)(goods_table.getValueAt(updateFlag, 0)));
					GoodsController gc=new GoodsController(operator);
					double a=new Double(goods_table.getValueAt(updateFlag, 8).toString());
					double b=new Double(goods_table.getValueAt(updateFlag, 9).toString());
					gc.updateGoods(vo,a ,b );
					updateFlag=-1;
				}
				GoodsController gc=new GoodsController(operator);
				gc.insertLog("������Ʒ");
			}
			else if(e.getSource() == gcm_add){
				//��ȡѡ�нڵ�   
                DefaultMutableTreeNode selectedNode   
                    = (DefaultMutableTreeNode) gc_tree.getLastSelectedPathComponent();
                if(selectedNode.isLeaf()){
                	GoodsClassificationController gcc = new GoodsClassificationController(operator);
                	boolean flag = gcc.hasGoods(selectedNode.getUserObject().toString());
                	if(flag){
                		return ;
                	}
                }
                if(selectedNode!=null){
                    DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("�·���");   
                    DefaultTreeModel model = (DefaultTreeModel)gc_tree.getModel();
                    int selectedIndex = selectedNode.getChildCount();
                    model.insertNodeInto(newNode, selectedNode, selectedIndex);
                    //�Զ�չ�����ڵ�     
                    TreeNode[] nodes = model.getPathToRoot(newNode);      
                    TreePath path = new TreePath(nodes);
                    gc_tree.scrollPathToVisible(path);
                 }
                DefaultMutableTreeNode node   
                = (DefaultMutableTreeNode) gc_tree.getLastSelectedPathComponent();
                GoodsClassificationController gcc = new GoodsClassificationController(operator);
                gcc.addClassification(selectedNode.getUserObject().toString(),"�·���");
                gcc.insertLog("������Ʒ����");
			}
			else if(e.getSource() == gcm_remove){
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)gc_tree.getLastSelectedPathComponent();
				if(node != null){
				    if(node.isLeaf() == true){
					    DefaultTreeModel model = (DefaultTreeModel)gc_tree.getModel();
					    model.removeNodeFromParent(node);
				    }
				}
				 GoodsClassificationController gcc = new GoodsClassificationController(operator);
				 gcc.insertLog("ɾ����Ʒ����");
			}
			else if(e.getSource() == gcm_update){
				//������Ʒ������Ҫ������
                DefaultMutableTreeNode selectedNode   
                = (DefaultMutableTreeNode) gc_tree.getLastSelectedPathComponent();
                GoodsClassificationController gcc = new GoodsClassificationController(operator);
                gcc.updateClassification(oldName, selectedNode.getUserObject().toString());
                oldName = "";
				 gcc.insertLog("�޸���Ʒ����");
			}
			else if(e.getSource() == sc_cancel){
				DefaultTableModel model = (DefaultTableModel)sc_table.getModel();
				int n = model.getRowCount() - 1;
				while(n >= 0){
					model.removeRow(n);
					n--;
				}
			}
			else if(e.getSource() == sc_confirm){
				String begin = "";
				begin = begin + start_year.getSelectedItem().toString()
						+ start_month.getSelectedItem().toString()
						+ start_day.getSelectedItem().toString();
				String end = "";
				end = end + end_year.getSelectedItem().toString()
						+ end_month.getSelectedItem().toString()
						+ end_day.getSelectedItem().toString();
				StockController sc = new StockController(operator);
				List<StockChangeVO> list = sc.showStock(begin, end);
				DefaultTableModel model = (DefaultTableModel)sc_table.getModel();
				int n = model.getRowCount() - 1;
				while(n >= 0){
					model.removeRow(n);
					n--;
				}
				Object[][] data = new Object[list.size()][11];
				for(int i=0;i<list.size();i++){
					data[i][0] = list.get(i).getGoodsnumber();
					data[i][1] = list.get(i).getName();
					data[i][2] = list.get(i).getStockoutnum();
					data[i][3] = list.get(i).getStockinnum();
					data[i][4] = list.get(i).getStockoutprice();
					data[i][5] = list.get(i).getStockinprice();
					data[i][6] = list.get(i).getSalesnum();
					data[i][7] = list.get(i).getSalesprice();
					data[i][8] = list.get(i).getPurchasenum();
					data[i][9] = list.get(i).getPurchasepirce();
				}
				for(int i=0;i<list.size();i++)
					model.addRow(data[i]);
				
				 GoodsClassificationController gcc = new GoodsClassificationController(operator);
				 gcc.insertLog("���鿴");
			}
			else if(e.getSource()==grant_submit){
				StockGrantOrderVO vo=new StockGrantOrderVO();
				OrderController oc=new OrderController(operator);
				Date a=new Date();
				vo.setDate(DatetoString.datetostr(a));
				vo.setIscheck(0);
				vo.setOrdernumber2(so_grant_number.getText());
				List<GoodsListVO> list=new ArrayList<GoodsListVO>();
				for(int i=0;i<grant_table.getRowCount();i++){					
					if((boolean)grant_table.getValueAt(i, 6)){
						GoodsListVO g = new GoodsListVO();
						g.setGoodsnumber(Integer.parseInt(grant_table.getValueAt(i, 0).toString()));					
						g.setNumber(Integer.parseInt(grant_table.getValueAt(i, 5).toString()));
						list.add(g);
					}
				}
				vo.setList(list);
				oc.CreateStockGrantOrder(vo);
				//�������
				so_grant_comment.setText("");
				for(int i=0;i<grant_table.getRowCount();i++){
				    grant_table.setValueAt(0, i, 5);
				    grant_table.setValueAt(new Boolean(false), i, 6);
				}
				GoodsClassificationController gcc = new GoodsClassificationController(operator);
				gcc.insertLog("�½�������͵�");
				JOptionPane.showMessageDialog(frame.getContentPane(), "�ύ�ɹ���");
			}
			else if(e.getSource()==loss_submit){
				StockLossOrderVO vo=new StockLossOrderVO();
				OrderController oc=new OrderController(operator);
				Date a=new Date();
				vo.setDate(DatetoString.datetostr(a));
				vo.setIscheck(0);
				vo.setOrdernumber2(so_loss_number.getText());
				
				for(int i=0;i<loss_table.getRowCount();i++){					
					if((boolean)loss_table.getValueAt(i, 5)){
						vo.setName(loss_table.getValueAt(i, 1).toString());				
						vo.setActualnumber(Integer.valueOf(loss_table.getValueAt(i, 4).toString()));
						vo.setStocknumber(Integer.valueOf(loss_table.getValueAt(i, 3).toString()));
					}
				}
				oc.CreateStockLossOrder(vo);
				//�������
				so_loss_comment.setText("");
				for(int i=0;i<loss_table.getRowCount();i++){
				    loss_table.setValueAt(0, i, 5);
				    loss_table.setValueAt(new Boolean(false), i, 5);
				}
				GoodsClassificationController gcc = new GoodsClassificationController(operator);
				gcc.insertLog("�½���汨��");
				JOptionPane.showMessageDialog(frame.getContentPane(), "�ύ�ɹ���");
			}
			else if(e.getSource()==of_submit){
				StockOverflowOrderVO vo=new StockOverflowOrderVO();
				OrderController oc=new OrderController(operator);
				Date a=new Date();
				vo.setDate(DatetoString.datetostr(a));
				vo.setIscheck(0);
				vo.setOrdernumber2(so_of_number.getText());
				
				for(int i=0;i<of_table.getRowCount();i++){					
					if((boolean)of_table.getValueAt(i, 5)){
						vo.setName(of_table.getValueAt(i, 1).toString());				
						vo.setActualnumber(Integer.valueOf(of_table.getValueAt(i, 4).toString()));
						vo.setStocknumber(Integer.valueOf(of_table.getValueAt(i, 3).toString()));
					}
				}
				oc.CreateStockOverflowOrder(vo);
				//�������
				so_of_comment.setText("");
				for(int i=0;i<of_table.getRowCount();i++){
				    of_table.setValueAt(0, i, 5);
				    of_table.setValueAt(new Boolean(false), i, 5);
				}
				GoodsClassificationController gcc = new GoodsClassificationController(operator);
				gcc.insertLog("�½���汨�絥");
				JOptionPane.showMessageDialog(frame.getContentPane(), "�ύ�ɹ���");
			}
			else if(e.getSource()==alarm_submit){
				StockAlarmOrderVO vo =new StockAlarmOrderVO();
				OrderController oc=new OrderController(operator);
				Date a=new Date();
				DefaultTableModel model=(DefaultTableModel)alarm_table.getModel();
				vo.setDate(DatetoString.datetostr(a));
				vo.setIscheck(0);
				vo.setOrdernumber2(so_alarm_number.getText());	
				List<GoodsListVO> list=new ArrayList<GoodsListVO>();
				for(int i=0;i<model.getRowCount();i++){
					GoodsListVO good=new GoodsListVO();
					good.setGoodsnumber(Integer.valueOf(model.getValueAt(i, 0).toString()));				
					good.setNumber(Integer.valueOf(alarm_table.getValueAt(i, 4).toString()));								
					list.add(good);
				}
				vo.setList(list);
				oc.CreateStockAlarmOrder(vo);
				//�������
				so_alarm_comment.setText("");
				DefaultTableModel tableModel = (DefaultTableModel)alarm_table.getModel();
				for(int i=alarm_table.getRowCount()-1;i>=0;i--){
				    tableModel.removeRow(i);
				}
				GoodsClassificationController gcc = new GoodsClassificationController(operator);
				gcc.insertLog("�½���汨����");
				JOptionPane.showMessageDialog(frame.getContentPane(), "�ύ�ɹ���");
			}
			
		}
	}
	
	class MouseActionListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == goods_table){
			    //˫��һ�к���ʾ���ݵ���ϸ��Ϣ
			    removeFlag = goods_table.getSelectedRow();
			    updateFlag = goods_table.getSelectedRow();
			}
			else if(e.getSource() == gc_tree){
				 DefaultMutableTreeNode selectedNode
	                = (DefaultMutableTreeNode) gc_tree.getLastSelectedPathComponent();
				 oldName = selectedNode.getUserObject().toString();
			}
			else if(e.getSource() == message_label){
				if(noticeFlag == 1){
					JOptionPane.showMessageDialog(frame.getContentPane(),"�����µĿ�����͵��ȴ�����", "ϵͳ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
					noticeFlag = 0;
					message_label.setIcon(message);
				}
				if(alarmFlag == 1){
					String str = "������Ʒ:";
					List<GoodsVO> goods_list = new ArrayList<GoodsVO>();
					try {
						goods_list = RemoteHelper.getInstance().getStockblservice().queryDangerGoods();
					} catch (RemoteException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					for(int i=0;i<goods_list.size();i++){
						str = str + goods_list.get(i).getName() + " ";
					}
					str = str + "���ھ����������뾡�촦��!";
					JOptionPane.showMessageDialog(frame.getContentPane(),str, "ϵͳ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
					alarmFlag = 0;
					message_label.setIcon(message);
				}
			}
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
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}


	
	class boxItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			//ѡ��item��Ӧ
			if(e.getStateChange() == ItemEvent.SELECTED){
				if(e.getSource() == start_month){
					int index = start_month.getSelectedIndex();
					index++;
					if(index==1 || index==3 || index==5 || index==7 || index==8 || index==10 || index==12){
						start_day.removeItem("29");
						start_day.removeItem("30");
						start_day.removeItem("31");
						start_day.addItem("29");
						start_day.addItem("30");
						start_day.addItem("31");
					}else if(index==4 || index==6 || index==9 || index==11){
						start_day.removeItem("29");
						start_day.removeItem("30");
						start_day.removeItem("31");
						start_day.addItem("29");
						start_day.addItem("30");
					}else if(index==2){
						start_day.removeItem("29");
						start_day.removeItem("30");
						start_day.removeItem("31");
					}
				}else if(e.getSource() == end_month){
					int index = end_month.getSelectedIndex();
					index++;
					if(index==1 || index==3 || index==5 || index==7 || index==8 || index==10 || index==12){
						end_day.removeItem("29");
						end_day.removeItem("30");
						end_day.removeItem("31");
						end_day.addItem("29");
						end_day.addItem("30");
						end_day.addItem("31");
					}else if(index==4 || index==6 || index==9 || index==11){
						end_day.removeItem("29");
						end_day.removeItem("30");
						end_day.removeItem("31");
						end_day.addItem("29");
						end_day.addItem("30");
					}else if(index==2){
						end_day.removeItem("29");
						end_day.removeItem("30");
						end_day.removeItem("31");
					}
				}
				else if(e.getSource() == so_classification){
					int index = so_classification.getSelectedIndex();
					if(index == 0){
						so_grant.setVisible(true);
						so_of.setVisible(false);
						so_loss.setVisible(false);
						so_alarm.setVisible(false);
						//��ʾ��Ʒ�б�
						GoodsController gc = new GoodsController(operator);
						Object[][] data = new Object[gc.query().size()][7];
						for(int i=0;i<gc.query().size();i++){
							data[i][0] = gc.query().get(i).getNumber();
							data[i][1] = gc.query().get(i).getName();
							data[i][2] = gc.query().get(i).getType();
							data[i][3] = gc.query().get(i).getLatestpeice();
							data[i][4] = gc.query().get(i).getStocknumber();
							data[i][5] = "0";
							data[i][6] = new Boolean(false);
						}
						grant_mytable.setData(data);
						grant_table.setModel(grant_mytable);
						StockController sc=new StockController(operator);
						so_grant_number.setEditable(false);
						so_grant_number.setText(sc.getStockGrantOrderNumber());
						so_grant_operator.setText(operator);
						
						so_grant_operator.setEditable(false);
					}
					else if(index == 1){
						so_grant.setVisible(false);
						so_of.setVisible(true);
						so_loss.setVisible(false);
						so_alarm.setVisible(false);
						//��ʾ�����Ϣ
						GoodsController gc = new GoodsController(operator);
						Object[][] data = new Object[gc.query().size()][6];
						for(int i=0;i<gc.query().size();i++){
							data[i][0] = gc.query().get(i).getNumber();
							data[i][1] = gc.query().get(i).getName();
							data[i][2] = gc.query().get(i).getType();
							data[i][3] = gc.query().get(i).getStocknumber();
							data[i][4] = 0;
							data[i][5] = new Boolean(false);
						}
						of_mytable.setData(data);
						of_table.setModel(of_mytable);
						StockController sc=new StockController(operator);
						so_of_number.setText(sc.getStockOverflowOrderNumber());
						so_of_operator.setText(operator);
						so_of_number.setEditable(false);
						so_of_operator.setEditable(false);
					}
					else if(index == 2){
						so_grant.setVisible(false);
						so_of.setVisible(false);
						so_loss.setVisible(true);
						so_alarm.setVisible(false);
						//��ʾ�����Ϣ
						GoodsController gc = new GoodsController(operator);
						Object[][] data = new Object[gc.query().size()][6];
						for(int i=0;i<gc.query().size();i++){
							data[i][0] = gc.query().get(i).getNumber();
							data[i][1] = gc.query().get(i).getName();
							data[i][2] = gc.query().get(i).getType();
							data[i][3] = gc.query().get(i).getStocknumber();
							data[i][4] = 0;
							data[i][5] = new Boolean(false);
						}
						loss_mytable.setData(data);
						loss_table.setModel(loss_mytable);
						StockController sc=new StockController(operator);
						so_loss_number.setText(sc.getStockLossOrderNumber());
						so_loss_operator.setText(operator);
						so_loss_number.setEditable(false);
						so_loss_operator.setEditable(false);
					}
					else if(index == 3){
						so_grant.setVisible(false);
						so_of.setVisible(false);
						so_loss.setVisible(false);
						so_alarm.setVisible(true);
						StockController sc=new StockController(operator);
						so_alarm_number.setText(sc.getStockAlarmOrderNumber());
						so_alarm_operator.setText(operator);
						so_alarm_number.setEditable(false);
						so_alarm_operator.setEditable(false);
						DefaultTableModel model = (DefaultTableModel)alarm_table.getModel();
						int n = model.getRowCount() - 1;
						while(n >= 0){
							model.removeRow(n);
							n--;
						}
						List<GoodsVO> list=sc.queryDangerGoods();
						Object data[][]=new Object [list.size()][5];
						for(int i=0;i<list.size();i++){
							data[i][0]=list.get(i).getNumber();
							data[i][1]=list.get(i).getName();
							data[i][2]=list.get(i).getType();
							data[i][3]=list.get(i).getDangernumber();
							data[i][4]=list.get(i).getStocknumber();
						}
						for(int i=0;i<list.size();i++){
							model.addRow(data[i]);
						}
						alarm_table.setModel(model);
					}
				}
			}
		}
		
	}
	
	class ImageJPanel extends JPanel{ 
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
	
	private DefaultMutableTreeNode createtree(String root,DefaultMutableTreeNode trueroot){
		GoodsClassificationController gcc=new GoodsClassificationController(operator);
		List<String> list=gcc.getson(root);
		//����Ǹ��ڵ㣬�������ý�������
		if(list.size()!=0){
			for(int j=0;j<list.size();j++){
				DefaultMutableTreeNode current=new DefaultMutableTreeNode(list.get(j));
			    trueroot.add(current); 
			    createtree(list.get(j),current);
			}
		}
		//������ӽڵ�,���ӽڵ��������Ʒ�ӵ��ýڵ�
		/*else{
			for(int j=0;j<2;j++)
				trueroot.add(new DefaultMutableTreeNode("555"));
		}*/
		return trueroot;
		
	}
	
}