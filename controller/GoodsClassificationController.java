package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rmi.RemoteHelper;
import utility.DatetoString;
import utility.ResultMessage;
import vo.GoodsVO;
import vo.LogVO;

public class GoodsClassificationController {
	private String operator;
	public GoodsClassificationController(String operator){
		this.operator=operator;
	}
	/*
	 * 计算分类编号
	 */
	public int getclassificationnumber(){
		return 0;
	}
	/*
	 * 得到父分类下所有子分类
	 */
	public List<String> getson(String father){
		List<String> list=null;
		try {
			list=RemoteHelper.getInstance().getGoodsClassificationblservice().getson(father);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/*
	 * 分类下是否有商品
	 */
	public boolean hasGoods(String name){
		boolean flag = false;
		List<GoodsVO> list=new ArrayList<GoodsVO>();
		try {
			list=RemoteHelper.getInstance().getGoodsblservice().query();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<list.size();i++){
			if(list.get(i).getClassification().equals(name)){
				flag = true;
				break;
			}
		}
		return flag;
	}
	/*
	 * 更新分类
	 */
	public ResultMessage updateClassification(String oldname,String newname){
		ResultMessage res=null;
		try {
			res=RemoteHelper.getInstance().getGoodsClassificationblservice().updateClassification(oldname, newname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	/*
	 * 添加商品分类
	 */
	public ResultMessage addClassification(String parent_classification,String son_classificatioin){
		
		try {
			return RemoteHelper.getInstance().getGoodsClassificationblservice().addClassification(parent_classification, son_classificatioin);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 得到所有的子节点
	 */
	public List<String> getAllSonClassifiaction(){
		try {
			return RemoteHelper.getInstance().getGoodsClassificationblservice().getAllSonClassification();
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
