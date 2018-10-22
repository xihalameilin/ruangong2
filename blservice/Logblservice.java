package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import utility.ResultMessage;
import vo.LogVO;

public interface Logblservice extends Remote{

	/*
	 * �����־
	 */
	public ResultMessage addlog(LogVO l)throws RemoteException;
	/*
	 * �鿴��־
	 */
	public List<LogVO> querylog()throws RemoteException;
}
