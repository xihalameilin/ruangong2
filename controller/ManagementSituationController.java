package controller;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import rmi.RemoteHelper;
import utility.DatetoString;
import utility.ResultMessage;
import vo.LogVO;

/*
 * 查看经营情况表
 */
public class ManagementSituationController {
	private String operator;
	public ManagementSituationController(String operator){
		this.operator=operator;
	}
	/*
	 * 查看经营情况表
	 */
	public List<Double> Situation(String begin,String end){
		try {
			return RemoteHelper.getInstance().getQueryblservice().queryManagementSituation(begin, end);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 导出经营情况表EXCEL
	 */
	public ResultMessage exportSituation(List<Double> a,String path){
		try {
			return RemoteHelper.getInstance().getQueryblservice().exportSitutationExcel(a,path);
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
