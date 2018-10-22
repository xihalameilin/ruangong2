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

import controller.CheckReceiptController;
import controller.CheckSalesController;
import controller.OrderController;
import ui.Stockmanui.ButtonActionListener;
import vo.GoodsListVO;
import vo.ReceiptBackVO;
import vo.SalesBackOrderVO;
import vo.TransferAccountVO;

public class SalesBackOrderFrame {
	private JFrame frame;
	private JTextField sbo_number;//单据编号
	private JTextField sbo_customer;//客户
	private JTextField sbo_operator;//操作员
	private JTextField sbo_salesman;//业务员
	private JTextField sbo_stock;//仓库
	private JTextField sbo_addup;//总额
	private Mytable model;//
	private JTable sbo_table;//出货商品表
	private JButton sbo_confirm;
	private JButton sbo_cancel;
	
	SalesBackOrderFrame(String orderID,String operator,int state){
		Font font = new Font("Default",Font.BOLD,25);
		Font font0 = new Font("Default",Font.BOLD,20);
	    frame = new JFrame("销售退货单");
	    frame.setLayout(null);
	    frame.setLocation(800,220);
	    frame.setSize(500,650);
	    frame.setFont(font);
	    frame.setResizable(false);
	    frame.getContentPane().setBackground(Color.cyan);
	    /*
	     * 表单信息显示
	     */
	    //单据编号
	    JLabel number_label = new JLabel("单据编号");
	    number_label.setLocation(20,20);
	    number_label.setSize(120,40);
	    number_label.setFont(font);
	    frame.getContentPane().add(number_label);
	    sbo_number = new JTextField();
	    sbo_number.setLocation(150,20);
	    sbo_number.setSize(250,40);
	    sbo_number.setBackground(Color.white);
	    sbo_number.setFont(font);
	    sbo_number.setEditable(false);
	    frame.getContentPane().add(sbo_number);
	    //客户
	    JLabel customer_label = new JLabel("客户");
	    customer_label.setLocation(40,80);
	    customer_label.setSize(60,40);
	    customer_label.setFont(font);
	    frame.getContentPane().add(customer_label);
	    sbo_customer = new JTextField();
	    sbo_customer.setLocation(100,80);
	    sbo_customer.setSize(120,40);
	    sbo_customer.setBackground(Color.white);
	    sbo_customer.setFont(font);
	    sbo_customer.setEditable(false);
	    frame.getContentPane().add(sbo_customer);
	    //业务员
	    JLabel salesman_label = new JLabel("业务员");
	    salesman_label.setLocation(240,80);
	    salesman_label.setSize(100,40);
	    salesman_label.setFont(font);
	    frame.getContentPane().add(salesman_label);
	    sbo_salesman = new JTextField();
	    sbo_salesman.setLocation(330,80);
	    sbo_salesman.setSize(120,40);
	    sbo_salesman.setBackground(Color.white);
	    sbo_salesman.setFont(font);
	    sbo_salesman.setEditable(false);
	    frame.getContentPane().add(sbo_salesman);
	    //操作员
	    JLabel operator_label = new JLabel("操作员");
	    operator_label.setLocation(10,140);
	    operator_label.setSize(100,40);
	    operator_label.setFont(font);
	    frame.getContentPane().add(operator_label);
	    sbo_operator = new JTextField();
	    sbo_operator.setLocation(100,140);
	    sbo_operator.setSize(120,40);
	    sbo_operator.setBackground(Color.white);
	    sbo_operator.setFont(font);
	    sbo_operator.setEditable(false);
	    frame.getContentPane().add(sbo_operator);
	    //仓库
	    JLabel stock_label = new JLabel("仓库");
	    stock_label.setLocation(260,140);
	    stock_label.setSize(100,40);
	    stock_label.setFont(font);
	    frame.getContentPane().add(stock_label);
	    sbo_stock = new JTextField();
	    sbo_stock.setLocation(330,140);
	    sbo_stock.setSize(120,40);
	    sbo_stock.setBackground(Color.white);
	    sbo_stock.setFont(font);
	    sbo_stock.setEditable(false);
	    frame.getContentPane().add(sbo_stock);
	    //出货商品清单
	    JLabel goods_label = new JLabel("出货商品清单");
	    goods_label.setLocation(160,180);
	    goods_label.setSize(200,40);
	    goods_label.setFont(font);
	    goods_label.setForeground(Color.red);
	    frame.getContentPane().add(goods_label);
	    model = new Mytable();
	    sbo_table = new JTable(model);
	    sbo_table.getTableHeader().setReorderingAllowed(false);
	    sbo_table.setFont(font);
	    sbo_table.setBackground(Color.cyan);
	    sbo_table.setSelectionBackground(Color.pink);
	    sbo_table.getTableHeader().setFont(font);
	    sbo_table.getTableHeader().setForeground(Color.red);
	    sbo_table.setRowHeight(33);
	    JScrollPane scrollPane = new JScrollPane(sbo_table);
	    scrollPane.setSize(500,320);
	    scrollPane.setLocation(0,220);
	    scrollPane.getViewport().setBackground(Color.cyan);
		frame.add(scrollPane);
		//总额
		JLabel add_label = new JLabel("总额");
	    add_label.setLocation(10,555);
	    add_label.setSize(100,40);
	    add_label.setFont(font0);
	    frame.getContentPane().add(add_label);
	    sbo_addup = new JTextField();
	    sbo_addup.setLocation(70,555);
	    sbo_addup.setSize(120,40);
	    sbo_addup.setBackground(Color.white);
	    sbo_addup.setFont(font);
	    sbo_addup.setEditable(false);
	    frame.getContentPane().add(sbo_addup);
		/*
		 * button控件
		 */
		//确认
		sbo_confirm = new JButton("确认");
		sbo_confirm.addActionListener(new ButtonActionListener());
		sbo_confirm.setLocation(350,550);
		sbo_confirm.setSize(100,50);
		sbo_confirm.setFont(font);
		sbo_confirm.setForeground(Color.red);
		sbo_confirm.setFocusPainted(false);
		frame.add(sbo_confirm);
		//取消
		sbo_cancel = new JButton("取消");
		sbo_cancel.addActionListener(new ButtonActionListener());
		sbo_cancel.setLocation(220,550);
		sbo_cancel.setSize(100,50);
		sbo_cancel.setFont(font);
		sbo_cancel.setForeground(Color.red);
		sbo_cancel.setFocusPainted(false);
		frame.add(sbo_cancel);
		CheckSalesController cpc = new CheckSalesController(operator);
	    SalesBackOrderVO vo =  cpc.querySalesBackByNumber(orderID);
	    sbo_number.setText(orderID);
	    sbo_customer.setText(vo.getSalesperson());
	    sbo_operator.setText(vo.getOperator());
	    sbo_stock.setText(vo.getWarehouse());
	    sbo_addup.setText(String.valueOf(vo.getTotal()));
	    //设置表格信息
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
	     * 红冲并复制
	     */
	    if(state == 1){
	    	OrderController oc = new OrderController(operator);
	    	sbo_number.setText(oc.getSalesBackOrderNumber());
	    	sbo_number.setEditable(false);
	    	sbo_customer.setEditable(true);
	    	sbo_operator.setEditable(true);
	    	sbo_salesman.setEditable(true);
	    	sbo_stock.setEditable(true);
	    	sbo_addup.setEditable(true);
	    }
		frame.setVisible(true);
	    
	}
	
	class ButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == sbo_cancel){
				frame.dispose();
			}
			else if(e.getSource() == sbo_confirm){
				frame.dispose();
			}
		}
		
	}
	
	class Mytable extends AbstractTableModel{
		String[] columnNames = {"编号","名称","型号","数量","单价","金额","备注"};
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
			if(columnIndex==3 || columnIndex==4 || columnIndex==6){
				   return true;
			}else{
				return false;
			}
		}
	}
	
}