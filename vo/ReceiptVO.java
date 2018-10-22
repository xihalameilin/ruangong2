package vo;

import java.io.Serializable;
import java.util.List;

public class ReceiptVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 是否审批
	 */
	private int ischeck;
	/*
	 * 日期
	 */
	private String date;
	/*
	 * 编号
	 */
	private String number;
	/*
	 * 供应商
	 */
	private String provider;
	/*
	 * 销售商
	 */
	private String salesperson;
	/*
	 * 操作员
	 */
	private String operator;
	/*
	 * 总额汇总
	 */
	private double total;
	/*
	 * 转账列表
	 */
	private List<TransferAccountVO> list;
	
	
	
	public void setList(List<TransferAccountVO> list) {
		this.list = list;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public void setSalesperson(String salesperson) {
		this.salesperson = salesperson;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	public int getIscheck() {
		return ischeck;
	}

	public void setIscheck(int ischeck) {
		this.ischeck = ischeck;
	}

	public String getDate() {
		return date;
	}
	public String getNumber() {
		return number;
	}
	public String getProvider() {
		return provider;
	}
	public String getSalesperson() {
		return salesperson;
	}
	public String getOperator() {
		return operator;
	}
	public double getTotal() {
		return total;
	}
	public List<TransferAccountVO> getList() {
		return list;
	}
	

	
	

}
