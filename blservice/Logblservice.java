package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import utility.ResultMessage;
import vo.LogVO;

public interface Logblservice extends Remote{

	/*
	 * 添加日志
	 */
	public ResultMessage addlog(LogVO l)throws RemoteException;
	/*
	 * 查看日志
	 */
	public List<LogVO> querylog()throws RemoteException;
}
