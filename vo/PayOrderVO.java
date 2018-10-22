package vo;

import java.io.Serializable;
import java.util.List;
/*
 * �ֽ���õ�
 */
public class PayOrderVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * �Ƿ�����
	 */
	private int ischeck;
	
	/*
	 * ����
	 */
	private String date;
	
	/*
	 * ���
	 */
	private String number;
	/*
	 * �����˻�
	 */
	private String bankaccountname;
	/*
	 * ����Ա
	 */
	private String operator;
	/*
	 * �ܶ�
	 */
	private double total;
	/*
	 * ��Ŀ�嵥
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
