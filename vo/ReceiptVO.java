package vo;

import java.io.Serializable;
import java.util.List;

public class ReceiptVO implements Serializable{
	
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
	 * ��Ӧ��
	 */
	private String provider;
	/*
	 * ������
	 */
	private String salesperson;
	/*
	 * ����Ա
	 */
	private String operator;
	/*
	 * �ܶ����
	 */
	private double total;
	/*
	 * ת���б�
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
