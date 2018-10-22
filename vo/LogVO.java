package vo;

import java.io.Serializable;

public class LogVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 谁
	 */
	private String name;
	/*
	 * 什么时候
	 */
	private String date;
	/*
	 * 干了什么
	 */
	private String operation;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	

}
