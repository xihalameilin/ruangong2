package vo;

import java.io.Serializable;
import java.util.List;

public class SalesOrderVO implements Serializable{
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
	 * ������
	 */
	private String salesperson;
	/*
	 * ҵ��Ա 
	 */
	private String defaultname;
	/*
	 * ����Ա
	 */
	private String operator;
	/*
	 * �ֿ�
	 */
	private String warehouse;
	/*
	 * ����ǰ�ܶ�
	 */
	private double total;
	/*
	 * ����
	 */
	private double discount;
	/*
	 * ����ȯ
	 */
	private double voucher;
	/*
	 * ���ú��ܶ�
	 */
	private double lasttotal;
	/*
	 * ������Ʒ�б�
	 */
	private List<GoodsListVO> list;
	/*
	 * ��ע
	 */
	private String comment;
	
	
	
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setSalesperson(String salesperson) {
		this.salesperson = salesperson;
	}
	public void setDefaultname(String defaultname) {
		this.defaultname = defaultname;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}
	public void setLasttotal(double lasttotal) {
		this.lasttotal = lasttotal;
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
	public String getSalesperson() {
		return salesperson;
	}
	public String getDefaultname() {
		return defaultname;
	}
	public String getOperator() {
		return operator;
	}
	public String getWarehouse() {
		return warehouse;
	}
	public double getTotal() {
		return total;
	}
	public double getDiscount() {
		return discount;
	}
	public double getVoucher() {
		return voucher;
	}
	public double getLasttotal() {
		return lasttotal;
	}
	public List<GoodsListVO> getList() {
		return list;
	}
	public void setList(List<GoodsListVO> list) {
		this.list = list;
	}
	
	

}
