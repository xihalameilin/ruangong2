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
import controller.CheckStockController;
import controller.GoodsController;
import controller.OrderController;
import ui.StockLossFrame.ButtonActionListener;
import vo.GoodsListVO;
import vo.GoodsVO;
import vo.SalesBackOrderVO;
import vo.StockGrantOrderVO;

public class StockGrantFrame {
	private JFrame frame;
	private JTextField grant_number;//单据编号
	private JTextField grant_date;//操作员
	private JTextField grant_comment;//备注
	private Mytable model;
	private JTable grant_table;
	private JButton grant_confirm;
	private JButton grant_cancel;
	
	
	StockGrantFrame(String orderID,String operator,int state){
		Font font0 = new Font("Default",Font.BOLD,25);
		Font font = new Font("Default",Font.BOLD,20);
		frame = new JFrame("库存赠送单");
		frame.setLayout(null);
		frame.setLocation(800,200);
		frame.setSize(500,640);
		frame.setFont(font0);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.cyan);
		//单据编号
		JLabel number_label = new JLabel("单据编号");
		number_label.setLocation(20,20);
		number_label.setSize(120,40);
		number_label.setFont(font0);
		frame.getContentPane().add(number_label);
		grant_number = new JTextField();
		grant_number.setLocation(150,20);
		grant_number.setSize(250,40);
		grant_number.setBackground(Color.white);
		grant_number.setFont(font);
		grant_number.setEditable(false);
	    frame.getContentPane().add(grant_number);
	    //操作员
	    JLabel operator_label = new JLabel("日期");
	    operator_label.setLocation(20,80);
	    operator_label.setSize(120,40);
	    operator_label.setFont(font0);
		frame.getContentPane().add(operator_label);
		grant_date = new JTextField();
		grant_date.setLocation(150,80);
		grant_date.setSize(250,40);
		grant_date.setBackground(Color.white);
		grant_date.setFont(font);
		grant_date.setEditable(false);
	    frame.getContentPane().add(grant_date);
	    //备注
	    JLabel comment_label = new JLabel("备注");
	    comment_label.setLocation(20,140);
	    comment_label.setSize(120,40);
	    comment_label.setFont(font0);
		frame.getContentPane().add(comment_label);
		grant_comment = new JTextField();
		grant_comment.setLocation(150,140);
		grant_comment.setSize(250,40);
		grant_comment.setBackground(Color.white);
		grant_comment.setFont(font);
		grant_comment.setEditable(true);
	    frame.getContentPane().add(grant_comment);
	    //赠品列表
	    JLabel grant_label = new JLabel("赠品列表");
	    grant_label.setLocation(190,180);
	    grant_label.setSize(120,40);
	    grant_label.setFont(font0);
	    frame.getContentPane().add(grant_label);
	    model = new Mytable();
	    grant_table = new JTable(model);
	    grant_table.getTableHeader().setReorderingAllowed(false);
	    grant_table.setBackground(Color.cyan);
	    grant_table.setSelectionBackground(Color.pink);
	    grant_table.getTableHeader().setFont(font0);
	    grant_table.getTableHeader().setForeground(Color.red);
	    grant_table.setRowHeight(33);
	    grant_table.setFont(font);
	    grant_table.getColumnModel().getColumn(4).setPreferredWidth(120);
	    grant_table.getColumnModel().getColumn(5).setPreferredWidth(120);
		JScrollPane scrollPane = new JScrollPane(grant_table);
		scrollPane.getViewport().setBackground(Color.cyan);
		scrollPane.setLocation(0,230);
		scrollPane.setSize(500,300);
		frame.add(scrollPane);
		/*
	     * button控件
	     */
	     //确认
		grant_confirm = new JButton("确认");
		grant_confirm.addActionListener(new ButtonActionListener());
		grant_confirm.setLocation(350,540);
		grant_confirm.setSize(100,50);
		grant_confirm.setFont(font0);
		grant_confirm.setForeground(Color.red);
		grant_confirm.setFocusPainted(false);
  		frame.add(grant_confirm);
  		//取消
  		grant_cancel = new JButton("取消");
  		grant_cancel.addActionListener(new ButtonActionListener());
  		grant_cancel.setLocation(50,540);
  		grant_cancel.setSize(100,50);
  		grant_cancel.setFont(font0);
  		grant_cancel.setForeground(Color.red);
  		grant_cancel.setFocusPainted(false);
  		frame.add(grant_cancel);
  		CheckStockController cpc = new CheckStockController(operator);
	    StockGrantOrderVO vo = cpc.queryStockGrantOrderByNumber(orderID);
	    grant_number.setText(orderID);
	    grant_date.setText(vo.getDate());
	    //设置表格信息
	    List<GoodsListVO> list = vo.getList();
	    Object[][]  data = new Object[list.size()][6];
	    GoodsController gc=new GoodsController(operator);
	    System.out.println(list.get(0).getGoodsnumber());
	    for(int i=0;i<list.size();i++){
	    	GoodsVO goods=gc.queryGoodsByNumebr(list.get(i).getGoodsnumber());
	    	data[i][0] = list.get(i).getGoodsnumber();
	    	data[i][1] = goods.getName();
	    	data[i][2] = goods.getType();
	    	data[i][3] = goods.getPrice();
	    	data[i][4] = goods.getStocknumber();
	    	data[i][5] = list.get(i).getNumber();
	    	
	    }
	    model.setData(data);
		/*
		 * 红冲并复制
		 */
	    if(state == 1){
	    	OrderController oc = new OrderController(operator);
	    	
	    }
		frame.setVisible(true);
	}
	
	class ButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == grant_cancel){
				frame.dispose();
			}
			else if(e.getSource() == grant_confirm){
				frame.dispose();
			}
		}
		
	}
	
	class Mytable extends AbstractTableModel{
		String[] columnNames = {"编号","名称","型号","单价","库存数量","赠送数量"};
		Object[][] celldata = {{"","","","","","",""}};
		
		//设置表格数据
		public void setData(Object[][] data){
			celldata = data;
			fireTableDataChanged();
		}
		
		//返回每一列的类型
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
		//设置可以编辑
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}
	}
	
}