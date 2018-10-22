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
import vo.PurchaseOrderVO;

public class PurchaseOrderFrame {
	private JFrame frame;
	private JTextField po_number;//���ݱ��
	private JTextField po_supplier;//��Ӧ��
	private JTextField po_stock;//�ֿ�
	private JTextField po_operator;//����Ա
	private JTextField po_comment;//��ע
	private Mytable model;
	private JTable po_table;//�����Ʒ��
	private JTextField po_addUp;//�ϼ�
	private JButton po_cancel;
	private JButton po_confirm;
	
	
	PurchaseOrderFrame(String orderID,String operator,int state){
		Font font = new Font("Default",Font.BOLD,25);
		Font font0 = new Font("Default",Font.BOLD,20);
	    frame = new JFrame("������");
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
	    po_number = new JTextField();
	    po_number.setLocation(160,20);
	    po_number.setSize(250,40);
	    po_number.setFont(font);
	    po_number.setBackground(Color.white);
	    po_number.setEditable(false);
	    frame.getContentPane().add(po_number);
	    //��Ӧ��
	    JLabel supplier_label = new JLabel("��Ӧ��");
	    supplier_label.setLocation(20,70);
	    supplier_label.setSize(120,40);
	    supplier_label.setFont(font);
	    frame.getContentPane().add(supplier_label);
	    po_supplier = new JTextField();
	    po_supplier.setLocation(160,70);
	    po_supplier.setSize(250,40);
	    po_supplier.setFont(font);
	    po_supplier.setBackground(Color.white);
	    po_supplier.setEditable(false);
	    frame.getContentPane().add(po_supplier);
	    //�ֿ�
	    JLabel stock_label = new JLabel("�ֿ�");
	    stock_label.setLocation(20,120);
	    stock_label.setSize(120,40);
	    stock_label.setFont(font);
	    frame.getContentPane().add(stock_label);
	    po_stock = new JTextField();
	    po_stock.setLocation(160,120);
	    po_stock.setSize(250,40);
	    po_stock.setFont(font);
	    po_stock.setBackground(Color.white);
	    po_stock.setEditable(false);
	    frame.getContentPane().add(po_stock);
	    //����Ա
	    JLabel operator_label = new JLabel("����Ա");
	    operator_label.setLocation(20,170);
	    operator_label.setSize(120,40);
	    operator_label.setFont(font);
	    frame.getContentPane().add(operator_label);
	    po_operator = new JTextField();
	    po_operator.setLocation(160,170);
	    po_operator.setSize(250,40);
	    po_operator.setFont(font);
	    po_operator.setBackground(Color.white);
	    po_operator.setEditable(false);
	    frame.getContentPane().add(po_operator);
	    //��ע
	    JLabel comment_label = new JLabel("��ע");
	    comment_label.setLocation(20,220);
	    comment_label.setSize(120,40);
	    comment_label.setFont(font);
	    frame.getContentPane().add(comment_label);
	    po_comment = new JTextField();
	    po_comment.setLocation(160,220);
	    po_comment.setSize(250,40);
	    po_comment.setFont(font);
	    po_comment.setBackground(Color.white);
	    po_comment.setEditable(true);
	    frame.getContentPane().add(po_comment);
	    //�����Ʒ�б�
	    JLabel goods_label = new JLabel("�����Ʒ�б�");
	    goods_label.setLocation(160,265);
	    goods_label.setSize(200,30);
	    goods_label.setFont(font);
	    goods_label.setForeground(Color.red);
	    frame.getContentPane().add(goods_label);
	    model = new Mytable();
	    po_table = new JTable(model);
	    po_table.getTableHeader().setReorderingAllowed(false);
	    po_table.setFont(font0);
	    po_table.setBackground(Color.cyan);
	    po_table.setSelectionBackground(Color.pink);
	    po_table.getTableHeader().setFont(font);
	    po_table.getTableHeader().setForeground(Color.red);
	    po_table.setRowHeight(33);
	    JScrollPane scrollPane = new JScrollPane(po_table);
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
		po_addUp = new JTextField();
		po_addUp.setLocation(60,600);
	    po_addUp.setSize(120,40);
	    po_addUp.setFont(font);
	    po_addUp.setBackground(Color.white);
	    po_addUp.setEditable(false);
	    frame.getContentPane().add(po_addUp);
	    /*
	     * button�ؼ�
	     */
	    //ȷ��
	  	po_confirm = new JButton("ȷ��");
	  	po_confirm.addActionListener(new ButtonActionListener());
	  	po_confirm.setLocation(350,595);
	  	po_confirm.setSize(100,50);
  		po_confirm.setFont(font0);
  		po_confirm.setForeground(Color.red);
  		po_confirm.setFocusPainted(false);
  		frame.add(po_confirm);
  		//ȡ��
  		po_cancel = new JButton("ȡ��");
  		po_cancel.addActionListener(new ButtonActionListener());
  		po_cancel.setLocation(210,595);
  		po_cancel.setSize(100,50);
  		po_cancel.setFont(font0);
  		po_cancel.setForeground(Color.red);
  		po_cancel.setFocusPainted(false);
  		frame.add(po_cancel);
  		
  		/*
  		 * ������Ϣ
  		 */
  		CheckPurchaseController cpc = new CheckPurchaseController(operator);
	    PurchaseOrderVO vo =  cpc.queryPurchaseByNumber(orderID);
	    po_number.setText(orderID);
	    po_supplier.setText(vo.getProvider());
	    po_stock.setText(vo.getWarehouse());
	    po_operator.setText(vo.getOperator());
	    po_comment.setText(vo.getComment());
	    po_addUp.setText(String.valueOf(vo.getTotal()));
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
	    	po_number.setText(oc.getPurchaseOrderNumber());
	    	po_number.setEditable(false);
	    	po_supplier.setEditable(true);
	    	po_stock.setEditable(true);
	    	po_operator.setEditable(true);
	    	po_comment.setEditable(true);
	    	po_addUp.setEditable(true);
	    }
	    frame.setVisible(true);
	}
	
	class ButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == po_cancel){
				frame.dispose();
			}
			else if(e.getSource() == po_confirm){
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