package controller;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import rmi.RemoteHelper;
import utility.DatetoString;
import utility.ResultMessage;
import vo.GoodsVO;
import vo.LogVO;
import vo.StockAlarmOrderVO;
import vo.StockGrantOrderVO;
import vo.StockLossOrderVO;
import vo.StockOverflowOrderVO;

public class CheckStockController {
	private String operator;
	public CheckStockController(String operator){
		this.operator=operator;
	}

	
	public List<StockGrantOrderVO> queryStockGrantOrder(){
		List<StockGrantOrderVO> list=null;
		try {
			list=RemoteHelper.getInstance().getStockblservice().queryStockGrantOrder();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	public List<StockLossOrderVO> queryStockLossOrder(){
		 List<StockLossOrderVO> list=null;
		 try {
			list=RemoteHelper.getInstance().getStockblservice().queryStockLossOrder();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	public List<StockOverflowOrderVO> queryStockOverflowOrder(){
		List<StockOverflowOrderVO> list=null;
		try {
			list=RemoteHelper.getInstance().getStockblservice().queryStockOverflowOrder();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	public List<StockAlarmOrderVO> queryStockAlarmOrder(){
		List<StockAlarmOrderVO> list=null;
		try {
			list=RemoteHelper.getInstance().getStockblservice().queryStockAlarmOrder();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	public void update(StockGrantOrderVO s,boolean ispass){
		if(ispass=true)
			try {
				RemoteHelper.getInstance().getStockblservice().updateStockGrantOrderState(s.getOrdernumber2(), 1);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {
				RemoteHelper.getInstance().getStockblservice().updateStockGrantOrderState(s.getOrdernumber2(), 3);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void update(StockLossOrderVO s,boolean ispass){
		if(ispass=true){
			try {
				RemoteHelper.getInstance().getStockblservice().updateStockLossOrderState(s.getOrdernumber2(), 1);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int change=s.getActualnumber()-s.getStocknumber();
			int number=0;
			
			try {
				List<GoodsVO> list =  RemoteHelper.getInstance().getGoodsblservice().searchGoodsbyname(s.getName());
				number=list.get(0).getNumber();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				RemoteHelper.getInstance().getStockblservice().changestock(number, change);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		}
		else
			try {
				RemoteHelper.getInstance().getStockblservice().updateStockLossOrderState(s.getOrdernumber2(), 3);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void update(StockOverflowOrderVO s,boolean ispass){
		if(ispass=true)
		{
			try {
				RemoteHelper.getInstance().getStockblservice().updateStockOverflowOrderState(s.getOrdernumber2(), 1);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int change=s.getActualnumber()-s.getStocknumber();
			int number=0;
			
			try {
				List<GoodsVO> list =  RemoteHelper.getInstance().getGoodsblservice().searchGoodsbyname(s.getName());
				number=list.get(0).getNumber();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				RemoteHelper.getInstance().getStockblservice().changestock(number, change);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		else
			try {
				RemoteHelper.getInstance().getStockblservice().updateStockOverflowOrderState(s.getOrdernumber2(), 3);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	public void update(StockAlarmOrderVO s,boolean ispass) {
		if(ispass=true)
			try {
				RemoteHelper.getInstance().getStockblservice().updateStockAlarmOrderState(s.getOrdernumber2(), 1);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		else	
			try {
				RemoteHelper.getInstance().getStockblservice().updateStockAlarmOrderState(s.getOrdernumber2(), 1);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	/*
	 * 根据单据编号查询报损单
	 */
	public StockLossOrderVO queryStockLossOrderByNumber(String number){
		try {
			return RemoteHelper.getInstance().getStockblservice().queryStockLossOrderByNumber(number);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public StockOverflowOrderVO queryStockOverflowOrderByNumber(String number){
		try {
			return RemoteHelper.getInstance().getStockblservice().queryStockOverflowOrderByNumber(number);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public StockGrantOrderVO queryStockGrantOrderByNumber(String number){
		try {
			return RemoteHelper.getInstance().getStockblservice().queryStockGrantOrderByNumber(number);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 更新报损单状态
	 */
	public ResultMessage updateStockLossOrderState(String number,int state){
		try {
			return RemoteHelper.getInstance().getStockblservice().updateStockLossOrderState(number, state);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 更新报溢单状态
	 */
	public ResultMessage updateStockOverflowOrderState(String number,int state){
		try {
			return RemoteHelper.getInstance().getStockblservice().updateStockOverflowOrderState(number, state);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 更新赠送单状态
	 */
	public ResultMessage updateStockGrantOrderState(String number,int state){
		try {
			return RemoteHelper.getInstance().getStockblservice().updateStockGrantOrderState(number, state);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 更新报损单状态
	 */
	public ResultMessage updateStockAlarmOrderState(String number,int state){
		try {
			return RemoteHelper.getInstance().getStockblservice().updateStockAlarmOrderState(number, state);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
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

