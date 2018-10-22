package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import controller.CheckPurchaseController;
import controller.CheckReceiptController;
import controller.OrderController;
import ui.Finacialmanui.Mytable1;
import ui.SalesOrderFrame.ButtonActionListener;
import vo.GoodsListVO;
import vo.PurchaseOrderVO;
import vo.ReceiptBackVO;
import vo.TransferAccountVO;

public class ReceiptBackFrame {
	private JFrame frame;
	private JTextField po_number;//���ݱ��
	private JTextField po_supplier;//��Ӧ��
	private JTextField po_retalier;//������
	private JTextField po_operator;//����Ա
	private Mytable model;
	private JTable po_table;//ת���б�
	private JTextField po_addUp;//�ܶ�
	private JButton po_confirm;
	private JButton po_cancel;
	
	
	
	ReceiptBackFrame(String orderID,String operator,int state){
		Font font0 = new Font("Default",Font.BOLD,25);
		Font font = new Font("Default",Font.BOLD,20);
		frame = new JFrame("���");
		frame.setLayout(null);
		frame.setLocation(800,200);
		frame.setSize(500,660);
		frame.setFont(font0);
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
		po_number = new JTextField();
		po_number.setLocation(150,10);
	    po_number.setSize(250,40);
	    po_number.setBackground(Color.white);
	    po_number.setFont(font);
	    po_number.setEditable(false);
	    frame.getContentPane().add(po_number);
	    //��Ӧ��
	    JLabel supplier_label = new JLabel("��Ӧ��");
	    supplier_label.setLocation(20,60);
	    supplier_label.setSize(120,40);
	    supplier_label.setFont(font0);
		frame.getContentPane().add(supplier_label);
		po_supplier = new JTextField();
		po_supplier.setLocation(150,60);
	    po_supplier.setSize(250,40);
	    po_supplier.setBackground(Color.white);
	    po_supplier.setFont(font);
	    po_supplier.setEditable(false);
	    frame.getContentPane().add(po_supplier);
	    //������
	    JLabel retalier_label = new JLabel("������");
	    retalier_label.setLocation(20,110);
	    retalier_label.setSize(120,40);
	    retalier_label.setFont(font0);
		frame.getContentPane().add(retalier_label);
		po_retalier = new JTextField();
		po_retalier.setLocation(150,110);
	    po_retalier.setSize(250,40);
	    po_retalier.setBackground(Color.white);
	    po_retalier.setFont(font);
	    po_retalier.setEditable(false);
	    frame.getContentPane().add(po_retalier);
	    //����Ա
	    JLabel operator_label = new JLabel("����Ա");
	    operator_label.setLocation(20,160);
	    operator_label.setSize(120,40);
	    operator_label.setFont(font0);
		frame.getContentPane().add(operator_label);
		po_operator = new JTextField();
		po_operator.setLocation(150,160);
	    po_operator.setSize(250,40);
	    po_operator.setBackground(Color.white);
	    po_operator.setFont(font);
	    po_operator.setEditable(false);
	    frame.getContentPane().add(po_operator);
	    //ת���б�
	    JLabel transferAccount = new JLabel("ת���б�");
	    transferAccount.setLocation(190,210);
	    transferAccount.setSize(150,30);
	    transferAccount.setFont(font0);
	    transferAccount.setForeground(Color.red);
	    frame.getContentPane().add(transferAccount);
	    model = new Mytable();
	    po_table = new JTable(model);
	    po_table.getTableHeader().setReorderingAllowed(false);
	    po_table.setBackground(Color.cyan);
	    po_table.setSelectionBackground(Color.pink);
	    po_table.getTableHeader().setFont(font0);
	    po_table.getTableHeader().setForeground(Color.red);
	    po_table.setRowHeight(33);
	    po_table.setFont(font);
	    po_table.getColumnModel().getColumn(2).setPreferredWidth(200);
		JScrollPane scrollPane = new JScrollPane(po_table);
		scrollPane.getViewport().setBackground(Color.cyan);
		scrollPane.setLocation(0,250);
		scrollPane.setSize(500,300);
		frame.add(scrollPane);
		//�ϼ�
		JLabel addUp_label = new JLabel("�ϼ�");
		addUp_label.setLocation(20,565);
		addUp_label.setSize(80,40);
		addUp_label.setFont(font);
		frame.getContentPane().add(addUp_label);
		po_addUp = new JTextField();
		po_addUp.setLocation(80,565);
	    po_addUp.setSize(120,40);
	    po_addUp.setBackground(Color.white);
	    po_addUp.setFont(font);
	    po_addUp.setEditable(false);
	    frame.getContentPane().add(po_addUp);
	    /*
	     * button�ؼ�
	     */
	     //ȷ��
	  	po_confirm = new JButton("ȷ��");
	  	po_confirm.addActionListener(new ButtonActionListener());
  		po_confirm.setLocation(370,560);
  		po_confirm.setSize(100,50);
  		po_confirm.setFont(font0);
  		po_confirm.setForeground(Color.red);
  		po_confirm.setFocusPainted(false);
  		frame.add(po_confirm);
  		//ȡ��
  		po_cancel = new JButton("ȡ��");
  		po_cancel.addActionListener(new ButtonActionListener());
  		po_cancel.setLocation(230,560);
  		po_cancel.setSize(100,50);
  		po_cancel.setFont(font0);
  		po_cancel.setForeground(Color.red);
  		po_cancel.setFocusPainted(false);
  		frame.add(po_cancel);
  		CheckReceiptController cpc = new CheckReceiptController(operator);
	    ReceiptBackVO vo =  cpc.queryReceiptBackByNumber(orderID);
	    po_number.setText(orderID);
	    po_supplier.setText(vo.getProvider());
	    po_retalier.setText(vo.getSalesperson());
	    po_operator.setText(vo.getOperator());
	    po_addUp.setText(String.valueOf(vo.getTotal()));
	    //���ñ����Ϣ
	    List<TransferAccountVO> list = vo.getList();
	    Object[][]  data = new Object[list.size()][3];
	    for(int i=0;i<list.size();i++){
	    	data[i][0] = list.get(i).getBankaccount();
	    	data[i][1] = list.get(i).getMoney();
	    	data[i][2] = list.get(i).getComment();
	    	
	    }
	    model.setData(data);
	    /*
	     * ��岢����
	     */
	    if(state == 1){
	    	OrderController oc = new OrderController(operator);
	    	po_number.setText(oc.getReceiptBackNumber());
	    	po_number.setEditable(false);
	    	po_supplier.setEditable(true);
	    	po_retalier.setEditable(true);
	    	po_operator.setEditable(true);
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
		String[] columnNames = {"�����˻�","ת�˽��","��ע"};
		Object[][] celldata = {{"","",""}};
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
			if(columnIndex==2){
				   return true;
			}else{
				return false;
			}
		}
	}
}