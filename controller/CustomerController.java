package controller;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import rmi.RemoteHelper;
import utility.DatetoString;
import utility.ResultMessage;
import vo.CustomerVO;
import vo.LogVO;

public class CustomerController {
	private String operator;
	public CustomerController(String operator){
		this.operator=operator;
	}
	
	/*
	 * 增加一个客户
	 */
	public ResultMessage addCustomer(CustomerVO c){
		ResultMessage res=null;
		try {
			res=RemoteHelper.getInstance().getCustomerblservice().addCustomer(c);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	/*
	 * 查询客户集合
	 */
	public List<CustomerVO> queryCustomer(){
	    List<CustomerVO> list=null;
	    try {
			list=RemoteHelper.getInstance().getCustomerblservice().queryCustomer();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	/*
	 * 根据编号查询客户
	 */
	public CustomerVO queryCustomerByNumber(String number){
		
		try {
			return RemoteHelper.getInstance().getCustomerblservice().queryCustomerByNumber(number);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	/*
	 * 根据级别查询客户
	 */
	public List<CustomerVO> queryCustomerByLevel(int level){
		try {
			return RemoteHelper.getInstance().getCustomerblservice().queryCustomerByLevel(level);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	/*
	 * 根据分类查询客户
	 */
	public List<CustomerVO> queryCustomerByClassification(int classification){
		List<CustomerVO> list=null;
		try {
			list = RemoteHelper.getInstance().getCustomerblservice().queryCustomerByClassification(classification);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	/*
	 * 得到客户编号
	 */
	public String getcustomernumber(){
		String str="";
		try {
			str=RemoteHelper.getInstance().getCustomerblservice().getcustomernumber();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	/*
	 * 修改客户级别
	 */
	public ResultMessage updateCustomerLevel(int number,CustomerVO customer){
		try {
			return RemoteHelper.getInstance().getCustomerblservice().updateCustomer(number, customer);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 根据名称查询客户
	 */
	public CustomerVO queryCustomerByName(String name){
		try {
			return RemoteHelper.getInstance().getCustomerblservice().queryCustomerByName(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 修改客户
	 */
	public ResultMessage updateCustomer(CustomerVO p){
		try {
			return RemoteHelper.getInstance().getCustomerblservice().updateCustomerAll(p);
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
