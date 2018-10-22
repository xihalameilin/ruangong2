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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.CheckPurchaseController;
import controller.CheckSalesController;
import controller.CustomerController;
import controller.GoodsClassificationController;
import controller.GoodsController;
import controller.OrderController;
import controller.PromotionController;
import ui.Salesmanui.ButtonActionListener;
import utility.DatetoString;
import utility.ResultMessage;
import vo.CustomerVO;
import vo.GoodsListVO;
import vo.GoodsVO;
import vo.LevelPromotionVO;
import vo.PurchaseBackOrderVO;
import vo.PurchaseOrderVO;
import vo.SalesBackOrderVO;
import vo.SalesOrderVO;

public class Salesmanui {
	private String operator;
	private JFrame frame;
	private JPanel po_panel;//�����������ɽ���
	private JPanel pbo_panel;//�����˻��������ɽ���
	private JPanel so_panel;//���۵������ɽ���
	private JPanel sbo_panel;//�����˻��������ɽ���
	private JPanel cm_panel;//�ͻ��������
	private JButton po;
	private JButton pbo;
	private JButton so;
	private JButton sbo;
	private JButton cm;
	private JButton close;//�ر�
	private JButton min;
	private JButton logout;//ע��
	private JTextField po_number;//������
	private JComboBox<String> po_supplier;//��Ӧ��
	private JTextField po_stock;//�ֿ�
	private JTextField po_operator;//����Ա
	private JTextField po_comment;//��ע
	private JTable po_gs;//��Ʒѡ���б�
	private Mytable po_mytable;
	private JTextField po_addAll;//�ϼ�
	private JButton po_editDraft;//�༭�ݸ�
	//�༭�ݸ����
	private JFrame po_editDraft_frame;
	private JComboBox po_editDraft_draftNumber;
	private JButton po_editDraft_confirm;
	private JButton po_editDraft_cancel;
	private JButton po_saveDraft;//����ݸ�
	private JButton po_submit;//�ύ����
	private  Mytable pbo_mytable;
	private JTextField pbo_number;//������
	private JComboBox<String> pbo_supplier;
	private JTextField pbo_stock;//�ֿ�
	private JTextField pbo_operator;//����Ա
	private JTextField pbo_comment;//��ע
	private JTextField pbo_addAll;//�ϼ�
	private JButton pbo_editDraft;//�༭�ݸ�
	//�༭�ݸ����
	private JFrame pbo_editDraft_frame;
	private JComboBox pbo_editDraft_draftNumber;
	private JButton pbo_editDraft_confirm;
	private JButton pbo_editDraft_cancel;
	private JButton pbo_saveDraft;//����ݸ�
	private JButton pbo_submit;//�ύ����
	private JTable pbo_gs;//��Ʒѡ���б�
	private JTextField so_number;//������
	private JComboBox<String> so_retailer;
	private JTextField so_salesman;//ҵ��Ա
	private JTextField so_operator;//����Ա
	private JTextField so_stock;//�ֿ�
	private JTextField so_comment;//��ע
	private JTable so_gs;//��Ʒѡ���б�
	private Mytable1 so_mytable;
	private JTextField so_beforeDiscount;//����ǰ�ܶ�
	private JTextField so_discount;//����
	private JTextField so_voucher;//����ȯ
	private JTextField so_afterDiscount;//���ú��ܶ�
	private JButton so_editDraft;//�༭�ݸ�
	//�༭�ݸ����
	private JFrame so_editDraft_frame;
	private JComboBox so_editDraft_draftNumber;
	private JButton so_editDraft_confirm;
	private JButton so_editDraft_cancel;
	private JButton so_saveDraft;//����ݸ�
	private JButton so_submit;//�ύ����
	private JTextField sbo_number;//������
	private JComboBox<String> sbo_retailer;
	private JComboBox<String> sbo_draft;
	private JTextField sbo_salesman;//ҵ��Ա
	private JTextField sbo_operator;//����Ա
	private JTextField sbo_stock;//�ֿ�
	private JTextField sbo_comment;//��ע
	private JTable sbo_gs;//��Ʒѡ���б�
	private Mytable sbo_mytable;
	private JTextField sbo_afterDiscount;//���ú��ܶ�
	private JButton sbo_editDraft;//�༭�ݸ�
	//�༭�ݸ����
	private JFrame sbo_editDraft_frame;
	private JComboBox sbo_editDraft_draftNumber;
	private JButton sbo_editDraft_confirm;
	private JButton sbo_editDraft_cancel;
	private JButton sbo_saveDraft;//����ݸ�
	private JButton sbo_submit;//�ύ����
	private JTable customer_table;//�ͻ��б�
	private JTextField search_customer;//��ѯ�ͻ�
	private JButton search;//
	private JComboBox search_box;//��ѯ���
	private JButton addCustomer;//���ӿͻ�
	private int removeFlag = -1;
	private JButton removeCustomer;//ɾ���ͻ�
	private int updateFlag = -1;
	private JButton updateCustomer;//�޸Ŀͻ�����
	
	private JComboBox<String> classificationbox;
	private JComboBox<String> levelbox;
	
	//���ӿͻ�����
     private JFrame cm_add_frame;
     private JTextField cm_add_number;//���
     private JComboBox cm_add_classification;//����
	 private JComboBox cm_add_level;//����
	 private JTextField cm_add_name;//����
	 private JTextField cm_add_phone;//�绰
	 private JTextField cm_add_address;//��ַ
	 private JTextField cm_add_postcode;//�ʱ�
	 private JTextField cm_add_eMail;//��������
	 private JTextField cm_add_maxIncome;//Ӧ�ն��
	 private JTextField cm_add_salesman;//Ĭ��ҵ��Ա
	 private JButton cm_add_cancel;
	 private JButton cm_add_confirm;

	public static void main(String []args){
		new Salesmanui("");
	}
	
	public Salesmanui(String operator){
		this.operator=operator;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 700);
		frame.setLocation(570, 200);
		//ȥ��������
		frame.setUndecorated(true);
		JLabel title = new JLabel("<html>�ƾ߽�����ϵͳ<br>(PSIS)</html>");
		title.setLocation(30,0);
		title.setSize(250,100);
		title.setForeground(Color.pink);
		//��������
		Font font0 = new Font("Default",Font.BOLD,25);
		title.setFont(font0);
		frame.getContentPane().add(title);
		
		/*
		 * �½���������ť
		 */
		Font font = new Font("Default",Font.BOLD,20);
		po = new JButton("�½�������");
		po.addActionListener(new ButtonActionListener());
        po.setLocation(0,100);
        po.setSize(250,100);
        po.setFont(font0);
        po.setForeground(Color.white);
        po.setFocusPainted(false);
        po.setContentAreaFilled(false);
        frame.getContentPane().add(po);
        ImageIcon po_icon = new ImageIcon("����.png");
        JLabel po_label = new JLabel(po_icon);
        po_label.setLocation(0,125);
        po_label.setSize(po_icon.getIconWidth(),po_icon.getIconHeight());
        frame.getContentPane().add(po_label);
        
        /*
         * �½������˻�����ť
         */
        pbo = new JButton("    �½������˻���");
        pbo.addActionListener(new ButtonActionListener());
        pbo.setLocation(0,200);
        pbo.setSize(250,100);
        pbo.setFont(font0);
        pbo.setForeground(Color.white);
        pbo.setFocusPainted(false);
        pbo.setContentAreaFilled(false);
        frame.getContentPane().add(pbo);
        ImageIcon pbo_icon = new ImageIcon("����.png");
        JLabel pbo_label = new JLabel(pbo_icon);
        pbo_label.setLocation(0,225);
        pbo_label.setSize(pbo_icon.getIconWidth(),pbo_icon.getIconHeight());
        frame.getContentPane().add(pbo_label);
        
        /*
         * �½����۵���ť
         */
        so = new JButton("�½����۵�");
        so.addActionListener(new ButtonActionListener());
        so.setLocation(0,300);
        so.setSize(250,100);
        so.setFont(font0);
        so.setForeground(Color.white);
        so.setFocusPainted(false);
        so.setContentAreaFilled(false);
        frame.getContentPane().add(so);
        ImageIcon so_icon = new ImageIcon("����.png");
        JLabel so_label = new JLabel(so_icon);
        so_label.setLocation(0,325);
        so_label.setSize(so_icon.getIconWidth(),so_icon.getIconHeight());
        frame.getContentPane().add(so_label);
        
        /*
         * �½������˻�����ť
         */
        sbo = new JButton("    �½������˻���");
        sbo.addActionListener(new ButtonActionListener());
        sbo.setLocation(0,400);
        sbo.setSize(250,100);
        sbo.setFont(font0);
        sbo.setForeground(Color.white);
        sbo.setFocusPainted(false);
        sbo.setContentAreaFilled(false);
        frame.getContentPane().add(sbo);
        ImageIcon sbo_icon = new ImageIcon("����.png");
        JLabel sbo_label = new JLabel(sbo_icon);
        sbo_label.setLocation(0,425);
        sbo_label.setSize(sbo_icon.getIconWidth(),sbo_icon.getIconHeight());
        frame.getContentPane().add(sbo_label);
        
        /*
         * �ͻ�����ť
         */
        cm = new JButton("�ͻ�����");
        cm.addActionListener(new ButtonActionListener());
        cm.setLocation(0,500);
        cm.setSize(250,100);
        cm.setFont(font0);
        cm.setForeground(Color.white);
        cm.setFocusPainted(false);
        cm.setContentAreaFilled(false);
        frame.getContentPane().add(cm);
        ImageIcon cm_icon = new ImageIcon("1.png");
        JLabel cm_label = new JLabel(cm_icon);
        cm_label.setLocation(20,530);
        cm_label.setSize(cm_icon.getIconWidth(),cm_icon.getIconHeight());
        frame.getContentPane().add(cm_label);
        
        /*
         * ע����ť
         */
        logout = new JButton("ע��       ");
		logout.addActionListener(new ButtonActionListener());
		logout.setLocation(0,630);
		logout.setSize(150,70);
		logout.setFont(font);
		logout.setForeground(Color.red);
		logout.setContentAreaFilled(false);
		logout.setFocusPainted(false);
		ImageIcon logout_icon = new ImageIcon("��Դ.png");
		JLabel logout_label = new JLabel(logout_icon);
		logout_label.setLocation(88,640);
		logout_label.setSize(logout_icon.getIconWidth(),logout_icon.getIconHeight());
		frame.getContentPane().add(logout_label);
		frame.getContentPane().add(logout);
		
		/*
		 * �ر�
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
		 * �����������ɽ���
		 */
		po_panel = new JPanel();
		po_panel.setLocation(300,50);
	    po_panel.setSize(520,620);
	    po_panel.setLayout(null);
	    po_panel.setBackground(Color.cyan);
	    po_panel.setOpaque(true);
	    /*
	     * ������Ϣ
	     */
	    JLabel po_input = new JLabel("����������");
	    po_input.setLocation(200,0);
	    po_input.setSize(150,30);
	    po_input.setForeground(Color.red);
	    po_input.setFont(font0);
	    po_panel.add(po_input);
	    //������
	    JLabel po_number_label = new JLabel("������");
	    po_number_label.setLocation(50,50);
	    po_number_label.setSize(100,30);
	    po_number_label.setFont(font0);
	    po_number_label.setBackground(Color.black);
	    po_panel.add(po_number_label);
	    po_number = new JTextField();
	    po_number.setLocation(170,50);
	    po_number.setSize(300,35);
	    po_number.setFont(font);
	    po_number.setEditable(false);
	    po_number.setBackground(Color.white);
	    po_panel.add(po_number);
	    //��Ӧ��
	    JLabel po_supplier_label = new JLabel("��Ӧ��");
	    po_supplier_label.setLocation(50,90);
	    po_supplier_label.setSize(100,30);
	    po_supplier_label.setFont(font0);
	    po_supplier_label.setBackground(Color.black);
	    po_panel.add(po_supplier_label);
	    //po_supplier = new JTextField();
	    po_supplier = new JComboBox<String>();
	    po_supplier.setMaximumRowCount(5);
	    po_supplier.setLocation(170,90);
	    po_supplier.setSize(300,35);
	    po_supplier.setFont(font);
	    po_supplier.setBackground(Color.white);
	    po_panel.add(po_supplier);
	    //�ֿ�
	    JLabel po_stock_label = new JLabel("�ֿ�");
	    po_stock_label.setLocation(50,130);
	    po_stock_label.setSize(100,30);
	    po_stock_label.setFont(font0);
	    po_stock_label.setBackground(Color.black);
	    po_panel.add(po_stock_label);
	    po_stock = new JTextField();
	    po_stock.setLocation(170,130);
	    po_stock.setSize(300,35);
	    po_stock.setFont(font);
	    po_stock.setBackground(Color.white);
	    po_panel.add(po_stock);
	    //����Ա
	    JLabel po_operator_label = new JLabel("����Ա");
	    po_operator_label.setLocation(50,170);
	    po_operator_label.setSize(100,30);
	    po_operator_label.setFont(font0);
	    po_operator_label.setBackground(Color.black);
	    po_panel.add(po_operator_label);
	    po_operator = new JTextField();
	    po_operator.setLocation(170,170);
	    po_operator.setSize(300,35);
	    po_operator.setFont(font);
	    po_operator.setEditable(false);
	    po_operator.setBackground(Color.white);
	    po_panel.add(po_operator);
	    //��ע
	    JLabel po_comment_label = new JLabel("��ע");
	    po_comment_label.setLocation(50,210);
	    po_comment_label.setSize(100,30);
	    po_comment_label.setFont(font0);
	    po_comment_label.setBackground(Color.black);
	    po_panel.add(po_comment_label);
	    po_comment = new JTextField();
	    po_comment.setLocation(170,210);
	    po_comment.setSize(300,35);
	    po_comment.setFont(font);
	    po_comment.setBackground(Color.white);
	    po_panel.add(po_comment);
	    
	    
	    /*
	     * ��Ʒѡ��
	     */
	    JLabel po_gs_label = new JLabel("��Ʒѡ���б�");
	    po_gs_label.setLocation(190,250);
	    po_gs_label.setSize(200,30);
	    po_gs_label.setFont(font0);
	    po_gs_label.setForeground(Color.black);
	    po_panel.add(po_gs_label);
	    frame.setLocationRelativeTo(null);
	    //�Զ���table
	    po_mytable = new Mytable();
	    po_gs = new JTable(po_mytable);
	    po_gs.addMouseListener(new MouseActionListener());
		po_gs.getTableHeader().setReorderingAllowed(false);
	    po_gs.setBackground(Color.cyan);
	    po_gs.getTableHeader().setPreferredSize(new Dimension(1, 50));
	    po_gs.getTableHeader().setFont(font);
	    po_gs.getTableHeader().setForeground(Color.red);
	    po_gs.setRowHeight(33);
	    po_gs.setFont(font);
		JScrollPane po_scrollPane = new JScrollPane(po_gs);
		po_scrollPane.setLocation(0,280);
		po_scrollPane.setSize(520,280);
		frame.setLocationRelativeTo(null);
		po_panel.add(po_scrollPane);
		/*
		 * button�ؼ�
		 */
		//�ϼ�
		JLabel po_addAll_label = new JLabel("�ϼ�");
		po_addAll_label.setLocation(0,560);
		po_addAll_label.setSize(50,50);
		po_addAll_label.setFont(font);
		po_addAll_label.setBackground(Color.black);
		po_panel.add(po_addAll_label);
		po_addAll = new JTextField("0.0");
		po_addAll.setLocation(50,570);
		po_addAll.setSize(100,35);
		po_addAll.setFont(font);
		po_panel.add(po_addAll);
		//�༭�ݸ�
		po_editDraft = new JButton("�༭�ݸ�");
		po_editDraft.addActionListener(new ButtonActionListener());
		po_editDraft.setLocation(160,565);
		po_editDraft.setSize(120,50);
		po_editDraft.setFocusPainted(false);
		po_editDraft.setFont(font);
		po_editDraft.setForeground(Color.red);
		po_panel.add(po_editDraft);
		//����ݸ�
		po_saveDraft = new JButton("����ݸ�");
		po_saveDraft.addActionListener(new ButtonActionListener());
		po_saveDraft.setLocation(295,565);
		po_saveDraft.setSize(120,50);
		po_saveDraft.setFocusPainted(false);
		po_saveDraft.setFont(font);
		po_saveDraft.setForeground(Color.red);
		po_panel.add(po_saveDraft);
		//�ύ
		po_submit = new JButton("�ύ");
		po_submit.addActionListener(new ButtonActionListener());
		po_submit.setLocation(430,565);
		po_submit.setSize(80,50);
		po_submit.setFocusPainted(false);
		po_submit.setFont(font);
		po_submit.setForeground(Color.red);
		po_panel.add(po_submit);
		po_panel.setVisible(false);
	    frame.getContentPane().add(po_panel);
	    
		/*
		 * �����˻��������ɽ���
		 */
		pbo_panel = new JPanel();
		pbo_panel.setLocation(300,50);
	    pbo_panel.setSize(520,620);
	    pbo_panel.setLayout(null);
	    pbo_panel.setBackground(Color.cyan);
	    pbo_panel.setOpaque(true);
	    /*
	     * ������Ϣ
	     */
	    JLabel pbo_input = new JLabel("�����˻�������");
	    pbo_input.setLocation(180,0);
	    pbo_input.setSize(250,30);
	    pbo_input.setForeground(Color.red);
	    pbo_input.setFont(font0);
	    pbo_panel.add(pbo_input);
	    //������
	    JLabel pbo_number_label = new JLabel("������");
	    pbo_number_label.setLocation(50,50);
	    pbo_number_label.setSize(100,30);
	    pbo_number_label.setFont(font0);
	    pbo_number_label.setBackground(Color.black);
	    pbo_panel.add(pbo_number_label);
	    pbo_number = new JTextField();
	    pbo_number.setLocation(170,50);
	    pbo_number.setSize(300,35);
	    pbo_number.setFont(font);
	    pbo_number.setBackground(Color.white);
	    pbo_panel.add(pbo_number);
	    //��Ӧ��
	    JLabel pbo_supplier_label = new JLabel("��Ӧ��");
	    pbo_supplier_label.setLocation(50,90);
	    pbo_supplier_label.setSize(100,30);
	    pbo_supplier_label.setFont(font0);
	    pbo_supplier_label.setBackground(Color.black);
	    pbo_panel.add(pbo_supplier_label);
	    //pbo_supplier = new JTextField();
	    pbo_supplier=new JComboBox<String>();
	    pbo_supplier.setMaximumRowCount(5);
	    pbo_supplier.setLocation(170,90);
	    pbo_supplier.setSize(300,35);
	    pbo_supplier.setFont(font);
	    pbo_supplier.setBackground(Color.white);
	    pbo_panel.add(pbo_supplier);
	    //�ֿ�
	    JLabel pbo_stock_label = new JLabel("�ֿ�");
	    pbo_stock_label.setLocation(50,130);
	    pbo_stock_label.setSize(100,30);
	    pbo_stock_label.setFont(font0);
	    pbo_stock_label.setBackground(Color.black);
	    pbo_panel.add(pbo_stock_label);
	    pbo_stock = new JTextField();
	    pbo_stock.setLocation(170,130);
	    pbo_stock.setSize(300,35);
	    pbo_stock.setFont(font);
	    pbo_stock.setBackground(Color.white);
	    pbo_panel.add(pbo_stock);
	    //����Ա
	    JLabel pbo_operator_label = new JLabel("����Ա");
	    pbo_operator_label.setLocation(50,170);
	    pbo_operator_label.setSize(100,30);
	    pbo_operator_label.setFont(font0);
	    pbo_operator_label.setBackground(Color.black);
	    pbo_panel.add(pbo_operator_label);
	    pbo_operator = new JTextField();
	    pbo_operator.setLocation(170,170);
	    pbo_operator.setSize(300,35);
	    pbo_operator.setFont(font);
	    pbo_operator.setBackground(Color.white);
	    pbo_panel.add(pbo_operator);
	    //��ע
	    JLabel pbo_comment_label = new JLabel("��ע");
	    pbo_comment_label.setLocation(50,210);
	    pbo_comment_label.setSize(100,30);
	    pbo_comment_label.setFont(font0);
	    pbo_comment_label.setBackground(Color.black);
	    pbo_panel.add(pbo_comment_label);
	    pbo_comment = new JTextField();
	    pbo_comment.setLocation(170,210);
	    pbo_comment.setSize(300,35);
	    pbo_comment.setFont(font);
	    pbo_comment.setBackground(Color.white);
	    pbo_panel.add(pbo_comment);
	    /*
	     * ��Ʒѡ��
	     */
	    JLabel pbo_gs_label = new JLabel("��Ʒѡ���б�");
	    pbo_gs_label.setLocation(190,250);
	    pbo_gs_label.setSize(200,30);
	    pbo_gs_label.setFont(font0);
	    pbo_gs_label.setForeground(Color.black);
	    pbo_panel.add(pbo_gs_label);
	    frame.setLocationRelativeTo(null);
	    pbo_mytable = new Mytable();
	    pbo_gs = new JTable(pbo_mytable);
	    pbo_gs.addMouseListener(new MouseActionListener());
		pbo_gs.getTableHeader().setReorderingAllowed(false);
	    pbo_gs.setBackground(Color.cyan);
	    pbo_gs.getTableHeader().setPreferredSize(new Dimension(1, 50));
	    pbo_gs.getTableHeader().setFont(font);
	    pbo_gs.getTableHeader().setForeground(Color.red);
	    pbo_gs.setRowHeight(33);
	    pbo_gs.setFont(font);
		JScrollPane pbo_scrollPane = new JScrollPane(pbo_gs);
		pbo_scrollPane.setLocation(0,280);
		pbo_scrollPane.setSize(520,280);
		frame.setLocationRelativeTo(null);
		pbo_panel.add(pbo_scrollPane);
		/*
		 * button�ؼ�
		 */
		//�ϼ�
		JLabel pbo_addAll_label = new JLabel("�ϼ�");
		pbo_addAll_label.setLocation(0,560);
		pbo_addAll_label.setSize(50,50);
		pbo_addAll_label.setFont(font);
		pbo_addAll_label.setBackground(Color.black);
		pbo_panel.add(pbo_addAll_label);
		pbo_addAll = new JTextField("0.0");
		pbo_addAll.setLocation(50,570);
		pbo_addAll.setSize(100,35);
		pbo_addAll.setFont(font);
		pbo_panel.add(pbo_addAll);
		//�༭�ݸ�
		pbo_editDraft = new JButton("�༭�ݸ�");
		pbo_editDraft.addActionListener(new ButtonActionListener());
		pbo_editDraft.setLocation(160,565);
		pbo_editDraft.setSize(120,50);
		pbo_editDraft.setFocusPainted(false);
		pbo_editDraft.setFont(font);
		pbo_editDraft.setForeground(Color.red);
		pbo_panel.add(pbo_editDraft);
		//����ݸ�
		pbo_saveDraft = new JButton("����ݸ�");
		pbo_saveDraft.addActionListener(new ButtonActionListener());
		pbo_saveDraft.setLocation(295,565);
		pbo_saveDraft.setSize(120,50);
		pbo_saveDraft.setFocusPainted(false);
		pbo_saveDraft.setFont(font);
		pbo_saveDraft.setForeground(Color.red);
		pbo_panel.add(pbo_saveDraft);
		//�ύ
		pbo_submit = new JButton("�ύ");
		pbo_submit.addActionListener(new ButtonActionListener());
		pbo_submit.setLocation(430,565);
		pbo_submit.setSize(80,50);
		pbo_submit.setFocusPainted(false);
		pbo_submit.setFont(font);
		pbo_submit.setForeground(Color.red);
		pbo_panel.add(pbo_submit);
	    pbo_panel.setVisible(false);
	    frame.getContentPane().add(pbo_panel);
	    
	    /*
	     * �ƶ����۵�����
	     */
	    so_panel = new JPanel();
	    so_panel.setLocation(270,50);
	    so_panel.setSize(550,620);
	    so_panel.setLayout(null);
	    so_panel.setBackground(Color.cyan);
	    so_panel.setOpaque(true);
	    //��ȡ����
	    JLabel so_input = new JLabel("���۵�����");
	    so_input.setLocation(200,0);
	    so_input.setSize(150,30);
	    so_input.setFont(font0);
	    so_input.setForeground(Color.red);
	    so_panel.add(so_input);
	    //������
	    JLabel so_number_label = new JLabel("������");
	    so_number_label.setLocation(30,50);
	    so_number_label.setSize(100,30);
	    so_number_label.setFont(font0);
	    so_number_label.setBackground(Color.black);
	    so_panel.add(so_number_label);
	    so_number = new JTextField();
	    so_number.setLocation(120,50);
	    so_number.setSize(280,30);
	    so_number.setBackground(Color.white);
	    so_number.setFont(font);
	    so_panel.add(so_number);
	    //������
	    JLabel so_retailer_label = new JLabel("������");
	    so_retailer_label.setLocation(30,90);
	    so_retailer_label.setSize(100,30);
	    so_retailer_label.setFont(font0);
	    so_retailer_label.setBackground(Color.black);
	    so_panel.add(so_retailer_label);
	    //so_retailer = new JTextField();
	    so_retailer=new JComboBox<String>();
	    so_retailer.addItemListener(new boxItemListener());
	    so_retailer.setMaximumRowCount(5);
	    so_retailer.setLocation(120,90);
	    so_retailer.setSize(120,30);
	    so_retailer.setBackground(Color.white);
	    so_retailer.setFont(font);
	    so_panel.add(so_retailer);
	    //ҵ��Ա
	    JLabel so_salesman_label = new JLabel("ҵ��Ա");
	    so_salesman_label.setLocation(260,90);
	    so_salesman_label.setSize(100,30);
	    so_salesman_label.setFont(font0);
	    so_panel.add(so_salesman_label);
	    so_salesman = new JTextField();
	    so_salesman.setLocation(350,90);
	    so_salesman.setSize(120,30);
	    so_salesman.setFont(font);
	    so_panel.add(so_salesman);
	    //����Ա
	    JLabel so_operator_label = new JLabel("����Ա");
	    so_operator_label.setLocation(30,130);
	    so_operator_label.setSize(100,30);
	    so_operator_label.setFont(font0);
	    so_panel.add(so_operator_label);
	    so_operator = new JTextField();
	    so_operator.setLocation(120,130);
	    so_operator.setSize(120,30);
	    so_operator.setBackground(Color.white);
	    so_operator.setFont(font);
	    so_panel.add(so_operator);
	    //�ֿ�
	    JLabel so_stock_label = new JLabel("�ֿ�");
	    so_stock_label.setLocation(260,130);
	    so_stock_label.setSize(100,30);
	    so_stock_label.setFont(font0);
	    so_panel.add(so_stock_label);
	    so_stock = new JTextField();
	    so_stock.setLocation(350,130);
	    so_stock.setSize(120,30);
	    so_stock.setBackground(Color.white);
	    so_stock.setFont(font);
	    so_panel.add(so_stock);
	    //��ע
	    JLabel so_comment_label = new JLabel("��ע");
	    so_comment_label.setLocation(30,170);
	    so_comment_label.setSize(100,30);
	    so_comment_label.setFont(font0);
	    so_panel.add(so_comment_label);
	    so_comment = new JTextField();
	    so_comment.setLocation(120,170);
	    so_comment.setSize(280,30);
	    so_comment.setFont(font);
	    so_panel.add(so_comment);
	    /*
	     * ��Ʒѡ��
	     */
	    JLabel so_gs_label = new JLabel("��Ʒѡ���б�");
	    so_gs_label.setLocation(190,210);
	    so_gs_label.setSize(200,30);
	    so_gs_label.setFont(font0);
	    so_gs_label.setForeground(Color.black);
	    so_panel.add(so_gs_label);
	    frame.setLocationRelativeTo(null);
	    so_mytable = new Mytable1();
	    so_gs = new JTable(so_mytable);
	    so_gs.addMouseListener(new MouseActionListener());
		so_gs.getTableHeader().setReorderingAllowed(false);
	    so_gs.setBackground(Color.cyan);
	    so_gs.getTableHeader().setPreferredSize(new Dimension(1, 50));
	    so_gs.getTableHeader().setFont(font);
	    so_gs.getTableHeader().setForeground(Color.red);
	    so_gs.setRowHeight(33);
	    so_gs.setFont(font);
		JScrollPane so_scrollPane = new JScrollPane(so_gs);
		so_scrollPane.setLocation(0,240);
		so_scrollPane.setSize(550,280);
		so_panel.add(so_scrollPane);
	    /*
	     * button�ؼ�
	     */
		//����ǰ�ܶ���á����ú��ܶ����ȯ
		JLabel so_bd = new JLabel("����ǰ�ܶ�");
		so_bd.setLocation(0,530);
		so_bd.setSize(150,30);
		so_bd.setFont(font);
		so_panel.add(so_bd);
		so_beforeDiscount = new JTextField("0.0");
		so_beforeDiscount.setLocation(110,530);
		so_beforeDiscount.setSize(80,30);
		so_beforeDiscount.setFont(font);
		so_panel.add(so_beforeDiscount);
		JLabel so_dc = new JLabel("����");
		so_dc.setLocation(220,530);
		so_dc.setSize(60,30);
		so_dc.setFont(font);
		so_panel.add(so_dc);
		so_discount = new JTextField();
		so_discount.setLocation(265,530);
		so_discount.setSize(80,30);
		so_discount.setFont(font);
		so_panel.add(so_discount);
		JLabel so_vc = new JLabel("����ȯ");
		so_vc.setLocation(355,530);
		so_vc.setSize(80,30);
		so_vc.setFont(font);
		so_panel.add(so_vc);
		so_voucher = new JTextField();
		so_voucher.setLocation(430,530);
		so_voucher.setSize(80,30);
		so_voucher.setFont(font);
		so_panel.add(so_voucher);
		JLabel so_ad = new JLabel("���ú��ܶ�");
		so_ad.setLocation(0,580);
		so_ad.setSize(150,30);
		so_ad.setFont(font);
		so_panel.add(so_ad);
		so_afterDiscount = new JTextField("0.0");
		so_afterDiscount.addMouseListener(new MouseActionListener());
		so_afterDiscount.setLocation(110,580);
		so_afterDiscount.setSize(80,30);
		so_afterDiscount.setFont(font);
		so_panel.add(so_afterDiscount);
		//�༭�ݸ塢����ݸ塢�ύ
		so_editDraft = new JButton("�༭�ݸ�");
		so_editDraft.addActionListener(new ButtonActionListener());
		so_editDraft.setLocation(200,575);
		so_editDraft.setSize(120,40);
		so_editDraft.setFocusPainted(false);
		so_editDraft.setFont(font);
		so_editDraft.setForeground(Color.red);
		so_panel.add(so_editDraft);
		so_saveDraft = new JButton("����ݸ�");
		so_saveDraft.addActionListener(new ButtonActionListener());
		so_saveDraft.setLocation(330,575);
		so_saveDraft.setSize(120,40);
		so_saveDraft.setFocusPainted(false);
		so_saveDraft.setFont(font);
		so_saveDraft.setForeground(Color.red);
		so_panel.add(so_saveDraft);
		so_submit = new JButton("�ύ");
		so_submit.addActionListener(new ButtonActionListener());
		so_submit.setLocation(460,575);
		so_submit.setSize(80,40);
		so_submit.setFocusPainted(false);
		so_submit.setFont(font);
		so_submit.setForeground(Color.red);
		so_panel.add(so_submit);
		so_panel.setVisible(false);
		frame.getContentPane().add(so_panel);
		
		/*
		 * �����˻������ɽ���
		 */
		sbo_panel = new JPanel();
	    sbo_panel.setLocation(270,50);
	    sbo_panel.setSize(550,620);
	    sbo_panel.setLayout(null);
	    sbo_panel.setBackground(Color.cyan);
	    sbo_panel.setOpaque(true);
	    //��ȡ����
	    JLabel sbo_input = new JLabel("�����˻�������");
	    sbo_input.setLocation(170,0);
	    sbo_input.setSize(200,30);
	    sbo_input.setFont(font0);
	    sbo_input.setForeground(Color.red);
	    sbo_panel.add(sbo_input);
	    //������
	    JLabel sbo_number_label = new JLabel("������");
	    sbo_number_label.setLocation(30,50);
	    sbo_number_label.setSize(100,30);
	    sbo_number_label.setFont(font0);
	    sbo_number_label.setBackground(Color.black);
	    sbo_panel.add(sbo_number_label);
	    sbo_number = new JTextField();
	    sbo_number.setLocation(120,50);
	    sbo_number.setSize(280,30);
	    sbo_number.setBackground(Color.white);
	    sbo_number.setFont(font);
	    sbo_panel.add(sbo_number);
	    //������
	    JLabel sbo_retailer_label = new JLabel("������");
	    sbo_retailer_label.setLocation(30,90);
	    sbo_retailer_label.setSize(100,30);
	    sbo_retailer_label.setFont(font0);
	    sbo_retailer_label.setBackground(Color.black);
	    sbo_panel.add(sbo_retailer_label);
	    sbo_retailer = new JComboBox<String>();
	    sbo_retailer.addItemListener(new boxItemListener());
	    sbo_retailer.setMaximumRowCount(5);
	    sbo_retailer.setLocation(120,90);
	    sbo_retailer.setSize(120,30);
	    sbo_retailer.setBackground(Color.white);
	    sbo_retailer.setFont(font);
	    sbo_panel.add(sbo_retailer);
	    //ҵ��Ա
	    JLabel sbo_salesman_label = new JLabel("ҵ��Ա");
	    sbo_salesman_label.setLocation(260,90);
	    sbo_salesman_label.setSize(100,30);
	    sbo_salesman_label.setFont(font0);
	    sbo_panel.add(sbo_salesman_label);
	    sbo_salesman = new JTextField();
	    sbo_salesman.setLocation(350,90);
	    sbo_salesman.setSize(120,30);
	    sbo_salesman.setBackground(Color.white);
	    sbo_salesman.setFont(font);
	    sbo_panel.add(sbo_salesman);
	    //����Ա
	    JLabel sbo_operator_label = new JLabel("����Ա");
	    sbo_operator_label.setLocation(30,130);
	    sbo_operator_label.setSize(100,30);
	    sbo_operator_label.setFont(font0);
	    sbo_panel.add(sbo_operator_label);
	    sbo_operator = new JTextField();
	    sbo_operator.setLocation(120,130);
	    sbo_operator.setSize(120,30);
	    sbo_operator.setBackground(Color.white);
	    sbo_operator.setFont(font);
	    sbo_panel.add(sbo_operator);
	    //�ֿ�
	    JLabel sbo_stock_label = new JLabel("�ֿ�");
	    sbo_stock_label.setLocation(260,130);
	    sbo_stock_label.setSize(100,30);
	    sbo_stock_label.setFont(font0);
	    sbo_panel.add(sbo_stock_label);
	    sbo_stock = new JTextField();
	    sbo_stock.setLocation(350,130);
	    sbo_stock.setSize(120,30);
	    sbo_stock.setBackground(Color.white);
	    sbo_stock.setFont(font);
	    sbo_panel.add(sbo_stock);
	    //��ע
	    JLabel sbo_comment_label = new JLabel("��ע");
	    sbo_comment_label.setLocation(30,170);
	    sbo_comment_label.setSize(100,30);
	    sbo_comment_label.setFont(font0);
	    sbo_panel.add(sbo_comment_label);
	    sbo_comment = new JTextField();
	    sbo_comment.setLocation(120,170);
	    sbo_comment.setSize(280,30);
	    sbo_comment.setBackground(Color.white);
	    sbo_comment.setFont(font);
	    sbo_panel.add(sbo_comment);
	    /*
	     * ��Ʒѡ��
	     */
	    JLabel sbo_gs_label = new JLabel("��Ʒѡ���б�");
	    sbo_gs_label.setLocation(190,210);
	    sbo_gs_label.setSize(200,30);
	    sbo_gs_label.setFont(font0);
	    sbo_gs_label.setForeground(Color.black);
	    sbo_panel.add(sbo_gs_label);
	    frame.setLocationRelativeTo(null);
	    sbo_mytable = new Mytable();
	    sbo_gs = new JTable(sbo_mytable);
	    sbo_gs.addMouseListener(new MouseActionListener());
		sbo_gs.getTableHeader().setReorderingAllowed(false);
	    sbo_gs.setBackground(Color.cyan);
	    sbo_gs.getTableHeader().setPreferredSize(new Dimension(1, 50));
	    sbo_gs.getTableHeader().setFont(font);
	    sbo_gs.getTableHeader().setForeground(Color.red);
	    sbo_gs.setRowHeight(33);
	    sbo_gs.setFont(font);
		JScrollPane sbo_scrollPane = new JScrollPane(sbo_gs);
		sbo_scrollPane.setLocation(0,240);
		sbo_scrollPane.setSize(550,310);
		sbo_panel.add(sbo_scrollPane);
	    /*
	     * button�ؼ�
	     */
		JLabel sbo_ad = new JLabel("�ܶ�");
		sbo_ad.setLocation(20,570);
		sbo_ad.setSize(150,30);
		sbo_ad.setFont(font);
		sbo_panel.add(sbo_ad);
		sbo_afterDiscount = new JTextField("0.0");
		sbo_afterDiscount.addMouseListener(new MouseActionListener());
		sbo_afterDiscount.setLocation(70,570);
		sbo_afterDiscount.setSize(120,30);
		sbo_afterDiscount.setFont(font);
		sbo_panel.add(sbo_afterDiscount);
		//����ݸ塢�ύ
		sbo_editDraft = new JButton("�༭�ݸ�");
		sbo_editDraft.addActionListener(new ButtonActionListener());
		sbo_editDraft.setLocation(200,565);
		sbo_editDraft.setSize(120,40);
		sbo_editDraft.setFocusPainted(false);
		sbo_editDraft.setFont(font);
		sbo_editDraft.setForeground(Color.red);
		sbo_panel.add(sbo_editDraft);
		sbo_saveDraft = new JButton("����ݸ�");
		sbo_saveDraft.addActionListener(new ButtonActionListener());
		sbo_saveDraft.setLocation(330,565);
		sbo_saveDraft.setSize(120,40);
		sbo_saveDraft.setFocusPainted(false);
		sbo_saveDraft.setFont(font);
		sbo_saveDraft.setForeground(Color.red);
		sbo_panel.add(sbo_saveDraft);
		sbo_submit = new JButton("�ύ");
		sbo_submit.addActionListener(new ButtonActionListener());
		sbo_submit.setLocation(460,565);
		sbo_submit.setSize(80,40);
		sbo_submit.setFocusPainted(false);
		sbo_submit.setFont(font);
		sbo_submit.setForeground(Color.red);
		sbo_panel.add(sbo_submit);
		sbo_panel.setVisible(false);
		frame.getContentPane().add(sbo_panel);
		
		/*
		 * �ͻ��������
		 */
		cm_panel = new JPanel();
		cm_panel.setLayout(null);
		cm_panel.setLocation(300,50);
	    cm_panel.setSize(520,620);
	    cm_panel.setLayout(null);
	    cm_panel.setBackground(Color.cyan);
	    cm_panel.setOpaque(true);
	    /*
	     * �ͻ��б�
	     */
	    Object[][] cellData = {{"","","","","","","","","","","",""}};
	    String[] columnNames = {"���","����","����","����","�绰","��ַ","�ʱ�","��������","Ӧ�ն��","Ӧ��","Ӧ��","Ĭ��ҵ��Ա"};
	    DefaultTableModel model = new DefaultTableModel(cellData,columnNames);
	    customer_table = new JTable(model){
			public boolean isCellEditable(int row, int column) {
				if(column == 0 || column == 1 || column == 9 || column == 10){
					return false;
				}else{
					return true;
				}
			}
		};
		customer_table.addMouseListener(new MouseActionListener());
		customer_table.setPreferredSize(new Dimension(1500,400));
		//����
		DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		customer_table.setDefaultRenderer(Object.class, renderer); 

		//�����п�
		customer_table.getColumnModel().getColumn(0).setPreferredWidth(60);
		customer_table.getColumnModel().getColumn(1).setPreferredWidth(100);
		customer_table.getColumnModel().getColumn(4).setPreferredWidth(150);
		customer_table.getColumnModel().getColumn(5).setPreferredWidth(200);
		customer_table.getColumnModel().getColumn(6).setPreferredWidth(150);
	    customer_table.getColumnModel().getColumn(7).setPreferredWidth(300);
	    customer_table.getColumnModel().getColumn(8).setPreferredWidth(100);
	    customer_table.getColumnModel().getColumn(11).setPreferredWidth(150);
		//�в����ƶ�
		customer_table.getTableHeader().setReorderingAllowed(false);
		customer_table.setBackground(Color.cyan);
		customer_table.getTableHeader().setFont(font);
		customer_table.getTableHeader().setForeground(Color.red);
		customer_table.setRowHeight(33);
		customer_table.setFont(font);
		JScrollPane cm_scrollPane = new JScrollPane(customer_table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		cm_scrollPane.setSize(520,400);
		cm_scrollPane.setLocation(0,100);
		customer_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		cm_panel.add(cm_scrollPane);
		/*
		 * ��ѯ��
		 */search_customer = new JTextField();
		search_customer.setLocation(130,25);
		search_customer.setSize(280,50);
		search_customer.setFont(font);
		cm_panel.add(search_customer);
		
		classificationbox=new JComboBox<String>();
		classificationbox.setLocation(130,25);
		classificationbox.setSize(280,50);
		classificationbox.setFont(font);
		classificationbox.setBackground(Color.white);
		classificationbox.setMaximumRowCount(3);
		classificationbox.addItem("��Ӧ��");
		classificationbox.addItem("������");
		classificationbox.setVisible(false);;
		cm_panel.add(classificationbox);
		
		
		levelbox=new JComboBox<String>();
		levelbox.setLocation(130,25);
		levelbox.setSize(280,50);
		levelbox.setFont(font);
		levelbox.setBackground(Color.white);
		levelbox.setMaximumRowCount(3);
		levelbox.addItem("һ��");
		levelbox.addItem("����");
		levelbox.addItem("����");
		levelbox.addItem("�ļ�");
		levelbox.addItem("�弶");
		levelbox.setVisible(false);;
		cm_panel.add(levelbox);
		
		search_box = new JComboBox();
		search_box.addItemListener(new boxActionListener());
		search_box.setLocation(50,25);
		search_box.setSize(80,50);
		search_box.setFont(font);
		search_box.setBackground(Color.white);
		search_box.setMaximumRowCount(3);
		search_box.addItem("���");
		search_box.addItem("����");
		search_box.addItem("����");
		cm_panel.add(search_box);
		
		search = new JButton();
		search.addActionListener(new ButtonActionListener());
		search.setLocation(410,25);
		search.setSize(50,50);
		search.setFont(font);
		search.setContentAreaFilled(false);
		cm_panel.add(search);
		ImageIcon search_icon = new ImageIcon("search.png");
		JLabel search_label = new JLabel(search_icon);
		search_label.setLocation(410,25);
		search_label.setSize(search_icon.getIconWidth(),search_icon.getIconHeight());
		cm_panel.add(search_label);
		/*
		 * button�ؼ�
		 */
		//add
		addCustomer = new JButton("����");
		addCustomer.addActionListener(new ButtonActionListener());
		addCustomer.setLocation(70,540);
		addCustomer.setSize(100,50);
		addCustomer.setFont(font);
		addCustomer.setFocusPainted(false);
		addCustomer.setForeground(Color.magenta);
		cm_panel.add(addCustomer);
		//remove
		removeCustomer = new JButton("ɾ��");
		removeCustomer.addActionListener(new ButtonActionListener());
		removeCustomer.setLocation(220,540);
		removeCustomer.setSize(100,50);
		removeCustomer.setFont(font);
		removeCustomer.setFocusPainted(false);
		removeCustomer.setForeground(Color.magenta);
		cm_panel.add(removeCustomer);
		//update
		updateCustomer = new JButton("�޸�");
		updateCustomer.addActionListener(new ButtonActionListener());
		updateCustomer.setLocation(370,540);
		updateCustomer.setSize(100,50);
		updateCustomer.setFont(font);
		updateCustomer.setFocusPainted(false);
		updateCustomer.setForeground(Color.magenta);
		cm_panel.add(updateCustomer);
	    cm_panel.setVisible(false);
	    frame.getContentPane().add(cm_panel);
        
		//���뱳��ͼƬ
		JPanel imagePanel = new ImageJPanel(new ImageIcon("������.jpg").getImage());
		frame.getContentPane().add(imagePanel);
		frame.setVisible(true);
	}
	
	
	//�Զ���table
	class Mytable extends AbstractTableModel{
		String[] columnNames = {"���","����","�ͺ�","����","����","���","��ע","ѡ��"};
		Object[][] celldata = {{"","","","","","","",new Boolean(false)}};
		//����ÿһ�е�����
		
		public void setData(Object[][] data){
			celldata = data;
			fireTableDataChanged();
		}
		
		@Override
		public Class getColumnClass(int columnIndex) {
			if(columnIndex == 7){
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
			if(columnIndex==6 || columnIndex==4 || columnIndex == 7){
			    return true;
			}else{
				return false;
			}
		}
	}
	
	class Mytable1 extends AbstractTableModel{
		String[] columnNames = {"���","����","�ͺ�","����","����","���","��ע","ѡ��"};
		Object[][] celldata = {{"","","","","","","",new Boolean(false)},{"","","","","","","",new Boolean(false)},{"","","","","","","",new Boolean(false)}
		,{"","","","","","","",new Boolean(false)},{"","","","","","","",new Boolean(false)},{"","","","","","","",new Boolean(false)},
		{"","","","","","","",new Boolean(false)},{"","","","","","","",new Boolean(false)}};
		//����ÿһ�е�����
		
		public void setData(Object[][] data){
			celldata = data;
			fireTableDataChanged();
		}
		
		@Override
		public Class getColumnClass(int columnIndex) {
			if(columnIndex == 7){
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
			if(columnIndex == 3 || columnIndex==6 || columnIndex==4 || columnIndex == 7){
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
				MainFrame mainframe = new MainFrame();
			}
			else if(e.getSource() == po){
				po_panel.setVisible(true);
				pbo_panel.setVisible(false);
				so_panel.setVisible(false);
				sbo_panel.setVisible(false);
				cm_panel.setVisible(false);
				
				GoodsController gc = new GoodsController(operator);
		        CustomerController cc=new CustomerController(operator);
		        List<CustomerVO> list=cc.queryCustomerByClassification(1);
		        po_supplier.removeAllItems();
		        for(int i=0;i<list.size();i++){
		        	po_supplier.addItem(list.get(i).getName());
		        }
				OrderController oc=new OrderController(operator);
				String number=oc.getPurchaseOrderNumber();
				po_number.setText(number);
				po_operator.setText(operator);
				po_stock.setText("");
				po_comment.setText("");
				Object[][] data = new Object[gc.query().size()][8];
				for(int i=0;i<gc.query().size();i++){
					data[i][0] = gc.query().get(i).getNumber();
					data[i][1] = gc.query().get(i).getName();
					data[i][2] = gc.query().get(i).getType();
					data[i][3] = gc.query().get(i).getPricein();
					data[i][4] = 0;
					data[i][5] = 0.0;
					data[i][6] = "";
					data[i][7] = new Boolean(false);
				}
				po_mytable.setData(data);
				po_addAll.setText("0.0");
				
			
			}
			else if(e.getSource() == pbo){
				po_panel.setVisible(false);
				pbo_panel.setVisible(true);
				so_panel.setVisible(false);
				sbo_panel.setVisible(false);
				cm_panel.setVisible(false);
				OrderController oc=new OrderController(operator);
			    CustomerController cc=new CustomerController(operator);
			    List<CustomerVO> list=cc.queryCustomerByClassification(1);
			    pbo_supplier.removeAllItems();
			    for(int i=0;i<list.size();i++){
			       pbo_supplier.addItem(list.get(i).getName());
			    }
				String number=oc.getPurchaseBackOrderNumber();
				pbo_number.setText(number);
				pbo_number.setEditable(false);
				pbo_operator.setText(operator);
				pbo_operator.setEditable(false);
				pbo_stock.setText("");
				pbo_comment.setText("");
				GoodsController gc = new GoodsController(operator);
				Object[][] data = new Object[gc.query().size()][8];
				for(int i=0;i<gc.query().size();i++){
					data[i][0] = gc.query().get(i).getNumber();
					data[i][1] = gc.query().get(i).getName();
					data[i][2] = gc.query().get(i).getType();
					data[i][3] = gc.query().get(i).getPricein();
					data[i][4] = 0;
					data[i][5] = 0.0;
					data[i][6] = "";
					data[i][7] = new Boolean(false);
				}
				pbo_addAll.setText("0.0");
				pbo_mytable.setData(data);
			}
			else if(e.getSource() == so){
				po_panel.setVisible(false);
				pbo_panel.setVisible(false);
				so_panel.setVisible(true);
				sbo_panel.setVisible(false);
				cm_panel.setVisible(false);
				GoodsController gc = new GoodsController(operator);
		        CustomerController cc=new CustomerController(operator);
		        List<CustomerVO> list=cc.queryCustomerByClassification(0);
		        so_retailer.removeAllItems();
		        for(int i=0;i<list.size();i++){
		        	so_retailer.addItem(list.get(i).getName());
		        }
				OrderController oc=new OrderController(operator);					
				Object[][] data = new Object[gc.query().size()][8];
				for(int i=0;i<gc.query().size();i++){
					data[i][0] = gc.query().get(i).getNumber();
					data[i][1] = gc.query().get(i).getName();
					data[i][2] = gc.query().get(i).getType();
					data[i][3] = gc.query().get(i).getPricein();
					data[i][4] = 0;
					data[i][5] = 0.0;
					data[i][6] = "";
					data[i][7] = new Boolean(false);
				}
				so_mytable.setData(data);
		
				String number=oc.getSalesOrderNumber();
				so_number.setText(number);
				so_number.setEditable(false);
				so_operator.setText(operator);
				so_operator.setEditable(false);
				so_stock.setText("");
				so_beforeDiscount.setText("0.0");
				so_afterDiscount.setText("0.0");
			}
			else if(e.getSource() == sbo){
				po_panel.setVisible(false);
				pbo_panel.setVisible(false);
				so_panel.setVisible(false);
				sbo_panel.setVisible(true);
				cm_panel.setVisible(false);
				CustomerController cc=new CustomerController(operator);
			    List<CustomerVO> list=cc.queryCustomerByClassification(0);
			    sbo_retailer.removeAllItems();
			    for(int i=0;i<list.size();i++){
			       sbo_retailer.addItem(list.get(i).getName());
			    }
			    GoodsController gc = new GoodsController(operator);
			    Object[][] data = new Object[gc.query().size()][8];
				for(int i=0;i<gc.query().size();i++){
					data[i][0] = gc.query().get(i).getNumber();
					data[i][1] = gc.query().get(i).getName();
					data[i][2] = gc.query().get(i).getType();
					data[i][3] = gc.query().get(i).getPricein();
					data[i][4] = 0;
					data[i][5] = 0.0;
					data[i][6] = "";
					data[i][7] = new Boolean(false);
				}
				sbo_mytable.setData(data);
				OrderController oc=new OrderController(operator);
				String number=oc.getSalesBackOrderNumber();
				sbo_number.setText(number);
				sbo_number.setEditable(false);
				sbo_operator.setText(operator);
				sbo_operator.setEditable(false);
				sbo_stock.setText("");
				sbo_comment.setText("");
				sbo_afterDiscount.setText("0.0");
			}
			else if(e.getSource() == cm){
				po_panel.setVisible(false);
				pbo_panel.setVisible(false);
				so_panel.setVisible(false);
				sbo_panel.setVisible(false);
				cm_panel.setVisible(true);
                
				DefaultTableModel model = (DefaultTableModel)customer_table.getModel();
				int n = model.getRowCount() - 1;
				while(n >= 0){
					model.removeRow(n);
					n--;
				}
				CustomerController cc=new CustomerController(operator);
				List<CustomerVO> list=cc.queryCustomer();
				Object[][] data = new Object[list.size()][12];
				for(int i=0;i<list.size();i++){
					data[i][0] = list.get(i).getNumber();
					data[i][1] = list.get(i).getName();
					if(list.get(i).getClassfication()==0)
					    data[i][2] = "������";
					else 
						data[i][2] = "��Ӧ��";
					if(list.get(i).getLevel()==1)
					     data[i][3] = "һ��";
					else if(list.get(i).getLevel()==2)
						 data[i][3] = "����";
					else if(list.get(i).getLevel()==3)
						 data[i][3] = "����";
					else if(list.get(i).getLevel()==4)
						 data[i][3] = "�ļ�";
					else if(list.get(i).getLevel()==5)
						 data[i][3] = "�弶";
					data[i][4] = list.get(i).getTelephone();
					data[i][5] = list.get(i).getAddress();
					data[i][6] = list.get(i).getPostcode();
					data[i][7] = list.get(i).getEmail();
					data[i][8] = list.get(i).getMaxincome();
					data[i][9] = list.get(i).getIncome();
					data[i][10] = list.get(i).getPayment();
					data[i][11] = list.get(i).getDefaultname();	
				}
				for(int i=0;i<list.size();i++){
					model.addRow(data[i]);
				}
				customer_table.setModel(model);
			}
			else if(e.getSource() == removeCustomer){
				System.out.println(removeFlag);
				if(removeFlag != -1){
					DefaultTableModel model = (DefaultTableModel)customer_table.getModel();
					model.removeRow(removeFlag);
					customer_table.setModel(model);
					removeFlag = -1;
					updateFlag = -1;
					GoodsClassificationController gcc = new GoodsClassificationController(operator);
					 gcc.insertLog("ɾ���ͻ�");
				}
			}
			else if(e.getSource() == updateCustomer){
				if(updateFlag != -1){
					DefaultTableModel model=(DefaultTableModel)customer_table.getModel();
					CustomerVO customer=new CustomerVO();
					customer.setNumber(model.getValueAt(updateFlag, 0).toString());
					customer.setName(model.getValueAt(updateFlag, 1).toString());
					if(model.getValueAt(updateFlag, 2).toString().equals("��Ӧ��"))
						customer.setClassfication(1);
					else
						customer.setClassfication(0);
					if(model.getValueAt(updateFlag, 3).toString().equals("һ��"))
						customer.setLevel(1);
					else if(model.getValueAt(updateFlag, 3).toString().equals("����"))
						customer.setLevel(2);
					else if(model.getValueAt(updateFlag, 3).toString().equals("����"))
						customer.setLevel(3);
					else if(model.getValueAt(updateFlag, 3).toString().equals("�ļ�"))
						customer.setLevel(4);
					else if(model.getValueAt(updateFlag, 3).toString().equals("�弶"))
						customer.setLevel(5);
					customer.setTelephone(model.getValueAt(updateFlag,4 ).toString());
					customer.setPostcode(model.getValueAt(updateFlag, 6).toString());
					customer.setAddress(model.getValueAt(updateFlag, 5).toString());
					customer.setMaxincome(Double.valueOf(model.getValueAt(updateFlag, 8).toString()));
					customer.setEmail(model.getValueAt(updateFlag, 7).toString());
					customer.setPayment(Double.valueOf(model.getValueAt(updateFlag, 9).toString()));
					customer.setIncome(Double.valueOf(model.getValueAt(updateFlag, 10).toString()));
					customer.setDefaultname(model.getValueAt(updateFlag, 11).toString());
					CustomerController cc=new CustomerController(operator);
					cc.updateCustomer(customer);
					updateFlag=-1;
					GoodsClassificationController gcc = new GoodsClassificationController(operator);
					 gcc.insertLog("���¿ͻ�");
				}
			}
			else if(e.getSource()==search){
				String s=search_box.getSelectedItem().toString();
				//String keyword=search_customer.getText();
				CustomerController cc=new CustomerController(operator);
				if(s.equals("����")){
					String keyword=classificationbox.getSelectedItem().toString();
					List<CustomerVO> list=null;
					if(keyword.equals("��Ӧ��")){
						list = cc.queryCustomerByClassification(1);
						DefaultTableModel model = (DefaultTableModel)customer_table.getModel();
						int n = model.getRowCount() - 1;
						while(n >= 0){
							model.removeRow(n);
							n--;
						}
						
						Object[][] data = new Object[list.size()][12];
						for(int i=0;i<list.size();i++){
							data[i][0] = list.get(i).getNumber();
							data[i][1] = list.get(i).getName();
							if(list.get(i).getClassfication()==0)
							    data[i][2] = "������";
							else 
								data[i][2] = "��Ӧ��";
							if(list.get(i).getLevel()==1)
								data[i][3]="һ��";
							else if(list.get(i).getLevel()==2)
								data[i][3]="����";
							else if(list.get(i).getLevel()==3)
								data[i][3]="����";
							else if(list.get(i).getLevel()==4)
								data[i][3]="�ļ�";
							else if(list.get(i).getLevel()==5)
								data[i][3]="�弶";						
							data[i][4] = list.get(i).getTelephone();
							data[i][5] = list.get(i).getAddress();
							data[i][6] = list.get(i).getPostcode();
							data[i][7] = list.get(i).getEmail();
							data[i][8] = list.get(i).getMaxincome();
							data[i][9] = list.get(i).getIncome();
							data[i][10] = list.get(i).getPayment();
							data[i][11] = list.get(i).getDefaultname();	
						}
						for(int i=0;i<list.size();i++){
							model.addRow(data[i]);
						}
						customer_table.setModel(model);
						
					}
					    
					else if(keyword.equals("������")){
						list=cc.queryCustomerByClassification(0);
						DefaultTableModel model = (DefaultTableModel)customer_table.getModel();
						int n = model.getRowCount() - 1;
						while(n >= 0){
							model.removeRow(n);
							n--;
						}
						
						Object[][] data = new Object[list.size()][12];
						for(int i=0;i<list.size();i++){
							data[i][0] = list.get(i).getNumber();
							data[i][1] = list.get(i).getName();
							if(list.get(i).getClassfication()==0)
							    data[i][2] = "������";
							else 
								data[i][2] = "��Ӧ��";
							if(list.get(i).getLevel()==1)
								data[i][3]="һ��";
							else if(list.get(i).getLevel()==2)
								data[i][3]="����";
							else if(list.get(i).getLevel()==3)
								data[i][3]="����";
							else if(list.get(i).getLevel()==4)
								data[i][3]="�ļ�";
							else if(list.get(i).getLevel()==5)
								data[i][3]="�弶";	
							data[i][4] = list.get(i).getTelephone();
							data[i][5] = list.get(i).getAddress();
							data[i][6] = list.get(i).getPostcode();
							data[i][7] = list.get(i).getEmail();
							data[i][8] = list.get(i).getMaxincome();
							data[i][9] = list.get(i).getIncome();
							data[i][10] = list.get(i).getPayment();
							data[i][11] = list.get(i).getDefaultname();	
						}
						for(int i=0;i<list.size();i++){
							model.addRow(data[i]);
						}
						customer_table.setModel(model);
						}
						
				/*	else
						 JOptionPane.showMessageDialog(null,"������Ч");*/
						
					
				}
				else if(s.equals("����")){
					String keyword=levelbox.getSelectedItem().toString();
					int level=0;
					if(keyword.equals("һ��")){
						level=1;
					}
					else if(keyword.equals("����")){
						level=2;
					}
					else if(keyword.equals("����")){
						level=3;
					}
					else if(keyword.equals("�ļ�")){
						level=4;
					}
					else if(keyword.equals("�弶")){
						level=5;
					}
					
					List<CustomerVO> list=cc.queryCustomerByLevel(level);
					DefaultTableModel model = (DefaultTableModel)customer_table.getModel();
					int n = model.getRowCount() - 1;
					while(n >= 0){
						model.removeRow(n);
						n--;
					}
					
					Object[][] data = new Object[list.size()][12];
					for(int i=0;i<list.size();i++){
						data[i][0] = list.get(i).getNumber();
						data[i][1] = list.get(i).getName();
						if(list.get(i).getClassfication()==0)
						    data[i][2] = "������";
						else 
							data[i][2] = "��Ӧ��";
						if(list.get(i).getLevel()==1)
							data[i][3]="һ��";
						else if(list.get(i).getLevel()==2)
							data[i][3]="����";
						else if(list.get(i).getLevel()==3)
							data[i][3]="����";
						else if(list.get(i).getLevel()==4)
							data[i][3]="�ļ�";
						else if(list.get(i).getLevel()==5)
							data[i][3]="�弶";	
						data[i][4] = list.get(i).getTelephone();
						data[i][5] = list.get(i).getAddress();
						data[i][6] = list.get(i).getPostcode();
						data[i][7] = list.get(i).getEmail();
						data[i][8] = list.get(i).getMaxincome();
						data[i][9] = list.get(i).getIncome();
						data[i][10] = list.get(i).getPayment();
						data[i][11] = list.get(i).getDefaultname();	
					}
					for(int i=0;i<list.size();i++){
						model.addRow(data[i]);
					}
					customer_table.setModel(model);
				}
				else if(s.equals("���")){
					String keyword = search_customer.getText().toString();
					CustomerVO c=cc.queryCustomerByNumber(keyword);
					DefaultTableModel model = (DefaultTableModel)customer_table.getModel();
					int n = model.getRowCount() - 1;
					while(n >= 0){
						model.removeRow(n);
						n--;
					}
					Object[][] data = new Object[1][12];
					data[0][0] = c.getNumber();
					data[0][1] = c.getName();
					if(c.getClassfication()==0)
					    data[0][2] = "������";
					else 
						data[0][2] = "��Ӧ��";
					if(c.getLevel()==1)
						data[0][3]="һ��";
					else if(c.getLevel()==2)
						data[0][3]="����";
					else if(c.getLevel()==3)
						data[0][3]="����";
					else if(c.getLevel()==4)
						data[0][3]="�ļ�";
					else if(c.getLevel()==5)
						data[0][3]="�弶";	
					data[0][4] = c.getTelephone();
					data[0][5] = c.getAddress();
					data[0][6] = c.getPostcode();
					data[0][7] = c.getEmail();
					data[0][8] = c.getMaxincome();
					data[0][9] = c.getIncome();
					data[0][10] = c.getPayment();
					data[0][11] = c.getDefaultname();	
					model.addRow(data[0]);
					customer_table.setModel(model);
					
				}
				GoodsClassificationController gcc = new GoodsClassificationController(operator);
				 gcc.insertLog("�½���ѯ�ͻ�");
			}
			else if(e.getSource() == po_submit){
				PurchaseOrderVO vo = new PurchaseOrderVO();
				List<GoodsListVO> list = new ArrayList<GoodsListVO>();
				for(int i=0;i<po_gs.getRowCount();i++){					
					if((boolean)po_gs.getValueAt(i, 7)){
						GoodsListVO g = new GoodsListVO();
						g.setGoodsnumber(Integer.parseInt(po_gs.getValueAt(i, 0).toString()));
						g.setGoodsname(po_gs.getValueAt(i, 1).toString());
						g.setType(po_gs.getValueAt(i, 2).toString());
						g.setPrice(Double.parseDouble(po_gs.getValueAt(i, 3).toString()));
						g.setNumber(Integer.parseInt(po_gs.getValueAt(i, 4).toString()));
						g.setComment(po_gs.getValueAt(i, 6).toString());
						g.setTotal(Double.parseDouble(po_gs.getValueAt(i, 5).toString()));
						list.add(g);
					}
				}
				vo.setList(list);
				vo.setComment(po_comment.getText());
				vo.setOperator(operator);
				vo.setDate(DatetoString.datetostr(new Date()));
				vo.setNumber(po_number.getText());
				vo.setTotal(Double.parseDouble(po_addAll.getText()));
				vo.setProvider(po_supplier.getSelectedItem().toString());
				vo.setWarehouse(po_stock.getText());
				vo.setIscheck(0);
				OrderController oc = new OrderController(operator);
				oc.CreateNewPurchaseOrder(vo);
				GoodsClassificationController gcc = new GoodsClassificationController(operator);
				gcc.insertLog("�½�������");
				JOptionPane.showMessageDialog(frame.getContentPane(), "�ύ�ɹ���");
			}
			else if(e.getSource()==po_saveDraft){
				PurchaseOrderVO vo = new PurchaseOrderVO();
				List<GoodsListVO> list = new ArrayList<GoodsListVO>();
				for(int i=0;i<po_gs.getRowCount();i++){					
					if((boolean)po_gs.getValueAt(i, 7)){
						GoodsListVO g = new GoodsListVO();
						g.setGoodsnumber(Integer.parseInt(po_gs.getValueAt(i, 0).toString()));
						g.setGoodsname(po_gs.getValueAt(i, 1).toString());
						g.setType(po_gs.getValueAt(i, 2).toString());
						g.setPrice(Double.parseDouble(po_gs.getValueAt(i, 3).toString()));
						g.setNumber(Integer.parseInt(po_gs.getValueAt(i, 4).toString()));
						g.setComment(po_gs.getValueAt(i, 6).toString());
						g.setTotal(Double.parseDouble(po_gs.getValueAt(i, 5).toString()));
						list.add(g);
					}
				}
				vo.setList(list);
				vo.setComment(po_comment.getText());
				vo.setOperator(operator);
				vo.setDate(DatetoString.datetostr(new Date()));
				vo.setNumber(po_number.getText());
				vo.setTotal(Double.parseDouble(po_addAll.getText()));
				vo.setProvider(po_supplier.getSelectedItem().toString());
				vo.setWarehouse(po_stock.getText());
				vo.setIscheck(2);
				OrderController oc = new OrderController(operator);
				oc.draftPurchaseOrder(vo);
				GoodsClassificationController gcc = new GoodsClassificationController(operator);
				gcc.insertLog("����������ݸ�");
			}
			else if(e.getSource() == pbo_submit){
				PurchaseBackOrderVO vo = new PurchaseBackOrderVO();
				List<GoodsListVO> list = new ArrayList<GoodsListVO>();
				for(int i=0;i<pbo_gs.getRowCount();i++){					
					if((boolean)pbo_gs.getValueAt(i, 7)){
						GoodsListVO g = new GoodsListVO();
						g.setGoodsnumber(Integer.parseInt(pbo_gs.getValueAt(i, 0).toString()));
						g.setGoodsname(pbo_gs.getValueAt(i, 1).toString());
						g.setType(pbo_gs.getValueAt(i, 2).toString());
						g.setPrice(Double.parseDouble(pbo_gs.getValueAt(i, 3).toString()));
						g.setNumber(Integer.parseInt(pbo_gs.getValueAt(i, 4).toString()));
						g.setComment(pbo_gs.getValueAt(i, 6).toString());
						g.setTotal(Double.parseDouble(pbo_gs.getValueAt(i, 5).toString()));
						list.add(g);
						//System.out.println(g.getGoodsnumber()+" "+g.getNumber());
					}
				}
				vo.setList(list);
				vo.setIscheck(0);
				vo.setComment(pbo_comment.getText());
				vo.setOperator(operator);
				vo.setDate(DatetoString.datetostr(new Date()));
				vo.setNumber(pbo_number.getText());
				vo.setTotal(Double.parseDouble(pbo_addAll.getText()));
				vo.setProvider(pbo_supplier.getSelectedItem().toString());
				vo.setWarehouse(pbo_stock.getText());
				OrderController oc = new OrderController(operator);
				oc.CreateNewPurchaseBackOrder(vo);
				GoodsClassificationController gcc = new GoodsClassificationController(operator);
				gcc.insertLog("�½������˻���");
				JOptionPane.showMessageDialog(frame.getContentPane(), "�ύ�ɹ���");
			}
			else if(e.getSource()==pbo_saveDraft){
				PurchaseBackOrderVO vo = new PurchaseBackOrderVO();
				List<GoodsListVO> list = new ArrayList<GoodsListVO>();
				for(int i=0;i<pbo_gs.getRowCount();i++){					
					if((boolean)pbo_gs.getValueAt(i, 7)){
						GoodsListVO g = new GoodsListVO();
						g.setGoodsnumber(Integer.parseInt(pbo_gs.getValueAt(i, 0).toString()));
						g.setGoodsname(pbo_gs.getValueAt(i, 1).toString());
						g.setType(pbo_gs.getValueAt(i, 2).toString());
						g.setPrice(Double.parseDouble(pbo_gs.getValueAt(i, 3).toString()));
						g.setNumber(Integer.parseInt(pbo_gs.getValueAt(i, 4).toString()));
						g.setComment(pbo_gs.getValueAt(i, 6).toString());
						g.setTotal(Double.parseDouble(pbo_gs.getValueAt(i, 5).toString()));
						list.add(g);
					}
				}
				vo.setList(list);
				vo.setIscheck(2);
				vo.setComment(pbo_comment.getText());
				vo.setOperator(operator);
				vo.setDate(DatetoString.datetostr(new Date()));
				vo.setNumber(pbo_number.getText());
				vo.setTotal(Double.parseDouble(pbo_addAll.getText()));
				vo.setProvider(pbo_supplier.getSelectedItem().toString());
				vo.setWarehouse(pbo_stock.getText());
				OrderController oc = new OrderController(operator);
				oc.draftPurchaseBackOrder(vo);
				GoodsClassificationController gcc = new GoodsClassificationController(operator);
				gcc.insertLog("��������˻������ݸ�");
			}
			else if(e.getSource()==so_submit){
				
				    double num=Double.valueOf(so_beforeDiscount.getText());
				    double jiangjia=0;
			        double voucherlevel=0;
			        double vouchertotal=0;
			        List<GoodsListVO> list2=new ArrayList<GoodsListVO>();
			    	for(int i=0;i<so_gs.getRowCount();i++){
						if((boolean)so_mytable.getValueAt(i, 7)){
							GoodsListVO goodlist=new GoodsListVO();						
							goodlist.setGoodsnumber(Integer.parseInt(so_mytable.getValueAt(i, 0).toString()));						
						    list2.add(goodlist);
						}
					}
			        
			        PromotionController pc=new PromotionController(operator);
			    	jiangjia=pc.getpromotionByGoodsCombination(list2);
			    	if(pc.getpromotionByTotal(num)!=null){
			    		vouchertotal=pc.getpromotionByTotal(num).getVoucher();
			    		List<GoodsListVO> list1=pc.getpromotionByTotal(num).getEverylist();  	
			    		String present="";
			    		GoodsController gc=new GoodsController(operator);
			    		for(int i=0;i<list1.size();i++){
			    			String name=gc.queryGoodsByNumebr(list1.get(i).getGoodsnumber()).getName();
			    			present=present+name+" "+list1.get(i).getNumber()+" ";
			    		}
			    		voucherlevel=Double.valueOf(so_voucher.getText());
			    		so_voucher.setText(String.valueOf(voucherlevel+vouchertotal));
			    		//System.out.println("present"+so_comment.getText());
			    		so_comment.setText(pc.union(so_comment.getText(),present));		    			    			    	
			    		}
			    	else{
			    		if(!so_voucher.getText().equals(""))
			    		    voucherlevel=Double.valueOf(so_voucher.getText());		    		
			    	}
			    	
			    	double last=num*Double.valueOf(so_discount.getText())-jiangjia-voucherlevel-vouchertotal;
			    	if(last<0)
			    		last=0;
			    	so_afterDiscount.setText(String.valueOf(last));
				SalesOrderVO sales=new SalesOrderVO();
 				String number=so_number.getText().toString();
				String salesperson=so_retailer.getSelectedItem().toString();
				String warehouse=so_stock.getText();
				String operator=so_operator.getText();
				String comment=so_comment.getText();
				System.out.println(comment);
				String defaultname=so_salesman.getText();
				
				sales.setNumber(number);
				sales.setSalesperson(salesperson);
				sales.setWarehouse(warehouse);
				sales.setOperator(operator);
				sales.setDefaultname(defaultname);
				sales.setComment(comment);
				sales.setDate(DatetoString.datetostr(new Date()));
				List<GoodsListVO> list = new ArrayList<GoodsListVO>();
				for(int i=0;i<so_gs.getRowCount();i++){					
					if((boolean)so_gs.getValueAt(i, 7)){
						GoodsListVO g = new GoodsListVO();
						g.setGoodsnumber(Integer.parseInt(so_gs.getValueAt(i, 0).toString()));
						g.setGoodsname(so_gs.getValueAt(i, 1).toString());
						g.setType(so_gs.getValueAt(i, 2).toString());
						g.setPrice(Double.parseDouble(so_gs.getValueAt(i, 3).toString()));
						g.setNumber(Integer.parseInt(so_gs.getValueAt(i, 4).toString()));
						g.setComment(so_gs.getValueAt(i, 6).toString());
						g.setTotal(Double.parseDouble(so_gs.getValueAt(i, 5).toString()));
						list.add(g);
					}
				}
				
				sales.setList(list);
				sales.setIscheck(0);
				sales.setDiscount(Double.valueOf(so_discount.getText()));
				sales.setVoucher(Double.valueOf(so_voucher.getText()));
				sales.setTotal(Double.valueOf(so_beforeDiscount.getText()));
				sales.setLasttotal(Double.valueOf(so_afterDiscount.getText()));
				OrderController oc=new OrderController(operator);
			    ResultMessage res=oc.CreateNewSalesOrder(sales);
			    System.out.println(res.getMessage());
				
			    GoodsClassificationController gcc = new GoodsClassificationController(operator);
				gcc.insertLog("�½����۵�");
				JOptionPane.showMessageDialog(frame.getContentPane(), "�ύ�ɹ���");
			}
			else if(e.getSource()==so_saveDraft){
				SalesOrderVO sales=new SalesOrderVO();
 				String number=so_number.getText().toString();
				String salesperson=so_retailer.getSelectedItem().toString();
				String warehouse=so_stock.getText();
				String operator=so_operator.getText();
				String comment=so_comment.getText();
				System.out.println(comment);
				String defaultname=so_salesman.getText();
				
				sales.setNumber(number);
				sales.setSalesperson(salesperson);
				sales.setWarehouse(warehouse);
				sales.setOperator(operator);
				sales.setDefaultname(defaultname);
				sales.setComment(comment);
				sales.setDate(DatetoString.datetostr(new Date()));
				List<GoodsListVO> list = new ArrayList<GoodsListVO>();
				for(int i=0;i<so_gs.getRowCount();i++){					
					if((boolean)so_gs.getValueAt(i, 7)){
						GoodsListVO g = new GoodsListVO();
						g.setGoodsnumber(Integer.parseInt(so_gs.getValueAt(i, 0).toString()));
						g.setGoodsname(so_gs.getValueAt(i, 1).toString());
						g.setType(so_gs.getValueAt(i, 2).toString());
						g.setPrice(Double.parseDouble(so_gs.getValueAt(i, 3).toString()));
						g.setNumber(Integer.parseInt(so_gs.getValueAt(i, 4).toString()));
						g.setComment(so_gs.getValueAt(i, 6).toString());
						g.setTotal(Double.parseDouble(so_gs.getValueAt(i, 5).toString()));
						list.add(g);
					}
				}
				
				sales.setList(list);
				sales.setIscheck(2);
				sales.setDiscount(Double.valueOf(so_discount.getText()));
				sales.setVoucher(Double.valueOf(so_voucher.getText()));
				sales.setTotal(Double.valueOf(so_beforeDiscount.getText()));
				sales.setLasttotal(Double.valueOf(so_afterDiscount.getText()));
				OrderController oc=new OrderController(operator);
			    ResultMessage res=oc.draftSalesOrder(sales);
			    System.out.println(res.getMessage());
			    GoodsClassificationController gcc = new GoodsClassificationController(operator);
				 gcc.insertLog("�������۵��ݸ�");
			}
			else if(e.getSource()==sbo_submit){
				SalesBackOrderVO sales=new SalesBackOrderVO();
 				String number=sbo_number.getText().toString();
				String salesperson=sbo_retailer.getSelectedItem().toString();
				String warehouse=sbo_stock.getText();
				String operator=sbo_operator.getText();
				String comment=sbo_comment.getText();
				String defaultname=sbo_salesman.getText();
				
				sales.setNumber(number);
				sales.setSalesperson(salesperson);
				sales.setWarehouse(warehouse);
				sales.setOperator(operator);
				sales.setDefaultname(defaultname);
				sales.setComment(comment);
				sales.setDate(DatetoString.datetostr(new Date()));
				List<GoodsListVO> list = new ArrayList<GoodsListVO>();
				for(int i=0;i<sbo_gs.getRowCount();i++){					
					if((boolean)sbo_gs.getValueAt(i, 7)){
						GoodsListVO g = new GoodsListVO();
						g.setGoodsnumber(Integer.parseInt(sbo_gs.getValueAt(i, 0).toString()));
						g.setGoodsname(sbo_gs.getValueAt(i, 1).toString());
						g.setType(sbo_gs.getValueAt(i, 2).toString());
						g.setPrice(Double.parseDouble(sbo_gs.getValueAt(i, 3).toString()));
						g.setNumber(Integer.parseInt(sbo_gs.getValueAt(i, 4).toString()));
						g.setComment(sbo_gs.getValueAt(i, 6).toString());
						g.setTotal(Double.parseDouble(sbo_gs.getValueAt(i, 5).toString()));
						list.add(g);
					}
				}
				
				sales.setList(list);
				sales.setIscheck(0);
				sales.setTotal(Double.valueOf(sbo_afterDiscount.getText()));
				
				OrderController oc=new OrderController(operator);
				ResultMessage res=oc.CreateNewSalesBackOrder(sales);
				System.out.println(res.getMessage());
				
				GoodsClassificationController gcc = new GoodsClassificationController(operator);
				gcc.insertLog("�½������˻���");
				JOptionPane.showMessageDialog(frame.getContentPane(), "�ύ�ɹ���");
			}
			else if(e.getSource()==sbo_saveDraft){
				SalesBackOrderVO sales=new SalesBackOrderVO();
 				String number=sbo_number.getText().toString();
				String salesperson=sbo_retailer.getSelectedItem().toString();
				String warehouse=sbo_stock.getText();
				String operator=sbo_operator.getText();
				String comment=sbo_comment.getText();
				String defaultname=sbo_salesman.getText();
				
				sales.setNumber(number);
				sales.setSalesperson(salesperson);
				sales.setWarehouse(warehouse);
				sales.setOperator(operator);
				sales.setDefaultname(defaultname);
				sales.setComment(comment);
				sales.setDate(DatetoString.datetostr(new Date()));
				List<GoodsListVO> list = new ArrayList<GoodsListVO>();
				for(int i=0;i<sbo_gs.getRowCount();i++){					
					if((boolean)sbo_gs.getValueAt(i, 7)){
						GoodsListVO g = new GoodsListVO();
						g.setGoodsnumber(Integer.parseInt(sbo_gs.getValueAt(i, 0).toString()));
						g.setGoodsname(sbo_gs.getValueAt(i, 1).toString());
						g.setType(sbo_gs.getValueAt(i, 2).toString());
						g.setPrice(Double.parseDouble(sbo_gs.getValueAt(i, 3).toString()));
						g.setNumber(Integer.parseInt(sbo_gs.getValueAt(i, 4).toString()));
						g.setComment(sbo_gs.getValueAt(i, 6).toString());
						g.setTotal(Double.parseDouble(sbo_gs.getValueAt(i, 5).toString()));
						list.add(g);
					}
				}
				
				sales.setList(list);
				sales.setIscheck(2);
				sales.setTotal(Double.valueOf(sbo_afterDiscount.getText()));
				
				OrderController oc=new OrderController(operator);
				ResultMessage res=oc.draftSalesBackOrder(sales);
				System.out.println(res.getMessage());
				GoodsClassificationController gcc = new GoodsClassificationController(operator);
				 gcc.insertLog("�½������˻����ݸ�");
			}
			else if(e.getSource()==addCustomer){
				Font font = new Font("Default",Font.BOLD,20);
				cm_add_frame = new JFrame("�����ͻ�");
				cm_add_frame.setLayout(null);
				cm_add_frame.setLocation(840,220);
				cm_add_frame.setSize(350,650);
				cm_add_frame.getContentPane().setBackground(Color.cyan);
				//���
				JLabel cm_add_number_label = new JLabel("���");
				cm_add_number_label.setLocation(40,20);
				cm_add_number_label.setSize(50,40);
				cm_add_number_label.setFont(font);
				cm_add_frame.getContentPane().add(cm_add_number_label);
				cm_add_number = new JTextField();
				cm_add_number.setLocation(110,20);
				cm_add_number.setSize(180,40);
				cm_add_number.setFont(font);
				cm_add_number.setEditable(false);
				cm_add_number.setBackground(Color.white);
				cm_add_frame.add(cm_add_number);
				//����
				JLabel cm_add_class_label = new JLabel("����");
				cm_add_class_label.setLocation(40,70);
				cm_add_class_label.setSize(50,40);
				cm_add_class_label.setFont(font);
				cm_add_frame.getContentPane().add(cm_add_class_label);
				cm_add_classification = new JComboBox();
				cm_add_classification.addItem("������");
				cm_add_classification.addItem("������");
				cm_add_classification.setLocation(110,70);
				cm_add_classification.setSize(180,40);
				cm_add_classification.setFont(font);
				cm_add_classification.setBackground(Color.white);
				cm_add_frame.add(cm_add_classification);
				//����
				JLabel cm_add_level_label = new JLabel("����");
				cm_add_level_label.setLocation(40,120);
				cm_add_level_label.setSize(50,40);
				cm_add_level_label.setFont(font);
				cm_add_frame.getContentPane().add(cm_add_level_label);
				cm_add_level = new JComboBox();
				cm_add_level.addItem("һ��");
				cm_add_level.addItem("����");
				cm_add_level.addItem("����");
				cm_add_level.addItem("�ļ�");
				cm_add_level.addItem("�弶");
				cm_add_level.setLocation(110,120);
				cm_add_level.setSize(180,40);
				cm_add_level.setFont(font);
				cm_add_level.setBackground(Color.white);
				cm_add_frame.add(cm_add_level);
				//����
				JLabel cm_add_name_label = new JLabel("����");
				cm_add_name_label.setLocation(40,170);
				cm_add_name_label.setSize(50,40);
				cm_add_name_label.setFont(font);
				cm_add_frame.getContentPane().add(cm_add_name_label);
				cm_add_name = new JTextField();
				cm_add_name.setLocation(110,170);
				cm_add_name.setSize(180,40);
				cm_add_name.setFont(font);
				cm_add_name.setBackground(Color.white);
				cm_add_frame.add(cm_add_name);
				//�绰
				JLabel cm_add_phone_label = new JLabel("�绰");
				cm_add_phone_label.setLocation(40,220);
				cm_add_phone_label.setSize(50,40);
				cm_add_phone_label.setFont(font);
				cm_add_frame.getContentPane().add(cm_add_phone_label);
				cm_add_phone = new JTextField();
				cm_add_phone.setLocation(110,220);
				cm_add_phone.setSize(180,40);
				cm_add_phone.setFont(font);
				cm_add_phone.setBackground(Color.white);
				cm_add_frame.add(cm_add_phone);
				//��ַ
				JLabel cm_add_address_label = new JLabel("��ַ");
				cm_add_address_label.setLocation(40,270);
				cm_add_address_label.setSize(50,40);
				cm_add_address_label.setFont(font);
				cm_add_frame.getContentPane().add(cm_add_address_label);
				cm_add_address = new JTextField();
				cm_add_address.setLocation(110,270);
				cm_add_address.setSize(180,40);
				cm_add_address.setFont(font);
				cm_add_address.setBackground(Color.white);
				cm_add_frame.add(cm_add_address);
				//�ʱ�
				JLabel cm_add_postcode_label = new JLabel("�ʱ�");
				cm_add_postcode_label.setLocation(40,320);
				cm_add_postcode_label.setSize(50,40);
				cm_add_postcode_label.setFont(font);
				cm_add_frame.getContentPane().add(cm_add_postcode_label);
				cm_add_postcode = new JTextField();
				cm_add_postcode.setLocation(110,320);
				cm_add_postcode.setSize(180,40);
				cm_add_postcode.setFont(font);
				cm_add_postcode.setBackground(Color.white);
				cm_add_frame.add(cm_add_postcode);
				//��������
				JLabel cm_add_eMail_label = new JLabel("��������");
				cm_add_eMail_label.setLocation(20,370);
				cm_add_eMail_label.setSize(100,40);
				cm_add_eMail_label.setFont(font);
				cm_add_frame.getContentPane().add(cm_add_eMail_label);
				cm_add_eMail = new JTextField();
				cm_add_eMail.setLocation(110,370);
				cm_add_eMail.setSize(180,40);
				cm_add_eMail.setFont(font);
				cm_add_eMail.setBackground(Color.white);
				cm_add_frame.add(cm_add_eMail);
				//Ӧ�ն��
				JLabel cm_add_maxIncome_label = new JLabel("Ӧ�ն��");
				cm_add_maxIncome_label.setLocation(20,420);
				cm_add_maxIncome_label.setSize(100,40);
				cm_add_maxIncome_label.setFont(font);
				cm_add_frame.getContentPane().add(cm_add_maxIncome_label);
				cm_add_maxIncome = new JTextField();
				cm_add_maxIncome.setLocation(110,420);
				cm_add_maxIncome.setSize(180,40);
				cm_add_maxIncome.setFont(font);
				cm_add_maxIncome.setBackground(Color.white);
				cm_add_frame.add(cm_add_maxIncome);
				//Ĭ��ҵ��Ա
				JLabel cm_add_salesman_label = new JLabel("Ĭ��ҵ��Ա");
				cm_add_salesman_label.setLocation(5,470);
				cm_add_salesman_label.setSize(120,40);
				cm_add_salesman_label.setFont(font);
				cm_add_frame.getContentPane().add(cm_add_salesman_label);
				cm_add_salesman = new JTextField();
				cm_add_salesman.setLocation(110,470);
				cm_add_salesman.setSize(180,40);
				cm_add_salesman.setFont(font);
				cm_add_salesman.setBackground(Color.white);
				cm_add_frame.add(cm_add_salesman);
				//ȷ��
				cm_add_confirm = new JButton("ȷ��");
				cm_add_confirm.addActionListener(new ButtonActionListener());
				cm_add_confirm.setLocation(200,530);
				cm_add_confirm.setSize(100,50);
				cm_add_confirm.setFont(font);
				cm_add_confirm.setForeground(Color.red);
				cm_add_confirm.setFocusPainted(false);
				cm_add_frame.add(cm_add_confirm);
				//ȡ��
				cm_add_cancel = new JButton("ȡ��");
				cm_add_cancel.addActionListener(new ButtonActionListener());
				cm_add_cancel.setLocation(25,530);
				cm_add_cancel.setSize(100,50);
				cm_add_cancel.setFont(font);
				cm_add_cancel.setForeground(Color.red);
				cm_add_cancel.setFocusPainted(false);
				cm_add_frame.add(cm_add_cancel);
				cm_add_frame.setVisible(true);
				CustomerController cc=new CustomerController(operator);
				String number=cc.getcustomernumber();
				cm_add_number.setText(number);
			}
			else if(e.getSource() == cm_add_cancel){
				cm_add_frame.dispose();
			}
			else if(e.getSource() == cm_add_confirm){
				
				//������Ϣ
				DefaultTableModel model = (DefaultTableModel)customer_table.getModel();
				String [] data = new String[12];
				data[0] = cm_add_number.getText();
				data[1] = cm_add_name.getText();
				data[2] = cm_add_classification.getSelectedItem().toString();
				data[3] = cm_add_level.getSelectedItem().toString();
				data[4] = cm_add_phone.getText();
				data[5] = cm_add_address.getText();
				data[6] = cm_add_postcode.getText();
				data[7] = cm_add_eMail.getText();
				data[8] = cm_add_maxIncome.getText();
				data[9] = "0.0";
				data[10] = "0.0";
				data[11] = cm_add_salesman.getText();
				model.addRow(data);
				customer_table.setModel(model);
				
				CustomerVO c=new CustomerVO();
				c.setNumber(cm_add_number.getText());
				c.setName(cm_add_name.getText());
				if(cm_add_classification.getSelectedItem().toString().equals("������"))
				   c.setClassfication(1);
				else
					c.setClassfication(0);
				if(cm_add_level.getSelectedItem().toString().equals("һ��"))
				        c.setLevel(1);
				else if(cm_add_level.getSelectedItem().toString().equals("����"))
			        c.setLevel(2);
				else if(cm_add_level.getSelectedItem().toString().equals("����"))
			        c.setLevel(3);
				else if(cm_add_level.getSelectedItem().toString().equals("�ļ�"))
			        c.setLevel(4);
				else if(cm_add_level.getSelectedItem().toString().equals("�弶"))
			        c.setLevel(5);
				c.setTelephone(cm_add_phone.getText());
				c.setPostcode(cm_add_postcode.getText());
				c.setAddress(cm_add_address.getText());
				c.setMaxincome(Double.valueOf(cm_add_maxIncome.getText()).doubleValue());
				c.setEmail(cm_add_eMail.getText());
				c.setPayment(0);
				c.setIncome(0);
				c.setDefaultname(cm_add_salesman.getText());
				CustomerController cc=new CustomerController(operator);
				cm_add_frame.dispose();
				ResultMessage res=cc.addCustomer(c);
				JOptionPane.showMessageDialog(null,res.getMessage());
				GoodsClassificationController gcc = new GoodsClassificationController(operator);
				 gcc.insertLog("�½��ͻ�");
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
				List<PurchaseOrderVO> list = oc.querydraftPurchaseOrder();
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
				GoodsClassificationController gcc = new GoodsClassificationController(operator);
				 gcc.insertLog("�༭�����ݸ�");
			}
			else if(e.getSource() == po_editDraft_cancel){
				po_editDraft_frame.dispose();
			}
			else if(e.getSource() == po_editDraft_confirm){
				CheckPurchaseController cpc = new CheckPurchaseController(operator);
				PurchaseOrderVO vo = cpc.queryPurchaseByNumber(po_editDraft_draftNumber.getSelectedItem().toString());
				po_number.setText(vo.getNumber());
				po_supplier.setSelectedItem(vo.getProvider());
				po_stock.setText(vo.getWarehouse());
				po_operator.setText(vo.getOperator());
				po_comment.setText(vo.getComment());
				po_addAll.setText(vo.getTotal()+"");
				List<GoodsListVO> list = vo.getList();
				int j = 0;
				if(list.size() > 0){
				for(int i=0;i<po_gs.getRowCount();i++){
					if(po_mytable.getValueAt(i, 1).equals(list.get(j).getGoodsname())){
						po_mytable.setValueAt(list.get(j).getNumber(), i, 4);
						po_mytable.setValueAt(list.get(j).getTotal(), i, 5);
						po_mytable.setValueAt(list.get(j).getComment(), i, 6);
						po_mytable.setValueAt(new Boolean(true), i, 7);
						j++;
						if(j == list.size()){
							break;
						}
					}
				}
				}
				po_editDraft_frame.dispose();
			}
			else if(e.getSource() == pbo_editDraft){
				Font font = new Font("Default",Font.BOLD,20);
				pbo_editDraft_frame = new JFrame("ѡ��ݸ�");
				pbo_editDraft_frame.setLocation(850,400);
				pbo_editDraft_frame.setSize(350,200);
				pbo_editDraft_frame.setLayout(null);
				pbo_editDraft_frame.getContentPane().setBackground(Color.cyan);
				//�ݸ���
				JLabel pbo_editDraft_draftNumber_label = new JLabel("���");
				pbo_editDraft_draftNumber_label.setLocation(10,20);
				pbo_editDraft_draftNumber_label.setSize(50,30);
				pbo_editDraft_draftNumber_label.setFont(font);
				pbo_editDraft_frame.add(pbo_editDraft_draftNumber_label);
				pbo_editDraft_draftNumber = new JComboBox();
				//��������
				OrderController oc = new OrderController(operator);
				List<PurchaseBackOrderVO> list = oc.querydraftPurchaseBackOrder();
				pbo_editDraft_draftNumber.removeAllItems();
				for(int i=0;i<list.size();i++){
					pbo_editDraft_draftNumber.addItem(list.get(i).getNumber());
				}
				pbo_editDraft_draftNumber.setMaximumRowCount(5);
				pbo_editDraft_draftNumber.setLocation(70,20);
				pbo_editDraft_draftNumber.setSize(230,40);
				pbo_editDraft_draftNumber.setFont(font);
				pbo_editDraft_draftNumber.setBackground(Color.white);
				pbo_editDraft_frame.add(pbo_editDraft_draftNumber);
				//ȡ��
				pbo_editDraft_cancel = new JButton("ȡ��");
				pbo_editDraft_cancel.addActionListener(new ButtonActionListener());
				pbo_editDraft_cancel.setLocation(30,80);
				pbo_editDraft_cancel.setSize(100,50);
				pbo_editDraft_cancel.setFont(font);
				pbo_editDraft_cancel.setForeground(Color.red);
				pbo_editDraft_cancel.setFocusPainted(false);
				pbo_editDraft_frame.add(pbo_editDraft_cancel);
				//ȷ��
				pbo_editDraft_confirm = new JButton("ȷ��");
				pbo_editDraft_confirm.addActionListener(new ButtonActionListener());
				pbo_editDraft_confirm.setLocation(200,80);
				pbo_editDraft_confirm.setSize(100,50);
				pbo_editDraft_confirm.setFont(font);
				pbo_editDraft_confirm.setForeground(Color.red);
				pbo_editDraft_confirm.setFocusPainted(false);
				pbo_editDraft_frame.add(pbo_editDraft_confirm);
				pbo_editDraft_frame.setVisible(true);
				GoodsClassificationController gcc = new GoodsClassificationController(operator);
				 gcc.insertLog("�༭�����˻����ݸ�");
			}
			else if(e.getSource() == pbo_editDraft_cancel){
				pbo_editDraft_frame.dispose();
			}
			else if(e.getSource() == pbo_editDraft_confirm){
				CheckPurchaseController cpc = new CheckPurchaseController(operator);
				PurchaseBackOrderVO vo = cpc.queryPurchaseBackByNumber(pbo_editDraft_draftNumber.getSelectedItem().toString());
				pbo_number.setText(vo.getNumber());
				pbo_supplier.setSelectedItem(vo.getProvider());
				pbo_stock.setText(vo.getWarehouse());
				pbo_operator.setText(vo.getOperator());
				pbo_comment.setText(vo.getComment());
				pbo_addAll.setText(vo.getTotal()+"");
				List<GoodsListVO> list = vo.getList();
				int j = 0;
				if(list.size() > 0){
				for(int i=0;i<pbo_gs.getRowCount();i++){
					if(pbo_mytable.getValueAt(i, 0).equals(list.get(j).getGoodsnumber())){
						pbo_mytable.setValueAt(list.get(j).getNumber(), i, 4);
						pbo_mytable.setValueAt(list.get(j).getTotal(), i, 5);
						pbo_mytable.setValueAt(list.get(j).getComment(), i, 6);
						pbo_mytable.setValueAt(new Boolean(true), i, 7);
						j++;
						if(j == list.size()){
							break;
						}
					}
				}
				}
				pbo_editDraft_frame.dispose();
			}
			else if(e.getSource() == so_editDraft){
				Font font = new Font("Default",Font.BOLD,20);
				so_editDraft_frame = new JFrame("ѡ��ݸ�");
				so_editDraft_frame.setLocation(850,400);
				so_editDraft_frame.setSize(350,200);
				so_editDraft_frame.setLayout(null);
				so_editDraft_frame.getContentPane().setBackground(Color.cyan);
				//�ݸ���
				JLabel so_editDraft_draftNumber_label = new JLabel("���");
				so_editDraft_draftNumber_label.setLocation(10,20);
				so_editDraft_draftNumber_label.setSize(50,30);
				so_editDraft_draftNumber_label.setFont(font);
				so_editDraft_frame.add(so_editDraft_draftNumber_label);
				so_editDraft_draftNumber = new JComboBox();
				//��������
				OrderController oc = new OrderController(operator);
				List<SalesOrderVO> list = oc.querydraftSalesOrder();
				so_editDraft_draftNumber.removeAllItems();
				for(int i=0;i<list.size();i++){
					so_editDraft_draftNumber.addItem(list.get(i).getNumber());
				}
				so_editDraft_draftNumber.setMaximumRowCount(5);
				so_editDraft_draftNumber.setLocation(70,20);
				so_editDraft_draftNumber.setSize(230,40);
				so_editDraft_draftNumber.setFont(font);
				so_editDraft_draftNumber.setBackground(Color.white);
				so_editDraft_frame.add(so_editDraft_draftNumber);
				//ȡ��
				so_editDraft_cancel = new JButton("ȡ��");
				so_editDraft_cancel.addActionListener(new ButtonActionListener());
				so_editDraft_cancel.setLocation(30,80);
				so_editDraft_cancel.setSize(100,50);
				so_editDraft_cancel.setFont(font);
				so_editDraft_cancel.setForeground(Color.red);
				so_editDraft_cancel.setFocusPainted(false);
				so_editDraft_frame.add(so_editDraft_cancel);
				//ȷ��
				so_editDraft_confirm = new JButton("ȷ��");
				so_editDraft_confirm.addActionListener(new ButtonActionListener());
				so_editDraft_confirm.setLocation(200,80);
				so_editDraft_confirm.setSize(100,50);
				so_editDraft_confirm.setFont(font);
				so_editDraft_confirm.setForeground(Color.red);
				so_editDraft_confirm.setFocusPainted(false);
				so_editDraft_frame.add(so_editDraft_confirm);
				so_editDraft_frame.setVisible(true);
				GoodsClassificationController gcc = new GoodsClassificationController(operator);
				 gcc.insertLog("�༭���۵��ݸ�");
			}
			else if(e.getSource() == so_editDraft_cancel){
				so_editDraft_frame.dispose();
			}
			else if(e.getSource() == so_editDraft_confirm){
				CheckSalesController cpc = new CheckSalesController(operator);
				SalesOrderVO vo = cpc.querySalesByNumber(so_editDraft_draftNumber.getSelectedItem().toString());
				so_number.setText(vo.getNumber());
				so_retailer.setSelectedItem(vo.getSalesperson());
				so_salesman.setText(vo.getDefaultname());
				so_operator.setText(vo.getOperator());
				so_stock.setText(vo.getWarehouse());
				so_comment.setText(vo.getComment());
				so_beforeDiscount.setText(vo.getTotal()+"");
				so_discount.setText(vo.getDiscount()+"");
				so_voucher.setText(vo.getVoucher()+"");
				so_afterDiscount.setText(vo.getLasttotal()+"");
				List<GoodsListVO> list = vo.getList();
				int j = 0;
				if(list.size() > 0){
				for(int i=0;i<so_gs.getRowCount();i++){
					if(so_mytable.getValueAt(i, 0).equals(list.get(j).getGoodsnumber())){
						so_mytable.setValueAt(list.get(j).getPrice(), i, 3);
						so_mytable.setValueAt(list.get(j).getNumber(), i, 4);
						so_mytable.setValueAt(list.get(j).getTotal(), i, 5);
						so_mytable.setValueAt(list.get(j).getComment(), i, 6);
						so_mytable.setValueAt(new Boolean(true), i, 7);
						j++;
						if(j == list.size()){
							break;
						}
					}
				}
				}
				so_editDraft_frame.dispose();
			}
			else if(e.getSource() == sbo_editDraft){
				Font font = new Font("Default",Font.BOLD,20);
				sbo_editDraft_frame = new JFrame("ѡ��ݸ�");
				sbo_editDraft_frame.setLocation(850,400);
				sbo_editDraft_frame.setSize(350,200);
				sbo_editDraft_frame.setLayout(null);
				sbo_editDraft_frame.getContentPane().setBackground(Color.cyan);
				//�ݸ���
				JLabel sbo_editDraft_draftNumber_label = new JLabel("���");
				sbo_editDraft_draftNumber_label.setLocation(10,20);
				sbo_editDraft_draftNumber_label.setSize(50,30);
				sbo_editDraft_draftNumber_label.setFont(font);
				sbo_editDraft_frame.add(sbo_editDraft_draftNumber_label);
				sbo_editDraft_draftNumber = new JComboBox();
				//��������
				OrderController oc = new OrderController(operator);
				List<SalesBackOrderVO> list = oc.querydraftSaBacklesOrder();
				sbo_editDraft_draftNumber.removeAllItems();
				for(int i=0;i<list.size();i++){
					sbo_editDraft_draftNumber.addItem(list.get(i).getNumber());
				}
				sbo_editDraft_draftNumber.setMaximumRowCount(5);
				sbo_editDraft_draftNumber.setLocation(70,20);
				sbo_editDraft_draftNumber.setSize(250,40);
				sbo_editDraft_draftNumber.setFont(font);
				sbo_editDraft_draftNumber.setBackground(Color.white);
				sbo_editDraft_frame.add(sbo_editDraft_draftNumber);
				//ȡ��
				sbo_editDraft_cancel = new JButton("ȡ��");
				sbo_editDraft_cancel.addActionListener(new ButtonActionListener());
				sbo_editDraft_cancel.setLocation(30,80);
				sbo_editDraft_cancel.setSize(100,50);
				sbo_editDraft_cancel.setFont(font);
				sbo_editDraft_cancel.setForeground(Color.red);
				sbo_editDraft_cancel.setFocusPainted(false);
				sbo_editDraft_frame.add(sbo_editDraft_cancel);
				//ȷ��
				sbo_editDraft_confirm = new JButton("ȷ��");
				sbo_editDraft_confirm.addActionListener(new ButtonActionListener());
				sbo_editDraft_confirm.setLocation(200,80);
				sbo_editDraft_confirm.setSize(100,50);
				sbo_editDraft_confirm.setFont(font);
				sbo_editDraft_confirm.setForeground(Color.red);
				sbo_editDraft_confirm.setFocusPainted(false);
				sbo_editDraft_frame.add(sbo_editDraft_confirm);
				sbo_editDraft_frame.setVisible(true);
				GoodsClassificationController gcc = new GoodsClassificationController(operator);
				 gcc.insertLog("�༭�����˻����ݸ�");
			}
			else if(e.getSource() == sbo_editDraft_cancel){
				sbo_editDraft_frame.dispose();
			}
			else if(e.getSource() == sbo_editDraft_confirm){
				CheckSalesController cpc = new CheckSalesController(operator);
				SalesBackOrderVO vo = cpc.querySalesBackByNumber(sbo_editDraft_draftNumber.getSelectedItem().toString());
				sbo_number.setText(vo.getNumber());
				sbo_retailer.setSelectedItem(vo.getSalesperson());
				sbo_salesman.setText(vo.getDefaultname());
				sbo_operator.setText(vo.getOperator());
				sbo_stock.setText(vo.getWarehouse());
				sbo_comment.setText(vo.getComment());
				sbo_afterDiscount.setText(vo.getTotal()+"");
				List<GoodsListVO> list = vo.getList();
				int j = 0;
				if(list.size() > 0){
				for(int i=0;i<sbo_gs.getRowCount();i++){
					if(sbo_mytable.getValueAt(i, 0).equals(list.get(j).getGoodsnumber())){
						sbo_mytable.setValueAt(list.get(j).getPrice(), i, 3);
						sbo_mytable.setValueAt(list.get(j).getNumber(), i, 4);
						sbo_mytable.setValueAt(list.get(j).getTotal(), i, 5);
						sbo_mytable.setValueAt(list.get(j).getComment(), i, 6);
						sbo_mytable.setValueAt(new Boolean(true), i, 7);
						j++;
						if(j == list.size()){
							break;
						}
					}
				}
				}
				sbo_editDraft_frame.dispose();
			}
		}
	}
	
	class MouseActionListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == po_gs){
				int row = po_gs.getSelectedRow();
			    if(String.valueOf(po_mytable.getValueAt(row, 4)) != "0"&&!String.valueOf(po_mytable.getValueAt(row, 4)).equals("")){
			    	double num = Double.parseDouble(po_mytable.getValueAt(row, 4).toString());
			    	double price = Double.parseDouble(po_mytable.getValueAt(row, 3).toString());
			    	double money = num * price;
			    	po_mytable.setValueAt(money, row, 5);
			    }
			    if(po_gs.getSelectedColumn() == 7){
			    	double num = 0;
			    	for(int i=0;i<po_gs.getRowCount();i++){
						if((boolean)po_gs.getValueAt(i, 7)){
							num = num + Double.parseDouble(po_gs.getValueAt(i, 5).toString());
						}
					}
			    	po_addAll.setText((num+""));
			    }
			}
			else if(e.getSource() == pbo_gs){
				int row = pbo_gs.getSelectedRow();
			    if(String.valueOf(pbo_mytable.getValueAt(row, 4)) != "0"&&!String.valueOf(pbo_mytable.getValueAt(row, 4)).equals("")){
			    	double num = Double.parseDouble(pbo_mytable.getValueAt(row, 4).toString());
			    	double price = Double.parseDouble(pbo_mytable.getValueAt(row, 3).toString());
			    	double money = num * price;
			    	pbo_mytable.setValueAt(money, row, 5);
			    }
			    if(pbo_gs.getSelectedColumn() == 7){
			    	double num = 0;
			    	for(int i=0;i<pbo_gs.getRowCount();i++){
						if((boolean)pbo_gs.getValueAt(i, 7)){
							num = num + Double.parseDouble(pbo_gs.getValueAt(i, 5).toString());
						}
					}
			    	pbo_addAll.setText((num+""));
			    }
			}
			else if(e.getSource() == so_gs){
				int row = so_gs.getSelectedRow();
			    if(String.valueOf(so_mytable.getValueAt(row, 4)) != "0"&&!String.valueOf(so_mytable.getValueAt(row, 4)).equals("")){
			    	double num = Double.parseDouble(so_mytable.getValueAt(row, 4).toString());
			    	double price = Double.parseDouble(so_mytable.getValueAt(row, 3).toString());
			    	double money = num * price;
			    	so_mytable.setValueAt(money, row, 5);
			    }
			    if(so_gs.getSelectedColumn() == 7){
			    	double num = 0;
			        List<GoodsListVO> list=new ArrayList<GoodsListVO>();
			    	for(int i=0;i<so_gs.getRowCount();i++){
						if((boolean)so_mytable.getValueAt(i, 7)){
							num = num + Double.parseDouble(so_mytable.getValueAt(i, 5).toString());
							GoodsListVO goodlist=new GoodsListVO();						
							goodlist.setGoodsnumber(Integer.parseInt(so_mytable.getValueAt(i, 0).toString()));						
						    list.add(goodlist);
						}
					}
			    	so_beforeDiscount.setText((num+""));
			    	
			    	/*
			        double jiangjia=0;
			        double voucherlevel=0;
			        double vouchertotal=0;
			        PromotionController pc=new PromotionController(operator);
			    	jiangjia=pc.getpromotionByGoodsCombination(list);
			    	if(pc.getpromotionByTotal(num)!=null){
			    		vouchertotal=pc.getpromotionByTotal(num).getVoucher();
			    		List<GoodsListVO> list1=pc.getpromotionByTotal(num).getEverylist();  	
			    		String present="";
			    		GoodsController gc=new GoodsController(operator);
			    		for(int i=0;i<list1.size();i++){
			    			String name=gc.queryGoodsByNumebr(list1.get(i).getGoodsnumber()).getName();
			    			present=present+name+" "+list1.get(i).getNumber()+" ";
			    		}
			    		voucherlevel=Double.valueOf(so_voucher.getText());
			    		so_voucher.setText(String.valueOf(voucherlevel+vouchertotal));
			    		//System.out.println("present"+so_comment.getText());
			    		so_comment.setText(pc.union(so_comment.getText(),present));		    			    			    	
			    		}
			    	else{
			    		if(!so_voucher.getText().equals(""))
			    		    voucherlevel=Double.valueOf(so_voucher.getText());		    		
			    	}
			    	double last=num*Double.valueOf(so_discount.getText())-jiangjia-voucherlevel-vouchertotal;
			    	if(last<0)
			    		last=0;
			    	so_afterDiscount.setText(String.valueOf(last));*/
			    }	
			}
			else if(e.getSource() == sbo_gs){
				int row = sbo_gs.getSelectedRow();
			    if(String.valueOf(sbo_mytable.getValueAt(row, 4)) != "0"&&!String.valueOf(sbo_mytable.getValueAt(row, 4)).equals("")){
			    	double num = Double.parseDouble(sbo_mytable.getValueAt(row, 4).toString());
			    	double price = Double.parseDouble(sbo_mytable.getValueAt(row, 3).toString());
			    	double money = num * price;
			    	sbo_mytable.setValueAt(money, row, 5);
			    }
			    if(sbo_gs.getSelectedColumn() == 7){
			    	double num = 0;
			    	for(int i=0;i<sbo_gs.getRowCount();i++){
						if((boolean)sbo_gs.getValueAt(i, 7)){
							num = num + Double.parseDouble(sbo_gs.getValueAt(i, 5).toString());
						}
					}
			    	//sbo_beforeDiscount.setText((num+""));
			    	sbo_afterDiscount.setText((num+""));
			    }
			}
			/*else if(e.getSource() == so_afterDiscount){
				double discount = Double.parseDouble(so_discount.getText());
		    	double beforeDiscount = Double.parseDouble(so_beforeDiscount.getText());
		    	double afterDiscount = discount * beforeDiscount-;
		    	so_afterDiscount.setText(afterDiscount+"");
			}
			else if(e.getSource() == sbo_afterDiscount){
				double discount = Double.parseDouble(sbo_discount.getText());
		    	double beforeDiscount = Double.parseDouble(sbo_beforeDiscount.getText());
		    	double afterDiscount = discount * beforeDiscount;
		    	sbo_afterDiscount.setText(afterDiscount+"");
			}*/
			else if(e.getSource() == customer_table){
           	 removeFlag = customer_table.getSelectedRow();
           	 updateFlag = customer_table.getSelectedRow();
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
	
	 class boxItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(e.getStateChange() == ItemEvent.SELECTED){
				if(e.getSource() == so_retailer){
					so_comment.setText("");
					String name=so_retailer.getSelectedItem().toString();
					CustomerController cc=new CustomerController(operator);
				    CustomerVO c=cc.queryCustomerByName(name);
				    so_salesman.setText(c.getDefaultname());
				    PromotionController pc=new PromotionController(operator);
				    LevelPromotionVO lp=pc.getpromotionByLevel(name);
				    if(lp!=null){
				       so_discount.setText(String.valueOf(lp.getZherang()));
				       so_voucher.setText(String.valueOf(lp.getVoucher()));
				       String present="";
				       GoodsController gc=new GoodsController(operator);
				       for(int i=0;i<lp.getEverylist().size();i++){
				    	   present=present+gc.queryGoodsByNumebr(lp.getEverylist().get(i).getGoodsnumber()).getName()+" "+lp.getEverylist().get(i).getNumber()+" ";	      
				       }
				      so_comment.setText(present);
				       }
				    else
				    {
				    	so_discount.setText("1");
				    	so_voucher.setText("0");
				    }
				    
				}
				else if(e.getSource() == sbo_retailer){
					String name=sbo_retailer.getSelectedItem().toString();
					CustomerController cc=new CustomerController(operator);
				    CustomerVO c=cc.queryCustomerByName(name);
				    sbo_salesman.setText(c.getDefaultname());
				    
				}
			}
		}
		 
	 }
	 
	 class boxActionListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==search_box){
			    if(search_box.getSelectedItem().toString()=="����"){
				   search_customer.setVisible(false);
				   classificationbox.setVisible(false);
				   levelbox.setVisible(true);
			   }
			   else if(search_box.getSelectedItem().toString()=="����"){
				   search_customer.setVisible(false);
				   levelbox.setVisible(false);
				   classificationbox.setVisible(true);
			   }
			   else if(search_box.getSelectedItem().toString()=="���"){
				   levelbox.setVisible(false);
				   classificationbox.setVisible(false);
				   search_customer.setVisible(true);
			   }
			}
			
		}
		 
		 
	 }
}