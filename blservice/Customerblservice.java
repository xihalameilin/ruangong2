package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import utility.ResultMessage;
import vo.CustomerVO;
import vo.GoodsVO;

public interface Customerblservice extends Remote{
	/*
	 * ���ӿͻ�
	 */
	public ResultMessage addCustomer(CustomerVO customer) throws RemoteException;
	/*
	 * ɾ���ͻ�
	 */
	public ResultMessage removeCustomer(int number) throws RemoteException;
	/*
	 * �޸Ŀͻ�
	 */
	
	public ResultMessage updateCustomer(int number,CustomerVO customer) throws RemoteException;
	/*
	 * ��ѯ�ͻ��б�
	 */
	
	public List<CustomerVO> queryCustomer() throws RemoteException;
	/*
	 * ��ѯ��Ʒ�б���Ʒѡ����棩
	 */
	
	public List<GoodsVO> getGoodsList() throws RemoteException;
	/*
	 * ��ѯ�ͻ��ĵȼ�
	 */
	public int getCustomerLevel(String name) throws RemoteException;
	/*
	 * ����ͻ����
	 */
	public String getcustomernumber()throws RemoteException;
	/*
	 * �޸Ŀͻ�Ӧ��
	 */
	public ResultMessage changepayment(String name,double money)throws RemoteException;
	/*
	 * �޸Ŀͻ�Ӧ��
	 */
	public ResultMessage changeincome(String name,double money)throws RemoteException;
	/*
	 * ���ݱ�Ų�ѯ�ͻ�
	 */
	public CustomerVO queryCustomerByNumber(String number)throws RemoteException;
	/*
	 * ���ݼ����ѯ�ͻ�
	 */
	public List<CustomerVO> queryCustomerByLevel(int level)throws RemoteException;
	/*
	 * ���ݷ����ѯ�ͻ�
	 */
	public List<CustomerVO> queryCustomerByClassification(int Classification )throws RemoteException;
	/*
	 * �������Ʋ�ѯ�ͻ�
	 */
	public CustomerVO queryCustomerByName(String name)throws RemoteException;
	/*
	 * ���¿ͻ�
	 */
	public ResultMessage updateCustomerAll(CustomerVO p)throws RemoteException;
}
