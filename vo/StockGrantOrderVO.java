package vo;

import java.io.Serializable;
import java.util.List;

public class StockGrantOrderVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * ���2
	 */
	private String ordernumber2;

	/*
	 * �Ƿ�����
	 */
    private int ischeck;
	/*
	 * ���
	 */
    private int ordernumber;
	/*
	 * ����
	 */
	private String date;
	/*
	 * ��Ʒ�б�
	 */
	private List<GoodsListVO> list;
	
	
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
	public List<GoodsListVO> getList() {
		return list;
	}
	public void setList(List<GoodsListVO> list) {
		this.list = list;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getIscheck() {
		return ischeck;
	}
	public void setIscheck(int ischeck) {
		this.ischeck = ischeck;
	}
	
	
	

}
