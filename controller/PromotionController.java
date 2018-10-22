package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rmi.RemoteHelper;
import utility.DatetoString;
import utility.ResultMessage;
import vo.GoodsCombinationPromotionVO;
import vo.GoodsListVO;
import vo.LevelPromotionVO;
import vo.LogVO;
import vo.TotalPromotionVO;

public class PromotionController {
	private String operator;
	public PromotionController(String operator){
		this.operator=operator;
	}
	/*
	 * 制定级别促销
	 */
	public ResultMessage createLevelPromotion(LevelPromotionVO p){
		try {
			return RemoteHelper.getInstance().getPromorionblservice().strategyForUser(p);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 制定总价促销
	 */
	public ResultMessage createTotalPromotion(TotalPromotionVO p){
		try {
			return RemoteHelper.getInstance().getPromorionblservice().strategyForPackage(p);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 制定分类促销
	 */
	public ResultMessage createGoodsPromotion(GoodsCombinationPromotionVO p){
		try {
			return RemoteHelper.getInstance().getPromorionblservice().strategyForPrice(p);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 根据级别得到促销
	 */
	public LevelPromotionVO getpromotionByLevel(String name){
		
		try {
			return RemoteHelper.getInstance().getPromorionblservice().getdiscountbylevelpromotion(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	/*
	 * 根据商品组合得到降价
	 */
	public double getpromotionByGoodsCombination(List<GoodsListVO> a){
		try {
			return RemoteHelper.getInstance().getPromorionblservice().getdiscountbygoodscombinationpromotion(a);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/*
	 * 根据总价得到促销策略
	 */
	public TotalPromotionVO getpromotionByTotal(double total){
		try {
			return RemoteHelper.getInstance().getPromorionblservice().getdiscountbytotalpromotion(total);
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
	
	/*
	 * 将两个字符串礼物合并
	 */
	public String union(String str1,String str2){
		List<String> list1=new ArrayList<String>();
		List<Integer> list2=new ArrayList<Integer>();
		String []shuzu2=str1.split(" ");
		String []shuzu=str2.split(" ");
		for(int i=0;i<shuzu2.length/2;i++){
			list1.add(shuzu2[i*2]);
			list2.add(Integer.valueOf(shuzu2[i*2+1]));
		}
		for(int i=0;i<shuzu.length;i++){
			boolean flag=false;
			for(int j=0;j<list1.size();j++){
				if(list1.get(j).equals(shuzu[i])){
					list2.set(j, list2.get(j)+Integer.valueOf(shuzu[i+1]));
					i++;
					flag=true;
					break;
				}
				}
			if(flag==false){
					list1.add(shuzu[i]);
					list2.add(Integer.valueOf(shuzu[i+1]));
					i++;
			}
		}
		String res="";
		for(int i =0;i<list1.size();i++){
			res=res+list1.get(i)+" "+list2.get(i)+ " ";
		}
		return res;
	}

}
