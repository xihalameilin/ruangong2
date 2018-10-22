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
	 * 新增商品
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
	 * 删除商品
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
	 * 修改商品
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
	 * 查询商品集合
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
	 * 计算商品编号
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
	 * 根据关键字查询商品
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
	 * 根据编号查询商品
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
	 * 根据名称查询商品
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
