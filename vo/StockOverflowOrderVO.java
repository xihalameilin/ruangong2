package vo;

import java.io.Serializable;

public class StockOverflowOrderVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 是否审批
	 */
	private int ischeck;
	/*
	 * 编号2
	 */
	private String ordernumber2;
	/*
	 * 编号
	 */
	private int ordernumber;
	/*
	 * 日期
	 */
	private String date;
	/*
	 * 商品名称
	 */
	private String name;
	/*
	 * 商品库存数量
	 */
	private int stocknumber;
	/*
	 * 实际商品数量
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
