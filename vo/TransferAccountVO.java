package vo;

import java.io.Serializable;

public class TransferAccountVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * �����˻�
	 */
	private String bankaccount;
	/*
	 * ת�˽��
	 */
	private double money;
	/*
	 * ��ע
	 */
	private String comment;
	
	public String getBankaccount() {
		return bankaccount;
	}
	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
