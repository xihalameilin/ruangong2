package vo;

import java.io 

 

.Serializable;
import java.util.List;

public class StockAlarmOrderVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 是否审批
	 */
	private int ischeck;
	/*
	 * 单据编号
	 */
	private int ordernumber;
	
	/*
	 * 单据编号
	 */
	private String ordernumber2;

	/*
     * 日期
     */
	private String date;
	/*
	 * 
	 */
	private List<GoodsListVO> list;
    
    
    

	public int getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(int ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getOrdernumber2() {
		return ordernumber2;
	}

	public void setOrdernumber2(String ordernumber2) {
		this.ordernumber2 = ordernumber2;
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

	public List<GoodsListVO> getList() {
		return list;
	}

	public void setList(List<GoodsListVO> list) {
		this.list = list;
	}
	
	
}
