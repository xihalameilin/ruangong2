package vo;

import java.io 

 

.Serializable;

public class StockChangeVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 日期
	 */
	private String date;
	/*
	 * 商品名称
	 */
	private String name;
	/*
	 * 商品编号
	 */
	private int goodsnumber;
	/*
	 * 入库数量
	 */
	private int stockinnum;
	/*
	 * 入库金额
	 */
	private double stockinprice;
	/*
	 * 出库数量
	 */
	private int stockoutnum;
	/*
	 * 出库金额
	 */
	private double stockoutprice;
	/*
	 * 销售数量
	 */
	private int salesnum;
	/*
	 * 销售金额
	 */
	private double salesprice;
	/*
	 * 进货数量
	 */
	private int purchasenum;
	/*
	 * 进货金额
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
