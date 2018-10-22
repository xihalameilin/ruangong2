package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import utility.ResultMessage;
import vo.PersonAccountVO;

public interface Loginblservice extends Remote{
	
	public ResultMessage login(PersonAccountVO p)throws RemoteException;
	

}
