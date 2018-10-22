package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rmi.RemoteHelper;
import utility.DatetoString;
import utility.ResultMessage;
import vo.LogVO;
import vo.SalesOrderVO;

/*
 * 查看销售明细表
 */
public class SalesDetailController {
	private String operator;
	public SalesDetailController (String operator){
		this.operator=operator;
	}
	/*
	 * 查看销售明细表
	 */
	public List<SalesOrderVO>  SalesDetail(String begin,String end,String goodsname,String customer){
		List<SalesOrderVO> list=null;
		try {
			list= RemoteHelper.getInstance().getQueryblservice().AccountForSales(begin, end);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<SalesOrderVO> list1=new ArrayList<SalesOrderVO>();
		for(int i=0;i<list.size();i++){			
			if(!customer.equals("")){							
				if(list.get(i).getSalesperson().equals(customer)){
							list1.add(list.get(i));			
				}
			}
			else if(customer.equals("")){
						list1.add(list.get(i));
				
			}					
		}
		return list1;
		
	}
	
	/*
	 * 导出EXCEL销售明细表
	 */
	public ResultMessage exportSales(List<SalesOrderVO> a,String path){
		try {
			return RemoteHelper.getInstance().getQueryblservice().exportSalesExcel(a,path);
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
