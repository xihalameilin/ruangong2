package vo;

import java.io.Serializable;

public class GoodsListVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 编号
	 */
	private int goodsnumber;
	/*
	 *名称
	 */
	private String goodsname;
	/*
	 * 型号
	 */
	private String type;
	/*
	 * 数量
	 */
	private int number;
	/*
	 * 价格
	 */
	private double price;
	/*
	 * 金额
	 */
	private double total;
	/*
	 * 备注
	 */
	private String comment;
	
	
	public int getGoodsnumber() {
		return goodsnumber;
	}
	public void setGoodsnumber(int goodsnumber) {
		this.goodsnumber = goodsnumber;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
