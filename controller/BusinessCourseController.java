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
 * 经历历程表controller
 */
public class BusinessCourseController {
	private String operator;
	public BusinessCourseController(String operator){
		this.operator=operator;
	}
	
	/*
	 * 查看一段时间销售单
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
	 * 查看一段时间销售退货单
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
	 * 查看一段时间进货单
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
	 * 查看一段时间进货退货单
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
	 * 查看一段时间收款单
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
	 * 查看一段时间付款单
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
	 * 查看一段时间报溢单
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
	 * 查看一段时间报损单
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
	 * 查看一段时间赠送单
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
	 * 红冲销售单
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
	 * 红冲销售退货单
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
	 * 红冲进货单
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
	 * 红冲进货退货单
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
	 * 红冲收款单
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
	 * 红冲付款单
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
	 * 红冲报损单
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
	 * 红冲报溢单
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
	 * 红冲赠送单
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
	 * 导出ExceL销售单
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
	 * 导出ExceL销售退货单
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
	 * 导出ExceL进货单
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
	 * 导出ExceL进货退货单
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
	 * 导出ExceL收款单
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
	 * 导出ExceL付款单
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
	 * 导出ExceL报溢单
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
	 * 导出ExceL报损单
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
	 * 导出ExceL赠送单
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
	 * 查看一段时间现金费用单
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
	 * 红冲现金费用单
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
