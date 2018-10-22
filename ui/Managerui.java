package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import controller.BusinessCourseController;
import controller.CheckPurchaseController;
import controller.CheckReceiptController;
import controller.CheckSalesController;
import controller.CheckStockController;
import controller.CustomerController;
import controller.GoodsClassificationController;
import controller.GoodsController;
import controller.LogController;
import controller.ManagementSituationController;
import controller.PromotionController;
import controller.SalesDetailController;
import ui.Finacialmanui.PieChart;
import ui.Finacialmanui.boxItemListener;
import ui.Stockmanui.ButtonActionListener;
import utility.ResultMessage;
import vo.CustomerVO;
import vo.GoodsCombinationPromotionVO;
import vo.GoodsListVO;
import vo.GoodsVO;
import vo.LevelPromotionVO;
import vo.LogVO;
import vo.PayOrderVO;
import vo.PurchaseBackOrderVO;
import vo.PurchaseOrderVO;
import vo.ReceiptBackVO;
import vo.ReceiptVO;
import vo.SalesBackOrderVO;
import vo.SalesOrderVO;
import vo.StockAlarmOrderVO;
import vo.StockGrantOrderVO;
import vo.StockLossOrderVO;
import vo.StockOverflowOrderVO;
import vo.TotalPromotionVO;

public class Managerui {
	
	private String operator;//����Ա
	private JFrame frame;
	private JPanel co_panel;//�������ݽ���
	private JPanel xsmx_panel;//�鿴������ϸ�����
	private JPanel jylc_panel;//�鿴��Ӫ���̱����
	private JPanel jyqk_panel;//�鿴��Ӫ��������
	private JPanel mp_panel;//�ƶ����۲��Խ���
	private JPanel imagePanel;//����
	private JButton close;//�ر�
	private JButton logout;//ע��
	private JButton checkOrder;//��������
	private JButton xsmx;//������ϸ
	private JButton jylc;//��Ӫ����
	private JButton jyqk;//��Ӫ���
	private JButton promotion;//�ƶ����۲���
	private JComboBox order_Classification;//��������
	private JButton order_search;//��ѯ
	private Mytable order_mytable;
	private JTable order_table;//�����б�
	private JButton co_pass;//����ͨ��
	private JButton co_unpass;//������ͨ��
	private JComboBox xsmx_start_year;
	private JComboBox xsmx_start_month;
	private JComboBox xsmx_start_day;
	private JComboBox xsmx_end_year;
	private JComboBox xsmx_end_month;
	private JComboBox xsmx_end_day;
	private JComboBox goods_box;//��Ʒ
	private JComboBox customer_box;//�ͻ�
	private JTextField salesman_box;//ҵ��Ա
	private JComboBox stock_box;//�ֿ�
	private JTable xsmx_table;//������ϸ��
	private JButton xsmx_confirm;
	private JButton xsmx_cancel;
	private JComboBox promotion_classification;//��������
	private JPanel level_promotion;//��Լ���
	private JPanel goods_promotion;//��������Ʒ
	private JPanel money_promotion;//����ܼ�
	private JComboBox mp_start_year;
	private JComboBox mp_start_month;
	private JComboBox mp_start_day;
	private JComboBox mp_end_year;
	private JComboBox mp_end_month;
	private JComboBox mp_end_day;
	private JComboBox level_box;
	private JTable level_table;//��Ʒѡ���
	private Mytable1 level_grant_table;
	private JTable goods_table;//�����Ʒѡ���
	private Mytable2 goods_mytable;
	private JTable money_table;//��Ʒѡ���
	private Mytable1 money_grant_table;
	private JTextField discount;//����
	private JTextField voucher;//����ȯ
	private JButton level_confirm;
	private JButton level_cancel;
	private JTextField addUp;//�ܼ�
	private JTextField bargain;//�ؼ�
	private JButton goods_confirm;
	private JButton goods_cancel;
	private JTextField money;//��Ͷ��
	private JTextField voucher1;//����ȯ
	private JButton money_confirm;
	private JButton money_cancel;
	private JComboBox jylc_start_year;
	private JComboBox jylc_start_month;
	private JComboBox jylc_start_day;
	private JComboBox jylc_end_year;
	private JComboBox jylc_end_month;
	private JComboBox jylc_end_day;
	private JComboBox oc;//��������
	private JComboBox jylc_customer;//�ͻ�
	private JTextField jylc_salesman;//ҵ��Ա
	private JComboBox jylc_stock;//�ֿ�
	private Mytable jylc_mytable;
	private JTable jylcOrder_table;//�����б�
	private JButton jylc_confirm;//
	private JButton jylc_cancel;//
	private JTable jyqkOrder_table;//�����б�
	private JComboBox jyqk_start_year;
	private JComboBox jyqk_start_month;
	private JComboBox jyqk_start_day;
	private JComboBox jyqk_end_year;
	private JComboBox jyqk_end_month;
	private JComboBox jyqk_end_day;
	private JButton jyqk_analyse;
	private JButton jyqk_export;
	private JTextField sale_income;//��������
	private JTextField goods_income;//��Ʒ������
	private JTextField discount_income;//����
	private JTextField sale_outcome;//����֧��
	private JTextField goods_outcome;//��Ʒ��֧��
	private JTextField addup_income;//������
	private JTextField addup_outcome;//��֧��
	private JTextField profit;//����
	private JButton jyqk_confirm;
	private JButton jyqk_cancel;
	private JButton checkLog;//�鿴��־
	private JFrame checkLog_frame;
	
	public static void main(String args[]){
		new Managerui("�ܾ���");
	}
	public Managerui(String operator){
		//����Ա
		this.operator = operator;
		//��������
		Font font0 = new Font("Default",Font.BOLD,30);
		Font font = new Font("Default",Font.BOLD,20);
		Font font1 = new Font("Default",Font.BOLD,25);
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(830, 650);
		frame.setLocation(600, 230);
		//�������
		JLabel title = new JLabel("<html>�ƾ߽�����ϵͳ<br>(PSIS)<html/>");
		title.setFont(font0);
		title.setSize(250,80);
		title.setLocation(20,20);
		title.setForeground(Color.pink);
		frame.getContentPane().add(title);
		/*
		 * �ر�
		 */
		close = new JButton("X");
		close.setFont(font1);
		close.setForeground(Color.white);
		close.addActionListener(new ButtonActionListener());
		close.setSize(80,50);
		close.setLocation(750,0);
		close.setContentAreaFilled(false);
		close.setFocusPainted(false);
		frame.getContentPane().add(close);
		/*
		 * ע��
		 */
		logout = new JButton("ע��       ");
		logout.addActionListener(new ButtonActionListener());
		logout.setLocation(0,580);
		logout.setSize(150,70);
		logout.setFont(font);
		logout.setForeground(Color.red);
		logout.setContentAreaFilled(false);
		logout.setFocusPainted(false);
		ImageIcon logout_icon = new ImageIcon("��Դ.png");
		JLabel logout_label = new JLabel(logout_icon);
		logout_label.setLocation(88,590);
		logout_label.setSize(logout_icon.getIconWidth(),logout_icon.getIconHeight());
		frame.getContentPane().add(logout_label);
		frame.getContentPane().add(logout);
		/*
		 * �鿴��־
		 */
		checkLog = new JButton("    �鿴��־ ");
		checkLog.addActionListener(new ButtonActionListener());
		checkLog.setLocation(0,520);
		checkLog.setSize(230,60);
		checkLog.setFont(font);
		checkLog.setForeground(Color.white);
		checkLog.setContentAreaFilled(false);
		checkLog.setFocusPainted(false);
		ImageIcon checkLog_icon = new ImageIcon("�ļ�.png");
		JLabel checkLog_label = new JLabel(checkLog_icon);
		checkLog_label.setLocation(30,530);
		checkLog_label.setSize(checkLog_icon.getIconWidth(),checkLog_icon.getIconHeight());
		frame.getContentPane().add(checkLog_label);
		frame.getContentPane().add(checkLog);
		/*
		 * �������ݰ�ť
		 */
		checkOrder = new JButton("��������");
		checkOrder.addActionListener(new ButtonActionListener());
		checkOrder.setLocation(0,120);
		checkOrder.setSize(230,80);
		checkOrder.setFont(font);
		checkOrder.setForeground(Color.white);
		checkOrder.setFocusPainted(false);
		checkOrder.setContentAreaFilled(false);
		frame.getContentPane().add(checkOrder);
		ImageIcon checkOrder_icon = new ImageIcon("5.png");
		JLabel checkOrder_label = new JLabel(checkOrder_icon);
		checkOrder_label.setLocation(10,140);
		checkOrder_label.setSize(checkOrder_icon.getIconWidth(),checkOrder_icon.getIconHeight());
		frame.getContentPane().add(checkOrder_label);
		/*
		 * �鿴������ϸ��ť
		 */
		xsmx = new JButton("    �鿴������ϸ��");
		xsmx.addActionListener(new ButtonActionListener());
		xsmx.setLocation(0,200);
		xsmx.setSize(230,80);
		xsmx.setFont(font);
		xsmx.setForeground(Color.white);
		xsmx.setFocusPainted(false);
		xsmx.setContentAreaFilled(false);
		frame.getContentPane().add(xsmx);
		ImageIcon xsmx_icon = new ImageIcon("search.png");
		JLabel xsmx_label = new JLabel(xsmx_icon);
		xsmx_label.setLocation(0,215);
		xsmx_label.setSize(xsmx_icon.getIconWidth(),xsmx_icon.getIconHeight());
		frame.getContentPane().add(xsmx_label);
		/*
		 * �鿴��Ӫ���̱�ť
		 */
		jylc = new JButton("    �鿴��Ӫ���̱�");
		jylc.addActionListener(new ButtonActionListener());
		jylc.setLocation(0,280);
		jylc.setSize(230,80);
		jylc.setFont(font);
		jylc.setForeground(Color.white);
		jylc.setFocusPainted(false);
		jylc.setContentAreaFilled(false);
		frame.getContentPane().add(jylc);
		ImageIcon jylc_icon = new ImageIcon("search.png");
		JLabel jylc_label = new JLabel(jylc_icon);
		jylc_label.setLocation(0,295);
		jylc_label.setSize(jylc_icon.getIconWidth(),jylc_icon.getIconHeight());
		frame.getContentPane().add(jylc_label);
		/*
		 * �鿴��Ӫ�����ť
		 */
		jyqk = new JButton("    �鿴��Ӫ�����");
		jyqk.addActionListener(new ButtonActionListener());
		jyqk.setLocation(0,360);
		jyqk.setSize(230,80);
		jyqk.setFont(font);
		jyqk.setForeground(Color.white);
		jyqk.setFocusPainted(false);
		jyqk.setContentAreaFilled(false);
		frame.getContentPane().add(jyqk);
		ImageIcon jyqk_icon = new ImageIcon("search.png");
		JLabel jyqk_label = new JLabel(jyqk_icon);
		jyqk_label.setLocation(0,375);
		jyqk_label.setSize(jyqk_icon.getIconWidth(),jyqk_icon.getIconHeight());
		frame.getContentPane().add(jyqk_label);
		/*
		 * �ƶ����۲��԰�ť
		 */
		promotion = new JButton(" �ƶ����۲���");
		promotion.addActionListener(new ButtonActionListener());
		promotion.setLocation(0,440);
		promotion.setSize(230,80);
		promotion.setFont(font);
		promotion.setForeground(Color.white);
		promotion.setFocusPainted(false);
		promotion.setContentAreaFilled(false);
		frame.getContentPane().add(promotion);
		ImageIcon promotion_icon = new ImageIcon("�ļ�.png");
		JLabel promotion_label = new JLabel(promotion_icon);
		promotion_label.setLocation(10,465);
		promotion_label.setSize(promotion_icon.getIconWidth(),promotion_icon.getIconHeight());
		frame.getContentPane().add(promotion_label);
		
		/*
		 *�������ݽ���
		 */
		co_panel = new JPanel();
		co_panel.setLayout(null);
		co_panel.setLocation(260,50);
		co_panel.setSize(460,550);
		co_panel.setOpaque(true);
		co_panel.setBackground(Color.cyan);
		/*
		 * ɸѡ����
		 */
		//��������
		JLabel oc_label = new JLabel("��������");
		oc_label.setLocation(30,30);
		oc_label.setSize(150,30);
		oc_label.setFont(font1);
		oc_label.setForeground(Color.black);
		co_panel.add(oc_label);
		order_search = new JButton("��ѯ");
		order_search.addActionListener(new ButtonActionListener());
		order_search.setLocation(340,20);
		order_search.setSize(80,50);
		order_search.setFont(font);
		order_search.setForeground(Color.black);
		order_search.setContentAreaFilled(true);
		order_search.setFocusPainted(false);
		co_panel.add(order_search);
		order_Classification = new JComboBox();
		order_Classification.setLocation(160,20);
		order_Classification.setSize(180,50);
		order_Classification.addItem("�����൥��");
		order_Classification.addItem("�����൥��");
		order_Classification.addItem("�����൥��");
		order_Classification.addItem("����൥��");
		order_Classification.setBackground(Color.white);
		order_Classification.setFont(font1);
		co_panel.add(order_Classification);
		//�����б�
		JLabel order_table_label = new JLabel("�����б�");
		order_table_label.setLocation(170,80);
		order_table_label.setSize(150,40);
		order_table_label.setFont(font1);
		order_table_label.setForeground(Color.red);
		co_panel.add(order_table_label);
		order_mytable = new Mytable();
		order_table = new JTable(order_mytable);
		order_table.addMouseListener(new MouseActionListener());
		order_table.getTableHeader().setReorderingAllowed(false);
		order_table.setBackground(Color.cyan);
		order_table.getTableHeader().setPreferredSize(new Dimension(1, 50));
		order_table.getTableHeader().setFont(font);
		order_table.getTableHeader().setForeground(Color.red);
		order_table.setRowHeight(33);
		order_table.setFont(font);
		JScrollPane order_scrollPane = new JScrollPane(order_table);
		order_scrollPane.setLocation(0,120);
		order_scrollPane.setSize(460,360);
		order_scrollPane.getViewport().setBackground(Color.cyan);
		co_panel.add(order_scrollPane);
		/*
		 * button�ؼ�
		 */
		co_pass = new JButton("ͨ��");
		co_pass.addActionListener(new ButtonActionListener());
		co_pass.setLocation(300,490);
		co_pass.setSize(100,50);
		co_pass.setFont(font);
		co_pass.setForeground(Color.magenta);
		co_pass.setFocusPainted(false);
		co_panel.add(co_pass);
		co_unpass = new JButton("����");
		co_unpass.addActionListener(new ButtonActionListener());
		co_unpass.setLocation(60,490);
		co_unpass.setSize(100,50);
		co_unpass.setFont(font);
		co_unpass.setForeground(Color.magenta);
		co_unpass.setFocusPainted(false);
		co_panel.add(co_unpass);
		co_panel.setVisible(false);
		frame.getContentPane().add(co_panel);
		
		/*
		 * �鿴������ϸ����
		 */
		xsmx_panel = new JPanel();
		xsmx_panel.setLayout(null);
		xsmx_panel.setLocation(260,50);
	    xsmx_panel.setSize(490,550);
		xsmx_panel.setLayout(null);
		xsmx_panel.setBackground(Color.cyan);
		xsmx_panel.setOpaque(true);
		/*
	     * ��ѯ����
		 */
		//��ֹʱ��
		JLabel start = new JLabel("��ʼ����");
		start.setLocation(20,10);
		start.setSize(100,40);
		start.setFont(font);
		start.setForeground(Color.magenta);
		xsmx_panel.add(start);
		JLabel end = new JLabel("��������");
		end.setLocation(20,60);
		end.setSize(100,40);
		end.setFont(font);
		end.setForeground(Color.magenta);
		xsmx_panel.add(end);
		//��ʼ���
		xsmx_start_year = new JComboBox();
		xsmx_start_year.setMaximumRowCount(10);
		xsmx_start_year.addItem("2017");
		xsmx_start_year.addItem("2018");
		xsmx_start_year.setFont(font);
		xsmx_start_year.setLocation(120,10);
		xsmx_start_year.setSize(80,40);
		xsmx_start_year.setEditable(false);
		xsmx_start_year.setBackground(Color.white);
		xsmx_panel.add(xsmx_start_year);
		JLabel label_year = new JLabel("��");
		label_year.setLocation(210,10);
		label_year.setSize(50,40);
		label_year.setFont(font);
		label_year.setForeground(Color.black);
		xsmx_panel.add(label_year);
		//�������
		xsmx_end_year = new JComboBox();
		xsmx_end_year.setMaximumRowCount(10);
		xsmx_end_year.addItem("2017");
		xsmx_end_year.addItem("2018");
		xsmx_end_year.setFont(font);
		xsmx_end_year.setLocation(120,60);
		xsmx_end_year.setSize(80,40);
		xsmx_end_year.setEditable(false);
		xsmx_end_year.setBackground(Color.white);
		xsmx_panel.add(xsmx_end_year);
		JLabel label_year1 = new JLabel("��");
		label_year1.setLocation(210,60);
		label_year1.setSize(50,50);
		label_year1.setFont(font);
		label_year1.setForeground(Color.black);
		xsmx_panel.add(label_year1);
		Object[] day = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17"
				,"18","19","20","21","22","23","24","25","26","27","28"};
		//��ʼ�·�
		xsmx_start_month = new JComboBox();
		xsmx_start_day = new JComboBox(day);
		xsmx_start_month.addItemListener(new boxItemListener());//��Ӽ����¼�
		xsmx_start_month.setMaximumRowCount(10);
		xsmx_start_month.addItem("01");
		xsmx_start_month.addItem("02");
		xsmx_start_month.addItem("03");
		xsmx_start_month.addItem("04");
		xsmx_start_month.addItem("05");
		xsmx_start_month.addItem("06");
		xsmx_start_month.addItem("07");
		xsmx_start_month.addItem("08");
		xsmx_start_month.addItem("09");
		xsmx_start_month.addItem("10");
		xsmx_start_month.addItem("11");
		xsmx_start_month.addItem("12");
		xsmx_start_month.setFont(font);
		xsmx_start_month.setLocation(250,10);
		xsmx_start_month.setSize(80,40);
		xsmx_start_month.setEditable(false);
		xsmx_start_month.setBackground(Color.white);
		xsmx_panel.add(xsmx_start_month);
		JLabel label_month = new JLabel("��");
		label_month.setLocation(340,10);
		label_month.setSize(50,40);
		label_month.setForeground(Color.black);
		label_month.setFont(font);
		xsmx_panel.add(label_month);
		//�����·�
		xsmx_end_month = new JComboBox();
		xsmx_end_day = new JComboBox(day);
		xsmx_end_month.addItemListener(new boxItemListener());//��Ӽ����¼�
		xsmx_end_month.setMaximumRowCount(10);
		xsmx_end_month.addItem("01");
		xsmx_end_month.addItem("02");
		xsmx_end_month.addItem("03");
		xsmx_end_month.addItem("04");
		xsmx_end_month.addItem("05");
		xsmx_end_month.addItem("06");
		xsmx_end_month.addItem("07");
		xsmx_end_month.addItem("08");
		xsmx_end_month.addItem("09");
		xsmx_end_month.addItem("10");
		xsmx_end_month.addItem("11");
		xsmx_end_month.addItem("12");
		xsmx_end_month.setFont(font);
		xsmx_end_month.setLocation(250,60);
		xsmx_end_month.setSize(80,40);
		xsmx_end_month.setEditable(false);
		xsmx_end_month.setBackground(Color.white);
		xsmx_panel.add(xsmx_end_month);
		JLabel label_month1 = new JLabel("��");
		label_month1.setLocation(340,60);
		label_month1.setSize(50,40);
		label_month1.setForeground(Color.black);
		label_month1.setFont(font);
		xsmx_panel.add(label_month1);
		//��ʼ����
		xsmx_start_day.setMaximumRowCount(10);
		xsmx_start_day.setLocation(375,10);
		xsmx_start_day.setSize(80,40);
		xsmx_start_day.setFont(font);
		xsmx_start_day.setEditable(false);
		xsmx_start_day.setBackground(Color.white);
		xsmx_panel.add(xsmx_start_day);
		JLabel label_day = new JLabel("��");
		label_day.setLocation(465,10);
		label_day.setSize(50,50);
		label_day.setForeground(Color.black);
		label_day.setFont(font);
		xsmx_panel.add(label_day);
		//��������
		xsmx_end_day.setMaximumRowCount(10);
		xsmx_end_day.setLocation(375,60);
		xsmx_end_day.setSize(80,40);
		xsmx_end_day.setFont(font);
		xsmx_end_day.setEditable(false);
		xsmx_end_day.setBackground(Color.white);
		xsmx_panel.add(xsmx_end_day);
		JLabel label_day1 = new JLabel("��");
		label_day1.setLocation(465,60);
		label_day1.setSize(50,50);
		label_day1.setForeground(Color.black);
		label_day1.setFont(font);
		xsmx_panel.add(label_day1);
		//��Ʒ��
		JLabel goods_box_label = new JLabel("��Ʒ��");
		goods_box_label.setLocation(20,120);
		goods_box_label.setSize(80,30);
		goods_box_label.setFont(font);
		goods_box_label.setForeground(Color.magenta);
		xsmx_panel.add(goods_box_label);
		goods_box = new JComboBox();
		goods_box.setMaximumRowCount(10);
		goods_box.setLocation(100,120);
		goods_box.setSize(150,40);
		goods_box.setFont(font);
		goods_box.setBackground(Color.white);
		xsmx_panel.add(goods_box);
		//�ͻ�
		JLabel customer_box_label = new JLabel("�ͻ�");
		customer_box_label.setLocation(270,120);
		customer_box_label.setSize(80,30);
		customer_box_label.setFont(font);
		customer_box_label.setForeground(Color.magenta);
		xsmx_panel.add(customer_box_label);
		customer_box = new JComboBox();
		customer_box.addItemListener(new boxItemListener());
		customer_box.setMaximumRowCount(10);
		customer_box.setLocation(330,120);
		customer_box.setSize(100,40);
		customer_box.setFont(font);
		customer_box.setBackground(Color.white);
		xsmx_panel.add(customer_box);
		//ҵ��Ա
		JLabel salesman_box_label = new JLabel("ҵ��Ա");
		salesman_box_label.setLocation(20,170);
		salesman_box_label.setSize(80,30);
		salesman_box_label.setFont(font);
		salesman_box_label.setForeground(Color.magenta);
		xsmx_panel.add(salesman_box_label);
		salesman_box = new JTextField();
		salesman_box.setLocation(100,170);
		salesman_box.setSize(150,40);
		salesman_box.setFont(font);
		salesman_box.setBackground(Color.white);
		xsmx_panel.add(salesman_box);
		//�ֿ�
		JLabel stock_box_label = new JLabel("�ֿ�");
		stock_box_label.setLocation(270,170);
		stock_box_label.setSize(80,30);
		stock_box_label.setFont(font);
		stock_box_label.setForeground(Color.magenta);
		xsmx_panel.add(stock_box_label);
		stock_box = new JComboBox();
		stock_box.setMaximumRowCount(10);
		stock_box.setLocation(330,170);
		stock_box.setSize(100,40);
		stock_box.setFont(font);
		stock_box.setBackground(Color.white);
		stock_box.addItem("");
		stock_box.addItem("1");
		stock_box.addItem("2");
		stock_box.addItem("3");
		xsmx_panel.add(stock_box);
		/*
		 * ������ϸ��
		 */
		Object[][] xsmx_data = {{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""}
		,{"","","","","",""},{"","","","","",""},{"","","","","",""}};
		String[] columnName = {"ʱ��","��Ʒ��","�ͺ�","����","����","�ܶ�"};
		DefaultTableModel model=new DefaultTableModel(xsmx_data,columnName);
		xsmx_table = new JTable(model){
			public boolean isCellEditable(int row, int column) { return false; }
		};
		xsmx_table.getColumnModel().getColumn(0).setPreferredWidth(150);
		xsmx_table.getColumnModel().getColumn(1).setPreferredWidth(100);
		xsmx_table.getTableHeader().setReorderingAllowed(false);
		xsmx_table.setBackground(Color.cyan);
		xsmx_table.getTableHeader().setFont(font);
		xsmx_table.getTableHeader().setForeground(Color.red);
		xsmx_table.setRowHeight(33);
		xsmx_table.setFont(font);
		JScrollPane xsmx_scrollPane = new JScrollPane(xsmx_table);
		xsmx_scrollPane.setSize(490,250);
		xsmx_scrollPane.setLocation(0,230);
		xsmx_scrollPane.getViewport().setBackground(Color.cyan);
		//xsmx_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		xsmx_panel.add(xsmx_scrollPane);
		/*
		 * button�ؼ�
		 */
		//ȡ��
		xsmx_cancel = new JButton("ȡ��");
		xsmx_cancel.setLocation(60,490);
		xsmx_cancel.setSize(80,50);
		xsmx_cancel.setFont(font);
	    xsmx_cancel.setForeground(Color.magenta);
	    xsmx_cancel.setFocusPainted(false);
	    xsmx_panel.add(xsmx_cancel);
		//ȷ��
		xsmx_confirm = new JButton("ȷ��");
		xsmx_confirm.addActionListener(new ButtonActionListener());
	    xsmx_confirm.setLocation(350,490);
	    xsmx_confirm.setSize(80,50);
	    xsmx_confirm.setFont(font);
	    xsmx_confirm.setForeground(Color.magenta);
	    xsmx_confirm.setFocusPainted(false);
	    xsmx_panel.add(xsmx_confirm);
	    xsmx_panel.setVisible(false);
	    frame.getContentPane().add(xsmx_panel);
	    
	    /*
	     * �ƶ����۲��Խ���
	     */
	    mp_panel = new JPanel();
	    mp_panel.setLayout(null);
	    mp_panel.setLocation(260,50);
	    mp_panel.setSize(460,550);
	    mp_panel.setBackground(Color.cyan);
	    mp_panel.setOpaque(true);
	    //��������
	    JLabel pc_label = new JLabel("��������");
	    pc_label.setLocation(80,10);
	    pc_label.setSize(200,50);
	    pc_label.setFont(font1);
	    pc_label.setForeground(Color.red);
	    mp_panel.add(pc_label);
	    promotion_classification = new JComboBox();
	    level_promotion = new JPanel();
	    goods_promotion = new JPanel();
	    money_promotion = new JPanel();
	    goods_mytable = new Mytable2();
	    level_grant_table=new Mytable1();
	    money_grant_table=new Mytable1();
	    promotion_classification.addItemListener(new boxItemListener());
	    promotion_classification.addItem("�������");
	    promotion_classification.addItem("�����Ʒ����");
	    promotion_classification.addItem("�ܼ۴���");
	    promotion_classification.setLocation(200,10);
	    promotion_classification.setSize(170,50);
	    promotion_classification.setFont(font);
	    promotion_classification.setBackground(Color.white);
	    mp_panel.add(promotion_classification);
	    /*
	     * ����ʱ��
	     */
	    JLabel mp_start = new JLabel("��ʼ����");
	    mp_start.setLocation(0,70);
	    mp_start.setSize(100,40);
	    mp_start.setFont(font);
	    mp_start.setForeground(Color.magenta);
		mp_panel.add(mp_start);
		JLabel mp_end = new JLabel("��������");
		mp_end.setLocation(0,120);
		mp_end.setSize(100,40);
		mp_end.setFont(font);
		mp_end.setForeground(Color.magenta);
		mp_panel.add(mp_end);
		//��ʼ���
		mp_start_year = new JComboBox();
		mp_start_year.setMaximumRowCount(10);
		mp_start_year.addItem("2017");
		mp_start_year.addItem("2018");
		mp_start_year.setFont(font);
		mp_start_year.setLocation(100,70);
		mp_start_year.setSize(80,40);
		mp_start_year.setEditable(false);
		mp_start_year.setBackground(Color.white);
		mp_panel.add(mp_start_year);
		JLabel mp_label_year = new JLabel("��");
		mp_label_year.setLocation(190,70);
		mp_label_year.setSize(50,40);
		mp_label_year.setFont(font);
		mp_label_year.setForeground(Color.black);
		mp_panel.add(mp_label_year);
		//�������
		mp_end_year = new JComboBox();
	    mp_end_year.setMaximumRowCount(10);
		mp_end_year.addItem("2017");
		mp_end_year.addItem("2018");
		mp_end_year.setFont(font);
		mp_end_year.setLocation(100,120);
		mp_end_year.setSize(80,40);
		mp_end_year.setEditable(false);
		mp_end_year.setBackground(Color.white);
		mp_panel.add(mp_end_year);
		JLabel mp_label_year1 = new JLabel("��");
		mp_label_year1.setLocation(190,120);
		mp_label_year1.setSize(50,50);
		mp_label_year1.setFont(font);
		mp_label_year1.setForeground(Color.black);
		mp_panel.add(mp_label_year1);
		//��ʼ�·�
		mp_start_month = new JComboBox();
		mp_start_day = new JComboBox(day);
		mp_start_month.addItemListener(new boxItemListener());//��Ӽ����¼�
		mp_start_month.setMaximumRowCount(10);
		mp_start_month.addItem("01");
		mp_start_month.addItem("02");
		mp_start_month.addItem("03");
		mp_start_month.addItem("04");
		mp_start_month.addItem("05");
		mp_start_month.addItem("06");
		mp_start_month.addItem("07");
		mp_start_month.addItem("08");
		mp_start_month.addItem("09");
		mp_start_month.addItem("10");
		mp_start_month.addItem("11");
		mp_start_month.addItem("12");
		mp_start_month.setFont(font);
		mp_start_month.setLocation(220,70);
		mp_start_month.setSize(80,40);
		mp_start_month.setEditable(false);
	    mp_start_month.setBackground(Color.white);
		mp_panel.add(mp_start_month);
		JLabel mp_label_month = new JLabel("��");
		mp_label_month.setLocation(310,70);
		mp_label_month.setSize(50,40);
		mp_label_month.setForeground(Color.black);
		mp_label_month.setFont(font);
		mp_panel.add(mp_label_month);
		//�����·�
		mp_end_month = new JComboBox();
		mp_end_day = new JComboBox(day);
		mp_end_month.addItemListener(new boxItemListener());//��Ӽ����¼�
		mp_end_month.setMaximumRowCount(10);
		mp_end_month.addItem("01");
		mp_end_month.addItem("02");
		mp_end_month.addItem("03");
		mp_end_month.addItem("04");
		mp_end_month.addItem("05");
		mp_end_month.addItem("06");
		mp_end_month.addItem("07");
		mp_end_month.addItem("08");
		mp_end_month.addItem("09");
		mp_end_month.addItem("10");
		mp_end_month.addItem("11");
		mp_end_month.addItem("12");
		mp_end_month.setFont(font);
		mp_end_month.setLocation(220,120);
		mp_end_month.setSize(80,40);
		mp_end_month.setEditable(false);
	    mp_end_month.setBackground(Color.white);
		mp_panel.add(mp_end_month);
		JLabel mp_label_month1 = new JLabel("��");
		mp_label_month1.setLocation(310,120);
		mp_label_month1.setSize(50,40);
		mp_label_month1.setForeground(Color.black);
		mp_label_month1.setFont(font);
		mp_panel.add(mp_label_month1);
		//��ʼ����
		mp_start_day.setMaximumRowCount(10);
		mp_start_day.setLocation(345,70);
		mp_start_day.setSize(80,40);
		mp_start_day.setFont(font);
		mp_start_day.setEditable(false);
		mp_start_day.setBackground(Color.white);
		mp_panel.add(mp_start_day);
		JLabel mp_label_day = new JLabel("��");
		mp_label_day.setLocation(435,70);
		mp_label_day.setSize(50,50);
		mp_label_day.setForeground(Color.black);
		mp_label_day.setFont(font);
		mp_panel.add(mp_label_day);
		//��������
		mp_end_day.setMaximumRowCount(10);
		mp_end_day.setLocation(345,120);
		mp_end_day.setSize(80,40);
		mp_end_day.setFont(font);
		mp_end_day.setEditable(false);
		mp_end_day.setBackground(Color.white);
		mp_panel.add(mp_end_day);
		JLabel mp_label_day1 = new JLabel("��");
		mp_label_day1.setLocation(435,120);
		mp_label_day1.setSize(50,50);
		mp_label_day1.setForeground(Color.black);
		mp_label_day1.setFont(font);
		mp_panel.add(mp_label_day1);
	    /*
	     * �����������
	     */
	    level_promotion.setLocation(0,170);
	    level_promotion.setSize(460,380);
	    level_promotion.setLayout(null);
	    level_promotion.setBackground(Color.cyan);
	    //����
	    JLabel level_label = new JLabel("����");
	    level_label.setLocation(10,0);
	    level_label.setSize(100,50);
	    level_label.setFont(font);
	    level_promotion.add(level_label);
	    level_box = new JComboBox();
	    level_box.addItem("һ��");
	    level_box.addItem("����");
	    level_box.addItem("����");
	    level_box.addItem("�ļ�");
	    level_box.addItem("�弶");
	    level_box.setLocation(60,5);
	    level_box.setSize(80,40);
	    level_box.setFont(font);
	    level_box.setBackground(Color.white);
	    level_promotion.add(level_box);
	    //����
	    JLabel discount_label = new JLabel("����");
	  	discount_label.setLocation(150,0);
	  	discount_label.setSize(80,50);
	  	discount_label.setFont(font);
	  	level_promotion.add(discount_label);
	  	discount = new JTextField();
	  	discount.setLocation(200,5);
	  	discount.setSize(80,40);
	  	discount.setFont(font);
	  	discount.setBackground(Color.white);
	  	level_promotion.add(discount);
	  	//����ȯ
	  	JLabel voucher_label = new JLabel("����ȯ");
	  	voucher_label.setLocation(290,0);
	  	voucher_label.setSize(80,50);
	  	voucher_label.setFont(font);
	  	level_promotion.add(voucher_label);
	  	voucher = new JTextField();
	  	voucher.setLocation(360,5);
	  	voucher.setSize(80,40);
	  	voucher.setFont(font);
	  	voucher.setBackground(Color.white);
	  	level_promotion.add(voucher);
	    /*
	     * ��Ʒѡ���
	     */
	    level_table = new JTable(level_grant_table);
	    level_table.getColumnModel().getColumn(3).setPreferredWidth(100);
	    level_table.getColumnModel().getColumn(4).setPreferredWidth(100);
	    level_table.setFont(font);
	    level_table.setBackground(Color.cyan);
	    level_table.getTableHeader().setFont(font);
	    level_table.getTableHeader().setForeground(Color.red);
	    level_table.setRowHeight(33);
	    JScrollPane levelTable_scrollPane = new JScrollPane(level_table);
	    levelTable_scrollPane.setSize(460,260);
	    levelTable_scrollPane.setLocation(0,60);
		level_promotion.add(levelTable_scrollPane);
		/*
		 * button�ؼ�
		 */
		//ȷ��
		level_confirm = new JButton("ȷ��");
		level_confirm.addActionListener(new ButtonActionListener());
		level_confirm.setLocation(330,325);
		level_confirm.setSize(80,50);
		level_confirm.setFont(font);
		level_confirm.setForeground(Color.magenta);
		level_confirm.setFocusPainted(false);
		level_promotion.add(level_confirm);
		//ȡ��
		level_cancel = new JButton("ȡ��");
		level_cancel.setLocation(50,325);
		level_cancel.setSize(80,50);
		level_cancel.setFont(font);
		level_cancel.setForeground(Color.magenta);
		level_cancel.setFocusPainted(false);
		level_promotion.add(level_cancel);
	    level_promotion.setVisible(true);
	    mp_panel.add(level_promotion);
	    /*
	     * ��Ʒ��ϴ�������
	     */
	    goods_promotion.setLocation(0,170);
	    goods_promotion.setSize(460,380);
	    goods_promotion.setLayout(null);
	    goods_promotion.setBackground(Color.cyan);
	    //��Ʒѡ���б�
	    goods_table = new JTable(goods_mytable);
	    goods_table.addMouseListener(new MouseActionListener());
	    goods_table.getColumnModel().getColumn(3).setPreferredWidth(100);
	    goods_table.getColumnModel().getColumn(4).setPreferredWidth(100);
	    goods_table.setFont(font);
	    goods_table.setBackground(Color.cyan);
	    goods_table.getTableHeader().setFont(font);
	    goods_table.getTableHeader().setForeground(Color.red);
	    goods_table.setRowHeight(33);
	    JScrollPane goodsTable_scrollPane = new JScrollPane(goods_table);
	    goodsTable_scrollPane.setSize(460,260);
	    goodsTable_scrollPane.setLocation(0,10);
		goods_promotion.add(goodsTable_scrollPane);
		//�ܼۡ�����ؼ�
		JLabel addUp_label = new JLabel("�ܼ�");
		addUp_label.setLocation(20,280);
		addUp_label.setSize(80,30);
		addUp_label.setFont(font);
		addUp_label.setForeground(Color.black);
		goods_promotion.add(addUp_label);
		addUp = new JTextField("0.0");
		addUp.setLocation(70,280);
		addUp.setSize(100,35);
		addUp.setFont(font);
		goods_promotion.add(addUp);
		JLabel bargain_label = new JLabel("����ؼ�");
		bargain_label.setLocation(220,280);
		bargain_label.setSize(150,30);
		bargain_label.setFont(font);
		bargain_label.setForeground(Color.red);
		goods_promotion.add(bargain_label);
		bargain = new JTextField();
		bargain.setLocation(320,280);
		bargain.setSize(100,35);
		bargain.setFont(font);
		bargain.setForeground(Color.red);
		goods_promotion.add(bargain);
		//ȷ�ϡ�ȡ��
		goods_confirm = new JButton("ȷ��");
		goods_confirm.addActionListener(new ButtonActionListener());
		goods_confirm.setLocation(330,325);
		goods_confirm.setSize(80,50);
		goods_confirm.setFont(font);
		goods_confirm.setForeground(Color.magenta);
		goods_confirm.setFocusPainted(false);
		goods_promotion.add(goods_confirm);
		goods_cancel = new JButton("ȡ��");
		goods_cancel.setLocation(50,325);
		goods_cancel.setSize(80,50);
		goods_cancel.setFont(font);
		goods_cancel.setForeground(Color.magenta);
		goods_cancel.setFocusPainted(false);
		goods_promotion.add(goods_cancel);
	    goods_promotion.setVisible(false);
	    mp_panel.add(goods_promotion);
	    /*
	     * �ܼ۴�������
	     */
	    money_promotion.setLocation(0,170);
	    money_promotion.setSize(460,380);
	    money_promotion.setLayout(null);
	    money_promotion.setBackground(Color.cyan);
	    //��Ʒ��
	    money_table = new JTable(money_grant_table);
	    money_table.getColumnModel().getColumn(3).setPreferredWidth(100);
	    money_table.getColumnModel().getColumn(4).setPreferredWidth(100);
	    money_table.setFont(font);
	    money_table.setBackground(Color.cyan);
	    money_table.getTableHeader().setFont(font);
	    money_table.getTableHeader().setForeground(Color.red);
	    money_table.setRowHeight(33);
	    JScrollPane moneyTable_scrollPane = new JScrollPane(money_table);
	    moneyTable_scrollPane.setSize(460,260);
	    moneyTable_scrollPane.setLocation(0,60);
		money_promotion.add(moneyTable_scrollPane);
		//�ܼ۶�ȡ�����ȯ
		JLabel all_label = new JLabel("��Ͷ��");
	  	all_label.setLocation(20,0);
	  	all_label.setSize(150,50);
	  	all_label.setFont(font);
	  	money_promotion.add(all_label);
	  	money = new JTextField();
	  	money.setLocation(110,5);
	  	money.setSize(100,40);
	  	money.setFont(font);
	  	money.setBackground(Color.white);
	  	money_promotion.add(money);
	  	//����ȯ
	  	JLabel voucher1_label = new JLabel("����ȯ");
	  	voucher1_label.setLocation(250,0);
	  	voucher1_label.setSize(80,50);
	  	voucher1_label.setFont(font);
	  	money_promotion.add(voucher1_label);
	  	voucher1 = new JTextField();
	  	voucher1.setLocation(320,5);
	  	voucher1.setSize(100,40);
	  	voucher1.setFont(font);
	  	voucher1.setBackground(Color.white);
	  	money_promotion.add(voucher1);
	    //ȷ�ϡ�ȡ��
	  	money_confirm = new JButton("ȷ��");
	  	money_confirm.addActionListener(new ButtonActionListener());
	  	money_confirm.setLocation(330,325);
	  	money_confirm.setSize(80,50);
	  	money_confirm.setFont(font);
	  	money_confirm.setForeground(Color.magenta);
	  	money_confirm.setFocusPainted(false);
	  	money_promotion.add(money_confirm);
	  	money_cancel = new JButton("ȡ��");
	  	money_cancel.setLocation(50,325);
	  	money_cancel.setSize(80,50);
	  	money_cancel.setFont(font);
	  	money_cancel.setForeground(Color.magenta);
	  	money_cancel.setFocusPainted(false);
	  	money_promotion.add(money_cancel);
	  	money_promotion.setVisible(false);
	  	mp_panel.add(money_promotion);
	    mp_panel.setVisible(false);
	    frame.getContentPane().add(mp_panel);
	    
	    /*
	     * �鿴��Ӫ���̱����
	     */
	    jylc_panel = new JPanel();
	    jylc_panel.setLayout(null);
	    jylc_panel.setLocation(260,20);
	    jylc_panel.setSize(490,610);
	    jylc_panel.setLayout(null);
	    jylc_panel.setBackground(Color.cyan);
	    jylc_panel.setOpaque(true);
	    /*
	     * ��ѯ����
	     */
	    //��ֹ����
	    JLabel jylc_start = new JLabel("��ʼ����");
	    jylc_start.setLocation(0,20);
	    jylc_start.setSize(100,40);
	    jylc_start.setFont(font);
	    jylc_start.setForeground(Color.magenta);
	    jylc_panel.add(jylc_start);
		JLabel jylc_end = new JLabel("��������");
		jylc_end.setLocation(0,70);
		jylc_end.setSize(100,40);
		jylc_end.setFont(font);
		jylc_end.setForeground(Color.magenta);
		jylc_panel.add(jylc_end);
		//��ʼ���
		jylc_start_year = new JComboBox();
		jylc_start_year.setMaximumRowCount(10);
		jylc_start_year.addItem("2017");
		jylc_start_year.addItem("2018");
		jylc_start_year.setFont(font);
		jylc_start_year.setLocation(100,20);
		jylc_start_year.setSize(80,40);
		jylc_start_year.setEditable(false);
		jylc_start_year.setBackground(Color.white);
		jylc_panel.add(jylc_start_year);
		JLabel jylc_label_year = new JLabel("��");
		jylc_label_year.setLocation(190,20);
		jylc_label_year.setSize(50,40);
		jylc_label_year.setFont(font);
		jylc_label_year.setForeground(Color.black);
		jylc_panel.add(jylc_label_year);
		//�������
		jylc_end_year = new JComboBox();
		jylc_end_year.setMaximumRowCount(10);
		jylc_end_year.addItem("2017");
		jylc_end_year.addItem("2018");
		jylc_end_year.setFont(font);
		jylc_end_year.setLocation(100,70);
		jylc_end_year.setSize(80,40);
		jylc_end_year.setEditable(false);
		jylc_end_year.setBackground(Color.white);
		jylc_panel.add(jylc_end_year);
		JLabel jylc_label_year1 = new JLabel("��");
		jylc_label_year1.setLocation(190,70);
		jylc_label_year1.setSize(50,50);
		jylc_label_year1.setFont(font);
		jylc_label_year1.setForeground(Color.black);
		jylc_panel.add(jylc_label_year1);
		//��ʼ�·�
		jylc_start_month = new JComboBox();
		jylc_start_day = new JComboBox(day);
		jylc_start_month.addItemListener(new boxItemListener());//��Ӽ����¼�
		jylc_start_month.setMaximumRowCount(10);
		jylc_start_month.addItem("01");
		jylc_start_month.addItem("02");
		jylc_start_month.addItem("03");
		jylc_start_month.addItem("04");
		jylc_start_month.addItem("05");
		jylc_start_month.addItem("06");
		jylc_start_month.addItem("07");
		jylc_start_month.addItem("08");
		jylc_start_month.addItem("09");
		jylc_start_month.addItem("10");
		jylc_start_month.addItem("11");
		jylc_start_month.addItem("12");
		jylc_start_month.setFont(font);
		jylc_start_month.setLocation(220,20);
		jylc_start_month.setSize(80,40);
		jylc_start_month.setEditable(false);
		jylc_start_month.setBackground(Color.white);
		jylc_panel.add(jylc_start_month);
		JLabel jylc_label_month = new JLabel("��");
		jylc_label_month.setLocation(310,20);
		jylc_label_month.setSize(50,40);
		jylc_label_month.setForeground(Color.black);
		jylc_label_month.setFont(font);
		jylc_panel.add(jylc_label_month);
		//�����·�
		jylc_end_month = new JComboBox();
		jylc_end_day = new JComboBox(day);
		jylc_end_month.addItemListener(new boxItemListener());//��Ӽ����¼�
		jylc_end_month.setMaximumRowCount(10);
		jylc_end_month.addItem("01");
		jylc_end_month.addItem("02");
		jylc_end_month.addItem("03");
		jylc_end_month.addItem("04");
		jylc_end_month.addItem("05");
		jylc_end_month.addItem("06");
		jylc_end_month.addItem("07");
		jylc_end_month.addItem("08");
		jylc_end_month.addItem("09");
		jylc_end_month.addItem("10");
		jylc_end_month.addItem("11");
		jylc_end_month.addItem("12");
		jylc_end_month.setFont(font);
		jylc_end_month.setLocation(220,70);
		jylc_end_month.setSize(80,40);
		jylc_end_month.setEditable(false);
		jylc_end_month.setBackground(Color.white);
		jylc_panel.add(jylc_end_month);
		JLabel jylc_label_month1 = new JLabel("��");
		jylc_label_month1.setLocation(310,70);
		jylc_label_month1.setSize(50,40);
		jylc_label_month1.setForeground(Color.black);
		jylc_label_month1.setFont(font);
		jylc_panel.add(jylc_label_month1);
		//��ʼ����
		jylc_start_day.setMaximumRowCount(10);
		jylc_start_day.setLocation(345,20);
		jylc_start_day.setSize(80,40);
		jylc_start_day.setFont(font);
		jylc_start_day.setEditable(false);
		jylc_start_day.setBackground(Color.white);
		jylc_panel.add(jylc_start_day);
		JLabel jylc_label_day = new JLabel("��");
		jylc_label_day.setLocation(435,20);
		jylc_label_day.setSize(50,50);
		jylc_label_day.setForeground(Color.black);
		jylc_label_day.setFont(font);
		jylc_panel.add(jylc_label_day);
		//��������
		jylc_end_day.setMaximumRowCount(10);
		jylc_end_day.setLocation(345,70);
		jylc_end_day.setSize(80,40);
		jylc_end_day.setFont(font);
		jylc_end_day.setEditable(false);
		jylc_end_day.setBackground(Color.white);
		jylc_panel.add(jylc_end_day);
		JLabel jylc_label_day1 = new JLabel("��");
		jylc_label_day1.setLocation(435,70);
		jylc_label_day1.setSize(50,50);
		jylc_label_day1.setForeground(Color.black);
		jylc_label_day1.setFont(font);
		jylc_panel.add(jylc_label_day1);
		//��������
		JLabel oc_label1 = new JLabel("��������");
		oc_label1.setLocation(10,125);
		oc_label1.setSize(120,30);
		oc_label1.setFont(font);
		jylc_panel.add(oc_label1);
		oc = new JComboBox();
		oc.setLocation(110,120);
		oc.setSize(150,40);
		oc.setFont(font);
		oc.addItem("�����൥��");
		oc.addItem("�����൥��");
		oc.addItem("�����൥��");
		oc.addItem("����൥��");
		oc.setEditable(false);
		oc.setBackground(Color.white);
		jylc_panel.add(oc);
		//�ͻ�
		JLabel jc_label = new JLabel("�ͻ�");
		jc_label.setLocation(300,125);
		jc_label.setSize(80,30);
		jc_label.setFont(font);
		jylc_panel.add(jc_label);
		jylc_customer = new JComboBox();
		jylc_customer.addItemListener(new boxItemListener());
		jylc_customer.setLocation(350,120);
		jylc_customer.setSize(100,40);
		jylc_customer.setFont(font);
		jylc_customer.setEditable(false);
		jylc_customer.setBackground(Color.white);
		jylc_panel.add(jylc_customer);
		//ҵ��Ա
		JLabel js_label = new JLabel("ҵ��Ա");
		js_label.setLocation(10,175);
		js_label.setSize(80,30);
		js_label.setFont(font);
		jylc_panel.add(js_label);
		jylc_salesman = new JTextField();
		jylc_salesman.setLocation(80,170);
		jylc_salesman.setSize(150,40);
		jylc_salesman.setFont(font);
		jylc_salesman.setEditable(false);
		jylc_salesman.setBackground(Color.white);
		jylc_panel.add(jylc_salesman);
		//�ֿ�
		JLabel jst_label = new JLabel("�ֿ�");
		jst_label.setLocation(300,175);
		jst_label.setSize(80,30);
		jst_label.setFont(font);
		jylc_panel.add(jst_label);
		jylc_stock = new JComboBox();
		jylc_stock.setLocation(350,170);
		jylc_stock.setSize(100,40);
		jylc_stock.setFont(font);
		jylc_stock.setEditable(false);
		jylc_stock.setBackground(Color.white);
		jylc_stock.addItem("");
		jylc_stock.addItem("1");
		jylc_stock.addItem("2");
		jylc_stock.addItem("3");
		jylc_panel.add(jylc_stock);
		//�����б�
		jylc_mytable = new Mytable();
		jylcOrder_table = new JTable(jylc_mytable);
		jylcOrder_table.addMouseListener(new MouseActionListener());
		jylcOrder_table.setFont(font);
		jylcOrder_table.setBackground(Color.cyan);
		jylcOrder_table.getTableHeader().setFont(font);
		jylcOrder_table.getTableHeader().setForeground(Color.red);
		jylcOrder_table.setRowHeight(33);
		JScrollPane jo_scrollPane = new JScrollPane(jylcOrder_table);
		jo_scrollPane.setSize(490,300);
		jo_scrollPane.setLocation(0,230);
		jo_scrollPane.getViewport().setBackground(Color.cyan);
	    jylc_panel.add(jo_scrollPane);
	    //ȷ�ϡ�ȡ��
	    jylc_confirm = new JButton("ȷ��");
	    jylc_confirm.addActionListener(new ButtonActionListener());
	    jylc_confirm.setLocation(340,545);
	    jylc_confirm.setSize(100,50);
	    jylc_confirm.setFont(font);
	    jylc_confirm.setForeground(Color.magenta);
	    jylc_confirm.setFocusPainted(false);
	    jylc_panel.add(jylc_confirm);
	    jylc_cancel = new JButton("ȡ��");
	    jylc_cancel.setLocation(50,545);
	    jylc_cancel.setSize(100,50);
	    jylc_cancel.setFont(font);
	    jylc_cancel.setForeground(Color.magenta);
	    jylc_cancel.setFocusPainted(false);
	    jylc_panel.add(jylc_cancel);
		jylc_panel.setVisible(false);
		frame.getContentPane().add(jylc_panel);
		
		/*
		 * �鿴��Ӫ��������
		 */
		jyqk_panel = new JPanel();
		jyqk_panel.setLayout(null);
	    jyqk_panel.setLocation(260,20);
	    jyqk_panel.setSize(490,610);
	    jyqk_panel.setLayout(null);
	    jyqk_panel.setBackground(Color.cyan);
	    jyqk_panel.setOpaque(true);
	    /*
	     * ��ѯ����
	     */
	    //��ֹ����
	    JLabel jyqk_start = new JLabel("��ʼ����");
	    jyqk_start.setLocation(0,20);
	    jyqk_start.setSize(100,40);
	    jyqk_start.setFont(font);
	    jyqk_start.setForeground(Color.magenta);
	    jyqk_panel.add(jyqk_start);
		JLabel jyqk_end = new JLabel("��������");
		jyqk_end.setLocation(0,70);
		jyqk_end.setSize(100,40);
		jyqk_end.setFont(font);
		jyqk_end.setForeground(Color.magenta);
		jyqk_panel.add(jyqk_end);
		//��ʼ���
		jyqk_start_year = new JComboBox();
		jyqk_start_year.setMaximumRowCount(10);
		jyqk_start_year.addItem("2017");
		jyqk_start_year.addItem("2018");
		jyqk_start_year.setFont(font);
		jyqk_start_year.setLocation(100,20);
		jyqk_start_year.setSize(80,40);
		jyqk_start_year.setEditable(false);
		jyqk_start_year.setBackground(Color.white);
		jyqk_panel.add(jyqk_start_year);
		JLabel jyqk_label_year = new JLabel("��");
		jyqk_label_year.setLocation(190,20);
		jyqk_label_year.setSize(50,40);
		jyqk_label_year.setFont(font);
		jyqk_label_year.setForeground(Color.black);
		jyqk_panel.add(jyqk_label_year);
		//�������
		jyqk_end_year = new JComboBox();
		jyqk_end_year.setMaximumRowCount(10);
		jyqk_end_year.addItem("2017");
		jyqk_end_year.addItem("2018");
		jyqk_end_year.setFont(font);
		jyqk_end_year.setLocation(100,70);
		jyqk_end_year.setSize(80,40);
		jyqk_end_year.setEditable(false);
		jyqk_end_year.setBackground(Color.white);
		jyqk_panel.add(jyqk_end_year);
		JLabel jyqk_label_year1 = new JLabel("��");
		jyqk_label_year1.setLocation(190,65);
		jyqk_label_year1.setSize(50,50);
		jyqk_label_year1.setFont(font);
		jyqk_label_year1.setForeground(Color.black);
		jyqk_panel.add(jyqk_label_year1);
		//��ʼ�·�
		jyqk_start_month = new JComboBox();
		jyqk_start_day = new JComboBox(day);
		jyqk_start_month.addItemListener(new boxItemListener());//��Ӽ����¼�
		jyqk_start_month.setMaximumRowCount(10);
		jyqk_start_month.addItem("01");
		jyqk_start_month.addItem("02");
		jyqk_start_month.addItem("03");
		jyqk_start_month.addItem("04");
		jyqk_start_month.addItem("05");
		jyqk_start_month.addItem("06");
		jyqk_start_month.addItem("07");
		jyqk_start_month.addItem("08");
		jyqk_start_month.addItem("09");
		jyqk_start_month.addItem("10");
		jyqk_start_month.addItem("11");
		jyqk_start_month.addItem("12");
		jyqk_start_month.setFont(font);
		jyqk_start_month.setLocation(220,20);
		jyqk_start_month.setSize(80,40);
		jyqk_start_month.setEditable(false);
		jyqk_start_month.setBackground(Color.white);
		jyqk_panel.add(jyqk_start_month);
		JLabel jyqk_label_month = new JLabel("��");
		jyqk_label_month.setLocation(310,20);
		jyqk_label_month.setSize(50,40);
		jyqk_label_month.setForeground(Color.black);
		jyqk_label_month.setFont(font);
		jyqk_panel.add(jyqk_label_month);
		//�����·�
		jyqk_end_month = new JComboBox();
		jyqk_end_day = new JComboBox(day);
		jyqk_end_month.addItemListener(new boxItemListener());//��Ӽ����¼�
		jyqk_end_month.setMaximumRowCount(10);
		jyqk_end_month.addItem("01");
		jyqk_end_month.addItem("02");
		jyqk_end_month.addItem("03");
		jyqk_end_month.addItem("04");
		jyqk_end_month.addItem("05");
		jyqk_end_month.addItem("06");
		jyqk_end_month.addItem("07");
		jyqk_end_month.addItem("08");
		jyqk_end_month.addItem("09");
		jyqk_end_month.addItem("10");
		jyqk_end_month.addItem("11");
		jyqk_end_month.addItem("12");
		jyqk_end_month.setFont(font);
		jyqk_end_month.setLocation(220,70);
		jyqk_end_month.setSize(80,40);
		jyqk_end_month.setEditable(false);
		jyqk_end_month.setBackground(Color.white);
		jyqk_panel.add(jyqk_end_month);
		JLabel jyqk_label_month1 = new JLabel("��");
		jyqk_label_month1.setLocation(310,70);
		jyqk_label_month1.setSize(50,40);
		jyqk_label_month1.setForeground(Color.black);
		jyqk_label_month1.setFont(font);
		jyqk_panel.add(jyqk_label_month1);
		//��ʼ����
		jyqk_start_day.setMaximumRowCount(10);
		jyqk_start_day.setLocation(345,20);
		jyqk_start_day.setSize(80,40);
		jyqk_start_day.setFont(font);
		jyqk_start_day.setEditable(false);
		jyqk_start_day.setBackground(Color.white);
		jyqk_panel.add(jyqk_start_day);
		JLabel jyqk_label_day = new JLabel("��");
		jyqk_label_day.setLocation(435,15);
		jyqk_label_day.setSize(50,50);
		jyqk_label_day.setForeground(Color.black);
		jyqk_label_day.setFont(font);
		jyqk_panel.add(jyqk_label_day);
		//��������
		jyqk_end_day.setMaximumRowCount(10);
		jyqk_end_day.setLocation(345,70);
		jyqk_end_day.setSize(80,40);
		jyqk_end_day.setFont(font);
		jyqk_end_day.setEditable(false);
		jyqk_end_day.setBackground(Color.white);
		jyqk_panel.add(jyqk_end_day);
		JLabel jyqk_label_day1 = new JLabel("��");
		jyqk_label_day1.setLocation(435,65);
		jyqk_label_day1.setSize(50,50);
		jyqk_label_day1.setForeground(Color.black);
		jyqk_label_day1.setFont(font);
		jyqk_panel.add(jyqk_label_day1);
		/*
		 * ��Ϣ��ʾ
		 */
		//������
		JLabel income_label = new JLabel("������:");
		income_label.setLocation(20,135);
		income_label.setSize(150,30);
		income_label.setFont(font1);
		income_label.setForeground(Color.red);
		jyqk_panel.add(income_label);
		//��������
		JLabel saleIC_label = new JLabel("��������");
		saleIC_label.setLocation(130,135);
		saleIC_label.setSize(150,30);
		saleIC_label.setFont(font1);
		jyqk_panel.add(saleIC_label);
		sale_income = new JTextField();
		sale_income.setLocation(250,130);
		sale_income.setSize(150,40);
		sale_income.setEditable(false);
		sale_income.setFont(font);
		sale_income.setForeground(Color.red);
		sale_income.setBackground(Color.white);
		jyqk_panel.add(sale_income);
		//��Ʒ������
		JLabel goodsIC_label = new JLabel("��Ʒ����");
		goodsIC_label.setLocation(130,190);
		goodsIC_label.setSize(150,30);
		goodsIC_label.setFont(font1);
		jyqk_panel.add(goodsIC_label);
		goods_income = new JTextField();
		goods_income.setLocation(250,185);
		goods_income.setSize(150,40);
		goods_income.setEditable(false);
		goods_income.setFont(font);
		goods_income.setForeground(Color.red);
		goods_income.setBackground(Color.white);
		jyqk_panel.add(goods_income);
		//����
		JLabel discount_label1 = new JLabel("����");
		discount_label1.setLocation(150,245);
		discount_label1.setSize(150,30);
		discount_label1.setFont(font1);
		jyqk_panel.add(discount_label1);
		discount_income = new JTextField();
		discount_income.setLocation(250,240);
		discount_income.setSize(150,40);
		discount_income.setEditable(false);
		discount_income.setFont(font);
		discount_income.setForeground(Color.red);
		discount_income.setBackground(Color.white);
		jyqk_panel.add(discount_income);
		//֧����
		JLabel outcome_label = new JLabel("֧����:");
		outcome_label.setLocation(20,300);
		outcome_label.setSize(150,30);
		outcome_label.setFont(font1);
		outcome_label.setForeground(Color.red);
		jyqk_panel.add(outcome_label);
		//����֧��
		JLabel saleOC_label = new JLabel("����֧��");
		saleOC_label.setLocation(130,300);
		saleOC_label.setSize(150,30);
		saleOC_label.setFont(font1);
		jyqk_panel.add(saleOC_label);
		sale_outcome = new JTextField();
		sale_outcome.setLocation(250,295);
		sale_outcome.setSize(150,40);
		sale_outcome.setEditable(false);
		sale_outcome.setFont(font);
		sale_outcome.setForeground(Color.red);
		sale_outcome.setBackground(Color.white);
		jyqk_panel.add(sale_outcome);
		//��Ʒ֧��
		JLabel goodsOC_label = new JLabel("��Ʒ֧��");
		goodsOC_label.setLocation(130,355);
		goodsOC_label.setSize(150,30);
		goodsOC_label.setFont(font1);
		jyqk_panel.add(goodsOC_label);
		goods_outcome = new JTextField();
		goods_outcome.setLocation(250,350);
		goods_outcome.setSize(150,40);
		goods_outcome.setEditable(false);
		goods_outcome.setFont(font);
		goods_outcome.setForeground(Color.red);
		goods_outcome.setBackground(Color.white);
		jyqk_panel.add(goods_outcome);
		//������
		JLabel addupIC_label = new JLabel("������");
		addupIC_label.setLocation(20,410);
		addupIC_label.setSize(150,30);
		addupIC_label.setFont(font1);
		addupIC_label.setForeground(Color.red);
		jyqk_panel.add(addupIC_label);
		addup_income = new JTextField();
		addup_income.setLocation(100,405);
		addup_income.setSize(120,40);
		addup_income.setEditable(false);
		addup_income.setFont(font);
		addup_income.setForeground(Color.red);
		addup_income.setBackground(Color.white);
		jyqk_panel.add(addup_income);
		//��֧��
		JLabel addupOC_label = new JLabel("��֧��");
		addupOC_label.setLocation(240,410);
		addupOC_label.setSize(150,30);
		addupOC_label.setFont(font1);
		addupOC_label.setForeground(Color.red);
		jyqk_panel.add(addupOC_label);
		addup_outcome = new JTextField();
		addup_outcome.setLocation(320,405);
		addup_outcome.setSize(120,40);
		addup_outcome.setEditable(false);
		addup_outcome.setFont(font);
		addup_outcome.setForeground(Color.red);
		addup_outcome.setBackground(Color.white);
		jyqk_panel.add(addup_outcome);
		//����
		JLabel profit_label = new JLabel("����");
		profit_label.setLocation(120,465);
		profit_label.setSize(150,30);
		profit_label.setFont(font1);
		profit_label.setForeground(Color.red);
		jyqk_panel.add(profit_label);
		profit = new JTextField();
		profit.setLocation(200,460);
		profit.setSize(120,40);
		profit.setEditable(false);
		profit.setFont(font);
		profit.setForeground(Color.red);
		profit.setBackground(Color.white);
		jyqk_panel.add(profit);
		/*
		 * ȷ�ϡ�ȡ��
		 */
		//����EXCEL
		jyqk_export = new JButton("����EXCEL");
		jyqk_export.addActionListener(new ButtonActionListener());
		jyqk_export.setLocation(330,530);
		jyqk_export.setSize(150,50);
		jyqk_export.setFont(font);
		jyqk_export.setForeground(Color.magenta);
		jyqk_export.setFocusPainted(false);
		jyqk_panel.add(jyqk_export);
		//ͼ�η���
		jyqk_analyse = new JButton("ͼ�η���");
		jyqk_analyse.addActionListener(new ButtonActionListener());
		jyqk_analyse.setLocation(200,530);
		jyqk_analyse.setSize(120,50);
		jyqk_analyse.setFont(font);
		jyqk_analyse.setForeground(Color.magenta);
		jyqk_analyse.setFocusPainted(false);
		jyqk_panel.add(jyqk_analyse);
		//ȷ��
		jyqk_confirm = new JButton("ȷ��");
		jyqk_confirm.addActionListener(new ButtonActionListener());
		jyqk_confirm.setLocation(110,530);
		jyqk_confirm.setSize(80,50);
		jyqk_confirm.setFont(font);
		jyqk_confirm.setForeground(Color.magenta);
		jyqk_confirm.setFocusPainted(false);
		jyqk_panel.add(jyqk_confirm);
		//ȡ��
		jyqk_cancel = new JButton("ȡ��");
		jyqk_cancel.setLocation(20,530);
		jyqk_cancel.setSize(80,50);
		jyqk_cancel.setFont(font);
		jyqk_cancel.setForeground(Color.magenta);
		jyqk_cancel.setFocusPainted(false);
		jyqk_panel.add(jyqk_cancel);
		jyqk_panel.setVisible(false);
		frame.getContentPane().add(jyqk_panel);
		
		//���뱳��ͼƬ
		imagePanel = new ImageJPanel(new ImageIcon("������.jpg").getImage());
		frame.getContentPane().add(imagePanel);
		frame.setVisible(true);
	}
	
	class ButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == close){
				frame.dispose();
			}
			else if(e.getSource() == logout){
				frame.dispose();
				MainFrame mainframe = new MainFrame();
			}
			else if(e.getSource() == checkOrder){
				co_panel.setVisible(true);
				xsmx_panel.setVisible(false);
				mp_panel.setVisible(false);
				jylc_panel.setVisible(false);
				jyqk_panel.setVisible(false);
			}
			else if(e.getSource() == xsmx){
				co_panel.setVisible(false);
				xsmx_panel.setVisible(true);
				mp_panel.setVisible(false);
				jylc_panel.setVisible(false);
				jyqk_panel.setVisible(false);
				CustomerController cc=new CustomerController(operator);
				List<CustomerVO> list=cc.queryCustomerByClassification(0);
				customer_box.removeAllItems();
				customer_box.addItem("");
				goods_box.removeAllItems();
				goods_box.addItem("");
				for(int i=0;i<list.size();i++)
					customer_box.addItem(list.get(i).getName());
				GoodsController gc=new GoodsController(operator);
				List<GoodsVO> goodlist=gc.query();
				for(int i=0;i<goodlist.size();i++){
					goods_box.addItem(goodlist.get(i).getName());
				}		
			}
			else if(e.getSource()==xsmx_confirm){
				String begin=xsmx_start_year.getSelectedItem().toString()+xsmx_start_month.getSelectedItem().toString()+xsmx_start_day.getSelectedItem().toString();
				String end=xsmx_end_year.getSelectedItem().toString()+xsmx_end_month.getSelectedItem().toString()+xsmx_end_day.getSelectedItem().toString();
				SalesDetailController sdc=new SalesDetailController(operator);
				String customer=customer_box.getSelectedItem().toString();
				String goodsname=goods_box.getSelectedItem().toString();
				List<SalesOrderVO> so=sdc.SalesDetail(begin, end,goodsname,customer);
				DefaultTableModel model = (DefaultTableModel)xsmx_table.getModel();
				int row = xsmx_table.getRowCount()-1;
				for(int i=row;i>=0;i--){
					model.removeRow(i);
				}
				int length=0;
				for(int i=0;i<so.size();i++){
					length=length+so.get(i).getList().size();
				}
				
				Object[][] data = new Object[length][6];
				int count=0;
				for(int i=0;i<so.size();i++){
					for(int j=0;j<so.get(i).getList().size();j++){
						if(!goodsname.equals("")){
							if(so.get(i).getList().get(j).getGoodsname().equals(goodsname)){
							data[count][0] = so.get(i).getDate();
							data[count][1] = so.get(i).getList().get(j).getGoodsname();
							data[count][2] = so.get(i).getList().get(j).getType();
							data[count][3] = so.get(i).getList().get(j).getNumber();
							data[count][4] =so.get(i).getList().get(j).getPrice();
							data[count][5] =so.get(i).getList().get(j).getTotal();
							count++;
							}
						}
						else{
							data[count][0] = so.get(i).getDate();
							data[count][1] = so.get(i).getList().get(j).getGoodsname();
							data[count][2] = so.get(i).getList().get(j).getType();
							data[count][3] = so.get(i).getList().get(j).getNumber();
							data[count][4] =so.get(i).getList().get(j).getPrice();
							data[count][5] =so.get(i).getList().get(j).getTotal();
							count++;
						}
							
					}	
				}
				
				for(int i=0;i<length;i++){
					model.addRow(data[i]);
				}
				xsmx_table.setModel(model);		
			}
			else if(e.getSource() == promotion){
				co_panel.setVisible(false);
				xsmx_panel.setVisible(false);
				mp_panel.setVisible(true);
				jylc_panel.setVisible(false);
				jyqk_panel.setVisible(false);
				//��Ʒ��
				GoodsController gc = new GoodsController("�ܾ���");
				List<GoodsVO> list;
				list = gc.query();
				Object[][] data = new Object[list.size()][6];
				for(int i=0;i<list.size();i++){
					data[i][0] = list.get(i).getNumber();
					data[i][1] = list.get(i).getName();
					data[i][2] = list.get(i).getType();
					data[i][3] = list.get(i).getStocknumber();
					data[i][4] = "0";
					data[i][5] = new Boolean(false);
				}
				level_grant_table.setData(data);

			}
			else if(e.getSource() == jylc){
				co_panel.setVisible(false);
				xsmx_panel.setVisible(false);
				mp_panel.setVisible(false);
				jylc_panel.setVisible(true);
				jyqk_panel.setVisible(false);
				CustomerController cc=new CustomerController(operator);
				List<CustomerVO> list=cc.queryCustomer();
				jylc_customer.removeAllItems();
				jylc_customer.addItem("");
				for(int i=0;i<list.size();i++)
					jylc_customer.addItem(list.get(i).getName());		
			}
			else if(e.getSource()==jylc_confirm){
				String type=oc.getSelectedItem().toString();
				BusinessCourseController bcc=new BusinessCourseController(operator);
				String begin=jylc_start_year.getSelectedItem().toString()+jylc_start_month.getSelectedItem().toString()+jylc_start_day.getSelectedItem().toString();
				String end=jylc_end_year.getSelectedItem().toString()+jylc_end_month.getSelectedItem().toString()+jylc_end_day.getSelectedItem().toString();
				String customer=jylc_customer.getSelectedItem().toString();
				if(type.equals("�����൥��")){
					List<SalesOrderVO> list=bcc.querySalesOrder(begin, end);
					List<SalesBackOrderVO> list2=bcc.querySalesBackOrder(begin, end);
					List<SalesOrderVO> listcustomer=new ArrayList<SalesOrderVO>();
					List<SalesBackOrderVO> listcustomer2=new ArrayList<SalesBackOrderVO>();
					if(!customer.equals("")){
						for(int i=0;i<list.size();i++){
							if(list.get(i).getSalesperson().equals(customer))
								listcustomer.add(list.get(i));
						}
						for(int i=0;i<list2.size();i++){
							if(list2.get(i).getSalesperson().equals(customer))
								listcustomer2.add(list2.get(i));
						}
						Object[][] data = new Object[listcustomer.size()+listcustomer2.size()][4];
						for(int i=0;i<listcustomer.size();i++){
							data[i][0]=listcustomer.get(i).getNumber();
							data[i][1]=listcustomer.get(i).getDate();
							data[i][2]="���۵�";
							data[i][3]=new Boolean(false);
						}
						if(listcustomer.size()!=0){
						for(int i=listcustomer.size();i<listcustomer.size()+listcustomer2.size();i++){
							data[i][0]=listcustomer2.get(i-listcustomer.size()).getNumber();
							data[i][1]=listcustomer2.get(i-listcustomer.size()).getDate();
							data[i][2]="�����˻���";
							data[i][3]=new Boolean(false);
							}
						}
						jylc_mytable.setData(data);
					}
					else{
						Object[][] data = new Object[list.size()+list2.size()][4];
						for(int i=0;i<list.size();i++){
							data[i][0]=list.get(i).getNumber();
							data[i][1]=list.get(i).getDate();
							data[i][2]="���۵�";
							data[i][3]=new Boolean(false);
						}
						if(list.size()!=0){
						for(int i=list.size();i<list.size()+list2.size();i++){
							data[i][0]=list2.get(i-list.size()).getNumber();
							data[i][1]=list2.get(i-list.size()).getDate();
							data[i][2]="�����˻���";
							data[i][3]=new Boolean(false);
							}
						}
						jylc_mytable.setData(data);
					}
				}
				else if(type.equals("�����൥��")){
					List<PurchaseOrderVO> list=bcc.queryPurchaseOrder(begin, end);
					List<PurchaseBackOrderVO> list2=bcc.queryPurchaseBackOrder(begin, end);
					List<PurchaseOrderVO> listcustomer=new ArrayList<PurchaseOrderVO>();
					List<PurchaseBackOrderVO> listcustomer2=new ArrayList<PurchaseBackOrderVO>();
					if(!customer.equals("")){
						for(int i=0;i<list.size();i++){
							if(list.get(i).getProvider().equals(customer))
								listcustomer.add(list.get(i));
						}
						for(int i=0;i<list2.size();i++){
							if(list2.get(i).getProvider().equals(customer))
								listcustomer2.add(list2.get(i));
						}
						Object[][] data = new Object[listcustomer.size()+listcustomer2.size()][4];
						for(int i=0;i<listcustomer.size();i++){
							data[i][0]=listcustomer.get(i).getNumber();
							data[i][1]=listcustomer.get(i).getDate();
							data[i][2]="������";
							data[i][3]=new Boolean(false);
						}
						if(listcustomer2.size()!=0){
						for(int i=listcustomer.size();i<listcustomer.size()+listcustomer2.size();i++){
							data[i][0]=listcustomer2.get(i-listcustomer.size()).getNumber();
							data[i][1]=listcustomer2.get(i-listcustomer.size()).getDate();
							data[i][2]="�����˻���";
							data[i][3]=new Boolean(false);
							}
						}
						jylc_mytable.setData(data);
					}
					else{
						Object[][] data = new Object[list.size()+list2.size()][4];
						for(int i=0;i<list.size();i++){
							data[i][0]=list.get(i).getNumber();
							data[i][1]=list.get(i).getDate();
							data[i][2]="������";
							data[i][3]=new Boolean(false);
						}
						if(list.size()!=0){
						for(int i=list.size();i<list.size()+list2.size();i++){
							data[i][0]=list2.get(i-list.size()).getNumber();
							data[i][1]=list2.get(i-list.size()).getDate();
							data[i][2]="�����˻���";
							data[i][3]=new Boolean(false);
							}
						}
						jylc_mytable.setData(data);
					}
				}
				else if(type.equals("�����൥��")){
					List<ReceiptVO> list=bcc.queryReceipt(begin, end);
					List<ReceiptBackVO> list2=bcc.queryReceiptBack(begin, end);
					List<PayOrderVO> list3=bcc.queryPayOrder(begin, end);
					List<ReceiptVO> listcustomer=new ArrayList<ReceiptVO>();
					List<ReceiptBackVO> listcustomer2=new ArrayList<ReceiptBackVO>();
					List<PayOrderVO> listcustomer3=new ArrayList<PayOrderVO>();
					Object[][] data = new Object[list.size()+list2.size()+list3.size()][4];
					for(int i=0;i<list3.size();i++){
						data[i][0]=list3.get(i).getNumber();
						data[i][1]=list3.get(i).getDate();
						data[i][2]="�ֽ���õ�";
						data[i][3]=new Boolean(false);
					}
					if(!customer.equals("")){
						for(int i=0;i<list.size();i++){
							if(list.get(i).getProvider().equals(customer))
								listcustomer.add(list.get(i));
						}
						for(int i=0;i<list2.size();i++){
							if(list2.get(i).getProvider().equals(customer))
								listcustomer2.add(list2.get(i));
						}
						if(listcustomer.size()!=0){
						for(int i=list3.size();i<listcustomer.size()+list3.size();i++){
							data[i][0]=listcustomer.get(i-list3.size()).getNumber();
							data[i][1]=listcustomer.get(i-list3.size()).getDate();
							data[i][2]="�տ";
							data[i][3]=new Boolean(false);
							}
						}
						if(listcustomer2.size()!=0){
						for(int i=listcustomer.size()+list3.size();i<listcustomer.size()+listcustomer2.size()+list3.size();i++){
							data[i][0]=listcustomer2.get(i-list3.size()-listcustomer.size()).getNumber();
							data[i][1]=listcustomer2.get(i-list3.size()-listcustomer.size()).getDate();
							data[i][2]="���";
							data[i][3]=new Boolean(false);
							}
						}
						jylc_mytable.setData(data);
					}
					else{
						if(list3.size()!=0){
						for(int i=list3.size();i<list.size()+list3.size();i++){
							data[i][0]=list.get(i-list3.size()).getNumber();
							data[i][1]=list.get(i-list3.size()).getDate();
							data[i][2]="�տ";
							data[i][3]=new Boolean(false);
							}
						}
						if(list2.size()!=0){
						for(int i=list.size()+list3.size();i<list.size()+list2.size()+list3.size();i++){
							data[i][0]=list2.get(i-list3.size()-list.size()).getNumber();
							data[i][1]=list2.get(i-list3.size()-list.size()).getDate();
							data[i][2]="���";
							data[i][3]=new Boolean(false);
							}
						}
						jylc_mytable.setData(data);
					}		
				}
				else if(type.equals("����൥��")){
					List<StockLossOrderVO> list=bcc.queryStockLossOrder(begin, end);
					List<StockOverflowOrderVO> list2=bcc.queryStockOverflowOrder(begin, end);
					List<StockGrantOrderVO> list3=bcc.queryStockGrantOrder(begin, end);
					Object[][] data = new Object[list.size()+list2.size()+list3.size()][4];
					for(int i=0;i<list.size();i++){
						data[i][0]=list.get(i).getOrdernumber2();
						data[i][1]=list.get(i).getDate();
						data[i][2]="��汨��";
						data[i][3]=new Boolean(false);
					}
					if(list2.size()!=0){
					for(int i=list.size();i<list.size()+list2.size();i++){
						data[i][0]=list2.get(i-list.size()).getOrdernumber2();
						data[i][1]=list2.get(i-list.size()).getDate();
						data[i][2]="��汨�絥";
						data[i][3]=new Boolean(false);
						}
					}
					if(list3.size()!=0){					
					for(int i=list.size()+list2.size();i<list.size()+list2.size()+list3.size();i++){
						data[i][0]=list3.get(i-list.size()-list2.size()).getOrdernumber2();
						data[i][1]=list3.get(i-list.size()-list2.size()).getDate();
						data[i][2]="������͵�";
						data[i][3]=new Boolean(false);
						}
					}
					jylc_mytable.setData(data);
				}
				GoodsClassificationController aqa=new GoodsClassificationController(operator);
				aqa.insertLog("�鿴��Ӫ���̱�");
			}
			else if(e.getSource() == jyqk){
				co_panel.setVisible(false);
				xsmx_panel.setVisible(false);
				mp_panel.setVisible(false);
				jylc_panel.setVisible(false);
				jyqk_panel.setVisible(true);
			}
			else if(e.getSource()==jyqk_confirm){
				ManagementSituationController msc=new ManagementSituationController(operator);
				String begin1=jyqk_start_year.getSelectedItem().toString()+jyqk_start_month.getSelectedItem().toString()+jyqk_start_day.getSelectedItem().toString();
				String end1=jyqk_end_year.getSelectedItem().toString()+jyqk_end_month.getSelectedItem().toString()+jyqk_end_day.getSelectedItem().toString();
				List<Double>list=msc.Situation(begin1, end1);
				sale_income.setText(String.valueOf(list.get(0)));//��������
				goods_income.setText(String.valueOf(list.get(1)));//��Ʒ������
				discount_income.setText(String.valueOf(list.get(2)));;//����
				sale_outcome.setText(String.valueOf(list.get(3)));//����֧��
				goods_outcome.setText(String.valueOf(list.get(4)));;//��Ʒ��֧��
				addup_income.setText(String.valueOf(list.get(0)+list.get(1)));;//������
				addup_outcome.setText(String.valueOf(list.get(3)+list.get(4)));;//��֧��
				profit.setText(String.valueOf(list.get(0)+list.get(1)-list.get(3)-list.get(4)));
				GoodsClassificationController aqa=new GoodsClassificationController(operator);
				aqa.insertLog("�鿴��Ӫ�����");
			}
			else if(e.getSource()==level_confirm){
				LevelPromotionVO vo=new LevelPromotionVO();
				vo.setBegintime(mp_start_year.getSelectedItem().toString()+mp_start_month.getSelectedItem().toString()+mp_start_day.getSelectedItem().toString());
				vo.setEndtime(mp_end_year.getSelectedItem().toString()+mp_end_month.getSelectedItem().toString()+mp_end_day.getSelectedItem().toString());
				if(level_box.getSelectedItem().equals("һ��"))
					vo.setLevel(1);
				else if(level_box.getSelectedItem().equals("����"))
					vo.setLevel(2);
				else if(level_box.getSelectedItem().equals("����"))
					vo.setLevel(3);
				else if(level_box.getSelectedItem().equals("�ļ�"))
					vo.setLevel(4);
				else if(level_box.getSelectedItem().equals("�弶"))
					vo.setLevel(5);
				vo.setVoucher(Double.valueOf(voucher.getText()));
				System.out.println(vo.getVoucher());
				vo.setZherang(Double.valueOf(discount.getText()));
				List<GoodsListVO> list=new ArrayList<GoodsListVO>();
				for(int i=0;i<level_table.getRowCount();i++){
					if((boolean)level_grant_table.getValueAt(i, 5)){
						GoodsListVO goodslist=new GoodsListVO();
						int good=Integer.parseInt(level_grant_table.getValueAt(i, 0).toString());
						int count=Integer.parseInt(level_grant_table.getValueAt(i, 4).toString());
						goodslist.setGoodsnumber(good);
						goodslist.setNumber(count);
						list.add(goodslist);
					}
				}
				vo.setEverylist(list);
				PromotionController pc=new PromotionController(operator);
				ResultMessage res=pc.createLevelPromotion(vo);
				JOptionPane.showMessageDialog(frame.getContentPane(), "�ύ�ɹ���");
			}
			else if(e.getSource()==goods_confirm){
				GoodsCombinationPromotionVO vo=new GoodsCombinationPromotionVO();
				vo.setBegintime(mp_start_year.getSelectedItem().toString()+mp_start_month.getSelectedItem().toString()+mp_start_day.getSelectedItem().toString());
				vo.setEndtime(mp_end_year.getSelectedItem().toString()+mp_end_month.getSelectedItem().toString()+mp_end_day.getSelectedItem().toString());
				double jiangjia=Double.valueOf(addUp.getText())-Double.valueOf(bargain.getText());
				vo.setJiangjia(jiangjia);
				List<GoodsListVO> list=new ArrayList<GoodsListVO>();
				for(int i=0;i<goods_table.getRowCount();i++){
					if((boolean)goods_mytable.getValueAt(i, 4)){
						GoodsListVO goodslist=new GoodsListVO();
						int good=Integer.parseInt(goods_mytable.getValueAt(i, 0).toString());
						goodslist.setGoodsnumber(good);
						list.add(goodslist);
					}
				}
				vo.setList(list);
				PromotionController pc=new PromotionController(operator);
				ResultMessage res=pc.createGoodsPromotion(vo);
				JOptionPane.showMessageDialog(frame.getContentPane(), "�ύ�ɹ���");
			}
			else if(e.getSource()==money_confirm){
				TotalPromotionVO vo=new TotalPromotionVO();
				vo.setBegintime(mp_start_year.getSelectedItem().toString()+mp_start_month.getSelectedItem().toString()+mp_start_day.getSelectedItem().toString());
				vo.setEndtime(mp_end_year.getSelectedItem().toString()+mp_end_month.getSelectedItem().toString()+mp_end_day.getSelectedItem().toString());
			    vo.setStandardprice(Double.valueOf(money.getText()));
			    vo.setVoucher(Double.valueOf(voucher1.getText()));
			    List<GoodsListVO> list=new ArrayList<GoodsListVO>();
				for(int i=0;i<money_table.getRowCount();i++){
					if((boolean)money_grant_table.getValueAt(i, 5)){
						GoodsListVO goodslist=new GoodsListVO();
						int good=Integer.parseInt(money_grant_table.getValueAt(i, 0).toString());
						int count=Integer.parseInt(money_grant_table.getValueAt(i, 4).toString());
						goodslist.setGoodsnumber(good);
						goodslist.setNumber(count);
						list.add(goodslist);
					}
				}
				vo.setEverylist(list);
				PromotionController pc=new PromotionController(operator);
				ResultMessage res=pc.createTotalPromotion(vo);
				JOptionPane.showMessageDialog(frame.getContentPane(), "�ύ�ɹ���");
			}
			else if(e.getSource()==order_search){
				String cl=order_Classification.getSelectedItem().toString();
				if(cl.equals("�����൥��")){
					CheckSalesController csc=new CheckSalesController(operator);
					List<SalesOrderVO> sales=csc.querySalesOrder();
					List<SalesBackOrderVO> salesback=csc.querySalesBackOrder();
					Object list[][]=new Object[sales.size()+salesback.size()][4];
					for(int i=0;i<sales.size();i++){
						list[i][0]=sales.get(i).getNumber();
						list[i][1]=sales.get(i).getDate();
						list[i][2]="���۵�";
						list[i][3]=new Boolean(false);
					}
					if(salesback.size()!=0){
					for(int i=sales.size();i<sales.size()+salesback.size();i++){
						list[i][0]=salesback.get(i-sales.size()).getNumber();
						list[i][1]=salesback.get(i-sales.size()).getDate();
						list[i][2]="�����˻���";
						list[i][3]=new Boolean(false);
						}
					}
					order_mytable.setData(list);
				}
				else if(cl.equals("�����൥��")){
					CheckPurchaseController cpc=new CheckPurchaseController(operator);
					List<PurchaseOrderVO> pur=cpc.queryPurchaseOrder();
					List<PurchaseBackOrderVO> purback=cpc.queryPurchaseBackOrder();
					Object list[][]=new Object[pur.size()+purback.size()][4];
					for(int i=0;i<pur.size();i++){
						list[i][0]=pur.get(i).getNumber();
						list[i][1]=pur.get(i).getDate();
						list[i][2]="������";			
						list[i][3]=new Boolean(false);
					}
					if(purback.size()!=0){
						for(int i=pur.size();i<pur.size()+purback.size();i++){
						list[i][0]=purback.get(i-pur.size()).getNumber();
						list[i][1]=purback.get(i-pur.size()).getDate();
						list[i][2]="�����˻���";	
						list[i][3]=new Boolean(false);
						}
					}
					
					order_mytable.setData(list);
				}
				else if(cl.equals("����൥��")){
					CheckStockController csc=new CheckStockController(operator);
					List<StockGrantOrderVO> grantlist=csc.queryStockGrantOrder();
					List<StockLossOrderVO> losslist=csc.queryStockLossOrder();
					List<StockOverflowOrderVO> overlist=csc.queryStockOverflowOrder();
					List<StockAlarmOrderVO> alarmlist=csc.queryStockAlarmOrder();
					int hang=grantlist.size()+losslist.size()+overlist.size();
					int size1=grantlist.size();
					int size2=losslist.size();
					int size3=overlist.size();
					int size4=alarmlist.size();
					Object list[][]=new Object[hang][4];
					for(int i=0;i<size1;i++){
						list[i][0]=grantlist.get(i).getOrdernumber2();
						list[i][1]=grantlist.get(i).getDate();
						list[i][2]="���͵�";
						list[i][3]=new Boolean(false);
					}
					if(losslist.size()!=0){
					for(int i=size1;i<size1+size2;i++){
						list[i][0]=losslist.get(i-size1).getOrdernumber2();
						list[i][1]=losslist.get(i-size1).getDate();
						list[i][2]="����";
						list[i][3]=new Boolean(false);
						}
					}
					if(overlist.size()!=0){
					for(int i=size1+size2;i<size1+size2+size3;i++){
						list[i][0]=overlist.get(i-size1-size2).getOrdernumber2();
						list[i][1]=overlist.get(i-size1-size2).getDate();
						list[i][2]="���絥";
						list[i][3]=new Boolean(false);
						}
					}
					/*for(int i=size1+size2+size3;i<size1+size2+size3+size4;i++){
						list[i][0]=alarmlist.get(i-size1-size2)
						list[i][1]=alarmlist.get(i-size1-size2).getDate();
						list[i][3]="���絥";
					}*/
					order_mytable.setData(list);	
				}
				else if(cl.equals("�����൥��")){
					CheckReceiptController crs=new CheckReceiptController(operator);
					List<ReceiptVO> receiptlist=crs.queryReceipt();
					List<ReceiptBackVO> receiptbacklist=crs.queryReceiptBack();
					int hang=receiptlist.size()+receiptbacklist.size();
					Object list[][]=new Object[hang][4];
					for(int i=0;i<receiptlist.size();i++){
						list[i][0]=receiptlist.get(i).getNumber();
						list[i][1]=receiptlist.get(i).getDate();
						list[i][2]="�տ";
						list[i][3]=new Boolean(false);
					}
					if(receiptbacklist.size()!=0){
					for(int i=receiptlist.size();i<receiptlist.size()+receiptbacklist.size();i++){
						list[i][0]=receiptbacklist.get(i-receiptlist.size()).getNumber();
						list[i][1]=receiptbacklist.get(i-receiptlist.size()).getDate();
						list[i][2]="���";
						list[i][3]=new Boolean(false);
						}
					}
					order_mytable.setData(list);	
				}
			}
			else if(e.getSource() == co_pass){
				int row = 0;
				for(int i=0;i<order_table.getRowCount();i++){
					//���ݱ�ѡ��
					if((boolean)order_mytable.getValueAt(i, 3)){
						row++;
						if(order_mytable.getValueAt(i, 0).toString().substring(0,3).equals("XSD")){
							CheckSalesController csc = new CheckSalesController(operator);
							SalesOrderVO vo = csc.querySalesByNumber(order_mytable.getValueAt(i, 0).toString());
							csc.update(vo, true);
						}
						else if(order_mytable.getValueAt(i, 0).toString().substring(0,3).equals("XST")){
							CheckSalesController csc = new CheckSalesController(operator);
							SalesBackOrderVO vo = csc.querySalesBackByNumber(order_mytable.getValueAt(i, 0).toString());
							csc.update(vo,true);
						}
						else if(order_mytable.getValueAt(i, 0).toString().substring(0,3).equals("JHD")){
							CheckPurchaseController cpc = new CheckPurchaseController(operator);
							PurchaseOrderVO vo = cpc.queryPurchaseByNumber(order_mytable.getValueAt(i, 0).toString());
							cpc.update(vo,true);
						}
						else if(order_mytable.getValueAt(i, 0).toString().substring(0,3).equals("JHT")){
							CheckPurchaseController cpc = new CheckPurchaseController(operator);
							PurchaseBackOrderVO vo = cpc.queryPurchaseBackByNumber(order_mytable.getValueAt(i, 0).toString());
						    cpc.update(vo,true);
						}
						else if(order_mytable.getValueAt(i, 0).toString().substring(0,3).equals("FKD")){
							CheckReceiptController crc = new CheckReceiptController(operator);
							ReceiptBackVO vo = crc.queryReceiptBackByNumber(order_mytable.getValueAt(i, 0).toString());
							crc.update(vo,true);
						}
						else if(order_mytable.getValueAt(i, 0).toString().substring(0,3).equals("SKD")){
							CheckReceiptController crc = new CheckReceiptController(operator);
							ReceiptVO vo = crc.queryReceiptByNumber(order_mytable.getValueAt(i, 0).toString());
							crc.update(vo,true);
						}
						
					}
				}
				//�ػ���
				Object[][] data = new Object[order_table.getRowCount()-row][4];
				int j = 0;
				for(int i=0;i<order_table.getRowCount();i++){
					if(!(boolean)order_mytable.getValueAt(i, 3)){
						data[j][0] = order_table.getValueAt(i, 0);
						data[j][1] = order_table.getValueAt(i, 1);
						data[j][2] = order_table.getValueAt(i, 2);
						data[j][3] = order_table.getValueAt(i, 3);
						j++;
						if(j == order_table.getRowCount()-row){
							break;
						}
					}
				}
				order_mytable.setData(data);
				GoodsClassificationController aqa=new GoodsClassificationController(operator);
				aqa.insertLog("��������");
			}
			else if(e.getSource()==co_unpass){
				int row = 0;
				for(int i=0;i<order_table.getRowCount();i++){
					//���ݱ�ѡ��
					if((boolean)order_mytable.getValueAt(i, 3)){
						row++;
						if(order_mytable.getValueAt(i, 0).toString().substring(0,3).equals("XSD")){
							CheckSalesController csc = new CheckSalesController(operator);
							SalesOrderVO vo = csc.querySalesByNumber(order_mytable.getValueAt(i, 0).toString());
							csc.update(vo, false);
						}
						else if(order_mytable.getValueAt(i, 0).toString().substring(0,3).equals("XST")){
							CheckSalesController csc = new CheckSalesController(operator);
							SalesBackOrderVO vo = csc.querySalesBackByNumber(order_mytable.getValueAt(i, 0).toString());
							csc.update(vo,false);
						}
						else if(order_mytable.getValueAt(i, 0).toString().substring(0,3).equals("JHD")){
							CheckPurchaseController cpc = new CheckPurchaseController(operator);
							PurchaseOrderVO vo = cpc.queryPurchaseByNumber(order_mytable.getValueAt(i, 0).toString());
							cpc.update(vo,false);
						}
						else if(order_mytable.getValueAt(i, 0).toString().substring(0,3).equals("JHT")){
							CheckPurchaseController cpc = new CheckPurchaseController(operator);
							PurchaseBackOrderVO vo = cpc.queryPurchaseBackByNumber(order_mytable.getValueAt(i, 0).toString());
						    cpc.update(vo,false);
						}
						else if(order_mytable.getValueAt(i, 0).toString().substring(0,3).equals("FKD")){
							CheckReceiptController crc = new CheckReceiptController(operator);
							ReceiptBackVO vo = crc.queryReceiptBackByNumber(order_mytable.getValueAt(i, 0).toString());
							crc.update(vo,false);
						}
						else if(order_mytable.getValueAt(i, 0).toString().substring(0,3).equals("SKD")){
							CheckReceiptController crc = new CheckReceiptController(operator);
							ReceiptVO vo = crc.queryReceiptByNumber(order_mytable.getValueAt(i, 0).toString());
							crc.update(vo,false);
						}
						
					}
				}
				//�ػ���
				Object[][] data = new Object[order_table.getRowCount()-row][4];
				int j = 0;
				for(int i=0;i<order_table.getRowCount();i++){
					if(!(boolean)order_mytable.getValueAt(i, 3)){
						data[j][0] = order_table.getValueAt(i, 0);
						data[j][1] = order_table.getValueAt(i, 1);
						data[j][2] = order_table.getValueAt(i, 2);
						data[j][3] = order_table.getValueAt(i, 3);
						j++;
						if(j == row){
							break;
						}
					}
				}
				order_mytable.setData(data);
				GoodsClassificationController aqa=new GoodsClassificationController(operator);
				aqa.insertLog("��������");
			}
			else if(e.getSource() == checkLog){
				Font font = new Font("Default",Font.BOLD,20);
				checkLog_frame = new JFrame("�鿴��־");
				checkLog_frame.setLocation(600, 200);
				checkLog_frame.setSize(800,500);
				checkLog_frame.setLayout(null);
				checkLog_frame.getContentPane().setBackground(Color.cyan);
				checkLog_frame.setFont(font);
				/*
				 * ��־��ʾ
				 */
				Object[][] data = {{"","",""}};
				String[] columnNames = {"����","����Ա","�¼�"};
				DefaultTableModel model = new DefaultTableModel(data,columnNames);
				JTable log_table = new JTable(model){
					public boolean isCellEditable(int rowIndex, int columnIndex){
						return false;
					}
				};
				log_table.setFont(font);
				log_table.setBackground(Color.cyan);
				log_table.getTableHeader().setFont(font);
				log_table.getTableHeader().setForeground(Color.red);
				log_table.setRowHeight(40);
				log_table.getColumnModel().getColumn(0).setPreferredWidth(200);
				log_table.getColumnModel().getColumn(1).setPreferredWidth(150);
				log_table.getColumnModel().getColumn(2).setPreferredWidth(430);
				JScrollPane log_table_scrollPane = new JScrollPane(log_table);
				log_table_scrollPane.setSize(780,445);
				log_table_scrollPane.setLocation(0,0);
				log_table_scrollPane.getViewport().setBackground(Color.cyan);
			    checkLog_frame.add(log_table_scrollPane);
			    /*
			     * ������־����
			     */
			    DefaultTableModel log_model = (DefaultTableModel)log_table.getModel();
				int n = model.getRowCount() - 1;
				while(n >= 0){
					model.removeRow(n);
					n--;
				}
				LogController lc = new LogController();
				List<LogVO> list = lc.queryAllLog();
				Object[][] log_data = new Object[list.size()][3];
				for(int i=0;i<list.size();i++){
					log_data[i][0] = list.get(i).getDate();
					log_data[i][1] = list.get(i).getName();
					log_data[i][2] = list.get(i).getOperation();
				}
				for(int i=0;i<list.size();i++){
					log_model.addRow(log_data[i]);
				}
				checkLog_frame.setVisible(true);
			}
			else if(e.getSource() == jyqk_analyse){
				JFrame frame=new JFrame("����ͳ��ͼ");
			    frame.setLayout(new GridLayout(2,1,10,10));
			    frame.add(new PieChart("������").getChartPanel());     
			    frame.add(new PieChart("֧����").getChartPanel());   
			    frame.setBounds(100, 100, 800, 800);
			    frame.setVisible(true);
			}
			else if(e.getSource() == jyqk_export){
				String path = "";
				String begin = jyqk_start_year.getSelectedItem().toString() + jyqk_start_month.getSelectedItem().toString() + jyqk_start_day.getSelectedItem().toString();
				String end = jyqk_end_year.getSelectedItem().toString() + jyqk_end_month.getSelectedItem().toString() + jyqk_end_day.getSelectedItem().toString();
				ManagementSituationController msc = new ManagementSituationController(operator);
				List<Double> list = new ArrayList<Double>();
				list.add(Double.parseDouble(sale_income.getText()));
				list.add(Double.parseDouble(goods_income.getText()));
				list.add(Double.parseDouble(discount_income.getText()));
				list.add(Double.parseDouble(sale_outcome.getText()));
				list.add(Double.parseDouble(goods_outcome.getText()));
				list.add(Double.parseDouble(profit.getText()));
				JFileChooser chooser = new JFileChooser();  			    
			    int abc =chooser.showSaveDialog(null);  
			    if(abc == JFileChooser.APPROVE_OPTION){  
			        path = chooser.getSelectedFile().getAbsolutePath()+".xls";		    
			    }
				msc.exportSituation(list, path);
				msc.insertLog("������Ӫ���");
			}
		}
		
	}
	
	class MouseActionListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == order_table){
			    //˫��һ�к���ʾ���ݵ���ϸ��Ϣ
			    if(e.getClickCount() == 2 && order_table.getSelectedColumn()!=3){
			    	int row = order_table.getSelectedRow();
			    	String str = order_mytable.getValueAt(row, 0).toString();
			    	if(str.substring(0, 3).equals("XSD")){
			    		new SalesOrderFrame(str,operator,0);
			    	}
			    	else if(str.substring(0, 3).equals("JHD")){
			    		new PurchaseOrderFrame(str,operator,0);
			    	}
			    	else if(str.substring(0, 3).equals("XST")){
			    		new SalesBackOrderFrame(str,operator,0);
			    	}
			    	else if(str.substring(0, 3).equals("JHT")){
			    		new PurchaseBackOrderFrame(str,operator,0);
			    	}
			    	else if(str.substring(0, 3).equals("FKD")){
			    		new ReceiptBackFrame(str,operator,0);
			    	}
			    	else if(str.substring(0, 3).equals("SKD")){
			    		new ReceiptOrderFrame(str,operator,0);
			    	}
			    	else if(str.substring(0, 3).equals("BSD")){
			    		new StockLossFrame(str,operator,0);
			    	}
			    	else if(str.substring(0, 3).equals("BYD")){
			    		new StockOverflowFrame(str,operator,0);
			    	}
			    	else if(str.substring(0, 3).equals("ZSD")){
			    		new StockGrantFrame(str,operator,0);
			    	}
			    }
			}
			else if(e.getSource() == jylcOrder_table){
				//˫��һ�к���ʾ���ݵ���ϸ��Ϣ
				 if(e.getClickCount() == 2 && jylcOrder_table.getSelectedColumn()!=3){
					 int row = jylcOrder_table.getSelectedRow();
				    	String str = jylc_mytable.getValueAt(row, 0).toString();
				    	if(str.substring(0, 3).equals("XSD")){
				    		new SalesOrderFrame(str,operator,0);
				    	}
				    	else if(str.substring(0, 3).equals("JHD")){
				    		new PurchaseOrderFrame(str,operator,0);
				    	}
				    	else if(str.substring(0, 3).equals("XST")){
				    		new SalesBackOrderFrame(str,operator,0);
				    	}
				    	else if(str.substring(0, 3).equals("JHT")){
				    		new PurchaseBackOrderFrame(str,operator,0);
				    	}
				    	else if(str.substring(0, 3).equals("FKD")){
				    		new ReceiptBackFrame(str,operator,0);
				    	}
				    	else if(str.substring(0, 3).equals("SKD")){
				    		new ReceiptOrderFrame(str,operator,0);
				    	}
				    	else if(str.substring(0, 3).equals("BSD")){
				    		new StockLossFrame(str,operator,0);
				    	}
				    	else if(str.substring(0, 3).equals("BYD")){
				    		new StockOverflowFrame(str,operator,0);
				    	}
				    	else if(str.substring(0, 3).equals("ZSD")){
				    		new StockGrantFrame(str,operator,0);
				    	}
				 }
			}
			else if(e.getSource() == goods_table){
				if(goods_table.getSelectedColumn() == 4){
					double num = 0;
			    	for(int i=0;i<goods_table.getRowCount();i++){
						if((boolean)goods_table.getValueAt(i, 4)){
							num = num + Double.parseDouble(goods_table.getValueAt(i, 3).toString());
						}
					}
			         addUp.setText((num+""));
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
				if(e.getSource() == xsmx_start_month){
					int index = xsmx_start_month.getSelectedIndex();
					index++;
					if(index==1 || index==3 || index==5 || index==7 || index==8 || index==10 || index==12){
						xsmx_start_day.removeItem("29");
						xsmx_start_day.removeItem("30");
						xsmx_start_day.removeItem("31");
						xsmx_start_day.addItem("29");
						xsmx_start_day.addItem("30");
						xsmx_start_day.addItem("31");
					}else if(index==4 || index==6 || index==9 || index==11){
						xsmx_start_day.removeItem("29");
						xsmx_start_day.removeItem("30");
						xsmx_start_day.removeItem("31");
						xsmx_start_day.addItem("29");
						xsmx_start_day.addItem("30");
					}else if(index==2){
						xsmx_start_day.removeItem("29");
						xsmx_start_day.removeItem("30");
						xsmx_start_day.removeItem("31");
					}
				}else if(e.getSource() == xsmx_end_month){
					int index = xsmx_end_month.getSelectedIndex();
					index++;
					if(index==1 || index==3 || index==5 || index==7 || index==8 || index==10 || index==12){
						xsmx_end_day.removeItem("29");
						xsmx_end_day.removeItem("30");
						xsmx_end_day.removeItem("31");
						xsmx_end_day.addItem("29");
						xsmx_end_day.addItem("30");
						xsmx_end_day.addItem("31");
					}else if(index==4 || index==6 || index==9 || index==11){
						xsmx_end_day.removeItem("29");
						xsmx_end_day.removeItem("30");
						xsmx_end_day.removeItem("31");
						xsmx_end_day.addItem("29");
						xsmx_end_day.addItem("30");
					}else if(index==2){
						xsmx_end_day.removeItem("29");
						xsmx_end_day.removeItem("30");
						xsmx_end_day.removeItem("31");
					}
				}
				else if(e.getSource() == mp_start_month){
					int index = mp_start_month.getSelectedIndex();
					index++;
					if(index==1 || index==3 || index==5 || index==7 || index==8 || index==10 || index==12){
						mp_start_day.removeItem("29");
						mp_start_day.removeItem("30");
						mp_start_day.removeItem("31");
						mp_start_day.addItem("29");
					    mp_start_day.addItem("30");
						mp_start_day.addItem("31");
					}else if(index==4 || index==6 || index==9 || index==11){
						mp_start_day.removeItem("29");
						mp_start_day.removeItem("30");
						mp_start_day.removeItem("31");
						mp_start_day.addItem("29");
						mp_start_day.addItem("30");
					}else if(index==2){
						mp_start_day.removeItem("29");
						mp_start_day.removeItem("30");
						mp_start_day.removeItem("31");
					}
				}
				else if(e.getSource() == mp_end_month){
					int index = mp_end_month.getSelectedIndex();
					index++;
					if(index==1 || index==3 || index==5 || index==7 || index==8 || index==10 || index==12){
						mp_end_day.removeItem("29");
						mp_end_day.removeItem("30");
						mp_end_day.removeItem("31");
						mp_end_day.addItem("29");
						mp_end_day.addItem("30");
						mp_end_day.addItem("31");
					}else if(index==4 || index==6 || index==9 || index==11){
						mp_end_day.removeItem("29");
						mp_end_day.removeItem("30");
						mp_end_day.removeItem("31");
						mp_end_day.addItem("29");
						mp_end_day.addItem("30");
					}else if(index==2){
						mp_end_day.removeItem("29");
						mp_end_day.removeItem("30");
						mp_end_day.removeItem("31");
					}
				}
				else if(e.getSource() == promotion_classification){
					int index = promotion_classification.getSelectedIndex();
					if(index == 0){
						level_promotion.setVisible(true);
						goods_promotion.setVisible(false);
						money_promotion.setVisible(false);
						//��Ʒ��
						GoodsController gc = new GoodsController("�ܾ���");
						List<GoodsVO> list;
						list = gc.query();
						Object[][] data = new Object[list.size()][6];
						for(int i=0;i<list.size();i++){
							data[i][0] = list.get(i).getNumber();
							data[i][1] = list.get(i).getName();
							data[i][2] = list.get(i).getType();
							data[i][3] = list.get(i).getStocknumber();
							data[i][4] = "0";
							data[i][5] = new Boolean(false);
						}
						level_grant_table.setData(data);

					}
					else if(index == 1){
						level_promotion.setVisible(false);
						goods_promotion.setVisible(true);
						money_promotion.setVisible(false);
						//��Ʒѡ���
						GoodsController gc = new GoodsController(operator);
						List<GoodsVO> list;
						list = gc.query();
						Object[][] data = new Object[list.size()][5];
						for(int i=0;i<list.size();i++){
							data[i][0] = list.get(i).getNumber();
							data[i][1] = list.get(i).getName();
							data[i][2] = list.get(i).getType();
							data[i][3] = list.get(i).getLatestpeice();
							data[i][4] = new Boolean(false);
						}
						goods_mytable.setData(data);

					}
					else if(index == 2){
						level_promotion.setVisible(false);
						goods_promotion.setVisible(false);
						money_promotion.setVisible(true);
						//��Ʒ��
						GoodsController gc = new GoodsController(operator);
						List<GoodsVO> list;
						list = gc.query();
						Object[][] data = new Object[list.size()][6];
						for(int i=0;i<list.size();i++){
							data[i][0] = list.get(i).getNumber();
							data[i][1] = list.get(i).getName();
							data[i][2] = list.get(i).getType();
							data[i][3] = list.get(i).getStocknumber();
							data[i][4] = "0";
							data[i][5] = new Boolean(false);
						}
						money_grant_table.setData(data);

					}
				}
				else if(e.getSource() == jylc_start_month){
					int index = jylc_start_month.getSelectedIndex();
					index++;
					if(index==1 || index==3 || index==5 || index==7 || index==8 || index==10 || index==12){
						jylc_start_day.removeItem("29");
						jylc_start_day.removeItem("30");
						jylc_start_day.removeItem("31");
						jylc_start_day.addItem("29");
					    jylc_start_day.addItem("30");
						jylc_start_day.addItem("31");
					}else if(index==4 || index==6 || index==9 || index==11){
						jylc_start_day.removeItem("29");
						jylc_start_day.removeItem("30");
						jylc_start_day.removeItem("31");
						jylc_start_day.addItem("29");
						jylc_start_day.addItem("30");
					}else if(index==2){
						jylc_start_day.removeItem("29");
						jylc_start_day.removeItem("30");
						jylc_start_day.removeItem("31");
					}
				}
				else if(e.getSource() == jylc_end_month){
					int index = jylc_end_month.getSelectedIndex();
					index++;
					if(index==1 || index==3 || index==5 || index==7 || index==8 || index==10 || index==12){
						jylc_end_day.removeItem("29");
						jylc_end_day.removeItem("30");
						jylc_end_day.removeItem("31");
						jylc_end_day.addItem("29");
						jylc_end_day.addItem("30");
						jylc_end_day.addItem("31");
					}else if(index==4 || index==6 || index==9 || index==11){
						jylc_end_day.removeItem("29");
						jylc_end_day.removeItem("30");
						jylc_end_day.removeItem("31");
						jylc_end_day.addItem("29");
						jylc_end_day.addItem("30");
					}else if(index==2){
						jylc_end_day.removeItem("29");
						jylc_end_day.removeItem("30");
						jylc_end_day.removeItem("31");
					}
				}
				else if(e.getSource() == jyqk_start_month){
					int index = jyqk_start_month.getSelectedIndex();
					index++;
					if(index==1 || index==3 || index==5 || index==7 || index==8 || index==10 || index==12){
						jyqk_start_day.removeItem("29");
						jyqk_start_day.removeItem("30");
						jyqk_start_day.removeItem("31");
						jyqk_start_day.addItem("29");
					    jyqk_start_day.addItem("30");
						jyqk_start_day.addItem("31");
					}else if(index==4 || index==6 || index==9 || index==11){
						jyqk_start_day.removeItem("29");
						jyqk_start_day.removeItem("30");
						jyqk_start_day.removeItem("31");
						jyqk_start_day.addItem("29");
						jyqk_start_day.addItem("30");
					}else if(index==2){
						jyqk_start_day.removeItem("29");
						jyqk_start_day.removeItem("30");
						jyqk_start_day.removeItem("31");
					}
				}
				else if(e.getSource() == jyqk_end_month){
					int index = jyqk_end_month.getSelectedIndex();
					index++;
					if(index==1 || index==3 || index==5 || index==7 || index==8 || index==10 || index==12){
						jyqk_end_day.removeItem("29");
						jyqk_end_day.removeItem("30");
						jyqk_end_day.removeItem("31");
						jyqk_end_day.addItem("29");
						jyqk_end_day.addItem("30");
						jyqk_end_day.addItem("31");
					}else if(index==4 || index==6 || index==9 || index==11){
						jyqk_end_day.removeItem("29");
						jyqk_end_day.removeItem("30");
						jyqk_end_day.removeItem("31");
						jyqk_end_day.addItem("29");
						jyqk_end_day.addItem("30");
					}else if(index==2){
						jyqk_end_day.removeItem("29");
						jyqk_end_day.removeItem("30");
						jyqk_end_day.removeItem("31");
					}
				}
				else if(e.getSource()==customer_box){
					String name=customer_box.getSelectedItem().toString();
					CustomerController cc=new CustomerController(operator);
					CustomerVO customer=cc.queryCustomerByName(name);
					salesman_box.setText(customer.getDefaultname());
				}
				else if(e.getSource()==jylc_customer){
					String name=jylc_customer.getSelectedItem().toString();
					CustomerController cc=new CustomerController(operator);
					CustomerVO customer=cc.queryCustomerByName(name);
					jylc_salesman.setText(customer.getDefaultname());
				}
			}
		}
		
	}
	
	//�Զ���table
		class Mytable extends AbstractTableModel{
			String[] columnNames = {"���","����","��������","ѡ��"};
			Object[][] celldata = {{"","","",new Boolean(false)},{"","","",new Boolean(false)},{"","","",new Boolean(false)},
			{"","","",new Boolean(false)},{"","","",new Boolean(false)},{"","","",new Boolean(false)},{"","","",new Boolean(false)},
			{"","","",new Boolean(false)},{"","","",new Boolean(false)},{"","","",new Boolean(false)}};
			
			//���ñ������
			public void setData(Object[][] data){
				celldata = data;
				fireTableDataChanged();
			}

			//����ÿһ�е�����
			@Override
			public Class getColumnClass(int columnIndex) {
				if(columnIndex == 3){
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
				if(columnIndex==3){
					   return true;
				}else{
					return false;
				}
			}
		}
		//��Ʒ��
		class Mytable1 extends AbstractTableModel{
			String[] columnNames = {"���","����","�ͺ�","�������","��������","ѡ��"};
			Object[][] celldata = {{"","","","","",new Boolean(false)},{"","","","","",new Boolean(false)},{"","","","","",new Boolean(false)},
					{"","","","","",new Boolean(false)},{"","","","","",new Boolean(false)},{"","","","","",new Boolean(false)},{"","","","","",new Boolean(false)}
					,{"","","","","",new Boolean(false)},{"","","","","",new Boolean(false)},{"","","","","",new Boolean(false)},{"","","","","",new Boolean(false)}};
			
			
			//���ñ������
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
				if(columnIndex==4 || columnIndex==5){
					   return true;
				}else{
					return false;
				}
			}
		}
		
		//��Ʒѡ���б�
		class Mytable2 extends AbstractTableModel{
			String[] columnNames = {"���","����","�ͺ�","����","ѡ��"};
			Object[][] celldata = {{"","","","",new Boolean(false)},{"","","","",new Boolean(false)},{"","","","",new Boolean(false)},
					{"","","","",new Boolean(false)},{"","","","",new Boolean(false)},{"","","","",new Boolean(false)},{"","","","",new Boolean(false)}
					,{"","","","",new Boolean(false)},{"","","","",new Boolean(false)},{"","","","",new Boolean(false)}};
			
			//���ñ������
			public void setData(Object[][] data){
				celldata = data;
				fireTableDataChanged();
			}

			
			//����ÿһ�е�����
			@Override
			public Class getColumnClass(int columnIndex) {
				if(columnIndex == 4){
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
				if(columnIndex==4){
					return true;
				}else{
					return false;
				}
			}
		}
		
		class PieChart {
			private String title;
		    private ChartPanel frame1;
		    public PieChart(String title){
		    	this.title=title;
		          DefaultPieDataset data = getDataSet();
		          JFreeChart chart = ChartFactory.createPieChart3D(title,data,true,false,false);
		        //���ðٷֱ�
		          PiePlot pieplot = (PiePlot) chart.getPlot();
		          DecimalFormat df = new DecimalFormat("0.00%");//���һ��DecimalFormat������Ҫ������С������
		          NumberFormat nf = NumberFormat.getNumberInstance();//���һ��NumberFormat����
		          StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//���StandardPieSectionLabelGenerator����
		          pieplot.setLabelGenerator(sp1);//���ñ�ͼ��ʾ�ٷֱ�
		       
		      //û�����ݵ�ʱ����ʾ������
		          pieplot.setNoDataMessage("��������ʾ");
		          pieplot.setCircular(false);
		          pieplot.setLabelGap(0.02D);
		       
		          pieplot.setIgnoreNullValues(true);//���ò���ʾ��ֵ
		          pieplot.setIgnoreZeroValues(true);//���ò���ʾ��ֵ
		         frame1=new ChartPanel (chart,true);
		          chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������
		          PiePlot piePlot= (PiePlot) chart.getPlot();//��ȡͼ���������
		          piePlot.setLabelFont(new Font("����",Font.BOLD,20));//�������
		          chart.getLegend().setItemFont(new Font("����",Font.BOLD,20));
		    }
		    
		    
		    private  DefaultPieDataset getDataSet() {
		        DefaultPieDataset dataset = new DefaultPieDataset();
		        ManagementSituationController msc = new ManagementSituationController(operator);
		        String begin=jyqk_start_year.getSelectedItem().toString()+jyqk_start_month.getSelectedItem().toString()+jyqk_start_day.getSelectedItem().toString();
				String end=jyqk_end_year.getSelectedItem().toString()+jyqk_end_month.getSelectedItem().toString()+jyqk_end_day.getSelectedItem().toString();
		        List<Double> list=msc.Situation(begin,end);
		        if(title.equals("������")){
		          dataset.setValue("��������",list.get(0));
		          dataset.setValue("��Ʒ������",list.get(1));
		          }
		        else{
		          dataset.setValue("���۳ɱ�",list.get(3));
		          dataset.setValue("��Ʒ��֧��",list.get(4));
		        	}	
		        return dataset;
		   }
		    public ChartPanel getChartPanel(){
		        return frame1;
		         
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
	
}