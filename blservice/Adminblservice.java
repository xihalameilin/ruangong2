package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import utility.ResultMessage;
import vo.PersonAccountVO;

public interface Adminblservice extends Remote{
	/*
	 * 修改权限
	 */
	public ResultMessage updatePersonAccount(String number,String identity)throws RemoteException;
	/*
	 * 添加人员
	 */
	public ResultMessage addPersonAccount(PersonAccountVO p)throws RemoteException;

}
