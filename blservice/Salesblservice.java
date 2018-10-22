package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import utility.ResultMessage;
import vo.SalesBackOrderVO;
import vo.SalesOrderVO;

public interface Salesblservice extends Remote{
	/*
	 * 创建新的销售单
	 */
	public ResultMessage createNewSalesOrder(SalesOrderVO s) throws RemoteException;
	/*
	 * 创建新的销售退货单
	 */
	public ResultMessage createNewSalesBackOrder(SalesBackOrderVO s) throws RemoteException;
	/*
	 * 计算销售单编号
	 */
	public String getsalesordernumber()throws RemoteException;
	/*
	 * 计算销售退货单编号
	 */
	public String getsalesbackordernumber()throws RemoteException;
	/*
	 * 红冲之销售单
	 */
	public ResultMessage RedDashSalesOrder(SalesOrderVO SalesOrder)throws RemoteException;	
	/*
	 * 红冲之销售退货单
	 */
	public ResultMessage RedDashSalesBackOrder(SalesBackOrderVO SalesBackOrder)throws RemoteException;
	/*
	 * 查看经营历程表之销售单
	 */
	public List<SalesOrderVO>BussinessCourseSalesOrder(String begin,String end) throws RemoteException;
	/*
	 * 查看经营历程表之销售退货单
	 */
	public List<SalesBackOrderVO>BussinessCourseSalesBackOrder(String begin,String end) throws RemoteException;
	/*
	 * 查询销售进货单
	 */
	public List<SalesOrderVO> querySalesOrder() throws RemoteException;
	/*
	 * 查询销售退货单
	 */
	public List<SalesBackOrderVO> querySalesBack() throws RemoteException;
	/*
	 * 保存销售单草稿
	 */
	public ResultMessage draftSalesOrder(SalesOrderVO s)throws RemoteException;
	/*
	 * 保存销售退货单草稿
	 */
	public ResultMessage draftSalesBackOrder(SalesBackOrderVO s)throws RemoteException;
	/*
	 * 查看销售单草稿
	 */
	public List<SalesOrderVO>querydraftSalesOrder()throws RemoteException;
	/*
	 * 查看销售退货单草稿
	 */
	public List<SalesBackOrderVO>querydraftSalesBackOrder()throws RemoteException;
	/*
	 * 导出经营历程表之销售单
	 */
	public ResultMessage exportSalesOrderExcel(List<SalesOrderVO> p,String path)throws RemoteException;
	/*
	 * 导出经营历程表之销售退货单
	 */
	public ResultMessage exportSalesBackOrderExcel(List<SalesBackOrderVO> p,String path)throws RemoteException;
	/*
	 * 根据编号查询销售单
	 */
	public SalesOrderVO querySalesOrderByNumber(String number)throws RemoteException;
	/*
	 * 根据编号查询销售退货单
	 */
	public SalesBackOrderVO querySalesBackOrderByNumber(String number)throws RemoteException;
	/*
	 * 更新销售单状态
	 */
	public ResultMessage updateSalesOrderState(String number,int state,String comment)throws RemoteException;
	/*
	 * 更新销售单状态
	 */
	public ResultMessage updateSalesBackOrderState(String number,int state,String comment)throws RemoteException;


}
