package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import utility.ResultMessage;
import vo.PersonAccountVO;

public interface Adminblservice extends Remote{
	/*
	 * �޸�Ȩ��
	 */
	public ResultMessage updatePersonAccount(String number,String identity)throws RemoteException;
	/*
	 * �����Ա
	 */
	public ResultMessage addPersonAccount(PersonAccountVO p)throws RemoteException;

}
