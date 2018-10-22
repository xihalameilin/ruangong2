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

import controller.CheckPurchaseController;
import controller.OrderController;
import ui.SalesOrderFrame.ButtonActionListener;
import ui.SalesOrderFrame.Mytable;
import vo.GoodsListVO;
import vo.PurchaseBackOrderVO;
import vo.PurchaseOrderVO;

public class PurchaseBackOrderFrame {
	private JFrame frame;
	private JTextField pbo_number;//���ݱ��
	private JTextField pbo_supplier;//��Ӧ��
	private JTextField pbo_stock;//�ֿ�
	private JTextField pbo_operator;//����Ա
	private JTextField pbo_comment;//��ע
	private Mytable model;
	private JTable pbo_table;//�����Ʒ��
	private JTextField pbo_addUp;//�ϼ�
	private JButton pbo_cancel;
	private JButton pbo_confirm;
	
	public static void main(String[] args){
		PurchaseBackOrderFrame frame = new PurchaseBackOrderFrame("","",0);
	}
	
	PurchaseBackOrderFrame(String orderID,String operator,int state){
		Font font = new Font("Default",Font.BOLD,25);
		Font font0 = new Font("Default",Font.BOLD,20);
	    frame = new JFrame("�����˻���");
	    frame.setLayout(null);
	    frame.setLocation(800,200);
	    frame.setSize(500,700);
	    frame.setFont(font);
	    frame.setResizable(false);
	    frame.getContentPane().setBackground(Color.cyan);
	    /*
	     * ����Ϣ��ʾ
	     */
	    //���ݱ��
	    JLabel number_label = new JLabel("���ݱ��");
	    number_label.setLocation(20,20);
	    number_label.setSize(120,40);
	    number_label.setFont(font);
	    frame.getContentPane().add(number_label);
	    pbo_number = new JTextField();
	    pbo_number.setLocation(160,20);
	    pbo_number.setSize(250,40);
	    pbo_number.setFont(font);
	    pbo_number.setBackground(Color.white);
	    pbo_number.setEditable(false);
	    frame.getContentPane().add(pbo_number);
	    //��Ӧ��
	    JLabel supplier_label = new JLabel("��Ӧ��");
	    supplier_label.setLocation(20,70);
	    supplier_label.setSize(120,40);
	    supplier_label.setFont(font);
	    frame.getContentPane().add(supplier_label);
	    pbo_supplier = new JTextField();
	    pbo_supplier.setLocation(160,70);
	    pbo_supplier.setSize(250,40);
	    pbo_supplier.setFont(font);
	    pbo_supplier.setBackground(Color.white);
	    pbo_supplier.setEditable(false);
	    frame.getContentPane().add(pbo_supplier);
	    //�ֿ�
	    JLabel stock_label = new JLabel("�ֿ�");
	    stock_label.setLocation(20,120);
	    stock_label.setSize(120,40);
	    stock_label.setFont(font);
	    frame.getContentPane().add(stock_label);
	    pbo_stock = new JTextField();
	    pbo_stock.setLocation(160,120);
	    pbo_stock.setSize(250,40);
	    pbo_stock.setFont(font);
	    pbo_stock.setBackground(Color.white);
	    pbo_stock.setEditable(false);
	    frame.getContentPane().add(pbo_stock);
	    //����Ա
	    JLabel operator_label = new JLabel("����Ա");
	    operator_label.setLocation(20,170);
	    operator_label.setSize(120,40);
	    operator_label.setFont(font);
	    frame.getContentPane().add(operator_label);
	    pbo_operator = new JTextField();
	    pbo_operator.setLocation(160,170);
	    pbo_operator.setSize(250,40);
	    pbo_operator.setFont(font);
	    pbo_operator.setBackground(Color.white);
	    pbo_operator.setEditable(false);
	    frame.getContentPane().add(pbo_operator);
	    //��ע
	    JLabel comment_label = new JLabel("��ע");
	    comment_label.setLocation(20,220);
	    comment_label.setSize(120,40);
	    comment_label.setFont(font);
	    frame.getContentPane().add(comment_label);
	    pbo_comment = new JTextField();
	    pbo_comment.setLocation(160,220);
	    pbo_comment.setSize(250,40);
	    pbo_comment.setFont(font);
	    pbo_comment.setBackground(Color.white);
	    pbo_comment.setEditable(true);
	    frame.getContentPane().add(pbo_comment);
	    //�����Ʒ�б�
	    JLabel goods_label = new JLabel("�����Ʒ�б�");
	    goods_label.setLocation(160,265);
	    goods_label.setSize(200,30);
	    goods_label.setFont(font);
	    goods_label.setForeground(Color.red);
	    frame.getContentPane().add(goods_label);
	    model = new Mytable();
	    pbo_table = new JTable(model);
	    pbo_table.getTableHeader().setReorderingAllowed(false);
	    pbo_table.setFont(font0);
	    pbo_table.setBackground(Color.cyan);
	    pbo_table.setSelectionBackground(Color.pink);
	    pbo_table.getTableHeader().setFont(font);
	    pbo_table.getTableHeader().setForeground(Color.red);
	    pbo_table.setRowHeight(33);
	    JScrollPane scrollPane = new JScrollPane(pbo_table);
	    scrollPane.setSize(500,280);
	    scrollPane.setLocation(0,300);
	    scrollPane.getViewport().setBackground(Color.cyan);
		frame.add(scrollPane);
	    //�ϼ�
		JLabel addUp_label = new JLabel("�ϼ�");
		addUp_label.setLocation(10,605);
		addUp_label.setSize(200,30);
		addUp_label.setFont(font);
		frame.getContentPane().add(addUp_label);
		pbo_addUp = new JTextField();
		pbo_addUp.setLocation(60,600);
	    pbo_addUp.setSize(120,40);
	    pbo_addUp.setFont(font);
	    pbo_addUp.setBackground(Color.white);
	    pbo_addUp.setEditable(false);
	    frame.getContentPane().add(pbo_addUp);
	    /*
	     * button�ؼ�
	     */
	    //ȷ��
	  	pbo_confirm = new JButton("ȷ��");
	  	pbo_confirm.addActionListener(new ButtonActionListener());
	  	pbo_confirm.setLocation(350,595);
	  	pbo_confirm.setSize(100,50);
  		pbo_confirm.setFont(font0);
  		pbo_confirm.setForeground(Color.red);
  		pbo_confirm.setFocusPainted(false);
  		frame.add(pbo_confirm);
  		//ȡ��
  		pbo_cancel = new JButton("ȡ��");
  		pbo_cancel.addActionListener(new ButtonActionListener());
  		pbo_cancel.setLocation(210,595);
  		pbo_cancel.setSize(100,50);
  		pbo_cancel.setFont(font0);
  		pbo_cancel.setForeground(Color.red);
  		pbo_cancel.setFocusPainted(false);
  		frame.add(pbo_cancel);
  		 /*
	     * ���ñ����Ϣ
	     */
  		CheckPurchaseController cpc = new CheckPurchaseController(operator);
	    PurchaseBackOrderVO vo =  cpc.queryPurchaseBackByNumber(orderID);
	    pbo_number.setText(orderID);
	    pbo_supplier.setText(vo.getProvider());
	    pbo_stock.setText(vo.getWarehouse());
	    pbo_operator.setText(vo.getOperator());
	    pbo_comment.setText(vo.getComment());
	    pbo_addUp.setText(String.valueOf(vo.getTotal()));
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
	     * �����Ƿ�ɱ༭
	     */
	    //��岢����
	    if(state == 1){
	    	OrderController oc = new OrderController(operator);
	    	pbo_number.setText(oc.getPurchaseBackOrderNumber());
	    	pbo_number.setEditable(false);
	    	pbo_supplier.setEditable(true);
	    	pbo_stock.setEditable(true);
	    	pbo_operator.setEditable(true);
	    	pbo_comment.setEditable(true);
	    	pbo_addUp.setEditable(true);
	    	
	    }
	    frame.setVisible(true);
	}
	
	class ButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == pbo_cancel){
				frame.dispose();
			}
			else if(e.getSource() == pbo_confirm){
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