package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import utility.ResultMessage;
import vo.BankAccountVO;

public interface BankAccountblservice extends Remote{
	/*
	 * /����˻�
	 */
	public ResultMessage addAccount(BankAccountVO bankaccount)throws RemoteException;
	/*
	 * /ɾ���˻�
	 */
	public ResultMessage removeAccount(String name)throws RemoteException;
	/*
	 * /�޸��˻�
	 */
	public ResultMessage updateAccount(String name,double money)throws RemoteException;
	/*
	 * /��ѯ�˻�
	 */
	public List<BankAccountVO> queryBankAccount() throws RemoteException;
	/*
	 * �������ֲ��˻�
	 */
	public BankAccountVO queryBankAccount(String name) throws RemoteException;
	/*
	 * �������ָ�����
	 */
	public ResultMessage updateBankAccountName(String oldname,String newname) throws RemoteException;

}
