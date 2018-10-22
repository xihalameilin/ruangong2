package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import utility.ResultMessage;
import vo.SalesBackOrderVO;
import vo.SalesOrderVO;

public interface Salesblservice extends Remote{
	/*
	 * �����µ����۵�
	 */
	public ResultMessage createNewSalesOrder(SalesOrderVO s) throws RemoteException;
	/*
	 * �����µ������˻���
	 */
	public ResultMessage createNewSalesBackOrder(SalesBackOrderVO s) throws RemoteException;
	/*
	 * �������۵����
	 */
	public String getsalesordernumber()throws RemoteException;
	/*
	 * ���������˻������
	 */
	public String getsalesbackordernumber()throws RemoteException;
	/*
	 * ���֮���۵�
	 */
	public ResultMessage RedDashSalesOrder(SalesOrderVO SalesOrder)throws RemoteException;	
	/*
	 * ���֮�����˻���
	 */
	public ResultMessage RedDashSalesBackOrder(SalesBackOrderVO SalesBackOrder)throws RemoteException;
	/*
	 * �鿴��Ӫ���̱�֮���۵�
	 */
	public List<SalesOrderVO>BussinessCourseSalesOrder(String begin,String end) throws RemoteException;
	/*
	 * �鿴��Ӫ���̱�֮�����˻���
	 */
	public List<SalesBackOrderVO>BussinessCourseSalesBackOrder(String begin,String end) throws RemoteException;
	/*
	 * ��ѯ���۽�����
	 */
	public List<SalesOrderVO> querySalesOrder() throws RemoteException;
	/*
	 * ��ѯ�����˻���
	 */
	public List<SalesBackOrderVO> querySalesBack() throws RemoteException;
	/*
	 * �������۵��ݸ�
	 */
	public ResultMessage draftSalesOrder(SalesOrderVO s)throws RemoteException;
	/*
	 * ���������˻����ݸ�
	 */
	public ResultMessage draftSalesBackOrder(SalesBackOrderVO s)throws RemoteException;
	/*
	 * �鿴���۵��ݸ�
	 */
	public List<SalesOrderVO>querydraftSalesOrder()throws RemoteException;
	/*
	 * �鿴�����˻����ݸ�
	 */
	public List<SalesBackOrderVO>querydraftSalesBackOrder()throws RemoteException;
	/*
	 * ������Ӫ���̱�֮���۵�
	 */
	public ResultMessage exportSalesOrderExcel(List<SalesOrderVO> p,String path)throws RemoteException;
	/*
	 * ������Ӫ���̱�֮�����˻���
	 */
	public ResultMessage exportSalesBackOrderExcel(List<SalesBackOrderVO> p,String path)throws RemoteException;
	/*
	 * ���ݱ�Ų�ѯ���۵�
	 */
	public SalesOrderVO querySalesOrderByNumber(String number)throws RemoteException;
	/*
	 * ���ݱ�Ų�ѯ�����˻���
	 */
	public SalesBackOrderVO querySalesBackOrderByNumber(String number)throws RemoteException;
	/*
	 * �������۵�״̬
	 */
	public ResultMessage updateSalesOrderState(String number,int state,String comment)throws RemoteException;
	/*
	 * �������۵�״̬
	 */
	public ResultMessage updateSalesBackOrderState(String number,int state,String comment)throws RemoteException;


}
