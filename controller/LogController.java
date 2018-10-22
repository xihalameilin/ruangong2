package controller;

import java.rmi.RemoteException;
import java.util.List;

import rmi.RemoteHelper;
import vo.LogVO;

public class LogController {
	
	public List<LogVO> queryAllLog(){
		try {
			return RemoteHelper.getInstance().getLogblservice().querylog();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
