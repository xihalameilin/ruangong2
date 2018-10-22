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
	 * 查询未审批的销售单
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
	 * 查询未审批的销售退货单
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
	 * 销售单审批通过后进行的更新操作(改应收应付，改库存,库存查看(stocksaleschange)，单据状态)
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
	 * 销售退货单审批通过后进行的更新操作(改应收应付，改库存,库存查看(stockIn)，单据状态)
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
	 * 根据单据编号查询销售单
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
	 * 根据单据编号查询销售退货单
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
	 * 更新销售单状态
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
	 * 更新销售退货单状态
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
	 * 新增操作日志
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