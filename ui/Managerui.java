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
	
	private String operator;//操作员
	private JFrame frame;
	private JPanel co_panel;//审批单据界面
	private JPanel xsmx_panel;//查看销售明细表界面
	private JPanel jylc_panel;//查看经营历程表界面
	private JPanel jyqk_panel;//查看经营情况表界面
	private JPanel mp_panel;//制订销售策略界面
	private JPanel imagePanel;//背景
	private JButton close;//关闭
	private JButton logout;//注销
	private JButton checkOrder;//审批单据
	private JButton xsmx;//销售明细
	private JButton jylc;//经营历程
	private JButton jyqk;//经营情况
	private JButton promotion;//制订销售策略
	private JComboBox order_Classification;//单据类型
	private JButton order_search;//查询
	private Mytable order_mytable;
	private JTable order_table;//单据列表
	private JButton co_pass;//审批通过
	private JButton co_unpass;//审批不通过
	private JComboBox xsmx_start_year;
	private JComboBox xsmx_start_month;
	private JComboBox xsmx_start_day;
	private JComboBox xsmx_end_year;
	private JComboBox xsmx_end_month;
	private JComboBox xsmx_end_day;
	private JComboBox goods_box;//商品
	private JComboBox customer_box;//客户
	private JTextField salesman_box;//业务员
	private JComboBox stock_box;//仓库
	private JTable xsmx_table;//销售明细表
	private JButton xsmx_confirm;
	private JButton xsmx_cancel;
	private JComboBox promotion_classification;//促销类型
	private JPanel level_promotion;//针对级别
	private JPanel goods_promotion;//针对组合商品
	private JPanel money_promotion;//针对总价
	private JComboBox mp_start_year;
	private JComboBox mp_start_month;
	private JComboBox mp_start_day;
	private JComboBox mp_end_year;
	private JComboBox mp_end_month;
	private JComboBox mp_end_day;
	private JComboBox level_box;
	private JTable level_table;//赠品选择表
	private Mytable1 level_grant_table;
	private JTable goods_table;//组合商品选择表
	private Mytable2 goods_mytable;
	private JTable money_table;//赠品选择表
	private Mytable1 money_grant_table;
	private JTextField discount;//折让
	private JTextField voucher;//代金券
	private JButton level_confirm;
	private JButton level_cancel;
	private JTextField addUp;//总价
	private JTextField bargain;//特价
	private JButton goods_confirm;
	private JButton goods_cancel;
	private JTextField money;//最低额度
	private JTextField voucher1;//代金券
	private JButton money_confirm;
	private JButton money_cancel;
	private JComboBox jylc_start_year;
	private JComboBox jylc_start_month;
	private JComboBox jylc_start_day;
	private JComboBox jylc_end_year;
	private JComboBox jylc_end_month;
	private JComboBox jylc_end_day;
	private JComboBox oc;//单据类型
	private JComboBox jylc_customer;//客户
	private JTextField jylc_salesman;//业务员
	private JComboBox jylc_stock;//仓库
	private Mytable jylc_mytable;
	private JTable jylcOrder_table;//单据列表
	private JButton jylc_confirm;//
	private JButton jylc_cancel;//
	private JTable jyqkOrder_table;//单据列表
	private JComboBox jyqk_start_year;
	private JComboBox jyqk_start_month;
	private JComboBox jyqk_start_day;
	private JComboBox jyqk_end_year;
	private JComboBox jyqk_end_month;
	private JComboBox jyqk_end_day;
	private JButton jyqk_analyse;
	private JButton jyqk_export;
	private JTextField sale_income;//销售收入
	private JTextField goods_income;//商品类收入
	private JTextField discount_income;//折让
	private JTextField sale_outcome;//销售支出
	private JTextField goods_outcome;//商品类支出
	private JTextField addup_income;//总收入
	private JTextField addup_outcome;//总支出
	private JTextField profit;//利润
	private JButton jyqk_confirm;
	private JButton jyqk_cancel;
	private JButton checkLog;//查看日志
	private JFrame checkLog_frame;
	
	public static void main(String args[]){
		new Managerui("总经理");
	}
	public Managerui(String operator){
		//操作员
		this.operator = operator;
		//设置字体
		Font font0 = new Font("Default",Font.BOLD,30);
		Font font = new Font("Default",Font.BOLD,20);
		Font font1 = new Font("Default",Font.BOLD,25);
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(830, 650);
		frame.setLocation(600, 230);
		//加入标题
		JLabel title = new JLabel("<html>灯具进销存系统<br>(PSIS)<html/>");
		title.setFont(font0);
		title.setSize(250,80);
		title.setLocation(20,20);
		title.setForeground(Color.pink);
		frame.getContentPane().add(title);
		/*
		 * 关闭
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
		 * 注销
		 */
		logout = new JButton("注销       ");
		logout.addActionListener(new ButtonActionListener());
		logout.setLocation(0,580);
		logout.setSize(150,70);
		logout.setFont(font);
		logout.setForeground(Color.red);
		logout.setContentAreaFilled(false);
		logout.setFocusPainted(false);
		ImageIcon logout_icon = new ImageIcon("电源.png");
		JLabel logout_label = new JLabel(logout_icon);
		logout_label.setLocation(88,590);
		logout_label.setSize(logout_icon.getIconWidth(),logout_icon.getIconHeight());
		frame.getContentPane().add(logout_label);
		frame.getContentPane().add(logout);
		/*
		 * 查看日志
		 */
		checkLog = new JButton("    查看日志 ");
		checkLog.addActionListener(new ButtonActionListener());
		checkLog.setLocation(0,520);
		checkLog.setSize(230,60);
		checkLog.setFont(font);
		checkLog.setForeground(Color.white);
		checkLog.setContentAreaFilled(false);
		checkLog.setFocusPainted(false);
		ImageIcon checkLog_icon = new ImageIcon("文件.png");
		JLabel checkLog_label = new JLabel(checkLog_icon);
		checkLog_label.setLocation(30,530);
		checkLog_label.setSize(checkLog_icon.getIconWidth(),checkLog_icon.getIconHeight());
		frame.getContentPane().add(checkLog_label);
		frame.getContentPane().add(checkLog);
		/*
		 * 审批单据按钮
		 */
		checkOrder = new JButton("审批单据");
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
		 * 查看销售明细表按钮
		 */
		xsmx = new JButton("    查看销售明细表");
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
		 * 查看经营历程表按钮
		 */
		jylc = new JButton("    查看经营历程表");
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
		 * 查看经营情况表按钮
		 */
		jyqk = new JButton("    查看经营情况表");
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
		 * 制订销售策略按钮
		 */
		promotion = new JButton(" 制订销售策略");
		promotion.addActionListener(new ButtonActionListener());
		promotion.setLocation(0,440);
		promotion.setSize(230,80);
		promotion.setFont(font);
		promotion.setForeground(Color.white);
		promotion.setFocusPainted(false);
		promotion.setContentAreaFilled(false);
		frame.getContentPane().add(promotion);
		ImageIcon promotion_icon = new ImageIcon("文件.png");
		JLabel promotion_label = new JLabel(promotion_icon);
		promotion_label.setLocation(10,465);
		promotion_label.setSize(promotion_icon.getIconWidth(),promotion_icon.getIconHeight());
		frame.getContentPane().add(promotion_label);
		
		/*
		 *审批单据界面
		 */
		co_panel = new JPanel();
		co_panel.setLayout(null);
		co_panel.setLocation(260,50);
		co_panel.setSize(460,550);
		co_panel.setOpaque(true);
		co_panel.setBackground(Color.cyan);
		/*
		 * 筛选条件
		 */
		//单据类型
		JLabel oc_label = new JLabel("单据类型");
		oc_label.setLocation(30,30);
		oc_label.setSize(150,30);
		oc_label.setFont(font1);
		oc_label.setForeground(Color.black);
		co_panel.add(oc_label);
		order_search = new JButton("查询");
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
		order_Classification.addItem("销售类单据");
		order_Classification.addItem("进货类单据");
		order_Classification.addItem("财务类单据");
		order_Classification.addItem("库存类单据");
		order_Classification.setBackground(Color.white);
		order_Classification.setFont(font1);
		co_panel.add(order_Classification);
		//单据列表
		JLabel order_table_label = new JLabel("单据列表");
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
		 * button控件
		 */
		co_pass = new JButton("通过");
		co_pass.addActionListener(new ButtonActionListener());
		co_pass.setLocation(300,490);
		co_pass.setSize(100,50);
		co_pass.setFont(font);
		co_pass.setForeground(Color.magenta);
		co_pass.setFocusPainted(false);
		co_panel.add(co_pass);
		co_unpass = new JButton("驳回");
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
		 * 查看销售明细界面
		 */
		xsmx_panel = new JPanel();
		xsmx_panel.setLayout(null);
		xsmx_panel.setLocation(260,50);
	    xsmx_panel.setSize(490,550);
		xsmx_panel.setLayout(null);
		xsmx_panel.setBackground(Color.cyan);
		xsmx_panel.setOpaque(true);
		/*
	     * 查询条件
		 */
		//起止时间
		JLabel start = new JLabel("开始日期");
		start.setLocation(20,10);
		start.setSize(100,40);
		start.setFont(font);
		start.setForeground(Color.magenta);
		xsmx_panel.add(start);
		JLabel end = new JLabel("结束日期");
		end.setLocation(20,60);
		end.setSize(100,40);
		end.setFont(font);
		end.setForeground(Color.magenta);
		xsmx_panel.add(end);
		//开始年份
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
		JLabel label_year = new JLabel("年");
		label_year.setLocation(210,10);
		label_year.setSize(50,40);
		label_year.setFont(font);
		label_year.setForeground(Color.black);
		xsmx_panel.add(label_year);
		//结束年份
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
		JLabel label_year1 = new JLabel("年");
		label_year1.setLocation(210,60);
		label_year1.setSize(50,50);
		label_year1.setFont(font);
		label_year1.setForeground(Color.black);
		xsmx_panel.add(label_year1);
		Object[] day = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17"
				,"18","19","20","21","22","23","24","25","26","27","28"};
		//开始月份
		xsmx_start_month = new JComboBox();
		xsmx_start_day = new JComboBox(day);
		xsmx_start_month.addItemListener(new boxItemListener());//添加监听事件
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
		JLabel label_month = new JLabel("月");
		label_month.setLocation(340,10);
		label_month.setSize(50,40);
		label_month.setForeground(Color.black);
		label_month.setFont(font);
		xsmx_panel.add(label_month);
		//结束月份
		xsmx_end_month = new JComboBox();
		xsmx_end_day = new JComboBox(day);
		xsmx_end_month.addItemListener(new boxItemListener());//添加监听事件
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
		JLabel label_month1 = new JLabel("月");
		label_month1.setLocation(340,60);
		label_month1.setSize(50,40);
		label_month1.setForeground(Color.black);
		label_month1.setFont(font);
		xsmx_panel.add(label_month1);
		//开始日期
		xsmx_start_day.setMaximumRowCount(10);
		xsmx_start_day.setLocation(375,10);
		xsmx_start_day.setSize(80,40);
		xsmx_start_day.setFont(font);
		xsmx_start_day.setEditable(false);
		xsmx_start_day.setBackground(Color.white);
		xsmx_panel.add(xsmx_start_day);
		JLabel label_day = new JLabel("日");
		label_day.setLocation(465,10);
		label_day.setSize(50,50);
		label_day.setForeground(Color.black);
		label_day.setFont(font);
		xsmx_panel.add(label_day);
		//结束日期
		xsmx_end_day.setMaximumRowCount(10);
		xsmx_end_day.setLocation(375,60);
		xsmx_end_day.setSize(80,40);
		xsmx_end_day.setFont(font);
		xsmx_end_day.setEditable(false);
		xsmx_end_day.setBackground(Color.white);
		xsmx_panel.add(xsmx_end_day);
		JLabel label_day1 = new JLabel("日");
		label_day1.setLocation(465,60);
		label_day1.setSize(50,50);
		label_day1.setForeground(Color.black);
		label_day1.setFont(font);
		xsmx_panel.add(label_day1);
		//商品名
		JLabel goods_box_label = new JLabel("商品名");
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
		//客户
		JLabel customer_box_label = new JLabel("客户");
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
		//业务员
		JLabel salesman_box_label = new JLabel("业务员");
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
		//仓库
		JLabel stock_box_label = new JLabel("仓库");
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
		 * 销售明细表
		 */
		Object[][] xsmx_data = {{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""}
		,{"","","","","",""},{"","","","","",""},{"","","","","",""}};
		String[] columnName = {"时间","商品名","型号","数量","单价","总额"};
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
		 * button控件
		 */
		//取消
		xsmx_cancel = new JButton("取消");
		xsmx_cancel.setLocation(60,490);
		xsmx_cancel.setSize(80,50);
		xsmx_cancel.setFont(font);
	    xsmx_cancel.setForeground(Color.magenta);
	    xsmx_cancel.setFocusPainted(false);
	    xsmx_panel.add(xsmx_cancel);
		//确认
		xsmx_confirm = new JButton("确认");
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
	     * 制订销售策略界面
	     */
	    mp_panel = new JPanel();
	    mp_panel.setLayout(null);
	    mp_panel.setLocation(260,50);
	    mp_panel.setSize(460,550);
	    mp_panel.setBackground(Color.cyan);
	    mp_panel.setOpaque(true);
	    //促销类型
	    JLabel pc_label = new JLabel("促销类型");
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
	    promotion_classification.addItem("级别促销");
	    promotion_classification.addItem("组合商品促销");
	    promotion_classification.addItem("总价促销");
	    promotion_classification.setLocation(200,10);
	    promotion_classification.setSize(170,50);
	    promotion_classification.setFont(font);
	    promotion_classification.setBackground(Color.white);
	    mp_panel.add(promotion_classification);
	    /*
	     * 促销时限
	     */
	    JLabel mp_start = new JLabel("开始日期");
	    mp_start.setLocation(0,70);
	    mp_start.setSize(100,40);
	    mp_start.setFont(font);
	    mp_start.setForeground(Color.magenta);
		mp_panel.add(mp_start);
		JLabel mp_end = new JLabel("结束日期");
		mp_end.setLocation(0,120);
		mp_end.setSize(100,40);
		mp_end.setFont(font);
		mp_end.setForeground(Color.magenta);
		mp_panel.add(mp_end);
		//开始年份
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
		JLabel mp_label_year = new JLabel("年");
		mp_label_year.setLocation(190,70);
		mp_label_year.setSize(50,40);
		mp_label_year.setFont(font);
		mp_label_year.setForeground(Color.black);
		mp_panel.add(mp_label_year);
		//结束年份
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
		JLabel mp_label_year1 = new JLabel("年");
		mp_label_year1.setLocation(190,120);
		mp_label_year1.setSize(50,50);
		mp_label_year1.setFont(font);
		mp_label_year1.setForeground(Color.black);
		mp_panel.add(mp_label_year1);
		//开始月份
		mp_start_month = new JComboBox();
		mp_start_day = new JComboBox(day);
		mp_start_month.addItemListener(new boxItemListener());//添加监听事件
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
		JLabel mp_label_month = new JLabel("月");
		mp_label_month.setLocation(310,70);
		mp_label_month.setSize(50,40);
		mp_label_month.setForeground(Color.black);
		mp_label_month.setFont(font);
		mp_panel.add(mp_label_month);
		//结束月份
		mp_end_month = new JComboBox();
		mp_end_day = new JComboBox(day);
		mp_end_month.addItemListener(new boxItemListener());//添加监听事件
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
		JLabel mp_label_month1 = new JLabel("月");
		mp_label_month1.setLocation(310,120);
		mp_label_month1.setSize(50,40);
		mp_label_month1.setForeground(Color.black);
		mp_label_month1.setFont(font);
		mp_panel.add(mp_label_month1);
		//开始日期
		mp_start_day.setMaximumRowCount(10);
		mp_start_day.setLocation(345,70);
		mp_start_day.setSize(80,40);
		mp_start_day.setFont(font);
		mp_start_day.setEditable(false);
		mp_start_day.setBackground(Color.white);
		mp_panel.add(mp_start_day);
		JLabel mp_label_day = new JLabel("日");
		mp_label_day.setLocation(435,70);
		mp_label_day.setSize(50,50);
		mp_label_day.setForeground(Color.black);
		mp_label_day.setFont(font);
		mp_panel.add(mp_label_day);
		//结束日期
		mp_end_day.setMaximumRowCount(10);
		mp_end_day.setLocation(345,120);
		mp_end_day.setSize(80,40);
		mp_end_day.setFont(font);
		mp_end_day.setEditable(false);
		mp_end_day.setBackground(Color.white);
		mp_panel.add(mp_end_day);
		JLabel mp_label_day1 = new JLabel("日");
		mp_label_day1.setLocation(435,120);
		mp_label_day1.setSize(50,50);
		mp_label_day1.setForeground(Color.black);
		mp_label_day1.setFont(font);
		mp_panel.add(mp_label_day1);
	    /*
	     * 级别促销界面
	     */
	    level_promotion.setLocation(0,170);
	    level_promotion.setSize(460,380);
	    level_promotion.setLayout(null);
	    level_promotion.setBackground(Color.cyan);
	    //级别
	    JLabel level_label = new JLabel("级别");
	    level_label.setLocation(10,0);
	    level_label.setSize(100,50);
	    level_label.setFont(font);
	    level_promotion.add(level_label);
	    level_box = new JComboBox();
	    level_box.addItem("一级");
	    level_box.addItem("二级");
	    level_box.addItem("三级");
	    level_box.addItem("四级");
	    level_box.addItem("五级");
	    level_box.setLocation(60,5);
	    level_box.setSize(80,40);
	    level_box.setFont(font);
	    level_box.setBackground(Color.white);
	    level_promotion.add(level_box);
	    //折让
	    JLabel discount_label = new JLabel("折让");
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
	  	//代金券
	  	JLabel voucher_label = new JLabel("代金券");
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
	     * 赠品选择表
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
		 * button控件
		 */
		//确认
		level_confirm = new JButton("确认");
		level_confirm.addActionListener(new ButtonActionListener());
		level_confirm.setLocation(330,325);
		level_confirm.setSize(80,50);
		level_confirm.setFont(font);
		level_confirm.setForeground(Color.magenta);
		level_confirm.setFocusPainted(false);
		level_promotion.add(level_confirm);
		//取消
		level_cancel = new JButton("取消");
		level_cancel.setLocation(50,325);
		level_cancel.setSize(80,50);
		level_cancel.setFont(font);
		level_cancel.setForeground(Color.magenta);
		level_cancel.setFocusPainted(false);
		level_promotion.add(level_cancel);
	    level_promotion.setVisible(true);
	    mp_panel.add(level_promotion);
	    /*
	     * 商品组合促销界面
	     */
	    goods_promotion.setLocation(0,170);
	    goods_promotion.setSize(460,380);
	    goods_promotion.setLayout(null);
	    goods_promotion.setBackground(Color.cyan);
	    //商品选择列表
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
		//总价、组合特价
		JLabel addUp_label = new JLabel("总价");
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
		JLabel bargain_label = new JLabel("组合特价");
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
		//确认、取消
		goods_confirm = new JButton("确认");
		goods_confirm.addActionListener(new ButtonActionListener());
		goods_confirm.setLocation(330,325);
		goods_confirm.setSize(80,50);
		goods_confirm.setFont(font);
		goods_confirm.setForeground(Color.magenta);
		goods_confirm.setFocusPainted(false);
		goods_promotion.add(goods_confirm);
		goods_cancel = new JButton("取消");
		goods_cancel.setLocation(50,325);
		goods_cancel.setSize(80,50);
		goods_cancel.setFont(font);
		goods_cancel.setForeground(Color.magenta);
		goods_cancel.setFocusPainted(false);
		goods_promotion.add(goods_cancel);
	    goods_promotion.setVisible(false);
	    mp_panel.add(goods_promotion);
	    /*
	     * 总价促销界面
	     */
	    money_promotion.setLocation(0,170);
	    money_promotion.setSize(460,380);
	    money_promotion.setLayout(null);
	    money_promotion.setBackground(Color.cyan);
	    //赠品表
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
		//总价额度、代金券
		JLabel all_label = new JLabel("最低额度");
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
	  	//代金券
	  	JLabel voucher1_label = new JLabel("代金券");
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
	    //确认、取消
	  	money_confirm = new JButton("确认");
	  	money_confirm.addActionListener(new ButtonActionListener());
	  	money_confirm.setLocation(330,325);
	  	money_confirm.setSize(80,50);
	  	money_confirm.setFont(font);
	  	money_confirm.setForeground(Color.magenta);
	  	money_confirm.setFocusPainted(false);
	  	money_promotion.add(money_confirm);
	  	money_cancel = new JButton("取消");
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
	     * 查看经营历程表界面
	     */
	    jylc_panel = new JPanel();
	    jylc_panel.setLayout(null);
	    jylc_panel.setLocation(260,20);
	    jylc_panel.setSize(490,610);
	    jylc_panel.setLayout(null);
	    jylc_panel.setBackground(Color.cyan);
	    jylc_panel.setOpaque(true);
	    /*
	     * 查询条件
	     */
	    //起止日期
	    JLabel jylc_start = new JLabel("开始日期");
	    jylc_start.setLocation(0,20);
	    jylc_start.setSize(100,40);
	    jylc_start.setFont(font);
	    jylc_start.setForeground(Color.magenta);
	    jylc_panel.add(jylc_start);
		JLabel jylc_end = new JLabel("结束日期");
		jylc_end.setLocation(0,70);
		jylc_end.setSize(100,40);
		jylc_end.setFont(font);
		jylc_end.setForeground(Color.magenta);
		jylc_panel.add(jylc_end);
		//开始年份
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
		JLabel jylc_label_year = new JLabel("年");
		jylc_label_year.setLocation(190,20);
		jylc_label_year.setSize(50,40);
		jylc_label_year.setFont(font);
		jylc_label_year.setForeground(Color.black);
		jylc_panel.add(jylc_label_year);
		//结束年份
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
		JLabel jylc_label_year1 = new JLabel("年");
		jylc_label_year1.setLocation(190,70);
		jylc_label_year1.setSize(50,50);
		jylc_label_year1.setFont(font);
		jylc_label_year1.setForeground(Color.black);
		jylc_panel.add(jylc_label_year1);
		//开始月份
		jylc_start_month = new JComboBox();
		jylc_start_day = new JComboBox(day);
		jylc_start_month.addItemListener(new boxItemListener());//添加监听事件
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
		JLabel jylc_label_month = new JLabel("月");
		jylc_label_month.setLocation(310,20);
		jylc_label_month.setSize(50,40);
		jylc_label_month.setForeground(Color.black);
		jylc_label_month.setFont(font);
		jylc_panel.add(jylc_label_month);
		//结束月份
		jylc_end_month = new JComboBox();
		jylc_end_day = new JComboBox(day);
		jylc_end_month.addItemListener(new boxItemListener());//添加监听事件
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
		JLabel jylc_label_month1 = new JLabel("月");
		jylc_label_month1.setLocation(310,70);
		jylc_label_month1.setSize(50,40);
		jylc_label_month1.setForeground(Color.black);
		jylc_label_month1.setFont(font);
		jylc_panel.add(jylc_label_month1);
		//开始日期
		jylc_start_day.setMaximumRowCount(10);
		jylc_start_day.setLocation(345,20);
		jylc_start_day.setSize(80,40);
		jylc_start_day.setFont(font);
		jylc_start_day.setEditable(false);
		jylc_start_day.setBackground(Color.white);
		jylc_panel.add(jylc_start_day);
		JLabel jylc_label_day = new JLabel("日");
		jylc_label_day.setLocation(435,20);
		jylc_label_day.setSize(50,50);
		jylc_label_day.setForeground(Color.black);
		jylc_label_day.setFont(font);
		jylc_panel.add(jylc_label_day);
		//结束日期
		jylc_end_day.setMaximumRowCount(10);
		jylc_end_day.setLocation(345,70);
		jylc_end_day.setSize(80,40);
		jylc_end_day.setFont(font);
		jylc_end_day.setEditable(false);
		jylc_end_day.setBackground(Color.white);
		jylc_panel.add(jylc_end_day);
		JLabel jylc_label_day1 = new JLabel("日");
		jylc_label_day1.setLocation(435,70);
		jylc_label_day1.setSize(50,50);
		jylc_label_day1.setForeground(Color.black);
		jylc_label_day1.setFont(font);
		jylc_panel.add(jylc_label_day1);
		//单据类型
		JLabel oc_label1 = new JLabel("单据类型");
		oc_label1.setLocation(10,125);
		oc_label1.setSize(120,30);
		oc_label1.setFont(font);
		jylc_panel.add(oc_label1);
		oc = new JComboBox();
		oc.setLocation(110,120);
		oc.setSize(150,40);
		oc.setFont(font);
		oc.addItem("销售类单据");
		oc.addItem("进货类单据");
		oc.addItem("财务类单据");
		oc.addItem("库存类单据");
		oc.setEditable(false);
		oc.setBackground(Color.white);
		jylc_panel.add(oc);
		//客户
		JLabel jc_label = new JLabel("客户");
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
		//业务员
		JLabel js_label = new JLabel("业务员");
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
		//仓库
		JLabel jst_label = new JLabel("仓库");
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
		//单据列表
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
	    //确认、取消
	    jylc_confirm = new JButton("确认");
	    jylc_confirm.addActionListener(new ButtonActionListener());
	    jylc_confirm.setLocation(340,545);
	    jylc_confirm.setSize(100,50);
	    jylc_confirm.setFont(font);
	    jylc_confirm.setForeground(Color.magenta);
	    jylc_confirm.setFocusPainted(false);
	    jylc_panel.add(jylc_confirm);
	    jylc_cancel = new JButton("取消");
	    jylc_cancel.setLocation(50,545);
	    jylc_cancel.setSize(100,50);
	    jylc_cancel.setFont(font);
	    jylc_cancel.setForeground(Color.magenta);
	    jylc_cancel.setFocusPainted(false);
	    jylc_panel.add(jylc_cancel);
		jylc_panel.setVisible(false);
		frame.getContentPane().add(jylc_panel);
		
		/*
		 * 查看经营情况表界面
		 */
		jyqk_panel = new JPanel();
		jyqk_panel.setLayout(null);
	    jyqk_panel.setLocation(260,20);
	    jyqk_panel.setSize(490,610);
	    jyqk_panel.setLayout(null);
	    jyqk_panel.setBackground(Color.cyan);
	    jyqk_panel.setOpaque(true);
	    /*
	     * 查询条件
	     */
	    //起止日期
	    JLabel jyqk_start = new JLabel("开始日期");
	    jyqk_start.setLocation(0,20);
	    jyqk_start.setSize(100,40);
	    jyqk_start.setFont(font);
	    jyqk_start.setForeground(Color.magenta);
	    jyqk_panel.add(jyqk_start);
		JLabel jyqk_end = new JLabel("结束日期");
		jyqk_end.setLocation(0,70);
		jyqk_end.setSize(100,40);
		jyqk_end.setFont(font);
		jyqk_end.setForeground(Color.magenta);
		jyqk_panel.add(jyqk_end);
		//开始年份
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
		JLabel jyqk_label_year = new JLabel("年");
		jyqk_label_year.setLocation(190,20);
		jyqk_label_year.setSize(50,40);
		jyqk_label_year.setFont(font);
		jyqk_label_year.setForeground(Color.black);
		jyqk_panel.add(jyqk_label_year);
		//结束年份
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
		JLabel jyqk_label_year1 = new JLabel("年");
		jyqk_label_year1.setLocation(190,65);
		jyqk_label_year1.setSize(50,50);
		jyqk_label_year1.setFont(font);
		jyqk_label_year1.setForeground(Color.black);
		jyqk_panel.add(jyqk_label_year1);
		//开始月份
		jyqk_start_month = new JComboBox();
		jyqk_start_day = new JComboBox(day);
		jyqk_start_month.addItemListener(new boxItemListener());//添加监听事件
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
		JLabel jyqk_label_month = new JLabel("月");
		jyqk_label_month.setLocation(310,20);
		jyqk_label_month.setSize(50,40);
		jyqk_label_month.setForeground(Color.black);
		jyqk_label_month.setFont(font);
		jyqk_panel.add(jyqk_label_month);
		//结束月份
		jyqk_end_month = new JComboBox();
		jyqk_end_day = new JComboBox(day);
		jyqk_end_month.addItemListener(new boxItemListener());//添加监听事件
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
		JLabel jyqk_label_month1 = new JLabel("月");
		jyqk_label_month1.setLocation(310,70);
		jyqk_label_month1.setSize(50,40);
		jyqk_label_month1.setForeground(Color.black);
		jyqk_label_month1.setFont(font);
		jyqk_panel.add(jyqk_label_month1);
		//开始日期
		jyqk_start_day.setMaximumRowCount(10);
		jyqk_start_day.setLocation(345,20);
		jyqk_start_day.setSize(80,40);
		jyqk_start_day.setFont(font);
		jyqk_start_day.setEditable(false);
		jyqk_start_day.setBackground(Color.white);
		jyqk_panel.add(jyqk_start_day);
		JLabel jyqk_label_day = new JLabel("日");
		jyqk_label_day.setLocation(435,15);
		jyqk_label_day.setSize(50,50);
		jyqk_label_day.setForeground(Color.black);
		jyqk_label_day.setFont(font);
		jyqk_panel.add(jyqk_label_day);
		//结束日期
		jyqk_end_day.setMaximumRowCount(10);
		jyqk_end_day.setLocation(345,70);
		jyqk_end_day.setSize(80,40);
		jyqk_end_day.setFont(font);
		jyqk_end_day.setEditable(false);
		jyqk_end_day.setBackground(Color.white);
		jyqk_panel.add(jyqk_end_day);
		JLabel jyqk_label_day1 = new JLabel("日");
		jyqk_label_day1.setLocation(435,65);
		jyqk_label_day1.setSize(50,50);
		jyqk_label_day1.setForeground(Color.black);
		jyqk_label_day1.setFont(font);
		jyqk_panel.add(jyqk_label_day1);
		/*
		 * 信息显示
		 */
		//收入类
		JLabel income_label = new JLabel("收入类:");
		income_label.setLocation(20,135);
		income_label.setSize(150,30);
		income_label.setFont(font1);
		income_label.setForeground(Color.red);
		jyqk_panel.add(income_label);
		//销售收入
		JLabel saleIC_label = new JLabel("销售收入");
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
		//商品类收入
		JLabel goodsIC_label = new JLabel("商品收入");
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
		//折让
		JLabel discount_label1 = new JLabel("折让");
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
		//支出类
		JLabel outcome_label = new JLabel("支出类:");
		outcome_label.setLocation(20,300);
		outcome_label.setSize(150,30);
		outcome_label.setFont(font1);
		outcome_label.setForeground(Color.red);
		jyqk_panel.add(outcome_label);
		//销售支出
		JLabel saleOC_label = new JLabel("销售支出");
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
		//商品支出
		JLabel goodsOC_label = new JLabel("商品支出");
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
		//总收入
		JLabel addupIC_label = new JLabel("总收入");
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
		//总支出
		JLabel addupOC_label = new JLabel("总支出");
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
		//利润
		JLabel profit_label = new JLabel("利润");
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
		 * 确认、取消
		 */
		//导出EXCEL
		jyqk_export = new JButton("导出EXCEL");
		jyqk_export.addActionListener(new ButtonActionListener());
		jyqk_export.setLocation(330,530);
		jyqk_export.setSize(150,50);
		jyqk_export.setFont(font);
		jyqk_export.setForeground(Color.magenta);
		jyqk_export.setFocusPainted(false);
		jyqk_panel.add(jyqk_export);
		//图形分析
		jyqk_analyse = new JButton("图形分析");
		jyqk_analyse.addActionListener(new ButtonActionListener());
		jyqk_analyse.setLocation(200,530);
		jyqk_analyse.setSize(120,50);
		jyqk_analyse.setFont(font);
		jyqk_analyse.setForeground(Color.magenta);
		jyqk_analyse.setFocusPainted(false);
		jyqk_panel.add(jyqk_analyse);
		//确认
		jyqk_confirm = new JButton("确认");
		jyqk_confirm.addActionListener(new ButtonActionListener());
		jyqk_confirm.setLocation(110,530);
		jyqk_confirm.setSize(80,50);
		jyqk_confirm.setFont(font);
		jyqk_confirm.setForeground(Color.magenta);
		jyqk_confirm.setFocusPainted(false);
		jyqk_panel.add(jyqk_confirm);
		//取消
		jyqk_cancel = new JButton("取消");
		jyqk_cancel.setLocation(20,530);
		jyqk_cancel.setSize(80,50);
		jyqk_cancel.setFont(font);
		jyqk_cancel.setForeground(Color.magenta);
		jyqk_cancel.setFocusPainted(false);
		jyqk_panel.add(jyqk_cancel);
		jyqk_panel.setVisible(false);
		frame.getContentPane().add(jyqk_panel);
		
		//加入背景图片
		imagePanel = new ImageJPanel(new ImageIcon("主背景.jpg").getImage());
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
				//赠品表
				GoodsController gc = new GoodsController("总经理");
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
				if(type.equals("销售类单据")){
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
							data[i][2]="销售单";
							data[i][3]=new Boolean(false);
						}
						if(listcustomer.size()!=0){
						for(int i=listcustomer.size();i<listcustomer.size()+listcustomer2.size();i++){
							data[i][0]=listcustomer2.get(i-listcustomer.size()).getNumber();
							data[i][1]=listcustomer2.get(i-listcustomer.size()).getDate();
							data[i][2]="销售退货单";
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
							data[i][2]="销售单";
							data[i][3]=new Boolean(false);
						}
						if(list.size()!=0){
						for(int i=list.size();i<list.size()+list2.size();i++){
							data[i][0]=list2.get(i-list.size()).getNumber();
							data[i][1]=list2.get(i-list.size()).getDate();
							data[i][2]="销售退货单";
							data[i][3]=new Boolean(false);
							}
						}
						jylc_mytable.setData(data);
					}
				}
				else if(type.equals("进货类单据")){
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
							data[i][2]="进货单";
							data[i][3]=new Boolean(false);
						}
						if(listcustomer2.size()!=0){
						for(int i=listcustomer.size();i<listcustomer.size()+listcustomer2.size();i++){
							data[i][0]=listcustomer2.get(i-listcustomer.size()).getNumber();
							data[i][1]=listcustomer2.get(i-listcustomer.size()).getDate();
							data[i][2]="进货退货单";
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
							data[i][2]="进货单";
							data[i][3]=new Boolean(false);
						}
						if(list.size()!=0){
						for(int i=list.size();i<list.size()+list2.size();i++){
							data[i][0]=list2.get(i-list.size()).getNumber();
							data[i][1]=list2.get(i-list.size()).getDate();
							data[i][2]="进货退货单";
							data[i][3]=new Boolean(false);
							}
						}
						jylc_mytable.setData(data);
					}
				}
				else if(type.equals("财务类单据")){
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
						data[i][2]="现金费用单";
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
							data[i][2]="收款单";
							data[i][3]=new Boolean(false);
							}
						}
						if(listcustomer2.size()!=0){
						for(int i=listcustomer.size()+list3.size();i<listcustomer.size()+listcustomer2.size()+list3.size();i++){
							data[i][0]=listcustomer2.get(i-list3.size()-listcustomer.size()).getNumber();
							data[i][1]=listcustomer2.get(i-list3.size()-listcustomer.size()).getDate();
							data[i][2]="付款单";
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
							data[i][2]="收款单";
							data[i][3]=new Boolean(false);
							}
						}
						if(list2.size()!=0){
						for(int i=list.size()+list3.size();i<list.size()+list2.size()+list3.size();i++){
							data[i][0]=list2.get(i-list3.size()-list.size()).getNumber();
							data[i][1]=list2.get(i-list3.size()-list.size()).getDate();
							data[i][2]="付款单";
							data[i][3]=new Boolean(false);
							}
						}
						jylc_mytable.setData(data);
					}		
				}
				else if(type.equals("库存类单据")){
					List<StockLossOrderVO> list=bcc.queryStockLossOrder(begin, end);
					List<StockOverflowOrderVO> list2=bcc.queryStockOverflowOrder(begin, end);
					List<StockGrantOrderVO> list3=bcc.queryStockGrantOrder(begin, end);
					Object[][] data = new Object[list.size()+list2.size()+list3.size()][4];
					for(int i=0;i<list.size();i++){
						data[i][0]=list.get(i).getOrdernumber2();
						data[i][1]=list.get(i).getDate();
						data[i][2]="库存报损单";
						data[i][3]=new Boolean(false);
					}
					if(list2.size()!=0){
					for(int i=list.size();i<list.size()+list2.size();i++){
						data[i][0]=list2.get(i-list.size()).getOrdernumber2();
						data[i][1]=list2.get(i-list.size()).getDate();
						data[i][2]="库存报溢单";
						data[i][3]=new Boolean(false);
						}
					}
					if(list3.size()!=0){					
					for(int i=list.size()+list2.size();i<list.size()+list2.size()+list3.size();i++){
						data[i][0]=list3.get(i-list.size()-list2.size()).getOrdernumber2();
						data[i][1]=list3.get(i-list.size()-list2.size()).getDate();
						data[i][2]="库存赠送单";
						data[i][3]=new Boolean(false);
						}
					}
					jylc_mytable.setData(data);
				}
				GoodsClassificationController aqa=new GoodsClassificationController(operator);
				aqa.insertLog("查看经营历程表");
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
				sale_income.setText(String.valueOf(list.get(0)));//销售收入
				goods_income.setText(String.valueOf(list.get(1)));//商品类收入
				discount_income.setText(String.valueOf(list.get(2)));;//折让
				sale_outcome.setText(String.valueOf(list.get(3)));//销售支出
				goods_outcome.setText(String.valueOf(list.get(4)));;//商品类支出
				addup_income.setText(String.valueOf(list.get(0)+list.get(1)));;//总收入
				addup_outcome.setText(String.valueOf(list.get(3)+list.get(4)));;//总支出
				profit.setText(String.valueOf(list.get(0)+list.get(1)-list.get(3)-list.get(4)));
				GoodsClassificationController aqa=new GoodsClassificationController(operator);
				aqa.insertLog("查看经营情况表");
			}
			else if(e.getSource()==level_confirm){
				LevelPromotionVO vo=new LevelPromotionVO();
				vo.setBegintime(mp_start_year.getSelectedItem().toString()+mp_start_month.getSelectedItem().toString()+mp_start_day.getSelectedItem().toString());
				vo.setEndtime(mp_end_year.getSelectedItem().toString()+mp_end_month.getSelectedItem().toString()+mp_end_day.getSelectedItem().toString());
				if(level_box.getSelectedItem().equals("一级"))
					vo.setLevel(1);
				else if(level_box.getSelectedItem().equals("二级"))
					vo.setLevel(2);
				else if(level_box.getSelectedItem().equals("三级"))
					vo.setLevel(3);
				else if(level_box.getSelectedItem().equals("四级"))
					vo.setLevel(4);
				else if(level_box.getSelectedItem().equals("五级"))
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
				JOptionPane.showMessageDialog(frame.getContentPane(), "提交成功！");
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
				JOptionPane.showMessageDialog(frame.getContentPane(), "提交成功！");
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
				JOptionPane.showMessageDialog(frame.getContentPane(), "提交成功！");
			}
			else if(e.getSource()==order_search){
				String cl=order_Classification.getSelectedItem().toString();
				if(cl.equals("销售类单据")){
					CheckSalesController csc=new CheckSalesController(operator);
					List<SalesOrderVO> sales=csc.querySalesOrder();
					List<SalesBackOrderVO> salesback=csc.querySalesBackOrder();
					Object list[][]=new Object[sales.size()+salesback.size()][4];
					for(int i=0;i<sales.size();i++){
						list[i][0]=sales.get(i).getNumber();
						list[i][1]=sales.get(i).getDate();
						list[i][2]="销售单";
						list[i][3]=new Boolean(false);
					}
					if(salesback.size()!=0){
					for(int i=sales.size();i<sales.size()+salesback.size();i++){
						list[i][0]=salesback.get(i-sales.size()).getNumber();
						list[i][1]=salesback.get(i-sales.size()).getDate();
						list[i][2]="销售退货单";
						list[i][3]=new Boolean(false);
						}
					}
					order_mytable.setData(list);
				}
				else if(cl.equals("进货类单据")){
					CheckPurchaseController cpc=new CheckPurchaseController(operator);
					List<PurchaseOrderVO> pur=cpc.queryPurchaseOrder();
					List<PurchaseBackOrderVO> purback=cpc.queryPurchaseBackOrder();
					Object list[][]=new Object[pur.size()+purback.size()][4];
					for(int i=0;i<pur.size();i++){
						list[i][0]=pur.get(i).getNumber();
						list[i][1]=pur.get(i).getDate();
						list[i][2]="进货单";			
						list[i][3]=new Boolean(false);
					}
					if(purback.size()!=0){
						for(int i=pur.size();i<pur.size()+purback.size();i++){
						list[i][0]=purback.get(i-pur.size()).getNumber();
						list[i][1]=purback.get(i-pur.size()).getDate();
						list[i][2]="进货退货单";	
						list[i][3]=new Boolean(false);
						}
					}
					
					order_mytable.setData(list);
				}
				else if(cl.equals("库存类单据")){
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
						list[i][2]="赠送单";
						list[i][3]=new Boolean(false);
					}
					if(losslist.size()!=0){
					for(int i=size1;i<size1+size2;i++){
						list[i][0]=losslist.get(i-size1).getOrdernumber2();
						list[i][1]=losslist.get(i-size1).getDate();
						list[i][2]="报损单";
						list[i][3]=new Boolean(false);
						}
					}
					if(overlist.size()!=0){
					for(int i=size1+size2;i<size1+size2+size3;i++){
						list[i][0]=overlist.get(i-size1-size2).getOrdernumber2();
						list[i][1]=overlist.get(i-size1-size2).getDate();
						list[i][2]="报溢单";
						list[i][3]=new Boolean(false);
						}
					}
					/*for(int i=size1+size2+size3;i<size1+size2+size3+size4;i++){
						list[i][0]=alarmlist.get(i-size1-size2)
						list[i][1]=alarmlist.get(i-size1-size2).getDate();
						list[i][3]="报溢单";
					}*/
					order_mytable.setData(list);	
				}
				else if(cl.equals("财务类单据")){
					CheckReceiptController crs=new CheckReceiptController(operator);
					List<ReceiptVO> receiptlist=crs.queryReceipt();
					List<ReceiptBackVO> receiptbacklist=crs.queryReceiptBack();
					int hang=receiptlist.size()+receiptbacklist.size();
					Object list[][]=new Object[hang][4];
					for(int i=0;i<receiptlist.size();i++){
						list[i][0]=receiptlist.get(i).getNumber();
						list[i][1]=receiptlist.get(i).getDate();
						list[i][2]="收款单";
						list[i][3]=new Boolean(false);
					}
					if(receiptbacklist.size()!=0){
					for(int i=receiptlist.size();i<receiptlist.size()+receiptbacklist.size();i++){
						list[i][0]=receiptbacklist.get(i-receiptlist.size()).getNumber();
						list[i][1]=receiptbacklist.get(i-receiptlist.size()).getDate();
						list[i][2]="付款单";
						list[i][3]=new Boolean(false);
						}
					}
					order_mytable.setData(list);	
				}
			}
			else if(e.getSource() == co_pass){
				int row = 0;
				for(int i=0;i<order_table.getRowCount();i++){
					//单据被选中
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
				//重绘表格
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
				aqa.insertLog("审批单据");
			}
			else if(e.getSource()==co_unpass){
				int row = 0;
				for(int i=0;i<order_table.getRowCount();i++){
					//单据被选中
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
				//重绘表格
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
				aqa.insertLog("审批单据");
			}
			else if(e.getSource() == checkLog){
				Font font = new Font("Default",Font.BOLD,20);
				checkLog_frame = new JFrame("查看日志");
				checkLog_frame.setLocation(600, 200);
				checkLog_frame.setSize(800,500);
				checkLog_frame.setLayout(null);
				checkLog_frame.getContentPane().setBackground(Color.cyan);
				checkLog_frame.setFont(font);
				/*
				 * 日志显示
				 */
				Object[][] data = {{"","",""}};
				String[] columnNames = {"日期","操作员","事件"};
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
			     * 设置日志内容
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
				JFrame frame=new JFrame("数据统计图");
			    frame.setLayout(new GridLayout(2,1,10,10));
			    frame.add(new PieChart("收入类").getChartPanel());     
			    frame.add(new PieChart("支出类").getChartPanel());   
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
				msc.insertLog("导出经营情况");
			}
		}
		
	}
	
	class MouseActionListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == order_table){
			    //双击一行后显示单据的详细信息
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
				//双击一行后显示单据的详细信息
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
			//选中item响应
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
						//赠品表
						GoodsController gc = new GoodsController("总经理");
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
						//商品选择表
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
						//赠品表
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
	
	//自定义table
		class Mytable extends AbstractTableModel{
			String[] columnNames = {"编号","日期","单据类型","选择"};
			Object[][] celldata = {{"","","",new Boolean(false)},{"","","",new Boolean(false)},{"","","",new Boolean(false)},
			{"","","",new Boolean(false)},{"","","",new Boolean(false)},{"","","",new Boolean(false)},{"","","",new Boolean(false)},
			{"","","",new Boolean(false)},{"","","",new Boolean(false)},{"","","",new Boolean(false)}};
			
			//设置表格数据
			public void setData(Object[][] data){
				celldata = data;
				fireTableDataChanged();
			}

			//返回每一列的类型
			@Override
			public Class getColumnClass(int columnIndex) {
				if(columnIndex == 3){
					   return Boolean.class;// 返回每一列的数据类型
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
			//设置可以编辑
			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				if(columnIndex==3){
					   return true;
				}else{
					return false;
				}
			}
		}
		//赠品表
		class Mytable1 extends AbstractTableModel{
			String[] columnNames = {"编号","名称","型号","库存数量","赠送数量","选择"};
			Object[][] celldata = {{"","","","","",new Boolean(false)},{"","","","","",new Boolean(false)},{"","","","","",new Boolean(false)},
					{"","","","","",new Boolean(false)},{"","","","","",new Boolean(false)},{"","","","","",new Boolean(false)},{"","","","","",new Boolean(false)}
					,{"","","","","",new Boolean(false)},{"","","","","",new Boolean(false)},{"","","","","",new Boolean(false)},{"","","","","",new Boolean(false)}};
			
			
			//设置表格数据
			public void setData(Object[][] data){
				celldata = data;
				fireTableDataChanged();
			}

			//返回每一列的类型
			@Override
			public Class getColumnClass(int columnIndex) {
				if(columnIndex == 5){
					   return Boolean.class;// 返回每一列的数据类型
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
			//设置可以编辑
			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				if(columnIndex==4 || columnIndex==5){
					   return true;
				}else{
					return false;
				}
			}
		}
		
		//商品选择列表
		class Mytable2 extends AbstractTableModel{
			String[] columnNames = {"编号","名称","型号","单价","选择"};
			Object[][] celldata = {{"","","","",new Boolean(false)},{"","","","",new Boolean(false)},{"","","","",new Boolean(false)},
					{"","","","",new Boolean(false)},{"","","","",new Boolean(false)},{"","","","",new Boolean(false)},{"","","","",new Boolean(false)}
					,{"","","","",new Boolean(false)},{"","","","",new Boolean(false)},{"","","","",new Boolean(false)}};
			
			//设置表格数据
			public void setData(Object[][] data){
				celldata = data;
				fireTableDataChanged();
			}

			
			//返回每一列的类型
			@Override
			public Class getColumnClass(int columnIndex) {
				if(columnIndex == 4){
						return Boolean.class;// 返回每一列的数据类型
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
			//设置可以编辑
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
		        //设置百分比
		          PiePlot pieplot = (PiePlot) chart.getPlot();
		          DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题
		          NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象
		          StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象
		          pieplot.setLabelGenerator(sp1);//设置饼图显示百分比
		       
		      //没有数据的时候显示的内容
		          pieplot.setNoDataMessage("无数据显示");
		          pieplot.setCircular(false);
		          pieplot.setLabelGap(0.02D);
		       
		          pieplot.setIgnoreNullValues(true);//设置不显示空值
		          pieplot.setIgnoreZeroValues(true);//设置不显示负值
		         frame1=new ChartPanel (chart,true);
		          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
		          PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
		          piePlot.setLabelFont(new Font("宋体",Font.BOLD,20));//解决乱码
		          chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,20));
		    }
		    
		    
		    private  DefaultPieDataset getDataSet() {
		        DefaultPieDataset dataset = new DefaultPieDataset();
		        ManagementSituationController msc = new ManagementSituationController(operator);
		        String begin=jyqk_start_year.getSelectedItem().toString()+jyqk_start_month.getSelectedItem().toString()+jyqk_start_day.getSelectedItem().toString();
				String end=jyqk_end_year.getSelectedItem().toString()+jyqk_end_month.getSelectedItem().toString()+jyqk_end_day.getSelectedItem().toString();
		        List<Double> list=msc.Situation(begin,end);
		        if(title.equals("收入类")){
		          dataset.setValue("销售收入",list.get(0));
		          dataset.setValue("商品类收入",list.get(1));
		          }
		        else{
		          dataset.setValue("销售成本",list.get(3));
		          dataset.setValue("商品类支出",list.get(4));
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