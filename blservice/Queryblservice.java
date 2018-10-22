package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import utility.ResultMessage;
import vo.SalesOrderVO;


public interface Queryblservice extends Remote{
	/*
	 * /�鿴������ϸ��
	 */
	public List<SalesOrderVO>AccountForSales(String begin,String end) throws RemoteException;	
	/*
	 * /�鿴��Ӫ�����
	 */
	public List<Double> queryManagementSituation(String begin,String end)throws RemoteException;
	/*
	 * /�ڳ�����֮����
	 */
	public ResultMessage SetBook()throws RemoteException;
	/*
	 * /�ڳ�����֮�鿴
	 */
	public String SetBookGoods(String year)throws RemoteException;
	/*
	 * ����������ϸ��
	 */
	public ResultMessage exportSalesExcel(List<SalesOrderVO> p,String path)throws RemoteException;
	/*
	 * ������Ӫ�����
	 */
	public ResultMessage exportSitutationExcel(List<Double> p,String path)throws RemoteException;


}
