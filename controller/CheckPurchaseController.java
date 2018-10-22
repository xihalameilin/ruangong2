package controller;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import rmi.RemoteHelper;
import utility.DatetoString;
import utility.ResultMessage;
import vo.GoodsListVO;
import vo.LogVO;
import vo.PurchaseBackOrderVO;
import vo.PurchaseOrderVO;
import vo.StockOutVO;
import vo.StockPurchaseChangeVO;


public class CheckPurchaseController {
	private String operator;
	public CheckPurchaseController(String operator){
		this.operator=operator;
	}

    /*
     * ��ѯδ�����Ľ�����
     */
	public List<PurchaseOrderVO> queryPurchaseOrder(){
		List<PurchaseOrderVO> list=null;
		try {
			list=RemoteHelper.getInstance().getPurchaseblservice().queryPurchaseOrder();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/*
	 * ��ѯδ�����Ľ����˻���
	 */
	public List<PurchaseBackOrderVO> queryPurchaseBackOrder(){
		List<PurchaseBackOrderVO> list=null;
		try {
			list=RemoteHelper.getInstance().getPurchaseblservice().queryPurchaseBack();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	/*
	 * ����������֮��ĸ��²���(�Ŀ��,��Ӧ��Ӧ��?������״̬����������¼(StockPurchaseChangeVO))
	 */
	public void update(PurchaseOrderVO p,boolean ispass){
		if(ispass=true){
			List<GoodsListVO> goodslist=p.getList();
			for(int i=0;i<goodslist.size();i++){
				try {
					RemoteHelper.getInstance().getStockblservice().changestock(goodslist.get(i).getGoodsnumber(), goodslist.get(i).getNumber());
					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
			try {
				RemoteHelper.getInstance().getCustomerblservice().changeincome(p.getProvider(), p.getTotal());
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			try {
				RemoteHelper.getInstance().getPurchaseblservice().updatePurchaseOrderState(p.getNumber(), 1, p.getComment());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			List<GoodsListVO> list=p.getList();
			for(int i=0;i<list.size();i++){
				StockPurchaseChangeVO stock=new StockPurchaseChangeVO();
				stock.setDate(p.getDate());
				stock.setGoodsnumber(list.get(i).getGoodsnumber());
				stock.setNumber(list.get(i).getNumber());
				stock.setPrice(list.get(i).getTotal());
				try {
					RemoteHelper.getInstance().getStockblservice().addStockPurchaseChangeVO(stock);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/*
	 * ���������˻���֮��ĸ��²���(�Ŀ�棬��Ӧ��Ӧ��?������״̬���������¼(StockOutVO))
	 */
	public void update(PurchaseBackOrderVO p,boolean ispass){
		if(ispass=true){
			List<GoodsListVO> goodslist=p.getList();
			for(int i=0;i<goodslist.size();i++){
				try {
					RemoteHelper.getInstance().getStockblservice().changestock(goodslist.get(i).getGoodsnumber(), -goodslist.get(i).getNumber());
					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				RemoteHelper.getInstance().getCustomerblservice().changepayment(p.getProvider(), p.getTotal());
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				RemoteHelper.getInstance().getPurchaseblservice().updatePurchaseBackOrderState(p.getNumber(), 1, p.getComment());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		List<GoodsListVO> list=p.getList();
		for(int i=0;i<list.size();i++){
			StockOutVO stock=new StockOutVO();
			stock.setDate(p.getDate());
			stock.setGoodsnumber(list.get(i).getGoodsnumber());
			stock.setNumber(list.get(i).getNumber());
			stock.setPrice(list.get(i).getTotal());
			try {
				RemoteHelper.getInstance().getStockblservice().addStockOutVO(stock);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		
	}
	/*
	 * ���ݵ��ݱ�Ų�ѯ������
	 */
	public PurchaseOrderVO queryPurchaseByNumber(String number){
		try {
			return RemoteHelper.getInstance().getPurchaseblservice().queryPurchaseOrderByNumber(number);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ���ݵ��ݱ�Ų�ѯ�����˻���
	 */
	public PurchaseBackOrderVO queryPurchaseBackByNumber(String number){
		try {
			return RemoteHelper.getInstance().getPurchaseblservice().queryPurchaseBackOrderByNumber(number);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ���½�����״̬
	 */
	public ResultMessage updatePurchaseOrderState(String number,int state,String comment){
		try {
			return RemoteHelper.getInstance().getPurchaseblservice().updatePurchaseOrderState(number, state, comment);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ���½����˻���״̬
	 */
	public ResultMessage updatePurchaseBackOrderState(String number,int state,String comment){
		try {
			return RemoteHelper.getInstance().getPurchaseblservice().updatePurchaseBackOrderState(number, state, comment);
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
