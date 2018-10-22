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

import controller.CheckStockController;
import controller.GoodsController;
import ui.ReceiptBackFrame.ButtonActionListener;
import vo.GoodsListVO;
import vo.GoodsVO;
import vo.StockLossOrderVO;

public class StockLossFrame {
	private JFrame frame;
	private JTextField loss_number;//���ݱ��
	private JTextField loss_date;//����Ա
	private JTextField loss_comment;//��ע
	private Mytable model;
	private JTable loss_table;//��汨���
	private JButton loss_confirm;
	private JButton loss_cancel;
	
	StockLossFrame(String orderID,String operator,int state){
		Font font0 = new Font("Default",Font.BOLD,25);
		Font font = new Font("Default",Font.BOLD,20);
		frame = new JFrame("��汨��");
		frame.setLayout(null);
		frame.setLocation(800,200);
		frame.setSize(500,660);
		frame.setFont(font0);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.cyan);
		//���ݱ��
		JLabel number_label = new JLabel("���ݱ��");
		number_label.setLocation(20,20);
		number_label.setSize(120,40);
		number_label.setFont(font0);
		frame.getContentPane().add(number_label);
		loss_number = new JTextField();
		loss_number.setLocation(150,20);
		loss_number.setSize(250,40);
		loss_number.setBackground(Color.white);
		loss_number.setFont(font);
		loss_number.setEditable(false);
	    frame.getContentPane().add(loss_number);
	    //����Ա
	    JLabel operator_label = new JLabel("����");
	    operator_label.setLocation(20,80);
	    operator_label.setSize(120,40);
	    operator_label.setFont(font0);
		frame.getContentPane().add(operator_label);
		loss_date = new JTextField();
		loss_date.setLocation(150,80);
		loss_date.setSize(250,40);
		loss_date.setBackground(Color.white);
		loss_date.setFont(font);
		loss_date.setEditable(false);
	    frame.getContentPane().add(loss_date);
	    //��ע
	    JLabel comment_label = new JLabel("��ע");
	    comment_label.setLocation(20,140);
	    comment_label.setSize(120,40);
	    comment_label.setFont(font0);
		frame.getContentPane().add(comment_label);
		loss_comment = new JTextField();
		loss_comment.setLocation(150,140);
		loss_comment.setSize(250,40);
		loss_comment.setBackground(Color.white);
		loss_comment.setFont(font);
		loss_comment.setEditable(true);
	    frame.getContentPane().add(loss_comment);
	    //����嵥
	    JLabel stock_label = new JLabel("����嵥");
	    stock_label.setLocation(180,195);
	    stock_label.setSize(120,40);
	    stock_label.setFont(font0);
	    frame.getContentPane().add(stock_label);
	    model = new Mytable();
	    loss_table = new JTable(model);
	    loss_table.getTableHeader().setReorderingAllowed(false);
	    loss_table.setBackground(Color.cyan);
	    loss_table.setSelectionBackground(Color.pink);
	    loss_table.getTableHeader().setFont(font0);
	    loss_table.getTableHeader().setForeground(Color.red);
	    loss_table.setRowHeight(33);
	    loss_table.setFont(font);
	    loss_table.getColumnModel().getColumn(3).setPreferredWidth(120);
	    loss_table.getColumnModel().getColumn(4).setPreferredWidth(120);
		JScrollPane scrollPane = new JScrollPane(loss_table);
		scrollPane.getViewport().setBackground(Color.cyan);
		scrollPane.setLocation(0,250);
		scrollPane.setSize(500,300);
		frame.add(scrollPane);
		/*
	     * button�ؼ�
	     */
	     //ȷ��
		loss_confirm = new JButton("ȷ��");
		loss_confirm.addActionListener(new ButtonActionListener());
		loss_confirm.setLocation(350,560);
		loss_confirm.setSize(100,50);
		loss_confirm.setFont(font0);
		loss_confirm.setForeground(Color.red);
		loss_confirm.setFocusPainted(false);
  		frame.add(loss_confirm);
  		//ȡ��
  		loss_cancel = new JButton("ȡ��");
  		loss_cancel.addActionListener(new ButtonActionListener());
  		loss_cancel.setLocation(50,560);
  		loss_cancel.setSize(100,50);
  		loss_cancel.setFont(font0);
  		loss_cancel.setForeground(Color.red);
  		loss_cancel.setFocusPainted(false);
  		frame.add(loss_cancel);
  		
  		CheckStockController cpc = new CheckStockController(operator);
	    StockLossOrderVO vo =  cpc.queryStockLossOrderByNumber(orderID);
	    loss_number.setText(orderID);
	    loss_date.setText(vo.getDate());
	    Object[][]  data = new Object[1][5];
	    GoodsController gc=new GoodsController(operator); 
	    List<GoodsVO> goods=gc.queryGoodsByName(vo.getName());
	    data[0][0] = goods.get(0).getNumber();
	    data[0][1] = goods.get(0).getName();
	    data[0][2] = goods.get(0).getType();
	    data[0][3] = vo.getStocknumber();
	    data[0][4] = vo.getActualnumber();        
	    model.setData(data);
		frame.setVisible(true);
	}
	
	class ButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == loss_cancel){
				frame.dispose();
			}
			else if(e.getSource() == loss_confirm){
				frame.dispose();
			}
		}
		
	}
	
	class Mytable extends AbstractTableModel{
		String[] columnNames = {"���","����","�ͺ�","�������","ʵ������"};
		Object[][] celldata = {{"","","","","",""}};
		
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
			return false;
		}
	}
}