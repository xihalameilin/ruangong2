package controller;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import rmi.RemoteHelper;
import utility.DatetoString;
import utility.ResultMessage;
import vo.GoodsListVO;
import vo.LogVO;
import vo.SalesBackOrderVO;
import vo.SalesOrderVO;
import vo.StockInVO;
import vo.StockSalesChangeVO;

public class CheckSalesController {
	private String operator;
	
	public CheckSalesController(String operator){
		this.operator=operator;
	}
	/*
	 * ��ѯδ���������۵�
	 */
	public List<SalesOrderVO> querySalesOrder(){
		List<SalesOrderVO> list=null;
		try {
			list=RemoteHelper.getInstance().getSalesblservice().querySalesOrder();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	/*
	 * ��ѯδ�����������˻���
	 */
	public List<SalesBackOrderVO> querySalesBackOrder(){
		List<SalesBackOrderVO> list=null;
		try {
			list=RemoteHelper.getInstance().getSalesblservice().querySalesBack();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	/*
	 * ���۵�����ͨ������еĸ��²���(��Ӧ��Ӧ�����Ŀ��,���鿴(stocksaleschange)������״̬)
	 */
	public void update(SalesOrderVO s,boolean ispass){
		if(ispass==true){
			for(int i=0;i<s.getList().size();i++){
				try {
					System.out.println(s.getList().get(i).getGoodsnumber());
					System.out.println(s.getList().get(i).getNumber());
					RemoteHelper.getInstance().getStockblservice().changestock(s.getList().get(i).getGoodsnumber(), s.getList().get(i).getNumber());
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
			try {
				RemoteHelper.getInstance().getCustomerblservice().changepayment(s.getSalesperson(), s.getLasttotal());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				RemoteHelper.getInstance().getSalesblservice().updateSalesOrderState(s.getNumber(), 1, s.getComment());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			List<GoodsListVO> list=s.getList();
			for(int i=0;i<list.size();i++){
				StockSalesChangeVO stock=new StockSalesChangeVO();
				stock.setDate(s.getDate());
				stock.setGoodsnumber(list.get(i).getGoodsnumber());
				stock.setNumber(list.get(i).getNumber());
				stock.setPrice(list.get(i).getTotal());
				try {
					RemoteHelper.getInstance().getStockblservice().addStockSalesChangeVO(stock);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
		else
			try {
				RemoteHelper.getInstance().getSalesblservice().updateSalesOrderState(s.getNumber(), 3, s.getComment());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	/*
	 * �����˻�������ͨ������еĸ��²���(��Ӧ��Ӧ�����Ŀ��,���鿴(stockIn)������״̬)
	 */
	public void update(SalesBackOrderVO s,boolean ispass){
	   if(ispass==true){
		   for(int i=0;i<s.getList().size();i++){
				try {
					RemoteHelper.getInstance().getStockblservice().changestock(s.getList().get(i).getGoodsnumber(), s.getList().get(i).getNumber());
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
			try {
				RemoteHelper.getInstance().getCustomerblservice().changeincome(s.getSalesperson(), s.getLasttotal());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				RemoteHelper.getInstance().getSalesblservice().updateSalesBackOrderState(s.getNumber(), 1, s.getComment());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List<GoodsListVO> list=s.getList();
			for(int i=0;i<list.size();i++){
				StockInVO stock=new StockInVO();
				stock.setDate(s.getDate());
				stock.setGoodsnumber(list.get(i).getGoodsnumber());
				stock.setNumber(list.get(i).getNumber());
				stock.setPrice(list.get(i).getTotal());
				try {
					RemoteHelper.getInstance().getStockblservice().addStockInVO(stock);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		
		}
		else{
			try {
				RemoteHelper.getInstance().getSalesblservice().updateSalesBackOrderState(s.getNumber(), 3, s.getComment());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	/*
	 * ���ݵ��ݱ�Ų�ѯ���۵�
	 */
	public SalesOrderVO querySalesByNumber(String number){
		try {
			return RemoteHelper.getInstance().getSalesblservice().querySalesOrderByNumber(number);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ���ݵ��ݱ�Ų�ѯ�����˻���
	 */
	public SalesBackOrderVO querySalesBackByNumber(String number){
		try {
			return RemoteHelper.getInstance().getSalesblservice().querySalesBackOrderByNumber(number);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �������۵�״̬
	 */
	public ResultMessage updateSalesOrderState(String number,int state,String comment){
		try {
			return RemoteHelper.getInstance().getSalesblservice().updateSalesOrderState(number, state, comment);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ���������˻���״̬
	 */
	public ResultMessage updateSalesBackOrderState(String number,int state,String comment){
		try {
			return RemoteHelper.getInstance().getSalesblservice().updateSalesBackOrderState(number, state, comment);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ����������־
	 */
	public void insertLog(String operation){
		LogVO l=new LogVO();
		l.setName(this.operator);
		l.setOperation(operation);
		l.setDate(DatetoString.datetostr2(new Date()));
		try {
			 RemoteHelper.getInstance().getLogblservice().addlog(l);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}