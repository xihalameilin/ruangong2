package vo;

import java.io 

 

.Serializable;

public class StockChangeVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * ����
	 */
	private String date;
	/*
	 * ��Ʒ����
	 */
	private String name;
	/*
	 * ��Ʒ���
	 */
	private int goodsnumber;
	/*
	 * �������
	 */
	private int stockinnum;
	/*
	 * �����
	 */
	private double stockinprice;
	/*
	 * ��������
	 */
	private int stockoutnum;
	/*
	 * ������
	 */
	private double stockoutprice;
	/*
	 * ��������
	 */
	private int salesnum;
	/*
	 * ���۽��
	 */
	private double salesprice;
	/*
	 * ��������
	 */
	private int purchasenum;
	/*
	 * �������
	 */
	private double purchasepirce;
	
	
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
		this.name 

 

 = name;
	}
	public int getGoodsnumber() {
		return goodsnumber;
	}
	public void setGoodsnumber(int goodsnumber) {
		this.goodsnumber = goodsnumber;
	}
	public int getStockinnum() {
		return stockinnum;
	}
	public void setStockinnum(int stockinnum) {
		this.stockinnum = stockinnum;
	}
	public double getStockinprice() {
		return stockinprice;
	}
	public void setStockinprice(double stockinprice) {
		this.stockinprice = stockinprice;
	}
	public int getStockoutnum() {
		return stockoutnum;
	}
	public void setStockoutnum(int stockoutnum) {
		this.stockoutnum = stockoutnum;
	}
	public double getStockoutprice() {
		return stockoutprice;
	}
	public void setStockoutprice(double stockoutprice) {
		this.stockoutprice = stockoutprice;
	}
	public int getSalesnum() {
		return salesnum;
	}
	public void setSalesnum(int salesnum) {
		this.salesnum = salesnum;
	}
	public double getSalesprice() {
		return salesprice;
	}
	public void setSalesprice(double salesprice) {
		this.salesprice = salesprice;
	}
	public int getPurchasenum() {
		return purchasenum;
	}
	public void setPurchasenum(int purchasenum) {
		this.purchasenum = purchasenum;
	}
	public double getPurchasepirce() {
		return purchasepirce;
	}
	public void setPurchasepirce(double purchasepirce) {
		this.purchasepirce = purchasepirce;
	}
    

}
