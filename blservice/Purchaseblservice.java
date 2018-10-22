package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import utility.ResultMessage;
import vo.PurchaseBackOrderVO;
import vo.PurchaseOrderVO;

public interface Purchaseblservice extends Remote{
	/*
	 * �����µĽ�����
	 */
	public ResultMessage createNewPurchaseOrder(PurchaseOrderVO p ) throws RemoteException;
	/*
	 * �����µĽ����˻���
	 */
	public ResultMessage createNewPurchaseBackOrder(PurchaseBackOrderVO p) throws RemoteException;
	/*
	 * /�鿴��Ӫ���̱�֮������
	 */
	public List<PurchaseOrderVO>BussinessCoursePurchase(String begin,String end) throws RemoteException;
	/*
	 * /�鿴��Ӫ���̱�֮�˻���
	 */
	public List<PurchaseBackOrderVO>BussinessCoursePurchaseBack(String begin,String end) throws RemoteException;
	/*
	 * /���֮������
	 */
	public ResultMessage RedDashPurchase(PurchaseOrderVO purchase)throws RemoteException;
	/*
	 * /���֮�˻���
	 */
	public ResultMessage RedDashPurchaseBack(PurchaseBackOrderVO purchaseback)throws RemoteException;
	/*
	 * ������������
	 */
	public String getpurchaseordernumber()throws RemoteException;
	/*
	 * ��������˻������
	 */
	public String getpurchasebackordernumber()throws RemoteException;
	/*
	 * ��ѯ������
	 */
	public List<PurchaseOrderVO> queryPurchaseOrder() throws RemoteException;
	/*
	 * ��ѯ�����˻���
	 */
	public List<PurchaseBackOrderVO> queryPurchaseBack() throws RemoteException;
	/*
	 * ����������ݸ�
	 */
	public ResultMessage draftPurchaseOrder(PurchaseOrderVO p)throws RemoteException;
	/*
	 * ��������˻����ݸ�
	 */
	public ResultMessage draftPurchaseBackOrder(PurchaseBackOrderVO p)throws RemoteException;
	/*
	 * �鿴�������ݸ�
	 */
	public List<PurchaseOrderVO> querydraftPurchaseOrder()throws RemoteException;
	/*
	 * �鿴�����˻����ݸ�
	 */
	public List<PurchaseBackOrderVO> querydraftPurchaseBackOrder()throws RemoteException;
	/*
	 * ������Ӫ���̱�֮������
	 */
	public ResultMessage exportPurchaseOrderExcel(List<PurchaseOrderVO> p,String path)throws RemoteException;
	/*
	 * ������Ӫ���̱�֮�����˻���
	 */
	public ResultMessage exportPurchaseBackOrderExcel(List<PurchaseBackOrderVO> p,String path)throws RemoteException;
	/*
     * ���ݱ�Ų�ѯ������
     */
	public PurchaseOrderVO queryPurchaseOrderByNumber(String number)throws RemoteException;
	/*
	 * ���ݱ�Ų�ѯ�����˻���
	 */
	public PurchaseBackOrderVO queryPurchaseBackOrderByNumber(String number)throws RemoteException;
	/*
	 * ���½�����״̬
	 */
	public ResultMessage updatePurchaseOrderState(String number,int state,String comment)throws RemoteException;
	/*
	 * �����˻���״̬
	 */
	public ResultMessage updatePurchaseBackOrderState(String number,int state,String comment)throws RemoteException;


}
