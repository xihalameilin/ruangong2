package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import utility.ResultMessage;
import vo.PayOrderVO;
import vo.ReceiptBackVO;
import vo.ReceiptVO;

public interface Receiptblservice extends Remote{
	/*
	 * /�ƶ��ֽ���õ�
	 */
	public ResultMessage createNewReceipt(ReceiptVO receipt) throws RemoteException;
	/*
	 * /�ƶ��տ
	 */
	public ResultMessage createPayOrder(PayOrderVO payorder) throws RemoteException;
	/*
	 * �ƶ����
	 */
	public ResultMessage createReceiptBack(ReceiptBackVO receiptback) throws RemoteException;
	/*
	 * �����տ���
	 */
	public String getreceiptnumber()throws RemoteException;
	/*
	 * �����ֽ���õ����
	 */
	public String getpayordernumber()throws RemoteException;
	/*
	 * ���㸶����
	 */
	public String getReceiptBackNumber()throws RemoteException;
	/*
	 * /�鿴��Ӫ���̱�֮�տ
	 */
	public List<ReceiptVO>BussinessCourseReceipt(String begin,String end) throws RemoteException;
	/*
	 * /�鿴��Ӫ���̱�֮�ֽ���õ�
	 */
	public List<PayOrderVO>BussinessCoursePayOrder(String begin,String end) throws RemoteException;
	/*
	 * �鿴��Ӫ���̱�֮���
	 */
	public List<ReceiptBackVO>BussinessCourseReceiptBack(String begin,String end)throws RemoteException;
	/*
	 * /���֮�տ
	 */
	public ResultMessage RedDashReceipt(ReceiptVO receipt)throws RemoteException;	
	/*
	 * /���֮�ֽ���õ�
	 */
	public ResultMessage RedDashPayOrder(PayOrderVO payorder)throws RemoteException;
	/*
	 * ���֮���
	 */
	public ResultMessage RedDashReceiptBack(ReceiptBackVO receiptback)throws RemoteException;
	/*
	 * ��ѯ�տ
	 */
	public List<ReceiptVO> queryReceipt() throws RemoteException;
	/*
	 * ��ѯ�ֽ���õ�
	 */
	public List<PayOrderVO> queryPayOrder() throws RemoteException;
	/*
	 * ��ѯ���
	 */
	public List<ReceiptBackVO> queryReceiptBack()throws RemoteException;
	/*
	 * �����տ�ݸ�
	 */
	public ResultMessage draftReceipt(ReceiptVO receipt)throws RemoteException;
	/*
	 * �����ֽ���õ��ݸ�
	 */
	public ResultMessage draftPayOrder(PayOrderVO payorder)throws RemoteException;
	/*
	 * ���渶��ݸ�
	 */
	public ResultMessage draftReceiptBack(ReceiptBackVO receiptback)throws RemoteException;
	/*
	 * �鿴�տ�ݸ�
	 */
	public List<ReceiptVO> querydraftReceipt()throws RemoteException;
	/*
	 * �鿴�ֽ���õ��ݸ�
	 */
	public List<PayOrderVO> querydraftPayOrder()throws RemoteException;
	/*
	 * �鿴����ݸ�
	 */
	public List<ReceiptBackVO> querydraftReceiptBack()throws RemoteException;
	/*
	 * ������Ӫ���̱�֮�տ
	 */
	public ResultMessage exportReceiptExcel(List<ReceiptVO> p,String path)throws RemoteException;
	/*
	 * ������Ӫ���̱�֮���
	 */
	public ResultMessage exportReceiptBackExcel(List<ReceiptBackVO> p,String path)throws RemoteException;
	/*
	 * ���ݱ�Ų�ѯ�տ
	 */
	public ReceiptVO queryReceiptByNumber(String number)throws RemoteException;
	/*
	 * ���ݱ�Ų�ѯ���
	 */
	public ReceiptBackVO queryReceiptBackByNumber(String number)throws RemoteException;
	/*
	 * �����տ״̬
	 */
	public ResultMessage updateReceiptState(String number,int state)throws RemoteException;
	/*
	 * ���¸��״̬
	 */
	public ResultMessage updateReceiptBackState(String number,int state)throws RemoteException;
	/*
	 * ���ݱ�Ų�ѯ�ֽ���õ�
	 */
	public PayOrderVO queryPayOrderByNumber(String number)throws RemoteException;
	/*
	 * �����ֽ���õ�EXCEL
	 */
	public ResultMessage exportPayOrderExcel(List<PayOrderVO> p,String path )throws RemoteException;



}