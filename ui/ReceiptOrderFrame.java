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

import controller.CheckReceiptController;
import controller.OrderController;
import ui.Finacialmanui.Mytable1;
import ui.SalesOrderFrame.ButtonActionListener;
import vo.ReceiptBackVO;
import vo.ReceiptVO;
import vo.TransferAccountVO;

public class ReceiptOrderFrame {
	private JFrame frame;
	private JTextField ro_number;//���ݱ��
	private JTextField ro_supplier;//��Ӧ��
	private JTextField ro_retalier;//������
	private JTextField ro_operator;//����Ա
	private Mytable model;
	private JTable ro_table;//ת���б�
	private JTextField ro_addUp;//�ܶ�
	private JButton ro_confirm;
	private JButton ro_cancel;
	
	
	ReceiptOrderFrame(String orderID,String operator,int state){
		Font font0 = new Font("Default",Font.BOLD,25);
		Font font = new Font("Default",Font.BOLD,20);
		frame = new JFrame("�տ");
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
		ro_number = new JTextField();
		ro_number.setLocation(150,10);
	    ro_number.setSize(250,40);
	    ro_number.setBackground(Color.white);
	    ro_number.setFont(font);
	    ro_number.setEditable(false);
	    frame.getContentPane().add(ro_number);
	    //��Ӧ��
	    JLabel supplier_label = new JLabel("��Ӧ��");
	    supplier_label.setLocation(20,60);
	    supplier_label.setSize(120,40);
	    supplier_label.setFont(font0);
		frame.getContentPane().add(supplier_label);
		ro_supplier = new JTextField();
		ro_supplier.setLocation(150,60);
	    ro_supplier.setSize(250,40);
	    ro_supplier.setBackground(Color.white);
	    ro_supplier.setFont(font);
	    ro_supplier.setEditable(false);
	    frame.getContentPane().add(ro_supplier);
	    //������
	    JLabel retalier_label = new JLabel("������");
	    retalier_label.setLocation(20,110);
	    retalier_label.setSize(120,40);
	    retalier_label.setFont(font0);
		frame.getContentPane().add(retalier_label);
		ro_retalier = new JTextField();
		ro_retalier.setLocation(150,110);
	    ro_retalier.setSize(250,40);
	    ro_retalier.setBackground(Color.white);
	    ro_retalier.setFont(font);
	    ro_retalier.setEditable(false);
	    frame.getContentPane().add(ro_retalier);
	    //����Ա
	    JLabel operator_label = new JLabel("����Ա");
	    operator_label.setLocation(20,160);
	    operator_label.setSize(120,40);
	    operator_label.setFont(font0);
		frame.getContentPane().add(operator_label);
		ro_operator = new JTextField();
		ro_operator.setLocation(150,160);
	    ro_operator.setSize(250,40);
	    ro_operator.setBackground(Color.white);
	    ro_operator.setFont(font);
	    ro_operator.setEditable(false);
	    frame.getContentPane().add(ro_operator);
	    //ת���б�
	    JLabel transferAccount = new JLabel("ת���б�");
	    transferAccount.setLocation(190,210);
	    transferAccount.setSize(150,30);
	    transferAccount.setFont(font0);
	    transferAccount.setForeground(Color.red);
	    frame.getContentPane().add(transferAccount);
	    model = new Mytable();
	    ro_table = new JTable(model);
	    ro_table.getTableHeader().setReorderingAllowed(false);
	    ro_table.setBackground(Color.cyan);
	    ro_table.setSelectionBackground(Color.pink);
	    ro_table.getTableHeader().setFont(font0);
	    ro_table.getTableHeader().setForeground(Color.red);
	    ro_table.setRowHeight(33);
	    ro_table.setFont(font);
	    ro_table.getColumnModel().getColumn(2).setPreferredWidth(200);
		JScrollPane scrollPane = new JScrollPane(ro_table);
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
		ro_addUp = new JTextField();
		ro_addUp.setLocation(80,565);
	    ro_addUp.setSize(120,40);
	    ro_addUp.setBackground(Color.white);
	    ro_addUp.setFont(font);
	    ro_addUp.setEditable(false);
	    frame.getContentPane().add(ro_addUp);
	    /*
	     * button�ؼ�
	     */
	     //ȷ��
	  	ro_confirm = new JButton("ȷ��");
	  	ro_confirm.addActionListener(new ButtonActionListener());
  		ro_confirm.setLocation(370,560);
  		ro_confirm.setSize(100,50);
  		ro_confirm.setFont(font0);
  		ro_confirm.setForeground(Color.red);
  		ro_confirm.setFocusPainted(false);
  		frame.add(ro_confirm);
  		//ȡ��
  		ro_cancel = new JButton("ȡ��");
  		ro_cancel.addActionListener(new ButtonActionListener());
  		ro_cancel.setLocation(230,560);
  		ro_cancel.setSize(100,50);
  		ro_cancel.setFont(font0);
  		ro_cancel.setForeground(Color.red);
  		ro_cancel.setFocusPainted(false);
  		frame.add(ro_cancel);
  		CheckReceiptController cpc = new CheckReceiptController(operator);
	    ReceiptVO vo =  cpc.queryReceiptByNumber(orderID);
	    ro_number.setText(orderID);
	    ro_supplier.setText(vo.getProvider());
	    ro_retalier.setText(vo.getSalesperson());
	    ro_operator.setText(vo.getOperator());
	    ro_addUp.setText(String.valueOf(vo.getTotal()));
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
	    	ro_number.setText(oc.getReceiptBackNumber());
	    	ro_number.setEditable(false);
	    	ro_supplier.setEditable(true);
	    	ro_retalier.setEditable(true);
	    	ro_operator.setEditable(true);
	    	ro_addUp.setEditable(true);
	    }
  		frame.setVisible(true);
	    
		
	}
	
	class ButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == ro_cancel){
				frame.dispose();
			}
			else if(e.getSource() == ro_confirm){
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