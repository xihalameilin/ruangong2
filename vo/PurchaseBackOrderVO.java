package vo;

import java.io.Serializable;
import java.util.List;

public class PurchaseBackOrderVO implements Serializable{
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
	 * �ֿ�
	 */
	private String warehouse;
	/*
	 * ����Ա
	 */
	private String operator;
	/*
	 * ��ע
	 */
	private String comment;
	/*
	 * �ܶ�ϼ�
	 */
	private double total;
	/*
	 * ��Ʒ�б�
	 */
	private List<GoodsListVO> list;
	
	public PurchaseBackOrderVO(){}
	
	
	public void setDate(String date) {
		this.date = date;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	public String getWarehouse() {
		return warehouse;
	}
	public String getOperator() {
		return operator;
	}
	public String getComment() {
		return comment;
	}
	public double getTotal() {
		return total;
	}

	public List<GoodsListVO> getList() {
		return list;
	}

	public void setList(List<GoodsListVO> list) {
		this.list = list;
	}
	
	

}
