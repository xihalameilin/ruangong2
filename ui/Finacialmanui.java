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
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
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

import controller.BankAccountController;
import controller.BusinessCourseController;
import controller.CheckPurchaseController;
import controller.CheckReceiptController;
import controller.CheckSalesController;
import controller.CheckStockController;
import controller.CustomerController;
import controller.GoodsController;
import controller.LogController;
import controller.ManagementSituationController;
import controller.OrderController;
import controller.SalesDetailController;
import controller.SetBookController;
import controller.StockController;
import rmi.RemoteHelper;
import ui.Salesmanui.ButtonActionListener;
import ui.Salesmanui.MouseActionListener;
import utility.DatetoString;
import utility.ResultMessage;
import vo.BankAccountVO;
import vo.CustomerVO;
import vo.GoodsListVO;
import vo.GoodsVO;
import vo.LogVO;
import vo.NoticeVO;
import vo.PayOrderVO;
import vo.PurchaseBackOrderVO;
import vo.PurchaseOrderVO;
import vo.ReceiptBackVO;
import vo.ReceiptVO;
import vo.SalesBackOrderVO;
import vo.SalesOrderVO;
import vo.StockGrantOrderVO;
import vo.StockLossOrderVO;
import vo.StockOverflowOrderVO;
import vo.TiaoMuVO;
import vo.TransferAccountVO;

public class Finacialmanui {
	
	private String operator;//����Ա
	private JFrame frame;
	private JButton close;
	private JButton logout;
	private JPanel imagePanel;
	private JButton am;//�����˻�����
	private JButton ro;//�����տ
	private JButton po;//���ɸ��
	private JButton mo;//�����ֽ���õ�
	private JButton findXSMX;//�鿴������ϸ
	private JButton findJYLC;//�鿴��Ӫ����
	private JButton findJYQK;//�鿴��Ӫ���
	private JButton ae;//�ڳ�����
	private JPanel am_panel;//�˻��������
	private JPanel ro_panel;//�տ���ɽ���
	private JPanel po_panel;//������ɽ���
	private JPanel mo_panel;//�ֽ���õ����ɽ���
	private JPanel xsmx_panel;//�鿴������ϸ����
	private JPanel jylc_panel;//�鿴��Ӫ�������
	private JPanel jyqk_panel;//�鿴��Ӫ���̽���
	private JPanel ae_panel;//�ڳ����˽���
	private JTextField search_account;//��ѯ�˻�
	private JButton search;//
	private JTable account_table;//�˻��б�
	private JButton addAccount;//�����˻�
	//�����˻�����
	private JFrame am_add_frame;
	private JTextField am_add_account;
	private JTextField am_add_money;
	private JButton am_add_cancel;
	private JButton am_add_confirm;
	private JButton removeAccount;//ɾ���˻�
	private JButton updateAccount;//�޸��˻�
	private int removeFlag = -1;
	private int updateFlag = -1;
	private String oldName = null;
	private JTextField ro_number;//������
	private JComboBox<String> ro_supplier;
	private JComboBox<String> ro_retailer;
	private JTextField ro_operator;//����Ա
	private JTable ro_ta_table;//ת���б�
	private Mytable1 ro_mytable;
	private JTextField ro_addAll;//�ϼ�
	private JButton ro_editDraft;//�༭�ݸ�
	//�༭�ݸ����
	private JFrame ro_editDraft_frame;
	private JComboBox ro_editDraft_draftNumber;//�ݸ���
	private JButton ro_editDraft_cancel;
	private JButton ro_editDraft_confirm;
	private JButton ro_saveDraft;//����ݸ�
	private JButton ro_submit;//�ύ
	private JTextField po_number;//������
	private JComboBox<String> po_supplier;
	private JComboBox<String> po_retailer;
	private JTextField po_operator;//����Ա
	private JTable po_ta_table;//ת���б�
	private Mytable1 po_mytable;
	private JTextField po_addAll;//�ϼ�
	private JButton po_editDraft;//�༭�ݸ�
	//�༭�ݸ����
	private JFrame po_editDraft_frame;
	private JComboBox po_editDraft_draftNumber;//�ݸ���
	private JButton po_editDraft_cancel;
	private JButton po_editDraft_confirm;
	private JButton po_saveDraft;//����ݸ�
	private JButton po_submit;//�ύ
	private JTextField mo_number;//������
	private JTextField mo_operator;//����Ա
	private JComboBox<String> mo_account;
	private JTextField mo_addAll;//�ϼ�
	private JButton mo_editDraft;//�༭�ݸ�
	//�༭�ݸ����
	private JFrame mo_editDraft_frame;
	private JComboBox mo_editDraft_draftNumber;//�ݸ���
	private JButton mo_editDraft_cancel;
	private JButton mo_editDraft_confirm;
	private JButton mo_saveDraft;//����ݸ�
	private JButton mo_submit;//�ύ
	private JTable tm_table;//��Ŀ�嵥
	private JComboBox start_year;
	private JComboBox start_month;
	private JComboBox start_day;
	private JComboBox end_year;
	private JComboBox end_month;
	private JComboBox end_day;
	private JComboBox goods_box;//��Ʒ��
	private JComboBox customer_box;//�ͻ�
	private JTextField salesman_box;//ҵ��Ա
	private JComboBox stock_box;//�ֿ�
	private JTable xsmx_table;//������ϸ��
	private JButton xsmx_confirm;//ȷ��
	private JButton xsmx_cancel;//ȡ��
	private JButton xsmx_export;//����EXCEL
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
	private JTable jylcOrder_table;//�����б�
	private Mytable mytable;
	private JTable jyqkOrder_table;//�����б�
	private JButton jylc_export;//����WXCEL
	private JButton jylc_confirm;//
	private JButton jylc_rd;//���
	private JButton jylc_rdac;//��岢����
	private JComboBox jyqk_start_year;
	private JComboBox jyqk_start_month;
	private JComboBox jyqk_start_day;
	private JComboBox jyqk_end_year;
	private JComboBox jyqk_end_month;
	private JComboBox jyqk_end_day;
	private JTextField sale_income;//��������
	private JTextField goods_income;//��Ʒ������
	private JTextField discount_income;//����
	private JTextField sale_outcome;//����֧��
	private JTextField goods_outcome;//��Ʒ��֧��
	private JTextField addup_income;//������
	private JTextField addup_outcome;//��֧��
	private JTextField profit;//����
	private JButton jyqk_analyse;//ͼ�η���
	private JButton jyqk_export;//����EXCEL
	private JButton jyqk_confirm;
	private JButton jyqk_cancel;
	private JComboBox ae_year;
	private JButton ae_makeAccount;//�ڳ�����
	private JButton ae_findAccount;//�鿴�ڳ���Ϣ
	private JFrame findAccount_frame;//�鿴�ڳ���Ϣ����
	private JFrame checkLog_frame;//�鿴��־����
	private JButton checkLog;//�鿴��־
	private ImageIcon message;
	private ImageIcon message1;
	private JLabel message_label;
	private int noticeFlag = 0;
	private List<NoticeVO> notice_list;
	
	public static void main(String[] args){
		Finacialmanui finacialmanui  = new Finacialmanui("������Ա");
	}
	
	public Finacialmanui(String operator){
		//����Ա
		this.operator = operator;
		//����frame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 650);
		frame.setLocation(500, 230);
		//��������
		Font font0 = new Font("Default",Font.BOLD,30);
		Font font = new Font("Default",Font.BOLD,20);
		Font font1 = new Font("Default",Font.BOLD,25);
		//ȥ�������
		frame.setUndecorated(true);
		//�������
		JLabel title = new JLabel("<html>�ƾ߽�����ϵͳ<br>(PSIS)<html/>");
		title.setFont(font0);
		title.setSize(250,80);
		title.setLocation(60,20);
		title.setForeground(Color.pink);
		frame.getContentPane().add(title);
		
		message1 = new ImageIcon("��Ϣ��ʾ.gif");
		message = new ImageIcon("��Ϣ��ʾ.png");
		message_label = new JLabel();
		notice_list = new ArrayList<NoticeVO>();
		try {
			notice_list = RemoteHelper.getInstance().getNoticeblservice().queryAll("������Ա");
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
		message_label.addMouseListener(new MouseActionListener());
		message_label.setLocation(340,590);
		message_label.setSize(message.getIconWidth(),message.getIconHeight());
		message_label.setVisible(true);
		frame.getContentPane().add(message_label);
		
		/*
		 * �ر�
		 */
		close = new JButton("X");
		close.setForeground(Color.white);
		close.addActionListener(new ButtonActionListener());
		close.setSize(80,50);
		close.setLocation(920,0);
		close.setFont(font);
		close.setContentAreaFilled(false);
		close.setFocusPainted(false);
		//close.setBorderPainted(false);
		frame.getContentPane().add(close);
		/*
		 * �˻�����
		 */
		am = new JButton("   �˻�����");
		am.addActionListener(new ButtonActionListener());
		am.setLocation(0,130);
		am.setSize(160,100);
		am.setForeground(Color.white);
		am.setFocusPainted(false);
		am.setFont(font);
		am.setContentAreaFilled(false);
		frame.getContentPane().add(am);
		ImageIcon am_icon = new ImageIcon("1.png");
		JLabel am_label = new JLabel(am_icon);
		am_label.setLocation(0,165);
		am_label.setSize(am_icon.getIconWidth(),am_icon.getIconHeight());
		frame.getContentPane().add(am_label);
		/*
		 * �鿴������ϸ��
		 */
		findXSMX = new JButton("      �鿴������ϸ��");
		findXSMX.addActionListener(new ButtonActionListener());
		findXSMX.setLocation(160,130);
		findXSMX.setSize(220,100);
		findXSMX.setForeground(Color.white);
		findXSMX.setFocusPainted(false);
		findXSMX.setFont(font);
		findXSMX.setContentAreaFilled(false);
		frame.getContentPane().add(findXSMX);
		ImageIcon findXSMX_icon = new ImageIcon("search.png");
		JLabel findXSMX_label = new JLabel(findXSMX_icon);
		findXSMX_label.setLocation(160,158);
		findXSMX_label.setSize(findXSMX_icon.getIconWidth(),findXSMX_icon.getIconHeight());
		frame.getContentPane().add(findXSMX_label);
		/*
		 * �ƶ��տ
		 */
		ro = new JButton("   �ƶ��տ");
		ro.addActionListener(new ButtonActionListener());
		ro.setLocation(0,230);
		ro.setSize(160,100);
		ro.setForeground(Color.white);
		ro.setFocusPainted(false);
		ro.setFont(font);
		ro.setContentAreaFilled(false);
		frame.getContentPane().add(ro);
		ImageIcon ro_icon = new ImageIcon("�ļ�.png");
		JLabel ro_label = new JLabel(ro_icon);
		ro_label.setLocation(0,265);
		ro_label.setSize(ro_icon.getIconWidth(),ro_icon.getIconHeight());
		frame.getContentPane().add(ro_label);
		/*
		 * �鿴��Ӫ���̱�
		 */
		findJYLC = new JButton("      �鿴��Ӫ���̱�");
		findJYLC.addActionListener(new ButtonActionListener());
		findJYLC.setLocation(160,230);
		findJYLC.setSize(220,100);
		findJYLC.setForeground(Color.white);
		findJYLC.setFocusPainted(false);
		findJYLC.setFont(font);
		findJYLC.setContentAreaFilled(false);
		frame.getContentPane().add(findJYLC);
		ImageIcon findJYLC_icon = new ImageIcon("search.png");
		JLabel findJYLC_label = new JLabel(findJYLC_icon);
		findJYLC_label.setLocation(160,258);
		findJYLC_label.setSize(findJYLC_icon.getIconWidth(),findJYLC_icon.getIconHeight());
		frame.getContentPane().add(findJYLC_label);
		/*
		 * �ƶ����
		 */
		po = new JButton("   �ƶ����");
		po.addActionListener(new ButtonActionListener());
		po.setLocation(0,330);
		po.setSize(160,100);
		po.setForeground(Color.white);
		po.setFocusPainted(false);
		po.setFont(font);
		po.setContentAreaFilled(false);
		frame.getContentPane().add(po);
		ImageIcon po_icon = new ImageIcon("�ļ�.png");
		JLabel po_label = new JLabel(po_icon);
		po_label.setLocation(0,365);
		po_label.setSize(po_icon.getIconWidth(),po_icon.getIconHeight());
		frame.getContentPane().add(po_label);
		/*
		 * �鿴��Ӫ�����
		 */
		findJYQK = new JButton("     �鿴��Ӫ�����");
		findJYQK.addActionListener(new ButtonActionListener());
		findJYQK.setLocation(160,330);
		findJYQK.setSize(220,100);
		findJYQK.setForeground(Color.white);
		findJYQK.setFocusPainted(false);
		findJYQK.setFont(font);
		findJYQK.setContentAreaFilled(false);
		frame.getContentPane().add(findJYQK);
		ImageIcon findJYQK_icon = new ImageIcon("search.png");
		JLabel findJYQK_label = new JLabel(findJYQK_icon);
		findJYQK_label.setLocation(160,358);
		findJYQK_label.setSize(findJYQK_icon.getIconWidth(),findJYQK_icon.getIconHeight());
		frame.getContentPane().add(findJYQK_label);
		/*
		 * �ڳ�����
		 */
		ae = new JButton(" �ڳ�����");
		ae.addActionListener(new ButtonActionListener());
		ae.setLocation(0,430);
		ae.setSize(160,100);
		ae.setForeground(Color.white);
		ae.setFocusPainted(false);
		ae.setFont(font);
		ae.setContentAreaFilled(false);
		frame.getContentPane().add(ae);
		ImageIcon ae_icon = new ImageIcon("�ļ�.png");
		JLabel ae_label = new JLabel(ae_icon);
		ae_label.setLocation(0,465);
		ae_label.setSize(ae_icon.getIconWidth(),ae_icon.getIconHeight());
		frame.getContentPane().add(ae_label);
		/*
		 * �ƶ��ֽ���õ�
		 */
		mo = new JButton("   �ƶ��ֽ���õ�");
		mo.addActionListener(new ButtonActionListener());
		mo.setLocation(160,430);
	    mo.setSize(220,100);
		mo.setForeground(Color.white);
		mo.setFocusPainted(false);
		mo.setFont(font);
		mo.setContentAreaFilled(false);
		frame.getContentPane().add(mo);
		ImageIcon mo_icon = new ImageIcon("�ļ�.png");
		JLabel mo_label = new JLabel(mo_icon);
		mo_label.setLocation(160,462);
		mo_label.setSize(mo_icon.getIconWidth(),mo_icon.getIconHeight());
		frame.getContentPane().add(mo_label);
		/*
         * ע����ť
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
		checkLog = new JButton("    �鿴��־");
		checkLog.addActionListener(new ButtonActionListener());
		checkLog.setLocation(180,580);
		checkLog.setSize(150,70);
		checkLog.setFont(font);
		checkLog.setForeground(Color.white);
		checkLog.setContentAreaFilled(false);
		checkLog.setFocusPainted(false);
		ImageIcon checkLog_icon = new ImageIcon("�ļ�.png");
		JLabel checkLog_label = new JLabel(checkLog_icon);
		checkLog_label.setLocation(188,595);
		checkLog_label.setSize(checkLog_icon.getIconWidth(),checkLog_icon.getIconHeight());
		frame.getContentPane().add(checkLog_label);
		frame.getContentPane().add(checkLog);
		
		/*
		 * �˻��������
		 */
		am_panel = new JPanel();
		am_panel.setLocation(430,80);
		am_panel.setSize(420,500);
		am_panel.setLayout(null);
		am_panel.setBackground(Color.cyan);
		am_panel.setOpaque(true);
		/*
		 * ��ѯ��
		 */
		search_account = new JTextField();
		search_account.setLocation(50,25);
		search_account.setSize(280,50);
		search_account.setFont(font);
		am_panel.add(search_account);
		search = new JButton();
		search.addActionListener(new ButtonActionListener());
		search.setLocation(330,25);
		search.setSize(50,50);
		search.setFont(font);
		search.setContentAreaFilled(false);
		am_panel.add(search);
		ImageIcon search_icon = new ImageIcon("search.png");
		JLabel search_label = new JLabel(search_icon);
		search_label.setLocation(330,25);
		search_label.setSize(search_icon.getIconWidth(),search_icon.getIconHeight());
		am_panel.add(search_label);
		/*
		 * �˻��б�
		 */
		JLabel account_label = new JLabel("�����˻��б�");
		account_label.setLocation(100,100);
		account_label.setSize(250,30);
		account_label.setFont(font1);
		am_panel.add(account_label);
		Object[][] data = {{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""}};
		String[] columnNames = {"����","���"};
		DefaultTableModel model = new DefaultTableModel(data,columnNames);
		account_table = new JTable(model){
			public boolean isCellEditable(int row, int column) {
				if(column == 0){
					return true;
				}else{
					return false;
				}
			}
		};
		account_table.addMouseListener(new MouseActionListener());
		account_table.getTableHeader().setReorderingAllowed(false);
		account_table.setBackground(Color.cyan);
		account_table.setSelectionBackground(Color.pink);
		account_table.getTableHeader().setFont(font);
		account_table.getTableHeader().setForeground(Color.red);
		account_table.setRowHeight(33);
		account_table.setFont(font);
		JScrollPane am_scrollPane = new JScrollPane(account_table);
		am_scrollPane.getViewport().setBackground(Color.cyan);
		am_scrollPane.setLocation(50,150);
		am_scrollPane.setSize(250,300);
		am_panel.add(am_scrollPane);
		/*
		 * buttton�ؼ�
		 */
		//����
		addAccount =  new JButton("����");
		addAccount.addActionListener(new ButtonActionListener());
		addAccount.setLocation(310,150);
		addAccount.setSize(100,60);
		addAccount.setFont(font);
		addAccount.setFocusPainted(false);
		addAccount.setForeground(Color.magenta);
		am_panel.add(addAccount);
		//ɾ��
		removeAccount =  new JButton("ɾ��");
		removeAccount.addActionListener(new ButtonActionListener());
		removeAccount.setLocation(310,270);
		removeAccount.setSize(100,60);
		removeAccount.setFont(font);
		removeAccount.setFocusPainted(false);
		removeAccount.setForeground(Color.magenta);
		am_panel.add(removeAccount);
		//�޸�
		updateAccount =  new JButton("�޸�");
		updateAccount.addActionListener(new ButtonActionListener());
		updateAccount.setLocation(310,390);
		updateAccount.setSize(100,60);
		updateAccount.setFont(font);
		updateAccount.setFocusPainted(false);
		updateAccount.setForeground(Color.magenta);
		am_panel.add(updateAccount);
		am_panel.setVisible(false);
		frame.getContentPane().add(am_panel);
		
		/*
		 * �ƶ��տ����
		 */
		ro_panel = new JPanel();
		ro_panel.setLayout(null);
		ro_panel.setLocation(410,50);
		ro_panel.setSize(510,550);
		ro_panel.setLayout(null);
		ro_panel.setBackground(Color.cyan);
		ro_panel.setOpaque(true);
		/*
		 * ����
		 */
		JLabel ro_input = new JLabel("�տ����");
		ro_input.setLocation(180,10);
		ro_input.setSize(150,30);
		ro_input.setFont(font1);
		ro_input.setForeground(Color.red);
		ro_panel.add(ro_input);
		//������
		JLabel ro_number_label = new JLabel("������");
	    ro_number_label.setLocation(40,50);
	    ro_number_label.setSize(100,30);
	    ro_number_label.setFont(font);
	    ro_number_label.setBackground(Color.black);
	    ro_panel.add(ro_number_label);
	    ro_number = new JTextField();
	    ro_number.setLocation(130,50);
	    ro_number.setSize(280,30);
	    ro_number.setFont(font);
	    ro_number.setBackground(Color.white);
	    ro_panel.add(ro_number);
	    //��Ӧ��
	    JLabel ro_supplier_label = new JLabel("��Ӧ��");
	    ro_supplier_label.setLocation(40,90);
	    ro_supplier_label.setSize(100,30);
	    ro_supplier_label.setFont(font);
	    ro_supplier_label.setBackground(Color.black);
	    ro_panel.add(ro_supplier_label);
	    ro_supplier = new JComboBox<String>();
	    ro_supplier.addItemListener(new boxItemListener());
	    ro_supplier.setLocation(130,90);
	    ro_supplier.setSize(280,30);
	    ro_supplier.setBackground(Color.white);
	    ro_supplier.setFont(font);
	    ro_panel.add(ro_supplier);
	    //������
	    JLabel ro_retailer_label = new JLabel("������");
	    
	    ro_retailer_label.setLocation(40,130);
	    ro_retailer_label.setSize(100,30);
	    ro_retailer_label.setFont(font);
	    ro_retailer_label.setBackground(Color.black);
	    ro_panel.add(ro_retailer_label);
	    ro_retailer = new JComboBox<String>();
	    ro_retailer.addItemListener(new boxItemListener());
	    ro_retailer.setLocation(130,130);
	    ro_retailer.setSize(280,30);
	    ro_retailer.setBackground(Color.white);
	    ro_retailer.setFont(font);
	    ro_panel.add(ro_retailer);
	    //����Ա
	    JLabel ro_operator_label = new JLabel("����Ա");
	    ro_operator_label.setLocation(40,170);
	    ro_operator_label.setSize(100,30);
	    ro_operator_label.setFont(font);
	    ro_operator_label.setBackground(Color.black);
	    ro_panel.add(ro_operator_label);
	    ro_operator = new JTextField();
	    ro_operator.setLocation(130,170);
	    ro_operator.setSize(280,30);
	    ro_operator.setFont(font);
	    ro_operator.setBackground(Color.white);
	    ro_panel.add(ro_operator);
	    /*
	     * ת���б�
	     */
	    JLabel transferAccount = new JLabel("ת���б�");
	    transferAccount.setLocation(190,210);
	    transferAccount.setSize(150,30);
	    transferAccount.setFont(font1);
	    transferAccount.setForeground(Color.black);
	    ro_panel.add(transferAccount);
	    ro_mytable = new Mytable1();
	    ro_ta_table = new JTable(ro_mytable);
	    ro_ta_table.addMouseListener(new MouseActionListener());
	    ro_ta_table.getTableHeader().setReorderingAllowed(false);
	    ro_ta_table.setBackground(Color.cyan);
	    ro_ta_table.setSelectionBackground(Color.pink);
	    ro_ta_table.getTableHeader().setFont(font);
	    ro_ta_table.getTableHeader().setForeground(Color.red);
	    ro_ta_table.setRowHeight(33);
	    ro_ta_table.setFont(font);
	    ro_ta_table.getColumnModel().getColumn(0).setPreferredWidth(100);
	    ro_ta_table.getColumnModel().getColumn(1).setPreferredWidth(100);
	    ro_ta_table.getColumnModel().getColumn(2).setPreferredWidth(150);
		JScrollPane ro_scrollPane = new JScrollPane(ro_ta_table);
		ro_scrollPane.getViewport().setBackground(Color.cyan);
		ro_scrollPane.setLocation(0,250);
		ro_scrollPane.setSize(510,230);
		ro_panel.add(ro_scrollPane);
		/*
		 * button�ؼ�
		 */
		JLabel ro_addAll_label = new JLabel("�ܼ�");
		ro_addAll_label.setLocation(0,500);
		ro_addAll_label.setSize(50,30);
		ro_addAll_label.setFont(font);
		ro_panel.add(ro_addAll_label);
		ro_addAll = new JTextField();
		ro_addAll.setLocation(40,500);
		ro_addAll.setSize(90,30);
		ro_addAll.setFont(font);
		ro_addAll.setBackground(Color.white);
		ro_panel.add(ro_addAll);
		//�༭�ݸ�
		ro_editDraft = new JButton("�༭�ݸ�");
		ro_editDraft.addActionListener(new ButtonActionListener());
		ro_editDraft.setLocation(140,490);
		ro_editDraft.setSize(120,50);
		ro_editDraft.setFont(font);
		ro_editDraft.setForeground(Color.MAGENTA);
		ro_editDraft.setFocusPainted(false);
		ro_panel.add(ro_editDraft);
		//����ݸ�
		ro_saveDraft = new JButton("����ݸ�");
		ro_saveDraft.addActionListener(new ButtonActionListener());
		ro_saveDraft.setLocation(280,490);
		ro_saveDraft.setSize(120,50);
		ro_saveDraft.setFont(font);
		ro_saveDraft.setForeground(Color.MAGENTA);
		ro_saveDraft.setFocusPainted(false);
		ro_panel.add(ro_saveDraft);
		//�ύ
		ro_submit = new JButton("�ύ");
		ro_submit.addActionListener(new ButtonActionListener());
		ro_submit.setLocation(420,490);
		ro_submit.setSize(80,50);
		ro_submit.setFont(font);
		ro_submit.setForeground(Color.MAGENTA);
		ro_submit.setFocusPainted(false);
		ro_panel.add(ro_submit);
		ro_panel.setVisible(false);
		frame.getContentPane().add(ro_panel);
		
		/*
		 * �ƶ��������
		 */
		po_panel = new JPanel();
		po_panel.setLayout(null);
		po_panel.setLocation(410,50);
		po_panel.setSize(510,550);
		po_panel.setLayout(null);
		po_panel.setBackground(Color.cyan);
		po_panel.setOpaque(true);
		/*
		 * ����
		 */
		JLabel po_input = new JLabel("�������");
		po_input.setLocation(180,10);
		po_input.setSize(150,30);
		po_input.setFont(font1);
		po_input.setForeground(Color.red);
		po_panel.add(po_input);
		//������
		JLabel po_number_label = new JLabel("������");
	    po_number_label.setLocation(40,50);
	    po_number_label.setSize(100,30);
	    po_number_label.setFont(font);
	    po_number_label.setBackground(Color.black);
	    po_panel.add(po_number_label);
	    po_number = new JTextField();
	    po_number.setLocation(130,50);
	    po_number.setSize(280,30);
	    po_number.setFont(font);
	    po_number.setBackground(Color.white);
	    po_panel.add(po_number);
	    //��Ӧ��
	    JLabel po_supplier_label = new JLabel("��Ӧ��");
	    po_supplier_label.setLocation(40,90);
	    po_supplier_label.setSize(100,30);
	    po_supplier_label.setFont(font);
	    po_supplier_label.setBackground(Color.black);
	    po_panel.add(po_supplier_label);
	    po_supplier = new JComboBox<String>();
	    po_supplier.addItemListener(new boxItemListener());
	    po_supplier.setLocation(130,90);
	    po_supplier.setSize(280,30);
	    po_supplier.setBackground(Color.white);
	    po_supplier.setFont(font);
	    po_panel.add(po_supplier);
	    //������
	    JLabel po_retailer_label = new JLabel("������");
	    po_retailer_label.setLocation(40,130);
	    po_retailer_label.setSize(100,30);
	    po_retailer_label.setFont(font);
	    po_retailer_label.setBackground(Color.black);
	    po_panel.add(po_retailer_label);
	    po_retailer = new JComboBox<String>();
	    po_retailer.addItemListener(new boxItemListener());
	    po_retailer.setLocation(130,130);
	    po_retailer.setSize(280,30);
	    po_retailer.setBackground(Color.white);
	    po_retailer.setFont(font);
	    po_panel.add(po_retailer);
	    //����Ա
	    JLabel po_operator_label = new JLabel("����Ա");
	    po_operator_label.setLocation(40,170);
	    po_operator_label.setSize(100,30);
	    po_operator_label.setFont(font);
	    po_operator_label.setBackground(Color.black);
	    po_panel.add(po_operator_label);
	    po_operator = new JTextField();
	    po_operator.setLocation(130,170);
	    po_operator.setSize(280,30);
	    po_operator.setFont(font);
	    po_operator.setBackground(Color.white);
	    po_panel.add(po_operator);
	    /*
	     * ת���б�
	     */
	    JLabel po_transferAccount = new JLabel("ת���б�");
	    po_transferAccount.setLocation(190,210);
	    po_transferAccount.setSize(150,30);
	    po_transferAccount.setFont(font1);
	    po_transferAccount.setForeground(Color.black);
	    po_panel.add(po_transferAccount);
	    po_mytable = new Mytable1();
	    po_ta_table = new JTable(po_mytable);
	    po_ta_table.addMouseListener(new MouseActionListener());
	    po_ta_table.getTableHeader().setReorderingAllowed(false);
	    po_ta_table.setBackground(Color.cyan);
	    po_ta_table.setSelectionBackground(Color.pink);
	    po_ta_table.getTableHeader().setFont(font);
	    po_ta_table.getTableHeader().setForeground(Color.red);
	    po_ta_table.setRowHeight(33);
	    po_ta_table.setFont(font);
	    po_ta_table.getColumnModel().getColumn(0).setPreferredWidth(100);
	    po_ta_table.getColumnModel().getColumn(1).setPreferredWidth(100);
	    po_ta_table.getColumnModel().getColumn(2).setPreferredWidth(150);
		JScrollPane po_scrollPane = new JScrollPane(po_ta_table);
		po_scrollPane.getViewport().setBackground(Color.cyan);
		po_scrollPane.setLocation(0,250);
		po_scrollPane.setSize(510,230);
		po_panel.add(po_scrollPane);
		/*
		 * button�ؼ�
		 */
		JLabel po_addAll_label = new JLabel("�ܼ�");
		po_addAll_label.setLocation(0,500);
		po_addAll_label.setSize(50,30);
		po_addAll_label.setFont(font);
		po_panel.add(po_addAll_label);
		po_addAll = new JTextField();
		po_addAll.setLocation(40,500);
		po_addAll.setSize(90,30);
		po_addAll.setFont(font);
		po_addAll.setBackground(Color.white);
		po_panel.add(po_addAll);
		//�༭�ݸ�
		po_editDraft = new JButton("�༭�ݸ�");
		po_editDraft.addActionListener(new ButtonActionListener());
		po_editDraft.setLocation(140,490);
		po_editDraft.setSize(120,50);
		po_editDraft.setFont(font);
		po_editDraft.setForeground(Color.MAGENTA);
		po_editDraft.setFocusPainted(false);
		po_panel.add(po_editDraft);
		//����ݸ�
		po_saveDraft = new JButton("����ݸ�");
		po_saveDraft.addActionListener(new ButtonActionListener());
		po_saveDraft.setLocation(280,490);
		po_saveDraft.setSize(120,50);
		po_saveDraft.setFont(font);
		po_saveDraft.setForeground(Color.MAGENTA);
		po_saveDraft.setFocusPainted(false);
		po_panel.add(po_saveDraft);
		//�ύ
		po_submit = new JButton("�ύ");
		po_submit.addActionListener(new ButtonActionListener());
		po_submit.setLocation(420,490);
		po_submit.setSize(80,50);
		po_submit.setFont(font);
		po_submit.setForeground(Color.MAGENTA);
		po_submit.setFocusPainted(false);
		po_panel.add(po_submit);
		po_panel.setVisible(false);
		frame.getContentPane().add(po_panel);
		
		/*
		 * �ƶ��ֽ���õ�����
		 */
		mo_panel = new JPanel();
		mo_panel.setLayout(null);
		mo_panel.setLocation(410,50);
		mo_panel.setSize(510,550);
		mo_panel.setLayout(null);
		mo_panel.setBackground(Color.cyan);
		mo_panel.setOpaque(true);
		/*
		 * ����
		 */
		JLabel mo_input = new JLabel("�ֽ���õ�����");
		mo_input.setLocation(160,10);
		mo_input.setSize(200,30);
		mo_input.setFont(font1);
		mo_input.setForeground(Color.red);
		mo_panel.add(mo_input);
		//������
		JLabel mo_number_label = new JLabel("������");
	    mo_number_label.setLocation(40,50);
	    mo_number_label.setSize(100,30);
	    mo_number_label.setFont(font);
	    mo_number_label.setBackground(Color.black);
	    mo_panel.add(mo_number_label);
	    mo_number = new JTextField();
	    mo_number.setLocation(130,50);
	    mo_number.setSize(280,30);
	    mo_number.setFont(font);
	    mo_number.setBackground(Color.white);
	    mo_panel.add(mo_number);
	    //����Ա
	    JLabel mo_operator_label = new JLabel("����Ա");
	    mo_operator_label.setLocation(40,90);
	    mo_operator_label.setSize(100,30);
	    mo_operator_label.setFont(font);
	    mo_operator_label.setBackground(Color.black);
	    mo_panel.add(mo_operator_label);
	    mo_operator = new JTextField();
	    mo_operator.setLocation(130,90);
	    mo_operator.setSize(280,30);
	    mo_operator.setFont(font);
	    mo_operator.setBackground(Color.white);
	    mo_panel.add(mo_operator);
	    //�����˻�
	    JLabel mo_account_label = new JLabel("�����˻�");
	    mo_account_label.setLocation(40,130);
	    mo_account_label.setSize(100,30);
	    mo_account_label.setFont(font);
	    mo_account_label.setBackground(Color.black);
	    mo_panel.add(mo_account_label);
	    mo_account=new JComboBox<String>();
	    mo_account.setLocation(130,130);
	    mo_account.setSize(280,30);
	    mo_account.setBackground(Color.white);
	    mo_account.setFont(font);
	    mo_panel.add(mo_account);
	    /*
	     * ��Ŀ�嵥
	     */
	    JLabel tm_label = new JLabel("��Ŀ�嵥");
	    tm_label.setLocation(200,170);
	    tm_label.setSize(150,30);
	    tm_label.setFont(font1);
	    tm_label.setForeground(Color.black);
	    mo_panel.add(tm_label);
	    Object[][] po_data = {{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""}
	    ,{"","",""},{"","",""}};
	    String[] po_columnNames = {"��Ŀ��","���","��ע"};
	    DefaultTableModel tm_model = new DefaultTableModel(po_data,po_columnNames);
	    tm_table = new JTable(tm_model);
	    tm_table.getTableHeader().setReorderingAllowed(false);
	    tm_table.setBackground(Color.cyan);
	    tm_table.setSelectionBackground(Color.pink);
	    tm_table.getTableHeader().setFont(font);
	    tm_table.getTableHeader().setForeground(Color.red);
	    tm_table.setRowHeight(33);
	    tm_table.setFont(font);
	    tm_table.getColumnModel().getColumn(0).setPreferredWidth(100);
	    tm_table.getColumnModel().getColumn(1).setPreferredWidth(100);
	    tm_table.getColumnModel().getColumn(2).setPreferredWidth(150);
		JScrollPane mo_scrollPane = new JScrollPane(tm_table);
		mo_scrollPane.getViewport().setBackground(Color.cyan);
		mo_scrollPane.setLocation(0,210);
		mo_scrollPane.setSize(510,270);
		mo_panel.add(mo_scrollPane);
		/*
		 * button�ؼ�
		 */
		JLabel mo_addAll_label = new JLabel("�ܼ�");
		mo_addAll_label.setLocation(0,500);
		mo_addAll_label.setSize(50,30);
		mo_addAll_label.setFont(font);
		mo_panel.add(mo_addAll_label);
		mo_addAll = new JTextField();
		mo_addAll.addMouseListener(new MouseActionListener() );
		mo_addAll.setLocation(40,500);
		mo_addAll.setSize(90,30);
		mo_addAll.setFont(font);
		mo_addAll.setBackground(Color.white);
		mo_panel.add(mo_addAll);
		//�༭�ݸ�
		mo_editDraft = new JButton("�༭�ݸ�");
		mo_editDraft.addActionListener(new ButtonActionListener());
		mo_editDraft.setLocation(140,490);
		mo_editDraft.setSize(120,50);
		mo_editDraft.setFont(font);
		mo_editDraft.setForeground(Color.MAGENTA);
		mo_editDraft.setFocusPainted(false);
		mo_panel.add(mo_editDraft);
		//����ݸ�
		mo_saveDraft = new JButton("����ݸ�");
		mo_saveDraft.addActionListener(new ButtonActionListener());
		mo_saveDraft.setLocation(280,490);
		mo_saveDraft.setSize(120,50);
		mo_saveDraft.setFont(font);
		mo_saveDraft.setForeground(Color.MAGENTA);
		mo_saveDraft.setFocusPainted(false);
		mo_panel.add(mo_saveDraft);
		//�ύ
		mo_submit = new JButton("�ύ");
		mo_submit.addActionListener(new ButtonActionListener());
		mo_submit.setLocation(420,490);
		mo_submit.setSize(80,50);
		mo_submit.setFont(font);
		mo_submit.setForeground(Color.MAGENTA);
		mo_submit.setFocusPainted(false);
		mo_panel.add(mo_submit);
		mo_panel.setVisible(false);
		frame.getContentPane().add(mo_panel);
	    mo_panel.setVisible(false);
	    frame.getContentPane().add(mo_panel);
	    
	    /*
	     * �鿴������ϸ�����
	     */
	    xsmx_panel = new JPanel();
	    xsmx_panel.setLayout(null);
	    xsmx_panel.setLocation(430,20);
	    xsmx_panel.setSize(490,610);
	    xsmx_panel.setLayout(null);
	    xsmx_panel.setBackground(Color.cyan);
	    xsmx_panel.setOpaque(true);
	    /*
		 * ��ѯ����
		 */
	    //��ֹʱ��
		JLabel start = new JLabel("��ʼ����");
		start.setLocation(20,20);
		start.setSize(100,50);
		start.setFont(font);
		start.setForeground(Color.magenta);
		xsmx_panel.add(start);
		JLabel end = new JLabel("��������");
		end.setLocation(20,80);
		end.setSize(100,50);
		end.setFont(font);
		end.setForeground(Color.magenta);
		xsmx_panel.add(end);
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
		xsmx_panel.add(start_year);
		JLabel label_year = new JLabel("��");
		label_year.setLocation(210,20);
		label_year.setSize(50,50);
		label_year.setFont(font);
		label_year.setForeground(Color.black);
		xsmx_panel.add(label_year);
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
		xsmx_panel.add(end_year);
		JLabel label_year1 = new JLabel("��");
		label_year1.setLocation(210,80);
		label_year1.setSize(50,50);
		label_year1.setFont(font);
		label_year1.setForeground(Color.black);
		xsmx_panel.add(label_year1);
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
		xsmx_panel.add(start_month);
		JLabel label_month = new JLabel("��");
		label_month.setLocation(340,20);
		label_month.setSize(50,50);
		label_month.setForeground(Color.black);
		label_month.setFont(font);
		xsmx_panel.add(label_month);
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
		xsmx_panel.add(end_month);
		JLabel label_month1 = new JLabel("��");
		label_month1.setLocation(340,80);
		label_month1.setSize(50,50);
		label_month1.setForeground(Color.black);
		label_month1.setFont(font);
		xsmx_panel.add(label_month1);
		//��ʼ����
		start_day.setMaximumRowCount(10);
		start_day.setLocation(375,20);
		start_day.setSize(80,50);
		start_day.setFont(font);
		start_day.setEditable(false);
		start_day.setBackground(Color.white);
		xsmx_panel.add(start_day);
		JLabel label_day = new JLabel("��");
		label_day.setLocation(465,20);
		label_day.setSize(50,50);
		label_day.setForeground(Color.black);
		label_day.setFont(font);
		xsmx_panel.add(label_day);
		//��������
		end_day.setMaximumRowCount(10);
		end_day.setLocation(375,80);
		end_day.setSize(80,50);
		end_day.setFont(font);
		end_day.setEditable(false);
		end_day.setBackground(Color.white);
		xsmx_panel.add(end_day);
		JLabel label_day1 = new JLabel("��");
		label_day1.setLocation(465,80);
		label_day1.setSize(50,50);
		label_day1.setForeground(Color.black);
		label_day1.setFont(font);
		xsmx_panel.add(label_day1);
	    //��Ʒ��
		JLabel goods_box_label = new JLabel("��Ʒ��");
		goods_box_label.setLocation(20,150);
		goods_box_label.setSize(80,30);
		goods_box_label.setFont(font);
		goods_box_label.setForeground(Color.magenta);
		xsmx_panel.add(goods_box_label);
		goods_box = new JComboBox();
		goods_box.setMaximumRowCount(10);
		goods_box.setLocation(100,140);
		goods_box.setSize(150,50);
		goods_box.setFont(font);
		goods_box.setBackground(Color.white);
		xsmx_panel.add(goods_box);
		//�ͻ�
		JLabel customer_box_label = new JLabel("�ͻ�");
		customer_box_label.setLocation(270,150);
		customer_box_label.setSize(80,30);
		customer_box_label.setFont(font);
		customer_box_label.setForeground(Color.magenta);
		xsmx_panel.add(customer_box_label);
		customer_box = new JComboBox();
		customer_box.addItemListener(new boxItemListener());
		customer_box.setMaximumRowCount(10);
		customer_box.setLocation(330,140);
		customer_box.setSize(100,50);
		customer_box.setFont(font);
		customer_box.setBackground(Color.white);
		xsmx_panel.add(customer_box);
		//ҵ��Ա
		JLabel salesman_box_label = new JLabel("ҵ��Ա");
		salesman_box_label.setLocation(20,210);
		salesman_box_label.setSize(80,30);
		salesman_box_label.setFont(font);
		salesman_box_label.setForeground(Color.magenta);
		xsmx_panel.add(salesman_box_label);
		salesman_box = new JTextField();
		
		salesman_box.setLocation(100,200);
		salesman_box.setSize(150,50);
		salesman_box.setFont(font);
		salesman_box.setBackground(Color.white);
		xsmx_panel.add(salesman_box);
		//�ֿ�
		JLabel stock_box_label = new JLabel("�ֿ�");
		stock_box_label.setLocation(270,210);
		stock_box_label.setSize(80,30);
		stock_box_label.setFont(font);
		stock_box_label.setForeground(Color.magenta);
		xsmx_panel.add(stock_box_label);
		stock_box = new JComboBox();
		stock_box.setMaximumRowCount(10);
		stock_box.setLocation(330,200);
		stock_box.setSize(100,50);
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
		,{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""}};
		String[] columnName = {"ʱ��","��Ʒ��","�ͺ�","����","����","�ܶ�"};
		DefaultTableModel xsmx_model = new DefaultTableModel(xsmx_data,columnName);
		xsmx_table = new JTable(xsmx_model){
			public boolean isCellEditable(int row, int column) { return false; }
		};
		xsmx_table.getColumnModel().getColumn(0).setPreferredWidth(150);
		xsmx_table.getColumnModel().getColumn(1).setPreferredWidth(100);
		xsmx_table.getTableHeader().setReorderingAllowed(false);
		xsmx_table.setBackground(Color.cyan);
		xsmx_table.setSelectionBackground(Color.pink);
		xsmx_table.getTableHeader().setFont(font);
		xsmx_table.getTableHeader().setForeground(Color.red);
		xsmx_table.setRowHeight(33);
		xsmx_table.setFont(font);
		JScrollPane xsmx_scrollPane = new JScrollPane(xsmx_table);
		xsmx_scrollPane.getViewport().setBackground(Color.cyan);
		xsmx_scrollPane.setSize(490,300);
		xsmx_scrollPane.setLocation(0,260);
		//xsmx_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		xsmx_panel.add(xsmx_scrollPane);
		/*
		 * button�ؼ�
		 */
		//ȡ��
	    xsmx_cancel = new JButton("ȡ��");
	    xsmx_cancel.setLocation(40,560);
	    xsmx_cancel.setSize(80,50);
	    xsmx_cancel.setFont(font);
	    xsmx_cancel.setForeground(Color.magenta);
	    xsmx_cancel.setFocusPainted(false);
	    xsmx_panel.add(xsmx_cancel);
	    //ȷ��
	    xsmx_confirm = new JButton("ȷ��");
	    xsmx_confirm.addActionListener(new ButtonActionListener());
	    xsmx_confirm.setLocation(170,560);
	    xsmx_confirm.setSize(80,50);
	    xsmx_confirm.setFont(font);
	    xsmx_confirm.setForeground(Color.magenta);
	    xsmx_confirm.setFocusPainted(false);
	    xsmx_panel.add(xsmx_confirm);
	    xsmx_panel.setVisible(false);
	    frame.getContentPane().add(xsmx_panel);
	    //����EXCEL
	    xsmx_export= new JButton("����EXCEL");
	    xsmx_export.addActionListener(new ButtonActionListener());
	    xsmx_export.setLocation(300,560);
	    xsmx_export.setSize(150,50);
	    xsmx_export.setFont(font);
	    xsmx_export.setForeground(Color.magenta);
	    xsmx_export.setFocusPainted(false);
	    xsmx_panel.add(xsmx_export);
	    xsmx_panel.setVisible(false);
	    frame.getContentPane().add(xsmx_panel);
	    
	    /*
	     * �鿴��Ӫ���̱����
	     */
	    jylc_panel = new JPanel();
	    jylc_panel.setLayout(null);
	    jylc_panel.setLocation(430,20);
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
		JLabel oc_label = new JLabel("��������");
		oc_label.setLocation(10,125);
		oc_label.setSize(120,30);
		oc_label.setFont(font);
		jylc_panel.add(oc_label);
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
		mytable = new Mytable();
		jylcOrder_table = new JTable(mytable);
		jylcOrder_table.addMouseListener(new MouseActionListener());
		jylcOrder_table.setFont(font);
		jylcOrder_table.setBackground(Color.cyan);
		jylcOrder_table.setSelectionBackground(Color.pink);
		jylcOrder_table.getTableHeader().setFont(font);
		jylcOrder_table.getTableHeader().setForeground(Color.red);
		jylcOrder_table.setRowHeight(33);
		JScrollPane jo_scrollPane = new JScrollPane(jylcOrder_table);
		jo_scrollPane.getViewport().setBackground(Color.cyan);
		jo_scrollPane.setSize(490,300);
		jo_scrollPane.setLocation(0,230);
	    jylc_panel.add(jo_scrollPane);
	    //ȷ�ϡ���塢��岢����
	    jylc_confirm = new JButton("ȷ��");
	    jylc_confirm.addActionListener(new ButtonActionListener());
	    jylc_confirm.setLocation(0,545);
	    jylc_confirm.setSize(80,50);
	    jylc_confirm.setFont(font);
	    jylc_confirm.setForeground(Color.magenta);
	    jylc_confirm.setFocusPainted(false);
	    jylc_panel.add(jylc_confirm);
	    jylc_rd = new JButton("���");
	    jylc_rd.addActionListener(new ButtonActionListener());
	    jylc_rd.setLocation(90,545);
	    jylc_rd.setSize(80,50);
	    jylc_rd.setFont(font);
	    jylc_rd.setForeground(Color.magenta);
	    jylc_rd.setFocusPainted(false);
	    jylc_panel.add(jylc_rd);
	    jylc_rdac = new JButton("��岢����");
	    jylc_rdac.addActionListener(new ButtonActionListener());
	    jylc_rdac.setLocation(180,545);
	    jylc_rdac.setSize(150,50);
	    jylc_rdac.setFont(font);
	    jylc_rdac.setForeground(Color.magenta);
	    jylc_rdac.setFocusPainted(false);
	    jylc_panel.add(jylc_rdac);
		jylc_export = new JButton("����EXCEL");
	    jylc_export.addActionListener(new ButtonActionListener());
	    jylc_export.setLocation(340,545);
	    jylc_export.setSize(150,50);
	    jylc_export.setFont(font);
	    jylc_export.setForeground(Color.magenta);
	    jylc_export.setFocusPainted(false);
	    jylc_panel.add(jylc_export);
		jylc_panel.setVisible(false);
		frame.getContentPane().add(jylc_panel);
		/*
		 * �鿴��Ӫ��������
		 */
		jyqk_panel = new JPanel();
		jyqk_panel.setLayout(null);
	    jyqk_panel.setLocation(430,20);
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
		JLabel discount_label = new JLabel("����");
		discount_label.setLocation(150,245);
		discount_label.setSize(150,30);
		discount_label.setFont(font1);
		jyqk_panel.add(discount_label);
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
		
		/*
		 * �ڳ����˽���
		 */
		ae_panel = new JPanel();
		ae_panel.setLayout(null);
	    ae_panel.setLocation(500,190);
	    ae_panel.setSize(350,210);
	    ae_panel.setLayout(null);
	    ae_panel.setBackground(Color.pink);
	    ae_panel.setOpaque(true);
	    //���
	    JLabel ae_year_label = new JLabel("���");
	    ae_year_label.setLocation(30,35);
	    ae_year_label.setSize(60,30);
	    ae_year_label.setFont(font1);
	    ae_panel.add(ae_year_label);
	    ae_year = new JComboBox();
	    ae_year.setLocation(100,30);
	    ae_year.setSize(180,45);
	    ae_year.addItem("2017");
	    ae_year.addItem("2018");
	    ae_year.setMaximumRowCount(5);
	    ae_year.setFont(font);
	    ae_year.setBackground(Color.white);
	    ae_panel.add(ae_year);
	    //�ڳ�����
	    ae_makeAccount = new JButton("�ڳ�����");
	    ae_makeAccount.addActionListener(new ButtonActionListener());
	    ae_makeAccount.setLocation(20,120);
	    ae_makeAccount.setSize(120,50);
	    ae_makeAccount.setForeground(Color.red);
	    ae_makeAccount.setFont(font);
	    ae_makeAccount.setFocusPainted(false);
	    ae_panel.add(ae_makeAccount);
	    //�鿴�ڳ���Ϣ
	    ae_findAccount = new JButton("�鿴�ڳ���Ϣ");
	    ae_findAccount.addActionListener(new ButtonActionListener());
	    ae_findAccount.setLocation(160,120);
	    ae_findAccount.setSize(160,50);
	    ae_findAccount.setForeground(Color.red);
	    ae_findAccount.setFont(font);
	    ae_findAccount.setFocusPainted(false);
	    ae_panel.add(ae_findAccount);
	    
	    ae_panel.setVisible(false);
	    frame.getContentPane().add(ae_panel);
		
		//���뱳��ͼƬ
		imagePanel = new ImageJPanel(new ImageIcon("������.jpg").getImage());
		frame.getContentPane().add(imagePanel);
		frame.setVisible(true);
	}
	
	class Mytable extends AbstractTableModel{
		String[] columnNames = {"���","����","��������","ѡ��"};
		Object[][] celldata = {{"","","",new Boolean(false)},{"","","",new Boolean(false)},{"","","",new Boolean(false)},
				{"","","",new Boolean(false)},{"","","",new Boolean(false)},{"","","",new Boolean(false)},{"","","",new Boolean(false)}
				,{"","","",new Boolean(false)},{"","","",new Boolean(false)},{"","","",new Boolean(false)}};
		
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
	
	class Mytable1 extends AbstractTableModel{
		String[] columnNames = {"�����˻�","ת�˽��","��ע","ѡ��"};
		Object[][] celldata = {{"","","",new Boolean(false)},{"","","",new Boolean(false)},{"","","",new Boolean(false)},
				{"","","",new Boolean(false)},{"","","",new Boolean(false)},{"","","",new Boolean(false)},{"","","",new Boolean(false)}
				,{"","","",new Boolean(false)},{"","","",new Boolean(false)},{"","","",new Boolean(false)}};
		
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
			if(columnIndex==0){
				   return false;
			}else{
				return true;
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
			else if(e.getSource() == logout){
				frame.dispose();
				MainFrame mainframe = new MainFrame();
			}
			else if(e.getSource() == am){
				am_panel.setVisible(true);
				ro_panel.setVisible(false);
				po_panel.setVisible(false);
				mo_panel.setVisible(false);
				xsmx_panel.setVisible(false);
				jylc_panel.setVisible(false);
				jyqk_panel.setVisible(false);
				ae_panel.setVisible(false);
				DefaultTableModel model = (DefaultTableModel)account_table.getModel();
				int n = model.getRowCount() - 1;
				while(n >= 0){
					model.removeRow(n);
					n--;
				}
				BankAccountController gc = new BankAccountController(operator);
				Object[][] data = new Object[gc.queryAllBankAccount().size()][2];
				for(int i=0;i<gc.queryAllBankAccount().size();i++){
					data[i][0] = gc.queryAllBankAccount().get(i).getName();
					data[i][1] = gc.queryAllBankAccount().get(i).getMoney();				
				}
				for(int i=0;i<gc.queryAllBankAccount().size();i++){
					model.addRow(data[i]);
				}
				account_table.setModel(model);
			}
			else if(e.getSource()==search){
				String name=search_account.getText();
				DefaultTableModel model = (DefaultTableModel)account_table.getModel();
				int n = model.getRowCount() - 1;
				while(n >= 0){
					model.removeRow(n);
					n--;
				}
				BankAccountController gc = new BankAccountController(operator);
				Object[][] data = new Object[1][2];	
				data[0][0] = gc.queryBankAccountByName(name).getName();
				data[0][1] = gc.queryBankAccountByName(name).getMoney();				
				model.addRow(data[0]);	
				account_table.setModel(model);
				
			}
			else if(e.getSource() == addAccount){
				Font font = new Font("Default",Font.BOLD,20);
				am_add_frame = new JFrame("���������˻�");
				am_add_frame.setLayout(null);
				am_add_frame.setLocation(800,390);
				am_add_frame.setSize(400,300);
				am_add_frame.getContentPane().setBackground(Color.cyan);
				//�˻�
				JLabel am_add_account_label = new JLabel("�˻�");
				am_add_account_label.setLocation(30,25);
				am_add_account_label.setSize(80,30);
				am_add_account_label.setFont(font);
				am_add_frame.getContentPane().add(am_add_account_label);
				am_add_account = new JTextField();
				am_add_account.setLocation(120,20);
				am_add_account.setSize(180,40);
				am_add_account.setEditable(true);
				am_add_account.setBackground(Color.white);
				am_add_account.setFont(font);
				am_add_frame.add(am_add_account);
				//���
				JLabel am_add_money_label = new JLabel("���");
				am_add_money_label.setLocation(30,95);
				am_add_money_label.setSize(80,30);
				am_add_money_label.setFont(font);
				am_add_frame.getContentPane().add(am_add_money_label);
				am_add_money = new JTextField();
				am_add_money.setLocation(120,90);
				am_add_money.setSize(180,40);
				am_add_money.setEditable(true);
				am_add_money.setBackground(Color.white);
				am_add_money.setFont(font);
				am_add_frame.add(am_add_money);
				//ȷ��
				am_add_confirm = new JButton("ȷ��");
				am_add_confirm.addActionListener(new ButtonActionListener());
				am_add_confirm.setLocation(250,160);
				am_add_confirm.setSize(80,50);
				am_add_confirm.setFont(font);
				am_add_confirm.setForeground(Color.red);
				am_add_confirm.setFocusPainted(false);
				am_add_frame.add(am_add_confirm);
				//ȡ��
				am_add_cancel = new JButton("ȡ��");
				am_add_cancel.addActionListener(new ButtonActionListener());
				am_add_cancel.setLocation(50,160);
				am_add_cancel.setSize(80,50);
				am_add_cancel.setFont(font);
				am_add_cancel.setForeground(Color.red);
				am_add_cancel.setFocusPainted(false);
				am_add_frame.add(am_add_cancel);
				
				am_add_frame.setVisible(true);
			}
			else if(e.getSource() == am_add_cancel){
				am_add_frame.dispose();
			}
			else if(e.getSource() == am_add_confirm){
				BankAccountVO vo = new BankAccountVO();
				vo.setName(am_add_account.getText());
				vo.setMoney(Double.parseDouble(am_add_money.getText()));
				BankAccountController bc = new BankAccountController(operator);
				bc.addBankAccount(vo);
				am_add_frame.dispose();
				bc.insertLog("�����˻�");
				DefaultTableModel model = (DefaultTableModel)account_table.getModel();
				Object[] data = new Object[2];
				data[0] = am_add_account.getText();
				data[1] = am_add_money.getText();
				model.addRow(data);
			}
			else if(e.getSource() == removeAccount){
				if(removeFlag != -1){
					DefaultTableModel model = (DefaultTableModel)account_table.getModel();
					model.removeRow(removeFlag);
					account_table.setModel(model);
					removeFlag = -1;
					updateFlag = -1;
				}
			}
			else if(e.getSource() == updateAccount){
				if(updateFlag != -1){
					BankAccountController bac = new BankAccountController(operator);
					DefaultTableModel model = (DefaultTableModel)account_table.getModel();
					String newName =  model.getValueAt(updateFlag, 0).toString();
					bac.updateBankAccountName(oldName, newName);
					oldName = null;
					bac.insertLog("�޸��˻�����");
				}
			}
			else if(e.getSource() == ro){
				am_panel.setVisible(false);
				ro_panel.setVisible(true);
				po_panel.setVisible(false);
				mo_panel.setVisible(false);
				xsmx_panel.setVisible(false);
				jylc_panel.setVisible(false);
				jyqk_panel.setVisible(false);
				ae_panel.setVisible(false);
				OrderController oc=new OrderController(operator);
				ro_number.setText(oc.getReceiptNumber());
				CustomerController cc=new CustomerController(operator);
		        List<CustomerVO> list1=cc.queryCustomerByClassification(0);
		        List<CustomerVO> list2=cc.queryCustomerByClassification(1);
		        ro_retailer.removeAllItems();
		        ro_supplier.removeAllItems();
		        ro_retailer.addItem("");
		        ro_supplier.addItem("");
		        for(int i=0;i<list1.size();i++){
		        	ro_retailer.addItem(list1.get(i).getName());
		        }
		        for(int i=0;i<list2.size();i++){
		        	 ro_supplier.addItem(list2.get(i).getName());
		        }	
		        BankAccountController bc = new BankAccountController(operator);
		        List<BankAccountVO> list=bc.queryAllBankAccount();
				Object[][] data = new Object[list.size()][4];
				for(int i=0;i<list.size();i++){
					data[i][0] = list.get(i).getName();
					data[i][1] = 0.0;
					data[i][2] = "";
					data[i][3] = new Boolean(false);
				}
				ro_mytable.setData(data);
				ro_number.setEditable(false);
				ro_operator.setText(operator);
				ro_operator.setEditable(false);
			}
			else if(e.getSource() == po){
				//���
				am_panel.setVisible(false);
				ro_panel.setVisible(false);
				po_panel.setVisible(true);
				mo_panel.setVisible(false);
				xsmx_panel.setVisible(false);
				jylc_panel.setVisible(false);
				jyqk_panel.setVisible(false);
				ae_panel.setVisible(false);
				OrderController oc=new OrderController(operator);
				po_number.setText(oc.getReceiptBackNumber());
				CustomerController cc=new CustomerController(operator);
		        List<CustomerVO> list1=cc.queryCustomerByClassification(0);
		        List<CustomerVO> list2=cc.queryCustomerByClassification(1);
		        po_retailer.removeAllItems();
		        po_supplier.removeAllItems();
		        po_retailer.addItem("");
		        po_supplier.addItem("");
		        for(int i=0;i<list1.size();i++){
		        	po_retailer.addItem(list1.get(i).getName());
		        }
		        
		        for(int i=0;i<list2.size();i++){
		        	 po_supplier.addItem(list2.get(i).getName());
		        }	
		        BankAccountController bc = new BankAccountController(operator);
		        List<BankAccountVO> list=bc.queryAllBankAccount();
				Object[][] data = new Object[list.size()][4];
				for(int i=0;i<list.size();i++){
					data[i][0] = list.get(i).getName();
					data[i][1] = 0.0;
					data[i][2] = "";
					data[i][3] = new Boolean(false);
				}
				po_mytable.setData(data);
				po_number.setEditable(false);
				po_operator.setText(operator);
				po_operator.setEditable(false);
				
			}
			else if(e.getSource() == mo){
				am_panel.setVisible(false);
				ro_panel.setVisible(false);
				po_panel.setVisible(false);
				mo_panel.setVisible(true);
				xsmx_panel.setVisible(false);
				jylc_panel.setVisible(false);
				jyqk_panel.setVisible(false);
				ae_panel.setVisible(false);
				OrderController oc=new OrderController(operator);
				String ordernumber=oc.getPayOrderNumber();
				BankAccountController bc=new BankAccountController(operator);
				List<BankAccountVO> list=bc.queryAllBankAccount();
				mo_account.removeAllItems();
				for(int i=0;i<list.size();i++)
					mo_account.addItem(list.get(i).getName());
				mo_operator.setText(operator);
				mo_number.setText(ordernumber);
				mo_number.setEditable(false);
				mo_operator.setEditable(false);
			}
			else if(e.getSource() == findXSMX){
				am_panel.setVisible(false);
				ro_panel.setVisible(false);
				po_panel.setVisible(false);
				mo_panel.setVisible(false);
				xsmx_panel.setVisible(true);
				jylc_panel.setVisible(false);
				jyqk_panel.setVisible(false);
				ae_panel.setVisible(false);
				CustomerController cc=new CustomerController(operator);
				List<CustomerVO> list=cc.queryCustomer();
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
				String begin=start_year.getSelectedItem().toString()+start_month.getSelectedItem().toString()+start_day.getSelectedItem().toString();
				String end=end_year.getSelectedItem().toString()+end_month.getSelectedItem().toString()+end_day.getSelectedItem().toString();
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
				sdc.insertLog("�鿴������ϸ");
			}
			else if(e.getSource() == findJYLC){
				am_panel.setVisible(false);
				ro_panel.setVisible(false);
				po_panel.setVisible(false);
				mo_panel.setVisible(false);
				xsmx_panel.setVisible(false);
				jylc_panel.setVisible(true);
				jyqk_panel.setVisible(false);
				ae_panel.setVisible(false);
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
						mytable.setData(data);
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
						mytable.setData(data);
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
						mytable.setData(data);
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
						mytable.setData(data);
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
						mytable.setData(data);
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
						mytable.setData(data);
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
					mytable.setData(data);
				}
				bcc.insertLog("�鿴��Ӫ����");
			}
			else if(e.getSource()==jylc_rd){
				BusinessCourseController bcc=new BusinessCourseController(operator);
				CheckPurchaseController cpc=new CheckPurchaseController(operator);
				CheckReceiptController crc=new CheckReceiptController(operator);
				CheckSalesController csc=new CheckSalesController(operator);
				CheckStockController ccc=new CheckStockController(operator);
				OrderController oc=new OrderController(operator);
				StockController sc=new StockController(operator);
				Date a=new Date();
				String str=DatetoString.datetostr(a);
				for(int i=0;i<mytable.getRowCount();i++){					
					if((boolean)mytable.getValueAt(i, 3)){
						if(mytable.getValueAt(i, 2).equals("���۵�")){
							SalesOrderVO vo=csc.querySalesByNumber(mytable.getValueAt(i, 0).toString());
							vo.setNumber(oc.getSalesOrderNumber());
							vo.setDate(str);
							ResultMessage rm=bcc.RedDashSalesOrder(vo);
                            bcc.insertLog("������۵�");
						}
						if(mytable.getValueAt(i, 2).equals("�����˻���")){
							SalesBackOrderVO vo=csc.querySalesBackByNumber(mytable.getValueAt(i, 0).toString());
							vo.setNumber(oc.getSalesBackOrderNumber());
							vo.setDate(str);
							ResultMessage rm=bcc.RedDashSalesBackOrder(vo);
							bcc.insertLog("��������˻���");
						}
						if(mytable.getValueAt(i, 2).equals("������")){
							PurchaseOrderVO vo=cpc.queryPurchaseByNumber(mytable.getValueAt(i, 0).toString());
							vo.setNumber(oc.getPurchaseOrderNumber());
							vo.setDate(str);
							ResultMessage rm=bcc.RedDashPurchaseOrder(vo);	
							bcc.insertLog("��������");
						}
						if(mytable.getValueAt(i, 2).equals("�����˻���")){
							PurchaseBackOrderVO vo=cpc.queryPurchaseBackByNumber(mytable.getValueAt(i, 0).toString());
							vo.setNumber(oc.getPurchaseBackOrderNumber());
							vo.setDate(str);
							ResultMessage rm=bcc.RedDashPurchaseBackOrder(vo);	
							bcc.insertLog("�������˻���");
						}
						if(mytable.getValueAt(i, 2).equals("�տ")){
							ReceiptVO vo=crc.queryReceiptByNumber(mytable.getValueAt(i, 0).toString());
							vo.setNumber(oc.getReceiptNumber());
							vo.setDate(str);
							ResultMessage rm=bcc.RedDashReceipt(vo);
							bcc.insertLog("����տ");
						}
						if(mytable.getValueAt(i, 2).equals("���")){
							ReceiptBackVO vo=crc.queryReceiptBackByNumber(mytable.getValueAt(i, 0).toString());
							vo.setNumber(oc.getReceiptBackNumber());
							vo.setDate(str);
							ResultMessage rm=bcc.RedDashReceiptBack(vo);
							bcc.insertLog("��帶�");
						}
						if(mytable.getValueAt(i, 2).equals("�ֽ���õ�")){
							PayOrderVO vo=crc.queryPayOrderByNumber(mytable.getValueAt(i, 0).toString());
							System.out.println(oc.getPayOrderNumber());
							vo.setNumber(oc.getPayOrderNumber());
							vo.setDate(str);
							ResultMessage rm=bcc.RedDashPayOrder(vo);
							bcc.insertLog("����ֽ���õ�");
						}
						if(mytable.getValueAt(i, 2).equals("��汨��")){
							StockLossOrderVO vo=ccc.queryStockLossOrderByNumber(mytable.getValueAt(i, 0).toString());
							vo.setOrdernumber2(sc.getStockLossOrderNumber());
							vo.setDate(str);
							ResultMessage rm=bcc.RedDashStockLossOrder(vo);
							bcc.insertLog("����汨��");
						}
						if(mytable.getValueAt(i, 2).equals("��汨�絥")){
							StockOverflowOrderVO vo=ccc.queryStockOverflowOrderByNumber(mytable.getValueAt(i, 0).toString());
							vo.setOrdernumber2(sc.getStockOverflowOrderNumber());
							vo.setDate(str);
							ResultMessage rm=bcc.RedDashStockOverflowOrder(vo);
							bcc.insertLog("����汨�絥");
						}
						if(mytable.getValueAt(i, 2).equals("������͵�")){
							StockGrantOrderVO vo=ccc.queryStockGrantOrderByNumber(mytable.getValueAt(i, 0).toString());
							vo.setOrdernumber2(sc.getStockGrantOrderNumber());
							vo.setDate(str);
							ResultMessage rm=bcc.RedDashStockGrantOrder(vo);
							bcc.insertLog("��������͵�");
						}
					}
				}
			}
			else if(e.getSource()==jylc_rdac){
				/*
				 * ���
				 */
				Date a=new Date();
				String str1=DatetoString.datetostr(a);
				BusinessCourseController bcc=new BusinessCourseController(operator);
				CheckPurchaseController cpc=new CheckPurchaseController(operator);
				CheckReceiptController crc=new CheckReceiptController(operator);
				CheckSalesController csc=new CheckSalesController(operator);
				CheckStockController ccc=new CheckStockController(operator);
				OrderController oc=new OrderController(operator);
				StockController sc=new StockController(operator);
				for(int i=0;i<mytable.getRowCount();i++){					
					if((boolean)mytable.getValueAt(i, 3)){
						if(mytable.getValueAt(i, 2).equals("���۵�")){
							SalesOrderVO vo=csc.querySalesByNumber(mytable.getValueAt(i, 0).toString());
							vo.setNumber(oc.getSalesOrderNumber());
							vo.setDate(str1);
							ResultMessage rm=bcc.RedDashSalesOrder(vo);
							bcc.insertLog("������۵�");
						}
						if(mytable.getValueAt(i, 2).equals("�����˻���")){
							SalesBackOrderVO vo=csc.querySalesBackByNumber(mytable.getValueAt(i, 0).toString());
							vo.setNumber(oc.getSalesBackOrderNumber());
							vo.setDate(str1);
							ResultMessage rm=bcc.RedDashSalesBackOrder(vo);
							bcc.insertLog("��������˻���");
						}
						if(mytable.getValueAt(i, 2).equals("������")){
							PurchaseOrderVO vo=cpc.queryPurchaseByNumber(mytable.getValueAt(i, 0).toString());
							vo.setNumber(oc.getPurchaseOrderNumber());
							vo.setDate(str1);
							ResultMessage rm=bcc.RedDashPurchaseOrder(vo);	
							bcc.insertLog("��������");
						}
						if(mytable.getValueAt(i, 2).equals("�����˻���")){
							PurchaseBackOrderVO vo=cpc.queryPurchaseBackByNumber(mytable.getValueAt(i, 0).toString());
							vo.setNumber(oc.getPurchaseBackOrderNumber());
							vo.setDate(str1);
							ResultMessage rm=bcc.RedDashPurchaseBackOrder(vo);	
							bcc.insertLog("�������˻���");
						}
						if(mytable.getValueAt(i, 2).equals("�տ")){
							ReceiptVO vo=crc.queryReceiptByNumber(mytable.getValueAt(i, 0).toString());
							vo.setNumber(oc.getReceiptNumber());
							vo.setDate(str1);
							ResultMessage rm=bcc.RedDashReceipt(vo);
							bcc.insertLog("����տ");
						}
						if(mytable.getValueAt(i, 2).equals("���")){
							ReceiptBackVO vo=crc.queryReceiptBackByNumber(mytable.getValueAt(i, 0).toString());
							vo.setNumber(oc.getReceiptBackNumber());
							vo.setDate(str1);
							ResultMessage rm=bcc.RedDashReceiptBack(vo);
							bcc.insertLog("��帶�");
						}
						if(mytable.getValueAt(i, 2).equals("�ֽ���õ�")){
							PayOrderVO vo=crc.queryPayOrderByNumber(mytable.getValueAt(i, 0).toString());
							vo.setNumber(oc.getPayOrderNumber());
							vo.setDate(str1);
							ResultMessage rm=bcc.RedDashPayOrder(vo);
							bcc.insertLog("����ֽ���õ�");
						}
						if(mytable.getValueAt(i, 2).equals("��汨��")){
							StockLossOrderVO vo=ccc.queryStockLossOrderByNumber(mytable.getValueAt(i, 0).toString());
							vo.setOrdernumber2(sc.getStockLossOrderNumber());
							vo.setDate(str1);
							ResultMessage rm=bcc.RedDashStockLossOrder(vo);
							bcc.insertLog("����汨��");
						}
						if(mytable.getValueAt(i, 2).equals("��汨�絥")){
							StockOverflowOrderVO vo=ccc.queryStockOverflowOrderByNumber(mytable.getValueAt(i, 0).toString());
							vo.setOrdernumber2(sc.getStockOverflowOrderNumber());
							vo.setDate(str1);
							ResultMessage rm=bcc.RedDashStockOverflowOrder(vo);
							bcc.insertLog("����汨�絥");
						}
						if(mytable.getValueAt(i, 2).equals("������͵�")){
							StockGrantOrderVO vo=ccc.queryStockGrantOrderByNumber(mytable.getValueAt(i, 0).toString());
							vo.setOrdernumber2(sc.getStockGrantOrderNumber());
							vo.setDate(str1);
							ResultMessage rm=bcc.RedDashStockGrantOrder(vo);
							bcc.insertLog("��������͵�");
						}
					}
				}
				/*
				 * ����
				 */
				for(int i=0;i<jylcOrder_table.getRowCount();i++){
					if((boolean)mytable.getValueAt(i, 3)){
						String str = mytable.getValueAt(i, 0).toString();
						if(str.equals("XSD")){
				    		new SalesOrderFrame(str,operator,1);
				    	}
				    	else if(str.substring(0,3).equals("JHD")){
				    		new PurchaseOrderFrame(str,operator,1);
				    	}
				    	else if(str.substring(0,3).equals("XST")){
				    		new SalesBackOrderFrame(str,operator,1);
				    	}
				    	else if(str.substring(0,3).equals("XSD")){
				    		new SalesOrderFrame(str,operator,1);
				    	}
				    	else if(str.substring(0,3).equals("JHT")){
				    		new PurchaseBackOrderFrame(str,operator,1);
				    	}
				    	else if(str.substring(0,3).equals("FKD")){
				    		new ReceiptBackFrame(str,operator,1);
				    	}
				    	else if(str.substring(0,3).equals("SKD")){
				    		new ReceiptOrderFrame(str,operator,1);
				    	}
				    	else if(str.substring(0,3).equals("XJF")){
				    		new MoneyOrderFrame(str,operator,1);
				    	}
				    	else if(str.substring(0,3).equals("BSD")){
				    		new StockLossFrame(str,operator,1);
				    	}
				    	else if(str.substring(0,3).equals("BYD")){
				    		new StockOverflowFrame(str,operator,1);
				    	}
				    	else if(str.substring(0,3).equals("ZSD")){
				    		new StockGrantFrame(str,operator,1);
				    	}
					}
				}
			}
			else if(e.getSource() == findJYQK){
				am_panel.setVisible(false);
				ro_panel.setVisible(false);
				po_panel.setVisible(false);
				mo_panel.setVisible(false);
				xsmx_panel.setVisible(false);
				jylc_panel.setVisible(false);
				jyqk_panel.setVisible(true);
				ae_panel.setVisible(false);
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
				msc.insertLog("�鿴��Ӫ�����");
			}
			else if(e.getSource() == jyqk_analyse){
				JFrame frame=new JFrame("����ͳ��ͼ");
			    frame.setLayout(new GridLayout(2,1,10,10));
			    frame.add(new PieChart("������").getChartPanel());     
			    frame.add(new PieChart("֧����").getChartPanel());   
			    frame.setBounds(100, 100, 800, 800);
			    frame.setVisible(true);
			}
			else if(e.getSource()==ro_submit){
				OrderController oc=new OrderController(operator);
				ReceiptVO vo=new ReceiptVO();
				Date a=new Date();
				String str=DatetoString.datetostr(a);
				List<TransferAccountVO> list=new ArrayList<TransferAccountVO>();
				for(int i=0;i<ro_ta_table.getRowCount();i++){					
					if((boolean)ro_ta_table.getValueAt(i, 3)){
						TransferAccountVO g = new TransferAccountVO();
						g.setBankaccount(ro_ta_table.getValueAt(i, 0).toString());
						g.setMoney(Double.parseDouble(ro_ta_table.getValueAt(i, 1).toString()));
						if(!ro_ta_table.getValueAt(i, 2).toString().equals(""))
							g.setComment(ro_ta_table.getValueAt(i, 2).toString());
						else
							g.setComment("��");
						list.add(g);
					}
				}
				String number=oc.getReceiptNumber();
				vo.setDate(str);
				vo.setIscheck(0);
				vo.setList(list);
				vo.setNumber(number);
				vo.setOperator(operator);
				vo.setProvider(ro_supplier.getSelectedItem().toString());
				vo.setSalesperson(ro_retailer.getSelectedItem().toString());
				vo.setTotal(Double.valueOf(ro_addAll.getText()));
				oc.CreateNewReceipt(vo);
				oc.insertLog("�����տ");
				JOptionPane.showMessageDialog(frame.getContentPane(), "�ύ�ɹ���");
			}
			else if(e.getSource() == ro_editDraft){
				Font font = new Font("Default",Font.BOLD,20);
				ro_editDraft_frame = new JFrame("ѡ��ݸ�");
				ro_editDraft_frame.setLocation(850,400);
				ro_editDraft_frame.setSize(350,200);
				ro_editDraft_frame.setLayout(null);
				ro_editDraft_frame.getContentPane().setBackground(Color.cyan);
				//�ݸ���
				JLabel ro_editDraft_draftNumber_label = new JLabel("���");
				ro_editDraft_draftNumber_label.setLocation(10,20);
				ro_editDraft_draftNumber_label.setSize(50,30);
				ro_editDraft_draftNumber_label.setFont(font);
				ro_editDraft_frame.add(ro_editDraft_draftNumber_label);
				ro_editDraft_draftNumber = new JComboBox();
				//��������
				OrderController oc = new OrderController(operator);
				List<ReceiptVO> list = oc.querydraftReceipt();
				ro_editDraft_draftNumber.removeAllItems();
				for(int i=0;i<list.size();i++){
					ro_editDraft_draftNumber.addItem(list.get(i).getNumber());
				}
				ro_editDraft_draftNumber.setMaximumRowCount(5);
				ro_editDraft_draftNumber.setLocation(70,20);
				ro_editDraft_draftNumber.setSize(230,40);
				ro_editDraft_draftNumber.setFont(font);
				ro_editDraft_draftNumber.setBackground(Color.white);
				ro_editDraft_frame.add(ro_editDraft_draftNumber);
				//ȡ��
				ro_editDraft_cancel = new JButton("ȡ��");
				ro_editDraft_cancel.addActionListener(new ButtonActionListener());
				ro_editDraft_cancel.setLocation(30,80);
				ro_editDraft_cancel.setSize(100,50);
				ro_editDraft_cancel.setFont(font);
				ro_editDraft_cancel.setForeground(Color.red);
				ro_editDraft_cancel.setFocusPainted(false);
				ro_editDraft_frame.add(ro_editDraft_cancel);
				//ȷ��
				ro_editDraft_confirm = new JButton("ȷ��");
				ro_editDraft_confirm.addActionListener(new ButtonActionListener());
				ro_editDraft_confirm.setLocation(200,80);
				ro_editDraft_confirm.setSize(100,50);
				ro_editDraft_confirm.setFont(font);
				ro_editDraft_confirm.setForeground(Color.red);
				ro_editDraft_confirm.setFocusPainted(false);
				ro_editDraft_frame.add(ro_editDraft_confirm);
				ro_editDraft_frame.setVisible(true);
			}
			else if(e.getSource() == ro_editDraft_cancel){
				ro_editDraft_frame.dispose();
			}
			else if(e.getSource() == ro_editDraft_confirm){
				CheckReceiptController crc = new CheckReceiptController(operator);
				ReceiptVO vo = crc.queryReceiptByNumber(ro_editDraft_draftNumber.getSelectedItem().toString());
				ro_number.setText(vo.getNumber());
				ro_supplier.setSelectedItem(vo.getProvider());
				ro_retailer.setSelectedItem(vo.getSalesperson());
				ro_operator.setText(vo.getOperator());
				ro_addAll.setText(vo.getTotal()+"");
				List<TransferAccountVO> list = vo.getList();
				int j = 0;
				for(int i=0;i<ro_ta_table.getRowCount();i++){
					if(ro_mytable.getValueAt(i, 0).equals(list.get(j).getBankaccount())){
						ro_mytable.setValueAt(list.get(j).getMoney(), i, 1);
						ro_mytable.setValueAt(list.get(j).getComment(), i, 2);
						ro_mytable.setValueAt(new Boolean(true), i, 3);
						j++;
						if(j == list.size()){
							break;
						}
					}
				}
				ro_editDraft_frame.dispose();
			}
			else if(e.getSource()==ro_saveDraft){
				OrderController oc=new OrderController(operator);
				ReceiptVO vo=new ReceiptVO();
				Date a=new Date();
				String str=DatetoString.datetostr(a);
				List<TransferAccountVO> list=new ArrayList<TransferAccountVO>();
				for(int i=0;i<ro_ta_table.getRowCount();i++){					
					if((boolean)ro_ta_table.getValueAt(i, 3)){
						TransferAccountVO g = new TransferAccountVO();
						g.setBankaccount(ro_ta_table.getValueAt(i, 0).toString());
						g.setMoney(Double.parseDouble(ro_ta_table.getValueAt(i, 1).toString()));
						if(!ro_ta_table.getValueAt(i, 2).toString().equals(""))
							g.setComment(ro_ta_table.getValueAt(i, 2).toString());
						else
							g.setComment("��");
						list.add(g);
					}
				}
				String number=oc.getReceiptNumber();
				vo.setDate(str);
				vo.setIscheck(2);
				vo.setList(list);
				vo.setNumber(number);
				vo.setOperator(operator);
				vo.setProvider(ro_supplier.getSelectedItem().toString());
				vo.setSalesperson(ro_retailer.getSelectedItem().toString());
				vo.setTotal(Double.valueOf(ro_addAll.getText()));
				oc.draftReceiptOrder(vo);
				oc.insertLog("�����տ�ݸ�");
			}
			else if(e.getSource() == po_editDraft){
				Font font = new Font("Default",Font.BOLD,20);
				po_editDraft_frame = new JFrame("ѡ��ݸ�");
				po_editDraft_frame.setLocation(850,400);
				po_editDraft_frame.setSize(350,200);
				po_editDraft_frame.setLayout(null);
				po_editDraft_frame.getContentPane().setBackground(Color.cyan);
				//�ݸ���
				JLabel po_editDraft_draftNumber_label = new JLabel("���");
				po_editDraft_draftNumber_label.setLocation(10,20);
				po_editDraft_draftNumber_label.setSize(50,30);
				po_editDraft_draftNumber_label.setFont(font);
				po_editDraft_frame.add(po_editDraft_draftNumber_label);
				po_editDraft_draftNumber = new JComboBox();
				//��������
				OrderController oc = new OrderController(operator);
				List<ReceiptBackVO> list = oc.querydraftReceiptBack();
				po_editDraft_draftNumber.removeAllItems();
				for(int i=0;i<list.size();i++){
					po_editDraft_draftNumber.addItem(list.get(i).getNumber());
				}
				po_editDraft_draftNumber.setMaximumRowCount(5);
				po_editDraft_draftNumber.setLocation(70,20);
				po_editDraft_draftNumber.setSize(230,40);
				po_editDraft_draftNumber.setFont(font);
				po_editDraft_draftNumber.setBackground(Color.white);
				po_editDraft_frame.add(po_editDraft_draftNumber);
				//ȡ��
				po_editDraft_cancel = new JButton("ȡ��");
				po_editDraft_cancel.addActionListener(new ButtonActionListener());
				po_editDraft_cancel.setLocation(30,80);
				po_editDraft_cancel.setSize(100,50);
				po_editDraft_cancel.setFont(font);
				po_editDraft_cancel.setForeground(Color.red);
				po_editDraft_cancel.setFocusPainted(false);
				po_editDraft_frame.add(po_editDraft_cancel);
				//ȷ��
				po_editDraft_confirm = new JButton("ȷ��");
				po_editDraft_confirm.addActionListener(new ButtonActionListener());
				po_editDraft_confirm.setLocation(200,80);
				po_editDraft_confirm.setSize(100,50);
				po_editDraft_confirm.setFont(font);
				po_editDraft_confirm.setForeground(Color.red);
				po_editDraft_confirm.setFocusPainted(false);
				po_editDraft_frame.add(po_editDraft_confirm);
				po_editDraft_frame.setVisible(true);
			}
			else if(e.getSource() == po_editDraft_cancel){
				po_editDraft_frame.dispose();
			}
			else if(e.getSource() == po_editDraft_confirm){
				CheckReceiptController crc = new CheckReceiptController(operator);
				ReceiptBackVO vo = crc.queryReceiptBackByNumber(po_editDraft_draftNumber.getSelectedItem().toString());
				po_number.setText(vo.getNumber());
				po_supplier.setSelectedItem(vo.getProvider());
				po_retailer.setSelectedItem(vo.getSalesperson());
				po_operator.setText(vo.getOperator());
				po_addAll.setText(vo.getTotal()+"");
				List<TransferAccountVO> list = vo.getList();
				int j = 0;
				for(int i=0;i<po_ta_table.getRowCount();i++){
					if(po_mytable.getValueAt(i, 0).equals(list.get(j).getBankaccount())){
						po_mytable.setValueAt(list.get(j).getMoney(), i, 1);
						po_mytable.setValueAt(list.get(j).getComment(), i, 2);
						po_mytable.setValueAt(new Boolean(true), i, 3);
						j++;
						if(j == list.size()){
							break;
						}
					}
				}
				po_editDraft_frame.dispose();
			}
			else if(e.getSource()==po_submit){
				OrderController oc=new OrderController(operator);
				ReceiptBackVO vo=new ReceiptBackVO();
				Date a=new Date();
				String str=DatetoString.datetostr(a);
				List<TransferAccountVO> list=new ArrayList<TransferAccountVO>();
				for(int i=0;i<po_ta_table.getRowCount();i++){					
					if((boolean)po_ta_table.getValueAt(i, 3)){
						TransferAccountVO g = new TransferAccountVO();
						g.setBankaccount(po_ta_table.getValueAt(i, 0).toString());
						g.setMoney(Double.parseDouble(po_ta_table.getValueAt(i, 1).toString()));
						if(!po_ta_table.getValueAt(i, 2).toString().equals(""))
							g.setComment(po_ta_table.getValueAt(i, 2).toString());
						else
							g.setComment("��");
						list.add(g);
					}
				}
				String number=oc.getReceiptBackNumber();
				vo.setDate(str);
				vo.setIscheck(0);
				vo.setList(list);
				vo.setNumber(number);
				vo.setOperator(operator);
				vo.setProvider(po_supplier.getSelectedItem().toString());
				vo.setSalesperson(po_retailer.getSelectedItem().toString());
				vo.setTotal(Double.valueOf(po_addAll.getText()));
				oc.CreateReceiptBack(vo);
				oc.insertLog("�������");
				JOptionPane.showMessageDialog(frame.getContentPane(), "�ύ�ɹ���");
			}
			else if(e.getSource()==po_saveDraft){
				OrderController oc=new OrderController(operator);
				ReceiptBackVO vo=new ReceiptBackVO();
				Date a=new Date();
				String str=DatetoString.datetostr(a);
				List<TransferAccountVO> list=new ArrayList<TransferAccountVO>();
				for(int i=0;i<po_ta_table.getRowCount();i++){					
					if((boolean)po_ta_table.getValueAt(i, 3)){
						TransferAccountVO g = new TransferAccountVO();
						g.setBankaccount(po_ta_table.getValueAt(i, 0).toString());
						g.setMoney(Double.parseDouble(po_ta_table.getValueAt(i, 1).toString()));
						if(!po_ta_table.getValueAt(i, 2).toString().equals(""))
							g.setComment(po_ta_table.getValueAt(i, 2).toString());
						else
							g.setComment("��");
						list.add(g);
					}
				}
				
				vo.setDate(str);
				vo.setIscheck(2);
				vo.setList(list);
				vo.setNumber(po_number.getText());
				vo.setOperator(operator);
				vo.setProvider(po_supplier.getSelectedItem().toString());
				vo.setSalesperson(po_retailer.getSelectedItem().toString());
				vo.setTotal(Double.valueOf(po_addAll.getText()));
				System.out.println(vo.getNumber());
				oc.draftReceiptBack(vo);
				oc.insertLog("���渶��ݸ�");
				
			}
			else if(e.getSource()==mo_submit){
				OrderController oc=new OrderController(operator);
				PayOrderVO vo=new PayOrderVO();
				Date a=new Date();
				String str=DatetoString.datetostr(a);
				List<TiaoMuVO> list=new ArrayList<TiaoMuVO>();
				DefaultTableModel model = (DefaultTableModel)tm_table.getModel();
				for(int i=0;i<model.getRowCount();i++){					
					if(!model.getValueAt(i, 0).equals("")){
						TiaoMuVO g = new TiaoMuVO();
						g.setName(model.getValueAt(i, 0).toString());
						g.setMoney(Double.parseDouble(model.getValueAt(i, 1).toString()));
						if(!model.getValueAt(i, 2).toString().equals(""))
							g.setComment(model.getValueAt(i, 2).toString());
						else
							g.setComment("��");
						list.add(g);
					}
				}
				String number=oc.getPayOrderNumber();
				vo.setDate(str);
				vo.setIscheck(1);
				vo.setList(list);
				vo.setNumber(number);
				vo.setOperator(operator);
				vo.setBankaccountname(mo_account.getSelectedItem().toString());
				vo.setTotal(Double.valueOf(mo_addAll.getText()));
				oc.CreateNewPayOrder(vo);
				oc.insertLog("�����ֽ���õ�");
				JOptionPane.showMessageDialog(frame.getContentPane(), "�ύ�ɹ���");
			}
			else if(e.getSource() == mo_editDraft){
				Font font = new Font("Default",Font.BOLD,20);
				mo_editDraft_frame = new JFrame("ѡ��ݸ�");
				mo_editDraft_frame.setLocation(850,400);
				mo_editDraft_frame.setSize(350,200);
				mo_editDraft_frame.setLayout(null);
				mo_editDraft_frame.getContentPane().setBackground(Color.cyan);
				//�ݸ���
				JLabel mo_editDraft_draftNumber_label = new JLabel("���");
				mo_editDraft_draftNumber_label.setLocation(10,20);
				mo_editDraft_draftNumber_label.setSize(50,30);
				mo_editDraft_draftNumber_label.setFont(font);
				mo_editDraft_frame.add(mo_editDraft_draftNumber_label);
				mo_editDraft_draftNumber = new JComboBox();
				//��������
				OrderController oc = new OrderController(operator);
				List<PayOrderVO> list = oc.querydraftPayOrder();
				mo_editDraft_draftNumber.removeAllItems();
				for(int i=0;i<list.size();i++){
					mo_editDraft_draftNumber.addItem(list.get(i).getNumber());
				}
				mo_editDraft_draftNumber.setMaximumRowCount(5);
				mo_editDraft_draftNumber.setLocation(70,20);
				mo_editDraft_draftNumber.setSize(230,40);
				mo_editDraft_draftNumber.setFont(font);
				mo_editDraft_draftNumber.setBackground(Color.white);
				mo_editDraft_frame.add(mo_editDraft_draftNumber);
				//ȡ��
				mo_editDraft_cancel = new JButton("ȡ��");
				mo_editDraft_cancel.addActionListener(new ButtonActionListener());
				mo_editDraft_cancel.setLocation(30,80);
				mo_editDraft_cancel.setSize(100,50);
				mo_editDraft_cancel.setFont(font);
				mo_editDraft_cancel.setForeground(Color.red);
				mo_editDraft_cancel.setFocusPainted(false);
				mo_editDraft_frame.add(mo_editDraft_cancel);
				//ȷ��
				mo_editDraft_confirm = new JButton("ȷ��");
				mo_editDraft_confirm.addActionListener(new ButtonActionListener());
				mo_editDraft_confirm.setLocation(200,80);
				mo_editDraft_confirm.setSize(100,50);
				mo_editDraft_confirm.setFont(font);
				mo_editDraft_confirm.setForeground(Color.red);
				mo_editDraft_confirm.setFocusPainted(false);
				mo_editDraft_frame.add(mo_editDraft_confirm);
				mo_editDraft_frame.setVisible(true);
			}
			else if(e.getSource() == po_editDraft_cancel){
				mo_editDraft_frame.dispose();
			}
			else if(e.getSource() == mo_editDraft_confirm){
				CheckReceiptController crc = new CheckReceiptController(operator);
				PayOrderVO vo = crc.queryPayOrderByNumber(mo_editDraft_draftNumber.getSelectedItem().toString());
				mo_number.setText(vo.getNumber());
				mo_operator.setText(vo.getOperator());
				mo_addAll.setText(vo.getTotal()+"");
				List<TiaoMuVO> list = vo.getList();
				DefaultTableModel model = (DefaultTableModel)tm_table.getModel();
				int row = tm_table.getRowCount()-1;
				for(int i=row;i>=0;i--){
					model.removeRow(i);
				}
				Object[][] data = new Object[list.size()][3];
				for(int i=0;i<list.size();i++){
					data[i][0] = list.get(i).getName();
					data[i][1] = list.get(i).getMoney();
					data[i][2] = list.get(i).getComment();
				}
				for(int i=0;i<list.size();i++){
					model.addRow(data[i]);
				}
				mo_editDraft_frame.dispose();
			}
			else if(e.getSource()==mo_saveDraft){
				OrderController oc=new OrderController(operator);
				PayOrderVO vo=new PayOrderVO();
				Date a=new Date();
				String str=DatetoString.datetostr(a);
				List<TiaoMuVO> list=new ArrayList<TiaoMuVO>();
				DefaultTableModel model = (DefaultTableModel)tm_table.getModel();
				for(int i=0;i<model.getRowCount();i++){					
					if(!model.getValueAt(i, 0).equals("")){
						TiaoMuVO g = new TiaoMuVO();
						g.setName(model.getValueAt(i, 0).toString());
						g.setMoney(Double.parseDouble(model.getValueAt(i, 1).toString()));
						if(!model.getValueAt(i, 2).toString().equals(""))
							g.setComment(model.getValueAt(i, 2).toString());
						else
							g.setComment("��");
						list.add(g);
					}
				}
				String number=oc.getPayOrderNumber();
				vo.setDate(str);
				vo.setIscheck(2);
				vo.setList(list);
				vo.setNumber(number);
				vo.setOperator(operator);
				vo.setBankaccountname(mo_account.getSelectedItem().toString());
				vo.setTotal(Double.valueOf(mo_addAll.getText()));
				oc.draftPayOrder(vo);
				oc.insertLog("�����ֽ���õ��ݸ�");
			}
			else if(e.getSource() == ae){
				am_panel.setVisible(false);
				ro_panel.setVisible(false);
				po_panel.setVisible(false);
				mo_panel.setVisible(false);
				xsmx_panel.setVisible(false);
				jylc_panel.setVisible(false);
				jyqk_panel.setVisible(false);
				ae_panel.setVisible(true);
			}
			else if(e.getSource() == ae_makeAccount){
			    SetBookController sbc = new SetBookController(operator);
			    sbc.SetBook();
			    sbc.insertLog("�ڳ�����");
			}
			else if(e.getSource() == ae_findAccount){
				Font font = new Font("Default",Font.BOLD,20);
				Font font0 = new Font("Default",Font.BOLD,30);
				findAccount_frame = new JFrame("�ڳ���Ϣ");
				findAccount_frame.setLocation(300,200);
				findAccount_frame.setSize(1420,600);
				findAccount_frame.setLayout(null);
				findAccount_frame.getContentPane().setBackground(Color.cyan);
				findAccount_frame.setVisible(true);
				/*
				 * ��Ʒ��Ϣ��
				 */
				JLabel goods_label = new JLabel("��Ʒ��Ϣ");
				goods_label.setLocation(240,20);
				goods_label.setSize(150,30);
				goods_label.setFont(font0);
				goods_label.setForeground(Color.magenta);
				findAccount_frame.add(goods_label);
				Object[][] goods_data = {};
				String[] goods_columnNames = {"��Ʒ����","����","����","����","�ۼ�","�������","����ۼ�"};
				DefaultTableModel goods_model = new DefaultTableModel(goods_data,goods_columnNames);
				JTable qc_goods = new JTable(goods_model){
					public boolean isCellEditable(int rowIndex, int columnIndex){
						return false;
					}
				};
				qc_goods.setFont(font);
				qc_goods.setBackground(Color.cyan);
				qc_goods.setSelectionBackground(Color.pink);
				qc_goods.getTableHeader().setFont(font);
				qc_goods.getTableHeader().setForeground(Color.red);
				qc_goods.setRowHeight(40);
				JScrollPane qc_goods_scrollPane = new JScrollPane(qc_goods);
				qc_goods_scrollPane.setSize(650,450);
				qc_goods_scrollPane.setLocation(0,70);
				qc_goods_scrollPane.getViewport().setBackground(Color.cyan);
			    findAccount_frame.add(qc_goods_scrollPane);
			    /*
			     * �ͻ���Ϣ��
			     */
			    JLabel customer_label = new JLabel("�ͻ���Ϣ");
			    customer_label.setLocation(860,20);
			    customer_label.setSize(150,30);
			    customer_label.setFont(font0);
			    customer_label.setForeground(Color.magenta);
				findAccount_frame.add(customer_label);
			    Object[][] customer_data = {};
				String[] customer_columnNames = {"�ͻ�����","����","��ϵ��ʽ","Ӧ��","Ӧ��"};
				DefaultTableModel customer_model = new DefaultTableModel(customer_data,customer_columnNames);
				JTable qc_customer = new JTable(customer_model){
					public boolean isCellEditable(int rowIndex, int columnIndex){
						return false;
					}
				};
				qc_customer.setFont(font);
				qc_customer.setBackground(Color.cyan);
				qc_customer.setSelectionBackground(Color.pink);
				qc_customer.getTableHeader().setFont(font);
				qc_customer.getTableHeader().setForeground(Color.red);
				qc_customer.setRowHeight(40);
				JScrollPane qc_customer_scrollPane = new JScrollPane(qc_customer);
				qc_customer_scrollPane.setSize(500,450);
				qc_customer_scrollPane.setLocation(680,70);
				qc_customer_scrollPane.getViewport().setBackground(Color.cyan);
			    findAccount_frame.add(qc_customer_scrollPane);
			    /*
			     * �˻���Ϣ��
			     */
			    JLabel account_label = new JLabel("�˻���Ϣ");
			    account_label.setLocation(1240,20);
			    account_label.setSize(150,30);
			    account_label.setFont(font0);
			    account_label.setForeground(Color.magenta);
				findAccount_frame.add(account_label);
			    Object[][] account_data = {};
				String[] account_columnNames = {"����","���"};
				DefaultTableModel account_model = new DefaultTableModel(account_data,account_columnNames);
				JTable qc_account = new JTable(account_model){
					public boolean isCellEditable(int rowIndex, int columnIndex){
						return false;
					}
				};
				qc_account.setFont(font);
				qc_account.setBackground(Color.cyan);
				qc_account.setSelectionBackground(Color.pink);
				qc_account.getTableHeader().setFont(font);
				qc_account.getTableHeader().setForeground(Color.red);
				qc_account.setRowHeight(40);
				JScrollPane qc_account_scrollPane = new JScrollPane(qc_account);
				qc_account_scrollPane.setSize(200,450);
				qc_account_scrollPane.setLocation(1200,70);
				qc_account_scrollPane.getViewport().setBackground(Color.cyan);
			    findAccount_frame.add(qc_account_scrollPane);
			    //��������
			    SetBookController sbc = new SetBookController(operator);
			    String s = sbc.LookBook(ae_year.getSelectedItem().toString());
			    String[] str = s.split(",");
			    String[] account_str = str[0].split(" ");
			    String[] goods_str = str[1].split(" ");
			    String[] customer_str = str[2].split(" ");
			    //�����Ʒ��Ϣ
			    Object[][] data = new Object[goods_str.length / 7][7];
			    for(int i=0;i<goods_str.length / 7;i++){
			    	data[i][0] = goods_str[i*7 + 0];
			    	data[i][1] = goods_str[i*7 + 1];
			    	data[i][2] = goods_str[i*7 + 2];
			    	data[i][3] = goods_str[i*7 + 3];
			    	data[i][4] = goods_str[i*7 + 4];
			    	data[i][5] = goods_str[i*7 + 5];
			    	data[i][6] = goods_str[i*7 + 6];
			    }
			    for(int i=0;i<data.length;i++){
			    	goods_model.addRow(data[i]);
			    }
			    //����˻���Ϣ
			    Object[][] data1 = new Object[account_str.length / 2][2];
			    for(int i=0;i<account_str.length / 2;i++){
			    	data1[i][0] = account_str[i*2 + 0];
			    	data1[i][1] = account_str[i*2 + 1];
			    }
			    for(int i=0;i<data1.length;i++){
			    	account_model.addRow(data1[i]);
			    }
			    //��ӿͻ���Ϣ
			    Object[][] data2 = new Object[customer_str.length / 5][5];
			    for(int i=0;i<customer_str.length / 5;i++){
			    	if(customer_str[i*5 + 0].equals("0")){
			    		data2[i][0] = "������";
			    	}else{
			    		data2[i][0] = "��Ӧ��";
			    	}
			    	data2[i][1] = customer_str[i*5 + 1];
			    	data2[i][2] = customer_str[i*5 + 2];
			    	data2[i][3] = customer_str[i*5 + 3];
			    	data2[i][4] = customer_str[i*5 + 4];
			    }
			    for(int i=0;i<data2.length;i++){
			    	customer_model.addRow(data2[i]);
			    }
			    sbc.insertLog("�鿴�ڳ���Ϣ");
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
				GoodsController gc = new GoodsController(operator);
			}
			else if(e.getSource() == xsmx_export){
				String path = "";
				String begin = start_year.getSelectedItem().toString() + start_month.getSelectedItem().toString() + start_day.getSelectedItem().toString();
				String end = end_year.getSelectedItem().toString() + end_month.getSelectedItem().toString() + end_day.getSelectedItem().toString();
				SalesDetailController sdc = new SalesDetailController(operator);
				List<SalesOrderVO> list =  sdc.SalesDetail(begin,end,goods_box.getSelectedItem().toString(),customer_box.getSelectedItem().toString());
				JFileChooser chooser = new JFileChooser();  			    
			    int abc =chooser.showSaveDialog(null);  
			    if(abc == JFileChooser.APPROVE_OPTION){  
			        path = chooser.getSelectedFile().getAbsolutePath()+".xls";		    
			    }
				sdc.exportSales(list,path);
				sdc.insertLog("����������ϸ");
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
			else if(e.getSource() == jylc_export){
				String path = "";
				JFileChooser chooser = new JFileChooser();  			    
			    int abc =chooser.showSaveDialog(null);  
			    if(abc == JFileChooser.APPROVE_OPTION){  
			        path = chooser.getSelectedFile().getAbsolutePath();		    
			    }
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
						int k = 0;
						for(int i=0;i<list.size();i++){
							if(list.get(i).getSalesperson().equals(customer))
								listcustomer.add(list.get(i));
						}
						for(int i=0;i<list2.size();i++){
							if(list2.get(i).getSalesperson().equals(customer))
								listcustomer2.add(list2.get(i));
						}
						if(listcustomer.size() !=0 ){
						    bcc.exportSalesOrder(listcustomer,path+k+".xls");
						    k++;
						}
						if(listcustomer2.size() !=0 ){
						    bcc.exportSalesBackOrder(listcustomer2,path+k+".xls");
						}
					}
					else{
						int k = 0;
						if(list.size() !=0 ){
						    bcc.exportSalesOrder(list,path+k+".xls");
						    k++;
						}
						if(list2.size() !=0 ){
						    bcc.exportSalesBackOrder(list2,path+k+".xls");
						}
					}
				}
				else if(type.equals("�����൥��")){
					List<PurchaseOrderVO> list=bcc.queryPurchaseOrder(begin, end);
					List<PurchaseBackOrderVO> list2=bcc.queryPurchaseBackOrder(begin, end);
					List<PurchaseOrderVO> listcustomer=new ArrayList<PurchaseOrderVO>();
					List<PurchaseBackOrderVO> listcustomer2=new ArrayList<PurchaseBackOrderVO>();
					if(!customer.equals("")){
						int k = 0;
						for(int i=0;i<list.size();i++){
							if(list.get(i).getProvider().equals(customer))
								listcustomer.add(list.get(i));
						}
						for(int i=0;i<list2.size();i++){
							if(list2.get(i).getProvider().equals(customer))
								listcustomer2.add(list2.get(i));
						}
						if(listcustomer.size() !=0 ){
						    bcc.exportPurchaseOrder(listcustomer,path+k+".xls");
						    k++;
						}
						if(listcustomer2.size() !=0 ){
						    bcc.exportPurchaseBackOrder(listcustomer2,path+k+".xls");
						}
					}
					else{
						int k = 0;
						if(list.size() !=0 ){
						    bcc.exportPurchaseOrder(list,path+k+".xls");
						    k++;
						}
						if(list2.size() !=0 ){
						    bcc.exportPurchaseBackOrder(list2,path+k+".xls");
						}
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
					if(list3.size()!=0){
						bcc.exportPayOrderExcel(list3, path+"pay.xls");
					}
					if(!customer.equals("")){
						int k = 0;
						for(int i=0;i<list.size();i++){
							if(list.get(i).getProvider().equals(customer))
								listcustomer.add(list.get(i));
						}
						for(int i=0;i<list2.size();i++){
							if(list2.get(i).getProvider().equals(customer))
								listcustomer2.add(list2.get(i));
						}
						if(listcustomer.size() !=0 ){
						    bcc.exportReceipt(listcustomer,path+k+".xls");
						    k++;
						}
						if(listcustomer2.size() !=0 ){
						    bcc.exportReceiptBack(listcustomer2,path+k+".xls");
						}
					}
					else{
						int k = 0;
						if(list.size() !=0 ){
						    bcc.exportReceipt(list,path+k+".xls");
						    k++;
						}
						if(list2.size() !=0 ){
						    bcc.exportReceiptBack(list2,path+k+".xls");
						}
					}		
				}
				else if(type.equals("����൥��")){
					List<StockLossOrderVO> list=bcc.queryStockLossOrder(begin, end);
					List<StockOverflowOrderVO> list2=bcc.queryStockOverflowOrder(begin, end);
					List<StockGrantOrderVO> list3=bcc.queryStockGrantOrder(begin, end);
					int k = 0;
					if(list.size() != 0){
						bcc.exportStockLossOrder(list, path+k+".xls");
						k++;
					}
					if(list2.size() != 0){
						bcc.exportStockOverflowOrder(list2, path+k+".xls");
						k++;
					}
					if(list3.size() != 0){
						bcc.exportStockGrantOrder(list3, path+k+".xls");
						k++;
					}
				}
				bcc.insertLog("������Ӫ����");
			}
			
		}
		
	}
	 
	 class MouseActionListener implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == account_table){
					removeFlag = account_table.getSelectedRow();
					updateFlag = account_table.getSelectedRow();
					if(oldName == null){
					    DefaultTableModel model = (DefaultTableModel)account_table.getModel();
					    oldName = model.getValueAt(updateFlag, 0).toString();
				    }
				}
				if(e.getSource()==ro_ta_table){
					if(ro_ta_table.getSelectedColumn() == 3){
			    	double num = 0;
			    	for(int i=0;i<ro_ta_table.getRowCount();i++){
						if((boolean)ro_ta_table.getValueAt(i, 3)){
							num = num + Double.parseDouble(ro_ta_table.getValueAt(i, 1).toString());
						}
					}
			    	ro_addAll.setText((num+""));
					}
				}
				if(e.getSource()==po_ta_table){
						if(po_ta_table.getSelectedColumn() == 3){
			    	double num = 0;
			    	for(int i=0;i<po_ta_table.getRowCount();i++){
						if((boolean)po_ta_table.getValueAt(i, 3)){
							num = num + Double.parseDouble(po_ta_table.getValueAt(i, 1).toString());
						}
					}
			    	po_addAll.setText((num+""));
					}
				}
				if(e.getSource()==mo_addAll){
					DefaultTableModel model = (DefaultTableModel)tm_table.getModel();
					double num = 0;
			    	for(int i=0;i<model.getRowCount();i++){
			    		if(!model.getValueAt(i,1).equals(""))
							num = num + Double.valueOf(model.getValueAt(i, 1).toString());					
					}
			    	mo_addAll.setText((num+""));
				}
				if(e.getSource() == jylcOrder_table){
					if(e.getClickCount() == 2 && jylcOrder_table.getSelectedColumn()!=3){
						int row = jylcOrder_table.getSelectedRow();
				    	String str = mytable.getValueAt(row, 0).toString();
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
				    	else if(str.substring(0, 3).equals("XJF")){
				    		new MoneyOrderFrame(str,operator,0);
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
				}else if(e.getSource() == message_label){
					if(noticeFlag == 1){
						for(int i=0;i<notice_list.size();i++){
							JOptionPane.showMessageDialog(frame.getContentPane(),notice_list.get(i).getMessage(), "ϵͳ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
						}
						noticeFlag = 0;
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
					else if(e.getSource()==ro_retailer){
						if(!ro_retailer.getSelectedItem().equals(""))
							ro_supplier.setSelectedItem("");
					}
					else if(e.getSource()==ro_supplier){
						if(!ro_supplier.getSelectedItem().equals(""))
							ro_retailer.setSelectedItem("");
					}
					else if(e.getSource()==po_retailer){
						if(!po_retailer.getSelectedItem().equals(""))
							po_supplier.setSelectedItem("");
					}
					else if(e.getSource()==po_supplier){
						if(!po_supplier.getSelectedItem().equals(""))
							po_retailer.setSelectedItem("");
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