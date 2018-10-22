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
import vo.StockGrantOrderVO;
import vo.StockLossOrderVO;
import vo.StockOverflowOrderVO;

/*
 * �������̱�controller
 */
public class BusinessCourseController {
	private String operator;
	public BusinessCourseController(String operator){
		this.operator=operator;
	}
	
	/*
	 * �鿴һ��ʱ�����۵�
	 */
	public List<SalesOrderVO> querySalesOrder(String begin,String end){
		try {
			return RemoteHelper.getInstance().getSalesblservice().BussinessCourseSalesOrder(begin, end);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �鿴һ��ʱ�������˻���
	 */
	public List<SalesBackOrderVO> querySalesBackOrder(String begin,String end){
		try {
			return RemoteHelper.getInstance().getSalesblservice().BussinessCourseSalesBackOrder(begin, end);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * �鿴һ��ʱ�������
	 */
	public List<PurchaseOrderVO> queryPurchaseOrder(String begin,String end){
		try {
			return RemoteHelper.getInstance().getPurchaseblservice().BussinessCoursePurchase(begin, end);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �鿴һ��ʱ������˻���
	 */
	public List<PurchaseBackOrderVO> queryPurchaseBackOrder(String begin,String end){
		try {
			return RemoteHelper.getInstance().getPurchaseblservice().BussinessCoursePurchaseBack(begin, end);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �鿴һ��ʱ���տ
	 */
	public List<ReceiptVO> queryReceipt(String begin,String end){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().BussinessCourseReceipt(begin, end);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �鿴һ��ʱ�丶�
	 */
	public List<ReceiptBackVO> queryReceiptBack(String begin,String end){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().BussinessCourseReceiptBack(begin, end);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �鿴һ��ʱ�䱨�絥
	 */
	public List<StockOverflowOrderVO> queryStockOverflowOrder(String begin,String end){
		try {
			return RemoteHelper.getInstance().getStockblservice().BussinessCourseStockOverflowOrder(begin, end);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �鿴һ��ʱ�䱨��
	 */
	public List<StockLossOrderVO> queryStockLossOrder(String begin,String end){
		try {
			return RemoteHelper.getInstance().getStockblservice().BussinessCourseStockLossOrder(begin, end);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �鿴һ��ʱ�����͵�
	 */
	public List<StockGrantOrderVO> queryStockGrantOrder(String begin,String end){
		try {
			return RemoteHelper.getInstance().getStockblservice().BussinessCourseStockGrantOrder(begin, end);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ������۵�
	 */
	public ResultMessage RedDashSalesOrder(SalesOrderVO s){
		try {
			return RemoteHelper.getInstance().getSalesblservice().RedDashSalesOrder(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ��������˻���
	 */
	public ResultMessage RedDashSalesBackOrder(SalesBackOrderVO s){
		try {
			return RemoteHelper.getInstance().getSalesblservice().RedDashSalesBackOrder(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ��������
	 */
	public ResultMessage RedDashPurchaseOrder(PurchaseOrderVO s){
		try {
			return RemoteHelper.getInstance().getPurchaseblservice().RedDashPurchase(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �������˻���
	 */
	public ResultMessage RedDashPurchaseBackOrder(PurchaseBackOrderVO s){
		try {
			return RemoteHelper.getInstance().getPurchaseblservice().RedDashPurchaseBack(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ����տ
	 */
	public ResultMessage RedDashReceipt(ReceiptVO s){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().RedDashReceipt(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ��帶�
	 */
	public ResultMessage RedDashReceiptBack(ReceiptBackVO s){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().RedDashReceiptBack(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ��屨��
	 */
	public ResultMessage RedDashStockLossOrder(StockLossOrderVO s){
		try {
			return RemoteHelper.getInstance().getStockblservice().RedDashStockLossOrder(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ��屨�絥
	 */
	public ResultMessage RedDashStockOverflowOrder(StockOverflowOrderVO s){
		try {
			return RemoteHelper.getInstance().getStockblservice().RedDashStockOverflowOrder(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ������͵�
	 */
	public ResultMessage RedDashStockGrantOrder(StockGrantOrderVO s){
		try {
			return RemoteHelper.getInstance().getStockblservice().RedDashStockGrantOrder(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ����ExceL���۵�
	 */
	public ResultMessage exportSalesOrder(List<SalesOrderVO> s,String path){
		try {
			return RemoteHelper.getInstance().getSalesblservice().exportSalesOrderExcel(s,path);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ����ExceL�����˻���
	 */
	public ResultMessage exportSalesBackOrder(List<SalesBackOrderVO> s,String path){
		try {
			return RemoteHelper.getInstance().getSalesblservice().exportSalesBackOrderExcel(s,path);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ����ExceL������
	 */
	public ResultMessage exportPurchaseOrder(List<PurchaseOrderVO> s,String path){
		try {
			return RemoteHelper.getInstance().getPurchaseblservice().exportPurchaseOrderExcel(s,path);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ����ExceL�����˻���
	 */
	public ResultMessage exportPurchaseBackOrder(List<PurchaseBackOrderVO> s,String path){
		try {
			return RemoteHelper.getInstance().getPurchaseblservice().exportPurchaseBackOrderExcel(s,path);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ����ExceL�տ
	 */
	public ResultMessage exportReceipt(List<ReceiptVO> s,String path){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().exportReceiptExcel(s,path);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ����ExceL���
	 */
	public ResultMessage exportReceiptBack(List<ReceiptBackVO> s,String path){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().exportReceiptBackExcel(s,path);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ����ExceL���絥
	 */
	public ResultMessage exportStockOverflowOrder(List<StockOverflowOrderVO> s,String path){
		try {
			return RemoteHelper.getInstance().getStockblservice().exportStockOverflowOrderExcel(s,path);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ����ExceL����
	 */
	public ResultMessage exportStockLossOrder(List<StockLossOrderVO> s,String path){
		try {
			return RemoteHelper.getInstance().getStockblservice().exportStockLossOrderExcel(s,path);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ����ExceL���͵�
	 */
	public ResultMessage exportStockGrantOrder(List<StockGrantOrderVO> s,String path){
		try {
			return RemoteHelper.getInstance().getStockblservice().exportStockGrantOrderExcel(s,path);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �鿴һ��ʱ���ֽ���õ�
	 */
	public List<PayOrderVO> queryPayOrder(String begin,String end){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().BussinessCoursePayOrder(begin, end);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ����ֽ���õ�
	 */
	public ResultMessage RedDashPayOrder(PayOrderVO p){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().RedDashPayOrder(p);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ResultMessage exportPayOrderExcel(List<PayOrderVO> p,String path){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().exportPayOrderExcel(p, path);
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
