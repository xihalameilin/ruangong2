package controller;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import rmi.RemoteHelper;
import utility.DatetoString;
import utility.ResultMessage;
import vo.LogVO;
import vo.PayOrderVO;
import vo.PurchaseBackOrderVO;
import vo.PurchaseOrderVO;
import vo.ReceiptBackVO;
import vo.ReceiptVO;
import vo.SalesBackOrderVO;
import vo.SalesOrderVO;
import vo.StockAlarmOrderVO;
import vo.StockGrantOrderVO;
import vo.StockLossOrderVO;
import vo.StockOverflowOrderVO;

public class OrderController {
	private String operator;
	public OrderController(String operator){
		this.operator=operator;
	}
	
	public ResultMessage CreateNewPurchaseOrder(PurchaseOrderVO p){
		ResultMessage res=null;
		try {
			res=RemoteHelper.getInstance().getPurchaseblservice().createNewPurchaseOrder(p);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	public ResultMessage CreateNewPurchaseOrderDraft(PurchaseOrderVO p){
		try {
			return RemoteHelper.getInstance().getPurchaseblservice().draftPurchaseOrder(p);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultMessage CreateNewPurchaseBackOrder(PurchaseBackOrderVO p){
		ResultMessage res=null;
		try {
			res=RemoteHelper.getInstance().getPurchaseblservice().createNewPurchaseBackOrder(p);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	public ResultMessage CreateNewPurchaseBackOrderDraft(PurchaseBackOrderVO p){
		try {
			return RemoteHelper.getInstance().getPurchaseblservice().draftPurchaseBackOrder(p);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	public ResultMessage CreateNewSalesOrder(SalesOrderVO s){
		ResultMessage res=null;
		try {
			res=RemoteHelper.getInstance().getSalesblservice().createNewSalesOrder(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	public ResultMessage CreateNewSalesOrderDraft(SalesOrderVO s){
		try {
			return RemoteHelper.getInstance().getSalesblservice().draftSalesOrder(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public ResultMessage CreateNewSalesBackOrder(SalesBackOrderVO s){
		ResultMessage res=null;
		try {
			res=RemoteHelper.getInstance().getSalesblservice().createNewSalesBackOrder(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	public ResultMessage CreateNewSalesBackOrderDraft(SalesBackOrderVO s){
		try {
			return RemoteHelper.getInstance().getSalesblservice().draftSalesBackOrder(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultMessage CreateNewReceipt(ReceiptVO r){
		ResultMessage res=null;
		try {
			res=RemoteHelper.getInstance().getReceiptblservice().createNewReceipt(r);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public ResultMessage CreateNewReceiptDraft(ReceiptVO r){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().draftReceipt(r);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultMessage CreateNewPayOrder(PayOrderVO p){
		ResultMessage res=null;
		try {
			res=RemoteHelper.getInstance().getReceiptblservice().createPayOrder(p);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public ResultMessage CreateNewPayOrderDraft(PayOrderVO p){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().draftPayOrder(p);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * �½���汨�絥
	 */
	public ResultMessage CreateStockOverflowOrder(StockOverflowOrderVO p){
		ResultMessage res=null;
		try {
			res=RemoteHelper.getInstance().getStockblservice().createNewStockOverflowOrder(p);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	/*
	 * �½���汨��
	 */
	public ResultMessage CreateStockLossOrder(StockLossOrderVO p){
		ResultMessage res=null;
		try {
			res=RemoteHelper.getInstance().getStockblservice().createNewStockLossOrder(p);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	/*
	 * �½���汨����
	 */
	public ResultMessage CreateStockAlarmOrder(StockAlarmOrderVO p){
		ResultMessage res=null;
		try {
			res=RemoteHelper.getInstance().getStockblservice().createNewStockAlarmOrder(p);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	/*
	 * �½�������͵�
	 */
	public ResultMessage CreateStockGrantOrder(StockGrantOrderVO p){
		ResultMessage res=null;
		try {
			res=RemoteHelper.getInstance().getStockblservice().createNewStockGrantOrder(p);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	/*
	 * �������۵��ݸ�
	 */
	public ResultMessage draftSalesOrder(SalesOrderVO s){
		try {
			return RemoteHelper.getInstance().getSalesblservice().draftSalesOrder(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ���������˻����ݸ�
	 */
	public ResultMessage draftSalesBackOrder(SalesBackOrderVO s){
		try {
			return RemoteHelper.getInstance().getSalesblservice().draftSalesBackOrder(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ����������ݸ�
	 */
	public ResultMessage draftPurchaseOrder(PurchaseOrderVO s){
		try {
			return RemoteHelper.getInstance().getPurchaseblservice().draftPurchaseOrder(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ��������˻����ݸ�
	 */
	public ResultMessage draftPurchaseBackOrder(PurchaseBackOrderVO s){
		try {
			return RemoteHelper.getInstance().getPurchaseblservice().draftPurchaseBackOrder(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �����տ�ݸ�
	 */
	public ResultMessage draftReceiptOrder(ReceiptVO s){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().draftReceipt(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ���渶��ݸ�
	 */
	public ResultMessage draftPayOrder(PayOrderVO s){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().draftPayOrder(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �����汨�絥�ݸ�
	 */
	public ResultMessage draftStockOverflowOrder(StockOverflowOrderVO s){
		try {
			return RemoteHelper.getInstance().getStockblservice().draftStockOverflowOrder(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ���������͵��ݸ�
	 */
	public ResultMessage draftStockGrantOrder(StockGrantOrderVO s){
		try {
			return RemoteHelper.getInstance().getStockblservice().draftStockGrantOrder(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �����汨�𵥲ݸ�
	 */
	public ResultMessage draftStockLossOrder(StockLossOrderVO s){
		try {
			return RemoteHelper.getInstance().getStockblservice().draftStockLossOrder(s);
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
	
	public String getPurchaseOrderNumber(){
		try {
			return RemoteHelper.getInstance().getPurchaseblservice().getpurchaseordernumber();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return operator;
	}
	
	public String getPurchaseBackOrderNumber(){
		try {
			return RemoteHelper.getInstance().getPurchaseblservice().getpurchasebackordernumber();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return operator;
	}
	
	public String getSalesOrderNumber(){
		try {
			return RemoteHelper.getInstance().getSalesblservice().getsalesordernumber();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return operator;
	}
	
	public String getSalesBackOrderNumber(){
		try {
			return RemoteHelper.getInstance().getSalesblservice().getsalesbackordernumber();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return operator;
	}
	
	public String getReceiptNumber(){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().getreceiptnumber();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return operator;
	}
	
	public String getReceiptBackNumber(){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().getReceiptBackNumber();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return operator;
	}
	
	public String getPayOrderNumber(){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().getpayordernumber();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return operator;
	}
	
	public ResultMessage CreateReceiptBack(ReceiptBackVO r){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().createReceiptBack(r);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ResultMessage draftReceiptBack(ReceiptBackVO r){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().draftReceiptBack(r);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �鿴�ݸ������
	 */
	public List<PurchaseOrderVO> querydraftPurchaseOrder(){
		try {
			return RemoteHelper.getInstance().getPurchaseblservice().querydraftPurchaseOrder();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �鿴�ݸ�����˻���
	 */
	public List<PurchaseBackOrderVO> querydraftPurchaseBackOrder(){
		try {
			return RemoteHelper.getInstance().getPurchaseblservice().querydraftPurchaseBackOrder();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �鿴�ݸ����۵�
	 */
	public List<SalesOrderVO> querydraftSalesOrder(){
		try {
			return RemoteHelper.getInstance().getSalesblservice().querydraftSalesOrder();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �鿴�ݸ������˻���
	 */
	public List<SalesBackOrderVO> querydraftSaBacklesOrder(){
		try {
			return RemoteHelper.getInstance().getSalesblservice().querydraftSalesBackOrder();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �鿴�ݸ��տ
	 */
	public List<ReceiptVO> querydraftReceipt(){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().querydraftReceipt();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �鿴�ݸ帶�
	 */
	public List<ReceiptBackVO> querydraftReceiptBack(){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().querydraftReceiptBack();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �鿴�ݸ��ֽ���õ�
	 */
	public List<PayOrderVO> querydraftPayOrder(){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().querydraftPayOrder();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



}