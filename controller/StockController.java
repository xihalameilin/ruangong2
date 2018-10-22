package controller;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import rmi.RemoteHelper;
import utility.DatetoString;
import utility.ResultMessage;
import vo.GoodsVO;
import vo.LogVO;
import vo.StockChangeVO;

public class StockController {
	private String operator;
	public StockController(String operator){
		this.operator=operator;
	}
	/*
	 * ø‚¥Ê≤Èø¥
	 */
	public List<StockChangeVO> showStock(String begin,String end){
		try {
			return RemoteHelper.getInstance().getStockblservice().showStock(begin, end);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ø‚¥Ê≈Ãµ„
	 */
	public List<StockChangeVO> searchStock(){
		try {
			RemoteHelper.getInstance().getStockblservice().showStock();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ResultMessage excelstock(List<GoodsVO> p,String path){
		try {
			return RemoteHelper.getInstance().getStockblservice().exportStockExcel(p,path);
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
	
	public String getStockGrantOrderNumber(){
		try {
			return RemoteHelper.getInstance().getStockblservice().getStockGrantOrderNumber();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getStockLossOrderNumber(){
		try {
			return RemoteHelper.getInstance().getStockblservice().getStockLossOrderNumber();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getStockOverflowOrderNumber(){
		try {
			return RemoteHelper.getInstance().getStockblservice().getStockOverflowOrderNumber();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getStockAlarmOrderNumber(){
		try {
			return RemoteHelper.getInstance().getStockblservice().getStockAlarmOrderNumber();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<GoodsVO> queryDangerGoods(){
		try {
			return RemoteHelper.getInstance().getStockblservice().queryDangerGoods();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
