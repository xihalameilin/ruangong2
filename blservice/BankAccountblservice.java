package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import utility.ResultMessage;
import vo.BankAccountVO;

public interface BankAccountblservice extends Remote{
	/*
	 * /添加账户
	 */
	public ResultMessage addAccount(BankAccountVO bankaccount)throws RemoteException;
	/*
	 * /删除账户
	 */
	public ResultMessage removeAccount(String name)throws RemoteException;
	/*
	 * /修改账户
	 */
	public ResultMessage updateAccount(String name,double money)throws RemoteException;
	/*
	 * /查询账户
	 */
	public List<BankAccountVO> queryBankAccount() throws RemoteException;
	/*
	 * 根据名字查账户
	 */
	public BankAccountVO queryBankAccount(String name) throws RemoteException;
	/*
	 * 根据名字改名字
	 */
	public ResultMessage updateBankAccountName(String oldname,String newname) throws RemoteException;

}
