package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import utility.ResultMessage;
import vo.CustomerVO;
import vo.GoodsVO;

public interface Customerblservice extends Remote{
	/*
	 * 增加客户
	 */
	public ResultMessage addCustomer(CustomerVO customer) throws RemoteException;
	/*
	 * 删除客户
	 */
	public ResultMessage removeCustomer(int number) throws RemoteException;
	/*
	 * 修改客户
	 */
	
	public ResultMessage updateCustomer(int number,CustomerVO customer) throws RemoteException;
	/*
	 * 查询客户列表
	 */
	
	public List<CustomerVO> queryCustomer() throws RemoteException;
	/*
	 * 查询商品列表（商品选择界面）
	 */
	
	public List<GoodsVO> getGoodsList() throws RemoteException;
	/*
	 * 查询客户的等级
	 */
	public int getCustomerLevel(String name) throws RemoteException;
	/*
	 * 计算客户编号
	 */
	public String getcustomernumber()throws RemoteException;
	/*
	 * 修改客户应付
	 */
	public ResultMessage changepayment(String name,double money)throws RemoteException;
	/*
	 * 修改客户应收
	 */
	public ResultMessage changeincome(String name,double money)throws RemoteException;
	/*
	 * 根据编号查询客户
	 */
	public CustomerVO queryCustomerByNumber(String number)throws RemoteException;
	/*
	 * 根据级别查询客户
	 */
	public List<CustomerVO> queryCustomerByLevel(int level)throws RemoteException;
	/*
	 * 根据分类查询客户
	 */
	public List<CustomerVO> queryCustomerByClassification(int Classification )throws RemoteException;
	/*
	 * 根据名称查询客户
	 */
	public CustomerVO queryCustomerByName(String name)throws RemoteException;
	/*
	 * 更新客户
	 */
	public ResultMessage updateCustomerAll(CustomerVO p)throws RemoteException;
}
