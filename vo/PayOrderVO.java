package vo;

import java.io.Serializable;
import java.util.List;
/*
 * 现金费用单
 */
public class PayOrderVO implements Serializable{
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
	 * 银行账户
	 */
	private String bankaccountname;
	/*
	 * 操作员
	 */
	private String operator;
	/*
	 * 总额
	 */
	private double total;
	/*
	 * 条目清单
	 */
	private List<TiaoMuVO> list;
	
	
	public PayOrderVO(){}
	
	public void setDate(String date) {
		this.date = date;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getBankaccountname() {
		return bankaccountname;
	}

	public void setBankaccountname(String bankaccountname) {
		this.bankaccountname = bankaccountname;
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


	public String getOperator() {
		return operator;
	}

	public double getTotal() {
		return total;
	}
	public List<TiaoMuVO> getList() {
		return list;
	}
	public void setList(List<TiaoMuVO> list) {
		this.list = list;
	}

	


}
