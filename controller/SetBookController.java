package controller;

import java.rmi.RemoteException;
import java.util.Date;

import rmi.RemoteHelper;
import utility.DatetoString;
import utility.ResultMessage;
import vo.LogVO;

public class SetBookController {
	private String operator;
	public SetBookController (String operator){
		this.operator=operator;
	}
	public ResultMessage SetBook(){
		try {
			return RemoteHelper.getInstance().getQueryblservice().SetBook();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String LookBook(String path){
		try {
			return RemoteHelper.getInstance().getQueryblservice().SetBookGoods(path);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	public void insertLog(String operation){
		LogVO l=new LogVO();
		l.setName(this.operator);
		l.setOperation(operation);
		l.setDate(DatetoString.datetostr2(new Date()));
		try {
			 RemoteHelper.getInstance().getLogblservice().addlog(l);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
