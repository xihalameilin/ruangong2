package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import utility.ResultMessage;
import vo.SalesOrderVO;


public interface Queryblservice extends Remote{
	/*
	 * /查看销售明细表
	 */
	public List<SalesOrderVO>AccountForSales(String begin,String end) throws RemoteException;	
	/*
	 * /查看经营情况表
	 */
	public List<Double> queryManagementSituation(String begin,String end)throws RemoteException;
	/*
	 * /期初建账之建立
	 */
	public ResultMessage SetBook()throws RemoteException;
	/*
	 * /期初建账之查看
	 */
	public String SetBookGoods(String year)throws RemoteException;
	/*
	 * 导出销售明细表
	 */
	public ResultMessage exportSalesExcel(List<SalesOrderVO> p,String path)throws RemoteException;
	/*
	 * 导出经营情况表
	 */
	public ResultMessage exportSitutationExcel(List<Double> p,String path)throws RemoteException;


}
