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
	 * ����һ���ͻ�
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
	 * ��ѯ�ͻ�����
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
	 * ���ݱ�Ų�ѯ�ͻ�
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
	 * ���ݼ����ѯ�ͻ�
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
	 * ���ݷ����ѯ�ͻ�
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
	 * �õ��ͻ����
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
	 * �޸Ŀͻ�����
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
	 * �������Ʋ�ѯ�ͻ�
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
	 * �޸Ŀͻ�
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
