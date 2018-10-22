package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.CheckReceiptController;
import controller.OrderController;
import ui.PurchaseBackOrderFrame.ButtonActionListener;
import vo.PayOrderVO;
import vo.TiaoMuVO;

public class MoneyOrderFrame {
	private JFrame frame;
	private JTextField mo_number;
	private JTextField mo_operator;
	private JComboBox mo_account;
	private JTable tm_table;
	private JButton mo_cancel;
	private JButton mo_confirm;
	
	public static void main(String[] args){
		new MoneyOrderFrame("","",1);
	}
	
	MoneyOrderFrame(String OrderID,String operator,int state){
		Font font = new Font("Default",Font.BOLD,25);
		Font font0 = new Font("Default",Font.BOLD,20);
	    frame = new JFrame("进货退货单");
	    frame.setLayout(null);
	    frame.setLocation(800,200);
	    frame.setSize(500,590);
	    frame.setFont(font);
	    frame.setResizable(false);
	    frame.getContentPane().setBackground(Color.cyan);
		//订单号
		JLabel mo_number_label = new JLabel("订单号");
	    mo_number_label.setLocation(40,30);
	    mo_number_label.setSize(100,30);
	    mo_number_label.setFont(font);
	    mo_number_label.setBackground(Color.black);
	    frame.add(mo_number_label);
	    mo_number = new JTextField();
	    mo_number.setLocation(150,30);
	    mo_number.setSize(280,30);
	    mo_number.setFont(font);
	    frame.add(mo_number);
	    //操作员
	    JLabel mo_operator_label = new JLabel("操作员");
	    mo_operator_label.setLocation(40,70);
	    mo_operator_label.setSize(100,30);
	    mo_operator_label.setFont(font);
	    mo_operator_label.setBackground(Color.black);
	    frame.add(mo_operator_label);
	    mo_operator = new JTextField();
	    mo_operator.setLocation(150,70);
	    mo_operator.setSize(280,30);
	    mo_operator.setFont(font);
	    frame.add(mo_operator);
	    //银行账户
	    JLabel mo_account_label = new JLabel("银行账户");
	    mo_account_label.setLocation(40,110);
	    mo_account_label.setSize(120,30);
	    mo_account_label.setFont(font);
	    mo_account_label.setBackground(Color.black);
	    frame.add(mo_account_label);
	    mo_account=new JComboBox<String>();
	    mo_account.setLocation(150,110);
	    mo_account.setSize(280,30);
	    mo_account.setBackground(Color.white);
	    mo_account.setFont(font);
	    frame.add(mo_account);
	    /*
	     * 条目清单
	     */
	    JLabel tm_label = new JLabel("条目清单");
	    tm_label.setLocation(200,150);
	    tm_label.setSize(150,30);
	    tm_label.setFont(font);
	    tm_label.setForeground(Color.black);
	    frame.add(tm_label);
	    Object[][] po_data = {{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""}
	    ,{"","",""},{"","",""}};
	    String[] po_columnNames = {"条目名","金额","备注"};
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
		mo_scrollPane.setLocation(0,190);
		mo_scrollPane.setSize(495,270);
		frame.add(mo_scrollPane);
		/*
		 * button控件
		 */
		//确认
	  	mo_confirm = new JButton("确认");
	  	mo_confirm.addActionListener(new ButtonActionListener());
	  	mo_confirm.setLocation(350,480);
	  	mo_confirm.setSize(100,50);
  		mo_confirm.setFont(font0);
  		mo_confirm.setForeground(Color.red);
  		mo_confirm.setFocusPainted(false);
  		frame.add(mo_confirm);
  		//取消
  		mo_cancel = new JButton("取消");
  		mo_cancel.addActionListener(new ButtonActionListener());
  		mo_cancel.setLocation(50,480);
  		mo_cancel.setSize(100,50);
  		mo_cancel.setFont(font0);
  		mo_cancel.setForeground(Color.red);
  		mo_cancel.setFocusPainted(false);
  		frame.add(mo_cancel);
  		/*
  		 * 设置表格信息
  		 */
  		CheckReceiptController crc = new CheckReceiptController(operator);
  		PayOrderVO vo = crc.queryPayOrderByNumber(OrderID);
  		mo_number.setText(OrderID);
	    mo_operator.setText(vo.getOperator());
	    mo_account.setSelectedItem(vo.getBankaccountname());
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
  		
  		/*
	     * 设置是否可编辑
	     */
	    //红冲并复制
	    if(state == 1){
	    	OrderController oc = new OrderController(operator);
	    	System.out.println(oc.getPayOrderNumber());
	    	mo_number.setText(oc.getPayOrderNumber());
	    	mo_number.setEditable(false);
	    	mo_operator.setEditable(true);
	    }
		frame.setVisible(true);
	}
	
	class ButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == mo_cancel){
				frame.dispose();
			}
			else if(e.getSource() == mo_confirm){
				frame.dispose();
			}
		}
		
	}
	
}
