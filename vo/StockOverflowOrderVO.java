package vo;

import java.io.Serializable;

public class StockOverflowOrderVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * �Ƿ�����
	 */
	private int ischeck;
	/*
	 * ���2
	 */
	private String ordernumber2;
	/*
	 * ���
	 */
	private int ordernumber;
	/*
	 * ����
	 */
	private String date;
	/*
	 * ��Ʒ����
	 */
	private String name;
	/*
	 * ��Ʒ�������
	 */
	private int stocknumber;
	/*
	 * ʵ����Ʒ����
	 */
	private int actualnumber;
	
	
	public String getOrdernumber2() {
		return ordernumber2;
	}
	public void setOrdernumber2(String ordernumber2) {
		this.ordernumber2 = ordernumber2;
	}
	public int getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(int ordernumber) {
		this.ordernumber = ordernumber;
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
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStocknumber() {
		return stocknumber;
	}
	public void setStocknumber(int stocknumber) {
		this.stocknumber = stocknumber;
	}
	public int getActualnumber() {
		return actualnumber;
	}
	public void setActualnumber(int actualnumber) {
		this.actualnumber = actualnumber;
	}
	

}
