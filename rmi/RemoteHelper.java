package rmi;

import java.rmi.Remote;

import blservice.Adminblservice;
import blservice.BankAccountblservice;
import blservice.Customerblservice;
import blservice.GoodsClassificationblservice;
import blservice.Goodsblservice;
import blservice.Logblservice;
import blservice.Loginblservice;
import blservice.Noticeblservice;
import blservice.Promotionblservice;
import blservice.Purchaseblservice;
import blservice.Queryblservice;
import blservice.Receiptblservice;
import blservice.Salesblservice;
import blservice.Stockblservice;


public class RemoteHelper {
	private Remote remote;
	private static RemoteHelper remoteHelper = new RemoteHelper();
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	
	private RemoteHelper() {
	}
	
	public void setRemote(Remote remote){
		this.remote = remote;
	}
	
	public Adminblservice getAdminblservice(){
		return (Adminblservice)remote;
	}
	public BankAccountblservice getBankAccountblservice(){
		return (BankAccountblservice)remote;
	}
	
	public Customerblservice getCustomerblservice(){
		return (Customerblservice)remote;
	}
	
	public Goodsblservice getGoodsblservice(){
		return (Goodsblservice)remote;
	}
	
	public GoodsClassificationblservice getGoodsClassificationblservice(){
		return (GoodsClassificationblservice)remote;
	}
	
	public Loginblservice getLoginblservice(){
		return (Loginblservice)remote;
	}
	
	public Promotionblservice getPromorionblservice(){
		return (Promotionblservice)remote;
	}
	
	public Purchaseblservice getPurchaseblservice(){
		return (Purchaseblservice)remote;
	}
	
	public Queryblservice getQueryblservice(){
		return (Queryblservice)remote;
	}
	
	public Receiptblservice getReceiptblservice(){
		return (Receiptblservice)remote;
	}
	
	public Salesblservice getSalesblservice(){
		return (Salesblservice)remote;
	}
	
	public Stockblservice getStockblservice(){
		return (Stockblservice)remote;
	}	
	
	public Logblservice getLogblservice(){
		return (Logblservice)remote;
	}
	
	public Noticeblservice getNoticeblservice(){
		return (Noticeblservice)remote;
	}
}
