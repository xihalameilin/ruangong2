package controller;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import rmi.RemoteHelper;
import utility.DatetoString;
import utility.ResultMessage;
import vo.GoodsVO;
import vo.LogVO;

public class GoodsController {
	private String operator;
	public GoodsController(String operator){
		this.operator=operator;
	}
	
	/*
	 * ������Ʒ
	 */
	public ResultMessage insertGoods(GoodsVO g){
		ResultMessage res=null;
		try {
			res=RemoteHelper.getInstance().getGoodsblservice().addGoods(g);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	/*
	 * ɾ����Ʒ
	 */
    public ResultMessage deleteGoods(GoodsVO g){
    	ResultMessage res=null;
    	try {
			res=RemoteHelper.getInstance().getGoodsblservice().removeGoods(g);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
    	
    }
    
	/*
	 * �޸���Ʒ
	 */
	public ResultMessage updateGoods(GoodsVO g,double pricein,double price){
		ResultMessage res=null;
		try {
			res=RemoteHelper.getInstance().getGoodsblservice().updateGoods(g, pricein, price);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	/*
	 * ��ѯ��Ʒ����
	 */
	public List<GoodsVO> query(){
		List<GoodsVO> list=null;
		try {
			list=RemoteHelper.getInstance().getGoodsblservice().query();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	/*
	 * ������Ʒ���
	 */
	public int getgoodsnumber(){
		int number=0;
		try {
			number=RemoteHelper.getInstance().getGoodsblservice().getgoodsnumber();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}
	/*
	 * ���ݹؼ��ֲ�ѯ��Ʒ
	 */
	public List<GoodsVO> queryGoodsByKeyword(String keyword){
		List<GoodsVO> list=null;
		try {
			list=RemoteHelper.getInstance().getGoodsblservice().searchGoods(keyword);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	/*
	 * ���ݱ�Ų�ѯ��Ʒ
	 */
	public GoodsVO queryGoodsByNumebr(int number){
		try {
			return RemoteHelper.getInstance().getGoodsblservice().searchGoodsbynumber(number);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �������Ʋ�ѯ��Ʒ
	 */
	public List<GoodsVO> queryGoodsByName(String name){
		try {
			return RemoteHelper.getInstance().getGoodsblservice().searchGoodsbyname(name);
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
