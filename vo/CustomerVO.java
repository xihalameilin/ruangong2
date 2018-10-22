package vo;

import java.io.Serializable;

public class CustomerVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 编号
	 */
	String number;
	/*
	 * 分类
	 */
	int classfication;
	/*
	 * 级别
	 */
	int level;
	/*
	 * 名称
	 */
	String name;
	/*
	 * 电话
	 */
	String telephone;
	/*
	 * 地址
	 */
	String address;
	 /*
	  * 邮编
	  */
	String postcode;
	/*
	 * 电子邮箱
	 */
	String email;
	/*
	 * 应收额度
	 */
	double maxincome;
	/*
	 * 应收
	 */
	double income;
	/*
	 * 应付
	 */
	double payment;
	/*
	 * 默认业务员
	 */
	String defaultname;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getClassfication() {
		return classfication;
	}
	public void setClassfication(int classfication) {
		this.classfication = classfication;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getMaxincome() {
		return maxincome;
	}
	public void setMaxincome(double maxincome) {
		this.maxincome = maxincome;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public String getDefaultname() {
		return defaultname;
	}
	public void setDefaultname(String defaultname) {
		this.defaultname = defaultname;
	}
	
	

}
