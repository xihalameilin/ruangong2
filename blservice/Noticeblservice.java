package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import utility.ResultMessage;
import vo.NoticeVO;

public interface Noticeblservice extends Remote{
	public List<NoticeVO> queryAll(String person)throws RemoteException;
	
	public ResultMessage addNotice(NoticeVO n)throws RemoteException;

}
