package vo;

import java.io.Serializable;

public class BankAccountVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Ãû³Æ
	 */
	private String name;
	/*
	 * ½ð¶î
	 */
	private double money;
	public BankAccountVO(){}
	
	public BankAccountVO(String name, double money) {
		super();
		this.name = name;
		this.money = money;
	}
	public void setMoney(double money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMoney() {
		return money;
	}
	
	

}
