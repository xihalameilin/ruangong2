package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import utility.ResultMessage;
import vo.PurchaseBackOrderVO;
import vo.PurchaseOrderVO;

public interface Purchaseblservice extends Remote{
	/*
	 * 创建新的进货单
	 */
	public ResultMessage createNewPurchaseOrder(PurchaseOrderVO p ) throws RemoteException;
	/*
	 * 创建新的进货退货单
	 */
	public ResultMessage createNewPurchaseBackOrder(PurchaseBackOrderVO p) throws RemoteException;
	/*
	 * /查看经营历程表之进货单
	 */
	public List<PurchaseOrderVO>BussinessCoursePurchase(String begin,String end) throws RemoteException;
	/*
	 * /查看经营历程表之退货单
	 */
	public List<PurchaseBackOrderVO>BussinessCoursePurchaseBack(String begin,String end) throws RemoteException;
	/*
	 * /红冲之进货单
	 */
	public ResultMessage RedDashPurchase(PurchaseOrderVO purchase)throws RemoteException;
	/*
	 * /红冲之退货单
	 */
	public ResultMessage RedDashPurchaseBack(PurchaseBackOrderVO purchaseback)throws RemoteException;
	/*
	 * 计算进货单编号
	 */
	public String getpurchaseordernumber()throws RemoteException;
	/*
	 * 计算进货退货单编号
	 */
	public String getpurchasebackordernumber()throws RemoteException;
	/*
	 * 查询进货单
	 */
	public List<PurchaseOrderVO> queryPurchaseOrder() throws RemoteException;
	/*
	 * 查询进货退货单
	 */
	public List<PurchaseBackOrderVO> queryPurchaseBack() throws RemoteException;
	/*
	 * 保存进货单草稿
	 */
	public ResultMessage draftPurchaseOrder(PurchaseOrderVO p)throws RemoteException;
	/*
	 * 保存进货退货单草稿
	 */
	public ResultMessage draftPurchaseBackOrder(PurchaseBackOrderVO p)throws RemoteException;
	/*
	 * 查看进货单草稿
	 */
	public List<PurchaseOrderVO> querydraftPurchaseOrder()throws RemoteException;
	/*
	 * 查看进货退货单草稿
	 */
	public List<PurchaseBackOrderVO> querydraftPurchaseBackOrder()throws RemoteException;
	/*
	 * 导出经营历程表之进货单
	 */
	public ResultMessage exportPurchaseOrderExcel(List<PurchaseOrderVO> p,String path)throws RemoteException;
	/*
	 * 导出经营历程表之进货退货单
	 */
	public ResultMessage exportPurchaseBackOrderExcel(List<PurchaseBackOrderVO> p,String path)throws RemoteException;
	/*
     * 根据编号查询进货单
     */
	public PurchaseOrderVO queryPurchaseOrderByNumber(String number)throws RemoteException;
	/*
	 * 根据编号查询进货退货单
	 */
	public PurchaseBackOrderVO queryPurchaseBackOrderByNumber(String number)throws RemoteException;
	/*
	 * 更新进货单状态
	 */
	public ResultMessage updatePurchaseOrderState(String number,int state,String comment)throws RemoteException;
	/*
	 * 更新退货单状态
	 */
	public ResultMessage updatePurchaseBackOrderState(String number,int state,String comment)throws RemoteException;


}
