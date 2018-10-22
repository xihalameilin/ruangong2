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
	 * /制定现金费用单
	 */
	public ResultMessage createNewReceipt(ReceiptVO receipt) throws RemoteException;
	/*
	 * /制定收款单
	 */
	public ResultMessage createPayOrder(PayOrderVO payorder) throws RemoteException;
	/*
	 * 制定付款单
	 */
	public ResultMessage createReceiptBack(ReceiptBackVO receiptback) throws RemoteException;
	/*
	 * 计算收款单编号
	 */
	public String getreceiptnumber()throws RemoteException;
	/*
	 * 计算现金费用单编号
	 */
	public String getpayordernumber()throws RemoteException;
	/*
	 * 计算付款单编号
	 */
	public String getReceiptBackNumber()throws RemoteException;
	/*
	 * /查看经营历程表之收款单
	 */
	public List<ReceiptVO>BussinessCourseReceipt(String begin,String end) throws RemoteException;
	/*
	 * /查看经营历程表之现金费用单
	 */
	public List<PayOrderVO>BussinessCoursePayOrder(String begin,String end) throws RemoteException;
	/*
	 * 查看经营历程表之付款单
	 */
	public List<ReceiptBackVO>BussinessCourseReceiptBack(String begin,String end)throws RemoteException;
	/*
	 * /红冲之收款单
	 */
	public ResultMessage RedDashReceipt(ReceiptVO receipt)throws RemoteException;	
	/*
	 * /红冲之现金费用单
	 */
	public ResultMessage RedDashPayOrder(PayOrderVO payorder)throws RemoteException;
	/*
	 * 红冲之付款单
	 */
	public ResultMessage RedDashReceiptBack(ReceiptBackVO receiptback)throws RemoteException;
	/*
	 * 查询收款单
	 */
	public List<ReceiptVO> queryReceipt() throws RemoteException;
	/*
	 * 查询现金费用单
	 */
	public List<PayOrderVO> queryPayOrder() throws RemoteException;
	/*
	 * 查询付款单
	 */
	public List<ReceiptBackVO> queryReceiptBack()throws RemoteException;
	/*
	 * 保存收款单草稿
	 */
	public ResultMessage draftReceipt(ReceiptVO receipt)throws RemoteException;
	/*
	 * 保存现金费用单草稿
	 */
	public ResultMessage draftPayOrder(PayOrderVO payorder)throws RemoteException;
	/*
	 * 保存付款单草稿
	 */
	public ResultMessage draftReceiptBack(ReceiptBackVO receiptback)throws RemoteException;
	/*
	 * 查看收款单草稿
	 */
	public List<ReceiptVO> querydraftReceipt()throws RemoteException;
	/*
	 * 查看现金费用单草稿
	 */
	public List<PayOrderVO> querydraftPayOrder()throws RemoteException;
	/*
	 * 查看付款单草稿
	 */
	public List<ReceiptBackVO> querydraftReceiptBack()throws RemoteException;
	/*
	 * 导出经营历程表之收款单
	 */
	public ResultMessage exportReceiptExcel(List<ReceiptVO> p,String path)throws RemoteException;
	/*
	 * 导出经营历程表之付款单
	 */
	public ResultMessage exportReceiptBackExcel(List<ReceiptBackVO> p,String path)throws RemoteException;
	/*
	 * 根据编号查询收款单
	 */
	public ReceiptVO queryReceiptByNumber(String number)throws RemoteException;
	/*
	 * 根据编号查询付款单
	 */
	public ReceiptBackVO queryReceiptBackByNumber(String number)throws RemoteException;
	/*
	 * 更新收款单状态
	 */
	public ResultMessage updateReceiptState(String number,int state)throws RemoteException;
	/*
	 * 更新付款单状态
	 */
	public ResultMessage updateReceiptBackState(String number,int state)throws RemoteException;
	/*
	 * 根据编号查询现金费用单
	 */
	public PayOrderVO queryPayOrderByNumber(String number)throws RemoteException;
	/*
	 * 导出现金费用单EXCEL
	 */
	public ResultMessage exportPayOrderExcel(List<PayOrderVO> p,String path )throws RemoteException;



}