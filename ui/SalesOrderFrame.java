package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import controller.CheckSalesController;
import controller.OrderController;
import vo.GoodsListVO;
import vo.SalesBackOrderVO;
import vo.SalesOrderVO;

public class SalesOrderFrame {
	private JFrame frame;
	private JTextField so_number;//���ݱ��
	private JTextField so_customer;//�ͻ�
	private JTextField so_operator;//����Ա
	private JTextField so_salesman;//ҵ��Ա
	private JTextField so_stock;//�ֿ�
	private JTextField so_comment;//��ע
	private Mytable model;//
	private JTable so_table;//������Ʒ��
	private JTextField so_beforeDiscount;//����ǰ�ܶ�
	private JTextField so_discount;//����
	private JTextField so_voucher;//����ȯ
	private JTextField so_afterDiscount;//���ú��ܶ�
	private JButton so_confirm;
	private JButton so_cancel;
	
	SalesOrderFrame(String orderID,String operator,int state){
		Font font0 = new Font("Default",Font.BOLD,25);
		Font font = new Font("Default",Font.BOLD,20);
	    frame = new JFrame("���۵�");
	    frame.setLayout(null);
	    frame.setLocation(800,170);
	    frame.setSize(500,750);
	    frame.setFont(font);
	    frame.setResizable(false);
	    frame.getContentPane().setBackground(Color.cyan);
	    /*
	     * ����Ϣ��ʾ
	     */
	    //���ݱ��
	    JLabel number_label = new JLabel("���ݱ��");
	    number_label.setLocation(20,10);
	    number_label.setSize(120,40);
	    number_label.setFont(font0);
	    frame.getContentPane().add(number_label);
	    so_number = new JTextField();
	    so_number.setLocation(150,10);
	    so_number.setSize(250,40);
	    so_number.setBackground(Color.white);
	    so_number.setFont(font);
	    so_number.setEditable(false);
	    frame.getContentPane().add(so_number);
	    //�ͻ�
	    JLabel customer_label = new JLabel("�ͻ�");
	    customer_label.setLocation(40,60);
	    customer_label.setSize(60,40);
	    customer_label.setFont(font0);
	    frame.getContentPane().add(customer_label);
	    so_customer = new JTextField();
	    so_customer.setLocation(100,60);
	    so_customer.setSize(120,40);
	    so_customer.setBackground(Color.white);
	    so_customer.setFont(font);
	    so_customer.setEditable(false);
	    frame.getContentPane().add(so_customer);
	    //ҵ��Ա
	    JLabel salesman_label = new JLabel("ҵ��Ա");
	    salesman_label.setLocation(240,60);
	    salesman_label.setSize(100,40);
	    salesman_label.setFont(font0);
	    frame.getContentPane().add(salesman_label);
	    so_salesman = new JTextField();
	    so_salesman.setLocation(330,60);
	    so_salesman.setSize(120,40);
	    so_salesman.setBackground(Color.white);
	    so_salesman.setFont(font);
	    so_salesman.setEditable(false);
	    frame.getContentPane().add(so_salesman);
	    //����Ա
	    JLabel operator_label = new JLabel("����Ա");
	    operator_label.setLocation(10,110);
	    operator_label.setSize(100,40);
	    operator_label.setFont(font0);
	    frame.getContentPane().add(operator_label);
	    so_operator = new JTextField();
	    so_operator.setLocation(100,110);
	    so_operator.setSize(120,40);
	    so_operator.setBackground(Color.white);
	    so_operator.setFont(font);
	    so_operator.setEditable(false);
	    frame.getContentPane().add(so_operator);
	    //�ֿ�
	    JLabel stock_label = new JLabel("�ֿ�");
	    stock_label.setLocation(260,110);
	    stock_label.setSize(100,40);
	    stock_label.setFont(font0);
	    frame.getContentPane().add(stock_label);
	    so_stock = new JTextField();
	    so_stock.setLocation(330,110);
	    so_stock.setSize(120,40);
	    so_stock.setBackground(Color.white);
	    so_stock.setFont(font);
	    so_stock.setEditable(false);
	    frame.getContentPane().add(so_stock);
	    //��ע
	    JLabel comment_label = new JLabel("��ע");
	    comment_label.setLocation(50,160);
	    comment_label.setSize(120,40);
	    comment_label.setFont(font0);
	    frame.getContentPane().add(comment_label);
	    so_comment = new JTextField();
	    so_comment.setLocation(150,160);
	    so_comment.setSize(250,40);
	    so_comment.setBackground(Color.white);
	    so_comment.setFont(font);
	    so_comment.setEditable(true);
	    frame.getContentPane().add(so_comment);
	    //������Ʒ�嵥
	    JLabel goods_label = new JLabel("������Ʒ�嵥");
	    goods_label.setLocation(160,200);
	    goods_label.setSize(200,40);
	    goods_label.setFont(font0);
	    goods_label.setForeground(Color.red);
	    frame.getContentPane().add(goods_label);
	    model = new Mytable();
	    so_table = new JTable(model);
	    so_table.getTableHeader().setReorderingAllowed(false);
	    so_table.setFont(font);
	    so_table.setBackground(Color.cyan);
	    so_table.setSelectionBackground(Color.pink);
	    so_table.getTableHeader().setFont(font0);
	    so_table.getTableHeader().setForeground(Color.red);
	    so_table.setRowHeight(33);
	    JScrollPane scrollPane = new JScrollPane(so_table);
	    scrollPane.setSize(500,300);
	    scrollPane.setLocation(0,240);
	    scrollPane.getViewport().setBackground(Color.cyan);
		frame.add(scrollPane);
		//����ǰ�ܶ�
		JLabel beforeDiscount_label = new JLabel("����ǰ�ܶ�");
		beforeDiscount_label.setLocation(10,555);
		beforeDiscount_label.setSize(120,30);
		beforeDiscount_label.setFont(font);
	    frame.getContentPane().add(beforeDiscount_label);
	    so_beforeDiscount = new JTextField();
	    so_beforeDiscount.setLocation(130,550);
	    so_beforeDiscount.setSize(130,40);
	    so_beforeDiscount.setBackground(Color.white);
	    so_beforeDiscount.setFont(font);
	    so_beforeDiscount.setEditable(false);
	    frame.getContentPane().add(so_beforeDiscount);
	    //����
	  	JLabel discount_label = new JLabel("����");
	  	discount_label.setLocation(280,555);
	  	discount_label.setSize(120,30);
	  	discount_label.setFont(font);
	  	frame.getContentPane().add(discount_label);
	  	so_discount = new JTextField();
	  	so_discount.setLocation(330,550);
	  	so_discount.setSize(130,40);
	  	so_discount.setBackground(Color.white);
	  	so_discount.setFont(font);
	  	so_discount.setEditable(false);
	  	frame.getContentPane().add(so_discount);
	    //����ȯ
	  	JLabel voucher_label = new JLabel("����ȯ");
	  	voucher_label.setLocation(10,605);
	  	voucher_label.setSize(120,30);
	  	voucher_label.setFont(font);
	  	frame.getContentPane().add(voucher_label);
	  	so_voucher = new JTextField();
	  	so_voucher.setLocation(80,600);
	  	so_voucher.setSize(130,40);
	  	so_voucher.setBackground(Color.white);
	  	so_voucher.setFont(font);
	  	so_voucher.setEditable(false);
  	    frame.getContentPane().add(so_voucher);
  	    //���ú��ܶ�
  	  	JLabel afterDiscount_label = new JLabel("���ú��ܶ�");
  	    afterDiscount_label.setLocation(220,605);
  	    afterDiscount_label.setSize(120,30);
  	    afterDiscount_label.setFont(font);
  	  	frame.getContentPane().add(afterDiscount_label);
  	  	so_afterDiscount = new JTextField();
  	  	so_afterDiscount.setLocation(330,600);
  	  	so_afterDiscount.setSize(130,40);
  	  	so_afterDiscount.setBackground(Color.white);
  	  	so_afterDiscount.setFont(font);
  	  	so_afterDiscount.setEditable(false);
  	  	frame.getContentPane().add(so_afterDiscount);
		/*
		 * button�ؼ�
		 */
		//ȷ��
		so_confirm = new JButton("ȷ��");
		so_confirm.addActionListener(new ButtonActionListener());
		so_confirm.setLocation(350,650);
		so_confirm.setSize(100,50);
		so_confirm.setFont(font0);
		so_confirm.setForeground(Color.red);
		so_confirm.setFocusPainted(false);
		frame.add(so_confirm);
		//ȡ��
		so_cancel = new JButton("ȡ��");
		so_cancel.addActionListener(new ButtonActionListener());
		so_cancel.setLocation(50,650);
		so_cancel.setSize(100,50);
		so_cancel.setFont(font0);
		so_cancel.setForeground(Color.red);
		so_cancel.setFocusPainted(false);
		frame.add(so_cancel);
		CheckSalesController cpc = new CheckSalesController(operator);
	    SalesOrderVO vo =  cpc.querySalesByNumber(orderID);
	    so_number.setText(orderID);
	    so_customer.setText(vo.getSalesperson());
	    so_operator.setText(vo.getOperator());
	    so_salesman.setText(vo.getDefaultname());
	    so_stock.setText(vo.getWarehouse());
	    so_beforeDiscount.setText(String.valueOf(vo.getTotal()));
	    so_discount.setText(String.valueOf(vo.getDiscount()));
	    so_voucher.setText(String.valueOf(vo.getVoucher()));
	    so_afterDiscount.setText(String.valueOf(vo.getLasttotal()));
	    //���ñ����Ϣ
	    List<GoodsListVO> list = vo.getList();
	    Object[][]  data = new Object[list.size()][7];
	    for(int i=0;i<list.size();i++){
	    	data[i][0] = list.get(i).getGoodsnumber();
	    	data[i][1] = list.get(i).getGoodsname();
	    	data[i][2] = list.get(i).getType();
	    	data[i][3] = list.get(i).getNumber();
	    	data[i][4] = list.get(i).getPrice();
	    	data[i][5] = list.get(i).getTotal();
	    	data[i][6] = list.get(i).getComment();
	    	
	    }
	    model.setData(data);
	    /*
	     * ��岢����
	     */
	    if(state == 1){
	    	OrderController oc = new OrderController(operator);
	    	so_number.setText(oc.getSalesOrderNumber());
	    	so_number.setEditable(false);
	    	so_customer.setEditable(true);
	    	so_operator.setEditable(true);
	    	so_salesman.setEditable(true);
	    	so_stock.setEditable(true);
	    	so_comment.setEditable(true);
	    	so_beforeDiscount.setEditable(true);
	    	so_discount.setEditable(true);
	    	so_voucher.setEditable(true);
	    	so_afterDiscount.setEditable(true);
	    }
		frame.setVisible(true);
	    
	}
	
	class ButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == so_cancel){
				frame.dispose();
			}
			else if(e.getSource() == so_confirm){
				frame.dispose();
			}
		}
		
	}
	
	class Mytable extends AbstractTableModel{
		String[] columnNames = {"���","����","�ͺ�","����","����","���","��ע"};
		Object[][] celldata = {{"","","","","","",""}};
		//���ñ������
		public void setData(Object[][] data){
			celldata = data;
			fireTableDataChanged();
		}
		
		//����ÿһ�е�����
		@Override
		public Class getColumnClass(int columnIndex) {
			return Object.class;
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
			if(columnIndex==3 || columnIndex==4 || columnIndex==6){
				   return true;
			}else{
				return false;
			}
		}
	}
	
}