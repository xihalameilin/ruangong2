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
     * 查询未审批的进货单
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
	 * 查询未审批的进货退货单
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
	 * 审批进货单之后的更新操作(改库存,改应收应付?，单据状态，库存进货记录(StockPurchaseChangeVO))
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
	 * 审批进货退货单之后的更新操作(改库存，该应收应付?，单据状态，库存出库记录(StockOutVO))
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
	 * 根据单据编号查询进货单
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
	 * 根据单据编号查询进货退货单
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
	 * 更新进货单状态
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
	 * 更新进货退货单状态
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
