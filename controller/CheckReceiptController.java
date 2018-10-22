package controller;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import rmi.RemoteHelper;
import utility.DatetoString;
import utility.ResultMessage;
import vo.LogVO;
import vo.NoticeVO;
import vo.PayOrderVO;
import vo.ReceiptBackVO;
import vo.ReceiptVO;

public class CheckReceiptController {
	private String operator;

	public CheckReceiptController(String operator) {
		super();
		this.operator = operator;
	}
	/*
	 * 查询未审批的收款单
	 */
	public List<ReceiptVO> queryReceipt(){
		List<ReceiptVO> list=null;
		try {
			list=RemoteHelper.getInstance().getReceiptblservice().queryReceipt();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}
	/*
	 * 查询未审批的单
	 */
	public List<ReceiptBackVO> queryReceiptBack(){
		List<ReceiptBackVO> list=null;
		try {
			list=RemoteHelper.getInstance().getReceiptblservice().queryReceiptBack();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	/*
	 * 审批收款单之后的更新(改银行账户?)
	 */
	public void update(ReceiptVO r,boolean ispass){
		if(ispass==true){
			String name="";
			if(r.getProvider()==null)
				name=r.getSalesperson();
			else
				name=r.getProvider();
			try {
				RemoteHelper.getInstance().getCustomerblservice().changepayment(name, r.getTotal());
				for(int i=0;i<r.getList().size();i++)
					RemoteHelper.getInstance().getBankAccountblservice().updateAccount(r.getList().get(i).getBankaccount(),r.getList().get(i).getMoney() );
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			try {
				RemoteHelper.getInstance().getReceiptblservice().updateReceiptState(r.getNumber(), 1);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			NoticeVO notice=new NoticeVO();
			notice.setPerson("财务人员");
			notice.setIsnotice(false);
			notice.setMessage("收款单编号："+r.getNumber()+"审批通过，请修改相应银行账户");
			try {
				RemoteHelper.getInstance().getNoticeblservice().addNotice(notice);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			try {
				RemoteHelper.getInstance().getReceiptblservice().updateReceiptState(r.getNumber(), 3);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	/*
	 * 审批付款单之后的更新(改银行账户?)
	 */
	public void update(ReceiptBackVO p,boolean ispass){
		if(ispass=true){
			String name="";
			if(p.getProvider()==null)
				name=p.getSalesperson();
			else
				name=p.getProvider();
			try {
				RemoteHelper.getInstance().getCustomerblservice().changeincome(name, p.getTotal());
				for(int i=0;i<p.getList().size();i++)
					RemoteHelper.getInstance().getBankAccountblservice().updateAccount(p.getList().get(i).getBankaccount(),p.getList().get(i).getMoney() );
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				RemoteHelper.getInstance().getReceiptblservice().updateReceiptBackState(p.getNumber(), 1);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			NoticeVO notice=new NoticeVO();
			notice.setPerson("财务人员");
			notice.setIsnotice(false);
			notice.setMessage("付款单编号："+p.getNumber()+"审批通过，请修改相应银行账户");
		} else
			try {
				RemoteHelper.getInstance().getReceiptblservice().updateReceiptBackState(p.getNumber(), 3);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	/*
	 * 根据单据编号查询收款单
	 */
	public ReceiptVO queryReceiptByNumber(String number){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().queryReceiptByNumber(number);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 根据单据编号查询付款单
	 */
	public ReceiptBackVO queryReceiptBackByNumber(String number){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().queryReceiptBackByNumber(number);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 更新收款单状态
	 */
	public ResultMessage updateReceiptState(String number,int state){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().updateReceiptState(number, state);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 更新付款单状态
	 */
	public ResultMessage updateReceiptBackState(String number,int state){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().updateReceiptBackState(number, state);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 根据单据编号查询现金费用单
	 */
	public PayOrderVO queryPayOrderByNumber(String number){
		try {
			return RemoteHelper.getInstance().getReceiptblservice().queryPayOrderByNumber(number);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 新增操作日志
	 */
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