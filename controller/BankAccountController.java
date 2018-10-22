package controller;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import rmi.RemoteHelper;
import utility.DatetoString;
import utility.ResultMessage;
import vo.BankAccountVO;
import vo.LogVO;

public class BankAccountController {
	private String operator;
	public BankAccountController(String operator){
		this.operator=operator;
	}
	
	public ResultMessage addBankAccount(BankAccountVO b){
		ResultMessage res=null;
		try {
			res = RemoteHelper.getInstance().getBankAccountblservice().addAccount(b);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return res;	
	}
	
	public List<BankAccountVO> queryAllBankAccount(){
		List<BankAccountVO> list=null;;
		try {
			list = RemoteHelper.getInstance().getBankAccountblservice().queryBankAccount();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public BankAccountVO queryBankAccountByName(String name){
		
		try {
			return RemoteHelper.getInstance().getBankAccountblservice().queryBankAccount(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultMessage updateBankAccount(String name,double money){
		try {
			return RemoteHelper.getInstance().getBankAccountblservice().updateAccount(name, money);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ResultMessage updateBankAccountName(String oldname,String newname){
		try {
			return RemoteHelper.getInstance().getBankAccountblservice().updateBankAccountName(oldname, newname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
